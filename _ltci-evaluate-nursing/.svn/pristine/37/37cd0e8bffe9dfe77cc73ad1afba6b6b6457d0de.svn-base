package com.taikang.dic.ltci.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.common.ws.ChanghuCard;
import com.taikang.dic.ltci.common.ws.ErrorReason;
import com.taikang.dic.ltci.common.ws.LongtermCareService;
import com.taikang.dic.ltci.common.ws.NurseInInfo;
import com.taikang.dic.ltci.common.ws.NurseOutInfo;
import com.taikang.dic.ltci.configration.WSConfig;
import com.taikang.dic.ltci.service.WSService;

/**
 * 调用东软接口进行护理机构的登记与退出
 *
 * @author itw_liuxy
 * @description
 * @createTime 2017年4月17日 上午11:05:46
 */
@Service
public class WSServiceImpl implements WSService {
  private static final Logger logger = LoggerFactory.getLogger(WSServiceImpl.class);
  @Autowired private WSConfig config;

  /** 居家/入住护理机构登记信息交易（泰康->东软） */
  @Override
  public ErrorReason registNurseInfo(NurseInInfo registRequest, ChanghuCard changhuCard) {
    LongtermCareService service = config.longtermCaseService();
    if (service == null) {
      return null;
    }
    logger.info("----------------护理机构登记信息交易：registNurseInfo-------------------");
    logger.info(
        "----------------入参：NurseInInfo："
            + JSONObject.toJSONString(registRequest)
            + "-------------------");
    logger.info(
        "----------------入参：ChanghuCard："
            + JSONObject.toJSONString(changhuCard)
            + "-------------------");
    ErrorReason errorReason = service.registNurseInfo(registRequest, changhuCard);
    logger.info(
        "----------------出参：ErrorReason"
            + JSONObject.toJSONString(errorReason)
            + "-------------------");
    return errorReason;
  }

  /** 居家/入住护理机构出院信息交易（泰康->东软） */
  @Override
  public ErrorReason getNurseOutInfo(NurseOutInfo nurseOutInfo) {
    LongtermCareService service = config.longtermCaseService();
    if (service == null) {
      return null;
    }
    logger.info("----------------护理机构出院信息交易：getNurseOutInfo-------------------");
    logger.info(
        "----------------入参：NurseOutInfo："
            + JSONObject.toJSONString(nurseOutInfo)
            + "-------------------");
    ErrorReason errorReason = service.getNurseOutInfo(nurseOutInfo);
    logger.info(
        "----------------出参：ErrorReason"
            + JSONObject.toJSONString(errorReason)
            + "-------------------");
    return errorReason;
  }
}
