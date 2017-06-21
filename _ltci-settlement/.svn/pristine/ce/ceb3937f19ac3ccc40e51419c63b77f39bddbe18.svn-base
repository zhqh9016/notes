package com.taikang.dic.ltci.service.impl;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.netflix.ribbon.proxy.annotation.Http.HttpMethod;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.ConstantUtil;
import com.taikang.dic.ltci.common.IsValidEnum;
import com.taikang.dic.ltci.common.enumeration.ModuleCodeEnum;
import com.taikang.dic.ltci.common.enumeration.OperationTypeEnum;
import com.taikang.dic.ltci.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.common.enumeration.TransportTypeEnum;
import com.taikang.dic.ltci.common.util.DateFormatUtil;
import com.taikang.dic.ltci.common.util.SpringContextUtil;
import com.taikang.dic.ltci.common.util.UUIDUtil;
import com.taikang.dic.ltci.dao.CustomNurseDetailDAO;
import com.taikang.dic.ltci.dao.DaySetPerDAO;
import com.taikang.dic.ltci.dao.IGenericDAO;
import com.taikang.dic.ltci.dao.IMqFailMessageLogDAO;
import com.taikang.dic.ltci.dao.INurseDetailDAO;
import com.taikang.dic.ltci.dao.INurseDetailLogDAO;
import com.taikang.dic.ltci.model.BaseModel;
import com.taikang.dic.ltci.model.DaySetPerDO;
import com.taikang.dic.ltci.model.DaySetPerDOExample;
import com.taikang.dic.ltci.model.InsuredPersonDO;
import com.taikang.dic.ltci.model.MqFailMessageLogDO;
import com.taikang.dic.ltci.model.NurseDetailDO;
import com.taikang.dic.ltci.model.NurseDetailDOExample;
import com.taikang.dic.ltci.model.NurseDetailDOExample.Criteria;
import com.taikang.dic.ltci.model.NurseDetailLogDO;
import com.taikang.dic.ltci.mqmodel.MQNurseDetailModel;
import com.taikang.dic.ltci.mqmodel.MqBaseModel;
import com.taikang.dic.ltci.service.AbstractGenericService;
import com.taikang.dic.ltci.service.IMqMessageLogService;
import com.taikang.dic.ltci.service.INurseDetailService;
import com.taikang.dic.ltci.service.WSService;
import com.taikang.dic.ltci.serviceClient.InsuredPersonServerClient;

/**
 * 护理明细服务实现类
 *
 * @author longfei04 E-mail:
 * @version 创建时间：2017年4月13日 下午2:48:58
 */
