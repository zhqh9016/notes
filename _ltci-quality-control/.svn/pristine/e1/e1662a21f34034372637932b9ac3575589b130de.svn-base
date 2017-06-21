package com.taikang.dic.ltci.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.api.model.EvaluateTaskProfessionDTO;
import com.taikang.dic.ltci.api.model.NursingTaskProfessionDTO;
import com.taikang.dic.ltci.api.model.PageResultDTO;
import com.taikang.dic.ltci.api.model.PatrolTaskDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.enumeration.ExecutionStatusEnum;
import com.taikang.dic.ltci.common.enumeration.PatrolObjectTypeEnum;
import com.taikang.dic.ltci.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.common.exception.ParametersIsNullException;
import com.taikang.dic.ltci.common.util.DateFormatUtil;
import com.taikang.dic.ltci.model.PatrolTaskAllotDetailSpecialDO;
import com.taikang.dic.ltci.model.PatrolTaskDetailDO;
import com.taikang.dic.ltci.model.PatrolTaskSpecialDO;
import com.taikang.dic.ltci.service.PatrolTaskService;

/** @author itw_xuyao 公用列表分页查询 公用详情信息查询 */
@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class PatrolTaskController {
  private Logger logger = LoggerFactory.getLogger(PatrolTaskController.class);

  @Autowired private PatrolTaskService patrolTaskService;

  public static final String RETRY_URL = "/mobileCompliain/receive/retry";

  @RequestMapping(path = "/mobileCompliain/receive/retry", method = RequestMethod.POST)
  public ResultDTO getMobileCompliain(@RequestParam String message) {
    ResultDTO resultDTO = new ResultDTO();
    try {
      logger.info("调用重试投诉接口...");
      return patrolTaskService.insertMqMessageLog(message);
    } catch (Exception e) {
      logger.error("重试投诉接口失败：", e);
      resultDTO.setStatus(ExecutionStatusEnum.FAILD.getValue());
    }
    logger.info("投诉接口返回DTO：" + JSONObject.toJSONString(resultDTO));
    return resultDTO;
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
  public PageResultDTO listPatrolTask(
      @RequestBody PatrolTaskDTO patrolTaskDTO,
      @RequestParam(value = "page", defaultValue = "1") int page,
      @RequestParam(value = "pageSize", defaultValue = "15") int pageSize) {
    logger.debug(
        "====传入的查询条件patrolTaskDTO【" + JSONObject.toJSONString(patrolTaskDTO) + "】===========");
    logger.debug("====传入的查询条件page【" + page + "】===========");
    logger.debug("====传入的查询条件pageSize【" + pageSize + "】===========");

    if (page < 1) {
      page = 1;
    }
    PatrolTaskSpecialDO patrolTaskSpecialDO = new PatrolTaskSpecialDO();
    BeanUtils.copyProperties(patrolTaskDTO, patrolTaskSpecialDO);

    Map<String, Object> map = patrolTaskService.listPatrolTask(patrolTaskSpecialDO, page, pageSize);

    Integer count = (Integer) map.get("count");
    Integer totalPage = (Integer) map.get("totalPage");
    PageResultDTO pageResultDTO = new PageResultDTO();
    pageResultDTO.setDatas(map.get("patrolTaskSpecialDOs"));
    pageResultDTO.setMessage("查询成功");
    pageResultDTO.setPage(page);
    pageResultDTO.setPageSize(pageSize);
    pageResultDTO.setTotalDataNum(count);
    pageResultDTO.setTotalPageNum(totalPage);
    pageResultDTO.setStatus(StatusCodeEnum.OK.getValue());
    logger.debug("==========pageResultDTO:" + JSONObject.toJSONString(pageResultDTO));

    return pageResultDTO;
  }

  /**
   * 新增巡查 评估任务对应机构
   *
   * @param evaluateTaskProfessionDTOs
   * @return
   */
  @RequestMapping(value = "/evaluateTaskProfessionAdd", method = RequestMethod.POST)
  public ResultDTO evaluateTaskProfessionAdd(
      @RequestBody List<EvaluateTaskProfessionDTO> evaluateTaskProfessionDTOs) {
    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setDatas("");
    if (!evaluateTaskProfessionDTOs.isEmpty()) {
      List<PatrolTaskDetailDO> patrolTaskDetailDOs = new ArrayList<PatrolTaskDetailDO>();
      for (EvaluateTaskProfessionDTO evaluateTaskProfessionDTO : evaluateTaskProfessionDTOs) {
        PatrolTaskDetailDO patrolTaskDetailDO = new PatrolTaskDetailDO();
        BeanUtils.copyProperties(evaluateTaskProfessionDTO, patrolTaskDetailDO);
        patrolTaskDetailDO =
            EvaluateTaskProfessionDTOToPatrolTaskDetailDO(
                evaluateTaskProfessionDTO, patrolTaskDetailDO);
        patrolTaskDetailDOs.add(patrolTaskDetailDO);
      }
      try {
        int result =
            patrolTaskService.expertTaskProfessionBatchAdd(
                patrolTaskDetailDOs, PatrolObjectTypeEnum.EVALUATE_ORGANIZATION.getValue());
        if (result > 0) {
          resultDTO.setMessage("添加成功");
          resultDTO.setStatus(StatusCodeEnum.CREATED.getValue());
        } else {
          resultDTO.setMessage("添加失败");
          resultDTO.setStatus(StatusCodeEnum.NOT_FOUND.getValue());
        }
      } catch (Exception e) {
        logger.error("expertTaskProfessionAdd 新增巡查任务 评估任务出错" + e);
        resultDTO.setMessage(e.getMessage());
        resultDTO.setStatus(StatusCodeEnum.INTERNAL_SERVER_ERROR.getValue());
      }
    }
    return resultDTO;
  }

  private PatrolTaskDetailDO EvaluateTaskProfessionDTOToPatrolTaskDetailDO(
      EvaluateTaskProfessionDTO evaluateTaskProfessionDTO, PatrolTaskDetailDO patrolTaskDetailDO) {
    patrolTaskDetailDO.setIsCritical(evaluateTaskProfessionDTO.getIsCritical());
    patrolTaskDetailDO.setAgencyCode(evaluateTaskProfessionDTO.getEstimateOrg());
    patrolTaskDetailDO.setAgencyName(evaluateTaskProfessionDTO.getAgencyName());
    patrolTaskDetailDO.setInsuranceAddress(evaluateTaskProfessionDTO.getRecognizeeManAddr());
    patrolTaskDetailDO.setInsuranceCode(evaluateTaskProfessionDTO.getRecognizeeManCode());
    patrolTaskDetailDO.setInsuranceName(evaluateTaskProfessionDTO.getRecognizeeMan());
    patrolTaskDetailDO.setInsurancePapersNo(evaluateTaskProfessionDTO.getRecognizeeManIdNo());
    patrolTaskDetailDO.setInsurancePapersType(
        evaluateTaskProfessionDTO.getRecognizeeManIdType()); //身份类型
    patrolTaskDetailDO.setInsurancePhone(evaluateTaskProfessionDTO.getRecognizeeManPhone());
    patrolTaskDetailDO.setLatitude(evaluateTaskProfessionDTO.getLatitude());
    patrolTaskDetailDO.setLongitude(evaluateTaskProfessionDTO.getLongitude());

    patrolTaskDetailDO.setOrgTaskId(evaluateTaskProfessionDTO.getTaskCode());
    patrolTaskDetailDO.setPersonCode(evaluateTaskProfessionDTO.getEstimateManCode());
    patrolTaskDetailDO.setPersonName(evaluateTaskProfessionDTO.getEstimateMan());
    patrolTaskDetailDO.setPersonPhone(evaluateTaskProfessionDTO.getEstimateManPhone());
    patrolTaskDetailDO.setPatrolObjectPhone(evaluateTaskProfessionDTO.getAgencyPhone());
    patrolTaskDetailDO.setPatrolObjectAddr(
        evaluateTaskProfessionDTO.getAgencyAddressDetail() != null
            ? evaluateTaskProfessionDTO.getAgencyAddressDetail()
            : "");
    patrolTaskDetailDO.setPreevaluateDate(
        DateFormatUtil.strToDateTime(evaluateTaskProfessionDTO.getPreevaluateDate()));

    patrolTaskDetailDO.setCreatedBy(evaluateTaskProfessionDTO.getCreatedBy());
    patrolTaskDetailDO.setCreatedOrg(evaluateTaskProfessionDTO.getCreatedOrg());
    return patrolTaskDetailDO;
  }

  private PatrolTaskDetailDO NursingTaskProfessionDTOToPatrolTaskDetailDO(
      NursingTaskProfessionDTO dto, PatrolTaskDetailDO patrolTaskDetailDO) {

    patrolTaskDetailDO.setInsuranceAddress(dto.getRecognizeeManAddr());
    patrolTaskDetailDO.setInsuranceCode(dto.getRecognizeeManCode());
    patrolTaskDetailDO.setInsuranceName(dto.getRecognizeeMan());
    patrolTaskDetailDO.setInsurancePapersNo(dto.getRecognizeeManIdNo());
    patrolTaskDetailDO.setInsurancePapersType(dto.getRecognizeeManIdType()); //身份类型
    patrolTaskDetailDO.setInsurancePhone(dto.getRecognizeeManPhone());
    patrolTaskDetailDO.setLatitude(dto.getLatitude());
    patrolTaskDetailDO.setLongitude(dto.getLongitude());

    patrolTaskDetailDO.setOrgTaskId(dto.getTaskCode());
    patrolTaskDetailDO.setPersonCode(dto.getNursingManCode());
    patrolTaskDetailDO.setPersonName(dto.getNursingManName());
    patrolTaskDetailDO.setPersonPhone(dto.getNursingManPhone());

    patrolTaskDetailDO.setIsKinshipCare(dto.getIsKinshipCare());
    patrolTaskDetailDO.setIsPrivilege(dto.getIsPrivilege());
    patrolTaskDetailDO.setAgencyCode(dto.getNursingOrgCode());
    patrolTaskDetailDO.setAgencyName(dto.getAgencyName());
    patrolTaskDetailDO.setPatrolObjectPhone(dto.getAgencyPhone());
    patrolTaskDetailDO.setPatrolObjectAddr(
        dto.getAgencyAddressDetail() != null ? dto.getAgencyAddressDetail() : "");
    patrolTaskDetailDO.setPreevaluateDate(DateFormatUtil.strToDateTime(dto.getPreevaluateDate()));
    if (dto.getServiceType() != null) {
      patrolTaskDetailDO.setServiceType(Integer.valueOf(dto.getServiceType()));
    }

    patrolTaskDetailDO.setCreatedBy(dto.getCreatedBy());
    patrolTaskDetailDO.setCreatedOrg(dto.getCreatedOrg());
    return patrolTaskDetailDO;
  }

  /**
   * 新增巡查 护理任务对应机构
   *
   * @param evaluateTaskProfessionDTOs
   * @return
   */
  @RequestMapping(value = "/nursingTaskProfessionAdd", method = RequestMethod.POST)
  public ResultDTO nursingTaskProfessionAdd(
      @RequestBody List<NursingTaskProfessionDTO> nursingTaskProfessionDTOs) {
    logger.debug("____nursingTaskProfessionAdd=" + nursingTaskProfessionDTOs);
    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setDatas("");
    if (!nursingTaskProfessionDTOs.isEmpty()) {
      List<PatrolTaskDetailDO> patrolTaskDetailDOs = new ArrayList<PatrolTaskDetailDO>();
      for (NursingTaskProfessionDTO nursingTaskProfessionDTO : nursingTaskProfessionDTOs) {
        PatrolTaskDetailDO patrolTaskDetailDO = new PatrolTaskDetailDO();
        BeanUtils.copyProperties(nursingTaskProfessionDTO, patrolTaskDetailDO);
        patrolTaskDetailDO =
            NursingTaskProfessionDTOToPatrolTaskDetailDO(
                nursingTaskProfessionDTO, patrolTaskDetailDO);
        patrolTaskDetailDOs.add(patrolTaskDetailDO);
      }
      try {
        int result =
            patrolTaskService.expertTaskProfessionBatchAdd(
                patrolTaskDetailDOs, PatrolObjectTypeEnum.NURSE_ORGANIZATION.getValue());
        if (result > 0) {
          resultDTO.setMessage("添加成功");
          resultDTO.setStatus(StatusCodeEnum.CREATED.getValue());
        } else {
          resultDTO.setMessage("添加失败");
          resultDTO.setStatus(StatusCodeEnum.NOT_FOUND.getValue());
        }
      } catch (Exception e) {
        logger.error("expertTaskProfessionAdd 新增巡查任务 护理任务出错" + e);
        resultDTO.setMessage(e.getMessage());
        resultDTO.setStatus(StatusCodeEnum.INTERNAL_SERVER_ERROR.getValue());
      }
    }
    logger.debug("____nursingTaskProfessionAdd result=" + resultDTO);
    return resultDTO;
  }

  /**
   * 公用详情查询
   *
   * @param patrolTaskDTO
   * @return
   */
  @RequestMapping(path = "/patrolTasks/{patrolTaskId}", method = RequestMethod.GET)
  public ResultDTO patrolTaskDetails(@PathVariable String patrolTaskId) {
    logger.debug("====传入的查询条件patrolTaskId【" + patrolTaskId + "】===========");

    PatrolTaskSpecialDO patrolTaskSpecialDO = patrolTaskService.patrolTaskDetails(patrolTaskId);

    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setDatas(patrolTaskSpecialDO);
    resultDTO.setMessage("查询成功");
    resultDTO.setStatus(StatusCodeEnum.OK.getValue());

    return resultDTO;
  }

  /**
   * 任务分配接口
   *
   * @param patrolTaskDTO
   * @return
   */
  @RequestMapping(path = "/patrolTasks/allot", method = RequestMethod.PUT)
  public ResultDTO patrolTaskAllot(
      @RequestParam(value = "patrolTaskId") String patrolTaskId,
      @RequestParam(value = "patrolStaffId") String patrolStaffId,
      @RequestParam(value = "patrolStaffName") String patrolStaffName,
      @RequestParam(value = "operatedBy") String operatedBy,
      @RequestParam(value = "operatedOrg") String operatedOrg) {
    logger.debug("====进入patrolTaskStaff查询可分配人员信息===========");
    logger.debug("====patrolTaskId【" + patrolTaskId + "】===========");
    logger.debug("====patrolStaffId【" + patrolStaffId + "】===========");
    logger.debug("====patrolStaffName【" + patrolStaffName + "】===========");
    ResultDTO resultDTO = new ResultDTO();

    if (StringUtils.isEmpty(patrolTaskId)
        || StringUtils.isEmpty(patrolStaffId)
        || StringUtils.isEmpty(patrolStaffName)) {
      throw new ParametersIsNullException("分配任务传入参数有空值，请确认");
    }

    Boolean b =
        patrolTaskService.patrolTaskAllot(
            patrolTaskId, patrolStaffId, patrolStaffName, operatedBy, operatedOrg);

    if (b) {
      resultDTO.setMessage("分配成功");
      resultDTO.setStatus(StatusCodeEnum.CREATED.getValue());
    } else {
      resultDTO.setMessage("分配失败");
      resultDTO.setStatus(StatusCodeEnum.INTERNAL_SERVER_ERROR.getValue());
    }

    return resultDTO;
  }

  /**
   * 判断哪些评估机构任务id已经新增
   *
   * @param evaluateTaskProfessionDTOs
   * @return
   */
  @RequestMapping(value = "/isHaveEvaluateOrgTaskId", method = RequestMethod.POST)
  public ResultDTO isHaveEvaluateOrgTaskId(
      @RequestBody List<EvaluateTaskProfessionDTO> evaluateTaskProfessionDTOs) {
    ResultDTO resultDTO = new ResultDTO();
    if (!evaluateTaskProfessionDTOs.isEmpty()) {
      List<PatrolTaskDetailDO> patrolTaskDetailDOs = new ArrayList<PatrolTaskDetailDO>();
      for (EvaluateTaskProfessionDTO evaluateTaskProfessionDTO : evaluateTaskProfessionDTOs) {
        PatrolTaskDetailDO patrolTaskDetailDO = new PatrolTaskDetailDO();
        BeanUtils.copyProperties(evaluateTaskProfessionDTO, patrolTaskDetailDO);
        patrolTaskDetailDO =
            EvaluateTaskProfessionDTOToPatrolTaskDetailDO(
                evaluateTaskProfessionDTO, patrolTaskDetailDO);
        patrolTaskDetailDOs.add(patrolTaskDetailDO);
      }
      try {
        List<String> hadTaskIdList = patrolTaskService.isHaveOrgTaskIdList(patrolTaskDetailDOs);
        Map<String, List<EvaluateTaskProfessionDTO>> taskMap =
            haveEvaluateTaskAndNotHave(evaluateTaskProfessionDTOs, hadTaskIdList);

        resultDTO.setDatas(taskMap);
        resultDTO.setMessage("成功");
        resultDTO.setStatus(StatusCodeEnum.OK.getValue());
      } catch (Exception e) {
        logger.error("expertTaskProfessionAdd 新增巡查任务 评估任务出错" + e);
        resultDTO.setMessage(e.getMessage());
        resultDTO.setStatus(StatusCodeEnum.INTERNAL_SERVER_ERROR.getValue());
      }
    }
    return resultDTO;
  }

  private Map<String, List<EvaluateTaskProfessionDTO>> haveEvaluateTaskAndNotHave(
      List<EvaluateTaskProfessionDTO> evaluateTaskProfessionDTOs, List<String> hadTaskIdList) {

    List<EvaluateTaskProfessionDTO> haveTaskId = new ArrayList<EvaluateTaskProfessionDTO>();
    List<EvaluateTaskProfessionDTO> notHaveTaskId = new ArrayList<EvaluateTaskProfessionDTO>();

    Map<String, String> map = new HashMap<String, String>();
    Map<String, EvaluateTaskProfessionDTO> haveTaskIdmap =
        new HashMap<String, EvaluateTaskProfessionDTO>();
    Map<String, EvaluateTaskProfessionDTO> notHaveTaskIdmap =
        new HashMap<String, EvaluateTaskProfessionDTO>();

    //list -> map
    hadTaskIdList.forEach(
        p -> {
          map.put(p, p);
        });

    //判断map中有无hadTaskIdList
    map.forEach(
        (k, v) -> {
          for (EvaluateTaskProfessionDTO evaluateTaskProfessionDTO : evaluateTaskProfessionDTOs) {
            if (map.get(evaluateTaskProfessionDTO.getTaskCode()) != null) {
              haveTaskIdmap.put(evaluateTaskProfessionDTO.getTaskCode(), evaluateTaskProfessionDTO);
            } else {
              notHaveTaskIdmap.put(
                  evaluateTaskProfessionDTO.getTaskCode(), evaluateTaskProfessionDTO);
            }
          }
        });

    //将map中的value 放入 list中
    haveTaskIdmap.forEach(
        (k, v) -> {
          haveTaskId.add(v);
        });
    notHaveTaskIdmap.forEach(
        (k, v) -> {
          notHaveTaskId.add(v);
        });

    Map<String, List<EvaluateTaskProfessionDTO>> taskMap =
        new HashMap<String, List<EvaluateTaskProfessionDTO>>();

    if (!hadTaskIdList.isEmpty()) {
      taskMap.put("haveTaskId", haveTaskId);
      taskMap.put("notHaveTaskId", notHaveTaskId);
    } else {
      taskMap.put("haveTaskId", haveTaskId);
      taskMap.put("notHaveTaskId", evaluateTaskProfessionDTOs);
    }

    return taskMap;
  }

  /**
   * 判断哪些护理机构任务id已经新增
   *
   * @param evaluateTaskProfessionDTOs
   * @return
   */
  @RequestMapping(value = "/isHaveNursingOrgTask", method = RequestMethod.POST)
  public ResultDTO isHaveNursingOrgTask(
      @RequestBody List<NursingTaskProfessionDTO> nursingTaskProfessionDTOs) {
    ResultDTO resultDTO = new ResultDTO();
    if (!nursingTaskProfessionDTOs.isEmpty()) {
      List<PatrolTaskDetailDO> patrolTaskDetailDOs = new ArrayList<PatrolTaskDetailDO>();
      for (NursingTaskProfessionDTO nursingTaskProfessionDTO : nursingTaskProfessionDTOs) {
        PatrolTaskDetailDO patrolTaskDetailDO = new PatrolTaskDetailDO();
        BeanUtils.copyProperties(nursingTaskProfessionDTO, patrolTaskDetailDO);
        patrolTaskDetailDO =
            NursingTaskProfessionDTOToPatrolTaskDetailDO(
                nursingTaskProfessionDTO, patrolTaskDetailDO);
        patrolTaskDetailDOs.add(patrolTaskDetailDO);
      }
      try {
        List<String> hadTaskIdList = patrolTaskService.isHaveOrgTaskIdList(patrolTaskDetailDOs);
        Map<String, List<NursingTaskProfessionDTO>> taskMap =
            haveNursingTaskAndNotHave(nursingTaskProfessionDTOs, hadTaskIdList);

        resultDTO.setDatas(taskMap);
        resultDTO.setMessage("成功");
        resultDTO.setStatus(StatusCodeEnum.OK.getValue());
      } catch (Exception e) {
        logger.error("expertTaskProfessionAdd 新增巡查任务 评估任务出错" + e);
        resultDTO.setMessage(e.getMessage());
        resultDTO.setStatus(StatusCodeEnum.INTERNAL_SERVER_ERROR.getValue());
      }
    }
    return resultDTO;
  }

  private Map<String, List<NursingTaskProfessionDTO>> haveNursingTaskAndNotHave(
      List<NursingTaskProfessionDTO> nursingTaskProfessionDTOs, List<String> hadTaskIdList) {

    List<NursingTaskProfessionDTO> haveTaskId = new ArrayList<NursingTaskProfessionDTO>();
    List<NursingTaskProfessionDTO> notHaveTaskId = new ArrayList<NursingTaskProfessionDTO>();

    Map<String, String> map = new HashMap<String, String>();
    Map<String, NursingTaskProfessionDTO> haveTaskIdmap =
        new HashMap<String, NursingTaskProfessionDTO>();
    Map<String, NursingTaskProfessionDTO> notHaveTaskIdmap =
        new HashMap<String, NursingTaskProfessionDTO>();

    //list -> map
    hadTaskIdList.forEach(
        p -> {
          map.put(p, p);
        });

    //判断map中有无hadTaskIdList
    map.forEach(
        (k, v) -> {
          for (NursingTaskProfessionDTO nursingTaskProfessionDTO : nursingTaskProfessionDTOs) {
            if (map.get(nursingTaskProfessionDTO.getTaskCode()) != null) {
              haveTaskIdmap.put(nursingTaskProfessionDTO.getTaskCode(), nursingTaskProfessionDTO);
            } else {
              notHaveTaskIdmap.put(
                  nursingTaskProfessionDTO.getTaskCode(), nursingTaskProfessionDTO);
            }
          }
        });

    //将map中的value 放入 list中
    haveTaskIdmap.forEach(
        (k, v) -> {
          haveTaskId.add(v);
        });
    notHaveTaskIdmap.forEach(
        (k, v) -> {
          notHaveTaskId.add(v);
        });

    Map<String, List<NursingTaskProfessionDTO>> taskMap =
        new HashMap<String, List<NursingTaskProfessionDTO>>();

    if (!hadTaskIdList.isEmpty()) {
      taskMap.put("haveTaskId", haveTaskId);
      taskMap.put("notHaveTaskId", notHaveTaskId);
    } else {
      taskMap.put("haveTaskId", haveTaskId);
      taskMap.put("notHaveTaskId", nursingTaskProfessionDTOs);
    }

    return taskMap;
  }

  /**
   * 代办巡查任务详情查询接口 移动端-经办
   *
   * @param patrolTaskId
   * @return
   */
  @RequestMapping(path = "/patrolTasks/allot/details/{patrolTaskId}", method = RequestMethod.GET)
  public ResultDTO patrolTaskAllotDetails(@PathVariable String patrolTaskId) {
    logger.debug("====传入的查询条件patrolTaskId【" + patrolTaskId + "】===========");

    PatrolTaskAllotDetailSpecialDO patrolTaskAllotDetailSpecialDO =
        patrolTaskService.patrolTaskAllotDetails(patrolTaskId);

    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setDatas(patrolTaskAllotDetailSpecialDO);
    resultDTO.setMessage("查询成功");
    resultDTO.setStatus(StatusCodeEnum.OK.getValue());

    return resultDTO;
  }
}
