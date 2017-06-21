package com.taikang.dic.ltci.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.taikang.dic.ltci.api.model.ApplicationDTO;
import com.taikang.dic.ltci.api.model.RestResponseDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.JsonUtils;
import com.taikang.dic.ltci.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.common.exception.NotFoundByIdException;
import com.taikang.dic.ltci.common.exception.ParametersIsNullException;
import com.taikang.dic.ltci.common.utils.DateFormat;
import com.taikang.dic.ltci.model.ApplicationComplexDO;
import com.taikang.dic.ltci.model.ApplicationDO;
import com.taikang.dic.ltci.model.ApplicationSimpleDO;
import com.taikang.dic.ltci.service.ApplicationService;

/** @author itw_caoxy 待遇申请查询接口 */
@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class ApplicationCotroller {

  private static final Logger logger = LoggerFactory.getLogger(ApplicationCotroller.class);

  @Autowired private ApplicationService applicationService;

  @RequestMapping(
    value = "/insuredPerson/{idCard}/{securityNumber}/{insuredPersonName}/deputy/{deputyIdCard}",
    method = RequestMethod.GET
  )
  public RestResponseDTO getApplicationState(
      @PathVariable String idCard,
      @PathVariable String securityNumber,
      @PathVariable String insuredPersonName,
      @PathVariable String deputyIdCard) {

    if (idCard == null
        || "".equals(idCard)
        || securityNumber == null
        || "".equals(securityNumber)
        || deputyIdCard == null
        || "".equals(deputyIdCard)
        || insuredPersonName == null
        || "".equals(insuredPersonName)) {
      throw new ParametersIsNullException("输入参数的不能为空");
    }

    ResultDTO resultDTO =
        applicationService.getApplicationState(
            idCard, securityNumber, insuredPersonName, deputyIdCard);
    //    ResultDTO resultDTO = new ResultDTO();
    //    Map<String, String> resultMap = new HashMap<String, String>();
    //    resultMap.put("applicationStatus", applicationDO.getApplicationStatus());
    //    resultDTO.setDatas(resultMap);
    //    resultDTO.setMessage("查询成功");
    //    resultDTO.setStatus(200);
    RestResponseDTO response = new RestResponseDTO();
    response.setData(resultDTO);
    //    response.setBusinessSerialid(restBaseDTO.getBusinessSerialid());
    response.setTimestamp(DateFormat.getLongDateTime());
    return response;
  }

  @RequestMapping(value = "/application", method = RequestMethod.POST)
  public RestResponseDTO createApplication(@RequestBody ApplicationDTO applicationDTO) {
    logger.info("====Controller层：进入createApplication方法开始========");
    ApplicationDO applicationDO = new ApplicationDO();
    BeanUtils.copyProperties(applicationDTO, applicationDO);
    logger.info("====Controller层：applicationDO：" + applicationDO + "========");

    ResultDTO resultDTO = new ResultDTO();
    Map<String, String> resultMap = new HashMap<String, String>();
    String applicationCode = applicationService.createApplication(applicationDO);
    resultMap.put("applicationCode", applicationCode);
    resultDTO.setDatas(JsonUtils.makeJsonForObjectWithoutFormat(resultMap));
    resultDTO.setNumber(1);
    resultDTO.setMessage("添加成功");
    resultDTO.setStatus(StatusCodeEnum.CREATED.getValue());
    logger.info("====Controller层：进入createApplication方法结束========");

    RestResponseDTO baseModel = new RestResponseDTO();
    baseModel.setData(resultDTO);
    return baseModel;
  }

  @RequestMapping(value = "/simple/application", method = RequestMethod.POST)
  public ResultDTO getApplicationSimple(
      @RequestParam(value = "applicationCodes") String applicationCodes) {
    logger.debug(applicationCodes);
    List<String> applicationSimples = JSONArray.parseArray(applicationCodes, String.class);
    //    StringBuilder sb = new StringBuilder();
    //    for (int i = 0; i < applicationSimples.size(); i++) {
    //      sb.append("'").append(applicationSimples.get(i)).append("'").append(",");
    //    }
    //    String applications = sb.toString().substring(0, sb.toString().length() - 1);
    //    logger.debug(applications);
    return applicationService.getApplicationSimple(applicationSimples);
  }

  @RequestMapping(value = "/complex/application", method = RequestMethod.POST)
  public ResultDTO getApplicationComplex(
      @RequestParam(value = "applicationCodes") String applicationCodes) {
    List<String> applicationComplexs = JSONArray.parseArray(applicationCodes, String.class);
    //    StringBuilder sb = new StringBuilder();
    //    for (int i = 0; i < applicationComplexs.size(); i++) {
    //      sb.append("'").append(applicationComplexs.get(i)).append("'").append(",");
    //    }
    //    String applications = sb.toString().substring(0, sb.toString().length() - 1);
    if (applicationCodes.isEmpty()) {
      throw new NotFoundByIdException("根据待遇申请编号查询查询申请详细信息接口中待遇申请编号不能为空！");
    }
    logger.debug(applicationCodes);
    return applicationService.getApplicationComplex(applicationComplexs.get(0));
  }
}
