package com.taikang.dic.ltci.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.taikang.dic.ltci.api.model.DeputyBindingCheckDTO;
import com.taikang.dic.ltci.api.model.DeputyBindingDTO;
import com.taikang.dic.ltci.api.model.PageResultDTO;
import com.taikang.dic.ltci.api.model.RestResponseDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.Result;
import com.taikang.dic.ltci.common.enumeration.ExecutionStatusEnum;
import com.taikang.dic.ltci.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.common.exception.ParametersIsNullException;
import com.taikang.dic.ltci.common.utils.DateFormat;
import com.taikang.dic.ltci.model.DeputyBindingDO;
import com.taikang.dic.ltci.model.DeputyBindingSpecialDO;
import com.taikang.dic.ltci.service.DeputyBindingService;

/** @author itw_caoxy 用于处理代理人绑定的处理类 */
@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class DeputyBindingController {
  private Logger logger = LoggerFactory.getLogger(DeputyBindingController.class);

  @Autowired private DeputyBindingService deputyBindingService;

  public static final String RETRY_URL = "/deputyBinding/receive/retry";

  @RequestMapping(path = "/deputyBinding/receive/retry", method = RequestMethod.POST)
  public ResultDTO getMobileCompliain(@RequestParam String message) {
    ResultDTO resultDTO = new ResultDTO();
    try {
      return deputyBindingService.insertMqMessageLog(message);
    } catch (Exception e) {
      logger.error("error", e);
      resultDTO.setStatus(ExecutionStatusEnum.FAILD.getValue());
    }
    return resultDTO;
  }

  @RequestMapping(value = "/deputy/bindings", method = RequestMethod.POST)
  @ResponseBody
  public RestResponseDTO getDeputyBindingQuery(
      String insuredPersonName,
      String idCard,
      String securityNumber,
      String deputyName,
      String deputyIdCard,
      String checkState,
      @RequestParam(value = "page", defaultValue = "1") int page,
      @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {

    logger.info("insuredPersonName:" + insuredPersonName);
    logger.info("idCard:" + idCard);
    logger.info("securityNumber:" + securityNumber);
    logger.info("deputyName:" + deputyName);
    logger.info("deputyIdCard:" + deputyIdCard);
    logger.info("checkState:" + checkState);

    PageResultDTO pageResultDTO =
        deputyBindingService.queryDeputyBinding(
            insuredPersonName,
            idCard,
            securityNumber,
            deputyName,
            deputyIdCard,
            checkState,
            page,
            pageSize);
    /*
       List<DeputyBindingCheckDTO> list = new ArrayList<DeputyBindingCheckDTO>();
       for (DeputyBindingSpecialDO deputyBinding : deputyBindings) {
         DeputyBindingCheckDTO deputyBindingCheckDTO = new DeputyBindingCheckDTO();
         deputyBindingCheckDTO.setCheckState(deputyBinding.getCheckState());
         deputyBindingCheckDTO.setDeputyIdCard(deputyBinding.getDeputyIdCard());
         deputyBindingCheckDTO.setIdCard(deputyBinding.getIdCard());
         deputyBindingCheckDTO.setInsuredPersonName(deputyBinding.getInsuredPersonName());
         deputyBindingCheckDTO.setSecurityNumber(deputyBinding.getSecurityNumber());
         deputyBindingCheckDTO.setDeputyName(deputyBinding.getDeputyName());
         list.add(deputyBindingCheckDTO);
       }
    */
    RestResponseDTO restResponseDTO = new RestResponseDTO();
    restResponseDTO.setData(pageResultDTO);
    return restResponseDTO;
  }

  /**
   * 代理人绑定状态查询接口
   *
   * @author itw_xuyao
   * @param DeputyBindingCheckDTO
   * @return ResultDTO
   */
  @RequestMapping(path = "/deputy/binding/status", method = RequestMethod.POST)
  @ResponseBody
  public RestResponseDTO getDeputyBindingStatus(
      @RequestBody DeputyBindingCheckDTO deputyBindingCheckDTO) {
    logger.info("====进入getDeputyBindingStatus方法开始========");
    logger.debug("===传入参数deputyBindingCheckDTO【" + deputyBindingCheckDTO.toString() + "】=========");
    if (StringUtils.isEmpty(deputyBindingCheckDTO.getIdCard())
        || StringUtils.isEmpty(deputyBindingCheckDTO.getSecurityNumber())
        || StringUtils.isEmpty(deputyBindingCheckDTO.getDeputyIdCard())) {
      throw new ParametersIsNullException("代理人绑定状态查询接口传入参数有空值，请确认");
    }
    DeputyBindingSpecialDO deputyBindingSpecialDO = new DeputyBindingSpecialDO();
    BeanUtils.copyProperties(deputyBindingCheckDTO, deputyBindingSpecialDO);
    Result result = deputyBindingService.getDeputyBindingStatus(deputyBindingSpecialDO);
    ResultDTO resultDTO = new ResultDTO();
    BeanUtils.copyProperties(result, resultDTO);

    RestResponseDTO restResponseDTO = new RestResponseDTO();
    restResponseDTO.setData(resultDTO);
    return restResponseDTO;
  }

  /**
   * 代理人绑定人工审核（移动端->经办） @RabbitListener 监听createDeputyBinding队列获取mq中信息 @RabbitHandler 指定对消息的处理方法
   *
   * <p>由service层直接监听队列 controller暂时注掉
   *
   * @author itw_xuyao
   * @param DeputyBindingDTO
   * @return ResultDTO
   */
  //  @RequestMapping(path = "/deputy/binding", method = RequestMethod.POST)
  //  @ResponseBody
  //  //@RabbitHandler
  //  @RabbitListener(queues = "q.test")
  //  public ResultDTO createDeputyBinding(
  //      DeputyBindingSubmitDTO deputyBindingSubmitDTO, HttpServletRequest request) {
  //    logger.info("====进入createDeputyBinding方法开始========");
  //    logger.debug(
  //        "=====传入参数deputyBindingSubmitDTO【" + deputyBindingSubmitDTO.toString() + "】===========");
  //
  //    // 首先判断参数是否为空
  //    if (StringUtils.isEmpty(deputyBindingSubmitDTO.getSerialNumber())
  //        || StringUtils.isEmpty(deputyBindingSubmitDTO.getIdCard())
  //        || StringUtils.isEmpty(deputyBindingSubmitDTO.getSecurityNumber())
  //        || StringUtils.isEmpty(deputyBindingSubmitDTO.getDeputyName())
  //        || StringUtils.isEmpty(deputyBindingSubmitDTO.getDeputyIdCard())
  //        || StringUtils.isEmpty(deputyBindingSubmitDTO.getDeputyMobile())) {
  //      throw new ParametersIsNullException("代理人绑定人工审核传入参数有值为空，请确认");
  //    }
  //    DeputyBindingDO deputyBindingDO = new DeputyBindingDO();
  //    BeanUtils.copyProperties(deputyBindingSubmitDTO, deputyBindingDO);
  //
  //    Result result = deputyBindingService.createDeputyBinding(deputyBindingDO, request);
  //    ResultDTO resultDTO = new ResultDTO();
  //    BeanUtils.copyProperties(result, resultDTO);
  //    return resultDTO;
  //  }

  /**
   * @author itw_xuyao 前段点击前往跳转代理人绑定人工审核详细页面 通过url中审核表中id查询所有信息
   * @return DeputyBindingDTO
   */
  @RequestMapping(value = "/deputy/bindings/{deputyBindingCode}", method = RequestMethod.GET)
  @ResponseBody
  public RestResponseDTO getDeputyBindingDTO(@PathVariable String deputyBindingCode) {
    logger.debug("deputyBindingCode:" + deputyBindingCode);
    DeputyBindingSpecialDO deputyBindingSpecialDO =
        deputyBindingService.getDeputyBindingDO(deputyBindingCode);

    DeputyBindingDTO deputyBindingDTO = new DeputyBindingDTO();
    BeanUtils.copyProperties(deputyBindingSpecialDO, deputyBindingDTO);
    logger.debug(
        "========返回的DTO deputyBindingDTO【" + deputyBindingDTO.toString() + "】================");

    Result result = new Result();
    result.setStatus(StatusCodeEnum.OK.getValue());
    result.setDatas(deputyBindingDTO);
    result.setMessage("查询成功");
    ResultDTO resultDTO = new ResultDTO();
    BeanUtils.copyProperties(result, resultDTO);
    logger.debug("====查询绑定审核信息返回result【" + resultDTO.toString() + "】=======");

    RestResponseDTO restResponseDTO = new RestResponseDTO();
    restResponseDTO.setData(resultDTO);
    return restResponseDTO;
  }

  /**
   * @author itw_xuyao 审核代理人绑定信息
   * @return ResultDTO
   */
  @RequestMapping(value = "/deputy/bindings/deputyBindingid/checkState", method = RequestMethod.PUT)
  @ResponseBody
  public RestResponseDTO updateDeputyBindingDTO(@RequestBody DeputyBindingDTO deputyBindingDTO) {
    String deputyBindingid = deputyBindingDTO.getDeputyBindingid();
    String checkState = deputyBindingDTO.getCheckState();
    String checkReason = deputyBindingDTO.getCheckReason();
    logger.debug("deputyBindingid:" + deputyBindingid);
    logger.debug("checkState:" + checkState);
    logger.debug("checkReason:" + checkReason);
    if (StringUtils.isEmpty(deputyBindingid) || StringUtils.isEmpty(checkState)) {
      throw new ParametersIsNullException(" 审核代理人绑定信息传入参数有值为空，请确认");
    }
    DeputyBindingDO deputyBindingDO = new DeputyBindingDO();
    BeanUtils.copyProperties(deputyBindingDTO, deputyBindingDO);
    Result result = deputyBindingService.updateDeputyBindingDO(deputyBindingDO);
    ResultDTO resultDTO = new ResultDTO();
    BeanUtils.copyProperties(result, resultDTO);

    RestResponseDTO restResponseDTO = new RestResponseDTO();
    restResponseDTO.setData(resultDTO);
    return restResponseDTO;
  }

  @RequestMapping(path = "/deputy/binding/list/{deputyIdCard}", method = RequestMethod.GET)
  @ResponseBody
  public RestResponseDTO getDeputyBindingListQuery(@PathVariable String deputyIdCard) {

    logger.debug("deputyIdCard:" + deputyIdCard);
    if ("".equals(deputyIdCard) || null == deputyIdCard) {
      throw new ParametersIsNullException("传入参数不能为空！");
    }

    ResultDTO resultDTO = deputyBindingService.getDeputyBindingListQuery(deputyIdCard);

    RestResponseDTO response = new RestResponseDTO();
    response.setData(resultDTO);
    //    response.setBusinessSerialid(restBaseDTO.getBusinessSerialid());
    response.setTimestamp(DateFormat.getLongDateTime());
    return response;
  }
}
