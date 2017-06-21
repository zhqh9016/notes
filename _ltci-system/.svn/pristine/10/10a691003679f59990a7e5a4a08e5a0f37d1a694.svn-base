package com.taikang.dic.ltci.service;

import com.taikang.dic.ltci.model.OrganizationDO;
import com.taikang.dic.ltci.api.model.OrganizationDTO;
import com.taikang.dic.ltci.api.model.PageResultDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;

public interface IOrganizationService extends GenericService<OrganizationDO, String> {

  PageResultDTO listOrganization(OrganizationDTO organization, int page, int pageSize);

  ResultDTO selectByName(String name);

  ResultDTO selectByCode(String code);

  ResultDTO selectById(String id);

  int update(OrganizationDTO organization);

  ResultDTO delete(OrganizationDTO organiation);

  //新增组织机构
  ResultDTO insertSelective(OrganizationDTO organiation);

  ResultDTO getBySocOrgCode(String socOrgCode);
}
