package com.taikang.dic.ltci.system.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.common.log.LogConstant;
import com.taikang.dic.ltci.system.serverClient.AreaServerClient;
import com.taikang.dic.ltci.system.service.IAreaService;

@Service
public class AreaServiceImpl implements IAreaService {
  @Autowired private AreaServerClient areaServerClient;
  private static final Logger logger = LoggerFactory.getLogger(AreaServiceImpl.class);

  @Override
  public PageResultDTO getByParentid(String parentid, Integer page, Integer pageSize) {
    logger.info("====AreaServiceImpl层：进入getByParentid方法开始  parentid: " + parentid + "========");
    PageResultDTO result =
        areaServerClient.getByParentId(parentid, page, pageSize, LogConstant.LOG.getLocalCode());
    logger.info("====AreaServiceImpl层：进入getByParentid方法结束========");
    return result;
  }

  @Override
  public ResultDTO getById(String id) {
    logger.info("====AreaServiceImpl层：进入getById方法开始  id: " + id + "========");
    ResultDTO resultDTO = areaServerClient.getById(id, LogConstant.LOG.getLocalCode());
    logger.info("====AreaServiceImpl层：进入getById方法结束========");
    return resultDTO;
  }
}
