package com.taikang.dic.ltci.portal.common.restRequestResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.RestResponseDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;

public class RestResponseFormat {
  private static Logger logger = LoggerFactory.getLogger(RestResponseFormat.class);
  /**
   * 将RestResponseDTO转ResultDTO
   *
   * @param restResponseDTO
   * @return
   */
  public static ResultDTO restResponseDTO2ResultDTO(RestResponseDTO restResponseDTO) {
    ResultDTO resultDTO = new ResultDTO();
    try {
      resultDTO =
          JSONObject.parseObject(
              JSONObject.toJSONString(restResponseDTO.getData()), ResultDTO.class);
    } catch (Exception e) {
      logger.error("从RestResponseDTO 转ResultDTO 出错：" + e);
    }
    return resultDTO;
  }

  /**
   * 将PageResultDTO转ResultDTO
   *
   * @param restResponseDTO
   * @return
   */
  public static PageResultDTO restResponseDTO2PageResultDTO(RestResponseDTO restResponseDTO) {
    PageResultDTO pageResultDTO = new PageResultDTO();
    try {
      pageResultDTO =
          JSONObject.parseObject(
              JSONObject.toJSONString(restResponseDTO.getData()), PageResultDTO.class);
    } catch (Exception e) {
      logger.error("从RestResponseDTO 转ResultDTO 出错：" + e);
    }
    return pageResultDTO;
  }
}
