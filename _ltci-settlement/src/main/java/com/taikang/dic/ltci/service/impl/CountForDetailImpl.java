package com.taikang.dic.ltci.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.ConstantUtil;
import com.taikang.dic.ltci.common.IsValidEnum;
import com.taikang.dic.ltci.common.util.DateFormatUtil;
import com.taikang.dic.ltci.dao.DaySetPerDAO;
import com.taikang.dic.ltci.dao.ISetCheckConfigDAO;
import com.taikang.dic.ltci.dao.ISetConfigDAO;
import com.taikang.dic.ltci.dao.ServiceItemDAO;
import com.taikang.dic.ltci.model.DaySetPerDO;
import com.taikang.dic.ltci.model.DaySetPerDOExample;
import com.taikang.dic.ltci.model.NurseAmountDetail;
import com.taikang.dic.ltci.model.NurseDetailDO;
import com.taikang.dic.ltci.model.ServiceItemDO;
import com.taikang.dic.ltci.model.ServiceItemDOExample;
import com.taikang.dic.ltci.model.SetCheckConfigBO;
import com.taikang.dic.ltci.model.SetCheckConfigBOExample;
import com.taikang.dic.ltci.model.SetCheckConfigBOExample.Criteria;
import com.taikang.dic.ltci.model.SetConfigBO;
import com.taikang.dic.ltci.model.SetConfigBOExample;
import com.taikang.dic.ltci.model.TreatmentState;
import com.taikang.dic.ltci.service.ICountNurseDetail;
import com.taikang.dic.ltci.serviceClient.AgencyServerClient;
import com.taikang.dic.ltci.serviceClient.CheckInServerClient;
import com.taikang.dic.ltci.serviceClient.InsuredPersonServerClient;
import com.taikang.dic.ltci.serviceClient.StaffServerClient;

/**
 * 根据护理明细计算
 *
 * @author itw_muwg
 */
@Service
public class CountForDetailImpl implements ICountNurseDetail {
  @Autowired private ISetCheckConfigDAO setCheckConfigDAO;
  @Autowired private ISetConfigDAO setConfigDAO;
  @Autowired private ServiceItemDAO serviceItemDAO;
  @Autowired private DaySetPerDAO daySetPerDAO;
  @Autowired private AgencyServerClient agencyServerClient;
  @Autowired private StaffServerClient staffServerClient;
  @Autowired private CheckInServerClient checkInServerClient;
  @Autowired private InsuredPersonServerClient insuredPersonServerClient;

  private Map<String, SetCheckConfigBO> checkMap = new HashMap<>();

  public void cleanMap() {
    this.checkMap.clear();
  }

