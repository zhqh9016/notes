package com.taikang.dic.ltci.controller;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.api.model.CheckInDTO;
import com.taikang.dic.ltci.api.model.PageResultDTO;
import com.taikang.dic.ltci.api.model.RestResponseDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.ConstantUtil;
import com.taikang.dic.ltci.common.enumeration.ErrorReasonStateEnum;
import com.taikang.dic.ltci.common.enumeration.ExecutionStatusEnum;
import com.taikang.dic.ltci.common.enumeration.InHospStateEnum;
import com.taikang.dic.ltci.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.common.ws.ErrorReason;
import com.taikang.dic.ltci.model.MqBaseModel;
import com.taikang.dic.ltci.service.CheckInService;
import com.taikang.dic.ltci.service.impl.CheckInServiceImpl;

/** @author itw_caoxy 协议管理查询列表 */
@Controller
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class CheckInController {
  private Logger logger = LoggerFactory.getLogger(ExpertEvaluateController.class);
  @Autowired private CheckInService checkInService;
  @Autowired private CheckInServiceImpl checkInServiceImpl;

  /** 给待遇申请微服务查询的接口，返回入院的状态 */
  @RequestMapping(
    path = "/insuredPerson/{idCard}/{insuredPersonName}/inHospState",
    method = RequestMethod.GET
  )
  @ResponseBody
  public ResultDTO getInHospState(
      @PathVariable String idCard, @PathVariable String insuredPersonName) {
    return checkInService.getInHospState(idCard, insuredPersonName);
  }

  @RequestMapping(
    path = "/insuredPerson/{idCard}/{insuredPersonName}/checkInHospState",
    method = RequestMethod.GET
  )
  @ResponseBody
  public ResultDTO getCheckInHospState(
      @PathVariable String idCard, @PathVariable String insuredPersonName) {
    return checkInService.getCheckInHospState(idCard, insuredPersonName);
  }
  /**
   * 重新发送 协议入住消息
   *
   * @param message
   * @throws Exception
   */
  @RequestMapping(path = ConstantUtil.RETRY_URL_CHECK_IN_MQ, method = RequestMethod.POST)
  public ResultDTO retryCheckIn(String message) {
    ResultDTO resultDTO = new ResultDTO();
    MqBaseModel mqBaseModel = JSONObject.parseObject(message, MqBaseModel.class);
    try {
      ErrorReason errorReason = checkInServiceImpl.checkInAndToDR(mqBaseModel);
      if (ErrorReasonStateEnum.IS_SUCCESS.getValue().equals(errorReason.getErrorReasonCode())) {
        resultDTO.setStatus(ExecutionStatusEnum.SUCCESS.getValue());
      } else {
        resultDTO.setStatus(ExecutionStatusEnum.FAILD.getValue());
      }
    } catch (Exception e) {
      logger.error("重新发送协议入住错误：", e);
      resultDTO.setStatus(ExecutionStatusEnum.FAILD.getValue());
    }
    return resultDTO;
  }

  /**
   * 重新发送 协议退出消息
   *
   * @param message
   * @throws Exception
   */
  @RequestMapping(path = ConstantUtil.RETRY_URL_CHECK_OUT_MQ, method = RequestMethod.POST)
  public ResultDTO retryCheckOut(String message) {
    ResultDTO resultDTO = new ResultDTO();
    MqBaseModel mqBaseModel = JSONObject.parseObject(message, MqBaseModel.class);
    ErrorReason errorReason;
    try {
      errorReason = checkInServiceImpl.checkOutAndToDR(mqBaseModel);
      if (ErrorReasonStateEnum.IS_SUCCESS.getValue().equals(errorReason.getErrorReasonCode())) {
        resultDTO.setStatus(ExecutionStatusEnum.SUCCESS.getValue());
      } else {
        resultDTO.setStatus(ExecutionStatusEnum.FAILD.getValue());
      }
    } catch (Exception e) {
      logger.error("重新发送协议退出错误：", e);
      resultDTO.setStatus(ExecutionStatusEnum.FAILD.getValue());
    }
    return resultDTO;
  }

  @RequestMapping(value = "/checkIn", method = RequestMethod.POST)
  @ResponseBody
  public RestResponseDTO getCheckIn(
      String beCarePersonName,
      String beCarePersonCard,
      String orgName,
      String operatedTime,
      String inHospState,
      @RequestParam(name = "page", defaultValue = "1") int page,
      @RequestParam(name = "pageSize", defaultValue = "15") int pageSize) {
    logger.info("beCarePersonName:" + beCarePersonName);
    logger.info("beCarePersonCard:" + beCarePersonCard);
    logger.info("inHospState:" + inHospState);
    logger.info("orgName:" + orgName);
    logger.info("operatedTime:" + operatedTime);
    logger.info("page:" + page);
    logger.info("pageSize:" + pageSize);
    PageResultDTO dto =
        checkInService.getCheckIn(
            beCarePersonName, beCarePersonCard, orgName, operatedTime, inHospState, page, pageSize);

    RestResponseDTO responseDTO = new RestResponseDTO();
    responseDTO.setData(dto);
    return responseDTO;
  }

  /**
   * 协议退出
   *
   * @param exitFrom
   * @param exitReason
   * @param exitReasonDetial
   * @param inHospState
   * @param agreOutDate
   * @param operatedBy
   * @param checkInCode
   * @return
   */
  @RequestMapping(path = "/checkInOut")
  @ResponseBody
  public RestResponseDTO checkInProtocolExit(@RequestBody CheckInDTO checkInDTO) {
    ResultDTO resultDto = new ResultDTO();
    resultDto.setNumber(0);
    try {
      int result =
          checkInService.updateCheckInByCheckInCode(
              checkInDTO.getExitFrom(),
              checkInDTO.getExitReason(),
              checkInDTO.getExitReasonDetial(),
              checkInDTO.getInHospState(),
              checkInDTO.getRealOutDate(),
              checkInDTO.getCheckInCode(),
              checkInDTO.getOperatedBy());

      if (result > 0) {
        resultDto.setMessage("状态修改成功");
        resultDto.setStatus(StatusCodeEnum.CREATED.getValue());
      } else if (result == -1) {
        resultDto.setMessage("记录已被他人操作，请刷新界面，重新选择数据！");
        resultDto.setStatus(StatusCodeEnum.CREATED.getValue());
      } else {
        resultDto.setMessage("状态修改失败");
        resultDto.setStatus(StatusCodeEnum.INTERNAL_SERVER_ERROR.getValue());
      }
    } catch (Exception e) {
      logger.error("错误信息：" + e);
      resultDto.setMessage(e.getMessage());
      resultDto.setStatus(StatusCodeEnum.INTERNAL_SERVER_ERROR.getValue());
    }
    RestResponseDTO responseDTO = new RestResponseDTO();
    responseDTO.setData(resultDto);
    return responseDTO;
  }

  /**
   * 协议入住实时接口
   *
   * @param jsonString
   * @return
   */
  @RequestMapping(path = "/registNurseInfo", method = RequestMethod.POST)
  @ResponseBody
  public ErrorReason registNurseInfo(String jsonString) {
    return checkInService.registNurseInfo(jsonString);
  }

  /**
   * 协议退出实时接口
   *
   * @param jsonString
   * @return
   */
  @RequestMapping(path = "/getNurseOutInfo", method = RequestMethod.POST)
  @ResponseBody
  public ErrorReason getNurseOutInfo(String jsonString) {
    return checkInService.getNurseOutInfo(jsonString);
  }

  /**
   * 查询参保人的在院状态
   *
   * @param inRecordUuid
   * @return
   */
  @RequestMapping(path = "/getInHospStat4Check", method = RequestMethod.GET)
  @ResponseBody
  public ResultDTO getInHostStat4Check(String inRecordUuid) {
    ResultDTO result = new ResultDTO();
    if (StringUtils.isBlank(inRecordUuid)) {
      result.setStatus(9);
      result.setMessage("入住编号不能为空");
      return result;
    }
    CheckInDTO checkIn = checkInService.getCheckInHospStateByInRecordUuid(inRecordUuid);
    if (checkIn == null) {
      result.setStatus(InHospStateEnum.NULL.getValue());
      result.setMessage("该入住编号不存在");
    } else if (String.valueOf(InHospStateEnum.In.getValue()).equals(checkIn.getInHospState())) {
      result.setStatus(InHospStateEnum.In.getValue());
      result.setMessage("已出院");
    } else if (String.valueOf(InHospStateEnum.out.getValue()).equals(checkIn.getInHospState())) {
      result.setStatus(InHospStateEnum.out.getValue());
      result.setMessage(InHospStateEnum.out.getDesc());
    }
    result.setDatas(checkIn);
    return result;
  }
}
