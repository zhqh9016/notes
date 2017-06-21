package com.taikang.dic.ltci.service.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taikang.dic.ltci.api.model.AgencyDetailDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.enumeration.IsValidEnum;
import com.taikang.dic.ltci.common.exception.NotFoundByIdException;
import com.taikang.dic.ltci.common.util.DateFormatUtil;
import com.taikang.dic.ltci.dao.AgencyDAO;
import com.taikang.dic.ltci.dao.AgencyHistoryDAO;
import com.taikang.dic.ltci.dao.IGenericDAO;
import com.taikang.dic.ltci.dao.StaffRankDAO;
import com.taikang.dic.ltci.model.AgencyDO;
import com.taikang.dic.ltci.model.AgencyDOExample;
import com.taikang.dic.ltci.model.AgencyHistoryDO;
import com.taikang.dic.ltci.model.AgencyHistoryDOExample;
import com.taikang.dic.ltci.model.AgencyHistoryDOExample.Criteria;
import com.taikang.dic.ltci.model.BaseModel.IsValid;
import com.taikang.dic.ltci.model.StaffDiffDO;
import com.taikang.dic.ltci.model.StaffRankDO;
import com.taikang.dic.ltci.model.StaffRankDOExample;
import com.taikang.dic.ltci.service.AbstractGenericService;
import com.taikang.dic.ltci.service.IAgencyAuditService;

/**
 * 机构审核RoleServiceImpl
 *
 * @author itw_liuzy 2017-05-10
 */
