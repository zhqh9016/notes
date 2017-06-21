package com.taikang.dic.ltci.service.impl;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.CalendarDeserializer;
import com.taikang.dic.ltci.api.model.CheckInDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.ConstantUtil;
import com.taikang.dic.ltci.common.enumeration.InHospStateEnum;
import com.taikang.dic.ltci.common.enumeration.OperationTypeEnum;
import com.taikang.dic.ltci.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.common.enumeration.TransportTypeEnum;
import com.taikang.dic.ltci.common.util.DateFormatUtil;
import com.taikang.dic.ltci.common.util.SpringContextUtil;
import com.taikang.dic.ltci.common.util.UUIDUtil;
import com.taikang.dic.ltci.common.util.UrlUtil;
import com.taikang.dic.ltci.dao.CustomNurseDetailDAO;
import com.taikang.dic.ltci.dao.DaySetPerDAO;
import com.taikang.dic.ltci.dao.IGenericDAO;
import com.taikang.dic.ltci.dao.MonSetPerDAO;
import com.taikang.dic.ltci.dao.MqMessageLogDAO;
import com.taikang.dic.ltci.model.InsuredPersonDO;
import com.taikang.dic.ltci.model.MonSetPerDO;
import com.taikang.dic.ltci.model.MonSetPerDOExample;
import com.taikang.dic.ltci.model.MonSetPerDOExample.Criteria;
import com.taikang.dic.ltci.model.MqFailMessageLogDO;
import com.taikang.dic.ltci.model.PersonAmountInfo;
import com.taikang.dic.ltci.model.PersonCostAccount;
import com.taikang.dic.ltci.mqmodel.MqBaseModel;
import com.taikang.dic.ltci.service.AbstractGenericService;
import com.taikang.dic.ltci.service.IMonSetPerService;
import com.taikang.dic.ltci.service.IMqFailMessageLogService;
import com.taikang.dic.ltci.service.IMqMessageLogService;
import com.taikang.dic.ltci.service.ServiceException;
import com.taikang.dic.ltci.serviceClient.CheckInServerClient;
import com.taikang.dic.ltci.serviceClient.InsuredPersonServerClient;

/**
 * 月结算刷卡（个人）service
 *
 * @author itw-huodd E-mail:
 * @date 创建时间：2017年4月13日 下午2:15:17
 */
