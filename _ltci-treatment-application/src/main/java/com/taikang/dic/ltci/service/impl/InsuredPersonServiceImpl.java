package com.taikang.dic.ltci.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.api.model.InsuredPersonDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.enumeration.ApplicationStatusEnum;
import com.taikang.dic.ltci.common.enumeration.InHospStateEnum;
import com.taikang.dic.ltci.common.enumeration.IsValidEnum;
import com.taikang.dic.ltci.common.enumeration.NoRreatmentReasonEnum;
import com.taikang.dic.ltci.common.enumeration.NurseTreatmentEnum;
import com.taikang.dic.ltci.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.common.exception.InsertRepeatException;
import com.taikang.dic.ltci.common.exception.NotFoundByIdException;
import com.taikang.dic.ltci.common.exception.ParametersIsNullException;
import com.taikang.dic.ltci.common.exception.ThrowsException;
import com.taikang.dic.ltci.common.utils.DateFormatUtil;
import com.taikang.dic.ltci.common.ws.InsuredInfo;
import com.taikang.dic.ltci.common.ws.TreatmentState;
import com.taikang.dic.ltci.dao.ApplicationDAO;
import com.taikang.dic.ltci.dao.IGenericDAO;
import com.taikang.dic.ltci.dao.InsuredInfoDAO;
import com.taikang.dic.ltci.dao.InsuredPersonDAO;
import com.taikang.dic.ltci.model.ApplicationDO;
import com.taikang.dic.ltci.model.ApplicationDOExample;
import com.taikang.dic.ltci.model.InsuredInfoDO;
import com.taikang.dic.ltci.model.InsuredInfoDOExample;
import com.taikang.dic.ltci.model.InsuredPersonDO;
import com.taikang.dic.ltci.model.InsuredPersonDOExample;
import com.taikang.dic.ltci.model.InsuredPersonDOExample.Criteria;
import com.taikang.dic.ltci.model.OrganizationDO;
import com.taikang.dic.ltci.serverClient.CheckInServerClient;
import com.taikang.dic.ltci.serverClient.OrganizationServerClient;
import com.taikang.dic.ltci.service.InsuredPersonService;
import com.taikang.dic.ltci.service.WSService;

