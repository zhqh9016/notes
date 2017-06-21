package com.taikang.dic.ltci.service;

import com.taikang.dic.ltci.model.StaffAuditHistoryDO;

public interface IStaffAuditHistoryService extends GenericService<StaffAuditHistoryDO, String> {

  boolean createStaffAuditHistory(StaffAuditHistoryDO auditHisDo) throws ServiceException;
}
