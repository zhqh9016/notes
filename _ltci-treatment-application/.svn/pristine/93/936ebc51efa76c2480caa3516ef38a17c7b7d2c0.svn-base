package com.taikang.dic.ltci.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taikang.dic.ltci.common.enumeration.ApplicationStatusEnum;
import com.taikang.dic.ltci.common.enumeration.InHospStateEnum;
import com.taikang.dic.ltci.common.enumeration.IsAppication;
import com.taikang.dic.ltci.common.enumeration.IsValidEnum;
import com.taikang.dic.ltci.common.enumeration.NoRreatmentReasonEnum;
import com.taikang.dic.ltci.common.enumeration.NurseTreatmentEnum;
import com.taikang.dic.ltci.common.enumeration.SourcesEnum;
import com.taikang.dic.ltci.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.common.exception.NotFoundByIdException;
import com.taikang.dic.ltci.common.ws.InsuredInfo;
import com.taikang.dic.ltci.common.ws.TreatmentState;
import com.taikang.dic.ltci.dao.ApplicationDAO;
import com.taikang.dic.ltci.dao.IGenericDAO;
import com.taikang.dic.ltci.dao.InsuredInfoDAO;
import com.taikang.dic.ltci.dao.InsuredPersonDAO;
import com.taikang.dic.ltci.dao.TreatmentApplicationDAO;
import com.taikang.dic.ltci.model.ApplicationComplexDO;
import com.taikang.dic.ltci.model.ApplicationDO;
import com.taikang.dic.ltci.model.ApplicationDOExample;
import com.taikang.dic.ltci.model.ApplicationSimpleDO;
import com.taikang.dic.ltci.model.InsuredInfoDO;
import com.taikang.dic.ltci.model.InsuredInfoDOExample;
import com.taikang.dic.ltci.model.InsuredPersonDO;
import com.taikang.dic.ltci.model.InsuredPersonDOExample;
import com.taikang.dic.ltci.model.InsuredPersonDOExample.Criteria;
import com.taikang.dic.ltci.serverClient.CheckInServerClient;
import com.taikang.dic.ltci.service.ApplicationService;
import com.taikang.dic.ltci.service.WSService;
import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.api.model.ResultDTO;

