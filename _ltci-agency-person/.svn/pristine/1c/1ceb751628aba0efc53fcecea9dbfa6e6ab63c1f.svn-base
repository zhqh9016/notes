package com.taikang.dic.ltci.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taikang.dic.ltci.common.enumeration.ActionTypeEnum;
import com.taikang.dic.ltci.common.enumeration.AgencyStateEnum;
import com.taikang.dic.ltci.common.enumeration.IsValidEnum;
import com.taikang.dic.ltci.common.exception.ThrowsException;
import com.taikang.dic.ltci.common.util.DateFormatUtil;
import com.taikang.dic.ltci.dao.AgencyStaffUnionSpecDAO;
import com.taikang.dic.ltci.dao.StaffAuditHistoryDAO;
import com.taikang.dic.ltci.dao.StaffDAO;
import com.taikang.dic.ltci.dao.StaffHistoryDAO;
import com.taikang.dic.ltci.model.StaffAuditHistoryDO;
import com.taikang.dic.ltci.model.StaffDO;
import com.taikang.dic.ltci.model.StaffDOExample;
import com.taikang.dic.ltci.model.StaffHistoryDO;
import com.taikang.dic.ltci.model.StaffHistoryDOExample;
import com.taikang.dic.ltci.model.StaffHistoryUnionExample;
import com.taikang.dic.ltci.service.IAgencyStaffFileService;
import com.taikang.dic.ltci.service.IStaffHistoryService;
import com.taikang.dic.ltci.service.IStaffInterfaceService;

@Service
public class StaffHistoryServiceImpl implements IStaffHistoryService {
  private static final Logger logger = LoggerFactory.getLogger(StaffHistoryServiceImpl.class);
  @Autowired private StaffHistoryDAO staffHistoryDAO;
  @Autowired private AgencyStaffUnionSpecDAO agencyStaffUnionSpecDAO;
  @Autowired private StaffDAO staffDAO;
  @Autowired private StaffAuditHistoryDAO staffAuditHistoryDAO;
  @Autowired private IAgencyStaffFileService agencyStaffFileService;
  @Autowired private IStaffInterfaceService staffInterfaceService;

  @Override
  public StaffHistoryDO getStaffHistoryDetailByStaffId(String staffId) {
    return staffHistoryDAO.selectByPrimaryKey(staffId);
  }

  @Override
  public Map<String, Object> getStaffApplyOrModifyList(
      String actionType,
      String staffName,
      String agencyName,
      String auditState,
      String dsignatedAgencyLevel,
      String dsignatedAgencyType,
      String agencyType,
      String applyBeginDate,
      String applyEndDate,
      String jobScope,
      Integer page,
      Integer pageSize) {
    StaffHistoryUnionExample example = new StaffHistoryUnionExample();
    if (actionType != null && !"".equals(actionType)) {
      example.setActionType(actionType);
    }
    if (staffName != null && !"".equals(staffName)) {
      example.setStaffName("%" + staffName + "%");
    }
    if (agencyName != null && !"".equals(agencyName)) {
      example.setAgencyName("%" + agencyName + "%");
    }
    if (auditState != null && !"".equals(auditState)) {
      String[] arr = auditState.split(",");
      example.setAuditState(arr);
    }
    if (agencyType != null && !"".equals(agencyType)) {
      String[] arr = agencyType.split(",");
      example.setAgencyType(arr);
      example.setIsHasAgencyType(true);
    }
    if (applyBeginDate != null
        && !"".equals(applyBeginDate)
        && applyEndDate != null
        && !"".equals(applyEndDate)) {
      applyEndDate += " 23:59:59";
      example.setIsBetweenOne(false);
      example.setBeginTime(
          DateFormatUtil.strToDate(applyBeginDate, DateFormatUtil.DATE_FORMAT_YYYY_MM_DD));
      example.setEndTime(
          DateFormatUtil.strToDate(applyEndDate, DateFormatUtil.DATE_FORMAT_YYYY_MM_DD_HH_MM_SS));
    } else if (applyBeginDate != null && !"".equals(applyBeginDate)) {
      example.setIsBetweenOne(true);
      example.setBeginTime(
          DateFormatUtil.strToDate(applyBeginDate, DateFormatUtil.DATE_FORMAT_YYYY_MM_DD));
    } else if (applyEndDate != null && !"".equals(applyEndDate)) {
      applyEndDate += " 23:59:59";
      example.setIsBetweenOne(true);
      example.setEndTime(
          DateFormatUtil.strToDate(applyEndDate, DateFormatUtil.DATE_FORMAT_YYYY_MM_DD_HH_MM_SS));
    }
    if (dsignatedAgencyLevel != null && !"".equals(dsignatedAgencyLevel)) {
      String[] arr = dsignatedAgencyLevel.split(",");
      example.setAgencyLevel(arr);
      example.setIsAgencyLevel(true);
    }
    if (dsignatedAgencyType != null && !"".equals(dsignatedAgencyType)) {
      String[] arr = dsignatedAgencyType.split(",");
      example.setDsignatedAgencyType(arr);
      example.setIsHasDisAgType(true);
    }
    if (jobScope != null && !"".equals(jobScope)) {
      String[] arr = jobScope.split(",");
      for (int i = 0; i < arr.length; i++) {
        arr[i] = "%" + arr[i] + "%";
      }
      example.setJobScope(arr);
      //      example.setJobScope("%" + jobScope + "%");
    }
    int count = agencyStaffUnionSpecDAO.countByExample(example);

    int totalPage = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
    example.setBeginNum((page - 1) * pageSize);
    example.setEndNum((page) * pageSize);
    List<StaffHistoryDO> staffHistoryList = agencyStaffUnionSpecDAO.selectByExample(example);

    Map<String, Object> model = new HashMap<>();
    model.put("page", page);
    model.put("pageSize", pageSize);
    model.put("totalDataNum", count);
    model.put("totalPageNum", totalPage);
    model.put("staffHistoryList", staffHistoryList);
    return model;
  }

