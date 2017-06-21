package com.taikang.dic.ltci.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taikang.dic.ltci.dao.IGenericDAO;
import com.taikang.dic.ltci.dao.StaffAuditHistoryDAO;
import com.taikang.dic.ltci.model.StaffAuditHistoryDO;
import com.taikang.dic.ltci.service.AbstractGenericService;
import com.taikang.dic.ltci.service.IStaffAuditHistoryService;
import com.taikang.dic.ltci.service.ServiceException;

/**
 * 人员审核流水历史
 *
 * @author itw_liuzy 2017-05-10
 */
@Service
public class StaffAuditHistoryServiceImpl
    extends AbstractGenericService<StaffAuditHistoryDO, String>
    implements IStaffAuditHistoryService {

  @Autowired private StaffAuditHistoryDAO auditHisDao;

  @Override
  public IGenericDAO<StaffAuditHistoryDO, String> getDao() {
    return null;
  }

  @Override
  public boolean createStaffAuditHistory(StaffAuditHistoryDO auditHisDo) throws ServiceException {
    int i = auditHisDao.insertSelective(auditHisDo);
    if (i <= 0) {
      throw new ServiceException(500, "添加审核流水信息失败");
    }
    return true;
  }
}
