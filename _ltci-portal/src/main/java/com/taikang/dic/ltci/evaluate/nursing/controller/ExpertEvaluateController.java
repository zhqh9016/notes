package com.taikang.dic.ltci.evaluate.nursing.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taikang.dic.ltci.evaluate.nursing.service.ExpertEvaluateService;
import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.treatment.application.common.ParametersIsNullException;

@Controller
@RequestMapping(value = "/api/v1", produces = "application/json;charset=utf-8")
public class ExpertEvaluateController {

  private Logger logger = LoggerFactory.getLogger(ExpertEvaluateController.class);

  @Autowired private ExpertEvaluateService expertEvaluateService;

  @RequestMapping(value = "/expertEvaluate", method = RequestMethod.POST)
  @ResponseBody
  public PageResultDTO getExpertEvaluate(
      String insuredPersonName,
      String idCard,
      String evaluateAgencyName,
      String operatedStartTime,
      String operatedEndTime,
      @RequestParam(name = "page", defaultValue = "1") int page,
      @RequestParam(name = "pageSize", defaultValue = "15") int pageSize) {
    logger.info("insuredPersonName:" + insuredPersonName);
    logger.info("idCard:" + idCard);
    logger.info("evaluateAgencyName:" + evaluateAgencyName);
    logger.info("operatedStartTime:" + operatedStartTime);
    logger.info("operatedEndTime:" + operatedEndTime);
    logger.info("page:" + page);
    logger.info("pageSize:" + pageSize);
    PageResultDTO pageResultDTO =
        expertEvaluateService.getExpertEvaluateList(
            insuredPersonName,
            idCard,
            evaluateAgencyName,
            operatedStartTime,
            operatedEndTime,
            page,
            pageSize);
    return pageResultDTO;
  }

  @RequestMapping(value = "/expertEvaluat/{expertEvaluateCode}", method = RequestMethod.GET)
  @ResponseBody
  public ResultDTO getExpertEvaluateScan(@PathVariable String expertEvaluateCode) {
    logger.info("expertEvaluateCode:" + expertEvaluateCode);
    return expertEvaluateService.getExpertEvaluateScan(expertEvaluateCode);
  }

  /** 提交专家评定的具体细节 */
  @RequestMapping(value = "/expertEvaluat/detial", method = RequestMethod.PUT)
  @ResponseBody
  public ResultDTO putExpertEvaluate(
      String expertEvaluateCode,
      String accessoryAddress,
      String evaluateContent,
      int fraction,
      String opinion) {
    logger.info("expertEvaluateCode:" + expertEvaluateCode);
    logger.info("accessoryAddress:" + accessoryAddress);
    logger.info("evaluateContent:" + evaluateContent);
    logger.info("fraction:" + fraction);
    logger.info("opinion:" + opinion);

    if (expertEvaluateCode == null
        || accessoryAddress == null
        || evaluateContent == null
        || fraction + "" == null
        || opinion == null) {
      throw new ParametersIsNullException("提交的参数不完整");
    }

    ResultDTO resultDTO =
        expertEvaluateService.putExpertEvaluate(
            expertEvaluateCode, accessoryAddress, evaluateContent, fraction, opinion);
    return resultDTO;
  }
}
