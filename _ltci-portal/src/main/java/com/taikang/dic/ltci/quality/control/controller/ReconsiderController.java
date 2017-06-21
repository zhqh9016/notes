package com.taikang.dic.ltci.quality.control.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.taikang.dic.ltci.portal.api.model.ReconsiderDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.portal.common.util.FileTypeDecideUtil;
import com.taikang.dic.ltci.quality.control.service.IReconsiderService;

/**
 * 申述复议
 *
 * @author itw_zhangqh
 */
@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class ReconsiderController {

  @Autowired private IReconsiderService reconsiderService;

  private Logger log = LoggerFactory.getLogger(ReconsiderController.class);

  /**
   * 根据巡查任务id查询申述复议列表
   *
   * @param patrolTaskId
   * @return
   */
  @RequestMapping(value = "/reconsiders/{patrolTaskId}", method = RequestMethod.GET)
  public ResultDTO getReconsiderListByPatrolTaskId(
      @PathVariable("patrolTaskId") String patrolTaskId) {
    //根据巡查任务id查询申述复议列表
    log.info("==========Controller层  getReconsiderListByPatrolTaskId=============");
    log.info("==========patrolTaskId为:  " + patrolTaskId + "=============");
    ResultDTO result = reconsiderService.getReconsiderListByPatrolTaskId(patrolTaskId);
    result.setStatus(StatusCodeEnum.OK.getValue());
    return result;
  }

  /**
   * 保存申述回复,更新最后一条回复信息为空的记录
   *
   * @param patrolTaskId
   * @param content
   * @return
   */
  @RequestMapping(value = "/reconsiders", method = RequestMethod.POST)
  public ResultDTO saveReconsider(ReconsiderDTO reconsider) {
    log.info("==========Controller层 saveReconsider=============");
    log.info("==========回复信息为:  " + reconsider);
    ResultDTO result = new ResultDTO();

    //复议时必须指定任务ID
    if (StringUtils.isBlank(reconsider.getPatrolTaskId())) {
      result.setStatus(407);
      result.setMessage("复议时必须指定任务ID");
      return result;
    }
    result = reconsiderService.saveReconsider(reconsider);
    return result;
  }

  @RequestMapping(value = "/reconsiderFile", method = RequestMethod.GET)
  public void getFile(
      HttpServletRequest request, HttpServletResponse response, String fileId, String fileType)
      throws IOException {
    UUID randomUUID = UUID.randomUUID();
    ServletOutputStream outputStream = response.getOutputStream();
    String type = FileTypeDecideUtil.getFileType(fileType);
    byte[] bs = null;
    try {
      bs = reconsiderService.getReconsiderFile(fileId, type);
    } catch (Exception e) {
      log.error("获取申述复议附件时发生异常", e);
      outputStream.write("<h1>服务器异常,请稍后重试</h1>".getBytes());
      return;
    }
    response.setHeader("Content-Disposition", "attachment;filename=" + randomUUID + "." + fileType);
    outputStream.write(bs);
    outputStream.flush();
  }
}
