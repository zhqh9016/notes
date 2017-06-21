package com.taikang.dic.ltci.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.taikang.dic.ltci.api.model.ResDTO;
import com.taikang.dic.ltci.common.InsertRepeatException;
import com.taikang.dic.ltci.dao.CustomResDAO;
import com.taikang.dic.ltci.dao.IGenericDAO;
import com.taikang.dic.ltci.dao.RRoleResDAO;
import com.taikang.dic.ltci.dao.ResDAO;
import com.taikang.dic.ltci.model.BaseModel;
import com.taikang.dic.ltci.model.CustomResDO;
import com.taikang.dic.ltci.model.RRoleResDO;
import com.taikang.dic.ltci.model.RRoleResDOExample;
import com.taikang.dic.ltci.model.ResDO;
import com.taikang.dic.ltci.model.ResDOExample;
import com.taikang.dic.ltci.model.ResDOExample.Criteria;
import com.taikang.dic.ltci.service.AbstractGenericService;
import com.taikang.dic.ltci.service.IResService;

/**
 * 资源信息UserService
 *
 * @author itw_huodd 2017-03-31
 */
@Service
public class ResServiceImpl extends AbstractGenericService<ResDO, String> implements IResService {

  private static final Logger logger = LoggerFactory.getLogger(ResServiceImpl.class);

  @Autowired ResDAO resDOMapper;
  @Autowired CustomResDAO cusResDao;
  @Autowired RRoleResDAO roleResDao;

  public boolean createRes(ResDO resDO) {
    resDO.setId(UUID.randomUUID().toString().replace("-", ""));
    resDO.setCreateTime(new Date());
    resDO.setIsValid(BaseModel.IsValid.VALID.getValue());
    int i = resDOMapper.insertSelective(resDO);
    if (i <= 0) {
      return false;
    }
    return true;
  }

  public ResDTO getResById(String id) {
    ResDO resDO = resDOMapper.selectByPrimaryKey(id);
    if (resDO == null) return null;
    ResDTO resDTO = new ResDTO();
    BeanUtils.copyProperties(resDO, resDTO);
    return resDTO;
  }

  @Override
  public List<ResDTO> getResByUserId(String userId) {
    List<ResDTO> result = new ArrayList<>();
    List<CustomResDO> selectResByUserId = cusResDao.selectResByUserId(userId);
    if (!CollectionUtils.isEmpty(selectResByUserId)) {
      String jsonString = JSONArray.toJSONString(selectResByUserId);
      result = JSONArray.parseArray(jsonString, ResDTO.class);
    }
    return result;
  }

  public boolean updateResById(String id, ResDO resDO) {
    resDO.setId(id);
    resDO.setUpdateTime(new Date());
    int i = resDOMapper.updateByPrimaryKeySelective(resDO);
    if (i <= 0) {
      return false;
    }
    return true;
  }

  public boolean removeById(String id, ResDO resDO) {
    // 判断菜单是否有下级目录
    if (IsHasSubRes(id)) {
      throw new InsertRepeatException("该菜单有下级目录，不能删除");
    }
    // 判断菜单是否关联角色
    RRoleResDOExample roleResExample = new RRoleResDOExample();
    roleResExample.createCriteria().andResIdEqualTo(id);
    List<RRoleResDO> roleResList = roleResDao.selectByExample(roleResExample);
    if (roleResList != null && roleResList.size() > 0) {
      throw new InsertRepeatException("该菜单关联角色，不能删除");
    }
    resDO.setId(id);
    resDO.setUpdateTime(new Date());
    resDO.setIsValid(BaseModel.IsValid.INVALID.getValue());
    int i = resDOMapper.updateByPrimaryKeySelective(resDO);
    if (i <= 0) {
      return false;
    }
    return true;
  }

  public Map<String, Object> getListResByParentId(String parentId, int page, int pageSize) {
    ResDOExample example = new ResDOExample();
    Criteria c = example.createCriteria();
    if (!StringUtils.isEmpty(parentId)) {
      c.andParentIdEqualTo(parentId);
    }
    // 删除标识
    c.andIsValidEqualTo(BaseModel.IsValid.VALID.getValue());
    int count = resDOMapper.countByExample(example);

    int pageIndex = (page - 1) * pageSize;
    int totalPage = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;

    example.setOrderByClause(" sequence*1 desc  limit " + pageIndex + " , " + pageSize + " ");
    List<ResDO> resDoList = resDOMapper.selectByExample(example);

    Map<String, Object> model = new HashMap<String, Object>();
    model.put("page", page);
    model.put("pageSize", pageSize);
    model.put("totalDataNum", count);
    model.put("totalPageNum", totalPage);
    model.put("resDoList", resDoList);
    return model;
  }

  /**
   * 是否有下级资源
   *
   * @param id
   * @return
   */
  public boolean IsHasSubRes(String id) {
    ResDOExample example = new ResDOExample();
    Criteria c = example.createCriteria();
    c.andIsValidEqualTo(BaseModel.IsValid.VALID.getValue()).andParentIdEqualTo(id);
    List<ResDO> resDoList = resDOMapper.selectByExample(example);
    if (resDoList != null && resDoList.size() > 0) {
      return true;
    }
    return false;
  }

  @Override
  public IGenericDAO<ResDO, String> getDao() {

    return null;
  }

  /** 获取所有有效的菜单信息以及菜单对应的角色信息 */
  @Override
  public List<CustomResDO> getAllResWithRoles() {
    List<CustomResDO> selectResValid = cusResDao.selectResValid();
    return selectResValid;
  }
}
