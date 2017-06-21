package com.taikang.dic.ltci.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.taikang.dic.ltci.api.model.DictionaryDTO;
import com.taikang.dic.ltci.api.model.PageResultDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.ParametersIsNullException;
import com.taikang.dic.ltci.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.common.util.DateFormatUtil;
import com.taikang.dic.ltci.model.DictionaryDO;
import com.taikang.dic.ltci.service.DictionaryService;

@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class DictionaryController {
  private Logger logger = LoggerFactory.getLogger(DictionaryController.class);

  @Autowired private DictionaryService dictionaryService;

  @RequestMapping(value = "/dictionary", method = RequestMethod.POST)
  public PageResultDTO getDictionary(
      @ModelAttribute DictionaryDTO dictionaryDTO,
      @RequestParam(value = "queryFlag", defaultValue = "one") String queryFlag,
      @RequestParam(value = "page", defaultValue = "1") int page,
      @RequestParam(value = "pageSize", defaultValue = "100") int pageSize) {
    logger.info(dictionaryDTO.toString() + "page:" + page + "pageSize:" + pageSize);
    return dictionaryService.getDictionary(dictionaryDTO, page, pageSize, queryFlag);
  }

  @RequestMapping(value = "/dictionary/{type}/and{value}", method = RequestMethod.GET)
  public ResultDTO getDictionaryDOByCondition(
      @PathVariable String type, @PathVariable String value) {
    ResultDTO dto = new ResultDTO();
    List<DictionaryDO> list = dictionaryService.getDictionaryDOByCondition(type, value);
    if (list.isEmpty()) {
      dto.setStatus(StatusCodeEnum.NOT_FOUND.getValue());
      dto.setMessage("未查询到type为" + type + "和value为" + value + "对应的数字字典！");
    } else {
      dto.setStatus(StatusCodeEnum.OK.getValue());
      dto.setDatas(list);
    }
    return dto;
  }

  @RequestMapping(value = "/new/dictionary", method = RequestMethod.POST)
  public ResultDTO addDictionary(@ModelAttribute DictionaryDO dictionaryDO) {
    logger.info(dictionaryDO.toString());
    //对数据进行完整判定
    if (dictionaryDO.getType() == null
        || dictionaryDO.getType().equals("")
        || dictionaryDO.getTypeName() == null
        || dictionaryDO.getTypeName().equals("")
        || dictionaryDO.getValue() == null
        || dictionaryDO.getValue().equals("")
        || dictionaryDO.getValueName() == null
        || dictionaryDO.getValueName().equals("")) {
      throw new ParametersIsNullException("输入参数不完整！");
    }

    ResultDTO resultDTO = new ResultDTO();
    dictionaryService.createDictionary(dictionaryDO);
    resultDTO.setStatus(200);
    resultDTO.setMessage("添加成功");
    logger.info(resultDTO.toString());
    return resultDTO;
  }

  @RequestMapping(value = "/diffrence/dictionary", method = RequestMethod.PUT)
  public ResultDTO updateDictionary(@ModelAttribute DictionaryDO dictionaryDO) {
    if (dictionaryDO.getType() == null
        || dictionaryDO.getType().equals("")
        || dictionaryDO.getTypeName() == null
        || dictionaryDO.getTypeName().equals("")
        || dictionaryDO.getValue() == null
        || dictionaryDO.getValue().equals("")
        || dictionaryDO.getValueName() == null
        || dictionaryDO.getValueName().equals("")
        || dictionaryDO.getId() == null
        || dictionaryDO.getId().equals("")) {
      throw new ParametersIsNullException("输入参数不完整！");
    }

    logger.info(dictionaryDO.toString());
    dictionaryService.updateDictionary(dictionaryDO);

    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setStatus(200);
    resultDTO.setMessage("修改成功");
    return resultDTO;
  }

  @RequestMapping(value = "/dictionary/{id}/user/{operatedBy}", method = RequestMethod.DELETE)
  public ResultDTO deleteDictionary(@PathVariable String id, @PathVariable String operatedBy) {
    logger.info("id:" + id + "operatedBy:" + operatedBy);
    if (id == null || id.equals("")) {
      throw new ParametersIsNullException("输入参数不完整！");
    }
    dictionaryService.deleteDictionary(id, operatedBy);
    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setStatus(200);
    resultDTO.setMessage("删除成功");
    return resultDTO;
  }

  @RequestMapping(value = "/dictionary/{id}/operatedBy/{operatedBy}", method = RequestMethod.PUT)
  public ResultDTO recoverDictionary(@PathVariable String id, @PathVariable String operatedBy) {
    logger.info("id:" + id + "operatedBy:" + operatedBy);
    if (id == null || id.equals("")) {
      throw new ParametersIsNullException("输入参数不完整！");
    }
    dictionaryService.recoverDictionary(id, operatedBy);
    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setStatus(200);
    resultDTO.setMessage("恢复成功");
    return resultDTO;
  }

  @RequestMapping(value = "/dictionary/maxOperateTime", method = RequestMethod.GET)
  public String getMaxOperateTime() {
    Date operateTime = dictionaryService.getMaxOperateTime();
    return DateFormatUtil.dateToTimeStr(operateTime);
  }
}
