package com.taikang.dic.ltci.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.enumeration.IsValidEnum;
import com.taikang.dic.ltci.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.common.exception.InsertRepeatException;
import com.taikang.dic.ltci.common.exception.NotFoundByIdException;
import com.taikang.dic.ltci.common.util.DateFormatUtil;
import com.taikang.dic.ltci.common.util.JsonUtils;
import com.taikang.dic.ltci.dao.AgencyDAO;
import com.taikang.dic.ltci.dao.StaffDAO;
import com.taikang.dic.ltci.dao.StaffHistoryDAO;
import com.taikang.dic.ltci.dao.StaffSpecialDAO;
import com.taikang.dic.ltci.model.AgencyDO;
import com.taikang.dic.ltci.model.AgencyDOExample;
import com.taikang.dic.ltci.model.AgencyDOExample.Criteria;
import com.taikang.dic.ltci.model.PatrolTaskQueryDO;
import com.taikang.dic.ltci.model.StaffComparedDO;
import com.taikang.dic.ltci.model.StaffDO;
import com.taikang.dic.ltci.model.StaffDOExample;
import com.taikang.dic.ltci.model.StaffDetailDO;
import com.taikang.dic.ltci.model.StaffDiffDO;
import com.taikang.dic.ltci.model.StaffHistoryDO;
import com.taikang.dic.ltci.model.StaffHistoryDOExample;
import com.taikang.dic.ltci.model.StaffSpecialDO;
import com.taikang.dic.ltci.service.AgencyStaffService;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

@Service
public class AgencyStaffImpl implements AgencyStaffService {
  private Logger logger = LoggerFactory.getLogger(AgencyStaffImpl.class);
  @Autowired private AgencyDAO agencyDAO;
  @Autowired private StaffDAO staffDAO;
  @Autowired private StaffHistoryDAO staffHistoryDAO;
  @Autowired private StaffSpecialDAO staffSpecialDAO;

  private static char[] org = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

