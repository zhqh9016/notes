package com.taikang.dic.ltci.quality.control.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.quality.control.service.IPatrolResultService;
import com.taikang.dic.ltci.quality.control.serviceClient.PatrolResultServiceClient;

@Service
public class PatrolResultServiceImpl implements IPatrolResultService {

  @Autowired private PatrolResultServiceClient patrolResultServiceClient;

  @Override
  public ResultDTO updateAuditState(String patrolTaskId, int auditState, String rejectionReason) {

    return patrolResultServiceClient.updateAuditState(patrolTaskId, auditState, rejectionReason);
  }
}
