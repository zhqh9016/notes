package com.taikang.dic.ltci.quality.control.serviceClient;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.taikang.dic.ltci.portal.api.model.EvaluateTaskProfessionDTO;
import com.taikang.dic.ltci.portal.api.model.NursingTaskProfessionDTO;
import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.PatrolTaskDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.quality.control.model.PatrolTaskAddDO;

@FeignClient(name = "${feign.quality.control.client}", url = "${feign.quality.control.url}")
public interface PatrolTaskServiceClient {

  @RequestMapping(path = "/api/v1/mobileCompliain/receive/retry", method = RequestMethod.POST)
  public void getMobileCompliain(@RequestBody String message);

  @RequestMapping(value = "/api/v1/patrol", method = RequestMethod.POST)
  public ResultDTO addPatrol(@RequestBody PatrolTaskAddDO patrolTaskAddDO);

  @RequestMapping(value = "/api/v1/patrolTasks", method = RequestMethod.POST)
  public PageResultDTO listPatrolTask(
      @RequestBody PatrolTaskDTO patrolTaskDTO,
      @RequestParam(value = "page") int page,
      @RequestParam(value = "pageSize") int pageSize);

  @RequestMapping(value = "/api/v1/patrolTasks/allot", method = RequestMethod.PUT)
  public ResultDTO patrolTaskAllot(
      @RequestParam(value = "patrolTaskId") String patrolTaskId,
      @RequestParam(value = "patrolStaffId") String patrolStaffId,
      @RequestParam(value = "patrolStaffName") String patrolStaffName,
      @RequestParam(value = "operatedBy") String operatedBy,
      @RequestParam(value = "operatedOrg") String operatedOrg);

  /**
   * 巡查评估任务新增
   *
   * @param evaluateTaskProfessionDTOs
   * @return
   */
  @RequestMapping(method = RequestMethod.POST, value = "/api/v1/evaluateTaskProfessionAdd")
  ResultDTO expertTaskProfessionAdd(
      @RequestBody List<EvaluateTaskProfessionDTO> evaluateTaskProfessionDTOs);

  /**
   * 巡查护理任务新增
   *
   * @param nursingTaskProfessionDTOs
   * @return
   */
  @RequestMapping(method = RequestMethod.POST, value = "/api/v1/nursingTaskProfessionAdd")
  ResultDTO nursingTaskProfessionAdd(List<NursingTaskProfessionDTO> nursingTaskProfessionDTOs);

  /**
   * 公用详情查询
   *
   * @param patrolTaskId
   * @return
   */
  @RequestMapping(method = RequestMethod.GET, value = "/api/v1/patrolTasks/{patrolTaskId}")
  ResultDTO patrolTaskDetails(@RequestParam(value = "patrolTaskId") String patrolTaskId);

  /**
   * 判断哪些机构任务id已经新增
   *
   * @param evaluateTaskProfessionDTOs
   * @return
   */
  @RequestMapping(method = RequestMethod.POST, value = "/api/v1/isHaveEvaluateOrgTaskId")
  ResultDTO isHaveEvaluateOrgTaskId(
      @RequestBody List<EvaluateTaskProfessionDTO> evaluateTaskProfessionDTOs);

  @RequestMapping(method = RequestMethod.POST, value = "/api/v1/isHaveNursingOrgTask")
  ResultDTO isHaveNursingOrgTaskId(
      @RequestBody List<NursingTaskProfessionDTO> nursingTaskProfessionDTOs);
}
