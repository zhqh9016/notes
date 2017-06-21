package com.taikang.dic.ltci.service;

import java.util.List;
import java.util.Map;

import com.taikang.dic.ltci.api.model.ResDTO;
import com.taikang.dic.ltci.model.CustomResDO;
import com.taikang.dic.ltci.model.ResDO;

public interface IResService extends GenericService<ResDO, String> {

  public boolean createRes(ResDO resDO) throws Exception;

  public ResDTO getResById(String id);

  public boolean updateResById(String id, ResDO resDO) throws Exception;

  public boolean removeById(String id, ResDO resDO) throws Exception;

  Map<String, Object> getListResByParentId(String parentId, int page, int pageSize);

  public boolean IsHasSubRes(String id);

  public List<CustomResDO> getAllResWithRoles();

  List<ResDTO> getResByUserId(String userId);
}