  @Override
  public NurseAmountDetail getNurseAmountDetail(NurseDetailDO nurseDetail) {
    initCheckMap();
    Map<String, Object> map = checkNurseDetail(nurseDetail);
    boolean flag = (boolean) map.get(ConstantUtil.FLAG);
    if (!flag) {
      return (NurseAmountDetail) map.get(ConstantUtil.NURSE_AMOUNT);
    } else {
      //如果校验都通过了，获取服务项目
      ServiceItemDO serviceItemBO = getServiceItem(nurseDetail.getMedicareCode());
      //该项目的计算规则
      SetConfigBO setConfigBO = getSetConfig(nurseDetail, serviceItemBO);
      return scaleNurseDetail(nurseDetail, serviceItemBO, setConfigBO);
    }
  }
  /**
   * 计算明细费用
   *
   * @param nurseDetail
   * @param serviceItemBO
   * @param setConfigBO
   * @return
   */
  private NurseAmountDetail scaleNurseDetail(
      NurseDetailDO nurseDetail, ServiceItemDO serviceItemBO, SetConfigBO setConfigBO) {
    NurseAmountDetail nuAmountDetail = new NurseAmountDetail();
    //统筹比例
    Double siScale = setConfigBO.getSiScale();
    double overCost = 0; //超限价
    double nurseTotalAmount =
        serviceItemBO.getPrice().doubleValue() * nurseDetail.getCount(); //总费用
    if (siScale == 0) {
      //统筹比例为0，全自费,个人自费 =总费用= 单价*数量，
      nuAmountDetail.setExpenseSelf(nurseTotalAmount);
      if (serviceItemBO.getPrice().doubleValue() - (serviceItemBO.getLimitPrice().doubleValue())
          > 0) {
        //如果单价超过限价,超限价 = 单价超过限价的部分乘以数量
        overCost =
            (serviceItemBO.getPrice().doubleValue() - (serviceItemBO.getLimitPrice().doubleValue()))
                * nurseDetail.getCount();
      }
      nuAmountDetail.setChargeLevel(serviceItemBO.getChargeLevel());
      nuAmountDetail.setNurseTotalAmount(nurseTotalAmount);
      nuAmountDetail.setOverCost(overCost);
      return nuAmountDetail;
    } else {
      return countSiPay(nurseDetail, serviceItemBO, setConfigBO);
    }
  }
  /**
   * 计算统筹支出、自付
   *
   * @param nurseDetail
   * @param serviceItemBO
   * @param setConfigBO
   * @return
   */
  private NurseAmountDetail countSiPay(
      NurseDetailDO nurseDetail, ServiceItemDO serviceItemBO, SetConfigBO setConfigBO) {
    NurseAmountDetail nuAmountDetail = new NurseAmountDetail();
    //统筹比例
    Double siScale = setConfigBO.getSiScale();
    //日限额
    BigDecimal dayQuota = setConfigBO.getDayQuota();
    double siPay = 0; //统筹支出
    double paySelf = 0; //个人自付
    double expenseSelf = 0; //个人自费
    double overCost = 0; //超限价
    double total; //总额
    double nurseTotalAmount =
        serviceItemBO.getPrice().doubleValue() * nurseDetail.getCount(); //总费用
    //单价超过限价
    if (serviceItemBO.getPrice().doubleValue() - (serviceItemBO.getLimitPrice().doubleValue())
        > 0) {
      //超限价乘以数量得到总额，单价超过限价的部分乘以数量作为超限价和个人自费。
      double overCostAndExpenseSelf =
          (serviceItemBO.getPrice().doubleValue() - (serviceItemBO.getLimitPrice().doubleValue()))
              * nurseDetail.getCount();
      overCost = overCostAndExpenseSelf;
      expenseSelf = overCostAndExpenseSelf;
      total = serviceItemBO.getLimitPrice().doubleValue() * nurseDetail.getCount();
    } else {
      //单价乘以数量得到总额
      total = serviceItemBO.getPrice().doubleValue() * nurseDetail.getCount();
    }
    //判断日结表中是否有此人的当日数据
    DaySetPerDO daySetPerDO = getNurseFromDaySet(nurseDetail);
    if (daySetPerDO == null) {
      //日结表中没有记录
      //总额不超过日限额：则以总额乘以统筹比例作为统筹支出，剩余的是自付
      if (total - dayQuota.doubleValue() < 0) {
        siPay = total * siScale;
        paySelf = total - siPay;
      } else {
        //总额超过日限额：则日限额乘以统筹比例作为统筹支出，日限额剩余的是自付，总额超过日限额的部分为个人自费；
        siPay = dayQuota.doubleValue() * siScale;
        paySelf = dayQuota.doubleValue() - siPay;
        expenseSelf += (total - dayQuota.doubleValue());
      }
    } else {
      //日结表中有记录
      if ((daySetPerDO.getAccountPay().doubleValue() + daySetPerDO.getPaySelf().doubleValue())
          > dayQuota.doubleValue()) {
        //日结中统筹支出加自付超过日限额：该明细的单价乘以数量都是个人自费
        expenseSelf += (serviceItemBO.getPrice().doubleValue() * nurseDetail.getCount());
      } else {
        //日结中统筹支出加自付没有超过日限额：日限额减去日结中统筹支出和自付=剩余的限额
        double remainQuota =
            dayQuota.doubleValue()
                - (daySetPerDO.getAccountPay().doubleValue()
                    + daySetPerDO.getPaySelf().doubleValue());
        if (total - remainQuota < 0) {
          // 总额不超过剩余的限额：则以总额乘以统筹比例作为统筹支出，剩余的是自付；
          siPay = total * siScale;
          paySelf = total - siPay;
        } else {
          // 总额超过剩余的限额：则剩余的限额乘以统筹比例作为统筹支出，剩余的限额剩余的是自付，总额超过剩余的限额的部分为个人自费；
          siPay = remainQuota * siScale;
          paySelf = remainQuota - siPay;
          expenseSelf += (total - remainQuota);
        }
      }
    }
    nuAmountDetail.setChargeLevel(serviceItemBO.getChargeLevel());
    nuAmountDetail.setExpenseSelf(expenseSelf);
    nuAmountDetail.setNurseTotalAmount(nurseTotalAmount);
    nuAmountDetail.setOverCost(overCost);
    nuAmountDetail.setPaySelf(paySelf);
    nuAmountDetail.setSiPay(siPay);
    return nuAmountDetail;
  }
  /**
   * 根据项目等级、医疗类别、统筹区获取项目计算规则
   *
   * @param nurseDetail
   * @param serviceItemBO
   * @return
   */
  private SetConfigBO getSetConfig(NurseDetailDO nurseDetail, ServiceItemDO serviceItemBO) {
    SetConfigBO setConfigBO = new SetConfigBO();
    if (serviceItemBO != null) {
      SetConfigBOExample setExample = new SetConfigBOExample();
      com.taikang.dic.ltci.model.SetConfigBOExample.Criteria setCriteria =
          setExample.createCriteria();
      setCriteria.andChargeLevelEqualTo(serviceItemBO.getChargeLevel()); //项目等级
      setCriteria.andMedicalTypeEqualTo(nurseDetail.getMedicalType()); //医疗类别
      setCriteria.andSiAreaEqualTo(nurseDetail.getSiArea()); //统筹区
      List<SetConfigBO> setConfigList = setConfigDAO.selectByExample(setExample);
      if (setConfigList != null && !setConfigList.isEmpty()) {
        setConfigBO = setConfigList.get(0);
      }
    }
    return setConfigBO;
  }
  /**
   * 根据服务项目编码查询
   *
   * @param medicareCode
   * @return
   */
  private ServiceItemDO getServiceItem(String medicareCode) {
    ServiceItemDOExample itemExample = new ServiceItemDOExample();
    com.taikang.dic.ltci.model.ServiceItemDOExample.Criteria itemCriteria =
        itemExample.createCriteria();
    itemCriteria.andServiceCodeEqualTo(medicareCode);
    //根据明细的服务目录查询出服务等级、单价和超限价，根据医疗类别和项目等级,统筹区查询统筹比例，日限额
    List<ServiceItemDO> itemList = serviceItemDAO.selectByExample(itemExample);
    //服务项目详情
    if (itemList != null && !itemList.isEmpty()) {
      return itemList.get(0);
    }
    return null;
  }
  /**
   * 校验明细是否 合格
   *
   * @param nurseDetail
   * @param flag
   * @return
   */
  private Map<String, Object> checkNurseDetail(NurseDetailDO nurseDetail) {
    Map<String, Object> map = new HashMap<>();
    boolean flag = true;
    String message;
    //校验参保人是否享受待遇
    SetCheckConfigBO insuredPersonTreatment = checkMap.get(ConstantUtil.INSURED_PERSON_TREATMENT);
    if (insuredPersonTreatment != null) {
      //身份证号,姓名校验是否享受待遇
      JSONObject insuredInfo = new JSONObject();
      insuredInfo.put("idCardNum ", nurseDetail.getBeCarePersonCard());
      insuredInfo.put("insuredPersonName ", nurseDetail.getBeCarePersonName());
      TreatmentState treatmentState =
          insuredPersonServerClient.queryNurseTreatment(insuredInfo.toJSONString());
      if ("0".equals(treatmentState.getTreatment())) {
        //0 不能享受待遇
        //如果校验不通过
        flag = false;
        message =
            "参保人："
                + nurseDetail.getBeCarePersonName()
                + "不能享受待遇，原因："
                + treatmentState.getNoRreatmentReason();
        return getCheckResult(map, flag, message);
      }
    }
    //校验参保人是在院
    SetCheckConfigBO insuredPersonInHospital =
        checkMap.get(ConstantUtil.INSURED_PERSON_IN_HOSPITAL);
    if (insuredPersonInHospital != null) {
      //入住编号校验是否在院
      ResultDTO inHostStat4Check =
          checkInServerClient.getInHostStat4Check(nurseDetail.getInRecorduuid());
      //0 在院
      if (0 != inHostStat4Check.getStatus()) {
        //如果不在院
        flag = false;
        message = inHostStat4Check.getMessage();
        return getCheckResult(map, flag, message);
      }
    }
    //校验护理机构是否有效
    SetCheckConfigBO nurseAgency = checkMap.get(ConstantUtil.NURSE_AGENCY);
    if (nurseAgency != null) {
      //根据机构编码查询机构信息
      String state =
          agencyServerClient.getAgencyState(nurseDetail.getOrgCode(), nurseDetail.getFeeDate());
      if ("false".equals(state)) {
        //如果校验不通过
        flag = false;
        message = "护理机构编码是：" + nurseDetail.getOrgCode() + "的记录无效";
        return getCheckResult(map, flag, message);
      }
    }
    //校验护理人员是否有效
    SetCheckConfigBO nursePerson = checkMap.get(ConstantUtil.NURSE_PERSON);
    if (nursePerson != null) {
      String staffState = staffServerClient.getStaffState(nurseDetail.getNurseCode());
      if ("false".equals(staffState)) {
        //如果校验不通过
        flag = false;
        message = "护理人员编码是：" + nurseDetail.getNurseCode() + "的记录无效";
        return getCheckResult(map, flag, message);
      }
    }
    //校验服务目录是否有效
    SetCheckConfigBO serviceItem = checkMap.get(ConstantUtil.SERVICE_ITEM);
    if (serviceItem != null) {
      //服务项目编码校验是否是医保服务项目
      ServiceItemDO serviceItemBO = getServiceItem(nurseDetail.getMedicareCode());
      if (serviceItemBO != null) {
        //校验该服务目录是否有计算规则
        SetConfigBO setConfig = getSetConfig(nurseDetail, serviceItemBO);
        if (setConfig == null) {
          flag = false;
          message =
              "没有找到医疗类别："
                  + nurseDetail.getMedicalType()
                  + "，项目等级："
                  + serviceItemBO.getChargeLevel()
                  + "，统筹区："
                  + nurseDetail.getSiArea()
                  + " 对应的计算规则";
          return getCheckResult(map, flag, message);
        }
      } else {
        //如果校验不通过
        flag = false;
        message = "服务项目编码：" + nurseDetail.getMedicareCode() + " 对应的记录不存在";
        return getCheckResult(map, flag, message);
      }
    }
    map.put("flag", flag);
    return map;
  }
  /**
   * 校验不通过结果
   *
   * @param map
   * @param flag
   * @param message
   * @return
   */
  private Map<String, Object> getCheckResult(
      Map<String, Object> map, boolean flag, String message) {
    NurseAmountDetail amountDetail = new NurseAmountDetail();
    amountDetail.setErrorReason(message);
    amountDetail.setErrorReasonCode(ConstantUtil.COUNT_DETAIL_RESPONSE_CODE_ERROR);
    map.put(ConstantUtil.FLAG, flag);
    map.put(ConstantUtil.NURSE_AMOUNT, amountDetail);
    return map;
  }
  /** 初始化校验规则 */
  private void initCheckMap() {
    if (checkMap.isEmpty()) {
      //初始化校验规则
      SetCheckConfigBOExample checkExample = new SetCheckConfigBOExample();
      Criteria checkCrieria = checkExample.createCriteria();
      checkCrieria.andIsValidEqualTo(IsValidEnum.NO_DELETE.getValue());
      //查询所有需要校验的规则
      List<SetCheckConfigBO> checkConfigList = setCheckConfigDAO.selectByExample(checkExample);
      for (SetCheckConfigBO setCheckConfigBO : checkConfigList) {
        checkMap.put(setCheckConfigBO.getOrderType(), setCheckConfigBO);
      }
    }
  }
  /**
   * 查询参保人费用当天日结表中是否有记录
   *
   * @param nurseDetail
   * @return
   */
  private DaySetPerDO getNurseFromDaySet(NurseDetailDO nurseDetail) {
    //判断日结表中是否有此人的当日数据
    DaySetPerDOExample daySetExample = new DaySetPerDOExample();
    com.taikang.dic.ltci.model.DaySetPerDOExample.Criteria daySetCriteria =
        daySetExample.createCriteria();
    daySetCriteria.andBeCarePersonCardEqualTo(nurseDetail.getBeCarePersonCard());
    daySetCriteria.andInRecorduuidEqualTo(nurseDetail.getInRecorduuid());
    daySetCriteria.andFeeDateGreaterThanOrEqualTo(
        DateFormatUtil.getDayFirstTime(nurseDetail.getFeeDate()));
    daySetCriteria.andFeeDateLessThanOrEqualTo(
        DateFormatUtil.getDayLastTime(nurseDetail.getFeeDate()));
    List<DaySetPerDO> daySetList = daySetPerDAO.selectByExample(daySetExample);
    if (daySetList != null && !daySetList.isEmpty()) {
      return daySetList.get(0);
    }
    return null;
  }
}
