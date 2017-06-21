package com.taikang.dic.ltci.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.taikang.dic.ltci.api.model.OrgSettlementDTO;
import com.taikang.dic.ltci.api.model.PageResultDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.ConstantUtil;
import com.taikang.dic.ltci.common.exception.ParametersException;
import com.taikang.dic.ltci.service.IOrgSettlementService;

/** 机构月结控制器 */
@RestController
@RequestMapping(path = "${restBasePath}", produces = "application/json;charset=utf-8")
public class OrgSettlementController {

  private Logger logger = LoggerFactory.getLogger(OrgSettlementController.class);
  @Autowired private IOrgSettlementService orgSettlementService;
  /**
   * 统计查询机构月结信息
   *
   * @param orgSettlementDTO
   * @return
   */
  @RequestMapping(value = "/orgSettlement/countData", method = RequestMethod.POST)
  public PageResultDTO countOrgData(
      @RequestBody OrgSettlementDTO orgSettlementDTO,
      @RequestParam(defaultValue = "1") Integer page,
      @RequestParam(defaultValue = "10") Integer pageSize) {
    logger.info("====Controller层：countOrgData方法========");
    logger.debug("查询条件:" + orgSettlementDTO);
    PageResultDTO result = orgSettlementService.countOrgData(orgSettlementDTO, page, pageSize);
    result.setStatus(HttpStatus.OK.value());
    return result;
  }
  /**
   * 审核保存机构月结信息
   *
   * @param id
   * @param feeStarttime
   * @param feeEndtime
   * @return
   */
  @RequestMapping(value = "/orgSettlement/save", method = RequestMethod.POST)
  public ResultDTO saveOrgData(@RequestBody OrgSettlementDTO orgSettlementDTO) {
    logger.info("====Controller层：saveOrgData方法========");
    logger.info("参数: " + orgSettlementDTO);
    ResultDTO resultDTO = new ResultDTO();
    try {
      orgSettlementService.saveOrgData(orgSettlementDTO);
      resultDTO.setStatus(HttpStatus.OK.value());
      resultDTO.setMessage(ConstantUtil.OPERATION_SUCCESS);
    } catch (Exception e) {
      resultDTO.setStatus(HttpStatus.EXPECTATION_FAILED.value());
      resultDTO.setMessage(ConstantUtil.OPERATION_FAILED);
      logger.error("save org settlement data error!", e);
    }
    return resultDTO;
  }

  /**
   * 机构月结表查询 包括费用复核查询,费用支付查询
   *
   * @return
   */
  @RequestMapping(value = "/orgSets/list", method = RequestMethod.POST)
  public PageResultDTO listMonSetOrgForCheckReview(
      String orgName,
      String orgCode,
      String auditState,
      String startDate,
      String endDate,
      Integer page,
      Integer pageSize) {
    logger.info("====Controller层：listMonSetOrgForCheckReview方法========");
    if (page == null) {
      page = 1;
    }
    if (pageSize == null) {
      pageSize = 10;
    }
    //将用逗号隔开的审核状态切割,并转成integer类型
    List<Integer> auditStateFlags = new ArrayList<Integer>();
    if (StringUtils.isNotBlank(auditState)) {
      String[] split = auditState.split(",");
      for (String ele : split) {
        Integer tempEle = null;
        try {
          tempEle = Integer.valueOf(ele);
        } catch (NumberFormatException e) {
          logger.error("====controller层出现异常", e);
          throw new ParametersException("审核状态码必须为数字", e);
        }
        auditStateFlags.add(tempEle);
      }
    }

    return orgSettlementService.listMonSetOrg(
        orgName, orgCode, auditStateFlags, startDate, endDate, page, pageSize);
  }

  /**
   * @param id
   * @return
   */
  @RequestMapping(value = "/orgSettlement/{id}", method = RequestMethod.GET)
  public ResultDTO selectMonSetOrgById(@PathVariable("id") String id) {
    logger.info("====Controller层：selectMonSetOrgById方法========");
    ResultDTO result = new ResultDTO();
    OrgSettlementDTO orgSet = orgSettlementService.selectById(id);
    result.setDatas(orgSet);
    return result;
  }
  /**
   * 更新机构月结审核状态信息,费用复核和费用支付时使用
   *
   * @param orgSet
   * @return
   */
  @RequestMapping(value = "/orgSettlement/auditState", method = RequestMethod.PUT)
  public ResultDTO updateAuditState(@RequestBody OrgSettlementDTO orgSet) {
    logger.info("====Controller层：updateAuditState方法========");
    return orgSettlementService.updateAuditState(orgSet);
  }

  /**
   * 机构月结费用结算操作
   *
   * @param orgSet
   * @return
   */
  @RequestMapping(value = "/orgSettlement/settle", method = RequestMethod.PUT)
  public ResultDTO settleForOrg(@RequestBody OrgSettlementDTO orgSet) {
    ResultDTO result = new ResultDTO();
    //如果传递的对象为空或ID为空,直接返回提示信息
    if (orgSet == null || StringUtils.isBlank(orgSet.getId())) {
      result.setStatus(407);
      result.setMessage("必须指定有效的id");
      return result;
    }
    result = orgSettlementService.settleForOrg(orgSet);
    return result;
  }
}
