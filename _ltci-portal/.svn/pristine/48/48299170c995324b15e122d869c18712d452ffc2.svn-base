package com.taikang.dic.ltci.quality.control.service.impl;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.taikang.dic.ltci.portal.api.model.EvaluateTaskProfessionDTO;
import com.taikang.dic.ltci.portal.api.model.NursingTaskProfessionDTO;
import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.PatrolTaskDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.api.model.UserDTO;
import com.taikang.dic.ltci.portal.common.util.DateFormatUtil;
import com.taikang.dic.ltci.portal.common.util.Encodes;
import com.taikang.dic.ltci.portal.common.util.UserUtils;
import com.taikang.dic.ltci.quality.control.model.PatrolTaskAddDO;
import com.taikang.dic.ltci.quality.control.professionModel.Page;
import com.taikang.dic.ltci.quality.control.professionModel.PageResultPF;
import com.taikang.dic.ltci.quality.control.service.PatrolTaskService;
import com.taikang.dic.ltci.quality.control.serviceClient.PatrolTaskExecuteServiceClient;
import com.taikang.dic.ltci.quality.control.serviceClient.PatrolTaskOfProfessionClient;
import com.taikang.dic.ltci.quality.control.serviceClient.PatrolTaskServiceClient;

/**
 * @author itw_xuxf
 * @description
 * @version 创建时间：2017年4月28日下午5:37:34
 */
@Service
public class PatrolTaskServiceImpl implements PatrolTaskService {

  private static final Logger logger = LoggerFactory.getLogger(PatrolTaskServiceImpl.class);

  @Value("${isIntefaceDebug}")
  private Boolean isIntefaceDebug;

  @Autowired private PatrolTaskServiceClient patrolTaskServiceClient;
  @Autowired private PatrolTaskOfProfessionClient patrolTaskOfProfessionClient;
  @Autowired private PatrolTaskExecuteServiceClient taskExecuteClient;

