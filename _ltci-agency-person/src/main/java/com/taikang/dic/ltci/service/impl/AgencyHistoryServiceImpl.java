package com.taikang.dic.ltci.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
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
import org.springframework.util.StringUtils;

import com.taikang.dic.ltci.api.model.AgencyDTO;
import com.taikang.dic.ltci.api.model.AgencyHistoryDTO;
import com.taikang.dic.ltci.common.enumeration.ActionTypeEnum;
import com.taikang.dic.ltci.common.enumeration.AgencyStateEnum;
import com.taikang.dic.ltci.common.enumeration.ProfessionTypeEnum;
import com.taikang.dic.ltci.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.common.util.DateFormatUtil;
import com.taikang.dic.ltci.dao.AgencyAuditHistoryDAO;
import com.taikang.dic.ltci.dao.AgencyDAO;
import com.taikang.dic.ltci.dao.AgencyHistoryDAO;
import com.taikang.dic.ltci.dao.AgencyStaffFileRDAO;
import com.taikang.dic.ltci.dao.StaffRankDAO;
import com.taikang.dic.ltci.model.AgencyAuditHistoryDO;
import com.taikang.dic.ltci.model.AgencyDO;
import com.taikang.dic.ltci.model.AgencyDOExample;
import com.taikang.dic.ltci.model.AgencyHistoryDO;
import com.taikang.dic.ltci.model.AgencyHistoryDOExample;
import com.taikang.dic.ltci.model.AgencyHistoryDOExample.Criteria;
import com.taikang.dic.ltci.model.AgencyStaffFileRDO;
import com.taikang.dic.ltci.model.AgencyStaffFileRDOExample;
import com.taikang.dic.ltci.model.BaseModel;
import com.taikang.dic.ltci.model.BaseModel.IsValid;
import com.taikang.dic.ltci.model.StaffRankDO;
import com.taikang.dic.ltci.model.StaffRankDOExample;
import com.taikang.dic.ltci.service.IAgencyHistoryService;
import com.taikang.dic.ltci.service.IAgencyInterfaceService;
import com.taikang.dic.ltci.service.IAgencyStaffFileService;
import com.taikang.dic.ltci.service.ServiceException;

@Service
public class AgencyHistoryServiceImpl implements IAgencyHistoryService {

  private Logger logger = LoggerFactory.getLogger(AgencyHistoryServiceImpl.class);

  @Autowired private AgencyHistoryDAO agencyHistoryDao;

  @Autowired private AgencyDAO agencyDao;

  @Autowired private AgencyAuditHistoryDAO auditHisDao;

  @Autowired private StaffRankDAO staffRankDao;

  @Autowired private IAgencyInterfaceService agencyInterfaceService;

  @Autowired private IAgencyStaffFileService agencyStaffFileService;

  @Autowired private AgencyStaffFileRDAO agencyStaffFileRDAO;

