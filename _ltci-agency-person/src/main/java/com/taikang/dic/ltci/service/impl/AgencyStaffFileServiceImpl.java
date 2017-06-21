package com.taikang.dic.ltci.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taikang.dic.ltci.dao.AgencyStaffFileRDAO;
import com.taikang.dic.ltci.model.AgencyStaffFileRDO;
import com.taikang.dic.ltci.model.AgencyStaffFileRDOExample;
import com.taikang.dic.ltci.model.AgencyStaffFileRDOExample.Criteria;
import com.taikang.dic.ltci.model.BaseModel;
import com.taikang.dic.ltci.service.IAgencyStaffFileService;

@Service
public class AgencyStaffFileServiceImpl implements IAgencyStaffFileService {

  @Autowired private AgencyStaffFileRDAO fileDao;

  @Override
  public List<AgencyStaffFileRDO> getAgencyStaffFileById(String id, Integer type) {
    AgencyStaffFileRDOExample example = new AgencyStaffFileRDOExample();
    Criteria c = example.createCriteria();
    c.andHistoryIdEqualTo(id);
    c.andObjTypeEqualTo(type);
    c.andIsValidEqualTo(BaseModel.IsValid.VALID.getValue());
    return fileDao.selectByExample(example);
  }

  @Override
  public List<AgencyStaffFileRDO> getAgencyStaffFile(String code, Integer type) {
    AgencyStaffFileRDOExample example = new AgencyStaffFileRDOExample();
    Criteria c = example.createCriteria();
    c.andCodeEqualTo(code);
    c.andObjTypeEqualTo(type);
    c.andIsValidEqualTo(BaseModel.IsValid.VALID.getValue());
    return fileDao.selectByExample(example);
  }

  /**
   * 将附件有效状态修改为无效
   *
   * @param file
   * @return
   */
  @Override
  public int updateAgencyStaffFileToIsValid(String code) {
    AgencyStaffFileRDO file = new AgencyStaffFileRDO();
    file.setCode(code);
    file.setIsValid(BaseModel.IsValid.INVALID.getValue());
    AgencyStaffFileRDOExample example = new AgencyStaffFileRDOExample();
    Criteria c = example.createCriteria();
    c.andCodeEqualTo(code).andIsValidEqualTo(BaseModel.IsValid.VALID.getValue());
    return fileDao.updateByExampleSelective(file, example);
  }

  /**
   * 根据历史表id修改附件为无效
   *
   * @param historyId
   * @return
   */
  @Override
  public int updateAgencyStaffFileToIsValidByHisId(String historyId) {
    AgencyStaffFileRDO file = new AgencyStaffFileRDO();
    file.setHistoryId(historyId);
    file.setIsValid(BaseModel.IsValid.INVALID.getValue());
    AgencyStaffFileRDOExample example = new AgencyStaffFileRDOExample();
    Criteria c = example.createCriteria();
    c.andHistoryIdEqualTo(historyId).andIsValidEqualTo(BaseModel.IsValid.VALID.getValue());
    return fileDao.updateByExampleSelective(file, example);
  }

  @Override
  public void insertAgencyStaffFile(AgencyStaffFileRDO agencyStaffFileRDO) {
    fileDao.insertSelective(agencyStaffFileRDO);
  }
}