@Service
public class AgencyAuditServiceImpl extends AbstractGenericService<AgencyHistoryDO, String>
    implements IAgencyAuditService {
  private Logger logger = LoggerFactory.getLogger(AgencyAuditServiceImpl.class);

  @Autowired private AgencyHistoryDAO agencyHistoryDAO;

  @Autowired private AgencyDAO agencyDAO;

  @Autowired private StaffRankDAO staffRankDAO;

  @Override
  public Map<String, Object> listAgencyAudit(
      String agencyName,
      String agencyLevel,
      String agencyServiceType,
      String agencyType,
      String agencyState,
      String operatedBeginDate,
      String operatedEndDate,
      String applyBeginDate,
      String applyEndDate,
      String actionType,
      int page,
      int pageSize) {
    AgencyHistoryDOExample example = new AgencyHistoryDOExample();
    Criteria c = example.createCriteria();
    if (!StringUtils.isEmpty(agencyName)) {
      c.andAgencyNameLike("%" + agencyName + "%");
    }
    if (!StringUtils.isEmpty(agencyLevel)) {
      c.andAgencyLevelEqualTo(Integer.parseInt(agencyLevel));
    }
    // 如果定点服务机构类型不为空
    if (!StringUtils.isEmpty(agencyServiceType)) {
      for (String agencyService : Arrays.asList(agencyServiceType.split(","))) {
        c.andAgencyServiceTypeLike("%" + agencyService + "%");
      }
    }
    // 如果机构类型不为空
    if (!StringUtils.isEmpty(agencyType)) {
      for (String agency : Arrays.asList(agencyType.split(","))) {
        c.andAgencyTypeLike("%" + agency + "%");
      }
    }
    //机构状态
    if (!StringUtils.isEmpty(agencyState)) {
      String[] agencyStateStr = agencyState.split(",");
      List<Integer> agencyStateList = new ArrayList<>();
      for (String agencyState1 : agencyStateStr) {
        agencyStateList.add(Integer.parseInt(agencyState1));
      }
      c.andAgencyStateIn(agencyStateList);
    }

    if (!StringUtils.isEmpty(operatedBeginDate)) {
      c.andOperatedTimeGreaterThanOrEqualTo(DateFormatUtil.getDayFirstTime(operatedBeginDate));
    }
    if (!StringUtils.isEmpty(operatedEndDate)) {
      c.andOperatedTimeLessThanOrEqualTo(DateFormatUtil.getDayLastTime(operatedEndDate));
    }
    if (!StringUtils.isEmpty(applyBeginDate)) {
      c.andAgencyApplyDateGreaterThanOrEqualTo(DateFormatUtil.getDayFirstTime(applyBeginDate));
    }
    if (!StringUtils.isEmpty(applyEndDate)) {
      c.andAgencyApplyDateLessThanOrEqualTo(DateFormatUtil.getDayLastTime(applyEndDate));
    }
    c.andActionTypeEqualTo(actionType);

    int count = agencyHistoryDAO.countByExample(example);

    int pageIndex = (page - 1) * pageSize;
    int totalPage = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;

    example.setOrderByClause(" created_time asc  limit " + pageIndex + " , " + pageSize + " ");
    List<AgencyHistoryDO> agencyHistoryDOList = agencyHistoryDAO.selectByExample(example);

    Map<String, Object> model = new HashMap<>();
    model.put("page", page);
    model.put("pageSize", pageSize);
    model.put("totalDataNum", count);
    model.put("totalPageNum", totalPage);
    model.put("agencyHistoryDOList", agencyHistoryDOList);
    return model;
  }

  @Override
  public IGenericDAO<AgencyHistoryDO, String> getDao() {
    return null;
  }

  @Override
  public Map<String, Object> listAgency(
      String agencyName, String agencyType, String agencyCode, int page, int pageSize) {
    AgencyDOExample example = new AgencyDOExample();
    com.taikang.dic.ltci.model.AgencyDOExample.Criteria c = example.createCriteria();
    //机构名称
    if (!StringUtils.isEmpty(agencyName)) {
      c.andAgencyNameLike("%" + agencyName + "%");
    }
    // 如果机构类型不为空
    if (!StringUtils.isEmpty(agencyType)) {
      //      c.andAgencyTypeEqualTo(agencyType);
      c.andAgencyTypeLike("%" + agencyType + "%");
    }
    // 机构编号（经办）
    if (!StringUtils.isEmpty(agencyCode)) {
      c.andAgencyCodeEqualTo(agencyCode);
    }
    //有效状态
    c.andIsValidEqualTo(IsValidEnum.NO_DELETE.getValue());
    int count = agencyDAO.countByExample(example);

    int pageIndex = (page - 1) * pageSize;
    int totalPage = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;

    example.setOrderByClause(" created_time asc  limit " + pageIndex + " , " + pageSize + " ");
    List<AgencyDO> agencyDOList = agencyDAO.selectByExample(example);

    Map<String, Object> model = new HashMap<>();
    model.put("page", page);
    model.put("pageSize", pageSize);
    model.put("totalDataNum", count);
    model.put("totalPageNum", totalPage);
    model.put("agencyDOList", agencyDOList);
    return model;
  }

  @Override
  public ResultDTO getAgencyDetail(String serialNum) {
    //先获取修改后的
    AgencyHistoryDOExample example = new AgencyHistoryDOExample();
    Criteria c = example.createCriteria();
    c.andSerialNumEqualTo(serialNum);

    List<AgencyHistoryDO> agencyHistoryList = agencyHistoryDAO.selectByExample(example);
    AgencyHistoryDO agencyHistoryDO = new AgencyHistoryDO();
    if (!agencyHistoryList.isEmpty()) {
      agencyHistoryDO = agencyHistoryList.get(0);
    } else {
      throw new NotFoundByIdException("未查询到变更数据");
    }

    //在获取修改前的记录
    AgencyDOExample example1 = new AgencyDOExample();
    com.taikang.dic.ltci.model.AgencyDOExample.Criteria cc = example1.createCriteria();
    cc.andAgencyCodeEqualTo(agencyHistoryDO.getAgencyCode());
    List<AgencyDO> list1 = agencyDAO.selectByExample(example1);

    AgencyDO agencyDO = new AgencyDO();
    if (!list1.isEmpty()) {
      agencyDO = list1.get(0);
    } else {
      throw new NotFoundByIdException("未查询到原有的数据");
    }

    StaffRankDOExample example2 = new StaffRankDOExample();
    com.taikang.dic.ltci.model.StaffRankDOExample.Criteria ccc = example2.createCriteria();
    ccc.andAgencyCodeEqualTo(agencyHistoryDO.getAgencyCode())
        .andIsValidEqualTo(IsValid.VALID.getValue());
    List<StaffRankDO> list2 = staffRankDAO.selectByExample(example2);

    AgencyDetailDTO agencyDetailDTO = new AgencyDetailDTO();
    if (!list2.isEmpty()) {
      for (StaffRankDO staffRank : list2) {
        if (staffRank.getProfessionType() == 1) {
          agencyDetailDTO.setAdvancedDoctorNum(staffRank.getAdvanced());
          agencyDetailDTO.setIntermediateDoctorNum(staffRank.getIntermediate());
          agencyDetailDTO.setPrimaryDoctorNum(staffRank.getElementary());
        }
      }
      for (StaffRankDO staffRank2 : list2) {
        if (staffRank2.getProfessionType() == 2) {
          agencyDetailDTO.setAdvancedNurseNum(staffRank2.getAdvanced());
          agencyDetailDTO.setIntermediateNurseNum(staffRank2.getIntermediate());
          agencyDetailDTO.setPrimaryNurseNum(staffRank2.getElementary());
        }
      }
      for (StaffRankDO staffRank3 : list2) {
        if (staffRank3.getProfessionType() == 3) {
          agencyDetailDTO.setAdvancedCarerNum(staffRank3.getAdvanced());
          agencyDetailDTO.setIntermediateCarerNum(staffRank3.getIntermediate());
          agencyDetailDTO.setPrimaryCarerNum(staffRank3.getElementary());
        }
      }
      for (StaffRankDO staffRank4 : list2) {
        if (staffRank4.getProfessionType() == 4) {
          agencyDetailDTO.setAdvancedMiscNum(staffRank4.getAdvanced());
          agencyDetailDTO.setIntermediateMiscNum(staffRank4.getIntermediate());
          agencyDetailDTO.setPrimaryMiscNum(staffRank4.getElementary());
        }
      }
    }

    AgencyDetailDTO agencyComparedBefore = new AgencyDetailDTO();
    AgencyDetailDTO agencyComparedAfter = new AgencyDetailDTO();

    BeanUtils.copyProperties(agencyHistoryDO, agencyComparedAfter);
    BeanUtils.copyProperties(agencyDO, agencyDetailDTO);
    BeanUtils.copyProperties(agencyDetailDTO, agencyComparedBefore);
    List<StaffDiffDO> staffDiffDOs = null;

    try {
      staffDiffDOs = convert(agencyComparedBefore, agencyComparedAfter);
    } catch (Exception e) {
      logger.error("转换出现错误", e);
    }
    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setDatas(staffDiffDOs);
    resultDTO.setStatus(200);
    resultDTO.setMessage("查询成功");

    return resultDTO;
  }

  private List<com.taikang.dic.ltci.model.StaffDiffDO> convert(
      Object agencyComparedBefore, Object agencyComparedAfter)
      throws IllegalArgumentException, IllegalAccessException {
    List<StaffDiffDO> staffDiffDOs = new ArrayList<StaffDiffDO>();
    Field[] fieldBefores = agencyComparedBefore.getClass().getDeclaredFields();
    Field[] fieldAfters = agencyComparedAfter.getClass().getDeclaredFields();
    for (Field fieldBefore : fieldBefores) {
      for (Field fieldAfter : fieldAfters) {
        if (fieldAfter.getName().equals(fieldBefore.getName())) {
          StaffDiffDO staffDiffDO = new StaffDiffDO();
          staffDiffDO.setKey(fieldAfter.getName());
          fieldAfter.setAccessible(true);
          fieldBefore.setAccessible(true);

          if (fieldAfter.get(agencyComparedBefore) != null) {
            staffDiffDO.setOldValue(fieldAfter.get(agencyComparedBefore).toString());
          } else {
            staffDiffDO.setOldValue("");
          }
          if (fieldBefore.get(agencyComparedAfter) != null) {
            staffDiffDO.setNewValue(fieldBefore.get(agencyComparedAfter).toString());
          } else {
            staffDiffDO.setNewValue("");
          }
          staffDiffDOs.add(staffDiffDO);
        }
      }
    }
    return staffDiffDOs;
  }

  @Override
  public List<AgencyDO> getKeyTime(String serialNum) {
    AgencyHistoryDO agencyHistoryDO = agencyHistoryDAO.selectByPrimaryKey(serialNum);
    AgencyDOExample example = new AgencyDOExample();
    com.taikang.dic.ltci.model.AgencyDOExample.Criteria c = example.createCriteria();
    //机构编码
    if (!StringUtils.isEmpty(agencyHistoryDO.getAgencyCode())) {
      c.andAgencyCodeEqualTo(agencyHistoryDO.getAgencyCode());
    }
    //创建时间
    if (!StringUtils.isEmpty(agencyHistoryDO.getOperatedTime().toString())) {
      c.andCreatedTimeEqualTo(agencyHistoryDO.getOperatedTime());
    }
    List<AgencyDO> agencyDOList = agencyDAO.selectByExample(example);
    return agencyDOList;
  }
}