  @Override
  public PageResultDTO getEvaluatePatrolTaskList(
      String isCritical,
      String beginTime,
      String endTime,
      String provinceCode,
      String cityCode,
      String areaCode,
      String orgCode,
      int page,
      int pageSize) {
    if (isIntefaceDebug) {
      PageResultDTO pageResult = new PageResultDTO();
      pageResult.setMessage("查询成功");
      pageResult.setPage(1);
      pageResult.setPageSize(10);
      pageResult.setStatus(200);
      pageResult.setTotalPageNum(1);

      List<EvaluateTaskProfessionDTO> list = Lists.newArrayList();

      EvaluateTaskProfessionDTO task1 = new EvaluateTaskProfessionDTO();
      task1.setTaskCode("111116"); //任务编号
      task1.setEstimateMan("张三"); //评估人名称
      task1.setEstimateManCode("zhangsan"); //评估人编号
      task1.setEstimateOrg("jigou1"); //机构编码
      task1.setAgencyName("机构1"); //机构名称
      task1.setAgencyPhone("010-12312312"); //评估机构联系电话
      task1.setProvinceCode("01"); //省code
      task1.setCityCode("11"); //市code
      task1.setAreaCode("22"); //县区code
      task1.setAgencyAddressDetail("北京市昌平区生命科学园"); //机构详情地址
      task1.setPreevaluateDate("2017-05-10"); //预定评估时间
      task1.setRecognizeeMan("李四"); //参保人
      task1.setRecognizeeManCode("lisi"); //参保人编号
      task1.setRecognizeeManIdType(1); //参保人证件类型
      task1.setRecognizeeManIdNo("11011111112223459X"); //参保人证件号码
      task1.setRecognizeeManPhone("13100001110"); //参保人联系方式
      task1.setRecognizeeManAddr("北京市昌平区生命科学园"); //参保人地址
      task1.setLongitude("1111"); //经度（暂不考虑）
      task1.setLatitude("2222"); //纬度（暂不考虑）
      task1.setRemark("备注"); //备注
      task1.setCreatedBy("test1"); //创建人
      task1.setCreatedOrg("org1"); //创建人机构

      EvaluateTaskProfessionDTO task2 = new EvaluateTaskProfessionDTO();
      task2.setTaskCode("222227"); //任务编号
      task2.setEstimateMan("张三2"); //评估人名称
      task2.setEstimateManCode("zhangsan2"); //评估人编号
      task2.setEstimateOrg("jigou2"); //机构编码
      task2.setAgencyName("机构2"); //机构名称
      task2.setAgencyPhone("010-12312312"); //评估机构联系电话
      task2.setProvinceCode("01"); //省code
      task2.setCityCode("11"); //市code
      task2.setAreaCode("22"); //县区code
      task2.setAgencyAddressDetail("北京市昌平区生命科学园"); //机构详情地址
      task2.setPreevaluateDate("2017-05-10"); //预定评估时间
      task2.setRecognizeeMan("李四2"); //参保人
      task2.setRecognizeeManCode("lisi2"); //参保人编号
      task2.setRecognizeeManIdType(1); //参保人证件类型
      task2.setRecognizeeManIdNo("11011111112223458X"); //参保人证件号码
      task2.setRecognizeeManPhone("13100001110"); //参保人联系方式
      task2.setRecognizeeManAddr("北京市昌平区生命科学园"); //参保人地址
      task2.setLongitude("1111"); //经度（暂不考虑）
      task2.setLatitude("2222"); //纬度（暂不考虑）
      task2.setRemark("备注"); //备注
      task2.setCreatedBy("test2"); //创建人
      task2.setCreatedOrg("org1"); //创建人机构

      EvaluateTaskProfessionDTO task3 = new EvaluateTaskProfessionDTO();
      task3.setTaskCode("333338"); //任务编号
      task3.setEstimateMan("张三3"); //评估人名称
      task3.setEstimateManCode("zhangsan3"); //评估人编号
      task3.setEstimateOrg("jigou3"); //机构编码
      task3.setAgencyName("机构3"); //机构名称
      task3.setAgencyPhone("010-12312312"); //评估机构联系电话
      task3.setProvinceCode("01"); //省code
      task3.setCityCode("11"); //市code
      task3.setAreaCode("22"); //县区code
      task3.setAgencyAddressDetail("北京市昌平区生命科学园"); //机构详情地址
      task3.setPreevaluateDate("2017-05-10"); //预定评估时间
      task3.setRecognizeeMan("李四3"); //参保人
      task3.setRecognizeeManCode("lisi3"); //参保人编号
      task3.setRecognizeeManIdType(1); //参保人证件类型
      task3.setRecognizeeManIdNo("11011111112223458X"); //参保人证件号码
      task3.setRecognizeeManPhone("13100001110"); //参保人联系方式
      task3.setRecognizeeManAddr("北京市昌平区生命科学园"); //参保人地址
      task3.setLongitude("1111"); //经度（暂不考虑）
      task3.setLatitude("2222"); //纬度（暂不考虑）
      task3.setRemark("备注"); //备注
      task3.setCreatedBy("test3"); //创建人
      task3.setCreatedOrg("org1"); //创建人机构

      EvaluateTaskProfessionDTO task4 = new EvaluateTaskProfessionDTO();
      task4.setTaskCode("444449"); //任务编号
      task4.setEstimateMan("张三4"); //评估人名称
      task4.setEstimateManCode("zhangsan4"); //评估人编号
      task4.setEstimateOrg("jigou3"); //机构编码
      task4.setAgencyName("机构3"); //机构名称
      task4.setAgencyPhone("010-12312312"); //评估机构联系电话
      task4.setProvinceCode("01"); //省code
      task4.setCityCode("11"); //市code
      task4.setAreaCode("22"); //县区code
      task4.setAgencyAddressDetail("北京市昌平区生命科学园"); //机构详情地址
      task4.setPreevaluateDate("2017-05-10"); //预定评估时间
      task4.setRecognizeeMan("李四4"); //参保人
      task4.setRecognizeeManCode("lisi4"); //参保人编号
      task4.setRecognizeeManIdType(1); //参保人证件类型
      task4.setRecognizeeManIdNo("11011111112223458X"); //参保人证件号码
      task4.setRecognizeeManPhone("13100001110"); //参保人联系方式
      task4.setRecognizeeManAddr("北京市昌平区生命科学园"); //参保人地址
      task4.setLongitude("1111"); //经度（暂不考虑）
      task4.setLatitude("2222"); //纬度（暂不考虑）
      task4.setRemark("备注"); //备注
      task4.setCreatedBy("test4"); //创建人
      task4.setCreatedOrg("org1"); //创建人机构
      list.add(task1);
      list.add(task2);
      list.add(task3);
      list.add(task4);

      pageResult.setTotalDataNum(list.size());
      pageResult.setDatas(list);
      return pageResult;
    } else {
      PageResultDTO dto = new PageResultDTO();
      if (isCritical != null) {
        if ("01".equals(isCritical)) {
          isCritical = "1";
        }
        if ("02".equals(isCritical)) {
          isCritical = "0";
        }
      }
      if (beginTime != null && !"".equals(beginTime)) {
        beginTime = beginTime + " 00:00:00";
      } else {
        beginTime =
            DateFormatUtil.DateToStr(new Date(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD)
                + " 00:00:00";
      }
      if (endTime != null && !"".equals(endTime)) {
        endTime = endTime + " 00:00:00";
      }
      provinceCode = "".equals(provinceCode) ? null : provinceCode;
      cityCode = "".equals(cityCode) ? null : cityCode;
      areaCode = "".equals(areaCode) ? null : areaCode;
      orgCode = "".equals(orgCode) ? null : orgCode;

      logger.info("isCritical:" + isCritical);
      logger.info("beginTime:" + beginTime);
      logger.info("endTime:" + endTime);
      logger.info("provinceCode:" + provinceCode);
      logger.info("cityCode:" + cityCode);
      logger.info("areaCode:" + areaCode);
      logger.info("orgCode:" + orgCode);
      logger.info("page:" + page);
      logger.info("pageSize:" + pageSize);
      PageResultPF prf =
          patrolTaskOfProfessionClient.getEvaluatePatrolTaskList(
              isCritical,
              beginTime,
              endTime,
              provinceCode,
              cityCode,
              areaCode,
              orgCode,
              page,
              pageSize);
      transferTo(dto, prf);
      return dto;
    }
  }

  @Override
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
      int page,
      int pageSize) {
    if (isIntefaceDebug) {
      PageResultDTO pageResult = new PageResultDTO();
      pageResult.setMessage("查询成功");
      pageResult.setPage(1);
      pageResult.setPageSize(10);
      pageResult.setStatus(200);
      pageResult.setTotalPageNum(1);

      List<NursingTaskProfessionDTO> list = Lists.newArrayList();

      NursingTaskProfessionDTO task1 = new NursingTaskProfessionDTO();
      task1.setTaskCode("n11111"); //任务编号
      task1.setNursingManName("张三"); //评估人名称
      task1.setNursingManCode("zhangsan"); //评估人编号
      task1.setNursingManPhone("13412312312"); //评估人电话
      task1.setNursingOrgCode("jigou1"); //机构编码
      task1.setAgencyName("机构1"); //机构名称
      task1.setAgencyPhone("010-12312312"); //评估机构联系电话
      task1.setProvinceCode("01"); //省code
      task1.setCityCode("11"); //市code
      task1.setAreaCode("22"); //县区code
      task1.setAgencyAddressDetail("北京市昌平区生命科学园"); //机构详情地址
      task1.setPreevaluateDate("2017-05-10"); //预定评估时间
      task1.setRecognizeeMan("李四"); //参保人
      task1.setRecognizeeManCode("lisi"); //参保人编号
      task1.setRecognizeeManIdType(1); //参保人证件类型
      task1.setRecognizeeManIdNo("11011111112223459X"); //参保人证件号码
      task1.setRecognizeeManPhone("13100001110"); //参保人联系方式
      task1.setRecognizeeManAddr("北京市昌平区生命科学园"); //参保人地址
      task1.setLongitude("1111"); //经度（暂不考虑）
      task1.setLatitude("2222"); //纬度（暂不考虑）
      task1.setRemark("备注"); //备注
      task1.setCreatedBy("test1"); //创建人
      task1.setCreatedOrg("org1"); //创建人机构
      task1.setIsKinshipCare(0);
      task1.setIsPrivilege(0);
      task1.setServiceType("31");
      task1.setServiceItems("翻身");

      NursingTaskProfessionDTO task2 = new NursingTaskProfessionDTO();
      task2.setTaskCode("22222"); //任务编号
      task2.setNursingManName("张三2"); //评估人名称
      task2.setNursingManCode("zhangsan2"); //评估人编号
      task1.setNursingManPhone("13412312312"); //评估人电话
      task2.setNursingOrgCode("jigou1"); //机构编码
      task2.setAgencyName("机构1"); //机构名称
      task2.setAgencyPhone("010-12312312"); //评估机构联系电话
      task2.setProvinceCode("01"); //省code
      task2.setCityCode("11"); //市code
      task2.setAreaCode("22"); //县区code
      task2.setAgencyAddressDetail("北京市昌平区生命科学园"); //机构详情地址
      task2.setPreevaluateDate("2017-05-10"); //预定评估时间
      task2.setRecognizeeMan("李四2"); //参保人
      task2.setRecognizeeManCode("lisi2"); //参保人编号
      task2.setRecognizeeManIdType(1); //参保人证件类型
      task2.setRecognizeeManIdNo("11011111112223458X"); //参保人证件号码
      task2.setRecognizeeManPhone("13100001110"); //参保人联系方式
      task2.setRecognizeeManAddr("北京市昌平区生命科学园"); //参保人地址
      task2.setLongitude("1111"); //经度（暂不考虑）
      task2.setLatitude("2222"); //纬度（暂不考虑）
      task2.setRemark("备注"); //备注
      task2.setCreatedBy("test2"); //创建人
      task2.setCreatedOrg("org1"); //创建人机构
      task2.setIsKinshipCare(0);
      task2.setIsPrivilege(0);
      task2.setServiceType("32");
      task2.setServiceItems("翻身");

      NursingTaskProfessionDTO task3 = new NursingTaskProfessionDTO();
      task3.setTaskCode("33333"); //任务编号
      task3.setNursingManName("张三3"); //评估人名称
      task3.setNursingManCode("zhangsan3"); //评估人编号
      task1.setNursingManPhone("13412312312"); //评估人电话
      task3.setNursingOrgCode("jigou3"); //机构编码
      task3.setAgencyName("机构3"); //机构名称
      task3.setAgencyPhone("010-12312312"); //评估机构联系电话
      task3.setProvinceCode("01"); //省code
      task3.setCityCode("11"); //市code
      task3.setAreaCode("22"); //县区code
      task3.setAgencyAddressDetail("北京市昌平区生命科学园"); //机构详情地址
      task3.setPreevaluateDate("2017-05-10"); //预定评估时间
      task3.setRecognizeeMan("李四3"); //参保人
      task3.setRecognizeeManCode("lisi3"); //参保人编号
      task3.setRecognizeeManIdType(1); //参保人证件类型
      task3.setRecognizeeManIdNo("11011111112223458X"); //参保人证件号码
      task3.setRecognizeeManPhone("13100001110"); //参保人联系方式
      task3.setRecognizeeManAddr("北京市昌平区生命科学园"); //参保人地址
      task3.setLongitude("1111"); //经度（暂不考虑）
      task3.setLatitude("2222"); //纬度（暂不考虑）
      task3.setRemark("备注"); //备注
      task3.setCreatedBy("test3"); //创建人
      task3.setCreatedOrg("org1"); //创建人机构
      task3.setIsKinshipCare(0);
      task3.setIsPrivilege(0);
      task2.setServiceType("33");
      task2.setServiceItems("翻身");

      NursingTaskProfessionDTO task4 = new NursingTaskProfessionDTO();
      task4.setTaskCode("44444"); //任务编号
      task4.setNursingManName("张三4"); //评估人名称
      task4.setNursingManCode("zhangsan4"); //评估人编号
      task1.setNursingManPhone("13412312312"); //评估人电话
      task4.setNursingOrgCode("jigou4"); //机构编码
      task4.setAgencyName("机构4"); //机构名称
      task4.setAgencyPhone("010-12312312"); //评估机构联系电话
      task4.setProvinceCode("01"); //省code
      task4.setCityCode("11"); //市code
      task4.setAreaCode("22"); //县区code
      task4.setAgencyAddressDetail("北京市昌平区生命科学园"); //机构详情地址
      task4.setPreevaluateDate("2017-05-10"); //预定评估时间
      task4.setRecognizeeMan("李四4"); //参保人
      task4.setRecognizeeManCode("lisi4"); //参保人编号
      task4.setRecognizeeManIdType(1); //参保人证件类型
      task4.setRecognizeeManIdNo("11011111112223458X"); //参保人证件号码
      task4.setRecognizeeManPhone("13100001110"); //参保人联系方式
      task4.setRecognizeeManAddr("北京市昌平区生命科学园"); //参保人地址
      task4.setLongitude("1111"); //经度（暂不考虑）
      task4.setLatitude("2222"); //纬度（暂不考虑）
      task4.setRemark("备注"); //备注
      task4.setCreatedBy("test4"); //创建人
      task4.setCreatedOrg("org1"); //创建人机构
      task4.setIsKinshipCare(0);
      task4.setIsPrivilege(0);
      task4.setServiceType("34");
      task4.setServiceItems("翻身");
      list.add(task1);
      list.add(task2);
      list.add(task3);
      list.add(task4);

      pageResult.setTotalDataNum(list.size());
      pageResult.setDatas(list);
      return pageResult;
    } else {
      serviceType = "".equals(serviceType) ? null : serviceType;
      serviceItems = "".equals(serviceItems) ? null : serviceItems;
      isKinshipCare = "".equals(isKinshipCare) ? null : isKinshipCare;
      isPrivilege = "".equals(isPrivilege) ? null : isPrivilege;
      beginTime =
          "".equals(beginTime)
              ? DateFormatUtil.DateToStr(new Date(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD)
              : beginTime;
      endTime = "".equals(endTime) ? null : endTime;
      provinceCode = "".equals(provinceCode) ? null : provinceCode;
      cityCode = "".equals(cityCode) ? null : cityCode;
      areaCode = "".equals(areaCode) ? null : areaCode;
      orgCode = "".equals(orgCode) ? null : orgCode;
      PageResultDTO dto = new PageResultDTO();
      PageResultPF prf =
          patrolTaskOfProfessionClient.getNursingPatrolTaskList(
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
      transferTo(dto, prf);
      return dto;
    }
  }

  private void transferTo(PageResultDTO dto, PageResultPF prf) {
    logger.debug("____transferTo prf=" + JSONObject.toJSONString(prf));
    if (prf != null) {
      dto.setMessage(prf.getMsg());
      if ("0".equals(prf.getCode())) {
        dto.setStatus(200);
      } else {
        dto.setStatus(500);
      }
      Page pageObj = prf.getPage();
      if (pageObj != null) {
        dto.setPage(pageObj.getNumber());
        dto.setPageSize(pageObj.getSize());
        dto.setTotalDataNum(pageObj.getTotalelements());
        dto.setTotalPageNum(pageObj.getTotalpages());
      }
      if (prf.getData() != null) {
        dto.setDatas(prf.getData());
        logger.info("prf.getData():" + prf.getData());
      } else {
        dto.setDatas(new ArrayList<Object>());
      }
    }
  }

  @Override
  public ResultDTO addPatrol(PatrolTaskAddDO patrolTaskAddDO) {
    UserDTO currentUser = UserUtils.getCurrentUser();
    String operatedBy = null;
    String operatedOrg = null;

    if (currentUser == null) {
      operatedBy = "";
      operatedOrg = "";
    } else {
      operatedBy = currentUser.getTrueName();
      if (currentUser.getDepartment() != null) {
        operatedOrg = currentUser.getDepartment().getCode();
      }
    }
    patrolTaskAddDO.setCreatedBy(operatedBy);
    patrolTaskAddDO.setCreatedOrg(operatedOrg);

    return patrolTaskServiceClient.addPatrol(patrolTaskAddDO);
  }

  @Override
  public PageResultDTO listPatrolTask(PatrolTaskDTO patrolTaskDTO, int page, int pageSize) {
    return patrolTaskServiceClient.listPatrolTask(patrolTaskDTO, page, pageSize);
  }

  @Override
  public ResultDTO patrolTaskAllot(
      String patrolTaskId,
      String patrolStaffId,
      String patrolStaffName,
      String operatedBy,
      String operatedOrg) {
    return patrolTaskServiceClient.patrolTaskAllot(
        patrolTaskId, patrolStaffId, patrolStaffName, operatedBy, operatedOrg);
  }

  @Override
  public ResultDTO expertTaskProfessionAdd(
      List<EvaluateTaskProfessionDTO> evaluateTaskProfessionDTOs) {
    UserDTO currentUser = UserUtils.getCurrentUser();
    String operatedBy = "";
    String operatedOrg = "";

    if (currentUser != null) {
      operatedBy = currentUser.getTrueName();
      if (currentUser.getDepartment() != null) {
        operatedOrg = currentUser.getDepartment().getCode();
      }
    }

    for (EvaluateTaskProfessionDTO evaluateTaskProfessionDTO : evaluateTaskProfessionDTOs) {
      evaluateTaskProfessionDTO.setCreatedBy(operatedBy);
      evaluateTaskProfessionDTO.setCreatedOrg(operatedOrg);
    }
    return patrolTaskServiceClient.expertTaskProfessionAdd(evaluateTaskProfessionDTOs);
  }

  @Override
  public ResultDTO nursingTaskProfessionAdd(
      List<NursingTaskProfessionDTO> nursingTaskProfessionDTOs) {
    UserDTO currentUser = UserUtils.getCurrentUser();
    String operatedBy = "";
    String operatedOrg = "";

    if (currentUser != null) {
      operatedBy = currentUser.getTrueName();
      if (currentUser.getDepartment() != null) {
        operatedOrg = currentUser.getDepartment().getCode();
      }
    }

    for (NursingTaskProfessionDTO evaluateTaskProfessionDTO : nursingTaskProfessionDTOs) {
      evaluateTaskProfessionDTO.setCreatedBy(operatedBy);
      evaluateTaskProfessionDTO.setCreatedOrg(operatedOrg);
    }
    return patrolTaskServiceClient.nursingTaskProfessionAdd(nursingTaskProfessionDTOs);
  }

  @Override
  public ResultDTO patrolTaskDetails(String patrolTaskId) {
    return patrolTaskServiceClient.patrolTaskDetails(patrolTaskId);
  }

  @Override
  public ResultDTO isHaveEvaluateOrgTaskId(
      List<EvaluateTaskProfessionDTO> evaluateTaskProfessionDTOs) {
    // TODO Auto-generated method stub
    return patrolTaskServiceClient.isHaveEvaluateOrgTaskId(evaluateTaskProfessionDTOs);
  }

  @Override
  public void getMongoDBMessage(
      String resourceFileName,
      String resourceMaterialInfoScan,
      HttpServletRequest request,
      HttpServletResponse response) {
    ResultDTO resultDto = taskExecuteClient.getMongoDBMessage(resourceMaterialInfoScan);
    try {
      byte[] bytes = Encodes.decodeBase64(resultDto.getDatas().toString());
      videoDownload(request, response, bytes, resourceFileName);
    } catch (IOException e) {
      logger.error("错误信息： " + e);
    }
  }

  @Override
  public ResultDTO isHaveNursingOrgTaskId(
      List<NursingTaskProfessionDTO> nursingTaskProfessionDTOs) {
    // TODO Auto-generated method stub
    return patrolTaskServiceClient.isHaveNursingOrgTaskId(nursingTaskProfessionDTOs);
  }

  private void videoDownload(
      HttpServletRequest request, HttpServletResponse response, byte[] data, String diskfilename)
      throws IOException {
    // 取头参数
    String range = request.getHeader("range");
    String browser = request.getHeader("User-Agent");
    if (browser.indexOf("Firefox") != -1) {
      // 火狐浏览器
      response.setContentType("video/ogg");
      response.setContentLength(data.length);
      response.setHeader("Content-Disposition", "attachment; filename=\"" + diskfilename + "\"");
      response.setHeader("Content-Range", range + Integer.valueOf(data.length - 1));
      response.setHeader("Accept-Ranges", "bytes");
      response.setHeader("Etag", "W/\"9767057-1323779115364\"");
      byte[] content = new byte[1024];
      BufferedInputStream is = new BufferedInputStream(new ByteArrayInputStream(data));
      OutputStream os = response.getOutputStream();
      while (is.read(content) != -1) {
        os.write(content);
      }
      is.close();
      os.close();
    } else if (browser.indexOf("MSIE") != -1) {
      // IE9以上浏览器
      response.setContentType("video/mpeg");
      // response.setContentType("application/octet-stream");
      response.setHeader("Content-Disposition", "attachment; filename=\"" + diskfilename + "\"");
      response.setContentLength(data.length);
      response.setHeader("Content-Range", range + Integer.valueOf(data.length - 1));
      response.setHeader("Accept-Ranges", "text/x-dvi");
      response.setHeader("Etag", "W/\"9767057-1323779115364\"");
      byte[] content = new byte[1024];
      BufferedInputStream is = new BufferedInputStream(new ByteArrayInputStream(data));
      OutputStream os = response.getOutputStream();
      while (is.read(content) != -1) {
        os.write(content);
      }
      is.close();
      os.close();
    } else if (browser.indexOf("Chrome") != -1) {
      // 谷歌浏览器
      response.setContentType("video/mp4");
      // response.setContentType("application/octet-stream");
      response.setHeader("Content-Disposition", "attachment; filename=\"" + diskfilename + "\"");
      System.out.println("data.length " + data.length);
      response.setContentLength(data.length);
      response.setHeader("Content-Range", range + Integer.valueOf(data.length - 1));
      response.setHeader("Accept-Ranges", "bytes");
      response.setHeader("Etag", "W/\"9767057-1323779115364\"");
      byte[] content = new byte[1024];
      BufferedInputStream is = new BufferedInputStream(new ByteArrayInputStream(data));
      OutputStream os = response.getOutputStream();
      while (is.read(content) != -1) {
        os.write(content);
      }
      is.close();
      os.close();
    } else if (browser.indexOf("CoreMedia") != -1) {
      // 其他浏览器
      response.setContentType("video/mpeg");
      response.setHeader("Content-Disposition", "attachment; filename=\"" + diskfilename + "\"");
      byte[] content = new byte[1024];
      BufferedInputStream is = new BufferedInputStream(new ByteArrayInputStream(data));
      OutputStream os = response.getOutputStream();
      while (is.read(content) != -1) {
        os.write(content);
      }
      is.close();
      os.close();
    }
  }
}
