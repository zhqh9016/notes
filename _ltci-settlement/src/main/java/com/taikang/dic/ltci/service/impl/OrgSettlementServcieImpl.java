package com.taikang.dic.ltci.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.api.model.OrgSettlementDTO;
import com.taikang.dic.ltci.api.model.PageResultDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.ConstantUtil;
import com.taikang.dic.ltci.common.IsValidEnum;
import com.taikang.dic.ltci.common.log.LogBO;
import com.taikang.dic.ltci.common.log.ThreadLocalUtil;
import com.taikang.dic.ltci.common.util.DateFormatUtil;
import com.taikang.dic.ltci.common.util.NumberUtil;
import com.taikang.dic.ltci.common.util.UUIDUtil;
import com.taikang.dic.ltci.dao.FeeAuditLogDAO;
import com.taikang.dic.ltci.dao.IGenericDAO;
import com.taikang.dic.ltci.dao.MonSetPerDAO;
import com.taikang.dic.ltci.dao.OrgSettlementCustomDAO;
import com.taikang.dic.ltci.dao.OrgSettlementDAO;
import com.taikang.dic.ltci.model.FeeAuditLogDO;
import com.taikang.dic.ltci.model.MonSetPerDO;
import com.taikang.dic.ltci.model.MonSetPerDOExample;
import com.taikang.dic.ltci.model.OrgSettlementDO;
import com.taikang.dic.ltci.model.OrgSettlementDOExample;
import com.taikang.dic.ltci.model.OrgSettlementDOExample.Criteria;
import com.taikang.dic.ltci.service.AbstractGenericService;
import com.taikang.dic.ltci.service.IOrgSettlementService;
import com.taikang.dic.ltci.serviceClient.OrgnizationServerClient;

