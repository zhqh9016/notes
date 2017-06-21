package com.taikang.dic.ltci.service.impl;

import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.common.enumeration.ActionTypeEnum;
import com.taikang.dic.ltci.common.enumeration.ModuleCodeEnum;
import com.taikang.dic.ltci.common.enumeration.OperationTypeEnum;
import com.taikang.dic.ltci.common.enumeration.TransportTypeEnum;
import com.taikang.dic.ltci.common.exception.ThrowsException;
import com.taikang.dic.ltci.common.util.DateFormat;
import com.taikang.dic.ltci.common.util.IPUtil;
import com.taikang.dic.ltci.dao.IGenericDAO;
import com.taikang.dic.ltci.dao.IMqFailMessageLogDAO;
import com.taikang.dic.ltci.dao.ServiceItemDAO;
import com.taikang.dic.ltci.model.BaseModel;
import com.taikang.dic.ltci.model.MqFailMessageLogDO;
import com.taikang.dic.ltci.model.ServiceItemDO;
import com.taikang.dic.ltci.model.ServiceItemDOExample;
import com.taikang.dic.ltci.model.ServiceItemDOExample.Criteria;
import com.taikang.dic.ltci.mqmodel.MQServiceItemModel;
import com.taikang.dic.ltci.mqmodel.MqBaseModel;
import com.taikang.dic.ltci.service.AbstractGenericService;
import com.taikang.dic.ltci.service.IMqMessageLogService;
import com.taikang.dic.ltci.service.IServiceItemService;
import com.taikang.dic.ltci.service.ServiceException;
import com.taikang.dic.ltci.service.WSService;

