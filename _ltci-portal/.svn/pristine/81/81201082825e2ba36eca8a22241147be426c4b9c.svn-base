package com.taikang.dic.ltci.quality.control.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.portal.api.model.AttachmentDTO;
import com.taikang.dic.ltci.portal.api.model.OrganizationDTO;
import com.taikang.dic.ltci.portal.api.model.ReconsiderDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.api.model.UserDTO;
import com.taikang.dic.ltci.portal.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.portal.common.util.Encodes;
import com.taikang.dic.ltci.portal.common.util.UserUtils;
import com.taikang.dic.ltci.portal.serverClient.AttachmentServiceClient;
import com.taikang.dic.ltci.quality.control.service.IReconsiderService;
import com.taikang.dic.ltci.quality.control.serviceClient.ReconsiderServiceClient;
import com.taikang.dic.ltci.treatment.application.common.ThrowsException;

@Service
public class ReconsiderServiceImpl implements IReconsiderService {

  @Autowired private ReconsiderServiceClient reconsiderClient;
  @Autowired private AttachmentServiceClient attachmentServiceClient;
  private Logger log = LoggerFactory.getLogger(ReconsiderServiceImpl.class);

  @Value("${systemCharset}")
  private String systemCharset;

  @Override
  public ResultDTO getReconsiderListByPatrolTaskId(String patrolTaskId) {
    log.info("=========Service层 getReconsiderListByPatrolTaskId========");
    log.info("=========patrolTaskId为: " + patrolTaskId);
    return reconsiderClient.getReconsiderListByPatrolTaskId(patrolTaskId);
  }

  @Override
  public ResultDTO saveReconsider(ReconsiderDTO reconsider) {

    log.info("=========Service层 saveReconsider========");
    log.info("=========回复信息为: " + reconsider);
    //获取经办人信息
    UserDTO currentUser = UserUtils.getCurrentUser();
    if (currentUser != null) {

      String userName = currentUser.getUserName();
      String telephone = currentUser.getTelephone();

      reconsider.setOperatedBy(userName);
      reconsider.setReplyPhone(telephone);
      reconsider.setReplyPerson(currentUser.getTrueName());

      OrganizationDTO department = currentUser.getDepartment();
      if (department != null) {
        String name = department.getName();
        reconsider.setOperatedOrg(name);
      }
    }
    return reconsiderClient.saveReconsider(reconsider);
  }

  @Override
  public byte[] getReconsiderFile(String fileId, String fileType) {
    ResultDTO resultDTO = attachmentServiceClient.getAttachmentByID(fileId, fileType);
    if (resultDTO == null || !StatusCodeEnum.OK.getValue().equals(resultDTO.getStatus())) {
      throw new ThrowsException("根据id:" + fileId + " 和fileType:" + fileType + " 查询媒体文件微服务出错");
    }
    AttachmentDTO dto =
        JSONObject.parseObject(JSONObject.toJSONString(resultDTO.getDatas()), AttachmentDTO.class);
    return Encodes.decodeBase64(dto.getContent());
  }
}
