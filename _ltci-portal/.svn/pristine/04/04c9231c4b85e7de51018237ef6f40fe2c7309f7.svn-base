package com.taikang.dic.ltci.portal.common.util;

import java.security.SecureRandom;

public class CodeGenerator {

  private static char[] org = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
  /**
   * 生成组织机构编码的规则是,组织机构所在区域+6位随机数, 如果随机数不够6位在前面用0补齐
   *
   * @param areaCode
   * @return
   */
  public static String generateOrgCode(String areaCode) {
    StringBuffer sb = new StringBuffer(areaCode);
    SecureRandom random = new SecureRandom();
    for (int i = 0; i < 6; i++) {
      sb.append(org[random.nextInt(org.length)]);
    }

    return sb.toString();
  }
}