  @Override
  @Transactional
  public boolean insertAgency(String path) throws Exception {

    //读取文件---文件路径写死
    File agencyfile = new File(path);
    InputStream agencyIn = new FileInputStream(agencyfile);
    Workbook angencyWorkbook = Workbook.getWorkbook(agencyIn);

    //获取第一张Sheet表
    int agencySheetNum = angencyWorkbook.getNumberOfSheets();
    logger.info("========表sheet【" + agencySheetNum + "】=========");
    //先循环sheet
    for (int i = 0; i < agencySheetNum; i++) {

      Sheet sheet = angencyWorkbook.getSheet(i);
      //我们既可能通过Sheet的名称来访问它，也可以通过下标来访问它。如果通过下标来访问的话，要注意的一点是下标从0开始，就像数组一样。
      int rowNum = sheet.getRows();

      //循环行
      for (int j = 1; j < rowNum; j++) {
        int columnNum = sheet.getColumns();
        AgencyDO agencyDO = new AgencyDO();
        agencyDO.setAgencyid(UUID.randomUUID().toString().replaceAll("-", ""));
        agencyDO.setIsValid(IsValidEnum.NO_DELETE.getValue());
        agencyDO.setCreatedTime(new Date());
        agencyDO.setOperatedTime(new Date());
        if (null == sheet.getCell(0, j).getContents()
            || "".equals(sheet.getCell(0, j).getContents())) {
          continue;
        }
        //循环列
        for (int c = 0; c < columnNum; c++) {
          Cell cell = sheet.getCell(c, j); //得到第一列
          String content = cell.getContents();

          //如果获取到的数据为空，继续循环
          if ("".equals(content) || content == null) {
            continue;
          }

          switch (c) {
            case 0:
              agencyDO.setAgencyCode(content);
              break;
            case 1:
              agencyDO.setOrgCode(content);
              break;
            case 2:
              agencyDO.setAgencyName(content);
              break;
            case 3:
              agencyDO.setProvinceCode(content);
              break;
            case 4:
              agencyDO.setCityCode(content);
              break;
            case 5:
              agencyDO.setAreaCode(content);
              break;
            case 6:
              agencyDO.setAgencyAddressDetail(content);
              break;
            case 7:
              agencyDO.setAgencyType(content);
              break;
            case 8:
              agencyDO.setAgencyLevel(Integer.parseInt(content));
              break;
            case 9:
              agencyDO.setAgencyState(Integer.parseInt(content));
              break;
            case 10:
              agencyDO.setAgencyServiceType(content);
              break;
            case 11:
              agencyDO.setOwnershipForm(Integer.parseInt(content));
              break;
            case 12:
              agencyDO.setPracticeLicense(content);
              break;
            case 13:
              agencyDO.setLegalRepresentative(content);
              break;
            case 14:
              agencyDO.setLegalPapersType(content);
              break;
            case 15:
              agencyDO.setLegalIdCard(content);
              break;
            case 16:
              agencyDO.setLegalPhoneNo(content);
              break;
            case 17:
              agencyDO.setAgencyServiceContact(content);
              break;
            case 18:
              agencyDO.setAgencyContactPhone(content);
              break;
            case 19:
              agencyDO.setAgencyContactEmail(content);
              break;
            case 20:
              agencyDO.setAgencyBedNum(Integer.parseInt(content));
              break;
            case 21:
              agencyDO.setConstructionArea(Double.parseDouble(content));
              break;
            case 22:
              agencyDO.setRemark(content);
              break;
            case 23:
              agencyDO.setAgencyCoordinates(content);
              break;
            case 24:
              agencyDO.setCreatedBy(content);
              break;
            case 25:
              agencyDO.setCreatedOrg(content);
              break;
            case 26:
              agencyDO.setKeyBeginDate(DateFormatUtil.strToDate(content));
              break;
            case 27:
              agencyDO.setKeyEndDate(DateFormatUtil.strToDate(content));
              break;

            default:
              break;
          }
        }
        String areaCode = "";
        //如果区县编码为空 则用所在城市编码
        if (StringUtils.isEmpty(agencyDO.getAreaCode())) {
          areaCode = agencyDO.getCityCode();
        } else {
          areaCode = agencyDO.getAreaCode();
        }
        String agencyCode = areaCode + agencyDO.getAgencyCode();
        //防止orgCode重复,自动生成后先去数据库查重
        //        while (true) {
        //          AgencyDOExample doExample = new AgencyDOExample();
        //          Criteria criteria = doExample.createCriteria();
        //          criteria.andAgencyCodeEqualTo(agencyCode);
        //          List<AgencyDO> selectByExample = agencyDAO.selectByExample(doExample);
        //
        //          if (selectByExample.size() <= 0) {
        //            //查询出数据为空 证明code值没有重复 不用重复生成
        //            break;
        //          }
        //          agencyCode = this.getAgencyCode(areaCode);
        //        }

        agencyDO.setAgencyCode(agencyCode);
        agencyDO.setSecretKey(agencyCode);
        logger.info("====要存入的机构信息【" + JsonUtils.makeJsonForObject(agencyDO) + "】============");
        int insertLength = agencyDAO.insertSelective(agencyDO);
        if (insertLength < 0) {
          throw new InsertRepeatException("插入失败");
        }
      }
    }
    return true;
  }

