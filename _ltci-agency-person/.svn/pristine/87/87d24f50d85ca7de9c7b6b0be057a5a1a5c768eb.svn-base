package com.taikang.dic.ltci.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taikang.dic.ltci.dao.AgencyDAO;
import com.taikang.dic.ltci.model.AgencyDO;
import com.taikang.dic.ltci.model.AgencyDOExample;
import com.taikang.dic.ltci.model.AgencyDOExample.Criteria;
import com.taikang.dic.ltci.model.BaseModel;
import com.taikang.dic.ltci.service.IAgencyService;

@Service
public class AgencyServiceImpl implements IAgencyService {

  @Autowired private AgencyDAO agencyDao;

  @Override
  public List<AgencyDO> getAgencyByOrgCode(String orgCode) {
    AgencyDOExample example = new AgencyDOExample();
    Criteria c = example.createCriteria();
    c.andOrgCodeEqualTo(orgCode);
    c.andIsValidEqualTo(BaseModel.IsValid.VALID.getValue());
    return agencyDao.selectByExample(example);
  }

  @Override
  public List<AgencyDO> getAgencyByAgencyCode(String agencyCode, String orgCode) {
    AgencyDOExample example = new AgencyDOExample();
    example.createCriteria().andAgencyCodeEqualTo(agencyCode).andOrgCodeNotEqualTo(orgCode);
    return agencyDao.selectByExample(example);
  }
}
