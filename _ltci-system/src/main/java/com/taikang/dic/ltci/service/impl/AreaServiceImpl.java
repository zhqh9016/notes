package com.taikang.dic.ltci.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taikang.dic.ltci.api.model.AreaDTO;
import com.taikang.dic.ltci.api.model.PageResultDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.util.DateFormatUtil;
import com.taikang.dic.ltci.dao.AreaDAO;
import com.taikang.dic.ltci.dao.IGenericDAO;
import com.taikang.dic.ltci.model.AreaDO;
import com.taikang.dic.ltci.model.AreaDOExample;
import com.taikang.dic.ltci.model.AreaDOExample.Criteria;
import com.taikang.dic.ltci.model.BaseModel;
import com.taikang.dic.ltci.service.AbstractGenericService;
import com.taikang.dic.ltci.service.IAreaService;

@Service
public class AreaServiceImpl extends AbstractGenericService<AreaDO, String>
    implements IAreaService {

  private static final Logger logger = LoggerFactory.getLogger(AreaServiceImpl.class);
  @Autowired private AreaDAO areaDAO;
  /** 根据上级区域id查询下级区域 */
  @Override
  public PageResultDTO getByParentid(String parentid, Integer page, Integer pageSize) {
    logger.info("====AreaServiceImpl层：进入getByParentid方法开始  parentid: " + parentid + "========");
    //构建查询条件
    AreaDOExample example = new AreaDOExample();
    Criteria c = example.createCriteria();
    c.andParentidEqualTo(parentid);
    c.andIsValidEqualTo(BaseModel.IsValid.VALID.getValue());

    int count = areaDAO.countByExample(example);

    int pageIndex = (page - 1) * pageSize;
    int totalPage = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;

    example.setOrderByClause(" sequence desc  limit " + pageIndex + " , " + pageSize + " ");

    List<AreaDO> areaDOList = areaDAO.selectByExample(example);
    PageResultDTO pageRet = new PageResultDTO();
    pageRet.setPage(page);
    pageRet.setPageSize(pageSize);
    pageRet.setTotalDataNum(count);
    pageRet.setTotalPageNum(totalPage);
    // 将查询结果转成DTO
    List<Object> resultDtoList = new ArrayList<>();
    if (areaDOList != null && !areaDOList.isEmpty()) {
      for (AreaDO areaDO : areaDOList) {
        AreaDTO areaDTO = new AreaDTO();
        BeanUtils.copyProperties(areaDO, areaDTO);
        if (areaDO.getCreatedTime() != null) {
          areaDTO.setCreatedTime(DateFormatUtil.dateToTimeStr(areaDO.getCreatedTime()));
        }
        if (areaDO.getOperatedTime() != null) {
          areaDTO.setOperatedTime(DateFormatUtil.dateToTimeStr(areaDO.getOperatedTime()));
        }
        resultDtoList.add(areaDTO);
      }
    }
    pageRet.setDatas(resultDtoList);
    logger.info("====AreaServiceImpl层：进入getByParentid方法结束========");
    return pageRet;
  }
  /** 根据id查询区域 */
  @Override
  public ResultDTO getById(String id) {
    logger.info("====AreaServiceImpl层：进入getById方法开始  id: " + id + "========");
    AreaDO areaDO = areaDAO.selectByPrimaryKey(id);
    AreaDTO areaDTO = new AreaDTO();
    BeanUtils.copyProperties(areaDO, areaDTO, "parent");
    if (areaDO.getCreatedTime() != null) {
      areaDTO.setCreatedTime(DateFormatUtil.dateToTimeStr(areaDO.getCreatedTime()));
    }
    if (areaDO.getOperatedTime() != null) {
      areaDTO.setOperatedTime(DateFormatUtil.dateToTimeStr(areaDO.getOperatedTime()));
    }
    //填充上级区域
    fillParent(areaDTO);
    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setDatas(areaDTO);
    logger.info("====AreaServiceImpl层：进入getById方法结束========");
    return resultDTO;
  }
  /**
   * 递归查询上级区域
   *
   * @param areaDO
   */
  private void fillParent(AreaDTO areaDTO) {
    String parentid = areaDTO.getParentid();
    //如果上级区域不是顶级区域，继续
    if (parentid != null && !"".equals(parentid) && !"0".equals(parentid)) {
      AreaDO areaDO = areaDAO.selectByPrimaryKey(parentid);
      AreaDTO area = new AreaDTO();
      BeanUtils.copyProperties(areaDO, area, "parent");
      if (areaDO.getCreatedTime() != null) {
        area.setCreatedTime(DateFormatUtil.dateToTimeStr(areaDO.getCreatedTime()));
      }
      if (areaDO.getOperatedTime() != null) {
        area.setOperatedTime(DateFormatUtil.dateToTimeStr(areaDO.getOperatedTime()));
      }
      areaDTO.setParent(area);
      fillParent(area);
    }
  }

  @Override
  public IGenericDAO<AreaDO, String> getDao() {
    return areaDAO;
  }
}
