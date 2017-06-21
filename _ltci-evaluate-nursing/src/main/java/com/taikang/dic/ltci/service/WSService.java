package com.taikang.dic.ltci.service;

import com.taikang.dic.ltci.common.ws.ChanghuCard;
import com.taikang.dic.ltci.common.ws.ErrorReason;
import com.taikang.dic.ltci.common.ws.NurseInInfo;
import com.taikang.dic.ltci.common.ws.NurseOutInfo;

/**
 * 调用东软第三方WebService接口
 *
 * @author itw_liuxy
 * @description
 * @createTime 2017年4月17日 上午10:43:49
 */
public interface WSService {

  /** 居家/入住护理机构登记信息交易（泰康->东软） */
  public ErrorReason registNurseInfo(NurseInInfo registRequest, ChanghuCard changhuCard);

  /** 居家/入住护理机构出院信息交易（泰康->东软） */
  public ErrorReason getNurseOutInfo(NurseOutInfo nurseOutInfo);
}
