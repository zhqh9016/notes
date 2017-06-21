package com.taikang.dic.ltci.system.service;

import com.taikang.dic.ltci.portal.api.model.OrganizationDTO;
import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;

public interface IOrganizationService {

  PageResultDTO listOrganization(OrganizationDTO organization, Integer page, Integer pageSize);

  ResultDTO getByName(String name);

  ResultDTO getByCode(String code);

  ResultDTO selectById(String id);

  ResultDTO deleteById(String id, String operatedBy);

  ResultDTO addOrganization(OrganizationDTO organization);

  ResultDTO updateOrganization(String id, OrganizationDTO organization);

  String getAreaCode(OrganizationDTO organizationDTO);
}