@Service
public class MonSetPerServiceImpl extends AbstractGenericService<MonSetPerDO, String>
    implements IMonSetPerService {

  private static final Logger logger = LoggerFactory.getLogger(MonSetPerServiceImpl.class);

  @Value("${ltci.monSetPer.queue}")
  private String monSetPerQ;

  @Value("${ltci.monSetPer.exechange}")
  private String exechange;

  @Value("${ltci.monSetPer.messageCode}")
  private String messageCode;

  @Autowired protected MonSetPerDAO monSetPerDAO;

  @Autowired protected MqMessageLogDAO mqMessageLogDAO;

  @Autowired DaySetPerDAO daySetPerDao;

  @Autowired IMqMessageLogService mqMessageLogService;

  @Autowired private UrlUtil urlUtil;

  @Autowired private IMqFailMessageLogService failMessageLogService;

  @Autowired private SpringContextUtil springContextUtil;

  @Autowired private InsuredPersonServerClient insuredPersonServerClient;

  @Autowired private CheckInServerClient checkInServerClient;

  @Autowired private CustomNurseDetailDAO customNurseDetailDAO;

  @Override
  public IGenericDAO<MonSetPerDO, String> getDao() {
    return monSetPerDAO;
  }

  /** 该方法由系统自动启动侦听，系统启动时如果AMQ中有消息自动进行处理 收到数据后： 0、查询消息日志，确认该日志是否已收到 1、数据录入个人月结表 2、更新个人日结个人支付状态 */
  @Override
  @RabbitListener(queues = "${ltci.monSetPer.queue}")
  public void receiveMessage(byte[] b) {
    String message = null;
    MqBaseModel mqBaseModel = null;
    try {
      message = new String(b, systemCharset);
      logger.debug("receive message content:" + message);
      mqBaseModel = JSONObject.parseObject(message, MqBaseModel.class);

      if (mqMessageLogService.isHas(mqBaseModel.getBusinessSerialid())) {
        logger.debug("__MQ消息[" + mqBaseModel.getBusinessSerialid() + "]已经处理");
        return;
      }

      //在这个方法中做事务处理
      MonSetPerServiceImpl bean =
          springContextUtil.getApplicationContext().getBean(MonSetPerServiceImpl.class);
      bean.saveMonSetPerData(message); //

    } catch (Exception e) {
      logger.error("监听移动端投诉接口异常：" + e.getMessage(), e);
      if (mqBaseModel != null && StringUtils.isNotBlank(mqBaseModel.getBusinessSerialid())) {
        MqFailMessageLogDO failLog = new MqFailMessageLogDO();
        failLog.setId(mqBaseModel.getBusinessSerialid());
        failLog.setTransportType(TransportTypeEnum.ASYNCHRONIZE.getValue()); //交互方式：异步
        failLog.setOperationType(OperationTypeEnum.RECEIVE.getValue()); //发送接收类型
        failLog.setQueryName(monSetPerQ);
        failLog.setContent(message);
        failLog.setErrorMessage(e.getMessage());
        failLog.setCreateTime(new Date());
        failLog.setHttpAction(HttpMethod.POST.name());
        // 添加重试url
        failLog.setRetryUrl(urlUtil.getBaseUrl() + ConstantUtil.RETRY_URL_MON_SET_PER);
        failMessageLogService.saveOrUpdateFailLog(failLog);
      }
    }
  }
  /**
   * 保存个人月结明细数据
   *
   * @param message MQ消息的json串
   */
  @Transactional
  public void saveMonSetPerData(String message) throws Exception {
    MqBaseModel mqBaseModel = JSONObject.parseObject(message, MqBaseModel.class);
    mqMessageLogService.receiveMqMessageLog(mqBaseModel.getBusinessSerialid(), message);

    message = String.valueOf(mqBaseModel.getData());
    MonSetPerDO monSetPerDo = JSONObject.parseObject(message, MonSetPerDO.class);
    monSetPerDo.setId(UUID.randomUUID().toString().replaceAll("-", ""));
    monSetPerDo.setCreatedTime(new Date());
    monSetPerDo.setOperatedTime(new Date());
    monSetPerDo.setAuditState(ConstantUtil.WAITING_PROCESS);
    //获取创建机构
    //    String createdOrg = getOrgCode(monSetPerDo.getBeCarePersonCardNum());
    InsuredPersonDO ido = getInsuredPerson(monSetPerDo.getBeCarePersonCardNum());
    if (ido != null && ido.getOperatedOrg() != null) {
      String createdOrg = ido.getOperatedOrg();
      monSetPerDo.setCreatedOrg(createdOrg);
      monSetPerDo.setOperatedOrg(createdOrg);
      monSetPerDo.setSiArea(ido.getSiArea());
      int i = insertSelective(monSetPerDo);
      //      if (i > 0) {
      //        DaySetPerDO ddo = new DaySetPerDO();
      //        ddo.setPerPayStatus(ConstantUtil.PER_PAY_STATUS_YES); //个人支付状态
      //        ddo.setOrgSetCode(monSetPerDo.getPerSetCode()); //专业端，个人月结费用统一id
      //        logger.debug("____" + monSetPerDo.getNurseStarttime());
      //        //入住唯一编号和费用产生时间作为更新条件
      //        DaySetPerDOExample dde = new DaySetPerDOExample();
      //        dde.createCriteria()
      //            .andIsValidEqualTo(IsValidEnum.NO_DELETE.getValue())
      //            .andInRecorduuidEqualTo(monSetPerDo.getInRecorduuid())
      //            .andFeeDateBetween(monSetPerDo.getNurseStarttime(), monSetPerDo.getNurseEndtime());
      //        //更新个人日结个人支付状态
      //        i = daySetPerDao.updateByExampleSelective(ddo, dde);
      //        if (i <= 0) {
      //          throw new Exception("更新个人日结个人支付状态失败");
      //        }
      //      }
      if (i == 0) {
        throw new Exception("个人月结录入失败");
      }
    } else {
      throw new Exception("获取护理对象[" + monSetPerDo.getBeCarePersonCardNum() + "]的基本信息失败");
    }
  }

  /**
   * 获取参保人经办机构编码
   *
   * @param idCardNo 身份证号码
   * @return
   */
  private InsuredPersonDO getInsuredPerson(String idCardNo) {
    try {
      ResultDTO result = insuredPersonServerClient.getInsuredPersonDetail("", idCardNo, "");
      if (StatusCodeEnum.OK.getValue().equals(result.getStatus())) {
        Object datas = result.getDatas();
        InsuredPersonDO ido =
            JSONObject.parseObject(JSONObject.toJSONString(datas), InsuredPersonDO.class);
        return ido;
      }
    } catch (Exception e) {
      logger.error("根据身份证号获取参保人信息失败" + e.getMessage(), e);
    }
    return null;
  }

  @Override
  public Map<String, Object> listMonSetPer(
      String name,
      String idCard,
      String startDate,
      String endDate,
      String orgCode,
      Double unrFee,
      Integer page,
      Integer pageSize,
      String operateOrgCode) {
    // 创建查询条件
    MonSetPerDOExample example = new MonSetPerDOExample();
    Criteria c = example.createCriteria();
    MonSetPerDOExample example1 = new MonSetPerDOExample();
    Criteria c1 = example1.createCriteria();
    // 机构编号
    c.andOrgCodeEqualTo(orgCode);
    c1.andOrgCodeEqualTo(orgCode);
    // 费用日期
    if (!StringUtils.isEmpty(startDate)) {
      c.andSetDateGreaterThanOrEqualTo(DateFormatUtil.getDayFirstTime(startDate));
      c1.andSetDateGreaterThanOrEqualTo(DateFormatUtil.getDayFirstTime(startDate));
    } else {
      c.andSetDateGreaterThanOrEqualTo(DateFormatUtil.getDayLastTime(endDate));
      c1.andSetDateGreaterThanOrEqualTo(DateFormatUtil.getDayLastTime(endDate));
    }
    if (!StringUtils.isEmpty(endDate)) {
      c.andSetDateLessThanOrEqualTo(DateFormatUtil.getDayLastTime(endDate));
      c1.andSetDateLessThanOrEqualTo(DateFormatUtil.getDayLastTime(endDate));
    } else {
      c.andSetDateLessThanOrEqualTo(DateFormatUtil.getDayFirstTime(startDate));
      c1.andSetDateLessThanOrEqualTo(DateFormatUtil.getDayFirstTime(startDate));
    }
    // 如果姓名不为空
    if (!StringUtils.isEmpty(name)) {
      c.andNurseObjNameLike("%" + name + "%");
      c1.andNurseObjNameLike("%" + name + "%");
    }
    // 如果身份证号不为空
    if (!StringUtils.isEmpty(idCard)) {
      c.andBeCarePersonCardNumEqualTo(idCard);
      c1.andBeCarePersonCardNumEqualTo(idCard);
    }
    // 如果不合理费用不为空
    if (unrFee != null && unrFee != 0) {
      c.andUnrFeeNotEqualTo(new BigDecimal(0));
      c1.andUnrFeeNotEqualTo(new BigDecimal(0));
    }
    c.andCreatedOrgEqualTo(operateOrgCode);
    c1.andOperatedOrgEqualTo(operateOrgCode);
    example.or(c1);
    int count = monSetPerDAO.countByExample(example);

    int pageIndex = (page - 1) * pageSize;
    int totalPage = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
    example.setOrderByClause(
        " nurse_obj_name, set_date asc  limit " + pageIndex + " , " + pageSize + " ");
    List<MonSetPerDO> monSetPerList = monSetPerDAO.selectByExample(example);

    Map<String, Object> model = new HashMap<>();
    model.put("page", page);
    model.put("pageSize", pageSize);
    model.put("totalDataNum", count);
    model.put("totalPageNum", totalPage);
    model.put("monSetPerList", monSetPerList);
    return model;
  }

  @Override
  public boolean enterUnrFee(MonSetPerDO monSetPerDo) throws ServiceException {
    monSetPerDo.setOperatedTime(new Date());
    monSetPerDo.setVersion(monSetPerDo.getVersion() + 1);
    int i = monSetPerDAO.updateByPrimaryKeySelective(monSetPerDo);
    if (i <= 0) {
      throw new ServiceException(500, "录入不合理费用失败");
    }
    return true;
  }

  @Override
  public List<MonSetPerDO> getMonSetByIdAndVersion(String id, Long version) {
    MonSetPerDOExample example = new MonSetPerDOExample();
    example.createCriteria().andIdEqualTo(id).andVersionEqualTo(version);
    return monSetPerDAO.selectByExample(example);
  }

  /** 统计费用时结束时间确定规则 比如,当前时间为5月5号,专业端传过来的是6月5号,我们将结算时间记为5月5号, 统计时,统计上个月月末之前的信息,即4月30之前的未结算信息 */
  @Override
  public PersonCostAccount countPersonCost(String personInfo, String cardInfo) {
    PersonCostAccount result = new PersonCostAccount();
    if (StringUtils.isNotBlank(personInfo)) {

      //-----------------------校验必传信息----start---------------------------
      PersonAmountInfo personAmountInfo =
          JSONObject.parseObject(personInfo, PersonAmountInfo.class);
      //入住唯一编号
      String recorduuid = personAmountInfo.getInRecorduuid();
      if (StringUtils.isBlank(recorduuid)) {
        result.setErrorReasonCode(ConstantUtil.PERSON_SETTLE_RESPONSE_CODE_ERROR);
        result.setErrorReason("入住编号不能为空");
        return result;
      }
      //是否使用账户支付
      String isAccountUse = personAmountInfo.getIsAccountUse();
      if (StringUtils.isBlank(isAccountUse)) {
        result.setErrorReasonCode(ConstantUtil.PERSON_SETTLE_RESPONSE_CODE_ERROR);
        result.setErrorReason("支付方式不能为空");
        return result;
      }
      //预结算标志
      String isbBalance = personAmountInfo.getIsbBalance();
      if (StringUtils.isBlank(isbBalance)) {
        result.setErrorReasonCode(ConstantUtil.PERSON_SETTLE_RESPONSE_CODE_ERROR);
        result.setErrorReason("预结算标识不能为空");
        return result;
      }
      //-----------------------校验必传信息----end---------------------------

      //-------------------------确定结算终止日期--start-----------------------------
      //查询人在院状态
      ResultDTO inHostStat4Check = checkInServerClient.getInHostStat4Check(recorduuid);
      Integer status = inHostStat4Check.getStatus();
      Object datas = inHostStat4Check.getDatas();

      //如果查不到在院状态,直接退出
      if (Integer.valueOf(InHospStateEnum.NULL.getValue()).equals(status)) {
        result.setErrorReasonCode(ConstantUtil.PERSON_SETTLE_RESPONSE_CODE_ERROR);
        result.setErrorReason("该入住编号查不到数据");
        return result;
      }
      CheckInDTO checkIn = JSONObject.parseObject(JSONObject.toJSONString(datas), CheckInDTO.class);

      Date feeTime = new Date();
      //用于存储费用结束时间
      Date endFeeTime = new Date();
      //如果是在院状态
      if (Integer.valueOf(InHospStateEnum.out.getValue()).equals(status)) {
        //判断结算时间是否为空或比当前时间靠后,如果比当前时间靠后,取当前时间,如果不比当前时间靠后那么取专业传递的结算时间
        String balanceDate = personAmountInfo.getBalanceDate();
        //比如,当前时间为5月5号,专业端传过来的是6月5号,我们将结算时间记为5月5号,统计时,统计上个月月末之前的信息,即4月30之前的未结算信息
        if (StringUtils.isNotBlank(balanceDate)
            && feeTime.after(DateFormatUtil.strToDate(balanceDate))) {
          feeTime = DateFormatUtil.strToDate(balanceDate);
        }
      }
      //如果是出院状态
      if (Integer.valueOf(InHospStateEnum.In.getValue()).equals(status)) {
        //取实际出院时间作为结算时间
        String realOutDate = checkIn.getRealOutDate();
        if (StringUtils.isNotBlank(realOutDate)) {
          feeTime =
              DateFormatUtil.strToDate(realOutDate, DateFormatUtil.DATE_FORMAT_YYYY_MM_DD_HH_MM_SS);
        }
      }
      endFeeTime = getPreMonthLastDay(feeTime);
      //-------------------------确定结算终止日期--end-----------------------------

      //--------------------------计算结算信息---start-----------------------------
      //判断是否使用账号支付
      //使用账号支付的逻辑,直接返回错误提示信息
      if (ConstantUtil.PERSON_SETTLE_USE_ACCOUNT.equals(isAccountUse)) {
        result.setErrorReasonCode(ConstantUtil.PERSON_SETTLE_RESPONSE_CODE_ERROR);
        result.setErrorReason("暂不支持账户支付方式");
        return result;
      }
      //不使用账号支付的逻辑
      if (ConstantUtil.PERSON_SETTLE_NOT_USE_ACCOUNT.equals(isAccountUse)) {
        Map<String, String> parameters = new HashMap<>();
        
        parameters.put("inRecorduuid", recorduuid);
        parameters.put("feeDate", DateFormatUtil.dateToStr(endFeeTime, DateFormatUtil.DATE_FORMAT_YYYY_MM_DD_HH_MM_SS));
        
        //从数据库服务明细表中根据入住唯一编号和结算截止日期计算结算信息
        PersonCostAccount settleForPerson = customNurseDetailDAO.settleForPerson(parameters);
        
        //构建返回结果
        settleForPersonNoAccount(result, settleForPerson);
        result.setErrorReasonCode(ConstantUtil.PERSON_SETTLE_RESPONSE_CODE_SUCESS);
      }
      //--------------------------计算结算信息---end------------------------------

      //---------------------------结算时结算信息插入以及更新结算状态--start----------------------------------
      //判断是否为预结算,如果不为结算那么向个人结算表中插入一条数据,并更新服务明细表中的结算状态
      if (ConstantUtil.PERSON_SETTLE_BALANCE.equals(isbBalance)) {
        //向个人结算表中插入一条数据并更新服务明细表中的结算状态,
        //需要在一个事物里
    	  MonSetPerDO monSetPerDO = new MonSetPerDO();
    	  monSetPerDO.setId(UUIDUtil.getUUID());
    	  monSetPerDO.setPerSetCode(UUIDUtil.getUUID());
    	  monSetPerDO.setReceiptNum(personAmountInfo.getReceiptNum());
    	  monSetPerDO.setInRecorduuid(recorduuid);
    	  monSetPerDO.setSetDate(new Date());
    	  //报销类别:定点医疗机构全部传“0”
    	  monSetPerDO.setReimbType(StringUtils.isBlank(personAmountInfo.getReceiptNum())?"0":personAmountInfo.getReceiptNum());
    	  monSetPerDO.setIsAccountUse(isAccountUse);
    	  //monSetPerDO.set
    	  
      }
      //---------------------------结算时结算信息插入以及更新结算状态--end----------------------------------
    }
    return result;
  }

  /**
   * 获取传入时间上一个月的最后一天
   * @param feeTime
   * @return
   */
private Date getPreMonthLastDay(Date feeTime) {
	
	String dateToStr = DateFormatUtil.dateToStr(feeTime, DateFormatUtil.DATE_FORMAT_YYYY_MM_DD);
	//先获取月第一天
	Date monthFirstDay = DateFormatUtil.getMonthFirstDay(dateToStr);
	Calendar instance = Calendar.getInstance();
	instance.setTime(monthFirstDay);
	//向前减一天
	instance.add(Calendar.DAY_OF_MONTH, -1);
	Date time = instance.getTime();
	//获取当天的最后时刻
	Date dayLastTime = DateFormatUtil.getDayLastTime(time);
	return dayLastTime;
	
}

/**
   * 非账户支付时计算个人结算信息
   * @param result
   * @param settleForPerson
   */
public void settleForPersonNoAccount(PersonCostAccount result, PersonCostAccount settleForPerson) {
	BigDecimal nurseTotalAmount = bigDecimalNullToZero(settleForPerson.getNurseTotalAmount());
	BigDecimal siPay = bigDecimalNullToZero(settleForPerson.getSiPay());
	BigDecimal paySelf = bigDecimalNullToZero(settleForPerson.getPaySelf());
	BigDecimal expenseSelf = bigDecimalNullToZero(settleForPerson.getExpenseSelf());
	BigDecimal overCost = bigDecimalNullToZero(settleForPerson.getOverCost());
	
	//总费用、统筹支出、个人自付、个人自费、超限额
	result.setNurseTotalAmount(nurseTotalAmount);
	result.setSiPay(siPay);
	result.setPaySelf(paySelf);
	result.setExpenseSelf(expenseSelf);
	result.setOverCost(overCost);
	
	//非医保结算,医保账户支付为0
	result.setMediAccountExpense(BigDecimal.valueOf(0));
	//现金支付为个人自付+个人自费
	result.setCashExpense(paySelf.add(expenseSelf));
	
}
private BigDecimal bigDecimalNullToZero(BigDecimal bigDecimal){
	if(bigDecimal == null){
		return BigDecimal.valueOf(0);
	}
	return bigDecimal;
}
}
