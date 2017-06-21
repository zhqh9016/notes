package com.taikang.dic.ltci.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.taikang.dic.ltci.api.model.OrganizationDTO;
import com.taikang.dic.ltci.api.model.PageResultDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.ConstantUtil;
import com.taikang.dic.ltci.common.enumeration.IsValidEnum;
import com.taikang.dic.ltci.common.util.DateFormatUtil;
import com.taikang.dic.ltci.dao.AreaDAO;
import com.taikang.dic.ltci.dao.IGenericDAO;
import com.taikang.dic.ltci.dao.IOrganizationDAO;
import com.taikang.dic.ltci.model.AreaDO;
import com.taikang.dic.ltci.model.BaseModel;
import com.taikang.dic.ltci.model.OrganizationDO;
import com.taikang.dic.ltci.model.OrganizationDOExample;
import com.taikang.dic.ltci.model.OrganizationDOExample.Criteria;
import com.taikang.dic.ltci.model.UserDO;
import com.taikang.dic.ltci.service.AbstractGenericService;
import com.taikang.dic.ltci.service.IOrganizationService;
import com.taikang.dic.ltci.service.IUserService;

/**
 * 组织信息
 *
 * @author itw_zhangqh
 */
@Service
public class OrganizationServiceImpl extends AbstractGenericService<OrganizationDO, String>
    implements IOrganizationService {
  protected static final Logger logger = LoggerFactory.getLogger(OrganizationServiceImpl.class);
  @Autowired private IOrganizationDAO organizationDAO;
  @Autowired private AreaDAO areaDao;
  @Autowired private IUserService userService;

  @Override
  public IGenericDAO<OrganizationDO, String> getDao() {
    return organizationDAO;
  }

  /**
   * 根据条件分页查询组织信息
   *
   * @param organization
   * @param page
   * @param pageSize
   * @return
   */
  @Override
  public PageResultDTO listOrganization(OrganizationDTO organization, int page, int pageSize) {
    LOG.info("===service层 listOrganization方法");
    OrganizationDOExample example = new OrganizationDOExample();
    Criteria c = example.createCriteria();
    if (!StringUtils.isEmpty(organization.getName())) {
      c.andNameLike("%" + organization.getName() + "%");
    }
    if (!StringUtils.isEmpty(organization.getCode())) {
      c.andCodeEqualTo(organization.getCode());
    }
    if (!StringUtils.isEmpty(organization.getParentid())
        && StringUtils.isEmpty(organization.getCode())
        && StringUtils.isEmpty(organization.getName())) {
      c.andParentidEqualTo(organization.getParentid());
    }
    // 删除标识
    c.andIsValidEqualTo(BaseModel.IsValid.VALID.getValue());

    int count = organizationDAO.countByExample(example);

    int pageIndex = (page - 1) * pageSize;
    int totalPage = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;

    example.setOrderByClause(" sequence asc  limit " + pageIndex + " , " + pageSize + " ");
    List<OrganizationDO> organizationDoList = organizationDAO.selectByExample(example);

    PageResultDTO pageRet = new PageResultDTO();
    pageRet.setPage(page);
    pageRet.setPageSize(pageSize);
    pageRet.setTotalDataNum(count);
    pageRet.setTotalPageNum(totalPage);
    pageRet.setStatus(200);
    // 遍历结果将DO转成DTO
    List<Object> resDtoList = new ArrayList<>();
    if (organizationDoList != null && !organizationDoList.isEmpty()) {
      for (OrganizationDO org : organizationDoList) {
        OrganizationDTO organizationDto = new OrganizationDTO();
        BeanUtils.copyProperties(org, organizationDto);
        // 转换日期
        organizationDto.setCreatedTime(DateFormatUtil.dateToTimeStr(org.getCreatedTime()));
        if (org.getOperatedTime() != null) {
          organizationDto.setOperatedTime(DateFormatUtil.dateToTimeStr(org.getOperatedTime()));
        }
        // 填充下级组织
        if (StringUtils.isEmpty(organization.getCode())
            && StringUtils.isEmpty(organization.getName())) {
          fillChildren(organizationDto);
        }
        resDtoList.add(organizationDto);
      }
    }
    pageRet.setDatas(resDtoList);
    return pageRet;
  }

  /**
   * 递归查询下级组织
   *
   * @param organizationDto
   */
  private void fillChildren(OrganizationDTO organizationDto) {

    OrganizationDOExample example = new OrganizationDOExample();
    Criteria c = example.createCriteria();
    c.andParentidEqualTo(organizationDto.getId());
    // 删除标识
    c.andIsValidEqualTo(BaseModel.IsValid.VALID.getValue());
    example.setOrderByClause(" sequence asc ");
    List<OrganizationDO> organizationDoList = organizationDAO.selectByExample(example);
    // 如果有下级组织
    if (organizationDoList != null && !organizationDoList.isEmpty()) {
      List<OrganizationDTO> listDto = new ArrayList<>();
      for (OrganizationDO org : organizationDoList) {
        OrganizationDTO dto = new OrganizationDTO();
        BeanUtils.copyProperties(org, dto);
        // 转换日期
        dto.setCreatedTime(DateFormatUtil.dateToTimeStr(org.getCreatedTime()));
        if (org.getOperatedTime() != null) {
          dto.setOperatedTime(DateFormatUtil.dateToTimeStr(org.getOperatedTime()));
        }
        // 填充下级组织
        fillChildren(dto);
        listDto.add(dto);
      }
      organizationDto.setChildren(listDto);
    }
  }

  /** 根据名称精确查询 */
  @Override
  public ResultDTO selectByName(String name) {
    LOG.info("===service层 selectByName方法");
    OrganizationDOExample example = new OrganizationDOExample();
    Criteria c = example.createCriteria();
    if (name != null && !"".equals(name)) {
      c.andNameEqualTo(name);
    }

    List<OrganizationDO> organizationDoList = organizationDAO.selectByExample(example);
    ResultDTO generalResultDTO = new ResultDTO();
    if (organizationDoList != null && !organizationDoList.isEmpty()) {
      OrganizationDO organizationDO = organizationDoList.get(0);
      OrganizationDTO organizationDto = new OrganizationDTO();
      BeanUtils.copyProperties(organizationDO, organizationDto);
      // 转换日期
      organizationDto.setCreatedTime(DateFormatUtil.dateToTimeStr(organizationDO.getCreatedTime()));
      if (organizationDO.getOperatedTime() != null) {
        organizationDto.setOperatedTime(
            DateFormatUtil.dateToTimeStr(organizationDO.getOperatedTime()));
      }
      generalResultDTO.setDatas(organizationDto);
    }
    return generalResultDTO;
  }

  /** 根据组织编码精确查询 */
  @Override
  public ResultDTO selectByCode(String code) {
    LOG.info("===service层 selectByCode方法");
    OrganizationDOExample example = new OrganizationDOExample();
    Criteria c = example.createCriteria();
    if (code != null && !"".equals(code)) {
      c.andCodeEqualTo(code);
    }

    List<OrganizationDO> organizationDoList = organizationDAO.selectByExample(example);
    ResultDTO generalResultDTO = new ResultDTO();
    if (organizationDoList != null && !organizationDoList.isEmpty()) {
      OrganizationDO organizationDO = organizationDoList.get(0);
      OrganizationDTO organizationDto = new OrganizationDTO();
      BeanUtils.copyProperties(organizationDO, organizationDto);
      // 转换日期
      organizationDto.setCreatedTime(DateFormatUtil.dateToTimeStr(organizationDO.getCreatedTime()));
      if (organizationDO.getOperatedTime() != null) {
        organizationDto.setOperatedTime(
            DateFormatUtil.dateToTimeStr(organizationDO.getOperatedTime()));
      }
      generalResultDTO.setDatas(organizationDto);
    }
    return generalResultDTO;
  }

  /** 根据主键ID查询 */
  @Override
  public ResultDTO selectById(String id) {
    LOG.info("===service层 selectById方法");
    ResultDTO generalResultDTO = new ResultDTO();
    OrganizationDO organizationDo = organizationDAO.selectByPrimaryKey(id);
    OrganizationDTO organizationDto = new OrganizationDTO();
    if (organizationDo != null) {
      BeanUtils.copyProperties(organizationDo, organizationDto);
      // 转换日期
      organizationDto.setCreatedTime(DateFormatUtil.dateToTimeStr(organizationDo.getCreatedTime()));
      if (organizationDo.getOperatedTime() != null) {
        organizationDto.setOperatedTime(
            DateFormatUtil.dateToTimeStr(organizationDo.getOperatedTime()));
      }
      generalResultDTO.setDatas(organizationDto);
    }
    return generalResultDTO;
  }

  @Override
  public int update(OrganizationDTO organization) {
    LOG.info("===service层 update方法");
    OrganizationDO orgDO = new OrganizationDO();
    BeanUtils.copyProperties(
        organization, orgDO, "createdBy", "createdTime", "code", "operatedTime");
    orgDO.setOperatedTime(new Date());
    //填充省市区的名称
    if (!StringUtils.isEmpty(organization.getProvinceid())) {
      AreaDO areaDO = areaDao.selectByPrimaryKey(organization.getProvinceid());
      if (areaDO != null) {
        orgDO.setProvinceName(areaDO.getAreaName());
      }
    }
    if (!StringUtils.isEmpty(organization.getCityid())) {
      AreaDO areaDO = areaDao.selectByPrimaryKey(organization.getCityid());
      if (areaDO != null) {
        orgDO.setCityName(areaDO.getAreaName());
      }
    }
    if (!StringUtils.isEmpty(organization.getCountyid())) {
      AreaDO areaDO = areaDao.selectByPrimaryKey(organization.getCountyid());
      if (areaDO != null) {
        orgDO.setCountyName(areaDO.getAreaName());
      }
    }
    return organizationDAO.updateByPrimaryKeySelective(orgDO);
  }

  @SuppressWarnings("unchecked")
  @Override
  public ResultDTO delete(OrganizationDTO organiation) {
    LOG.info("===service层 delete方法");
    ResultDTO result = new ResultDTO();
    // 删除请求中不包含id
    if (StringUtils.isEmpty(organiation.getId())) {
      result.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
      result.setMessage(ConstantUtil.DELETE_NO_ID);
      return result;
    }
    //判断是否有下级组织目录
    OrganizationDOExample example = new OrganizationDOExample();
    Criteria c = example.createCriteria();
    c.andParentidEqualTo(organiation.getId());
    c.andIsValidEqualTo(BaseModel.IsValid.VALID.getValue());
    List<OrganizationDO> organizationDoList = organizationDAO.selectByExample(example);
    if (organizationDoList != null && !organizationDoList.isEmpty()) {
      result.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
      result.setMessage(ConstantUtil.DELETE_LOWER_ORG);
      return result;
    }
    //判断该组织下是否有用户
    UserDO userDo = new UserDO();
    userDo.setDepartmentid(organiation.getId());
    Map<String, Object> model = userService.listUser(userDo, "", 1, 10);
    List<UserDO> listUser = (List<UserDO>) model.get("userDoList");
    if (listUser != null && !listUser.isEmpty()) {
      result.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
      result.setMessage(ConstantUtil.NOT_DELETE_USER_ORG);
      return result;
    }

    OrganizationDO orgDO = new OrganizationDO();
    // 将dto转成do
    BeanUtils.copyProperties(
        organiation, orgDO, "createdBy", "createdTime", "code", "operatedTime");
    // 填充操作时间
    orgDO.setOperatedTime(new Date());
    orgDO.setIsValid(BaseModel.IsValid.INVALID.getValue());
    int updateByPrimaryKeySelective = organizationDAO.updateByPrimaryKeySelective(orgDO);
    // 根据受影响的条数返回不同的状态
    if (updateByPrimaryKeySelective == 1) {
      result.setStatus(HttpStatus.OK.value());
      result.setMessage(ConstantUtil.DELETE_SUCCESS);
    } else if (updateByPrimaryKeySelective == 0) {
      result.setStatus(HttpStatus.NOT_FOUND.value());
      result.setMessage(ConstantUtil.DELETE_NO_ITEM);
    }

    return result;
  }

  @Override
  public ResultDTO insertSelective(OrganizationDTO organizationDTO) {
    LOG.info("===service层 insertSelective方法");
    OrganizationDO organizationDO = new OrganizationDO();
    BeanUtils.copyProperties(organizationDTO, organizationDO);
    organizationDO.setId(BaseModel.getUUID());
    organizationDTO.setId(organizationDO.getId());
    organizationDO.setCreatedBy(organizationDTO.getCreatedBy());
    organizationDO.setCreatedTime(new Date());
    organizationDO.setOperatedTime(new Date());
    organizationDO.setIsValid(BaseModel.IsValid.VALID.getValue());
    //填充省市区的名称
    if (!StringUtils.isEmpty(organizationDO.getProvinceid())) {
      AreaDO areaDO = areaDao.selectByPrimaryKey(organizationDO.getProvinceid());
      if (areaDO != null) {
        organizationDO.setProvinceName(areaDO.getAreaName());
      }
    }
    if (!StringUtils.isEmpty(organizationDO.getCityid())) {
      AreaDO areaDO = areaDao.selectByPrimaryKey(organizationDO.getCityid());
      if (areaDO != null) {
        organizationDO.setCityName(areaDO.getAreaName());
      }
    }
    if (!StringUtils.isEmpty(organizationDO.getCountyid())) {
      AreaDO areaDO = areaDao.selectByPrimaryKey(organizationDO.getCountyid());
      if (areaDO != null) {
        organizationDO.setCountyName(areaDO.getAreaName());
      }
    }

    int succeed = insertSelective(organizationDO);

    ResultDTO result = new ResultDTO();
    if (succeed == ConstantUtil.DB_OPERATION_SUCCEED) {
      result.setStatus(HttpStatus.OK.value());
      result.setMessage(ConstantUtil.OPERATION_SUCCESS);
    } else {
      result.setStatus(HttpStatus.NOT_FOUND.value());
      result.setMessage(ConstantUtil.DELETE_NO_ITEM);
    }
    return result;
  }

  @Override
  public ResultDTO getBySocOrgCode(String socOrgCode) {
    LOG.info("===service层 selectByCode方法");
    OrganizationDOExample example = new OrganizationDOExample();
    Criteria c = example.createCriteria();
    if (socOrgCode != null && !"".equals(socOrgCode)) {
      c.andSocOrgCodeEqualTo(socOrgCode);
    }
    c.andIsValidEqualTo(IsValidEnum.NO_DELETE.getValue());
    List<OrganizationDO> organizationDoList = organizationDAO.selectByExample(example);
    ResultDTO generalResultDTO = new ResultDTO();
    if (organizationDoList != null && !organizationDoList.isEmpty()) {
      OrganizationDO organizationDO = organizationDoList.get(0);
      generalResultDTO.setDatas(organizationDO);
    }
    return generalResultDTO;
  }
}
