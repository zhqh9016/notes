package com.taikang.dic.ltci.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.common.exception.NotFoundByIdException;
import com.taikang.dic.ltci.dao.MobileDAO;
import com.taikang.dic.ltci.model.MobileComplaintDO;
import com.taikang.dic.ltci.model.MobileComplaintListDO;
import com.taikang.dic.ltci.model.MobileResourceDO;
import com.taikang.dic.ltci.model.PatrolStaffListDO;
import com.taikang.dic.ltci.service.MobileService;

@Service
public class MobileServiceImpl implements MobileService {
  @Autowired private MobileDAO mobileDAO;
  private Logger logger = LoggerFactory.getLogger(MobileServiceImpl.class);

  @Override
  public ResultDTO getPatrolTaskList(String idCard) {
    List<MobileComplaintListDO> patrolTaskList = mobileDAO.getPatrolTaskList(idCard);

    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setDatas(patrolTaskList);
    resultDTO.setStatus(StatusCodeEnum.OK.getValue());
    resultDTO.setMessage("查询成功");

    return resultDTO;
  }

  @Override
  public ResultDTO getPatrolTask(String patrolTaskId) {
    List<MobileResourceDO> mobileResource = mobileDAO.getMobileResource(patrolTaskId);
    MobileComplaintListDO mobileComplaintListDO = mobileDAO.getPatrolTask(patrolTaskId);
    if (mobileComplaintListDO == null) {
      throw new NotFoundByIdException("未查询到相关数据");
    }

    MobileComplaintDO mobileComplaintDO = new MobileComplaintDO();
    BeanUtils.copyProperties(mobileComplaintListDO, mobileComplaintDO);
    if (!mobileResource.isEmpty()) {
      mobileComplaintDO.setMobileResource(mobileResource);
    }
    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setDatas(mobileComplaintDO);
    resultDTO.setMessage("查询成功");
    resultDTO.setStatus(StatusCodeEnum.OK.getValue());

    return resultDTO;
  }

  @Override
  public ResultDTO getTodoPatrolTask(String patrolStaffId, List<String> taskStatus) {

    List<PatrolStaffListDO> patrolStaffLisDO =
        mobileDAO.getTodoPatrolTask(patrolStaffId, taskStatus);
    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setDatas(patrolStaffLisDO);
    resultDTO.setMessage("查询成功");
    resultDTO.setNumber(patrolStaffLisDO.size());
    resultDTO.setStatus(StatusCodeEnum.OK.getValue());
    return resultDTO;
  }
}
