package com.taikang.dic.ltci.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.common.enumeration.ThirdInterfaceLogEnum;
import com.taikang.dic.ltci.common.util.DateFormatUtil;
import com.taikang.dic.ltci.common.ws.ErrorReason;
import com.taikang.dic.ltci.common.ws.InsuredInfo;
import com.taikang.dic.ltci.common.ws.LongtermCareService;
import com.taikang.dic.ltci.common.ws.NurseAmount;
import com.taikang.dic.ltci.common.ws.NurseAmountDetail;
import com.taikang.dic.ltci.common.ws.ServiceProject;
import com.taikang.dic.ltci.common.ws.TreatmentState;
import com.taikang.dic.ltci.configration.WSConfig;
import com.taikang.dic.ltci.dao.ThirdInterfaceLogDAO;
import com.taikang.dic.ltci.model.NurseDetailDO;
import com.taikang.dic.ltci.model.ServiceItemDO;
import com.taikang.dic.ltci.model.ThirdInterfaceLogDO;
import com.taikang.dic.ltci.model.ThirdInterfaceLogDOExample;
import com.taikang.dic.ltci.service.WSService;

@Service
public class WSServiceImpl implements WSService {
  private static final Logger logger = LoggerFactory.getLogger(WSServiceImpl.class);
  @Autowired private WSConfig config;

  @Autowired private ThirdInterfaceLogDAO thirdInterfaceLogDAO;

  @Value("${isWebserviceDebug}")
  private Boolean isWebserviceDebug;

  /**
   * 保存或更新第三方日志表
   *
   * @param log
   * @return
   */
  public boolean insertInterfaceLog(ThirdInterfaceLogDO log) {

    ThirdInterfaceLogDOExample doe = new ThirdInterfaceLogDOExample();
    doe.createCriteria()
        .andBusiTypeEqualTo(log.getBusiType())
        .andTypeEqualTo(ThirdInterfaceLogEnum.TYPE_SB.getValue())
        .andBusiDataIdEqualTo(log.getBusiDataId());
    List<ThirdInterfaceLogDO> list = thirdInterfaceLogDAO.selectByExample(doe);
    if (!list.isEmpty()) {
      //更新失败次数
      ThirdInterfaceLogDO ldo = list.get(0);
      ldo.setSendContent(log.getSendContent());
      ldo.setSendTime(log.getSendTime());
      ldo.setReveiceContent(log.getReveiceContent());
      ldo.setReveiceTime(log.getReveiceTime());
      ldo.setIsSendSuccess(log.getIsSendSuccess());
      ldo.setReSendNum(ldo.getReSendNum() + 1);
      //重试三次记录错误日志表
      return thirdInterfaceLogDAO.updateByPrimaryKeySelective(ldo) > 0;
    } else {
      if (log.getIsSendSuccess() == 1) {
        return true;
      }
      ThirdInterfaceLogDO third = new ThirdInterfaceLogDO();
      third.setId(UUID.randomUUID().toString().replaceAll("-", ""));
      third.setType(ThirdInterfaceLogEnum.TYPE_SB.getValue()); //社保
      third.setBusiType(log.getBusiType());
      third.setBusiDataId(log.getBusiDataId());
      third.setCreateTime(new Date());
      third.setSendContent(log.getSendContent());
      third.setSendTime(log.getSendTime());
      third.setReveiceContent(log.getReveiceContent());
      third.setReveiceTime(log.getReveiceTime());
      return thirdInterfaceLogDAO.insertSelective(third) > 0;
    }
  }

  @Override
  public InsuredInfo selectInsuredInfo(String idCardNum, String insuredPersonName) {
    LongtermCareService service = config.longtermCaseService();
    InsuredInfo info = null;
    if (service != null) {
      //      info = service.queryInsuredInfo(idCardNum, insuredPersonName);
    }
    return info;
  }

  @Override
  public TreatmentState selectApplicationStatus(String idCardNum, String insuredPersonName) {
    LongtermCareService service = config.longtermCaseService();
    TreatmentState info = null;
    if (service != null) {
      //      info = service.queryNurseTreatment(idCardNum, insuredPersonName);
    }
    return info;
  }

