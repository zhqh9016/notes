package com.taikang.dic.ltci.common.exception;

/**
 * 传递的参数不符合业务要求时抛出该异常
 *
 * @author itw_zhangqh
 */
public class ParametersException extends RuntimeException {

  /** */
  private static final long serialVersionUID = 1L;

  public ParametersException() {
    super();
  }

  public ParametersException(String message, Exception ex) {
    super(message, ex);
  }

  public ParametersException(String message) {
    super(message);
  }
}
