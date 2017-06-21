package com.taikang.dic.ltci.quality.control.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.taikang.dic.ltci.portal.api.model.ExecuteResultDTO;
import com.taikang.dic.ltci.portal.api.model.RExecuteFileDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.quality.control.service.PatrolTaskExecuteService;

@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class PatrolTaskExecuteController {

  @Autowired private PatrolTaskExecuteService taskExecuteService;

  /**
   * 附件提交
   *
   * @param file
   * @return
   */
  @RequestMapping(
    value = "/taskExecute/result/file",
    method = RequestMethod.POST,
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  @ResponseBody
  public ResultDTO uploadPatrolTaskExecute(
      @RequestParam(value = "executeFile", required = true) MultipartFile file) {
    return taskExecuteService.uploadPatrolTaskExecute(file);
  }

  /**
   * 录入巡查意见
   *
   * @return
   */
  @RequestMapping(
    value = "/taskExecute/resources",
    method = RequestMethod.POST,
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  @ResponseBody
  public ResultDTO createPatrolTaskExecute(@RequestBody ExecuteResultDTO executeResultDto) {
    return taskExecuteService.createPatrolTaskExecute(executeResultDto);
  }

  /**
   * 附件删除
   *
   * @param file
   * @return
   */
  @RequestMapping(value = "/taskExecute/result/{fileid}/{suffix}", method = RequestMethod.DELETE)
  @ResponseBody
  public ResultDTO deleteExecuteFile(@PathVariable String fileid, @PathVariable String suffix) {
    return taskExecuteService.deleteExecuteFile(fileid, suffix);
  }

  /**
   * 查看执行结果资源附件
   *
   * @param file
   * @return
   */
  @RequestMapping(value = "/taskExecute/resources/{patrolTaskId}", method = RequestMethod.GET)
  @ResponseBody
  public ResultDTO getPatrolTaskExecuteFile(@PathVariable String patrolTaskId) {
    return taskExecuteService.getPatrolTaskExecuteFile(patrolTaskId);
  }

  /**
   * 查询MongoDB附件信息
   *
   * @param executeFileDto
   * @return
   */
  @RequestMapping(value = "/taskExecute/mongoDBMessage", method = RequestMethod.GET)
  public void getMongoDBMessage(
      RExecuteFileDTO executeFileDto, HttpServletRequest request, HttpServletResponse response) {
    taskExecuteService.getMongoDBMessage(executeFileDto, request, response);
  }
}