  @Override
  public NurseDetailDO getNurseFeeDetailAndCalaResult(NurseDetailDO detail) {
    long begin = System.currentTimeMillis();
    ThirdInterfaceLogDO log = new ThirdInterfaceLogDO();
    log.setType(ThirdInterfaceLogEnum.TYPE_SB.getValue());
    log.setBusiType(ThirdInterfaceLogEnum.BUSI_TYPE_01.getValue());
    log.setBusiDataId(detail.getId());
    try {
      NurseAmount nurseAmount = new NurseAmount();
      nurseAmount.setInRecorduuid(detail.getInRecorduuid());
      nurseAmount.setProjectType(detail.getProjectType());
      nurseAmount.setChargeType(detail.getChargeType());
      nurseAmount.setCareOrgServiceCode(detail.getCareOrgServiceCode());
      nurseAmount.setMedicareCode(detail.getMedicareCode());
      nurseAmount.setCareOrgServiceName(detail.getCareOrgServiceName());
      nurseAmount.setPrice(String.valueOf(detail.getPrice()));
      nurseAmount.setCount(String.valueOf(detail.getCount()));
      nurseAmount.setNurseName(detail.getNurseName());
      nurseAmount.setOperator(detail.getOperatedBy());
      nurseAmount.setBuildingNo(detail.getBuildingNo());
      nurseAmount.setRoomNo(detail.getRoomNo());
      nurseAmount.setIsRelativeCare(String.valueOf(detail.getIsRelativeCare()));
      nurseAmount.setNurseTime(DateFormatUtil.dateToStr(detail.getNurseTime(), "yyyyMMddHHmmss"));
      nurseAmount.setDiseaseArea(detail.getDiseaseArea());
      nurseAmount.setBedNum(detail.getBedNum());
      nurseAmount.setRxDate(DateFormatUtil.dateToStr(detail.getFeeDate(), "yyyyMMddHHmmss"));
      nurseAmount.setRxNum(detail.getTradeNum()); //对应费用明细流水UUID
      nurseAmount.setSendTimestamp(DateFormatUtil.dateToStr(new Date(), "yyyyMMddHHmmss"));
      nurseAmount.setUniqueNumber(getOrgCode(detail.getOrgCode())); //机构编码
      //logger.debug("__send NurseAmount=" + nurseAmount);
      log.setSendContent(JSONObject.toJSONString(nurseAmount));
      log.setSendTime(new Date());
      NurseAmountDetail thirdDetail = null;
      if (isWebserviceDebug) {
        String json =
            "{\"chargeLevel\":\"1\",\"cycleNum\":\"123\",\"errorReason\":\"成功\",\"errorReasonCode\":\"0\",\"expenseSelf\":6.6,\"nurseTotalAmount\":3.3,\"overCost\":2.2,\"paySelf\":5.5,\"siPay\":4.4,\"transactionNum\":\"1492496533431\"}";
        //String json ="{\"errorReason\":\"中心端连接异常，未接收到消息返回\",\"errorReasonCode\":\"-1\",\"expenseSelf\":0,\"nurseTotalAmount\":0,\"overCost\":0,\"paySelf\":0,\"siPay\":0}";
        thirdDetail = JSONObject.parseObject(json, NurseAmountDetail.class);
      } else {
        LongtermCareService service = config.longtermCaseService();
        thirdDetail = service.getNurseAmountDetail(nurseAmount);
      }
      logger.debug("__return getNurseAmountDetail=" + JSONObject.toJSONString(thirdDetail));
      log.setReveiceContent(JSONObject.toJSONString(thirdDetail));
      log.setReveiceTime(new Date());

      if (thirdDetail != null && WSConfig.STATUS_SUCCESS.equals(thirdDetail.getErrorReasonCode())) {
        log.setIsSendSuccess(1);
        detail.setOverCost(new BigDecimal(thirdDetail.getOverCost())); //超限额
        detail.setNurseTotalAmount(new BigDecimal(thirdDetail.getNurseTotalAmount())); //费用
        detail.setSiPay(new BigDecimal(thirdDetail.getSiPay())); //统筹支出
        detail.setPaySelf(new BigDecimal(thirdDetail.getPaySelf())); //个人自付
        detail.setExpenseSelf(new BigDecimal(thirdDetail.getExpenseSelf())); //个人自费
        detail.setChargeLevel(Integer.parseInt(thirdDetail.getChargeLevel())); //收费项目等级
        return detail;
      } else {
        log.setIsSendSuccess(0);
        log.setFailMessage(thirdDetail != null ? thirdDetail.getErrorReason() : "");
        //调用失败的业务处理。。。
        return null;
      }
    } catch (Exception e) {
      log.setIsSendSuccess(0);
      log.setFailMessage(e.getMessage());
      logger.error(e.getMessage(), e);
      return null;
    } finally {
      insertInterfaceLog(log);
      logger.debug(
          "_____webservice getNurseAmountDetail__耗时ms:" + ((System.currentTimeMillis()) - begin));
    }
  }