  @Override
  @Transactional
  public boolean insertStaff(String path) throws Exception {

    //读取文件---文件路径写死
    File agencyfile = new File(path);
    InputStream agencyIn = new FileInputStream(agencyfile);
    Workbook angencyWorkbook = Workbook.getWorkbook(agencyIn);

    //获取第一张Sheet表
    int agencySheetNum = angencyWorkbook.getNumberOfSheets();
    logger.info("========表sheet【" + agencySheetNum + "】=========");
    //先循环sheet
    for (int i = 0; i < agencySheetNum; i++) {
      Sheet sheet = angencyWorkbook.getSheet(i);
      //我们既可能通过Sheet的名称来访问它，也可以通过下标来访问它。如果通过下标来访问的话，要注意的一点是下标从0开始，就像数组一样。
      int rowNum = sheet.getRows();
      logger.info("===人员表行数【" + rowNum + "】========");
      //循环行
      for (int j = 1; j < rowNum; j++) {
        int columnNum = sheet.getColumns();
        logger.info("===人员表列数【" + columnNum + "】========");
        StaffDO staffDO = new StaffDO();

        staffDO.setStaffid(UUID.randomUUID().toString().replaceAll("-", ""));
        staffDO.setIsValid(IsValidEnum.NO_DELETE.getValue());
        staffDO.setCreatedTime(new Date());
        staffDO.setOperatedTime(new Date());
        if (null == sheet.getCell(0, j).getContents()
            || "".equals(sheet.getCell(0, j).getContents())) {
          continue;
        }
        //循环列
        for (int c = 0; c < columnNum; c++) {
          Cell cell = sheet.getCell(c, j); //得到第一列
          String content = cell.getContents();
          //	            logger.info("=====具体数据【" + content + "】========");

          //如果获取到的数据为空，继续循环
          if ("".equals(content) || content == null) {
            continue;
          }

          switch (c) {
            case 0:
              staffDO.setEmpCode(content);
              break;
            case 1:
              staffDO.setStaffName(content);
              break;
            case 2:
              staffDO.setAgencyCode(content);
              break;
            case 3:
              staffDO.setAgencyName(content);
              break;
            case 4:
              staffDO.setStaffPhone(content);
              break;
            case 5:
              staffDO.setCredentialType(Integer.getInteger(content));
              break;
            case 6:
              staffDO.setCredentialNumber(content);
              break;
            case 7:
              staffDO.setCredentialValidityDate(DateFormatUtil.strToDateTime(content));
              break;
            case 8:
              staffDO.setStaffGender(Integer.getInteger(content));
              break;
            case 9:
              staffDO.setHighestEducation(content);
              break;
            case 10:
              staffDO.setAcquireDegree(content);
              break;
            case 11:
              staffDO.setDiplomaDate(DateFormatUtil.strToDateTime(content));
              break;
            case 12:
              staffDO.setDegreeDate(DateFormatUtil.strToDateTime(content));
              break;
            case 13:
              staffDO.setJobScope(content);
              break;
            case 14:
              staffDO.setStaffLevel(content);
              break;
            case 15:
              staffDO.setCategory(content);
              break;
            case 16:
              staffDO.setRemark(content);
              break;
            case 17:
              staffDO.setAuditState(Integer.parseInt(content));
              break;
            case 18:
              staffDO.setCreatedBy(content);
              break;
            case 19:
              staffDO.setCreatedOrg(content);
              break;

            default:
              break;
          }
        }
        String areaCode = staffDO.getAgencyCode();
        //如果区县编码为空 则用所在城市编码
        String staffCode = this.getStaffCode(areaCode);
        //防止orgCode重复,自动生成后先去数据库查重
        while (true) {
          StaffDOExample doExample = new StaffDOExample();
          com.taikang.dic.ltci.model.StaffDOExample.Criteria criteria = doExample.createCriteria();
          criteria.andStaffCodeEqualTo(staffCode);
          List<StaffDO> selectByExample = staffDAO.selectByExample(doExample);

          if (selectByExample.size() <= 0) {
            //查询出数据为空 证明code值没有重复 不用重复生成
            break;
          }
          staffCode = this.getStaffCode(staffCode);
        }

        staffDO.setStaffCode(staffCode);
        logger.info("====要存入的人员信息【" + JsonUtils.makeJsonForObject(staffDO) + "】============");
        int insertLength = staffDAO.insertSelective(staffDO);
        if (insertLength < 0) {
          throw new InsertRepeatException("插入失败");
        }
      }
    }
    return true;
  }

  public static String getAgencyCode(String areaCode) {
    StringBuffer sb = new StringBuffer(areaCode);
    SecureRandom random = new SecureRandom();
    for (int i = 0; i < 6; i++) {
      sb.append(org[random.nextInt(org.length)]);
    }

    return sb.toString();
  }

  public static String getStaffCode(String areaCode) {
    StringBuffer sb = new StringBuffer(areaCode);
    SecureRandom random = new SecureRandom();
    for (int i = 0; i < 6; i++) {
      sb.append(org[random.nextInt(org.length)]);
    }

    return sb.toString();
  }

  /** 通过staffcode获取staff的详细信息 */
  @Override
  public ResultDTO getStaff(String staffCode) {
    StaffDOExample staffDOExample = new StaffDOExample();
    com.taikang.dic.ltci.model.StaffDOExample.Criteria criteria = staffDOExample.createCriteria();
    criteria.andStaffCodeEqualTo(staffCode);
    List<StaffDO> list = staffDAO.selectByExample(staffDOExample);
    ResultDTO resultDTO = new ResultDTO();

    if (!list.isEmpty()) {
      resultDTO.setMessage("查询成功");
      resultDTO.setDatas(list.get(0));
      return resultDTO;
    } else {
      throw new NotFoundByIdException("未查询到结果");
    }
  }

