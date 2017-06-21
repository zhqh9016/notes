package com.taikang.dic.ltci.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taikang.dic.ltci.api.model.PageResultDTO;
import com.taikang.dic.ltci.api.model.RestResponseDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.service.ExpertEvaluateService;

@Controller
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class ExpertEvaluateController {

  private Logger logger = LoggerFactory.getLogger(ExpertEvaluateController.class);

  @Autowired private ExpertEvaluateService expertEvaluateService;

  @RequestMapping(value = "/expertEvaluate", method = RequestMethod.POST)
  @ResponseBody
  public RestResponseDTO getExpertEvaluate(
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
    PageResultDTO dto =
        expertEvaluateService.getExpertEvaluateList(
            insuredPersonName,
            idCard,
            evaluateAgencyName,
            operatedStartTime,
            operatedEndTime,
            page,
            pageSize);

    RestResponseDTO responseDTO = new RestResponseDTO();
    responseDTO.setData(dto);
    return responseDTO;
  }

  @RequestMapping(value = "/expertEvaluat/{expertEvaluateCode}", method = RequestMethod.GET)
  @ResponseBody
  public RestResponseDTO getExpertEvaluateScan(@PathVariable String expertEvaluateCode) {
    logger.info("expertEvaluateCode:" + expertEvaluateCode);
    Map<String, Object> map = expertEvaluateService.getExpertEvaluateScan(expertEvaluateCode);

    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setDatas(map);
    resultDTO.setMessage("查询成功");
    resultDTO.setStatus(StatusCodeEnum.OK.getValue());

    RestResponseDTO responseDTO = new RestResponseDTO();
    responseDTO.setData(resultDTO);
    return responseDTO;
  }

  /** 提交专家评定的具体细节 */
  @RequestMapping(value = "/expertEvaluat/detial", method = RequestMethod.PUT)
  @ResponseBody
  public RestResponseDTO putExpertEvaluate(
      String expertEvaluateCode,
      String accessoryAddress,
      String evaluateContent,
      int fraction,
      String opinion,
      String operatedBy,
      String operatedOrg) {
    logger.info("expertEvaluateCode:" + expertEvaluateCode);
    logger.info("accessoryAddress:" + accessoryAddress);
    logger.info("evaluateContent:" + evaluateContent);
    logger.info("fraction:" + fraction);
    logger.info("opinion:" + opinion);
    logger.info("operatedBy:" + operatedBy);
    logger.info("operatedOrg:" + operatedOrg);
    ResultDTO dto =
        expertEvaluateService.putExpertEvaluate(
            expertEvaluateCode,
            accessoryAddress,
            evaluateContent,
            fraction,
            opinion,
            operatedBy,
            operatedOrg);

    RestResponseDTO responseDTO = new RestResponseDTO();
    responseDTO.setData(dto);
    return responseDTO;
  }
}
