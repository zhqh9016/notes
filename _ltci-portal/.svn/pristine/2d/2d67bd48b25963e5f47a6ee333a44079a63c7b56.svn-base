package com.taikang.dic.ltci.system.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.portal.api.model.OrganizationDTO;
import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.api.model.UserDTO;
import com.taikang.dic.ltci.portal.common.log.LogConstant;
import com.taikang.dic.ltci.portal.common.util.UserUtils;
import com.taikang.dic.ltci.system.serverClient.OrganizationServerClient;
import com.taikang.dic.ltci.system.service.IOrganizationService;
import com.taikang.dic.ltci.treatment.application.common.ParametersIsNullException;
/** @author itw_muwg */
@Service
public class OrganizationServiceImpl implements IOrganizationService {

  private final Logger LOG = LoggerFactory.getLogger(OrganizationServiceImpl.class);

  @Autowired private OrganizationServerClient organizationServerClient;

  /** 根据条件分页查询机构部门 */
  @Override
  public PageResultDTO listOrganization(
      OrganizationDTO organization, Integer page, Integer pageSize) {
    LOG.info("===service层 listOrganization方法");
    return organizationServerClient.listOrganization(
        organization, page, pageSize, LogConstant.LOG.getLocalCode());
  }

  /** 根据名称精确查询机构部门 */
  @Override
  public ResultDTO getByName(String name) {
    LOG.info("===service层 getByName方法");
    return organizationServerClient.getByName(name, LogConstant.LOG.getLocalCode());
  }

  /** 根据机构编码精确查询机构部门 */
  @Override
  public ResultDTO getByCode(String code) {
    LOG.info("===service层 getByCode方法");
    return organizationServerClient.getByCode(code, LogConstant.LOG.getLocalCode());
  }

  /** 根据机构ID精确查询机构部门 */
  @Override
  public ResultDTO selectById(String id) {
    LOG.info("===service层 selectById方法");
    return organizationServerClient.selectById(id, LogConstant.LOG.getLocalCode());
  }

  @Override
  public ResultDTO deleteById(String id, String operatedBy) {
    LOG.info("===service层 deleteById方法");
    return organizationServerClient.deleteById(id, operatedBy);
  }

  @Override
  public ResultDTO updateOrganization(String id, OrganizationDTO organization) {
    LOG.info("===service层 updateOrganization方法");
    UserDTO user = UserUtils.getCurrentUser();
    if (user != null) {
      organization.setOperatedBy(user.getTrueName());
    }
    return organizationServerClient.updateOrganization(id, organization);
  }

  @Override
  public ResultDTO addOrganization(OrganizationDTO organization) {
    LOG.info("===service层 addOrganization方法");
    if (StringUtils.isBlank(organization.getCode())
        || StringUtils.isBlank(organization.getName())) {
      throw new ParametersIsNullException("请求参数不能为空！");
    }
    UserDTO user = UserUtils.getCurrentUser();
    if (user != null) {
      organization.setCreatedBy(user.getTrueName());
    }
    return organizationServerClient.addOrganization(organization);
  }

  /** 获取组织最低级别区域编码 */
  @Override
  public String getAreaCode(OrganizationDTO organizationDTO) {
    Integer isOrg = organizationDTO.getIsOrg();
    //如果当前组织是机构,那么直接获取机构的区域信息
    if (isOrg != null && 1 == isOrg) {
      String code = getLowestArea(organizationDTO);
      return code;
    }
    if (isOrg != null && 2 == isOrg) {
      String parentid = organizationDTO.getParentid();
      ResultDTO selectById =
          organizationServerClient.selectById(parentid, LogConstant.LOG.getLocalCode());
      Object datas = selectById.getDatas();
      String jsonString = JSONObject.toJSONString(datas);
      OrganizationDTO parseObject = JSONObject.parseObject(jsonString, OrganizationDTO.class);
      return getAreaCode(parseObject);
    }
    return null;
  }

  //获取机构的最低区域编码,有的机构属于省,有的机构属于市,有的机构属于区县
  private String getLowestArea(OrganizationDTO organizationDTO) {
    if (StringUtils.isNotBlank(organizationDTO.getCountyid())) {
      return organizationDTO.getCountyid();
    }
    if (StringUtils.isNotBlank(organizationDTO.getCityid())) {
      return organizationDTO.getCityid();
    }
    if (StringUtils.isNotBlank(organizationDTO.getProvinceid())) {
      return organizationDTO.getProvinceid();
    }
    return null;
  }
}
