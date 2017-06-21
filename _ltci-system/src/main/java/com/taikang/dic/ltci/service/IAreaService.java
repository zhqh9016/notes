package com.taikang.dic.ltci.service;

import com.taikang.dic.ltci.api.model.PageResultDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;

public interface IAreaService {

  PageResultDTO getByParentid(String parentid, Integer page, Integer pageSize);

  ResultDTO getById(String id);
}
