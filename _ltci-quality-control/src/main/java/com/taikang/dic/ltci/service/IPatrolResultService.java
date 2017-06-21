package com.taikang.dic.ltci.service;

public interface IPatrolResultService {

  public int putPatrolResult(String patrolTaskId);

  public boolean updateAuditState(String patrolTaskId, int auditState, String rejectionReason)
      throws ServiceException;
}
