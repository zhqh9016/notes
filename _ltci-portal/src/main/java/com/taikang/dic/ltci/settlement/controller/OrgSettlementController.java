package com.taikang.dic.ltci.settlement.controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.portal.api.model.OrgSettlementDTO;
import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.settlement.service.IOrgSettlementService;
import com.taikang.dic.ltci.system.common.ConstantUtil;

@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class OrgSettlementController {

  private Logger logger = LoggerFactory.getLogger(OrgSettlementController.class);

  @Autowired IOrgSettlementService orgSettlementService;

  /**
   * 统计查询机构月结信息
   *
   * @param orgSettlementDTO
   * @return
   */
  @RequestMapping(value = "/orgSettlement/countData", method = RequestMethod.POST)
  public PageResultDTO countOrgData(
      OrgSettlementDTO orgSettlementDTO, Integer page, Integer pageSize) {
    logger.info("====Controller层：countOrgData方法========");
    logger.info("查询条件:" + orgSettlementDTO);
    PageResultDTO resultDTO = orgSettlementService.countOrgData(orgSettlementDTO, page, pageSize);
    return resultDTO;
  }
  /**
   * 保存审核通过的机构月结信息
   *
   * @param id
   * @param feeStarttime
   * @param feeEndtime
   * @return
   */
  @RequestMapping(value = "/orgSettlement/save", method = RequestMethod.POST)
  public ResultDTO saveOrgData(OrgSettlementDTO orgSettlementDTO) {
    logger.info("====Controller层：saveOrgData方法========");
    logger.debug("参数: " + orgSettlementDTO);
    ResultDTO resultDTO = orgSettlementService.saveOrgData(orgSettlementDTO);
    return resultDTO;
  }

  /**
   * 费用复核列表查询,如果没传auditState,那么默认为已审核
   *
   * @param orgName
   * @param orgCode
   * @param auditState
   * @param startDate
   * @param endDate
   * @param page
   * @param pageSize
   * @return
   */
  @RequestMapping(value = "/orgSettlement/check/list", method = RequestMethod.POST)
  public PageResultDTO listMonSetOrg(
      String orgName,
      String orgCode,
      String auditState,
      String startDate,
      String endDate,
      Integer page,
      Integer pageSize) {
    if (StringUtils.isBlank(auditState)) {
      auditState = "" + ConstantUtil.ALREADY_AUDIT;
    }
    logger.info("====Controller层：listMonSetOrg方法========");
    PageResultDTO result =
        orgSettlementService.listMonSetOrgForCheckReview(
            orgName, orgCode, auditState, startDate, endDate, page, pageSize);
    result.setStatus(200);
    return result;
  }

  /**
   * 费用支付结算接口,如果没传auditState,默认为复核通过,已结算,已支付
   *
   * @param orgName
   * @param orgCode
   * @param auditState
   * @param startDate
   * @param endDate
   * @param page
   * @param pageSize
   * @return
   */
  @RequestMapping(value = "/orgSettlement/pay/list", method = RequestMethod.POST)
  public PageResultDTO listMonSetOrgForPayment(
      String orgName,
      String orgCode,
      String auditState,
      String startDate,
      String endDate,
      Integer page,
      Integer pageSize) {
    if (StringUtils.isBlank(auditState)) {
      auditState =
          ""
              + ConstantUtil.RECHECK_PASS
              + ","
              + ConstantUtil.ALREADY_SETTLED
              + ","
              + ConstantUtil.ALREADY_PAY;
    }
    logger.info("====Controller层：listMonSetOrgForPayment方法========");
    PageResultDTO result =
        orgSettlementService.listMonSetOrgForCheckReview(
            orgName, orgCode, auditState, startDate, endDate, page, pageSize);
    result.setStatus(200);
    return result;
  }

  /**
   * 费用支付操作 费用支付时,先判断当前机构是否处于已结算状态,如果不是,返回提示信息 如果是已结算状态,那么更新机构月结,个人日结,个人服务明细审核状态为已支付
   *
   * @return
   */
  @RequestMapping(value = "/orgSettlement/pay/{id}", method = RequestMethod.PUT)
  public ResultDTO updateAuditStateForPayment(@PathVariable("id") String id, String createdOrg) {
    logger.info("====Controller层：updateAuditStateForPayment方法========");
    ResultDTO result = new ResultDTO();
    //先根据ID查询机构月结信息
    ResultDTO selectById = orgSettlementService.selectById(id);
    Object datas = selectById.getDatas();
    //判断是否有经办机构
    if (StringUtils.isBlank(createdOrg)) {
      result.setStatus(407);
      result.setMessage("操作的机构月结记录没有经办机构,请联系管理员");
      return result;
    }
    //判断被操作的记录是不是存在
    if (datas == null) {
      result.setStatus(407);
      result.setMessage(ConstantUtil.RESOURCE_NOT_FOUNT);
      return result;
    }
    OrgSettlementDTO orgSet =
        JSONObject.parseObject(JSONObject.toJSONString(datas), OrgSettlementDTO.class);
    Integer auditState = orgSet.getAuditState();
    //判断操作的记录是不是处于已结算状态
    if (!ConstantUtil.ALREADY_SETTLED.equals(auditState)) {
      result.setStatus(407);
      result.setMessage("必须先结算再支付");
      return result;
    }
    //执行审核状态更新操作
    orgSet.setAuditState(ConstantUtil.ALREADY_PAY);

    //设置机构月结记录所属经办机构
    orgSet.setCreatedOrg(createdOrg);
    result = orgSettlementService.updateAuditState(orgSet);
    if (result.getStatus() != null && 407 != result.getStatus()) {
      result.setStatus(200);
      result.setMessage(ConstantUtil.OPERATED_SUCESS);
    }
    return result;
  }
  /**
   * 机构月结费用复核接口
   *
   * @param id
   * @param auditState
   * @param rejectReason
   * @return
   */
  @RequestMapping(value = "/orgSettlement/check/{id}", method = RequestMethod.PUT)
  public ResultDTO updateAuditStateForCheck(
      @PathVariable("id") String id, Integer auditState, String rejectReason, String createdOrg) {
    logger.info("====Controller层：updateAuditStateForCheck方法========");
    ResultDTO result = new ResultDTO();
    //如果复核时传递的是其他审核状态直接响应给前台提示信息
    if (auditState == null
        || (!auditState.equals(ConstantUtil.RECHECK_PASS)
            && !auditState.equals(ConstantUtil.RECHECK_NOT_PASS))) {
      result.setStatus(407);
      result.setMessage("请指定有效的复核状态,3或4");
      return result;
    }

    //判断是否有经办机构
    if (StringUtils.isBlank(createdOrg)) {
      result.setStatus(407);
      result.setMessage("操作的机构月结记录没有经办机构,请联系管理员");
      return result;
    }

    //先根据ID查询机构月结信息
    ResultDTO selectById = orgSettlementService.selectById(id);
    Object datas = selectById.getDatas();
    //判断被操作的记录是不是存在
    if (datas == null) {
      result.setStatus(407);
      result.setMessage(ConstantUtil.RESOURCE_NOT_FOUNT);
      return result;
    }
    OrgSettlementDTO orgSet =
        JSONObject.parseObject(JSONObject.toJSONString(datas), OrgSettlementDTO.class);
    Integer auditStateTemp = orgSet.getAuditState();
    //判断操作的记录是不是处于已审核状态
    if (!ConstantUtil.ALREADY_AUDIT.equals(auditStateTemp)) {
      result.setStatus(407);
      result.setMessage("必须审核通过才能复核");
      return result;
    }
    //设置机构月结记录所属经办机构
    orgSet.setCreatedOrg(createdOrg);
    //执行审核状态更新操作
    orgSet.setAuditState(auditState);
    orgSet.setRejectReason(rejectReason);
    result = orgSettlementService.updateAuditState(orgSet);
    if (result.getStatus() != null && 407 != result.getStatus()) {
      result.setStatus(200);
      result.setMessage(ConstantUtil.OPERATED_SUCESS);
    }
    return result;
  }
  /**
   * 机构费用结算
   *
   * @param id
   * @return
   */
  @RequestMapping(value = "/orgSettlement/settle/{id}", method = RequestMethod.PUT)
  public ResultDTO settlementForOrg(@PathVariable("id") String id, String createdOrg) {
    logger.info("====Controller层：settlementForOrg方法========");
    ResultDTO result = new ResultDTO();
    //判断是否有经办机构
    if (StringUtils.isBlank(createdOrg)) {
      result.setStatus(407);
      result.setMessage("操作的机构月结记录没有经办机构,请联系管理员");
      return result;
    }
    ResultDTO selectById = orgSettlementService.selectById(id);
    Object datas = selectById.getDatas();
    //判断被操作的记录是不是存在
    if (datas == null) {
      result.setStatus(407);
      result.setMessage(ConstantUtil.RESOURCE_NOT_FOUNT);
      return result;
    }
    OrgSettlementDTO orgSet =
        JSONObject.parseObject(JSONObject.toJSONString(datas), OrgSettlementDTO.class);
    Integer auditStateTemp = orgSet.getAuditState();
    //判断操作的记录是不是处于复核通过状态
    if (!ConstantUtil.RECHECK_PASS.equals(auditStateTemp)) {
      result.setStatus(407);
      result.setMessage("必须复核通过才能结算");
      return result;
    }

    //设置机构月结记录所属经办机构
    orgSet.setCreatedOrg(createdOrg);

    orgSet.setAuditState(ConstantUtil.ALREADY_SETTLED);
    result = orgSettlementService.settleForOrg(orgSet);
    if (result.getStatus() != null && 407 != result.getStatus()) {
      result.setStatus(200);
      result.setMessage(ConstantUtil.OPERATED_SUCESS);
    }
    return result;
  }

  /**
   * 机构月结结算打印
   *
   * @param id
   * @return
   */
  @RequestMapping(value = "/orgSettlement/{id}", method = RequestMethod.GET)
  public ResultDTO selectMonSetOrgById(@PathVariable("id") String id) {
    logger.info("====Controller层：selectMonSetOrgById方法========");
    ResultDTO result = new ResultDTO();
    if (StringUtils.isBlank(id)) {
      result.setStatus(407);
      result.setMessage("没有有效的ID");
      return result;
    }
    ResultDTO selectById = orgSettlementService.selectById(id);
    Object datas = selectById.getDatas();
    //判断被操作的记录是不是存在
    if (datas == null) {
      result.setStatus(407);
      result.setMessage(ConstantUtil.RESOURCE_NOT_FOUNT);
      return result;
    }
    OrgSettlementDTO orgSet =
        JSONObject.parseObject(JSONObject.toJSONString(datas), OrgSettlementDTO.class);
    Integer auditStateTemp = orgSet.getAuditState();
    //判断操作的记录是不是处于已结算或已支付状态
    if (!ConstantUtil.ALREADY_SETTLED.equals(auditStateTemp)
        && !ConstantUtil.ALREADY_PAY.equals(auditStateTemp)) {
      result.setStatus(407);
      result.setMessage("必须结算完成才能打印");
      return result;
    }
    selectById.setStatus(200);
    return selectById;
  }
}
