package com.taikang.dic.ltci.controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taikang.dic.ltci.api.model.RestResponseDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.exception.ParametersIsNullException;
import com.taikang.dic.ltci.service.MQMessageService;

@Controller
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class MQMessageController {
  private Logger logger = LoggerFactory.getLogger(MQMessageController.class);
  @Autowired private MQMessageService mqMessageService;

  @RequestMapping(value = "/mqMessages/{sendStatTime}/{sendEndTime}", method = RequestMethod.PUT)
  @ResponseBody
  public RestResponseDTO repeatMQMessage(
      @PathVariable String sendStatTime, @PathVariable String sendEndTime) {

    logger.info("sendStatTime:" + sendStatTime);
    logger.info("sendEndTime:" + sendEndTime);
    if (StringUtils.isBlank(sendStatTime) || StringUtils.isBlank(sendEndTime)) {
      throw new ParametersIsNullException("输入参数不完整");
    }
    ResultDTO dto = mqMessageService.repeatMQMessage(sendStatTime, sendEndTime);
    RestResponseDTO responseDTO = new RestResponseDTO();
    responseDTO.setData(dto);
    return responseDTO;
  }
}
