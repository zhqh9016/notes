package com.taikang.dic.ltci.treatment.application.common;

/**
 * @author itw_liuxy
 * @description
 * @createTime 2017年3月31日 下午4:23:22
 */
public class ParametersIsNullException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public ParametersIsNullException(String message) {
    super(message);
  }
}
