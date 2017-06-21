package com.taikang.dic.ltci.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.taikang.dic.ltci.api.model.InsuredPersonDTO;
import com.taikang.dic.ltci.api.model.RestResponseDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.JsonUtils;
import com.taikang.dic.ltci.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.common.utils.DateFormatUtil;
import com.taikang.dic.ltci.model.InsuredPersonDO;
import com.taikang.dic.ltci.service.InsuredPersonService;

/** @author itw_liuxy 2017年3月29日18:15:09 参保人表查，增，改操作 */
@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class InsuredPersonController {
  private static final Logger logger = LoggerFactory.getLogger(InsuredPersonController.class);

  @Autowired private InsuredPersonService insuredPersonService;

  /**
   * 根据身份证号和姓名查询用户信息
   *
   * @param idCard
   * @param securityNumber
   * @return
   */
  @RequestMapping(
    path = "/insuredPerson/{idCard}/and/{insuredPersonName}/{uniqueNumber}/{operator}",
    method = RequestMethod.GET
  )
  public RestResponseDTO getInsuredPerson(
      @PathVariable String idCard,
      @PathVariable String insuredPersonName,
      @PathVariable String uniqueNumber,
      @PathVariable String operator) {
    logger.info("====Controller层：getInsuredPerson方法========");
    logger.debug("IdCard:" + idCard + "  insuredPersonName:" + insuredPersonName);
    if (StringUtils.isEmpty(uniqueNumber)) {
      uniqueNumber = "jingmen";
    }
    if (StringUtils.isEmpty(operator)) {
      operator = "jingban";
    }
    ResultDTO resultDTO =
        insuredPersonService.getInsuredPerson(idCard, insuredPersonName, uniqueNumber, operator);
    RestResponseDTO baseModel = new RestResponseDTO();
    baseModel.setData(resultDTO);
    return baseModel;
  }

  /**
   * 编辑参保人
   *
   * @param insuredPersonDTO
   */
  @RequestMapping(path = "/insuredPerson", method = RequestMethod.PUT)
  public RestResponseDTO updateInsuredPerson(@RequestBody InsuredPersonDTO insuredPersonDTO) {
    InsuredPersonDO insuredPersonDO = new InsuredPersonDO();
    BeanUtils.copyProperties(insuredPersonDTO, insuredPersonDO);
    String insuredPersonid = insuredPersonService.updateInsuredPerson(insuredPersonDO);

    Map<String, String> resultMap = new HashMap<>();
    resultMap.put("insuredPersonid", insuredPersonid);

    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setDatas(JsonUtils.makeJsonForObjectWithoutFormat(resultMap));
    resultDTO.setMessage("修改成功");
    resultDTO.setStatus(StatusCodeEnum.CREATED.getValue());
    RestResponseDTO baseModel = new RestResponseDTO();
    baseModel.setData(resultDTO);
    return baseModel;
  }

  /**
   * 新增参保人信息
   *
   * @param insuredPersonDTO
   */
  @RequestMapping(path = "/insuredPerson", method = RequestMethod.POST)
  public RestResponseDTO createInsuredPerson(@RequestBody InsuredPersonDTO insuredPersonDTO) {
    InsuredPersonDO insuredPersonDO = new InsuredPersonDO();
    BeanUtils.copyProperties(insuredPersonDTO, insuredPersonDO);
    insuredPersonDO.setBirthday(
        DateFormatUtil.StrToDate(
            insuredPersonDTO.getBirthday(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD));
    String insuredPersonCode = insuredPersonService.createInsuredPerson(insuredPersonDO);

    Map<String, String> resultMap = new HashMap<>();
    resultMap.put("insuredPersonCode", insuredPersonCode);

    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setDatas(JsonUtils.makeJsonForObjectWithoutFormat(resultMap));
    resultDTO.setMessage("新增成功");
    resultDTO.setStatus(StatusCodeEnum.CREATED.getValue());
    RestResponseDTO baseModel = new RestResponseDTO();
    baseModel.setData(resultDTO);
    return baseModel;
  }

  /**
   * 根据insuredPersonCode
   *
   * @param idCard
   * @return
   */
  @RequestMapping(path = "/insuredPerson/{insuredPersonCode}", method = RequestMethod.GET)
  public ResultDTO getInsuredPersonMessage(@PathVariable String insuredPersonCode) {
    logger.info("====评估护理feign调用接口查询参保人信息========");
    logger.debug("insuredPersonCode:" + insuredPersonCode);

    ResultDTO resultDTO = insuredPersonService.getInsuredPersonMessage(insuredPersonCode);
    return resultDTO;
  }

  /**
   * 根据参保人编号或身份证号或社保卡号查询对应的参保人信息
   *
   * @param insuredPersonCode
   * @param idCard
   * @param securityNum
   * @return
   */
  @RequestMapping(path = "/insuredPersonDetails", method = RequestMethod.GET)
  public ResultDTO getInsuredPersonDetail(
      @RequestParam(value = "insuredPersonCode") String insuredPersonCode,
      @RequestParam(value = "idCard") String idCard,
      @RequestParam(value = "securityNumber") String securityNumber) {
    logger.info("====Controller层：getInsuredPersonDetail方法========");
    logger.debug(
        "IdCard:"
            + idCard
            + "  insuredPersonCode:"
            + insuredPersonCode
            + "  securityNumber:"
            + securityNumber);

    return insuredPersonService.getInsuredPersonDetail(insuredPersonCode, idCard, securityNumber);
  }
}
