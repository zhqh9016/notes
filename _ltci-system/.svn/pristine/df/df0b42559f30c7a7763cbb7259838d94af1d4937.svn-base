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
import com.taikang.dic.ltci.service.DiseaseService;

@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class DiseaseController {
  private Logger logger = LoggerFactory.getLogger(DiseaseController.class);

  @Autowired private DiseaseService diseaseService;

  @RequestMapping(value = "/disease/list", method = RequestMethod.GET)
  public PageResultDTO getDisease(
      @RequestParam(value = "name", defaultValue = "") String name,
      @RequestParam(value = "page", defaultValue = "1") int page,
      @RequestParam(value = "pageSize", defaultValue = "15") int pageSize) {

    return diseaseService.getDisease(name, page, pageSize);
  }
}