  /**
   * 人员申请 新增/变更 受理、审核
   *
   * <p>新增1时：受理->根据人员身份证号判断原始表中有无有效的人员数据； 暂不受理 审核通过-> 新增原始表正式人员数据 审核不通过
   *
   * <p>变更2时：审核通过-> 修改原始表正式人员数据 审核不通过
   */
  @Override
  @Transactional
  public int staffHistoryStateCase(StaffHistoryDO staffHistoryDO) {
    int result = 0;
    //在受理或暂不受理时进行校验是否有有效人员
    if (isHaveStaff(staffHistoryDO)) {
      throw new ThrowsException("该申请人已经存在有效记录，不能重复申请");
    }
    try {
      //状态修改 不管是新增还是变更，只要是修改状态都得更新
      StaffHistoryDOExample example = new StaffHistoryDOExample();
      com.taikang.dic.ltci.model.StaffHistoryDOExample.Criteria c = example.createCriteria();
      c.andSerialNoEqualTo(staffHistoryDO.getSerialNo());
      staffHistoryDO.setOperatedTime(new Date());

      if (AgencyStateEnum.STATE_ACCEPT.getValue() == staffHistoryDO.getAuditState()
          || AgencyStateEnum.STATE_WITHHOLD_ACCEPT.getValue()
              == staffHistoryDO.getAuditState()) { //受理时
        c.andAuditStateEqualTo(AgencyStateEnum.STATE_NO_ACCEPT.getValue());
        c.andIsValidEqualTo(IsValidEnum.NO_DELETE.getValue());
        List<StaffHistoryDO> list = staffHistoryDAO.selectByExample(example);
        if (list.isEmpty()) {
          return -1;
        }
      }
      if (AgencyStateEnum.STATE_AUDIT.getValue() == staffHistoryDO.getAuditState()
          || AgencyStateEnum.STATE_NO_AUDIT.getValue() == staffHistoryDO.getAuditState()) { //审核时
        c.andAuditStateEqualTo(AgencyStateEnum.STATE_ACCEPT.getValue());
        c.andIsValidEqualTo(IsValidEnum.NO_DELETE.getValue());
        List<StaffHistoryDO> list = staffHistoryDAO.selectByExample(example);
        if (list.isEmpty()) {
          return -1;
        }
      }
      int staffHistoryUpdate = staffHistoryDAO.updateByExampleSelective(staffHistoryDO, example);
      result = staffHistoryUpdate;
      //受理不通过 或 审核不通过 更新附件的有效性
      updateAgencyStaffFileToIsValid(staffHistoryDO);
      //状态历史记录新增
      if (staffHistoryUpdate > 0) {
        StaffAuditHistoryDO staffAuditHistoryDO = new StaffAuditHistoryDO();
        BeanUtils.copyProperties(staffHistoryDO, staffAuditHistoryDO);
        Date date = new Date();
        staffAuditHistoryDO.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        staffAuditHistoryDO.setCreatedBy(staffHistoryDO.getOperatedBy());
        staffAuditHistoryDO.setCreatedOrg(staffHistoryDO.getOperatedOrg());
        staffAuditHistoryDO.setCreatedTime(date);
        staffAuditHistoryDO.setOperatedTime(date);
        staffAuditHistoryDO.setIsValid(IsValidEnum.NO_DELETE.getValue());
        int staffAuditHistoryUpdate = staffAuditHistoryDAO.insertSelective(staffAuditHistoryDO);
        result = staffAuditHistoryUpdate;
        if (staffAuditHistoryUpdate > 0) {
          //先判断状态，然后再审核状态中再判断 操作类型
          staffAuditHistoryUpdate = staffHistoryStateCase2(staffHistoryDO);
          if (staffAuditHistoryUpdate > 0) {
            //调取发送消息
            staffUpateMQ(staffHistoryDO);
          } else {
            result = 0;
          }
        }
      }
    } catch (Exception e) {
      logger.error("staffHistoryStateCase(StaffHistoryDO staffHistoryDO) 人员状态处理出错：" + e);
      throw new ThrowsException("人员状态处理出错:" + e.getMessage());
    }
    return result;
  }