@Service
public class ApplicationServiceImpl extends AbstractGenericService<ApplicationDO, String>
    implements ApplicationService {

  @Autowired private ApplicationDAO applicationDAO;

  @Autowired private TreatmentApplicationDAO treatmentApplicationDAO;

  @Autowired private CheckInServerClient checkInServerClient;

  @Autowired private InsuredPersonDAO insuredPersonDAO;
  @Autowired private WSService wsService;

  @Autowired private InsuredInfoDAO insuredInfoDAO;

  @Value("${isWebserviceDebug}")
  private boolean isWebserviceDebug;

  /** 参保人新增待遇申请信息 返回值是待遇申请编号ID */
  @Override
  public String createApplication(ApplicationDO applicationDO) {
    logger.info("====Service层：进入createApplication方法开始========");
    applicationDO.setApplicationid(UUID.randomUUID().toString().replaceAll("-", ""));
    applicationDO.setApplicationCode(UUID.randomUUID().toString().replaceAll("-", ""));

    applicationDO.setVersion(1L);

    applicationDO.setCreatedTime(new Date());
    if (applicationDO.getIsValid() == null) {
      applicationDO.setIsValid(IsValidEnum.NO_DELETE.getValue());
    }
    if (StringUtils.isBlank(applicationDO.getSources())) {
      applicationDO.setSources(SourcesEnum.AGENCY.getValue());
    }
    applicationDO.setOperatedTime(new Date());
    applicationDAO.insert(applicationDO);
    logger.info("====Service层：applicationDO：" + applicationDO + "========");
    logger.info("====Service层：进入createApplication方法结束========");
    return applicationDO.getApplicationCode();
  }

  @Override
  public ResultDTO getApplicationState(
      String idCard, String securityNumber, String insuredPersonName, String deputyIdCard) {
    //
    //    Map<String, String> resultMap = new HashMap<>();
    //    //调用微服务接口
    //    ResultDTO resultCheckIn = checkInServerClient.getInHospState(idCard, insuredPersonName);
    //
    //    String inHospState = resultCheckIn.getDatas().toString();
    //
    //    resultMap.put("inHospState", inHospState);
    //
    //    ApplicationDO appicationDO =
    //        treatmentApplicationDAO.getApplicationState(
    //            idCard, securityNumber, insuredPersonName, deputyIdCard);
    //    if (appicationDO == null) {
    //      resultMap.put("applicationStatus", ApplicationStatusEnum.NO_APPLICATION.getValue());
    //      resultDTO.setDatas(resultMap);
    //      resultDTO.setStatus(StatusCodeEnum.OK.getValue());
    //      return resultDTO;
    //    }
    //    resultMap.put("applicationStatus", appicationDO.getApplicationStatus());
    //    resultDTO.setDatas(resultMap);
    //    resultDTO.setStatus(StatusCodeEnum.OK.getValue());
    //    resultDTO.setMessage("查询成功");
    //    return resultDTO;

    //此功能重新改写
    ResultDTO resultDTO = new ResultDTO();
    Map<String, String> resultMap = new HashMap<>();
    InsuredInfo insuredInfo = new InsuredInfo();
    InsuredInfoDO insuredInfoDO = null;
    String uniqueNumber = "99999";
    String operator = "mobile";
    TreatmentState treatmentState = new TreatmentState();
    if (!isWebserviceDebug) {
      try {
        treatmentState =
            wsService.selectApplicationStatus(idCard, insuredPersonName, uniqueNumber, operator);
        logger.info(JSONObject.toJSONString(treatmentState));
        if (StringUtils.isBlank(treatmentState.getTreatment())) {
          resultDTO.setStatus(StatusCodeEnum.OK.getValue());
          resultMap.put("applicationStatus", IsAppication.NO.getValue());
          resultDTO.setDatas(resultMap);
          resultDTO.setMessage(treatmentState.getErrorReason());
          return resultDTO;
        }

        if (NurseTreatmentEnum.NO.getValue().equals(treatmentState.getTreatment())) {
          resultDTO.setStatus(StatusCodeEnum.OK.getValue());
          resultMap.put("applicationStatus", IsAppication.NO.getValue());
          if (NoRreatmentReasonEnum.ABNORMAL
              .getValue()
              .equals(treatmentState.getNoRreatmentReason())) {
            resultDTO.setMessage("待遇申请失败，当前参保人" + NoRreatmentReasonEnum.ABNORMAL.getDesc() + "！");

            resultDTO.setDatas(resultMap);
            return resultDTO;
          }
          if (NoRreatmentReasonEnum.BLOCKADE
              .getValue()
              .equals(treatmentState.getNoRreatmentReason())) {
            resultDTO.setMessage("待遇申请失败，" + NoRreatmentReasonEnum.BLOCKADE.getDesc() + "！");

            resultDTO.setDatas(resultMap);
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
        resultDTO.setStatus(StatusCodeEnum.OK.getValue());
        resultMap.put("applicationStatus", IsAppication.NO.getValue());
        resultDTO.setDatas(resultMap);
        resultDTO.setMessage("当前参保人无长期护理照护享受资格！");
        return resultDTO;
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
            resultDTO.setStatus(StatusCodeEnum.OK.getValue());
            resultMap.put("applicationStatus", IsAppication.NO.getValue());
            resultDTO.setDatas(resultMap);
            resultDTO.setMessage("当前参保人还未退出协议，不能重复提交申请！");
            return resultDTO;
          }
          if (InHospStateEnum.NULL.getValue().equals(checkInState)) {
            resultDTO.setStatus(StatusCodeEnum.OK.getValue());
            resultMap.put("applicationStatus", IsAppication.NO.getValue());
            resultDTO.setDatas(resultMap);
            resultDTO.setMessage("当前参保人已存在待遇申请信息，不能重复提交申请！");
            return resultDTO;
          }
        }
      }
    }

    resultDTO.setStatus(StatusCodeEnum.OK.getValue());
    resultMap.put("applicationStatus", IsAppication.YES.getValue());
    resultDTO.setDatas(resultMap);
    return resultDTO;
  }

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

  @Override
  public IGenericDAO<ApplicationDO, String> getDao() {
    return applicationDAO;
  }

  @Override
  public ResultDTO getApplicationSimple(List<String> applicationSimples) {
    List<ApplicationSimpleDO> applicationSimple =
        treatmentApplicationDAO.getApplicationSimple(applicationSimples);
    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setDatas(applicationSimple);
    resultDTO.setStatus(StatusCodeEnum.OK.getValue());
    resultDTO.setMessage("查询成功");
    return resultDTO;
  }

  @Override
  public ResultDTO getApplicationComplex(String applicationCodes) {
    List<ApplicationComplexDO> applicationComplex =
        treatmentApplicationDAO.getApplicationComplex(applicationCodes);
    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setDatas(applicationComplex);
    resultDTO.setStatus(StatusCodeEnum.OK.getValue());
    resultDTO.setMessage("查询成功");
    return resultDTO;
  }
}