  @Override
  public Map<String, Object> getAgencyApplyList(
      String agencyName,
      String dsignatedAgencyLevel,
      String dsignatedAgencyType,
      String agencyType,
      String acceptState,
      String applyBeginDate,
      String applyEndDate,
      Integer page,
      Integer pageSize) {
    // 查询条件
    AgencyHistoryDOExample example = new AgencyHistoryDOExample();
    Criteria c = example.createCriteria();
    // 如果机构名称不为空
    if (!StringUtils.isEmpty(agencyName)) {
      c.andAgencyNameLike("%" + agencyName + "%");
    }
    // 如果定点机构类别不为空
    if (!StringUtils.isEmpty(dsignatedAgencyLevel)) {
      String[] agencyLevelStr = dsignatedAgencyLevel.split(",");
      List<Integer> agencyLevelList = new ArrayList<>();
      for (String agencyLevel : agencyLevelStr) {
        agencyLevelList.add(Integer.parseInt(agencyLevel));
      }
      c.andAgencyLevelIn(agencyLevelList);
    }
    // 如果定点服务机构类型不为空
    if (!StringUtils.isEmpty(dsignatedAgencyType)) {
      for (String agencyServiceType : Arrays.asList(dsignatedAgencyType.split(","))) {
        c.andAgencyServiceTypeLike("%" + agencyServiceType + "%");
      }
    }
    // 如果机构类型不为空
    if (!StringUtils.isEmpty(agencyType)) {
      for (String agencyTypeStr : Arrays.asList(agencyType.split(","))) {
        c.andAgencyTypeLike("%" + agencyTypeStr + "%");
      }
    }
    // 如果受理状态不为空
    if (!StringUtils.isEmpty(acceptState)) {
      String[] acceptStateStr = acceptState.split(",");
      List<Integer> stateList = new ArrayList<>();
      for (String state : acceptStateStr) {
        stateList.add(Integer.parseInt(state));
      }
      c.andAgencyStateIn(stateList);
    } else {
      c.andAgencyStateEqualTo(AgencyStateEnum.STATE_NO_ACCEPT.getValue());
    }
    // 如果申请开始时间不为空
    if (!StringUtils.isEmpty(applyBeginDate)) {
      c.andAgencyApplyDateGreaterThanOrEqualTo(DateFormatUtil.getDayFirstTime(applyBeginDate));
    }
    // 如果申请结束时间不为空
    if (!StringUtils.isEmpty(applyEndDate)) {
      c.andAgencyApplyDateLessThanOrEqualTo(DateFormatUtil.getDayLastTime(applyEndDate));
    }
    // 操作类型--新增
    c.andActionTypeEqualTo(ActionTypeEnum.CREATE.getValue());

    int count = agencyHistoryDao.countByExample(example);

    int pageIndex = (page - 1) * pageSize;
    int totalPage = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
    example.setOrderByClause(" agency_apply_date asc  limit " + pageIndex + " , " + pageSize + " ");

    List<AgencyHistoryDO> agencyHistoryList = agencyHistoryDao.selectByExample(example);

    Map<String, Object> model = new HashMap<>();
    model.put("page", page);
    model.put("pageSize", pageSize);
    model.put("totalDataNum", count);
    model.put("totalPageNum", totalPage);
    model.put("agencyHistoryList", agencyHistoryList);
    return model;
  }

  @Override
  public AgencyHistoryDO getAgencyHistory(String id) {
    return agencyHistoryDao.selectByPrimaryKey(id);
  }

  @Override
  @Transactional
  public boolean agencyOnlineApplyUpdate(AgencyHistoryDTO agencyHis) throws ServiceException {
    // 机构在线申请变更处理
    AgencyHistoryDO agencyHistoryDO = new AgencyHistoryDO();
    if (agencyHis.getAgencyState() == AgencyStateEnum.STATE_AUDIT.getValue()
        && !StringUtils.isEmpty(agencyHis.getAgencyCodeInput())) {
      String agencyCodeInput =
          agencyHis.getAgencyCode().substring(0, 6) + agencyHis.getAgencyCodeInput();
      logger.debug(
          "__机构编码agencyCode_____"
              + agencyCodeInput
              + "___机构状态agencyState___"
              + agencyHis.getAgencyState());
      agencyHis.setAgencyCode(agencyCodeInput);
      // 更新资源中间表
      AgencyStaffFileRDO fileDO = new AgencyStaffFileRDO();
      fileDO.setCode(agencyCodeInput);
      AgencyStaffFileRDOExample fileExample = new AgencyStaffFileRDOExample();
      fileExample.createCriteria().andHistoryIdEqualTo(agencyHis.getSerialNum());
      agencyStaffFileRDAO.updateByExampleSelective(fileDO, fileExample);
    }
    BeanUtils.copyProperties(agencyHis, agencyHistoryDO);
    agencyHistoryDO.setOperatedTime(new Date());
    logger.debug("__机构受理信息agencyHistoryDO_____" + agencyHistoryDO);
    int i = agencyHistoryDao.updateByPrimaryKeySelective(agencyHistoryDO);
    if (i > 0) {
      if (agencyHis.getAgencyState() == AgencyStateEnum.STATE_ACCEPT.getValue()
          || agencyHis.getAgencyState() == AgencyStateEnum.STATE_WITHHOLD_ACCEPT.getValue()) {
        // 调用受理结果告知
        agencyHis.setOperatedTime(DateFormatUtil.dateToTimeStr(new Date()));
        agencyInterfaceService.sendOrgAcceptResult(agencyHis);
      }
    } else {
      throw new ServiceException(StatusCodeEnum.INTERNAL_SERVER_ERROR.getValue(), "机构受理失败");
    }
    // 添加审核流水记录
    auditHisDao.insertSelective(getAuditHistoryInfo(agencyHis));
    // 调用机构申请、变更审核操作
    callAgencyCreateUpdate(agencyHis);
    // 更新机构附件有效性
    updateAgencyStaffFileToIsValid(agencyHis);
    return true;
  }