  private boolean isHaveStaff(StaffHistoryDO staffHistoryDO) {
    //申请受理  判断人员原始有无对应申请人信息
    if (AgencyStateEnum.STATE_ACCEPT.getValue() == staffHistoryDO.getAuditState()) {
      //查询人员原始数据
      StaffDOExample staffExample = new StaffDOExample();
      com.taikang.dic.ltci.model.StaffDOExample.Criteria staffCriteria =
          staffExample.createCriteria();
      staffCriteria
          .andCredentialNumberEqualTo(staffHistoryDO.getCredentialNumber()) //身份证号
          .andIsValidEqualTo(IsValidEnum.NO_DELETE.getValue());
      List<StaffDO> staffList = staffDAO.selectByExample(staffExample);
      if (!staffList.isEmpty()) {
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }

  private void updateAgencyStaffFileToIsValid(StaffHistoryDO staffHistoryDO) {
    if (AgencyStateEnum.STATE_WITHHOLD_ACCEPT.getValue() == staffHistoryDO.getAuditState()
        || AgencyStateEnum.STATE_NO_AUDIT.getValue() == staffHistoryDO.getAuditState()) {
      agencyStaffFileService.updateAgencyStaffFileToIsValidByHisId(staffHistoryDO.getSerialNo());
    }
  }

  private int staffHistoryStateCase2(StaffHistoryDO staffHistoryDO) {
    int result = 1;
    if (AgencyStateEnum.STATE_AUDIT.getValue() == staffHistoryDO.getAuditState()) { //状态为审核时
      if (ActionTypeEnum.CREATE.getValue().equals(staffHistoryDO.getActionType())) { //人员新增时
        //先判断原始表中有无记录  如果有则获取原来的人员编码放入新申请人员中
        //            StaffDOExample staffExample = new StaffDOExample();
        //            com.taikang.dic.ltci.model.StaffDOExample.Criteria staffCriteria =
        //                staffExample.createCriteria();
        //            staffCriteria
        //                .andCredentialNumberEqualTo(staffHistoryDO.getCredentialNumber()) //身份证号
        //                .andIsValidEqualTo(IsValidEnum.ALREADY_DELETE.getValue());
        //            List<StaffDO> staffList = staffDAO.selectByExample(staffExample);
        //            if (!staffList.isEmpty()) {
        //                StaffDO staffDO = staffList.get(0);
        //                staffHistoryDO.setStaffCode(staffDO.getStaffCode());
        //            }
        //新增人员原始记录
        result = staffAdd(staffHistoryDO);
      }
      if (ActionTypeEnum.UPDATE.getValue().equals(staffHistoryDO.getActionType())) { //人员变更时
        StaffHistoryDOExample example = new StaffHistoryDOExample();
        com.taikang.dic.ltci.model.StaffHistoryDOExample.Criteria c = example.createCriteria();
        c.andSerialNoEqualTo(staffHistoryDO.getSerialNo());

        StaffHistoryDO staffHistoryDO2 =
            staffHistoryDAO.selectByPrimaryKey(staffHistoryDO.getSerialNo());
        //修改人员原始记录
        result = staffUpdate(staffHistoryDO2);
      }
      if (ActionTypeEnum.DELETE.getValue().equals(staffHistoryDO.getActionType())) { //人员注销时
        //修改人员原始记录
        staffHistoryDO.setIsValid(IsValidEnum.ALREADY_DELETE.getValue());
        result = staffUpdate(staffHistoryDO);
      }
    }
    return result;
  }

  private int staffAdd(StaffHistoryDO staffHistoryDO) {
    StaffHistoryDOExample example = new StaffHistoryDOExample();
    com.taikang.dic.ltci.model.StaffHistoryDOExample.Criteria c = example.createCriteria();
    c.andSerialNoEqualTo(staffHistoryDO.getSerialNo());
    StaffHistoryDO staffHistoryDO2 =
        staffHistoryDAO.selectByPrimaryKey(staffHistoryDO.getSerialNo());

    Date date = new Date();
    StaffDO staffDO = new StaffDO();
    BeanUtils.copyProperties(staffHistoryDO2, staffDO);
    staffDO.setStaffid(UUID.randomUUID().toString().replaceAll("-", ""));
    staffDO.setCreatedBy(staffHistoryDO.getOperatedBy());
    staffDO.setCreatedOrg(staffHistoryDO.getOperatedOrg());
    staffDO.setCreatedTime(date);
    staffDO.setOperatedBy(staffHistoryDO.getOperatedBy());
    staffDO.setOperatedOrg(staffHistoryDO.getOperatedOrg());
    staffDO.setOperatedTime(date);
    staffDO.setIsValid(IsValidEnum.NO_DELETE.getValue());
    return staffDAO.insertSelective(staffDO);
  }

  private int staffUpdate(StaffHistoryDO staffHistoryDO) {
    StaffDO staffDO = new StaffDO();
    StaffDOExample example = new StaffDOExample();
    com.taikang.dic.ltci.model.StaffDOExample.Criteria c = example.createCriteria();
    c.andStaffCodeEqualTo(staffHistoryDO.getStaffCode());
    c.andIsValidEqualTo(IsValidEnum.NO_DELETE.getValue());
    BeanUtils.copyProperties(staffHistoryDO, staffDO);
    staffDO.setOperatedBy(staffHistoryDO.getOperatedBy());
    staffDO.setOperatedOrg(staffHistoryDO.getOperatedOrg());
    staffDO.setOperatedTime(new Date());
    return staffDAO.updateByExampleSelective(staffDO, example);
  }

  private void staffUpateMQ(StaffHistoryDO staffHistoryDO) {
    StaffHistoryDOExample example = new StaffHistoryDOExample();
    com.taikang.dic.ltci.model.StaffHistoryDOExample.Criteria c = example.createCriteria();
    c.andSerialNoEqualTo(staffHistoryDO.getSerialNo());

    StaffHistoryDO staffHistoryDO2 =
        staffHistoryDAO.selectByPrimaryKey(staffHistoryDO.getSerialNo());

    if (AgencyStateEnum.STATE_ACCEPT.getValue() == staffHistoryDO.getAuditState()
        || AgencyStateEnum.STATE_WITHHOLD_ACCEPT.getValue()
            == staffHistoryDO.getAuditState()) { //受理时
      staffInterfaceService.sendAcceptResult(staffHistoryDO2);
    }
    if (AgencyStateEnum.STATE_AUDIT.getValue() == staffHistoryDO.getAuditState()
        || AgencyStateEnum.STATE_NO_AUDIT.getValue() == staffHistoryDO.getAuditState()) { //审核时
      if (ActionTypeEnum.CREATE.getValue().equals(staffHistoryDO.getActionType())) { //人员新增时
        staffInterfaceService.sendApproveResult(staffHistoryDO2);
      }
      if (ActionTypeEnum.UPDATE.getValue().equals(staffHistoryDO.getActionType())) { //人员变更时
        staffInterfaceService.sendChangeApproveResult(staffHistoryDO2);
      }
    }
  }
}
