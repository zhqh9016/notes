package com.taikang.dic.ltci.portal.common.enumeration;

/**
 * @author itw_liuxy
 * @description
 * @createTime 2017年4月14日 上午9:45:34
 */
public enum FileTypeEnum {
  PICTURE("00", "图片附件"),
  VIDEO("01", "视频附件"),
  AUDIO("02", "音频附件");

  private String value;

  private String desc;

  private FileTypeEnum(String value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  public String getValue() {
    return value;
  }

  public String getDesc() {
    return desc;
  }

  public boolean isRest() {
    return false;
  }
}