  /** 通过修改流水号 获取修改前后的staff信息 */
  @Override
  public ResultDTO staffDetail(String serialNo) {
    //先获取修改后的
    StaffHistoryDOExample example = new StaffHistoryDOExample();
    com.taikang.dic.ltci.model.StaffHistoryDOExample.Criteria criteria = example.createCriteria();
    criteria.andSerialNoEqualTo(serialNo);

    List<StaffHistoryDO> staffHistoryList = staffHistoryDAO.selectByExample(example);
    StaffHistoryDO staffHistoryDO = new StaffHistoryDO();
    if (!staffHistoryList.isEmpty()) {
      staffHistoryDO = staffHistoryList.get(0);
    } else {
      throw new NotFoundByIdException("未查询要修改的记录");
    }

    //在获取修改前的记录
    StaffDOExample staffDOExample = new StaffDOExample();
    com.taikang.dic.ltci.model.StaffDOExample.Criteria staffCriteria =
        staffDOExample.createCriteria();
    staffCriteria.andStaffCodeEqualTo(staffHistoryDO.getStaffCode());
    List<StaffDO> list = staffDAO.selectByExample(staffDOExample);
    StaffDO staffDO = new StaffDO();
    if (!list.isEmpty()) {
      staffDO = list.get(0);
    } else {
      throw new NotFoundByIdException("未查询到相关的人员记录");
    }

    StaffComparedDO staffComparedBefore = new StaffComparedDO();
    StaffComparedDO staffComparedAfter = new StaffComparedDO();

    BeanUtils.copyProperties(staffHistoryDO, staffComparedAfter);
    BeanUtils.copyProperties(staffDO, staffComparedBefore);
    List<StaffDiffDO> staffDiffDOs = null;
    try {
      staffDiffDOs = convert(staffComparedBefore, staffComparedAfter);
    } catch (Exception e) {
      logger.error("转换出现错误", e);
    }
    //将日期格式转换一下
    for (StaffDiffDO staffDiffDO : staffDiffDOs) {
      if (staffDiffDO.getKey().equals("credentialValidityDate")
          || staffDiffDO.getKey().equals("degreeDate")
          || staffDiffDO.getKey().equals("diplomaDate")
          || staffDiffDO.getKey().equals("qualificationCertificationDate")
          || staffDiffDO.getKey().equals("practiceCertificationDate")) {
        staffDiffDO.setNewValue(DateFormatUtil.changeDateType((String) staffDiffDO.getNewValue()));
        staffDiffDO.setOldValue(DateFormatUtil.changeDateType((String) staffDiffDO.getOldValue()));
      }
    }
    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setDatas(staffDiffDOs);
    resultDTO.setMessage("查询成功");
    resultDTO.setStatus(StatusCodeEnum.OK.getValue());
    return resultDTO;
  }

  private List<com.taikang.dic.ltci.model.StaffDiffDO> convert(
      StaffComparedDO staffComparedBefore, StaffComparedDO staffComparedAfter)
      throws IllegalArgumentException, IllegalAccessException {
    List<StaffDiffDO> staffDiffDOs = new ArrayList<StaffDiffDO>();
    Field[] fieldBefores = staffComparedBefore.getClass().getDeclaredFields();
    Field[] fieldAfters = staffComparedAfter.getClass().getDeclaredFields();
    for (Field fieldBefore : fieldBefores) {
      for (Field fieldAfter : fieldAfters) {
        if (fieldAfter.getName().equals(fieldBefore.getName())) {
          StaffDiffDO staffDiffDO = new StaffDiffDO();
          staffDiffDO.setKey(fieldAfter.getName());
          fieldAfter.setAccessible(true);
          fieldBefore.setAccessible(true);
          if (fieldAfter.get(staffComparedBefore) != null) {
            staffDiffDO.setOldValue(fieldAfter.get(staffComparedBefore).toString());
          } else {
            staffDiffDO.setOldValue("");
          }
          if (fieldBefore.get(staffComparedAfter) != null) {
            staffDiffDO.setNewValue(fieldBefore.get(staffComparedAfter).toString());
          } else {
            staffDiffDO.setNewValue("");
          }
          staffDiffDOs.add(staffDiffDO);
        }
      }
    }
    return staffDiffDOs;
  }

