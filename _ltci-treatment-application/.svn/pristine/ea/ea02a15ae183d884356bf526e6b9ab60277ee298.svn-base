package com.taikang.dic.ltci.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.taikang.dic.ltci.api.model.ApplicationLogDTO;
import com.taikang.dic.ltci.api.model.RestResponseDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.model.ApplicationLogDO;
import com.taikang.dic.ltci.service.ApplicationLogService;

/**
 * @author itw_liuxy
 * @description 待遇申请日志表操作
 * @createTime 2017年3月31日 上午10:43:16
 */
@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class ApplicationLogCotroller {
  private static final Logger logger = LoggerFactory.getLogger(ApplicationLogCotroller.class);

  @Autowired private ApplicationLogService applicationLogService;

  @RequestMapping(value = "/applicationLog", method = RequestMethod.POST)
  public RestResponseDTO createApplication(@RequestBody ApplicationLogDTO applicationLogDTO) {
    logger.info("====Controller层：进入createApplication方法开始========");
    ApplicationLogDO applicationLogDO = new ApplicationLogDO();
    BeanUtils.copyProperties(applicationLogDTO, applicationLogDO);
    logger.info("====Controller层：applicationLogDTO：" + applicationLogDTO + "========");

    ResultDTO resultDTO = new ResultDTO();
    applicationLogService.createApplicationLog(applicationLogDO);
    resultDTO.setMessage("添加成功");
    resultDTO.setStatus(StatusCodeEnum.CREATED.getValue());

    logger.info("====Controller层：进入createApplication方法结束========");
    RestResponseDTO baseModel = new RestResponseDTO();
    baseModel.setData(resultDTO);
    return baseModel;
  }
}
