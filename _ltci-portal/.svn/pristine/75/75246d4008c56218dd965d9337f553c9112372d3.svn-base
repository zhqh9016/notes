package com.taikang.dic.ltci.quality.control.serviceClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taikang.dic.ltci.portal.api.model.ExecuteResultDTO;
import com.taikang.dic.ltci.portal.api.model.RestResponseDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;

@FeignClient(name = "${feign.quality.control.client}", url = "${feign.quality.control.url}")
public interface PatrolTaskExecuteServiceClient {

  /**
   * 附件提交
   *
   * @param base64
   * @param systemCode
   * @return
   */
  @RequestMapping(method = RequestMethod.POST, value = "/api/v1/taskExecute/result/file")
  RestResponseDTO uploadPatrolTaskExecute(
      @RequestBody String base64, @RequestParam(value = "systemCode") String systemCode);

  /**
   * 生成执行结果资源中间表数据
   *
   * @param base64
   * @param systemCode
   * @return
   */
  @RequestMapping(method = RequestMethod.POST, value = "/api/v1/taskExecute/resources")
  ResultDTO createPatrolTaskExecute(
      @RequestBody ExecuteResultDTO executeResultDto,
      @RequestParam(value = "systemCode") String systemCode);

  /**
   * 附件删除
   *
   * @param fileid
   * @param systemCode
   * @return
   */
  @RequestMapping(value = "/api/v1/taskExecute/result/{fileid}", method = RequestMethod.DELETE)
  @ResponseBody
  RestResponseDTO deleteExecuteFile(
      @PathVariable(value = "fileid") String fileid,
      @RequestParam(value = "systemCode") String systemCode);

  /**
   * 查看执行结果资源附件
   *
   * @param patrolTaskId
   * @return
   */
  @RequestMapping(
    value = "/api/v1/taskExecute/resources/{patrolTaskId}",
    method = RequestMethod.GET
  )
  @ResponseBody
  ResultDTO getPatrolTaskExecuteFile(
      @PathVariable(value = "patrolTaskId") String patrolTaskId,
      @RequestParam(value = "systemCode") String systemCode);

  /**
   * 查询MongoDB附件信息
   *
   * @param id
   * @return
   */
  @RequestMapping(method = RequestMethod.POST, value = "/api/v1/taskExecute/mongoDBMessage")
  ResultDTO getMongoDBMessage(@RequestParam(value = "id") String id);

  /**
   * 根据任务主键查询任务结果信息
   *
   * @param patrolTaskId
   * @param systemCode
   * @return
   */
  @RequestMapping(value = "/api/v1/taskExecute/{patrolTaskId}", method = RequestMethod.GET)
  @ResponseBody
  ResultDTO getPatrolTaskResultByTaskId(
      @PathVariable(value = "patrolTaskId") String patrolTaskId,
      @RequestParam(value = "systemCode") String systemCode);
}