/** @author itw_liuxy 2017年3月29日18:38:32 参保人表service层进行查，增，改操作。 */
@Service
public class InsuredPersonServiceImpl extends AbstractGenericService<InsuredPersonDO, String>
    implements InsuredPersonService {

  @Autowired private InsuredPersonDAO insuredPersonDAO;
  @Autowired private WSService wsService;

  @Autowired private InsuredInfoDAO insuredInfoDAO;

  @Autowired private ApplicationDAO applicationDAO;

  @Autowired private CheckInServerClient checkInServerClient;

  @Autowired private OrganizationServerClient organizationServerClient;

  @Value("${isWebserviceDebug}")
  private boolean isWebserviceDebug;

  /**
   * 根据身份证号和姓名查询参保人信息
   *
   * @param idCard
   * @param securityNumber
   * @return
   */
  @Override
  public InsuredInfoDO getInsuredInfo(String idCard, String insuredPersonName) {
    logger.info("-----------------------------------------------");
    InsuredInfoDOExample doExample = new InsuredInfoDOExample();
    com.taikang.dic.ltci.model.InsuredInfoDOExample.Criteria criteria = doExample.createCriteria();
    if (StringUtils.isNotBlank(idCard)) {
      criteria.andIdCardEqualTo(idCard);
    }
    if (StringUtils.isNotBlank(insuredPersonName)) {
      criteria.andInsuredPersonNameEqualTo(insuredPersonName);
    }
    List<InsuredInfoDO> doList = insuredInfoDAO.selectByExample(doExample);
    if (doList.isEmpty()) {
      return null;
    }
    return doList.get(0);
  }

  /**
   * 根据身份证号和姓名查询参保人信息
   *
   * @param idCard
   * @param securityNumber
   * @return
   */
  @Override
  public ResultDTO getInsuredPerson(
      String idCard, String insuredPersonName, String uniqueNumber, String operator) {
    logger.info("====Service层：进入getInsuredPerson方法开始========");

    ResultDTO resultDTO = new ResultDTO();
    InsuredInfo insuredInfo = new InsuredInfo();
    InsuredInfoDO insuredInfoDO = null;
    TreatmentState treatmentState = new TreatmentState();
    if (!isWebserviceDebug) {
      try {
        treatmentState =
            wsService.selectApplicationStatus(idCard, insuredPersonName, uniqueNumber, operator);
        logger.info(JSONObject.toJSONString(treatmentState));
        if (StringUtils.isBlank(treatmentState.getTreatment())) {
          resultDTO.setStatus(StatusCodeEnum.NOT_FOUND.getValue());
          resultDTO.setDatas(treatmentState);
          resultDTO.setMessage(treatmentState.getErrorReason());
          return resultDTO;
        }
        if (NurseTreatmentEnum.NO.getValue().equals(treatmentState.getTreatment())) {
          resultDTO.setStatus(StatusCodeEnum.NOT_FOUND.getValue());
          resultDTO.setDatas(treatmentState);
          if (NoRreatmentReasonEnum.ABNORMAL
              .getValue()
              .equals(treatmentState.getNoRreatmentReason())) {
            resultDTO.setMessage("待遇申请失败，当前参保人" + NoRreatmentReasonEnum.ABNORMAL.getDesc() + "！");

            return resultDTO;
          }
          if (NoRreatmentReasonEnum.BLOCKADE
              .getValue()
              .equals(treatmentState.getNoRreatmentReason())) {
            resultDTO.setMessage("待遇申请失败，" + NoRreatmentReasonEnum.BLOCKADE.getDesc() + "！");

            return resultDTO;
          }
        }
      } catch (Exception e) {
        logger.error("错误信息：" + e);
        throw new NotFoundByIdException("调用WebService访问selectApplicationStatus接口失败！");
      }

      try {
        insuredInfo =
            wsService.selectInsuredInfo(idCard, insuredPersonName, uniqueNumber, operator);
      } catch (Exception e) {
        logger.error("错误信息：" + e);
        throw new NotFoundByIdException("调用WebService访问selectInsuredInfo接口失败！");
      }
    } else {
      insuredInfoDO = getInsuredInfo(idCard, insuredPersonName);
      if (insuredInfoDO == null) {
        throw new ThrowsException("当前参保人无长期护理照护享受资格！");
      }
    }

    logger.info("-----------------------------------------------");
    logger.info(JSONObject.toJSONString(insuredInfo));
    InsuredPersonDOExample doExample = new InsuredPersonDOExample();
    Criteria criteria = doExample.createCriteria();
    if (StringUtils.isNotBlank(idCard)) {
      criteria.andIdCardEqualTo(idCard);
    }
    if (StringUtils.isNotBlank(insuredPersonName)) {
      criteria.andInsuredPersonNameEqualTo(insuredPersonName);
    }
    List<InsuredPersonDO> doList = insuredPersonDAO.selectByExample(doExample);
    InsuredPersonDO insuredPersonDO;
    if (doList.isEmpty()) {
      insuredPersonDO = new InsuredPersonDO();
    } else {
      insuredPersonDO = doList.get(0);

      //查询参保人是否在申请过程中,查询参数？？？
      ApplicationDOExample applicationDOExample = new ApplicationDOExample();
      com.taikang.dic.ltci.model.ApplicationDOExample.Criteria appCriteria =
          applicationDOExample.createCriteria();
      appCriteria.andIsValidEqualTo(IsValidEnum.NO_DELETE.getValue());
      appCriteria.andInsuredPersonCodeEqualTo(insuredPersonDO.getInsuredPersonCode());
      applicationDOExample.setOrderByClause(" created_time desc ");

      List<ApplicationDO> list = applicationDAO.selectByExample(applicationDOExample);
      if (!list.isEmpty()) {
        ApplicationDO applicationDO = list.get(0);

        if (!ApplicationStatusEnum.NOT_PASS_ACCEPT
            .getValue()
            .equals(applicationDO.getApplicationStatus())) {
          //通过评估护理微服务获取在院状态
          ResultDTO checkInResult = checkInServerClient.getInHospState(idCard, insuredPersonName);
          String checkInState = checkInResult.getDatas().toString();
          //如果在院 不能进行申请
          if (InHospStateEnum.IN.getValue().equals(checkInState)) {
            throw new InsertRepeatException("当前参保人还未退出协议，不能重复提交申请！");
          }
          if (InHospStateEnum.NULL.getValue().equals(checkInState)) {
            throw new InsertRepeatException("当前参保人已存在待遇申请信息，不能重复提交申请！");
          }
        }
      }
    }

    InsuredPersonDTO insuredPersonDTO = new InsuredPersonDTO();
    BeanUtils.copyProperties(insuredPersonDO, insuredPersonDTO);
    insuredPersonDTO.setInsuredPersonName(insuredPersonName);
    insuredPersonDTO.setIdCard(idCard);

    if (isWebserviceDebug) {
      insuredPersonDTO.setSecurityNumber(insuredInfoDO.getSecurityNumber());
      insuredPersonDTO.setNation(insuredInfoDO.getNation());
      insuredPersonDTO.setSiArea(insuredInfoDO.getSiArea());
      insuredPersonDTO.setInsuredPersonGender(insuredInfoDO.getInsuredPersonGender());
      insuredPersonDTO.setSecurityPersonalNumber(insuredInfoDO.getSecurityPersonalNumber());
      insuredPersonDTO.setOrgCode(insuredInfoDO.getOrgCode());

      insuredPersonDTO.setBirthday(
          DateFormatUtil.dateToStr(
              insuredInfoDO.getBirthday(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD));
    } else {
      insuredPersonDTO.setSecurityNumber(insuredInfo.getSecurityNum());
      insuredPersonDTO.setNation(insuredInfo.getNation());
      insuredPersonDTO.setSiArea(insuredInfo.getSiArea());
      insuredPersonDTO.setInsuredPersonGender(insuredInfo.getGender());
      insuredPersonDTO.setSecurityPersonalNumber(insuredInfo.getSiID());
      insuredPersonDTO.setOrgCode(insuredInfo.getOrgCode());

      insuredPersonDTO.setBirthday(DateFormatUtil.dateStrToFormatStr(insuredInfo.getBirthday()));
    }

    resultDTO.setDatas(insuredPersonDTO);
    resultDTO.setMessage("查询成功");
    resultDTO.setStatus(StatusCodeEnum.OK.getValue());

    logger.info("====Service层：insuredPersonDTO：" + insuredPersonDTO + "===========");
    return resultDTO;
  }

  /**
   * 编辑参保人,返回参保人ID
   *
   * @param insuredPersonDTO
   */
  @Override
  public String updateInsuredPerson(InsuredPersonDO insuredPersonDO) {
    logger.info("====Service层：进入updateInsuredPerson方法开始========");
    insuredPersonDAO.updateByPrimaryKeySelective(insuredPersonDO);
    logger.info("====Service层：insuredPersonDO：" + insuredPersonDO + "========");
    logger.info("====Service层：进入updateInsuredPerson方法结束========");
    return insuredPersonDO.getInsuredPersonCode();
  }

  /**
   * 新增参保人信息,返回参保人ID
   *
   * @param insuredPersonDTO
   */
  @Override
  public String createInsuredPerson(InsuredPersonDO insuredPersonDO) {
    logger.info("====Service层：进入createInsuredPerson方法开始========");
    insuredPersonDO.setInsuredPersonid(UUID.randomUUID().toString().replaceAll("-", ""));
    insuredPersonDO.setInsuredPersonCode(UUID.randomUUID().toString().replaceAll("-", ""));
    insuredPersonDO.setIsValid(IsValidEnum.NO_DELETE.getValue());
    insuredPersonDO.setCreatedTime(new Date());
    insuredPersonDO.setOperatedTime(new Date());

    //经办机构或创建机构为空的时候查询机构人员微服务
    if (StringUtils.isBlank(insuredPersonDO.getOrgCode())) {
      throw new ThrowsException("参保人机构代码orgCode为空！");
    }
    ResultDTO resultDTO = organizationServerClient.getBySocOrgCode(insuredPersonDO.getOrgCode());
    if (resultDTO == null
        || !StatusCodeEnum.OK.getValue().equals(resultDTO.getStatus())
        || resultDTO.getDatas() == null) {
      throw new ThrowsException("调用基础服务查询机构代码失败，未查询到对应机构编码！");
    }

    OrganizationDO organizationDO =
        JSONObject.parseObject(JSONObject.toJSONString(resultDTO.getDatas()), OrganizationDO.class);
    insuredPersonDO.setOperatedOrg(organizationDO.getCode());

    if (StringUtils.isBlank(insuredPersonDO.getCreatedOrg())) {
      insuredPersonDO.setCreatedOrg(organizationDO.getCode());
    }
    insuredPersonDAO.insert(insuredPersonDO);
    logger.info(
        "====Service层：InsuredPersonCode：" + insuredPersonDO.getInsuredPersonCode() + "========");
    logger.info("====Service层：进入createInsuredPerson方法开始========");
    return insuredPersonDO.getInsuredPersonCode();
  }

  @Override
  public IGenericDAO<InsuredPersonDO, String> getDao() {
    return insuredPersonDAO;
  }

  @Override
  public ResultDTO getInsuredPersonMessage(String insuredPersonCode) {
    if (StringUtils.isEmpty(insuredPersonCode)) {
      throw new ParametersIsNullException("评估护理传入insuredPersonCode为空");
    }

    InsuredPersonDOExample insuredPersonDOExample = new InsuredPersonDOExample();
    Criteria criteria = insuredPersonDOExample.createCriteria();
    criteria.andInsuredPersonCodeEqualTo(insuredPersonCode);

    List<InsuredPersonDO> selectByExample =
        insuredPersonDAO.selectByExample(insuredPersonDOExample);
    if (selectByExample.isEmpty()) {
      throw new NotFoundByIdException("根据评估护理传入insuredPersonCode未查询出信息");
    }
    ResultDTO resultDTO = new ResultDTO();

    resultDTO.setDatas(selectByExample.get(0));
    resultDTO.setStatus(StatusCodeEnum.OK.getValue());
    resultDTO.setMessage("查询成功");
    return resultDTO;
  }

  @Override
  public ResultDTO getInsuredPersonDetail(
      String insuredPersonCode, String idCard, String securityNumber) {
    if (StringUtils.isBlank(insuredPersonCode)
        && StringUtils.isBlank(idCard)
        && StringUtils.isBlank(securityNumber)) {
      throw new ParametersIsNullException("查询参保人详情接口传入参数全部为空！");
    }

    InsuredPersonDOExample insuredPersonDOExample = new InsuredPersonDOExample();
    Criteria criteria = insuredPersonDOExample.createCriteria();
    if (StringUtils.isNotBlank(insuredPersonCode)) {
      criteria.andInsuredPersonCodeEqualTo(insuredPersonCode);
    }
    if (StringUtils.isNotBlank(idCard)) {
      criteria.andIdCardEqualTo(idCard);
    }
    if (StringUtils.isNotBlank(securityNumber)) {
      criteria.andSecurityNumberEqualTo(securityNumber);
    }

    List<InsuredPersonDO> list = insuredPersonDAO.selectByExample(insuredPersonDOExample);

    ResultDTO resultDTO = new ResultDTO();
    if (list.isEmpty()) {
      resultDTO.setStatus(StatusCodeEnum.NOT_FOUND.getValue());
      resultDTO.setMessage("未查询到相应的参保人详情信息！");
    } else {
      resultDTO.setDatas(list.get(0));
      resultDTO.setStatus(StatusCodeEnum.OK.getValue());
      resultDTO.setMessage("查询成功");
    }
    return resultDTO;
  }
}
