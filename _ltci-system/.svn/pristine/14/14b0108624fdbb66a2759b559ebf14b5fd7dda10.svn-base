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
import com.taikang.dic.ltci.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.dao.DictionaryDAO;
import com.taikang.dic.ltci.dao.DictionaryOperateDAO;
import com.taikang.dic.ltci.dao.DiseaseDAO;
import com.taikang.dic.ltci.dao.IGenericDAO;
import com.taikang.dic.ltci.model.BaseModel;
import com.taikang.dic.ltci.model.DictionaryDO;
import com.taikang.dic.ltci.model.DictionaryDOExample;
import com.taikang.dic.ltci.model.DictionaryDOExample.Criteria;
import com.taikang.dic.ltci.model.DiseaseDO;
import com.taikang.dic.ltci.model.DiseaseDOExample;
import com.taikang.dic.ltci.model.DiseaseSpecialDO;
import com.taikang.dic.ltci.service.AbstractGenericService;
import com.taikang.dic.ltci.service.DictionaryService;
import com.taikang.dic.ltci.service.DiseaseService;

@Service
public class DiseaseServiceImpl extends AbstractGenericService<DiseaseDO, String>
    implements DiseaseService {

  @Autowired DiseaseDAO diseaseDAO;

  @Override
  public IGenericDAO<DiseaseDO, String> getDao() {
    return diseaseDAO;
  }

  @Override
  public PageResultDTO getDisease(String name, int page, int pageSize) {

    DiseaseDOExample diseaseDOExample = new DiseaseDOExample();
    com.taikang.dic.ltci.model.DiseaseDOExample.Criteria createCriteria =
        diseaseDOExample.createCriteria();

    if (!StringUtils.isEmpty(name)) {
      createCriteria.andNameLike("%" + name + "%");
    }
    int count = diseaseDAO.countByExample(diseaseDOExample);
    int pageIndex = (page - 1) * pageSize;
    int totalPage = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;

    diseaseDOExample.setOrderByClause(" name limit " + pageIndex + " , " + pageSize + " ");
    List<DiseaseDO> lists = diseaseDAO.selectByExample(diseaseDOExample);

    List<DiseaseSpecialDO> listDTOs = new ArrayList<DiseaseSpecialDO>();

    lists.forEach(
        list -> {
          DiseaseSpecialDO diseaseSpecialDO = new DiseaseSpecialDO();
          BeanUtils.copyProperties(list, diseaseSpecialDO);
          diseaseSpecialDO.setShowName(diseaseSpecialDO.getName());
          listDTOs.add(diseaseSpecialDO);
        });
    PageResultDTO pageRet = new PageResultDTO();
    pageRet.setPage(page);
    pageRet.setPageSize(pageSize);
    pageRet.setTotalDataNum(count);
    pageRet.setTotalPageNum(totalPage);
    pageRet.setStatus(StatusCodeEnum.OK.getValue());
    pageRet.setDatas(listDTOs);
    return pageRet;
  }
}
