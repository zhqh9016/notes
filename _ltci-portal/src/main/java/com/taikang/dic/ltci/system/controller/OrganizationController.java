package com.taikang.dic.ltci.system.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.api.model.UserDTO;
import com.taikang.dic.ltci.portal.common.util.CodeGenerator;
import com.taikang.dic.ltci.portal.common.util.UserUtils;
import com.taikang.dic.ltci.portal.api.model.OrganizationDTO;
import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.system.service.IOrganizationService;

@RestController
@RequestMapping(path = "${restBasePath}", produces = "application/json;charset=utf-8")
public class OrganizationController {
  private Logger logger = LoggerFactory.getLogger(OrganizationController.class);

  @Autowired private IOrganizationService organizationService;

  /** 根据条件分页查询 */
  @RequestMapping(value = "/organization/list", method = RequestMethod.POST)
  public PageResultDTO listOrganization(
      OrganizationDTO organization, Integer page, Integer pageSize) {
    logger.info("====Controller层：listOrganization方法========");
    logger.debug("查询条件:" + organization + "  page:" + page + "  pageSize:" + pageSize);
    if (organization.getId() != null && !"".equals(organization.getId())) {
      organization.setParentid(organization.getId());
    }
    return organizationService.listOrganization(organization, page, pageSize);
  }

  /** 根据组织名称精确查询 */
  @RequestMapping(value = "/organization/getByName", method = RequestMethod.GET)
  public ResultDTO getByName(@RequestParam("name") String name) {
    logger.info("====Controller层：getByName方法========");
    ResultDTO resultDTO = organizationService.getByName(name);
    logger.debug("===getByName方法返回resultDTO【" + resultDTO.toString() + "】===========");
    return resultDTO;
  }

  /** 根据组织编码精确查询 */
  @RequestMapping(value = "/organization/getByCode", method = RequestMethod.GET)
  public ResultDTO getByCode(@RequestParam("code") String code) {
    logger.info("====Controller层：getByCode方法========");
    ResultDTO resultDTO = organizationService.getByCode(code);
    logger.debug("===getByCode方法返回resultDTO【" + resultDTO.toString() + "】===========");
    return resultDTO;
  }

  /** 根据组织ID精确查询 */
  @RequestMapping(value = "/organization/{id}", method = RequestMethod.GET)
  public ResultDTO selectById(@PathVariable("id") String id) {
    logger.info("====Controller层：selectById方法========");
    ResultDTO resultDTO = organizationService.selectById(id);
    logger.debug("===selectById方法返回resultDTO【" + resultDTO.toString() + "】===========");
    return resultDTO;
  }
  /** 根据ID删除组织 */
  @RequestMapping(value = "/organization/{id}", method = RequestMethod.DELETE)
  ResultDTO deleteById(@PathVariable("id") String id) {
    logger.info("====Controller层：delete方法========");
    String username = "";
    UserDTO currentUser = UserUtils.getCurrentUser();
    if (currentUser != null) {
      username = currentUser.getTrueName();
    }
    return organizationService.deleteById(id, username);
  }

  /**
   * 新增组织信息
   *
   * @param OrganizationDTO
   * @return ResultDTO
   */
  @RequestMapping(value = "/organization", method = RequestMethod.POST)
  ResultDTO addOrganization(OrganizationDTO organizationDTO) {
    if ("0".equals(organizationDTO.getParentid()) && 2 == organizationDTO.getIsOrg()) {
      throw new RuntimeException("根节点不能是部门");
    }
    logger.info("begin call OrganizationController#addOrganization parameters:" + organizationDTO);
    //生成一个9位的随机码
    String areaCode = organizationService.getAreaCode(organizationDTO);
    if (areaCode == null) {
      throw new RuntimeException("请求添加的部门所属机构/请求添加的机构没有有效的区域信息");
    }

    String orgCode = CodeGenerator.generateOrgCode(areaCode);
    //防止orgCode重复,自动生成后先去数据库查重
    while (true) {
      ResultDTO byCode = organizationService.getByCode(orgCode);
      if (byCode.getDatas() == null) {
        break;
      }
      orgCode = CodeGenerator.generateOrgCode(areaCode);
    }
    organizationDTO.setCode(orgCode);
    ResultDTO resultDTO = organizationService.addOrganization(organizationDTO);
    logger.info("finish call OrganizationController#addOrganization result:" + resultDTO);
    return resultDTO;
  }

  /**
   * 更新组织信息
   *
   * @param id
   * @param organization
   * @return
   */
  @RequestMapping(value = "/organization/{id}", method = RequestMethod.PUT)
  public ResultDTO updateOrganization(@PathVariable("id") String id, OrganizationDTO organization) {
    logger.info("====Controller层：updateOrganization方法========");
    logger.debug("====updateOrganization organizationDTO:" + organization);
    return organizationService.updateOrganization(id, organization);
  }
}
