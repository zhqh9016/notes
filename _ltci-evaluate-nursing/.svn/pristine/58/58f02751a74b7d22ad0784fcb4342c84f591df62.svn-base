package com.taikang.dic.ltci.common.exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.taikang.dic.ltci.api.model.RestResponseDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.enumeration.StatusCodeEnum;

@RestController
@ControllerAdvice
class GlobalExceptionHandler {
  private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  @ExceptionHandler(value = Exception.class)
  @ResponseBody
  public RestResponseDTO defaultErrorHandler(HttpServletRequest req, Exception e) {
    logger.error("Exception:异常拦截，输出错误描述信息", e);
    ResultDTO ee = new ResultDTO();
    ee.setStatus(StatusCodeEnum.INTERNAL_SERVER_ERROR.getValue());
    ee.setMessage("服务器异常，后台报错！");

    RestResponseDTO responseDTO = new RestResponseDTO();
    responseDTO.setData(ee);
    return responseDTO;
  }

  @ExceptionHandler(value = ThrowsException.class)
  @ResponseBody
  public RestResponseDTO throwsErrorHandler(HttpServletRequest req, Exception e) {
    logger.error("throwsErrorHandler:异常拦截，输出错误描述信息", e);
    ResultDTO ee = new ResultDTO();
    ee.setStatus(StatusCodeEnum.INTERNAL_SERVER_ERROR.getValue());
    ee.setMessage(e.getMessage());
    RestResponseDTO responseDTO = new RestResponseDTO();
    responseDTO.setData(ee);
    return responseDTO;
  }
  /** 参数不全的异常 */
  @ExceptionHandler(ParametersIsNullException.class)
  @ResponseBody
  public RestResponseDTO handleException(ParametersIsNullException ex) {
    logger.error("ParametersIsNullException:异常拦截，输出错误描述信息", ex);
    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setStatus(StatusCodeEnum.NOT_ACCEPTABLE.getValue());
    resultDTO.setMessage(ex.getMessage());
    RestResponseDTO responseDTO = new RestResponseDTO();
    responseDTO.setData(resultDTO);
    return responseDTO;
  }

  @ExceptionHandler(NotFoundByIdException.class)
  @ResponseBody
  public RestResponseDTO handleException(NotFoundByIdException ex) {
    logger.error("NotFoundByIdException:异常拦截，输出错误描述信息", ex);
    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setStatus(StatusCodeEnum.NOT_FOUND.getValue());
    resultDTO.setMessage(ex.getMessage());
    RestResponseDTO responseDTO = new RestResponseDTO();
    responseDTO.setData(resultDTO);
    return responseDTO;
  }

  @ExceptionHandler(InsertRepeatException.class)
  @ResponseBody
  public RestResponseDTO handleException(InsertRepeatException ex) {
    logger.error("InsertRepeatException:异常拦截，输出错误描述信息", ex);
    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setStatus(StatusCodeEnum.INSERT_REPEAT.getValue());
    resultDTO.setMessage(ex.getMessage());
    RestResponseDTO responseDTO = new RestResponseDTO();
    responseDTO.setData(resultDTO);
    return responseDTO;
  }
}
