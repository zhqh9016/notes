package com.taikang.dic.ltci.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.system.serverClient.ResServerClient;
import com.taikang.dic.ltci.system.service.ResService;

/**
 * 资源service
 *
 * @author itw_huodd 2017-04-01
 */
@Service
public class ResServerImpl implements ResService {
  @Autowired ResServerClient resServerClient;

  public PageResultDTO listRes(String parentId, int page, int pageSize) {
    return resServerClient.listRes(parentId, page, pageSize);
  }

  public ResultDTO createRes(ResDTO resDto) {
    return resServerClient.createRes(resDto);
  }

  public ResultDTO updateRes(String id, ResDTO resDto) {
    return resServerClient.updateRes(id, resDto);
  }

  public ResultDTO delRes(String id, ResDTO resDto) {
    return resServerClient.delRes(id, resDto);
  }

  @Override
  public ResultDTO getAllResAndRoles() {

    return resServerClient.getAllResAndRoles();
  }
}