  /** 给质控的接口 通过人员名字查询staff和agency的合并信息 */
  @Override
  public ResultDTO queryStaff(String name) {
    List<StaffSpecialDO> staffs = staffSpecialDAO.getStaffs(name);
    List<PatrolTaskQueryDO> speciaLists = new ArrayList<PatrolTaskQueryDO>();

    for (StaffSpecialDO list : staffs) {
      PatrolTaskQueryDO patrolTaskQueryDO = new PatrolTaskQueryDO();
      patrolTaskQueryDO.setPatrolObjectAddr(list.getAgencyAddressDetail());
      patrolTaskQueryDO.setPatrolObjectId(list.getStaffCode());
      patrolTaskQueryDO.setPatrolObjectName(list.getStaffName());
      patrolTaskQueryDO.setPatrolObjectPhone(list.getStaffPhone());
      patrolTaskQueryDO.setIdCard(list.getCredentialNumber());
      speciaLists.add(patrolTaskQueryDO);
    }

    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setStatus(StatusCodeEnum.OK.getValue());
    resultDTO.setDatas(speciaLists);
    resultDTO.setMessage("查询成功！");
    return resultDTO;
  }

  /** 给质控的接口 通过机构名字 查询机构相关信息 */
  @Override
  public ResultDTO queryAgency(String name) {
    AgencyDOExample agencyDOExample = new AgencyDOExample();
    Criteria criteria = agencyDOExample.createCriteria();
    if (name != null) {
      criteria.andAgencyNameLike("%" + name + "%");
    }
    criteria.andIsValidEqualTo(IsValidEnum.NO_DELETE.getValue());
    List<AgencyDO> lists = agencyDAO.selectByExample(agencyDOExample);
    List<PatrolTaskQueryDO> speciaLists = new ArrayList<PatrolTaskQueryDO>();

    for (AgencyDO list : lists) {
      PatrolTaskQueryDO patrolTaskQueryDO = new PatrolTaskQueryDO();
      patrolTaskQueryDO.setPatrolObjectAddr(list.getAgencyAddressDetail());
      patrolTaskQueryDO.setPatrolObjectId(list.getAgencyCode());
      patrolTaskQueryDO.setPatrolObjectName(list.getAgencyName());
      patrolTaskQueryDO.setPatrolObjectPhone(list.getAgencyContactPhone());
      speciaLists.add(patrolTaskQueryDO);
    }

    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setStatus(StatusCodeEnum.OK.getValue());
    resultDTO.setDatas(speciaLists);
    resultDTO.setMessage("查询成功！");
    return resultDTO;
  }

  @Override
  public ResultDTO getAgencyByStaff(String code) {
    StaffSpecialDO staffSpecialDO = staffSpecialDAO.getAgencyByStaff(code);
    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setStatus(StatusCodeEnum.OK.getValue());
    resultDTO.setDatas(staffSpecialDO);
    resultDTO.setMessage("查询成功！");
    return resultDTO;
  }

  /** 质控微服务根据机构编码查询机构信息 */
  @Override
  public ResultDTO getAgencyByAgencyCode(String code) {
    AgencyDOExample agencyDOExample = new AgencyDOExample();
    com.taikang.dic.ltci.model.AgencyDOExample.Criteria agencyCriteria =
        agencyDOExample.createCriteria();
    agencyCriteria.andAgencyCodeEqualTo(code);
    agencyCriteria.andIsValidEqualTo(IsValidEnum.NO_DELETE.getValue());

    List<AgencyDO> list = agencyDAO.selectByExample(agencyDOExample);
    if (list.isEmpty()) {
      throw new NotFoundByIdException("未查询到机构代码与" + code + " 对应的护理机构信息");
    }
    ResultDTO dto = new ResultDTO();
    dto.setStatus(StatusCodeEnum.OK.getValue());
    dto.setDatas(list.get(0));
    return dto;
  }

  /** 质控微服务根据人员编码查询人员和机构信息 */
  @Override
  public ResultDTO getStaffByStaffCode(String code) {
    StaffSpecialDO staffSpecialDO = staffSpecialDAO.getAgencyByStaff(code);
    if (staffSpecialDO == null) {
      throw new NotFoundByIdException("未查询到人员编码与" + code + " 对应的护理人员信息");
    }
    ResultDTO dto = new ResultDTO();
    dto.setStatus(StatusCodeEnum.OK.getValue());
    dto.setDatas(staffSpecialDO);
    return dto;
  }
}
