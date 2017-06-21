package com.taikang.dic.ltci.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.taikang.dic.ltci.api.model.OrganizationDTO;
import com.taikang.dic.ltci.api.model.PageResultDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.service.IOrganizationService;

@RestController
@RequestMapping(path = "${restBasePath}", produces = "application/json;charset=utf-8")
public class OrganizationController {

  private Logger logger = LoggerFactory.getLogger(OrganizationController.class);

  @Autowired private IOrganizationService organizationService;

  /** 根据条件分页查询 */
  @RequestMapping(value = "/organization/list", method = RequestMethod.POST)
  public PageResultDTO listOrganization(
      @RequestBody OrganizationDTO organization, Integer page, Integer pageSize) {
    logger.info("====Controller层：listOrganization方法========");
    logger.debug("查询条件:" + organization + "  page:" + page + "  pageSize:" + pageSize);
    PageResultDTO pageResultDTO =
        organizationService.listOrganization(organization, page, pageSize);
    pageResultDTO.setStatus(HttpStatus.OK.value());
    pageResultDTO.setMessage("查询成功");
    return pageResultDTO;
  }

  /**
   * 更新组织信息
   *
   * @param organization
   */
  @RequestMapping(value = "/organization/{id}", method = RequestMethod.PUT)
  public ResultDTO updateOrganization(
      @PathVariable("id") String id, @RequestBody OrganizationDTO organization) {
    logger.info("====Controller层：updateOrganization方法========");
    logger.debug("====organizationDTO:" + organization);
    if (organization.getId() != null) {
      organizationService.update(organization);
    }
    ResultDTO result = new ResultDTO();
    result.setStatus(HttpStatus.OK.value());
    result.setMessage("更新成功");
    return result;
  }
  /** 根据组织名称精确查询 */
  @RequestMapping(value = "/organization/getByName", method = RequestMethod.GET)
  public ResultDTO getByName(@RequestParam("name") String name) {
    logger.info("====Controller层：getByName方法========");
    ResultDTO resultDTO = organizationService.selectByName(name);
    resultDTO.setStatus(HttpStatus.OK.value());
    resultDTO.setMessage("查询成功");
    logger.debug("===getByName方法返回resultDTO【" + resultDTO.toString() + "】===========");
    return resultDTO;
  }
  /** 根据组织编码精确查询 */
  @RequestMapping(value = "/organization/getByCode", method = RequestMethod.GET)
  public ResultDTO getByCode(@RequestParam("code") String code) {
    logger.info("====Controller层：getByCode方法========");
    ResultDTO resultDTO = organizationService.selectByCode(code);
    resultDTO.setStatus(HttpStatus.OK.value());
    resultDTO.setMessage("查询成功");
    logger.debug("===getByCode方法返回resultDTO【" + resultDTO.toString() + "】===========");
    return resultDTO;
  }
  /** 根据社保机构编码精确查询 */
  @RequestMapping(value = "/organization/getBySocOrgCode", method = RequestMethod.GET)
  public ResultDTO getBySocOrgCode(@RequestParam("socOrgCode") String socOrgCode) {
    logger.info("====Controller层：getBySocOrgCode方法========");
    ResultDTO resultDTO = organizationService.getBySocOrgCode(socOrgCode);
    resultDTO.setStatus(HttpStatus.OK.value());
    resultDTO.setMessage("查询成功");
    logger.debug("===getByCode方法返回resultDTO【" + resultDTO.toString() + "】===========");
    return resultDTO;
  }
  /** 根据组织编码精确查询 */
  @RequestMapping(value = "/organization/{id}", method = RequestMethod.GET)
  public ResultDTO selectById(@PathVariable("id") String id) {
    logger.info("====Controller层：selectById方法========");
    ResultDTO resultDTO = organizationService.selectById(id);
    resultDTO.setStatus(HttpStatus.OK.value());
    resultDTO.setMessage("查询成功");
    logger.debug("===getById方法返回resultDTO【" + resultDTO.toString() + "】===========");
    return resultDTO;
  }
  /** 根据ID删除组织 */
  @RequestMapping(value = "/organization/{id}", method = RequestMethod.DELETE)
  public ResultDTO delete(
      @PathVariable("id") String id, @RequestParam("operatedBy") String operatedBy) {
    logger.info("====Controller层：delete方法========");
    OrganizationDTO organiation = new OrganizationDTO();
    //设置被删除的条目id和操作人
    organiation.setId(id);
    organiation.setOperatedBy(operatedBy);

    return organizationService.delete(organiation);
  }

  /** 新增组织机构 */
  @RequestMapping(value = "/organization", method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.OK)
  public ResultDTO addOrganization(@RequestBody OrganizationDTO organizationDTO) {
    logger.info("====Controller层：addOrganization方法========");
    logger.debug("====organizationDTO:" + organizationDTO);
    ResultDTO resultDTO = organizationService.insertSelective(organizationDTO);
    logger.info("call OrganizationController#addOrganization info:" + organizationDTO);
    return resultDTO;
  }
}