  /**
   * 机构申请、变更审核操作
   *
   * @param agencyHis
   * @throws ServiceException
   */
  private void callAgencyCreateUpdate(AgencyHistoryDTO agencyHis) throws ServiceException {
    // 调用申请审核结果告知
    if (agencyHis.getAgencyState() == AgencyStateEnum.STATE_AUDIT.getValue()
        || agencyHis.getAgencyState() == AgencyStateEnum.STATE_NO_AUDIT.getValue()) {
      // 若是申请操作，则生成新的机构信息数据
      if (ActionTypeEnum.CREATE.getValue().equals(agencyHis.getActionType())) {
        // 审核通过
        if (agencyHis.getAgencyState() == AgencyStateEnum.STATE_AUDIT.getValue()) {
          agencyApplyAudit(agencyHis);
        }
        agencyInterfaceService.sendOrgApproveResult(callAuditNotifyInterface(agencyHis));
      }
      // 若是变更操作，则更新机构信息数据
      if (ActionTypeEnum.UPDATE.getValue().equals(agencyHis.getActionType())) {
        // 审核通过
        if (agencyHis.getAgencyState() == AgencyStateEnum.STATE_AUDIT.getValue()) {
          AgencyHistoryDO agencyHisDo =
              agencyHistoryDao.selectByPrimaryKey(agencyHis.getSerialNum());
          agencyHisDo.setAgencyState(AgencyStateEnum.STATE_AUDIT.getValue());
          agencyUpdateAudit(agencyHisDo);
        }
        // 调用变更审核结果告知
        agencyInterfaceService.sendOrgChangeResult(callAuditNotifyInterface(agencyHis));
      }
    }
  }

