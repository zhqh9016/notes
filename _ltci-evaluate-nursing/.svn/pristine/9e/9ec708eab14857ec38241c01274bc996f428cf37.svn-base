package com.taikang.dic.ltci.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.api.model.FirstEvaluateDTO;
import com.taikang.dic.ltci.api.model.PageResultDTO;
import com.taikang.dic.ltci.api.model.RestResponseDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.enumeration.ExecutionStatusEnum;
import com.taikang.dic.ltci.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.common.log.ThreadLocalUtil;
import com.taikang.dic.ltci.common.util.DateFormatUtil;
import com.taikang.dic.ltci.model.FirstEvaluateSpecialDO;
import com.taikang.dic.ltci.service.FirstEvaluateService;

@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class FirstEvaluateController {

  private static final Logger logger = LoggerFactory.getLogger(FirstEvaluateController.class);

  @Autowired private FirstEvaluateService firstEvaluateService;

  public static final String RETRY_URL = "/firstEvaluate/receive/retry";

  @RequestMapping(path = "/firstEvaluate/receive/retry", method = RequestMethod.POST)
  public ResultDTO getMobileCompliain(@RequestParam String message) {
    ResultDTO resultDTO = new ResultDTO();
    try {
      return firstEvaluateService.insertMqMessageLog(message);
    } catch (Exception e) {
      logger.error("初评结果接收出错：", e);
      resultDTO.setStatus(ExecutionStatusEnum.FAILD.getValue());
    }
    return resultDTO;
  }

  @SuppressWarnings("unchecked")
  @RequestMapping(value = "/firstEvaluate", method = RequestMethod.POST)
  public RestResponseDTO getFirstEvaluate(
      String insuredPersonName,
      String idCard,
      String evaluateOrg,
      String operatedTime,
      @RequestParam(value = "page", defaultValue = "1") int page,
      @RequestParam(value = "pageSize", defaultValue = "15") int pageSize) {
    logger.debug("=======进入初评结果查询接口===============");
    logger.debug("=======insuredPersonName【" + insuredPersonName + "】=======");
    logger.debug("=======idCard【" + idCard + "】======");
    logger.debug("=======evaluateOrg【" + evaluateOrg + "】========");
    logger.debug("=======operatedTime【" + operatedTime + "】========");
    String operatedOrg = ThreadLocalUtil.threadLocal.get().getOperatedOrg();
    if (!StringUtils.isEmpty(operatedOrg)) {
      logger.debug("=======operatedOrg【" + operatedOrg + "】========");
    }

    Map<String, Object> map =
        firstEvaluateService.getFirstEvaluate(
            insuredPersonName, idCard, evaluateOrg, operatedTime, page, pageSize, operatedOrg);

    List<FirstEvaluateSpecialDO> firstEvaluateSpecialDOs =
        (List<FirstEvaluateSpecialDO>) map.get("firstEvaluateSpecialDOs");
    logger.debug("firstEvaluateSpecialDOs:" + JSONObject.toJSONString(firstEvaluateSpecialDOs));
    List<FirstEvaluateDTO> firstEvaluateDTOs = new ArrayList<>();
    for (FirstEvaluateSpecialDO firstEvaluateSpecialDO : firstEvaluateSpecialDOs) {
      FirstEvaluateDTO firstEvaluateDTO = new FirstEvaluateDTO();
      BeanUtils.copyProperties(firstEvaluateSpecialDO, firstEvaluateDTO);
      firstEvaluateDTO.setScore(firstEvaluateSpecialDO.getScore().toString().split("\\.")[0]);
      firstEvaluateDTO.setOperatedTime(
          DateFormatUtil.dateToStr(
              firstEvaluateSpecialDO.getOperatedTime(),
              DateFormatUtil.DATE_FORMAT_YYYY_MM_DD_HH_MM_SS));
      firstEvaluateDTOs.add(firstEvaluateDTO);
    }
    logger.debug("firstEvaluateDTOs:" + JSONObject.toJSONString(firstEvaluateDTOs));

    Integer count = (Integer) map.get("count");
    Integer totalPage = (Integer) map.get("totalPage");
    PageResultDTO pageResultDTO = new PageResultDTO();
    pageResultDTO.setDatas(firstEvaluateDTOs);
    pageResultDTO.setMessage("查询成功");
    pageResultDTO.setPage(page);
    pageResultDTO.setPageSize(pageSize);
    pageResultDTO.setTotalDataNum(count);
    pageResultDTO.setTotalPageNum(totalPage);
    pageResultDTO.setStatus(StatusCodeEnum.OK.getValue());
    logger.debug("pageResultDTO:" + JSONObject.toJSONString(pageResultDTO));
    logger.debug("=======进入初评结果查询接口结束===============");

    RestResponseDTO responseDTO = new RestResponseDTO();
    responseDTO.setData(pageResultDTO);
    return responseDTO;
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

    FirstEvaluateSpecialDO firstEvaluateSpecialDO;
    try {
      firstEvaluateSpecialDO = firstEvaluateService.getFirstDetail(firstEvaluateCode);
      logger.debug(
          "=======evaluateTaskCode【" + firstEvaluateSpecialDO.getEvaluateTaskCode() + "】======");
      ResultDTO resultDTO = new ResultDTO();
      resultDTO.setDatas(firstEvaluateSpecialDO);
      resultDTO.setMessage("查询成功");
      resultDTO.setStatus(StatusCodeEnum.OK.getValue());
      return resultDTO;
    } catch (Exception e) {
      logger.error("查询量表信息出错", e);
      ResultDTO resultDTO = new ResultDTO();
      resultDTO.setMessage("查询失败");
      resultDTO.setStatus(StatusCodeEnum.NOT_FOUND.getValue());
      return resultDTO;
    }
  }
}