@Transactional
@Service
public class OrgSettlementServcieImpl extends AbstractGenericService<OrgSettlementDO, String>
    implements IOrgSettlementService {

  private Logger logger = LoggerFactory.getLogger(OrgSettlementServcieImpl.class);
  @Autowired private OrgSettlementDAO orgSettlementDAO;
  @Autowired private OrgSettlementCustomDAO settlementCustomDAO;
  @Autowired private MonSetPerDAO monSetPerDAO;
  @Autowired private FeeAuditLogDAO feeAuditLogDAO;
  @Autowired private OrgnizationServerClient orgnizationServerClient;

  @Value("${rate.warranty}")
  private Double warrantyRate; //保证金比例

  @Override
  public IGenericDAO<OrgSettlementDO, String> getDao() {
    return orgSettlementDAO;
  }

  /** 根据个人结算表ltci_mon_set_per统计一个时间段内每个机构的费用总和 */
  @Override
  public PageResultDTO countOrgData(OrgSettlementDTO dto, Integer page, Integer pageSize) {
    PageResultDTO result = new PageResultDTO();
    logger.info("进入 OrgSettlementServcieImpl countOrgData方法 !");
    OrgSettlementDO orgSettlementDO = new OrgSettlementDO();

    //设置查询条件，实时统计
    if (StringUtils.isNotBlank(dto.getOrgCode())) {
      orgSettlementDO.setOrgCode(dto.getOrgCode());
    }
    if (StringUtils.isNotBlank(dto.getOrgName())) {
      orgSettlementDO.setOrgName("%" + dto.getOrgName() + "%");
    }
    //如果开始日期不为空
    if (StringUtils.isNotBlank(dto.getFeeStarttime())) {
      orgSettlementDO.setFeeStarttime(DateFormatUtil.getMonthFirstDay(dto.getFeeStarttime()));
    }
    //如果终止日期不为空
    if (StringUtils.isNotBlank(dto.getFeeEndtime())) {
      orgSettlementDO.setFeeEndtime(DateFormatUtil.getMonthLastDay(dto.getFeeEndtime()));
    } else {
      //如果为空，设置为上月最后一天
      orgSettlementDO.setFeeEndtime(
          DateFormatUtil.getMonthLastDay(DateFormatUtil.getBeforeMonth()));
    }
    LogBO logBO = ThreadLocalUtil.threadLocal.get();
    if (logBO != null && StringUtils.isNotBlank(logBO.getOperatedOrg())) {
      orgSettlementDO.setCreatedOrg(logBO.getOperatedOrg());
    }
    //在个人日结表中统计
    //如果状态是空 或者是  待处理
    if (dto.getAuditState() == ConstantUtil.WAITING_PROCESS) {
      orgSettlementDO.setAuditState(ConstantUtil.WAITING_PROCESS);
    }
    if (dto.getAuditState() == ConstantUtil.RECHECK_NOT_PASS) {
      orgSettlementDO.setAuditState(ConstantUtil.RECHECK_NOT_PASS);
    }
    int count = settlementCustomDAO.count(orgSettlementDO);

    int pageIndex = (page - 1) * pageSize;
    int totalPage = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
    orgSettlementDO.setOrderBy(
        " ORDER BY set_date desc LIMIT " + pageIndex + " , " + pageSize + " ");
    //统计每个月的待处理数据
    List<OrgSettlementDTO> list = getDateFromMonPerSet(orgSettlementDO);
    logger.info("查询结束，返回" + list);
    result.setDatas(list);
    result.setPage(page);
    result.setPageSize(pageSize);
    result.setTotalDataNum(count);
    result.setTotalPageNum(totalPage);
    return result;
  }
  /**
   * @param result 结果list
   * @param orgSettlementDO 条件
   * @param monthFirstDay 开始时间
   * @param monthLastDay 终止时间
   */
  private List<OrgSettlementDTO> getDateFromMonPerSet(OrgSettlementDO orgSettlementDO) {
    List<OrgSettlementDTO> result = new ArrayList<>();
    logger.info("统计未处理的个人结算记录");
    List<OrgSettlementDO> settlementDataList =
        settlementCustomDAO.getSettlementData(orgSettlementDO);
    //转换成dto
    for (OrgSettlementDO orgSettlementDO2 : settlementDataList) {
      orgSettlementDO2.setFeeStarttime(
          DateFormatUtil.getMonthFirstDay(
              DateFormatUtil.dateToTimeStr(orgSettlementDO2.getFeeStarttime())));
      orgSettlementDO2.setFeeEndtime(
          DateFormatUtil.getMonthLastDay(
              DateFormatUtil.dateToTimeStr(orgSettlementDO2.getFeeStarttime())));
      //如果是复核不通过的记录，填充驳回原因
      if (StringUtils.isNotBlank(orgSettlementDO2.getOrgSetCode())) {
        OrgSettlementDOExample example = new OrgSettlementDOExample();
        Criteria criteria = example.createCriteria();
        criteria.andOrgSetCodeEqualTo(orgSettlementDO2.getOrgSetCode());
        List<OrgSettlementDO> list = orgSettlementDAO.selectByExample(example);
        orgSettlementDO2.setRejectReason(
            list != null && !list.isEmpty() ? list.get(0).getRejectReason() : null);
      }
      String jsonString =
          JSONObject.toJSONStringWithDateFormat(
              orgSettlementDO2, DateFormatUtil.DATE_FORMAT_YYYY_MM_DD_HH_MM_SS);
      OrgSettlementDTO rsDto = JSONObject.parseObject(jsonString, OrgSettlementDTO.class);
      //查询经办机构的 名称，前台需要展示
      if (StringUtils.isNotBlank(rsDto.getCreatedOrg())) {
        ResultDTO dto = orgnizationServerClient.getByCode(rsDto.getCreatedOrg());
        JSONObject obj = (JSONObject) dto.getDatas();
        rsDto.setCreatedOrgName(obj != null ? obj.getString("name") : "");
      }
      result.add(rsDto);
    }
    return result;
  }
  /** 保存审核通过的机构月结信息 */
  @Override
  @Transactional
  public int saveOrgData(OrgSettlementDTO dto) {
    //更新个人结算信息时的条件
    MonSetPerDO monSetPer = new MonSetPerDO();
    //添加日志时的DO
    FeeAuditLogDO feeAudit = new FeeAuditLogDO();

    logger.info("进入OrgSettlementServcieImpl  方法 saveOrgData!");
    OrgSettlementDTO resDto = new OrgSettlementDTO();

    OrgSettlementDO orgSettlementDO = new OrgSettlementDO();
    //设置经办机构---需要前台传值
    orgSettlementDO.setCreatedOrg(dto.getCreatedOrg()); //所属经办机构
    orgSettlementDO.setOrgCode(dto.getOrgCode()); //护理机构
    orgSettlementDO.setFeeStarttime(DateFormatUtil.getMonthFirstDay(dto.getFeeStarttime()));
    orgSettlementDO.setFeeEndtime(DateFormatUtil.getMonthLastDay(dto.getFeeEndtime()));
    orgSettlementDO.setOrderBy(" ORDER BY set_date desc");
    List<OrgSettlementDTO> list = getDateFromMonPerSet(orgSettlementDO);
    if (list.isEmpty()) {
      return 0;
    } else {
      resDto = list.get(0);
    }
    String jsonString =
        JSONObject.toJSONStringWithDateFormat(
            resDto, DateFormatUtil.DATE_FORMAT_YYYY_MM_DD_HH_MM_SS);
    OrgSettlementDO orgSetDO = JSONObject.parseObject(jsonString, OrgSettlementDO.class);
    int num;
    if (StringUtils.isNotBlank(resDto.getOrgSetCode())) {
      //月结唯一编号不为空，则是保存复核失败的记录
      orgSetDO.setOperatedTime(new Date());
      orgSetDO.setOperatedBy(dto.getOperatedBy());
      orgSetDO.setOperatedOrg(dto.getOperatedOrg());
      orgSetDO.setAuditState(ConstantUtil.ALREADY_AUDIT);

      logger.info("审核更新操作， 参数：" + orgSetDO);
      OrgSettlementDOExample example = new OrgSettlementDOExample();
      Criteria criteria = example.createCriteria();
      criteria.andOrgSetCodeEqualTo(resDto.getOrgSetCode());
      num = orgSettlementDAO.updateByExampleSelective(orgSetDO, example);
      //日志
      feeAudit.setOrgSetCode(resDto.getOrgSetCode());
    } else {
      //保存新统计的数据
      orgSetDO.setOperatedTime(new Date());
      orgSetDO.setCreatedTime(new Date());
      orgSetDO.setOperatedBy(dto.getOperatedBy());
      orgSetDO.setCreatedBy(dto.getOperatedBy());
      orgSetDO.setOperatedOrg(dto.getOperatedOrg());
      orgSetDO.setAuditState(ConstantUtil.ALREADY_AUDIT); //审核状态
      orgSetDO.setId(UUIDUtil.getUUID());
      String uuid = UUIDUtil.getUUID();
      orgSetDO.setOrgSetCode(uuid); //月结记录唯一编号
      orgSetDO.setIsValid(IsValidEnum.NO_DELETE.getValue()); //有效
      //保存时更新个人月结表的 费用月结唯一编码
      monSetPer.setMonSetCode(uuid);
      feeAudit.setOrgSetCode(uuid);
      logger.info("审核保存操作， 参数：" + orgSetDO);
      num = orgSettlementDAO.insertSelective(orgSetDO);
    }
    Date monthFirstDay = DateFormatUtil.getMonthFirstDay(dto.getFeeStarttime());
    Date monthLastDay = DateFormatUtil.getMonthLastDay(dto.getFeeEndtime());
    //更新个人日结信息审核状态为‘已审核’
    monSetPer.setAuditState(ConstantUtil.ALREADY_AUDIT);
    monSetPer.setOperatedBy(dto.getOperatedBy());
    monSetPer.setOperatedTime(new Date());
    monSetPer.setOperatedOrg(dto.getOperatedOrg());
    MonSetPerDOExample monSetPerExample = new MonSetPerDOExample();
    com.taikang.dic.ltci.model.MonSetPerDOExample.Criteria monPerCriteria =
        monSetPerExample.createCriteria();
    //根据机构 、时间段 更新 审核状态为“已审核”
    monPerCriteria.andOrgCodeEqualTo(dto.getOrgCode());
    monPerCriteria.andSetDateGreaterThanOrEqualTo(monthFirstDay);
    monPerCriteria.andSetDateLessThanOrEqualTo(monthLastDay);
    monPerCriteria.andCreatedOrgEqualTo(dto.getCreatedOrg()); //经办机构
    logger.info("审核更新个人日结表， 参数：" + monSetPer);
    monSetPerDAO.updateByExampleSelective(monSetPer, monSetPerExample);

    //添加审核日志信息
    feeAudit.setId(UUIDUtil.getUUID());
    feeAudit.setAuditType(ConstantUtil.ALREADY_AUDIT);
    feeAudit.setOperatedBy(dto.getOperatedBy());
    feeAudit.setOperatedOrg(dto.getOperatedOrg());
    feeAudit.setOperatedTime(new Date());
    logger.info("审核新增日志， 参数：" + feeAudit);
    feeAuditLogDAO.insertSelective(feeAudit);
    return num;
  }

  /** 提供四种查询条件:机构名称、机构编码、费用开始时间-费用结束时间、审核状态 */
  @Override
  public PageResultDTO listMonSetOrg(
      String orgName,
      String orgCode,
      List<Integer> auditStateFlags,
      String startDate,
      String endDate,
      Integer page,
      Integer pageSize) {
    PageResultDTO result = new PageResultDTO();
    //构建查询条件
    OrgSettlementDOExample example = new OrgSettlementDOExample();
    Criteria criteria = example.createCriteria();
    Criteria criteria2 = example.createCriteria();
    //设置四种查询条件:机构名称、机构编码、费用开始时间-费用结束时间、审核状态
    if (StringUtils.isNotBlank(orgName)) {
      criteria.andOrgNameLike("%" + orgName + "%");
      criteria2.andOrgNameLike("%" + orgName + "%");
    }

    if (StringUtils.isNotBlank(orgCode)) {
      criteria.andOrgCodeEqualTo(orgCode);
      criteria2.andOrgCodeEqualTo(orgCode);
    }

    if (StringUtils.isNotBlank(startDate)) {
      criteria.andFeeStarttimeGreaterThanOrEqualTo(DateFormatUtil.getMonthFirstDay(startDate));
      criteria2.andFeeStarttimeGreaterThanOrEqualTo(DateFormatUtil.getMonthFirstDay(startDate));
    }
    if (StringUtils.isNotBlank(endDate)) {
      criteria.andFeeEndtimeLessThanOrEqualTo(DateFormatUtil.getMonthLastDay(endDate));
      criteria2.andFeeEndtimeLessThanOrEqualTo(DateFormatUtil.getMonthLastDay(endDate));
    }

    String operatedOrg = ThreadLocalUtil.threadLocal.get().getOperatedOrg();
    if (StringUtils.isNotBlank(operatedOrg)) {
      criteria.andOperatedOrgEqualTo(operatedOrg);
      criteria2.andCreatedOrgEqualTo(operatedOrg);
    }

    //为了适应对多个状态的查询
    if (!CollectionUtils.isEmpty(auditStateFlags)) {
      criteria.andAuditStateIn(auditStateFlags);
      criteria2.andAuditStateIn(auditStateFlags);
    }
    example.or(criteria2);

    //设置分页信息
    int count = orgSettlementDAO.countByExample(example);

    int pageIndex = (page - 1) * pageSize;
    int totalPage = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
    example.setOrderByClause(" created_time desc  limit " + pageIndex + " , " + pageSize + " ");
    List<OrgSettlementDO> monSetOrgList = orgSettlementDAO.selectByExample(example);
    List<OrgSettlementDTO> monsets = new ArrayList<>();
    //将do转成dto
    if (!CollectionUtils.isEmpty(monSetOrgList)) {
      for (OrgSettlementDO orgSettlementDO : monSetOrgList) {
        String format =
            JSONObject.toJSONStringWithDateFormat(
                orgSettlementDO, DateFormatUtil.DATE_FORMAT_YYYY_MM_DD_HH_MM_SS);
        OrgSettlementDTO orgSettlementDTO = JSONObject.parseObject(format, OrgSettlementDTO.class);
        //查询经办机构的 名称，前台需要展示
        if (StringUtils.isNotBlank(orgSettlementDTO.getCreatedOrg())) {
          ResultDTO dto = orgnizationServerClient.getByCode(orgSettlementDTO.getCreatedOrg());
          JSONObject obj = (JSONObject) dto.getDatas();
          orgSettlementDTO.setCreatedOrgName(obj != null ? obj.getString("name") : "");
        }
        monsets.add(orgSettlementDTO);
      }
    }
    result.setDatas(monsets);
    result.setPage(page);
    result.setPageSize(pageSize);
    result.setTotalDataNum(count);
    result.setTotalPageNum(totalPage);
    return result;
  }

  @Override
  public OrgSettlementDTO selectById(String id) {
    OrgSettlementDO settlementDO = orgSettlementDAO.selectByPrimaryKey(id);
    if (settlementDO != null) {
      String jsonString =
          JSONObject.toJSONStringWithDateFormat(
              settlementDO, DateFormatUtil.DATE_FORMAT_YYYY_MM_DD_HH_MM_SS);
      return JSONObject.parseObject(jsonString, OrgSettlementDTO.class);
    }
    return null;
  }

  @Override
  @Transactional
  public ResultDTO updateAuditState(OrgSettlementDTO orgSet) {
    ResultDTO result = new ResultDTO();
    String orgCode = orgSet.getOrgCode();
    String feeStarttime = orgSet.getFeeStarttime();
    String feeEndtime = orgSet.getFeeEndtime();
    Integer auditState = orgSet.getAuditState();
    if (StringUtils.isEmpty(orgCode)
        || StringUtils.isEmpty(feeStarttime)
        || StringUtils.isEmpty(feeEndtime)
        || auditState == null) {
      result.setStatus(407);
      result.setMessage(ConstantUtil.UPDATE_AUDIT_STATE_PARAM_ERROR);
      return result;
    }

    //更新机构月结表状态
    updateOrgSetAuditState(orgSet);

    //更新个人月结记录状态
    updatePerMonSetAuditState(orgSet);

    //添加机构费用审核日志
    addAuditStateLog(orgSet);
    result.setStatus(200);
    return result;
  }

  /**
   * 更新个人月结记录
   *
   * @param orgSet
   */
  private void updatePerMonSetAuditState(OrgSettlementDTO orgSet) {
    String orgSetCode = orgSet.getOrgSetCode();
    String feeStarttime = orgSet.getFeeStarttime();
    String feeEndtime = orgSet.getFeeEndtime();
    Integer auditState = orgSet.getAuditState();
    String createdOrg = orgSet.getCreatedOrg();
    //构建修改实体
    MonSetPerDO monSetPer = new MonSetPerDO();
    monSetPer.setAuditState(auditState);
    monSetPer.setOperatedBy(orgSet.getOperatedBy());
    monSetPer.setOperatedTime(
        DateFormatUtil.strToDate(
            orgSet.getOperatedTime(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD_HH_MM_SS));
    monSetPer.setOperatedOrg(orgSet.getOperatedOrg());

    //更新个人日结对公支付状态
    if (ConstantUtil.ALREADY_PAY.equals(orgSet.getAuditState())) {
      //daySet.setPubPayStatus(ConstantUtil.PUB_PAY_STATUS_YES);
    }

    //构建修改条件
    MonSetPerDOExample example = new MonSetPerDOExample();
    com.taikang.dic.ltci.model.MonSetPerDOExample.Criteria criteria = example.createCriteria();
    //机构月结唯一编码
    criteria.andMonSetCodeEqualTo(orgSetCode);
    criteria.andSetDateBetween(
        DateFormatUtil.getDayFirstTime(feeStarttime), DateFormatUtil.getDayLastTime(feeEndtime));
    criteria.andCreatedOrgEqualTo(createdOrg);

    monSetPerDAO.updateByExampleSelective(monSetPer, example);
  }

  //添加机构费用审核日志
  private void addAuditStateLog(OrgSettlementDTO orgSet) {
    FeeAuditLogDO record = new FeeAuditLogDO();

    record.setId(UUIDUtil.getUUID());
    record.setAuditType(orgSet.getAuditState());
    record.setOrgSetCode(orgSet.getOrgSetCode());
    record.setOperatedBy(orgSet.getOperatedBy());
    record.setOperatedOrg(orgSet.getOperatedOrg());
    record.setOperatedTime(
        DateFormatUtil.strToDate(
            orgSet.getOperatedTime(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD_HH_MM_SS));
    //复核不通过时保存不合理费用现场
    if (ConstantUtil.RECHECK_NOT_PASS.equals(orgSet.getAuditState())) {
      record.setRejectReason(orgSet.getRejectReason());
      MonSetPerDOExample _example = new MonSetPerDOExample();
      com.taikang.dic.ltci.model.MonSetPerDOExample.Criteria criteria = _example.createCriteria();
      // 护理机构编号
      criteria.andOrgCodeEqualTo(orgSet.getOrgCode());
      // 费用日期
      criteria.andSetDateBetween(
          DateFormatUtil.getDayFirstTime(orgSet.getFeeStarttime()),
          DateFormatUtil.getDayLastTime(orgSet.getFeeEndtime()));
      // 不合理费用不为空
      criteria.andUnrFeeIsNotNull();
      criteria.andUnrFeeNotEqualTo(BigDecimal.valueOf(0));
      List<MonSetPerDO> perMonSetList = monSetPerDAO.selectByExample(_example);
      if (!CollectionUtils.isEmpty(perMonSetList)) {
        record.setRejectScene(JSON.toJSONString(perMonSetList));
      }
    }
    feeAuditLogDAO.insertSelective(record);
  }

  //更新机构月结表状态
  private void updateOrgSetAuditState(OrgSettlementDTO orgSet) {
    OrgSettlementDO record = new OrgSettlementDO();

    record.setId(orgSet.getId());
    record.setAuditState(orgSet.getAuditState());
    record.setOperatedBy(orgSet.getOperatedBy());
    record.setOperatedTime(new Date());
    record.setOperatedOrg(orgSet.getOperatedOrg());
    record.setRejectReason(orgSet.getRejectReason());

    orgSet.setOperatedTime(
        DateFormatUtil.dateToStr(
            record.getOperatedTime(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD_HH_MM_SS));

    orgSettlementDAO.updateByPrimaryKeySelective(record);
  }

  @Override
  @Transactional
  public ResultDTO settleForOrg(OrgSettlementDTO orgSet) {
    ResultDTO result = new ResultDTO();

    OrgSettlementDO countMouSetPer = new OrgSettlementDO();

    //更新审核状态
    orgSet.setAuditState(ConstantUtil.ALREADY_SETTLED);
    updateAuditState(orgSet);

    //保存机构月结结算信息
    countMouSetPer.setId(orgSet.getId());
    //计算应结金额
    BigDecimal siPay = NumberUtil.nullToBigDecimal(orgSet.getSiPay());
    BigDecimal unrFee = NumberUtil.nullToBigDecimal(orgSet.getUnrFee());
    BigDecimal acountPayable = siPay.subtract(unrFee);
    //计算保证金
    BigDecimal warranty = acountPayable.multiply(BigDecimal.valueOf(warrantyRate));
    //计算实结金额
    BigDecimal realPay = acountPayable.subtract(warranty);

    countMouSetPer.setAcountPayable(acountPayable);
    countMouSetPer.setRealPay(realPay);
    countMouSetPer.setWarranty(warranty);
    countMouSetPer.setSetDate(new Date());

    orgSettlementDAO.updateByPrimaryKeySelective(countMouSetPer);
    result.setStatus(200);
    return result;
  }

  @Override
  public ResultDTO getSiPayCost(String clientCode, String siArea, String agencyCode) {
    ResultDTO dto = new ResultDTO();
    dto.setStatus(200);
    List<Object> dlist = new ArrayList<>();

    String[] arr = siArea.split(",");
    List<String> list = new ArrayList<String>();
    for (String str : arr) {
      list.add(str);
    }
    OrgSettlementDOExample otoe = new OrgSettlementDOExample();
    otoe.createCriteria().andSiAreaIn(list).andIsValidEqualTo(1);
    if (!StringUtils.isEmpty(agencyCode)) {
      otoe.createCriteria().andOrgCodeEqualTo(agencyCode);
    }
    List<OrgSettlementDO> olist = orgSettlementDAO.selectByExample(otoe);

    for (OrgSettlementDO odo : olist) {
      Map<String, String> map = new HashMap<String, String>();
      map.put("costId", odo.getId());
      map.put(
          "setDate",
          DateFormatUtil.dateToStr(odo.getSetDate(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD));
      map.put("totalAmount", String.valueOf(odo.getNurseTotalAmount()));
      map.put("siPay", String.valueOf(odo.getSiPay()));
      map.put("realPay", String.valueOf(odo.getRealPay()));
      dlist.add(map);
    }
    dto.setDatas(dlist);
    return dto;
  }

  @Override
  public ResultDTO updateOrgPaySuccess(
      String costId, String clientCode, String siArea, String agencyCode) {
    ResultDTO dto = new ResultDTO();
    dto.setStatus(200);
    if (StringUtils.isEmpty(costId)) {
      dto.setStatus(500);
      dto.setMessage("costId不能为空");
    }
    OrgSettlementDO record = new OrgSettlementDO();
    record.setId(costId);
    record.setAuditState(ConstantUtil.ALREADY_PAY);
    record.setOperatedTime(new Date());
    record.setOperatedBy(clientCode);
    record.setOperatedOrg(clientCode);
    OrgSettlementDOExample example = new OrgSettlementDOExample();
    example
        .createCriteria()
        .andIsValidEqualTo(1)
        .andIdEqualTo(costId)
        .andAuditStateEqualTo(ConstantUtil.ALREADY_SETTLED);
    if (orgSettlementDAO.selectByExample(example).isEmpty()) {
      dto.setStatus(500);
      dto.setMessage("费用costId无效或未有待支付的费用");
    } else {
      int i = orgSettlementDAO.updateByExampleSelective(record, example);
      if (i < 1) {
        dto.setStatus(500);
        dto.setMessage("支付结果接受失败，请重试");
      }
    }
    return dto;
  }
}
