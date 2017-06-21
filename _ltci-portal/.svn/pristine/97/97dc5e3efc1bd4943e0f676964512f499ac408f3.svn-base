package com.taikang.dic.ltci.portal.common.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.taikang.dic.ltci.portal.api.model.UserDTO;
import com.taikang.dic.ltci.portal.common.util.IPUtil;
import com.taikang.dic.ltci.portal.common.util.UserUtils;

/**
 * 常量类
 *
 * @author itw_muwg
 */
@Component
public class LogConstant {

  private Logger logger = LoggerFactory.getLogger(LogConstant.class);

  public LogConstant() {
    try {
      String localIp = IPUtil.getLocalIp();
      LogConstant.LOG.setLocalIp(localIp);
    } catch (Exception e) {
      logger.error("parse host error !", e);
    }
  }

  @Value("${spring.application.name}")
  public void setSystemCode(String localSystemCode) {
    LogConstant.LOG.setLocalCode(localSystemCode);
  }

  public static final LogBO LOG = new LogBO();
  public static final String SYSTEM_CODE = "LCPM"; //本系统编码
  public static final String BUSINESS_SERIALID_KEY = "businessSerialid"; //交易流水参数
  public static final String SYSTEM_CODE_KEY = "systemCode"; //客户端系统编码参数
  public static final String MODULE_CODE_KEY = "moduleCode"; //客户端模块编码参数
  public static final String TIMESTAMP_KEY = "timestamp"; //发送时间 yyyyMMdd HH:mm:ss SSS
  public static final String OPERATED_ORG = "operatedOrg"; //操作机构
}
