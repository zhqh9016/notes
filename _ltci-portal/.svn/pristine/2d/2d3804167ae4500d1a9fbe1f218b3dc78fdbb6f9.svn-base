package com.taikang.dic.ltci.evaluate.nursing.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.taikang.dic.ltci.evaluate.nursing.service.FirstEvaluateService;
import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.portal.common.util.UserUtils;

@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class FirstEvaluateController {

  private static final Logger logger = LoggerFactory.getLogger(FirstEvaluateController.class);

  @Autowired private FirstEvaluateService firstEvaluateService;

  @RequestMapping(value = "/firstEvaluate", method = RequestMethod.POST)
  @ResponseBody
  public PageResultDTO getFirstEvaluate(
      String insuredPersonName,
      String idCard,
      String evaluateOrg,
      String operatedTime,
      @RequestParam(value = "page", defaultValue = "1") int page,
      @RequestParam(value = "pageSize", defaultValue = "15") int pageSize) {
    logger.debug("=======进入初评结果查询接口===============");
    logger.debug("=======insuredPersonName【" + insuredPersonName + "】========");
    logger.debug("=======idCard【" + idCard + "】========");
    logger.debug("=======evaluateOrg【" + evaluateOrg + "】========");
    logger.debug("=======operatedTime【" + operatedTime + "】========");
    logger.debug("=======进入初评结果查询接口结束===============");

    PageResultDTO pageResultDTO =
        firstEvaluateService.getFirstEvaluate(
            insuredPersonName, idCard, evaluateOrg, operatedTime, page, pageSize);
    return pageResultDTO;
  }

  /**
   * 初评结果接收量表信息查询
   *
   * @param firstEvaluateCode
   * @return
   */
  @RequestMapping(path = "/firstEvaluate/{firstEvaluateCode}", method = RequestMethod.GET)
  public ResultDTO getFirstDetail(@PathVariable String firstEvaluateCode) {
    logger.debug("====firstEvaluateCode【" + firstEvaluateCode + "】=========");
    return firstEvaluateService.getFirstDetail(firstEvaluateCode);
  }
}
