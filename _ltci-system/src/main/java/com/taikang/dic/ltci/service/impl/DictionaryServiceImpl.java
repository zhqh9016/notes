package com.taikang.dic.ltci.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.taikang.dic.ltci.api.model.DictionaryDTO;
import com.taikang.dic.ltci.api.model.PageResultDTO;
import com.taikang.dic.ltci.common.ConstantUtil;
import com.taikang.dic.ltci.common.InsertRepeatException;
import com.taikang.dic.ltci.common.NotFoundByIdException;
import com.taikang.dic.ltci.common.enumeration.IsValidEnum;
import com.taikang.dic.ltci.dao.DictionaryDAO;
import com.taikang.dic.ltci.dao.DictionaryOperateDAO;
import com.taikang.dic.ltci.dao.IGenericDAO;
import com.taikang.dic.ltci.model.BaseModel;
import com.taikang.dic.ltci.model.DictionaryDO;
import com.taikang.dic.ltci.model.DictionaryDOExample;
import com.taikang.dic.ltci.model.DictionaryDOExample.Criteria;
import com.taikang.dic.ltci.service.AbstractGenericService;
import com.taikang.dic.ltci.service.DictionaryService;

@Service
public class DictionaryServiceImpl extends AbstractGenericService<DictionaryDO, String>
    implements DictionaryService {

  @Autowired private DictionaryDAO dictionaryDOMapper;

  @Autowired private DictionaryOperateDAO dictionaryOperateDao;

  @Override
  public IGenericDAO<DictionaryDO, String> getDao() {
    return dictionaryDOMapper;
  }

  @Override
  public List<DictionaryDO> getDictionaryDOByCondition(String type, String value) {
    DictionaryDOExample doExample = new DictionaryDOExample();
    Criteria dictionaryCriteria = doExample.createCriteria();
    dictionaryCriteria.andTypeEqualTo(type);
    dictionaryCriteria.andValueEqualTo(value);
    dictionaryCriteria.andIsValidEqualTo(IsValidEnum.NO_DELETE.getValue());
    return dictionaryDOMapper.selectByExample(doExample);
  }

  @Override
  public PageResultDTO getDictionary(
      DictionaryDTO dictionaryDTO, int page, int pageSize, String queryFlag) {

    DictionaryDOExample example = new DictionaryDOExample();
    Criteria c = example.createCriteria();
    if (!StringUtils.isEmpty(dictionaryDTO.getType())) {
      c.andTypeEqualTo(dictionaryDTO.getType());
    }
    if (!StringUtils.isEmpty(dictionaryDTO.getTypeName())) {
      c.andTypeNameLike("%" + dictionaryDTO.getTypeName() + "%");
    }
    if (!StringUtils.isEmpty(dictionaryDTO.getValue())) {
      c.andValueEqualTo(dictionaryDTO.getValue());
    }
    if (!StringUtils.isEmpty(dictionaryDTO.getValueName())) {
      c.andValueNameLike("%" + dictionaryDTO.getValueName() + "%");
    }
    if (ConstantUtil.SELECT_DICTIONARY_FLAG_ONE.equals(queryFlag)) {
      c.andIsValidEqualTo(BaseModel.IsValid.VALID.getValue());
    }

    int count = dictionaryDOMapper.countByExample(example);
    int pageIndex = (page - 1) * pageSize;
    int totalPage = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;

    example.setOrderByClause(
        "is_valid desc, type,value asc  limit " + pageIndex + " , " + pageSize + " ");
    List<DictionaryDO> lists = dictionaryDOMapper.selectByExample(example);

    PageResultDTO pageRet = new PageResultDTO();
    pageRet.setPage(page);
    pageRet.setPageSize(pageSize);
    pageRet.setTotalDataNum(count);
    pageRet.setTotalPageNum(totalPage);
    pageRet.setStatus(200);

    List<Object> listDTOs = new ArrayList<>();

    if (lists != null && !lists.isEmpty()) {
      for (DictionaryDO list : lists) {
        DictionaryDTO dictionary = new DictionaryDTO();
        BeanUtils.copyProperties(list, dictionary);
        listDTOs.add(dictionary);
      }
    }
    pageRet.setDatas(listDTOs);
    return pageRet;
  }

  @Override
  @Transactional
  public void createDictionary(DictionaryDO dictionaryDO) {

    //先进行查询，如果有重复的就无法提交
    DictionaryDOExample example = new DictionaryDOExample();
    Criteria c = example.createCriteria();
    c.andTypeEqualTo(dictionaryDO.getType());
    c.andValueEqualTo(dictionaryDO.getValue());
    List<DictionaryDO> lists = dictionaryDOMapper.selectByExample(example);

    if (!lists.isEmpty()) {
      throw new InsertRepeatException("已经有重复的数据");
    }

    dictionaryDO.setId(UUID.randomUUID().toString().replace("-", ""));
    dictionaryDO.setCreateTime(new Date());
    dictionaryDO.setOperatedTime(new Date());
    dictionaryDO.setIsValid(BaseModel.IsValid.VALID.getValue());
    dictionaryDOMapper.insertSelective(dictionaryDO);
  }

  @Override
  @Transactional
  public void updateDictionary(DictionaryDO dictionaryDO) {
    DictionaryDO dictionaryDB = dictionaryDOMapper.selectByPrimaryKey(dictionaryDO.getId());
    if (dictionaryDB == null) {
      throw new NotFoundByIdException("无法查询到此数据");
    } else {
      dictionaryDB.setType(dictionaryDO.getType());
      dictionaryDB.setTypeName(dictionaryDO.getTypeName());
      dictionaryDB.setValue(dictionaryDO.getValue());
      dictionaryDB.setValueName(dictionaryDO.getValueName());
      dictionaryDB.setOperatedBy(dictionaryDO.getOperatedBy());
      dictionaryDB.setOperatedTime(new Date());
      dictionaryDOMapper.updateByPrimaryKeySelective(dictionaryDB);
    }
  }

  @Override
  @Transactional
  public void deleteDictionary(String id, String operatedBy) {
    DictionaryDO dictionaryDB = dictionaryDOMapper.selectByPrimaryKey(id);
    if (dictionaryDB == null) {
      throw new NotFoundByIdException("无法查询到此数据");
    } else {
      dictionaryDB.setIsValid(BaseModel.IsValid.INVALID.getValue());
      dictionaryDB.setOperatedBy(operatedBy);
      dictionaryDOMapper.updateByPrimaryKeySelective(dictionaryDB);
    }
  }

  @Override
  public void recoverDictionary(String id, String operatedBy) {
    DictionaryDO dictionaryDO = new DictionaryDO();
    dictionaryDO.setId(id);
    dictionaryDO.setOperatedBy(operatedBy);
    dictionaryDO.setIsValid(BaseModel.IsValid.VALID.getValue());
    dictionaryDO.setOperatedTime(new Date());
    dictionaryDOMapper.updateByPrimaryKeySelective(dictionaryDO);
  }

  @Override
  public Date getMaxOperateTime() {
    return dictionaryOperateDao.getMaxOperateTime();
  }
}