@Service
public class ServiceItemServiceImpl extends AbstractGenericService<ServiceItemDO, String>
    implements IServiceItemService {

  private static final Logger logger = LoggerFactory.getLogger(ServiceItemServiceImpl.class);

  @Value("${ltci.serviceItem.queue}")
  private String serviceItemQ;

  @Value("${ltci.serviceItem.exechange}")
  private String exechange;

  @Value("${ltci.sendServiceItem.messageCode}")
  private String messageCode;

  @Value("${service.item.cityId}")
  private String cityId;

  @Autowired private ServiceItemDAO serviceItemDAO;

  @Autowired private IMqFailMessageLogDAO mqFailMessageLogDAO;

  @Autowired private WSService wsService;

  @Autowired private IMqMessageLogService mqMessageLogService;

  @Override
  public IGenericDAO<ServiceItemDO, String> getDao() {
    return serviceItemDAO;
  }

  @Override
  public int putServiceItemMessage(String id, Integer valid) {
    ServiceItemDO serviceItemDo = serviceItemDAO.selectByPrimaryKey(id);
    MQServiceItemModel mqModel = new MQServiceItemModel();
    // ID
    mqModel.setId(serviceItemDo.getId());
    // 行政区域
    mqModel.setProvinceCode(cityId);
    // 服务项目编码
    mqModel.setMedicareCode(serviceItemDo.getServiceCode());
    // 服务项目类型
    mqModel.setMedicareType(serviceItemDo.getServiceType());
    // 服务项目名称
    mqModel.setMedicareName(serviceItemDo.getServiceName());
    // 费用类别
    mqModel.setChargeType(serviceItemDo.getChargeType());
    // 收费项目等级
    mqModel.setChargeLevel(serviceItemDo.getChargeLevel());
    // 服务频次
    mqModel.setServiceFrequency(serviceItemDo.getFrequency());
    // 服务项目持续时间
    mqModel.setMedicareHours(serviceItemDo.getTaskTime());
    // 服务项目内涵
    mqModel.setMedicarecontent(serviceItemDo.getDescription());
    // 生效开始时间
    mqModel.setValidStartDate(serviceItemDo.getStartTime());
    // 生效结束时间
    mqModel.setValidEndDate(serviceItemDo.getEndTime());
    // 单价
    mqModel.setUnitPrice(serviceItemDo.getPrice());
    // 最高限价
    mqModel.setMaximumPrice(serviceItemDo.getLimitPrice());
    // 统筹区
    mqModel.setSiArea(serviceItemDo.getSiArea());
    // 经办人
    mqModel.setOperator(serviceItemDo.getOperatedBy());
    // 经办日期
    mqModel.setOperatorDate(serviceItemDo.getOperatedTime());
    // 状态
    mqModel.setValid(valid);

    //封装MqBaseModel信息
    MqBaseModel mqBaseModel = new MqBaseModel();
    mqBaseModel.setBusinessSerialid(UUID.randomUUID().toString());
    mqBaseModel.setTimestamp(DateFormat.getLocalDateTime());
    try {
      mqBaseModel.setNodeIP(IPUtil.getLocalIp());
    } catch (Exception e) {
      logger.error("错误信息：" + e);
      throw new ThrowsException("获取本地IP失败！");
    }
    mqBaseModel.setSystemCode(systemCode);
    mqBaseModel.setModuleCode(ModuleCodeEnum.SEND_SERVICE_ITEM.getValue());
    mqBaseModel.setMessageCode(messageCode);
    mqBaseModel.setData(mqModel);
    String message = JSONObject.toJSONString(mqBaseModel);
    try {
      sendMessage(exechange, serviceItemQ, message.getBytes(systemCharset));
      logger.debug("send message content:" + message);
      mqMessageLogService.sendMqMessageLog(
          mqBaseModel.getBusinessSerialid(), 1L, "0", message, exechange, serviceItemQ);
    } catch (UnsupportedEncodingException e) {
      logger.error(e.getMessage(), e);
      MqFailMessageLogDO failMessageLog = new MqFailMessageLogDO();
      failMessageLog.setId(mqBaseModel.getBusinessSerialid().replaceAll("-", ""));
      failMessageLog.setTransportType(TransportTypeEnum.ASYNCHRONIZE.getValue()); //交互方式：异步
      failMessageLog.setOperationType(OperationTypeEnum.SEND.getValue()); //发送接收类型
      failMessageLog.setQueryName(serviceItemQ);
      failMessageLog.setExchangeName(exechange);
      failMessageLog.setContent(message);
      failMessageLog.setErrorMessage(e.getMessage());
      failMessageLog.setCreateTime(new Date());
      failMessageLog.setHttpAction(HttpMethod.POST.name());
      mqFailMessageLogDAO.insert(failMessageLog);
    }
    return 1;
  }

  /**
   * 按条件分页查询护理目录列表
   *
   * @param ItemDTO 查询条件
   * @param page 当前页码
   * @param pageSize 每页显示件数
   * @return 护理目录查询信息列表
   */
  @Override
  public Map<String, Object> listItem(
      String serviceCode,
      String serviceName,
      String serviceType,
      String chargeType,
      String chargeLevel,
      String isValid,
      int page,
      int pageSize) {
    ServiceItemDOExample example = new ServiceItemDOExample();
    Criteria c = example.createCriteria();
    // 如果服务项目编码不为空
    if (!StringUtils.isEmpty(serviceCode)) {
      c.andServiceCodeEqualTo(serviceCode);
    }
    // 如果服务项目名称不为空
    if (!StringUtils.isEmpty(serviceName)) {
      c.andServiceNameLike("%" + serviceName + "%");
    }
    //如果项目类型不为空
    if (!StringUtils.isEmpty(serviceType)) {
      c.andServiceTypeEqualTo(Integer.parseInt(serviceType));
    }
    //如果费用类型不为空
    if (!StringUtils.isEmpty(chargeType)) {
      c.andChargeTypeEqualTo(chargeType);
    }
    //如果收费项目等级不为空
    if (!StringUtils.isEmpty(chargeLevel)) {
      c.andChargeLevelEqualTo(chargeLevel);
    }
    //有效标示
    if (!StringUtils.isEmpty(isValid)) {
      c.andIsValidEqualTo(Integer.parseInt(isValid));
    }

    int count = serviceItemDAO.countByExample(example);

    int pageIndex = (page - 1) * pageSize;
    int totalPage = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;

    example.setOrderByClause(" created_time desc  limit " + pageIndex + " , " + pageSize + " ");
    List<ServiceItemDO> itemDoList = serviceItemDAO.selectByExample(example);

    Map<String, Object> model = new HashMap<>();
    model.put("page", page);
    model.put("pageSize", pageSize);
    model.put("totalDataNum", count);
    model.put("totalPageNum", totalPage);
    model.put("itemDoList", itemDoList);
    return model;
  }

  /* 护理目录添加 */
  @Override
  @Transactional
  public boolean saveItem(ServiceItemDO itemDO) throws ServiceException {
    // 设置主键
    itemDO.setId(UUID.randomUUID().toString().replace("-", ""));
    // 创建时间
    itemDO.setCreatedTime(new Date());
    // 经办时间
    itemDO.setOperatedTime(new Date());
    // 生成随机数
    SecureRandom random = new SecureRandom();
    int res = random.nextInt(1000000);
    String s = Integer.toString(res);
    itemDO.setServiceCode(s);
    // 删除标识
    itemDO.setIsValid(BaseModel.IsValid.VALID.getValue());
    int i = serviceItemDAO.insertSelective(itemDO);
    if (i <= 0) {
      throw new ServiceException(500, "添加护理目录失败");
    }
    //服务项目推送（第三方）
    pushServiceItem(itemDO.getId());
    putServiceItemMessage(itemDO.getId(), ActionTypeEnum.CREATE.getValue());
    return true;
  }

  /*护理目录删除*/
  @Override
  @Transactional
  public boolean deleteItem(String id) throws ServiceException {
    // 用户删除标识更新为1
    ServiceItemDO userDo = new ServiceItemDO();
    userDo.setId(id);
    userDo.setIsValid(BaseModel.IsValid.INVALID.getValue());
    userDo.setOperatedTime(new Date());
    int i = serviceItemDAO.updateByPrimaryKeySelective(userDo);
    if (i <= 0) {
      throw new ServiceException(500, "删除护理目录失败");
    }
    //    putServiceItemMessage(id, ActionTypeEnum.DELETE.getValue());
    return true;
  }

  /*护理目录修改*/
  @Override
  @Transactional
  public boolean updateItem(ServiceItemDO itemDO) throws ServiceException {
    int i = serviceItemDAO.updateByPrimaryKeySelective(itemDO);
    if (i <= 0) {
      throw new ServiceException(500, "编辑护理目录失败");
    }
    //服务项目推送（第三方）
    pushServiceItem(itemDO.getId());
    putServiceItemMessage(itemDO.getId(), ActionTypeEnum.UPDATE.getValue());
    return true;
  }

  /*
   * 服务项目推送
   * 交互方式webservice
   */
  @Override
  public boolean pushServiceItem(String serviceItemId) {
    logger.info("______begin pushServiceItem: serviceItemId=" + serviceItemId);
    ServiceItemDOExample example = new ServiceItemDOExample();
    boolean b = true;
    Criteria c = example.createCriteria();
    //如果推送项目ID不为空
    if (!StringUtils.isEmpty(serviceItemId)) {
      c.andIdEqualTo(serviceItemId);
    }
    List<ServiceItemDO> serviceItemDOList = serviceItemDAO.selectByExample(example);
    for (ServiceItemDO serviceItem : serviceItemDOList) {
      b = wsService.pushServiceProject(serviceItem);
    }
    return b;
  }

  /*通过ID 删除数据*/
  @Override
  public ServiceItemDO getItem(String id) {
    return serviceItemDAO.selectByPrimaryKey(id);
  }

  /**
   * 查询服务项目名称是否存在
   *
   * @param serviceName
   */
  @Override
  public List<ServiceItemDO> getServiceName(String serviceName) {
    ServiceItemDOExample example = new ServiceItemDOExample();
    Criteria c = example.createCriteria();
    c.andIsValidEqualTo(BaseModel.IsValid.VALID.getValue());
    c.andServiceNameEqualTo(serviceName);
    return serviceItemDAO.selectByExample(example);
  }
}
