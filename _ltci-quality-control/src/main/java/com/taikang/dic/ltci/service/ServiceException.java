package com.taikang.dic.ltci.service;

/**
 * 异常捕捉类
 *
 * @author itw_liyh01
 */
public class ServiceException extends Exception {

  /** */
  private static final long serialVersionUID = 3891239438883248350L;

  private final int errorCode;

  public ServiceException(int errorCode, String message) {
    super(message);
    this.errorCode = errorCode;
  }

  public int getErrorCode() {
    return errorCode;
  }
}
