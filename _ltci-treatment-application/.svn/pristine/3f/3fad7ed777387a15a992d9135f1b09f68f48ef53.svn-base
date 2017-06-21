package com.taikang.dic.ltci.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taikang.dic.ltci.common.ws.InsuredInfo;
import com.taikang.dic.ltci.common.ws.LongtermCareService;
import com.taikang.dic.ltci.common.ws.TreatmentState;
import com.taikang.dic.ltci.config.WSConfig;
import com.taikang.dic.ltci.service.WSService;

/**
 * 调用社保局接口查询参保人信息
 *
 * @author itw_liuxy
 * @description
 * @createTime 2017年4月17日 下午6:14:17
 */
@Service
public class WSServiceImpl implements WSService {
  private static final Logger logger = LoggerFactory.getLogger(WSServiceImpl.class);

  @Autowired private WSConfig config;

  @Override
  public InsuredInfo selectInsuredInfo(
      String idCardNum, String insuredPersonName, String uniqueNumber, String operator) {
    logger.info(
        "----------selectInsuredInfo:----idCardNum="
            + idCardNum
            + "-----insuredPersonName="
            + insuredPersonName
            + "-------");
    LongtermCareService service = config.longtermCaseService();
    if (service == null) {
      return null;
    }
    InsuredInfo info =
        service.queryInsuredInfo(idCardNum, insuredPersonName, uniqueNumber, operator);
    return info;
  }

  @Override
  public TreatmentState selectApplicationStatus(
      String idCardNum, String insuredPersonName, String uniqueNumber, String operator) {
    logger.info(
        "----------selectInsuredInfo:----idCardNum="
            + idCardNum
            + "-----insuredPersonName="
            + insuredPersonName
            + "-------");
    LongtermCareService service = config.longtermCaseService();
    if (service == null) {
      return null;
    }
    TreatmentState info =
        service.queryNurseTreatment(idCardNum, insuredPersonName, uniqueNumber, operator);
    return info;
  }
}