@Service
public class NurseDetailServiceImpl extends AbstractGenericService<NurseDetailDO, String>
    implements INurseDetailService {

  private static final Logger logger = LoggerFactory.getLogger(NurseDetailServiceImpl.class);

  @Value("${ltci.mursedetail.queue}")
  private String murseDetailQ;

  @Value("${ltci.nurse.exechange}")
  private String exechange;

  @Value("${ltci.mursedetail.messageCode}")
  private String messageCode;

  @Value("${ltci.murseDetailBack.queue}")
  private String murseBackQ;

  @Value("${ltci.murseDetailBack.exechange}")
  private String murseBackExechange;

  @Value("${ltci.murseDetailBack.messageCode}")
  private String murseBackMessageCode;

  @Autowired protected INurseDetailDAO nerseDetailDAO;

  @Autowired protected INurseDetailLogDAO nerseDetailLogDAO;

  @Autowired private CustomNurseDetailDAO customNurseDetailDAO;

  @Autowired private DaySetPerDAO daySetPerDAO;

  @Autowired private IMqFailMessageLogDAO mqFailMessageLogDAO;

  @Autowired private WSService wsService;

  @Autowired IMqMessageLogService mqMessageLogService;

  @Autowired private SpringContextUtil springContextUtil;

  @Autowired private InsuredPersonServerClient insuredPersonServerClient;

  @Override
  public IGenericDAO<NurseDetailDO, String> getDao() {
    return nerseDetailDAO;
  }

  /** 该方法由系统自动启动侦听，系统启动时如果AMQ中有消息自动进行处理 */
  @Override
  @RabbitListener(queues = "${ltci.mursedetail.queue}")
  public void receiveMessage(byte[] bytes) {
    String message = null;
    try {
      message = new String(bytes, systemCharset);
    } catch (UnsupportedEncodingException e) {
      logger.error(e.getMessage(), e);
      return;
    }
    logger.debug("receive message content:" + message);
    NurseDetailLogDO nurseDetailLog = null;
    NurseDetailDO nurseDetail = null;

    List<NurseDetailDO> nerseDetails = new ArrayList<>();
    try {
      JSONObject root = JSONObject.parseObject(message);
      nurseDetailLog = packagingNerseDetailLog(root);
      nurseDetailLog.setCreatedTime(new Date());
      JSONObject data = root.getJSONObject(ConstantUtil.DATA);
      JSONArray nursingDetails = data.getJSONArray(ConstantUtil.NURSING_DETAILS);

      for (int i = 0; i < nursingDetails.size(); i++) {
        JSONObject nersingDetail = nursingDetails.getJSONObject(i);
        nurseDetail = packagingNurseDetail(nersingDetail);
        //根据参保人的唯一标识获取参保人所在的经办区域
        fillOperatedOrg(nurseDetail);
        //根据交易流水号来保证消息幂等性，并且消息幂等性不在事物中进行判断，缩短事物方法时间
        NurseDetailDOExample example = new NurseDetailDOExample();
        Criteria createCriteria = example.createCriteria();
        createCriteria.andTradeNumEqualTo(nurseDetail.getTradeNum());
        List<NurseDetailDO> _nurseDetails = nerseDetailDAO.selectByExample(example);
        if (_nurseDetails != null && !_nurseDetails.isEmpty()) {
          logger.warn("个人费用明细交易流水号[" + nurseDetail.getTradeNum() + "]重复,本次不做处理");
        } else {
          nerseDetails.add(nurseDetail);
        }
      }
      //如果消息条数和总条数不能对应，则该条记录为异常记录，但是没有问题的详细记录已经入库，需要人
      if (nurseDetailLog.getDetailNum() != nursingDetails.size()) {
        nurseDetailLog.setExceptionFlag(ConstantUtil.IS_EXCEPTION);
      } else {
        nurseDetailLog.setExceptionFlag(ConstantUtil.IS_NOT_EXCEPTION);
      }
      nurseDetailLog.setMessageContent(message);

      NurseDetailServiceImpl nerseDetailServiceImpl =
          springContextUtil.getApplicationContext().getBean(NurseDetailServiceImpl.class);
      nerseDetailServiceImpl.saveNerseDetailMessage(nurseDetailLog, nerseDetails);

      //上传明细到第三方（社保）
      uploadDetailToThirdParty(nerseDetails);

    } catch (Exception e) {
      logger.error(ConstantUtil.PARSE_MESSAGE_ERROR + message, e);
      nurseDetailLog = new NurseDetailLogDO();
      nurseDetailLog.setId(BaseModel.getUUID());
      nurseDetailLog.setExceptionFlag(ConstantUtil.IS_EXCEPTION);
      nurseDetailLog.setMessageContent(message);
      nerseDetailLogDAO.insertSelective(nurseDetailLog);
    }
  }

  private void fillOperatedOrg(NurseDetailDO nurseDetail) {
    InsuredPersonDO ido = getInsuredPerson(nurseDetail.getBeCarePersonCard());
    if (ido != null) {
      nurseDetail.setOperatedOrg(
          ido.getOperatedOrg() == null ? BaseModel.DEFAULT_ORG_CODE : ido.getOperatedOrg());
      nurseDetail.setOperatedBy(
          ido.getOperatedBy() == null ? BaseModel.DEFAULT_ORG_CODE : ido.getOperatedBy());
      nurseDetail.setSiArea(ido.getSiArea() == null ? BaseModel.DEFAULT_ORG_CODE : ido.getSiArea());
      nurseDetail.setOperatedTime(new Date());
    } else {
      nurseDetail.setOperatedOrg(BaseModel.DEFAULT_ORG_CODE);
      nurseDetail.setOperatedBy(BaseModel.DEFAULT_ORG_CODE);
      nurseDetail.setSiArea(BaseModel.DEFAULT_ORG_CODE);
      nurseDetail.setOperatedTime(new Date());
    }
  }

  /**
   * 获取参保人经办机构编码
   *
   * @param idCardNo 身份证号码
   * @return
   */
  private InsuredPersonDO getInsuredPerson(String idCardNo) {
    InsuredPersonDO ido = null;
    try {
      ResultDTO result = insuredPersonServerClient.getInsuredPersonDetail("", idCardNo, "");
      logger.debug("___获取参保人经办机构编码=" + (result != null ? JSONObject.toJSONString(result) : ""));
      if (result != null && StatusCodeEnum.OK.getValue().equals(result.getStatus())) {
        Object datas = result.getDatas();
        ido = JSONObject.parseObject(JSONObject.toJSONString(datas), InsuredPersonDO.class);
      }
    } catch (Exception e) {
      logger.error("根据身份证号获取参保人经办机构编码失败" + e.getMessage(), e);
    }
    return ido;
  }

  @Transactional
  public void saveNerseDetailMessage(
      NurseDetailLogDO nurseDetailLog, List<NurseDetailDO> nurseDetails) {
    nerseDetailLogDAO.insertSelective(nurseDetailLog);
    for (NurseDetailDO nurseDetail : nurseDetails) {
      nurseDetail.setCreatedTime(new Date());
      nurseDetail.setIsSynForSocial(ConstantUtil.IS_SYSN_FAIL);
      nurseDetail.setIsSysForOrg(ConstantUtil.IS_SYSN_PENDING);
      nurseDetail.setIsValid(IsValidEnum.NO_DELETE.getValue());
      nurseDetail.setOrgCode(nurseDetailLog.getOrgCode());
      nurseDetail.setOrgName(nurseDetailLog.getOrgName());
      nerseDetailDAO.insertSelective(nurseDetail);
    }
  }

  private NurseDetailDO packagingNurseDetail(JSONObject nerseDetail) {
    NurseDetailDO nurseDetail = new NurseDetailDO();
    nurseDetail.setCreatedTime(new Date());
    nurseDetail.setId(BaseModel.getUUID());
    nurseDetail.setInRecorduuid(nerseDetail.getString(ConstantUtil.RECORD_UUID));
    nurseDetail.setSocSecNum(nerseDetail.getString(ConstantUtil.SOC_SEC_NUM));
    nurseDetail.setBeCarePersonName(nerseDetail.getString(ConstantUtil.BE_CARE_PERSON_NAME));
    nurseDetail.setBeCarePersonCard(nerseDetail.getString(ConstantUtil.BE_CARE_PERSON_CARD));
    nurseDetail.setBuildingNo(nerseDetail.getString(ConstantUtil.BUILDING_NO));
    nurseDetail.setRoomNo(nerseDetail.getString(ConstantUtil.ROOM_NO));
    nurseDetail.setDiseaseArea(nerseDetail.getString(ConstantUtil.DISEASE_AREA));
    nurseDetail.setBedNum(nerseDetail.getString(ConstantUtil.BED_NUM));
    nurseDetail.setProjectType(nerseDetail.getString(ConstantUtil.PROJECT_TYPE));
    nurseDetail.setChargeType(nerseDetail.getString(ConstantUtil.CHARGE_TYPE));
    nurseDetail.setMedicalType(nerseDetail.getString(ConstantUtil.MEDICAL_TYPE));
    Boolean b = nerseDetail.getBoolean(ConstantUtil.IS_RELATIVE_CARE);
    Integer isRelativeCare = 0;
    if (b != null && b == true) isRelativeCare = 1;
    nurseDetail.setIsRelativeCare(isRelativeCare);
    nurseDetail.setTradeNum(nerseDetail.getString(ConstantUtil.TRADE_NUM));
    nurseDetail.setMedicareCode(nerseDetail.getString(ConstantUtil.MEDICARE_CODE));
    nurseDetail.setMedicareName(nerseDetail.getString(ConstantUtil.MEDICARE_NAME));
    nurseDetail.setCareOrgServiceCode(nerseDetail.getString(ConstantUtil.CARE_ORG_SERVICE_CODE));
    nurseDetail.setCareOrgServiceName(nerseDetail.getString(ConstantUtil.CARE_ORG_SERVICE_NAME));
    nurseDetail.setFeeDate(nerseDetail.getDate(ConstantUtil.FEE_DATE));
    nurseDetail.setPrice(nerseDetail.getBigDecimal(ConstantUtil.PRICE));
    nurseDetail.setCount(nerseDetail.getDouble(ConstantUtil.COUNT));
    nurseDetail.setAmount(nerseDetail.getBigDecimal(ConstantUtil.AMOUNT));
    nurseDetail.setManHour(nerseDetail.getInteger(ConstantUtil.MAN_HOUR));
    nurseDetail.setNurseCode(nerseDetail.getString(ConstantUtil.NURSE_CODE));
    nurseDetail.setNurseTime(nerseDetail.getDate(ConstantUtil.NURSE_TIME));
    nurseDetail.setNurseName(nerseDetail.getString(ConstantUtil.NURSE_NAME));
    nurseDetail.setChargePersonCd(nerseDetail.getString(ConstantUtil.CHARGE_PERSON_CODE));
    nurseDetail.setChargePersonName(nerseDetail.getString(ConstantUtil.CHARGE_PERSON_NAME));
    nurseDetail.setChargeDeptCd(nerseDetail.getString(ConstantUtil.CHARGE_DEPT_CODE));
    return nurseDetail;
  }

  private NurseDetailLogDO packagingNerseDetailLog(JSONObject root) {
    NurseDetailLogDO nerseDetailLog = new NurseDetailLogDO();
    nerseDetailLog.setId(BaseModel.getUUID());
    nerseDetailLog.setBusinessSerialid(root.getString(ConstantUtil.BUSINESS_SERIALID));
    nerseDetailLog.setSysCode(root.getString(ConstantUtil.SYS_CODE));
    nerseDetailLog.setModuleCode(root.getString(ConstantUtil.MODULE_CODE));
    nerseDetailLog.setNodeIp(root.getString(ConstantUtil.NODE_IP));
    nerseDetailLog.setSendTime(new Date());

    JSONObject data = root.getJSONObject(ConstantUtil.DATA);

    nerseDetailLog.setMessageCode(data.getString(ConstantUtil.MESSAGE_CODE));
    nerseDetailLog.setOrgCode(data.getString(ConstantUtil.ORG_CODE));
    nerseDetailLog.setOrgName(data.getString(ConstantUtil.ORG_NAME));
    nerseDetailLog.setSendTime(new Date(data.getLongValue(ConstantUtil.SEND_TIME)));
    nerseDetailLog.setDetailNum(data.getInteger(ConstantUtil.DETAIL_COUNT));
    nerseDetailLog.setCreatedTime(new Date());
    return nerseDetailLog;
  }

  @Override
  public int putNurseDetailMessage(String message) {
    logger.info("message:" + message);
    byte[] bytes;
    try {
      bytes = message.toString().getBytes(systemCharset);
      sendMessage(exechange, murseDetailQ, bytes);
    } catch (UnsupportedEncodingException e) {
      logger.error(e.getMessage(), e);
      return 0;
    }
    return 1;
  }

  /** 个人护理费用明细 */
  @Override
  public Map<String, Object> listPersonNurseDetail(
      String orgCode,
      String inRecorduuid,
      String beCarePersonCard,
      String feeBeginDate,
      String feeEndDate,
      int page,
      int pageSize) {
    NurseDetailDOExample example = new NurseDetailDOExample();
    Criteria c = example.createCriteria();
    //机构名称
    if (!StringUtils.isEmpty(orgCode)) {
      c.andOrgCodeEqualTo(orgCode);
    }
    //入住记录唯一编号
    if (!StringUtils.isEmpty(inRecorduuid)) {
      c.andInRecorduuidEqualTo(inRecorduuid);
    }
    //护理对象证件号
    if (!StringUtils.isEmpty(beCarePersonCard)) {
      c.andBeCarePersonCardEqualTo(beCarePersonCard);
    }
    //费用发生日期
    if (!StringUtils.isEmpty(feeBeginDate)) {
      c.andFeeDateBetween(
          DateFormatUtil.getDayFirstTime(feeBeginDate), DateFormatUtil.getDayLastTime(feeEndDate));
    }
    // 删除标识
    c.andIsValidEqualTo(IsValidEnum.NO_DELETE.getValue());
    int count = nerseDetailDAO.countByExample(example);
    int pageIndex = (page - 1) * pageSize;
    int totalPage = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
    example.setOrderByClause(" created_time desc  limit " + pageIndex + " , " + pageSize + " ");
    List<NurseDetailDO> nurseDetailDoList = nerseDetailDAO.selectByExample(example);

    Map<String, Object> model = new HashMap<>();
    model.put("page", page);
    model.put("pageSize", pageSize);
    model.put("totalDataNum", count);
    model.put("totalPageNum", totalPage);
    model.put("nurseDetailDoList", nurseDetailDoList);
    return model;
  }

  /** */
  @Override
  public void countDaySetPer(String socSecNum, Date feeDate, String orgCode) {
    logger.info(
        "______begin countDaySetPer___param: feiDate="
            + feeDate
            + ";socSecNum="
            + socSecNum
            + ";orgCode="
            + orgCode);
    //如果费用时间没有传,那么默认时间为前一天
    if (feeDate == null) {
      Calendar instance = Calendar.getInstance();
      instance.add(Calendar.DAY_OF_YEAR, -1);
      feeDate = instance.getTime();
    }
    //查询条件信息
    Map<String, String> parameters = createParamByFeeDate(feeDate);

    //根据socSecNum字段判断是统计单个人的日结信息,还是统计所有人的
    //如果没有指定个人社保号码,那么统计指定时间内所有机构所有人的个人日结信息
    if (StringUtils.isNotBlank(socSecNum) && checkIsSynForSocial(socSecNum, feeDate)) {
      //检查指定人员,指定时间和社保之间的上传状态,如果个人指定时间存在不成功的上传,那么不统计个人日结信息
      parameters.put("socSecNum", socSecNum);
      List<DaySetPerDO> countDaySetPer = customNurseDetailDAO.countDaySetPer(parameters);
      boolean flag =
          checkDaySetPerUnique(
              countDaySetPer.get(0).getSocSecNum(),
              feeDate,
              countDaySetPer.get(0).getInRecorduuid());
      //判断指定用户指定日期的日结信息是否已经被统计
      if (!CollectionUtils.isEmpty(countDaySetPer) && flag) {
        DaySetPerDO result = countDaySetPer.get(0);
        //填充物理ID和业务ID,并指定经办时间
        result.setFeeDate(DateFormatUtil.getDayFirstTime(feeDate));
        genericDaySetPerFields(result);
        daySetPerDAO.insertSelective(result);
        //将个人日结业务ID会写到服务明细表中
        writeBackDaySetIdForNurseDetail(result);
      }
      return;
    }

    //统计指定日期所有人的日结信息
    parameters.put("orgCode", orgCode);
    List<DaySetPerDO> countDaySetPer = customNurseDetailDAO.countDaySetPer(parameters);
    //获取指定日期存在未将服务明细上传给社保的人的信息
    List<String> unSynPers = getUnSynForSocialPers(feeDate);
    //保存统计信息,排除服务明细未上传到社保的个人日结信息
    if (!CollectionUtils.isEmpty(countDaySetPer)) {
      for (DaySetPerDO daySetper : countDaySetPer) {
        //日结信息入库时,检查是否存在未上传的服务明细
        if (unSynPers.contains(daySetper.getSocSecNum() + daySetper.getInRecorduuid())) continue;
        boolean flag =
            checkDaySetPerUnique(daySetper.getSocSecNum(), feeDate, daySetper.getInRecorduuid());
        if (flag) {
          //填充物理ID和业务ID,并指定经办时间
          daySetper.setFeeDate(DateFormatUtil.getDayFirstTime(feeDate));
          genericDaySetPerFields(daySetper);
          daySetPerDAO.insertSelective(daySetper);
          //将个人日结业务ID会写到服务明细表中
          writeBackDaySetIdForNurseDetail(daySetper);
        }
      }
    }
  }

  //将个人日结业务ID回写到服务明细表中
  private void writeBackDaySetIdForNurseDetail(DaySetPerDO result) {
    //构建更新对象
    NurseDetailDO record = new NurseDetailDO();
    record.setFeeSetCode(result.getFeeSetCode());
    //构建更新条件
    String socSecNum = result.getSocSecNum();
    Date feeDate = result.getFeeDate();

    NurseDetailDOExample example = new NurseDetailDOExample();
    Criteria criteria = example.createCriteria();
    criteria.andSocSecNumEqualTo(socSecNum);

    Date firstTime = DateFormatUtil.getDayFirstTime(feeDate);
    Date lastTime = DateFormatUtil.getDayLastTime(feeDate);

    criteria.andFeeDateBetween(firstTime, lastTime);
    //执行更新
    nerseDetailDAO.updateByExampleSelective(record, example);
  }

  /**
   * 判断指定用户指定日期是否已存在日结记录
   *
   * @param socSecNum
   * @param feeDate
   * @param inRecorduuid
   * @return
   */
  private boolean checkDaySetPerUnique(String socSecNum, Date feeDate, String inRecorduuid) {
    //计算费用开始时间和结束时间
    Date firstTime = DateFormatUtil.getDayFirstTime(feeDate);
    Date lastTime = DateFormatUtil.getDayLastTime(feeDate);
    //构建查询条件
    DaySetPerDOExample example = new DaySetPerDOExample();
    com.taikang.dic.ltci.model.DaySetPerDOExample.Criteria createCriteria =
        example.createCriteria();

    createCriteria.andSocSecNumEqualTo(socSecNum);
    createCriteria.andFeeDateBetween(firstTime, lastTime);
    //执行查询
    List<DaySetPerDO> selectByExample = daySetPerDAO.selectByExample(example);
    //如果没有查出结果说明该用户该日期没有日结记录
    if (CollectionUtils.isEmpty(selectByExample)) {
      return true;
    }
    return false;
  }

  /**
   * 初始化日结信息
   *
   * @param daySetper
   */
  private void genericDaySetPerFields(DaySetPerDO daySetper) {
    Date feeDate = daySetper.getFeeDate();
    daySetper.setId(UUIDUtil.getUUID());
    daySetper.setFeeSetCode(UUIDUtil.getUUID());
    daySetper.setCreatedTime(new Date());
    daySetper.setOperatedTime(new Date());
    //日结记录中护理时间取费用时间
    daySetper.setNurseTime(daySetper.getFeeDate());
    NurseDetailDOExample example = new NurseDetailDOExample();
    Criteria createCriteria = example.createCriteria();
    createCriteria.andSocSecNumEqualTo(daySetper.getSocSecNum());
    createCriteria.andFeeDateBetween(
        DateFormatUtil.getDayFirstTime(feeDate), DateFormatUtil.getDayLastTime(feeDate));
    List<NurseDetailDO> selectByExample = nerseDetailDAO.selectByExample(example);
    if (!CollectionUtils.isEmpty(selectByExample)) {
      NurseDetailDO nurseDetailDO = selectByExample.get(0);
      daySetper.setInRecorduuid(nurseDetailDO.getInRecorduuid());
      daySetper.setOrgCode(nurseDetailDO.getOrgCode());
      daySetper.setOrgName(nurseDetailDO.getOrgName());
      daySetper.setBeCarePersonCard(nurseDetailDO.getBeCarePersonCard());
      daySetper.setCardType(nurseDetailDO.getCardType());
      daySetper.setBeCarePersonName(nurseDetailDO.getBeCarePersonName());
      daySetper.setNurseStyle(Integer.valueOf(nurseDetailDO.getMedicalType()));
      daySetper.setIsValid(IsValidEnum.NO_DELETE.getValue());
      daySetper.setAuditState(ConstantUtil.WAITING_PROCESS);
      daySetper.setPubPayStatus(ConstantUtil.PUB_PAY_STATUS_NO);
      daySetper.setPerPayStatus(ConstantUtil.PER_PAY_STATUS_NO);

      BigDecimal initial = new BigDecimal(0);
      daySetper.setAccountPay(initial);
      daySetper.setBankCardPay(initial);
      daySetper.setUnrFee(initial);
    }
  }

  /**
   * 根据日期构建查询初始条件
   *
   * @param feeDate
   * @return
   */
  private Map<String, String> createParamByFeeDate(Date feeDate) {
    Map<String, String> parameters = new HashMap<>();
    SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String format = formater.format(feeDate);
    Date startTime = DateFormatUtil.getDayFirstTime(format);
    Date endTime = DateFormatUtil.getDayLastTime(format);
    parameters.put("startTime", formater.format(startTime));
    parameters.put("endTime", formater.format(endTime));
    return parameters;
  }

  /**
   * 获取指定日期所有未将服务明细上传到社保的用户
   *
   * @param feeDate
   * @return
   */
  private List<String> getUnSynForSocialPers(Date feeDate) {
    Map<String, String> parameters = createParamByFeeDate(feeDate);
    List<String> socialPers = customNurseDetailDAO.getUnSynForSocialPers(parameters);
    if (socialPers == null) {
      socialPers = new ArrayList<>();
    }
    return socialPers;
  }

  /**
   * 判断指定用户指定日期是否存在服务明细上传到社保端失败的记录
   *
   * @param socSecNum
   * @param feeDate
   * @return
   */
  private boolean checkIsSynForSocial(String socSecNum, Date feeDate) {
    Map<String, String> parameters = createParamByFeeDate(feeDate);
    parameters.put("socSecNum", socSecNum);
    List<String> socialPers = customNurseDetailDAO.getUnSynForSocialPers(parameters);
    if (CollectionUtils.isEmpty(socialPers)) {
      return true;
    }
    return false;
  }

  /**
   * 同步费用明细到第三方
   *
   * @param nerseDetails 费用明细
   */
  public void uploadDetailToThirdParty(List<NurseDetailDO> nerseDetails) {
    logger.info("______begin uploadDetailToThirdParty___");
    long begin = System.currentTimeMillis();
    Date tFeiDate = null;
    String orgCode = null;
    boolean con = false;
    for (NurseDetailDO detail : nerseDetails) {
      tFeiDate = detail.getFeeDate();
      orgCode = detail.getOrgCode();
      NurseDetailDO tdetail = wsService.getNurseFeeDetailAndCalaResult(detail); //调用失败返回null
      if (tdetail == null) {
        detail.setIsSynForSocial(ConstantUtil.IS_SYSN_FAIL);
      } else {
        con = true;
        detail.setIsSynForSocial(ConstantUtil.IS_SYSN_FINISHED);
      }
      nerseDetailDAO.updateByPrimaryKeySelective(detail);
    }
    logger.debug(
        "______uploadDetailToThirdParty___完成第三方费用明细上传，耗时S:"
            + ((System.currentTimeMillis()) - begin) / 1000);
    if (con) { //调用第三方成功后方可日结、回传专业系统
      //调用日结算
      countDaySetPer(null, tFeiDate, orgCode);
      logger.debug(
          "______uploadDetailToThirdParty___完成个人日结算，耗时S:"
              + ((System.currentTimeMillis()) - begin) / 1000);

      logger.debug("___tFeiDate=" + tFeiDate);
      uploadDetailToOrg(
          tFeiDate == null
              ? null
              : DateFormatUtil.dateToStr(tFeiDate, DateFormatUtil.DATE_FORMAT_YYYY_MM_DD),
          ConstantUtil.IS_SYSN_PENDING,
          orgCode);
      logger.debug(
          "______uploadDetailToThirdParty___完成明细回传专业服务系统，耗时S:"
              + ((System.currentTimeMillis()) - begin) / 1000);
    }
    logger.info(
        "______end uploadDetailToThirdParty___耗时S:"
            + ((System.currentTimeMillis()) - begin) / 1000);
  }

  /**
   * 同步费用明细到第三方 1、默认查询前一天（对应字段：费用日期）且待上传(IsSynForSocial待上传到第三方社保)的明细（也可以指定某一天待上传的明细） 2、逐条上传到第三方（社保）
   * 3、根据逐条返回的结果更新明细数据状态 4、容错处理机制：如果有一条明细失败出现三次，这记录失败日志；本次；待人工进行处理；
   *
   * <p>5、调用个人日结算接口，参数个人标识、费用日期，都非必传 6、调用数据同步到专业服务系统
   *
   * @param feiDate 费用日期
   * @param sysnStatus 同步状态
   * @param orgCode 机构码
   */
  public void uploadDetailToThirdParty(String feiDate, Integer sysnStatus, String orgCode) {
    logger.info(
        "______begin uploadDetailToThirdParty___param: feiDate="
            + feiDate
            + ";sysnStatus="
            + sysnStatus
            + ";orgCode="
            + orgCode);
    long begin = System.currentTimeMillis();

    NurseDetailDOExample example = new NurseDetailDOExample();
    Criteria c = example.createCriteria();
    c.andIsValidEqualTo(IsValidEnum.NO_DELETE.getValue());
    Date tFeiDate = null;
    boolean con = false;
    //如果费用日期不为空
    if (!StringUtils.isEmpty(feiDate)) {
      tFeiDate = DateFormatUtil.strToDate(feiDate, "yyyy-MM-dd");
    } else {
      Calendar instance = Calendar.getInstance();
      instance.add(Calendar.DAY_OF_YEAR, -1);
      tFeiDate = instance.getTime();
      feiDate = DateFormatUtil.dateToStr(tFeiDate, "yyyy-MM-dd");
    }
    c.andFeeDateBetween(
        DateFormatUtil.getDayFirstTime(feiDate), DateFormatUtil.getDayLastTime(feiDate));

    if (!StringUtils.isEmpty(orgCode)) {
      c.andOrgCodeEqualTo(orgCode);
    }

    //如果同步状态不为空，并且是有效状态
    if (sysnStatus != null
        && (sysnStatus == ConstantUtil.IS_SYSN_PENDING
            || sysnStatus == ConstantUtil.IS_SYSN_FAIL)) {
      c.andIsSynForSocialEqualTo(sysnStatus);
    } else {
      c.andIsSynForSocialEqualTo(ConstantUtil.IS_SYSN_PENDING);
    }

    int count = nerseDetailDAO.countByExample(example);
    int pageSize = 30; //每次查询30条数据
    int totalPage = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
    for (int i = 1; i <= totalPage; i++) {
      int pageIndex = (i - 1) * pageSize;
      example.setOrderByClause(" created_time asc  limit " + pageIndex + " , " + pageSize + " ");
      List<NurseDetailDO> nurseDetailDoList = nerseDetailDAO.selectByExample(example);

      for (NurseDetailDO detail : nurseDetailDoList) {
        NurseDetailDO tdetail = wsService.getNurseFeeDetailAndCalaResult(detail); //调用失败返回null
        logger.debug("__________________tdetail_" + tdetail);
        if (tdetail == null) {
          detail.setIsSynForSocial(ConstantUtil.IS_SYSN_FAIL);
        } else {
          con = true;
          detail.setIsSynForSocial(ConstantUtil.IS_SYSN_FINISHED);
        }
        nerseDetailDAO.updateByPrimaryKeySelective(detail);
      }
    }
    logger.debug(
        "______uploadDetailToThirdParty___完成第三方费用明细上传，耗时S:"
            + ((System.currentTimeMillis()) - begin) / 1000);
    if (con) { //调用第三方成功后方可日结、回传专业系统
      //调用日结算
      countDaySetPer(null, tFeiDate, orgCode);
      logger.debug(
          "______uploadDetailToThirdParty___完成个人日结算，耗时S:"
              + ((System.currentTimeMillis()) - begin) / 1000);

      uploadDetailToOrg(feiDate, sysnStatus, orgCode);
      logger.debug(
          "______uploadDetailToThirdParty___完成明细回传专业服务系统，耗时S:"
              + ((System.currentTimeMillis()) - begin) / 1000);
    }
    logger.info(
        "______end uploadDetailToThirdParty___耗时S:"
            + ((System.currentTimeMillis()) - begin) / 1000);
  }

  /**
   * 同步费用明细到专业系统 1、默认查询前一天（对应字段：费用日期）已完成第三方上传，且待上传的明细（也可以指定某一天待上传的明细） 2、打包一并上传到专业服务系统MQ
   *
   * @param feiDate 费用日期
   * @param sysnStatus 同步状态
   * @param orgCode 机构码
   */
  public void uploadDetailToOrg(String feiDate, Integer sysnStatus, String orgCode) {
    logger.info(
        "______begin uploadDetailToOrg___param: feiDate="
            + feiDate
            + ";sysnStatus="
            + sysnStatus
            + ";orgCode="
            + orgCode);
    long begin = System.currentTimeMillis();

    NurseDetailDOExample example = new NurseDetailDOExample();
    Criteria c = example.createCriteria();
    c.andIsValidEqualTo(IsValidEnum.NO_DELETE.getValue());
    c.andIsSynForSocialEqualTo(ConstantUtil.IS_SYSN_FINISHED);
    Date tFeiDate = null;
    //如果费用日期不为空
    if (!StringUtils.isEmpty(feiDate)) {
      tFeiDate = DateFormatUtil.strToDate(feiDate, "yyyy-MM-dd");
    } else {
      Calendar instance = Calendar.getInstance();
      instance.add(Calendar.DAY_OF_YEAR, -1);
      tFeiDate = instance.getTime();
      feiDate = DateFormatUtil.dateToStr(tFeiDate, "yyyy-MM-dd");
    }
    c.andFeeDateBetween(
        DateFormatUtil.getDayFirstTime(feiDate), DateFormatUtil.getDayLastTime(feiDate));

    if (!StringUtils.isEmpty(orgCode)) {
      c.andOrgCodeEqualTo(orgCode);
    }
    //如果同步状态不为空，并且是有效状态
    if (sysnStatus != null
        && (sysnStatus == ConstantUtil.IS_SYSN_PENDING
            || sysnStatus == ConstantUtil.IS_SYSN_FAIL)) {
      c.andIsSysForOrgEqualTo(sysnStatus);
    } else {
      c.andIsSysForOrgEqualTo(ConstantUtil.IS_SYSN_PENDING);
    }

    int count = nerseDetailDAO.countByExample(example);
    logger.debug("_____count = " + count);
    int pageSize = 100; //每次查询30条数据
    int totalPage = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
    List<MQNurseDetailModel> list = new ArrayList<MQNurseDetailModel>();
    NurseDetailDOExample texample = example;
    for (int i = 1; i <= totalPage; i++) {
      int pageIndex = (i - 1) * pageSize;
      texample.setOrderByClause(" created_time asc  limit " + pageIndex + " , " + pageSize + " ");
      List<NurseDetailDO> nurseDetailDoList = nerseDetailDAO.selectByExample(texample);
      logger.debug("____nurseDetailDoList=" + nurseDetailDoList.size());
      for (NurseDetailDO ddo : nurseDetailDoList) {
        MQNurseDetailModel model = new MQNurseDetailModel();
        BeanUtils.copyProperties(ddo, model);
        list.add(model);
      }
    }
    if (!list.isEmpty()) {
      //调用mq消息发送接口
      String message = JSONObject.toJSONString(list);
      //sendMessage(exechange, murseDetailQ, message.getBytes());
      putNurseDetailMessage2OrgMq(message);
      //批量更新同步状态
      NurseDetailDO ndo = new NurseDetailDO();
      ndo.setIsSysForOrg(ConstantUtil.IS_SYSN_FINISHED);
      for (MQNurseDetailModel model : list) {
        NurseDetailDOExample exp = new NurseDetailDOExample();
        exp.createCriteria().andTradeNumEqualTo(model.getTradeNum());
        nerseDetailDAO.updateByExampleSelective(ndo, exp);
      }
    }
    logger.info(
        "______end uploadDetailToOrg___耗时S:" + ((System.currentTimeMillis()) - begin) / 1000);
  }

  private void putNurseDetailMessage2OrgMq(Object message) {
    MqBaseModel mqBaseModel =
        new MqBaseModel(
            systemCode,
            ModuleCodeEnum.SEND_NURSE_DETAIL_RESULT.getValue(),
            murseBackMessageCode,
            message);
    String json = JSONObject.toJSONString(mqBaseModel);
    logger.debug("_____putNurseDetailMessage2OrgMq content=" + json);
    mqMessageLogService.sendMqMessageLog(
        mqBaseModel.getBusinessSerialid(), 0L, "0", json, murseBackExechange, murseBackQ);
    try {
      sendMessage(murseBackExechange, murseBackQ, json.getBytes(systemCharset));
    } catch (UnsupportedEncodingException e) {
      logger.error(e.getMessage(), e);
      MqFailMessageLogDO failMessageLog = new MqFailMessageLogDO();
      failMessageLog.setId(mqBaseModel.getBusinessSerialid().replaceAll("-", ""));
      failMessageLog.setTransportType(TransportTypeEnum.ASYNCHRONIZE.getValue()); //交互方式：异步
      failMessageLog.setOperationType(OperationTypeEnum.SEND.getValue()); //发送接收类型
      failMessageLog.setQueryName(murseBackQ);
      failMessageLog.setExchangeName(exechange);
      failMessageLog.setContent(json);
      failMessageLog.setErrorMessage(e.getMessage());
      failMessageLog.setCreateTime(new Date());
      failMessageLog.setHttpAction(HttpMethod.POST.name());
      mqFailMessageLogDAO.insert(failMessageLog);
    }
  }
}