  private String getOrgCode(String orgCode) {
    if (orgCode != null) {
      if (orgCode.length() >= 6) {
        orgCode = orgCode.substring(6, orgCode.length());
      }
    }
    return orgCode;
  }

  @Override
  public boolean pushServiceProject(ServiceItemDO serviceItem) {
    long begin = System.currentTimeMillis();
    ThirdInterfaceLogDO log = new ThirdInterfaceLogDO();
    log.setBusiType(ThirdInterfaceLogEnum.BUSI_TYPE_02.getValue());
    log.setBusiDataId(serviceItem.getId());

    try {
      ServiceProject serviceProject = new ServiceProject();
      serviceProject.setMedicareCode(serviceItem.getServiceCode());
      serviceProject.setMedicareType(String.valueOf(serviceItem.getServiceType()));
      serviceProject.setMedicareName(serviceItem.getServiceName());
      serviceProject.setChargeType(serviceItem.getChargeType());
      serviceProject.setChargeLevel(serviceItem.getChargeLevel());
      serviceProject.setServiceFrequency(serviceItem.getFrequency());
      serviceProject.setMedicareHours(serviceItem.getTaskTime());
      serviceProject.setMedicarecontent(serviceItem.getDescription());
      serviceProject.setValidStartDate(
          DateFormatUtil.dateToStr(serviceItem.getStartTime(), "yyyyMMddHHmmss"));
      serviceProject.setValidEndDate(
          DateFormatUtil.dateToStr(serviceItem.getEndTime(), "yyyyMMddHHmmss"));
      serviceProject.setUnitPrice(String.valueOf(serviceItem.getPrice()));
      serviceProject.setMaximumPrice(String.valueOf(serviceItem.getLimitPrice()));
      serviceProject.setOperator(serviceItem.getOperatedBy());
      serviceProject.setOperatorDate(
          DateFormatUtil.dateToStr(serviceItem.getOperatedTime(), "yyyyMMddHHmmss"));
      //logger.debug("__pushServiceProject=" + serviceProject);
      log.setSendContent(JSONObject.toJSONString(serviceProject));
      log.setSendTime(new Date());
      ErrorReason resp = null;
      if (isWebserviceDebug) {
        String json =
            "{\"cycleNum\":\"我是周期号\",\"errorReason\":\"成功\",\"errorReasonCode\":\"0\",\"transactionNum\":\"1492496533296\"}";
        //String json ="{\"errorReason\":\"中心端连接异常，未接收到消息返回\",\"errorReasonCode\":\"-1\"}";
        resp = JSONObject.parseObject(json, ErrorReason.class);
      } else {
        LongtermCareService service = config.longtermCaseService();
        resp = service.pushServiceProject(serviceProject);
      }
      logger.debug("__pushServiceProject=" + JSONObject.toJSONString(resp));
      log.setReveiceContent(JSONObject.toJSONString(resp));
      log.setReveiceTime(new Date());
      if (resp != null && WSConfig.STATUS_SUCCESS.equals(resp.getErrorReasonCode())) {
        log.setIsSendSuccess(1);
        return true;
      } else {
        log.setIsSendSuccess(0);
        log.setFailMessage(resp != null ? resp.getErrorReason() : "");
        return false;
      }
    } catch (Exception e) {
      log.setIsSendSuccess(0);
      log.setFailMessage(e.getMessage());
      logger.error(e.getMessage(), e);
      return false;
    } finally {
      insertInterfaceLog(log);
      logger.debug(
          "_____webservice pushServiceProject__耗时ms:" + ((System.currentTimeMillis()) - begin));
    }
  }
}
