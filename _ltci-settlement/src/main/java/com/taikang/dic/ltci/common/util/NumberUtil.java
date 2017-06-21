package com.taikang.dic.ltci.common.util;

import java.math.BigDecimal;

public class NumberUtil {

  public static BigDecimal nullToBigDecimal(Double num) {
    if (num == null) {
      return BigDecimal.valueOf(0);
    }
    return BigDecimal.valueOf(num);
  }
}
