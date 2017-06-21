package com.taikang.dic.ltci.quality.control.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.taikang.dic.ltci.portal.api.model.EvaluateTaskProfessionDTO;
import com.taikang.dic.ltci.portal.api.model.NursingTaskProfessionDTO;
import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.PatrolTaskDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.api.model.UserDTO;
import com.taikang.dic.ltci.portal.common.util.UserUtils;
import com.taikang.dic.ltci.quality.control.service.PatrolTaskService;

/**
 * @author itw_xuxf
 * @description
 * @version 创建时间：2017年4月28日下午5:17:14
 */
/**
 * 巡查任务
 *
 * @author itw_xuxf
 * @version 2017年4月28日下午5:17:36
 */
@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class PatrolTaskController {
  private Logger logger = LoggerFactory.getLogger(PatrolTaskController.class);

  @Autowired private PatrolTaskService patrolTaskService;

  /**
   * 巡查任务查询 评估任务
   *
   * @param isCritical 是否紧急
   * @param beginTime 开始时间
   * @param endTime 结束时间
   * @param provinceCode 省编码
   * @param cityCode 市编码
   * @param areaCode 区域编码
   * @param orgCode 机构编码
   * @param page 页数
   * @param pageSize 条数
   * @return
   */
  @RequestMapping(value = "/evaluatePatrolTask", method = RequestMethod.POST)
  @ResponseBody
  public PageResultDTO getEvaluatePatrolTaskList(
      String isCritical,
      String beginTime,
      String endTime,
      String provinceCode,
      String cityCode,
      String areaCode,
      String orgCode,
      @RequestParam(name = "page", defaultValue = "1") int page,
      @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {
    PageResultDTO pageResultDTO =
        patrolTaskService.getEvaluatePatrolTaskList(
            isCritical,
            beginTime,
            endTime,
            provinceCode,
            cityCode,
            areaCode,
            orgCode,
            page,
            pageSize);
    return pageResultDTO;
  }

  /**
   * 巡查任务查询 护理任务
   *
   * @param serviceType 服务类型: 非全日居家护理、全日居家护理、机构护理、医疗护理
   * @param serviceItems 服务目录项（页面录入的）
   * @param isKinshipCare 是否特权通过
   * @param isPrivilege 是否亲属照护
   * @param beginTime 服务开始时间
   * @param endTime 服务结束时间
   * @param provinceCode 所属省份
   * @param cityCode 所属城市
   * @param areaCode 所属区域
   * @param orgCode 机构编号
   * @param page 当前页面
   * @param pageSize 每页展示的条数
   * @return
   */
  @RequestMapping(value = "/nursingPatrolTask", method = RequestMethod.POST)
  @ResponseBody
  public PageResultDTO getNursingPatrolTaskList(
      String serviceType,
      String serviceItems,
      String isKinshipCare,
      String isPrivilege,
      String beginTime,
      String endTime,
      String provinceCode,
      String cityCode,
      String areaCode,
      String orgCode,
      @RequestParam(name = "page", defaultValue = "1") int page,
      @RequestParam(name = "pageSize", defaultValue = "15") int pageSize) {
    logger.info("serviceType:" + serviceType);
    logger.info("serviceItems:" + serviceItems);
    logger.info("isKinshipCare:" + isKinshipCare);
    logger.info("isPrivilege:" + isPrivilege);
    logger.info("beginTime:" + beginTime);
    logger.info("endTime:" + endTime);
    logger.info("provinceCode:" + provinceCode);
    logger.info("cityCode:" + cityCode);
    logger.info("areaCode:" + areaCode);
    logger.info("orgCode:" + orgCode);
    logger.info("page:" + page);
    logger.info("pageSize:" + pageSize);
    PageResultDTO pageResultDTO =
        patrolTaskService.getNursingPatrolTaskList(
            serviceType,
            serviceItems,
            isKinshipCare,
            isPrivilege,
            beginTime,
            endTime,
            provinceCode,
            cityCode,
            areaCode,
            orgCode,
            page,
            pageSize);
    return pageResultDTO;
  }

  /**
   * 公用列表查询
   *
   * @param patrolTaskDTO
   * @param page
   * @param pageSize
   * @return
   */
  @RequestMapping(path = "/patrolTasks", method = RequestMethod.POST)
  @ResponseBody
  public PageResultDTO listPatrolTask(
      PatrolTaskDTO patrolTaskDTO,
      @RequestParam(value = "page", defaultValue = "1") int page,
      @RequestParam(value = "pageSize", defaultValue = "15") int pageSize) {
    PageResultDTO pageResultDTO = patrolTaskService.listPatrolTask(patrolTaskDTO, page, pageSize);

    return pageResultDTO;
  }

  /**
   * 任务分配接口
   *
   * @param patrolTaskDTO
   * @return
   */
  @RequestMapping(path = "/patrolTasks/allot", method = RequestMethod.PUT)
  @ResponseBody
  public ResultDTO patrolTaskAllot(
      @RequestParam(value = "patrolTaskId") String patrolTaskId,
      @RequestParam(value = "patrolStaffId") String patrolStaffId,
      @RequestParam(value = "patrolStaffName") String patrolStaffName) {
    UserDTO userDTO = UserUtils.getCurrentUser();
    String operatedBy = "";
    String operatedOrg = "";
    if (userDTO != null) {
      operatedBy = userDTO.getTrueName();
      if (userDTO.getDepartment() != null) {
        operatedOrg = userDTO.getDepartment().getCode();
      }
    }

    logger.debug("====operatedBy【" + operatedBy + "】========");
    ResultDTO resultDTO =
        patrolTaskService.patrolTaskAllot(
            patrolTaskId, patrolStaffId, patrolStaffName, operatedBy, operatedOrg);

    return resultDTO;
  }

  /**
   * 新增巡查 评估任务对应机构
   *
   * @param evaluateTaskProfessionDTOs
   * @return
   */
  @RequestMapping(value = "/evaluateTaskProfessionAdd", method = RequestMethod.POST)
  @ResponseBody
  public ResultDTO evaluateTaskProfessionAdd(String json) {
    logger.debug("_____evaluateTaskProfessionAdd=" + json);
    List<EvaluateTaskProfessionDTO> evaluateTaskProfessionDTOs =
        JSONArray.parseArray(json, EvaluateTaskProfessionDTO.class);
    return patrolTaskService.expertTaskProfessionAdd(evaluateTaskProfessionDTOs);
  }

  /**
   * 新增巡查 护理任务对应机构
   *
   * @param json
   * @return
   */
  @RequestMapping(value = "/nursingTaskProfessionAdd", method = RequestMethod.POST)
  @ResponseBody
  public ResultDTO nursingTaskProfessionAdd(String json) {
    logger.debug("_____nursingTaskProfessionAdd=" + json);
    List<NursingTaskProfessionDTO> nursingTaskProfessionDTOs =
        JSONArray.parseArray(json, NursingTaskProfessionDTO.class);
    return patrolTaskService.nursingTaskProfessionAdd(nursingTaskProfessionDTOs);
  }

  /**
   * 公用详情查询
   *
   * @param patrolTaskDTO
   * @return
   */
  @RequestMapping(path = "/patrolTasks/{patrolTaskId}", method = RequestMethod.GET)
  @ResponseBody
  public ResultDTO patrolTaskDetails(@PathVariable String patrolTaskId) {
    logger.debug("====传入的查询条件patrolTaskId【" + patrolTaskId + "】===========");
    return patrolTaskService.patrolTaskDetails(patrolTaskId);
  }

  /**
   * 新增巡查 评估任务对应机构
   *
   * @param evaluateTaskProfessionDTOs
   * @return
   */
  @RequestMapping(value = "/isHaveEvaluateOrgTask", method = RequestMethod.POST)
  @ResponseBody
  public ResultDTO isHaveEvaluateOrgTaskId(String json) {
    logger.debug("_____isHaveOrgTaskId=" + json);
    List<EvaluateTaskProfessionDTO> evaluateTaskProfessionDTOs =
        JSONArray.parseArray(json, EvaluateTaskProfessionDTO.class);
    return patrolTaskService.isHaveEvaluateOrgTaskId(evaluateTaskProfessionDTOs);
  }

  /**
   * 详情页面公用查询MongoDB附件信息
   *
   * @param executeFileDto
   * @return
   */
  @RequestMapping(value = "/patrolTask/mongoDBMessage", method = RequestMethod.POST)
  public void getMongoDBMessage(
      String resourceFileName,
      String resourceMaterialInfoScan,
      HttpServletRequest request,
      HttpServletResponse response) {
    patrolTaskService.getMongoDBMessage(
        resourceFileName, resourceMaterialInfoScan, request, response);
  }

  /**
   * 新增巡查 护理任务对应机构
   *
   * @param evaluateTaskProfessionDTOs
   * @return
   */
  @RequestMapping(value = "/isHaveNursingOrgTask", method = RequestMethod.POST)
  @ResponseBody
  public ResultDTO isHaveNursingOrgTaskId(String json) {
    logger.debug("_____isHaveOrgTaskId=" + json);
    logger.debug("_____nursingTaskProfessionAdd=" + json);
    List<NursingTaskProfessionDTO> nursingTaskProfessionDTOs =
        JSONArray.parseArray(json, NursingTaskProfessionDTO.class);
    return patrolTaskService.isHaveNursingOrgTaskId(nursingTaskProfessionDTOs);
  }
}
