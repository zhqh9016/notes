package com.taikang.dic.ltci.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.taikang.dic.ltci.dao.AgencyDAO;
import com.taikang.dic.ltci.dao.StaffRankDAO;
import com.taikang.dic.ltci.model.AgencyDO;
import com.taikang.dic.ltci.model.AgencyDOExample;
import com.taikang.dic.ltci.model.AgencyDOExample.Criteria;
import com.taikang.dic.ltci.model.BaseModel;
import com.taikang.dic.ltci.model.StaffRankDO;
import com.taikang.dic.ltci.model.BaseModel.IsValid;
import com.taikang.dic.ltci.model.StaffRankDOExample;
import com.taikang.dic.ltci.service.IAgencyStaffFileService;
import com.taikang.dic.ltci.service.IScheduleService;

@Service
public class ScheduleServiceImpl implements IScheduleService {

  @Autowired AgencyDAO agencyDao;

  @Autowired IAgencyStaffFileService fileService;

  @Autowired StaffRankDAO staffRankDao;

  /** 每天零点触发任务，根据条件更新机构有效状态 */
  @Scheduled(cron = "${agencyValidTiming}")
  public void updateAgencyInfo() {
    // 条件
    AgencyDOExample example = new AgencyDOExample();
    Criteria c = example.createCriteria();
    c.andKeyEndDateLessThan(new Date());
    c.andIsValidEqualTo(BaseModel.IsValid.VALID.getValue());
    List<AgencyDO> agencyList = agencyDao.selectByExample(example);
    for (AgencyDO agency : agencyList) {
      fileService.updateAgencyStaffFileToIsValid(agency.getAgencyCode());
      // 更新人员职级表
      StaffRankDOExample staffRankExample = new StaffRankDOExample();
      staffRankExample
          .createCriteria()
          .andAgencyCodeEqualTo(agency.getAgencyCode())
          .andIsValidEqualTo(IsValid.VALID.getValue());
      StaffRankDO staffRankDo = new StaffRankDO();
      staffRankDo.setIsValid(IsValid.INVALID.getValue());
      staffRankDao.updateByExampleSelective(staffRankDo, staffRankExample);
    }
    // 修改内容
    AgencyDO agencyDo = new AgencyDO();
    agencyDo.setIsValid(BaseModel.IsValid.INVALID.getValue());
    agencyDao.updateByExampleSelective(agencyDo, example);
  }
}
