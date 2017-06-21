package com.taikang.dic.ltci.common.log;
/**
 * 传递客户端信息BO
 *
 * @author itw_muwg
 */
public class LogBO {

  private String businessSerialid; //交易流水
  private String systemCode; //请求方系统编码
  private String moduleCode; //请求方模块编码
  private String remoteIp; //请求方节点ip
  private String timestamp; //请求方发送时间
  private String localIp; //本地服务器IP
  private String localCode; //本地模块编码
  private String operatedOrg; //经办机构编号

  public LogBO() {
    super();
  }

  public LogBO(
      String businessSerialid,
      String systemCode,
      String moduleCode,
      String remoteIp,
      String timestamp,
      String operatedOrg) {
    super();
    this.businessSerialid = businessSerialid;
    this.systemCode = systemCode;
    this.moduleCode = moduleCode;
    this.remoteIp = remoteIp;
    this.timestamp = timestamp;
    this.operatedOrg = operatedOrg;
  }

  public String getBusinessSerialid() {
    return businessSerialid;
  }

  public void setBusinessSerialid(String businessSerialid) {
    this.businessSerialid = businessSerialid;
  }

  public String getSystemCode() {
    return systemCode;
  }

  public void setSystemCode(String systemCode) {
    this.systemCode = systemCode;
  }

  public String getModuleCode() {
    return moduleCode;
  }

  public void setModuleCode(String moduleCode) {
    this.moduleCode = moduleCode;
  }

  public String getRemoteIp() {
    return remoteIp;
  }

  public void setRemoteIp(String remoteIp) {
    this.remoteIp = remoteIp;
  }

  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  public String getLocalIp() {
    return localIp;
  }

  public void setLocalIp(String localIp) {
    this.localIp = localIp;
  }

  public String getLocalCode() {
    return localCode;
  }

  public void setLocalCode(String localCode) {
    this.localCode = localCode;
  }

  public String getOperatedOrg() {
    return operatedOrg;
  }

  public void setOperatedOrg(String operatedOrg) {
    this.operatedOrg = operatedOrg;
  }
}