  /**
   * 调用审核结果告知接口
   *
   * @param agencyHisDto
   */
  private AgencyDTO callAuditNotifyInterface(AgencyHistoryDTO agencyHisDto) {
    AgencyDTO agencyDto = new AgencyDTO();
    agencyDto.setOperatedTime(DateFormatUtil.dateToTimeStr(new Date()));
    // 审核通过或不通过时，调用审核结果告知接口
    // 根据机构信息码查询机构信息
    AgencyDOExample example = new AgencyDOExample();
    com.taikang.dic.ltci.model.AgencyDOExample.Criteria c = example.createCriteria();
    c.andOrgCodeEqualTo(agencyHisDto.getOrgCode());
    c.andIsValidEqualTo(BaseModel.IsValid.VALID.getValue());
    List<AgencyDO> agencyList = agencyDao.selectByExample(example);
    if (agencyList != null && !agencyList.isEmpty()) {
      AgencyDO agencyInfo = agencyList.get(0);
      BeanUtils.copyProperties(agencyInfo, agencyDto);
      // 审核状态
      agencyDto.setAgencyState(agencyHisDto.getAgencyState());
      // 原因
      agencyDto.setRejectionReason(agencyHisDto.getCause());
      // 密钥开始日期
      if (agencyInfo.getKeyBeginDate() != null) {
        agencyDto.setKeyBeginDate(
            DateFormatUtil.dateToStr(
                agencyInfo.getKeyBeginDate(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD));
      }
      if (agencyInfo.getKeyEndDate() != null) {
        // 密钥终止日期
        agencyDto.setKeyEndDate(
            DateFormatUtil.dateToStr(
                agencyInfo.getKeyEndDate(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD));
      }
    } else {
      BeanUtils.copyProperties(agencyHisDto, agencyDto);
    }
    return agencyDto;
  }

  /**
   * 生成审核流水数据
   *
   * @param agencyHisDto
   * @return
   */
  private AgencyAuditHistoryDO getAuditHistoryInfo(AgencyHistoryDTO agencyHisDto) {
    AgencyAuditHistoryDO auditHisDo = new AgencyAuditHistoryDO();
    // 主键
    auditHisDo.setId(UUID.randomUUID().toString().replace("-", ""));
    // 机构流水号
    auditHisDo.setSerialNo(agencyHisDto.getSerialNum());
    // 操作类型
    auditHisDo.setType(Integer.parseInt(agencyHisDto.getActionType()));
    // 状态
    auditHisDo.setAuditState(agencyHisDto.getAgencyState());
    auditHisDo.setCreatedBy(agencyHisDto.getOperatedBy());
    auditHisDo.setCreatedOrg(agencyHisDto.getOperatedOrg());
    auditHisDo.setCreatedTime(new Date());
    auditHisDo.setOperatedBy(agencyHisDto.getOperatedBy());
    auditHisDo.setOperatedOrg(agencyHisDto.getOperatedOrg());
    auditHisDo.setOperatedTime(new Date());
    return auditHisDo;
  }

  /**
   * 机构申请审核处理
   *
   * @param agencyHisDto
   * @throws ServiceException
   */
  private void agencyApplyAudit(AgencyHistoryDTO agencyHisDto) throws ServiceException {
    AgencyHistoryDO agencyHisDo = agencyHistoryDao.selectByPrimaryKey(agencyHisDto.getSerialNum());
    AgencyDO agencyDo = new AgencyDO();
    BeanUtils.copyProperties(agencyHisDo, agencyDo);
    agencyDo.setAgencyid(UUID.randomUUID().toString().replace("-", ""));
    agencyDo.setCreatedTime(agencyHisDo.getOperatedTime());
    agencyDo.setOperatedTime(new Date());
    agencyDo.setSecretKey(agencyDo.getAgencyid());
    agencyDo.setAgencyState(agencyHisDto.getAgencyState());
    agencyDo.setKeyBeginDate(
        DateFormatUtil.strToDate(
            agencyHisDto.getKeyBeginDate(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD));
    agencyDo.setKeyEndDate(
        DateFormatUtil.strToDate(
            agencyHisDto.getKeyEndDate(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD));
    logger.debug("________机构申请审核信息agencyDo_____" + agencyDo);
    // 判断此机构编号是否存在有效数据
    AgencyDOExample agencyExample = new AgencyDOExample();
    agencyExample
        .createCriteria()
        .andOrgCodeEqualTo(agencyHisDto.getOrgCode())
        .andIsValidEqualTo(IsValid.VALID.getValue());
    List<AgencyDO> agencyCheckList = agencyDao.selectByExample(agencyExample);
    if (agencyCheckList == null || agencyCheckList.isEmpty()) {
      int j = agencyDao.insert(agencyDo);
      if (j > 0) {
        // 生成机构人员职级子表数据
        createStaffRankData(agencyHisDo);
      } else {
        throw new ServiceException(StatusCodeEnum.INTERNAL_SERVER_ERROR.getValue(), "机构申请审核失败");
      }
    }
  }

  /**
   * 机构变更审核处理
   *
   * @param agencyHisDto
   * @throws ServiceException
   */
  private void agencyUpdateAudit(AgencyHistoryDO agencyHisDo) throws ServiceException {
    AgencyDO agencyDo = new AgencyDO();
    BeanUtils.copyProperties(agencyHisDo, agencyDo);
    AgencyDOExample example = new AgencyDOExample();
    example.createCriteria().andOrgCodeEqualTo(agencyDo.getOrgCode());
    agencyDo.setOperatedTime(new Date());
    logger.debug("________机构变更审核信息agencyDo_____" + agencyDo);
    int j = agencyDao.updateByExampleSelective(agencyDo, example);
    if (j > 0) {
      // 更新机构人员职级子表数据
      updateStaffRankDoctor(agencyHisDo);
      updateStaffRankNurse(agencyHisDo);
      updateStaffRankCarer(agencyHisDo);
      updateStaffRankMisc(agencyHisDo);
    } else {
      throw new ServiceException(StatusCodeEnum.INTERNAL_SERVER_ERROR.getValue(), "机构变更审核失败");
    }
  }

  /**
   * 添加机构职级数据
   *
   * @param agencyHisDo
   * @throws ServiceException
   */
  private void createStaffRankData(AgencyHistoryDO agencyHisDo) throws ServiceException {
    // 医师数
    StaffRankDO doctorDO = new StaffRankDO();
    doctorDO.setRankid(UUID.randomUUID().toString().replace("-", ""));
    doctorDO.setAgencyCode(agencyHisDo.getAgencyCode());
    doctorDO.setProfessionType(ProfessionTypeEnum.DOCTOR_CODE.getValue());
    doctorDO.setAdvanced(agencyHisDo.getAdvancedDoctorNum());
    doctorDO.setIntermediate(agencyHisDo.getIntermediateDoctorNum());
    doctorDO.setElementary(agencyHisDo.getPrimaryDoctorNum());
    doctorDO.setTotalNum(
        agencyHisDo.getAdvancedDoctorNum()
            + agencyHisDo.getIntermediateDoctorNum()
            + agencyHisDo.getPrimaryDoctorNum());
    doctorDO.setIsValid(IsValid.VALID.getValue());
    logger.debug("________医师数doctorDO_____" + doctorDO);
    int i = staffRankDao.insert(doctorDO);
    if (i <= 0) {
      throw new ServiceException(StatusCodeEnum.INTERNAL_SERVER_ERROR.getValue(), "添加医师数失败");
    }
    // 护士数
    StaffRankDO nurseDO = new StaffRankDO();
    nurseDO.setRankid(UUID.randomUUID().toString().replace("-", ""));
    nurseDO.setAgencyCode(agencyHisDo.getAgencyCode());
    nurseDO.setProfessionType(ProfessionTypeEnum.NURSE_CODE.getValue());
    nurseDO.setAdvanced(agencyHisDo.getAdvancedNurseNum());
    nurseDO.setIntermediate(agencyHisDo.getIntermediateNurseNum());
    nurseDO.setElementary(agencyHisDo.getPrimaryNurseNum());
    nurseDO.setTotalNum(
        agencyHisDo.getAdvancedNurseNum()
            + agencyHisDo.getIntermediateNurseNum()
            + agencyHisDo.getPrimaryNurseNum());
    nurseDO.setIsValid(IsValid.VALID.getValue());
    logger.debug("________护士数nurseDO_____" + nurseDO);
    i = staffRankDao.insert(nurseDO);
    if (i <= 0) {
      throw new ServiceException(StatusCodeEnum.INTERNAL_SERVER_ERROR.getValue(), "添加护士数失败");
    }
    // 护理员数
    StaffRankDO carerDO = new StaffRankDO();
    carerDO.setRankid(UUID.randomUUID().toString().replace("-", ""));
    carerDO.setAgencyCode(agencyHisDo.getAgencyCode());
    carerDO.setProfessionType(ProfessionTypeEnum.CARER_CODE.getValue());
    carerDO.setAdvanced(agencyHisDo.getAdvancedCarerNum());
    carerDO.setIntermediate(agencyHisDo.getIntermediateCarerNum());
    carerDO.setElementary(agencyHisDo.getPrimaryCarerNum());
    carerDO.setTotalNum(
        agencyHisDo.getAdvancedCarerNum()
            + agencyHisDo.getIntermediateCarerNum()
            + agencyHisDo.getPrimaryCarerNum());
    carerDO.setIsValid(IsValid.VALID.getValue());
    logger.debug("________护理员数carerDO_____" + carerDO);
    i = staffRankDao.insert(carerDO);
    if (i <= 0) {
      throw new ServiceException(StatusCodeEnum.INTERNAL_SERVER_ERROR.getValue(), "添加护理员数失败");
    }
    // 其他人员数
    StaffRankDO miscDO = new StaffRankDO();
    miscDO.setRankid(UUID.randomUUID().toString().replace("-", ""));
    miscDO.setAgencyCode(agencyHisDo.getAgencyCode());
    miscDO.setProfessionType(ProfessionTypeEnum.MISC_CODE.getValue());
    miscDO.setAdvanced(agencyHisDo.getAdvancedMiscNum());
    miscDO.setIntermediate(agencyHisDo.getIntermediateMiscNum());
    miscDO.setElementary(agencyHisDo.getPrimaryMiscNum());
    miscDO.setTotalNum(
        agencyHisDo.getAdvancedMiscNum()
            + agencyHisDo.getIntermediateMiscNum()
            + agencyHisDo.getPrimaryMiscNum());
    miscDO.setIsValid(IsValid.VALID.getValue());
    logger.debug("________其他人员数miscDO_____" + miscDO);
    i = staffRankDao.insert(miscDO);
    if (i <= 0) {
      throw new ServiceException(StatusCodeEnum.INTERNAL_SERVER_ERROR.getValue(), "添加其他人员数失败");
    }
  }

  /**
   * 更新机构职级数据(医师数)
   *
   * @param agencyHisDto
   */
  private void updateStaffRankDoctor(AgencyHistoryDO agencyHisDo) throws ServiceException {
    // 医师数
    if (agencyHisDo.getAdvancedDoctorNum() != null
        || agencyHisDo.getIntermediateDoctorNum() != null
        || agencyHisDo.getPrimaryDoctorNum() != null) {
      StaffRankDOExample example = new StaffRankDOExample();
      com.taikang.dic.ltci.model.StaffRankDOExample.Criteria c = example.createCriteria();
      c.andAgencyCodeEqualTo(agencyHisDo.getAgencyCode());
      c.andProfessionTypeEqualTo(ProfessionTypeEnum.DOCTOR_CODE.getValue());
      StaffRankDO doctorDO = staffRankDao.selectByExample(example).get(0);
      if (agencyHisDo.getAdvancedDoctorNum() != null) {
        doctorDO.setAdvanced(agencyHisDo.getAdvancedDoctorNum());
      }
      if (agencyHisDo.getIntermediateDoctorNum() != null) {
        doctorDO.setIntermediate(agencyHisDo.getIntermediateDoctorNum());
      }
      if (agencyHisDo.getPrimaryDoctorNum() != null) {
        doctorDO.setElementary(agencyHisDo.getPrimaryDoctorNum());
      }
      doctorDO.setTotalNum(
          doctorDO.getAdvanced() + doctorDO.getIntermediate() + doctorDO.getElementary());
      logger.debug("________变更医师数doctorDO_____" + doctorDO);
      int i = staffRankDao.updateByPrimaryKeySelective(doctorDO);
      if (i <= 0) {
        throw new ServiceException(StatusCodeEnum.INTERNAL_SERVER_ERROR.getValue(), "更新医师数失败");
      }
    }
  }

  /**
   * 更新机构职级数据(护士数)
   *
   * @param agencyHisDto
   */
  private void updateStaffRankNurse(AgencyHistoryDO agencyHisDo) throws ServiceException {
    // 护士数
    if (agencyHisDo.getAdvancedNurseNum() != null
        || agencyHisDo.getIntermediateNurseNum() != null
        || agencyHisDo.getPrimaryNurseNum() != null) {
      StaffRankDOExample example = new StaffRankDOExample();
      com.taikang.dic.ltci.model.StaffRankDOExample.Criteria c = example.createCriteria();
      c.andAgencyCodeEqualTo(agencyHisDo.getAgencyCode());
      c.andProfessionTypeEqualTo(ProfessionTypeEnum.NURSE_CODE.getValue());
      StaffRankDO nurseDO = staffRankDao.selectByExample(example).get(0);
      if (agencyHisDo.getAdvancedNurseNum() != null) {
        nurseDO.setAdvanced(agencyHisDo.getAdvancedNurseNum());
      }
      if (agencyHisDo.getIntermediateNurseNum() != null) {
        nurseDO.setIntermediate(agencyHisDo.getIntermediateNurseNum());
      }
      if (agencyHisDo.getPrimaryNurseNum() != null) {
        nurseDO.setElementary(agencyHisDo.getPrimaryNurseNum());
      }
      nurseDO.setTotalNum(
          nurseDO.getAdvanced() + nurseDO.getIntermediate() + nurseDO.getElementary());
      logger.debug("________变更护士数nurseDO_____" + nurseDO);
      int i = staffRankDao.updateByPrimaryKeySelective(nurseDO);
      if (i <= 0) {
        throw new ServiceException(StatusCodeEnum.INTERNAL_SERVER_ERROR.getValue(), "更新护士数失败");
      }
    }
  }

  /**
   * 更新机构职级数据(护理员数)
   *
   * @param agencyHisDto
   */
  private void updateStaffRankCarer(AgencyHistoryDO agencyHisDo) throws ServiceException {
    // 护理员数
    if (agencyHisDo.getAdvancedCarerNum() != null
        || agencyHisDo.getIntermediateCarerNum() != null
        || agencyHisDo.getPrimaryCarerNum() != null) {
      StaffRankDOExample example = new StaffRankDOExample();
      com.taikang.dic.ltci.model.StaffRankDOExample.Criteria c = example.createCriteria();
      c.andAgencyCodeEqualTo(agencyHisDo.getAgencyCode());
      c.andProfessionTypeEqualTo(ProfessionTypeEnum.CARER_CODE.getValue());
      StaffRankDO carerDO = staffRankDao.selectByExample(example).get(0);
      if (agencyHisDo.getAdvancedCarerNum() != null) {
        carerDO.setAdvanced(agencyHisDo.getAdvancedCarerNum());
      }
      if (agencyHisDo.getIntermediateCarerNum() != null) {
        carerDO.setIntermediate(agencyHisDo.getIntermediateCarerNum());
      }
      if (agencyHisDo.getPrimaryCarerNum() != null) {
        carerDO.setElementary(agencyHisDo.getPrimaryCarerNum());
      }
      carerDO.setTotalNum(
          carerDO.getAdvanced() + carerDO.getIntermediate() + carerDO.getElementary());
      logger.debug("________变更护理员数carerDO_____" + carerDO);
      int i = staffRankDao.updateByPrimaryKeySelective(carerDO);
      if (i <= 0) {
        throw new ServiceException(StatusCodeEnum.INTERNAL_SERVER_ERROR.getValue(), "更新护理员数失败");
      }
    }
  }

  /**
   * 更新机构职级数据(其他人员数)
   *
   * @param agencyHisDto
   */
  private void updateStaffRankMisc(AgencyHistoryDO agencyHisDo) throws ServiceException {
    // 其他人员数
    if (agencyHisDo.getAdvancedMiscNum() != null
        || agencyHisDo.getIntermediateMiscNum() != null
        || agencyHisDo.getPrimaryMiscNum() != null) {
      StaffRankDOExample example = new StaffRankDOExample();
      com.taikang.dic.ltci.model.StaffRankDOExample.Criteria c = example.createCriteria();
      c.andAgencyCodeEqualTo(agencyHisDo.getAgencyCode());
      c.andProfessionTypeEqualTo(ProfessionTypeEnum.MISC_CODE.getValue());
      StaffRankDO miscDO = staffRankDao.selectByExample(example).get(0);
      if (agencyHisDo.getAdvancedMiscNum() != null) {
        miscDO.setAdvanced(agencyHisDo.getAdvancedMiscNum());
      }
      if (agencyHisDo.getIntermediateMiscNum() != null) {
        miscDO.setIntermediate(agencyHisDo.getIntermediateMiscNum());
      }
      if (agencyHisDo.getPrimaryMiscNum() != null) {
        miscDO.setElementary(agencyHisDo.getPrimaryMiscNum());
      }
      miscDO.setTotalNum(miscDO.getAdvanced() + miscDO.getIntermediate() + miscDO.getElementary());
      logger.debug("________变更其他人员数miscDO_____" + miscDO);
      int i = staffRankDao.updateByPrimaryKeySelective(miscDO);
      if (i <= 0) {
        throw new ServiceException(StatusCodeEnum.INTERNAL_SERVER_ERROR.getValue(), "更新其他人员数失败");
      }
    }
  }

  /**
   * 更新附件有效性状态
   *
   * @param agencyHisDto
   */
  private void updateAgencyStaffFileToIsValid(AgencyHistoryDTO agencyHisDto) {
    if (AgencyStateEnum.STATE_WITHHOLD_ACCEPT.getValue().equals(agencyHisDto.getAgencyState())
        || AgencyStateEnum.STATE_NO_AUDIT.getValue().equals(agencyHisDto.getAgencyState())) {
      agencyStaffFileService.updateAgencyStaffFileToIsValid(agencyHisDto.getSerialNum());
    }
  }

  @Override
  public List<AgencyHistoryDO> getAgencyHisByIdAndState(String id, Integer state) {
    AgencyHistoryDOExample hisExample = new AgencyHistoryDOExample();
    hisExample.createCriteria().andSerialNumEqualTo(id).andAgencyStateEqualTo(state);
    return agencyHistoryDao.selectByExample(hisExample);
  }
}
