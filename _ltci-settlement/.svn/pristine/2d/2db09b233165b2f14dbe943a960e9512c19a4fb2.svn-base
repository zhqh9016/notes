package com.taikang.dic.ltci.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.common.exception.ParametersException;

@ControllerAdvice
class GlobalExceptionHandler {
  private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  @ExceptionHandler(value = Exception.class)
  @ResponseBody
  public ResultDTO defaultErrorHandler(Exception e) {
    logger.error("defaultErrorHandler  Exception:异常拦截，输出错误描述信息", e);
    ResultDTO ee = new ResultDTO();
    ee.setStatus(StatusCodeEnum.INTERNAL_SERVER_ERROR.getValue());
    ee.setMessage(e.getMessage());
    return ee;
  }
  /** 参数不全的异常 */
  @ExceptionHandler(ParametersIsNullException.class)
  @ResponseBody
  public ResultDTO handleException(ParametersIsNullException ex) {
    logger.error("handleException  ParametersIsNullException:异常拦截，输出错误描述信息", ex);
    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setStatus(StatusCodeEnum.NOT_ACCEPTABLE.getValue());
    resultDTO.setMessage(ex.getMessage());
    return resultDTO;
  }

  @ExceptionHandler(NotFoundByIdException.class)
  @ResponseBody
  public ResultDTO handleException(NotFoundByIdException ex) {
    logger.error("handleException  NotFoundByIdException:异常拦截，输出错误描述信息", ex);
    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setStatus(StatusCodeEnum.NOT_FOUND.getValue());
    resultDTO.setMessage(ex.getMessage());
    return resultDTO;
  }

  @ExceptionHandler(InsertRepeatException.class)
  @ResponseBody
  public ResultDTO handleException(InsertRepeatException ex) {
    logger.error("handleException  InsertRepeatException:异常拦截，输出错误描述信息", ex);
    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setStatus(StatusCodeEnum.INSERT_REPEAT.getValue());
    resultDTO.setMessage(ex.getMessage());
    return resultDTO;
  }

  /**
   * 传递的参数不符合业务要求时发生的异常
   *
   * @param ex
   * @return
   */
  @ExceptionHandler(ParametersException.class)
  @ResponseBody
  public ResultDTO handleException(ParametersException ex) {
    logger.error("handleException  ParametersException:异常拦截，输出错误描述信息", ex);
    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setStatus(StatusCodeEnum.NOT_ACCEPTABLE.getValue());
    resultDTO.setMessage(ex.getMessage());
    return resultDTO;
  }
}
