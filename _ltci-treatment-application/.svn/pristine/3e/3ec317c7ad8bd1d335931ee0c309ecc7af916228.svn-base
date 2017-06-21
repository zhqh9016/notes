package com.taikang.dic.ltci.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.taikang.dic.ltci.api.model.RestResponseDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.common.exception.InsertRepeatException;
import com.taikang.dic.ltci.common.exception.NotFoundByIdException;
import com.taikang.dic.ltci.common.exception.ParametersIsNullException;
import com.taikang.dic.ltci.common.exception.ThrowsException;

//该 Exception Handler 只需考虑本业务微服务应用自己的 Exception 处理，其他由 Spring 框架或者 trolls-rest-webmvc,统一考虑，参见开发指引 Controller 一节。

@RestController
@ControllerAdvice
public class BusinessExceptionHandler {
  private static final Logger logger = LoggerFactory.getLogger(BusinessExceptionHandler.class);

  @ExceptionHandler(NotFoundByIdException.class)
  @ResponseBody
  public RestResponseDTO handleException(NotFoundByIdException ex) {
    logger.error("NotFoundByIdException:异常拦截，输出错误描述信息", ex);
    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setStatus(StatusCodeEnum.NOT_FOUND.getValue());
    resultDTO.setMessage(ex.getMessage());
    RestResponseDTO baseModel = new RestResponseDTO();
    baseModel.setData(resultDTO);
    return baseModel;
  }

  @ExceptionHandler(ParametersIsNullException.class)
  @ResponseBody
  public RestResponseDTO handleException(ParametersIsNullException ex) {
    logger.error("ParametersIsNullException:异常拦截，输出错误描述信息", ex);
    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setStatus(StatusCodeEnum.NOT_ACCEPTABLE.getValue());
    resultDTO.setMessage(ex.getMessage());
    RestResponseDTO baseModel = new RestResponseDTO();
    baseModel.setData(resultDTO);
    return baseModel;
  }

  @ExceptionHandler(RuntimeException.class)
  @ResponseBody
  public RestResponseDTO handleException(RuntimeException ex) {
    logger.error("RuntimeException:异常拦截，输出错误描述信息", ex);
    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setStatus(StatusCodeEnum.INTERNAL_SERVER_ERROR.getValue());
    resultDTO.setMessage(ex.getMessage());
    RestResponseDTO baseModel = new RestResponseDTO();
    baseModel.setData(resultDTO);
    return baseModel;
  }

  @ExceptionHandler(ThrowsException.class)
  @ResponseBody
  public RestResponseDTO throwsException(RuntimeException ex) {
    logger.error("throwsException:异常拦截，输出错误描述信息", ex);
    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setStatus(StatusCodeEnum.INTERNAL_SERVER_ERROR.getValue());
    resultDTO.setMessage(ex.getMessage());
    RestResponseDTO baseModel = new RestResponseDTO();
    baseModel.setData(resultDTO);
    return baseModel;
  }

  @ExceptionHandler(InsertRepeatException.class)
  @ResponseBody
  public RestResponseDTO handleException(InsertRepeatException ex) {
    logger.error("InsertRepeatException:异常拦截，输出错误描述信息", ex);
    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setStatus(StatusCodeEnum.INSERT_REPEAT.getValue());
    resultDTO.setMessage(ex.getMessage());
    RestResponseDTO baseModel = new RestResponseDTO();
    baseModel.setData(resultDTO);
    return baseModel;
  }
}
