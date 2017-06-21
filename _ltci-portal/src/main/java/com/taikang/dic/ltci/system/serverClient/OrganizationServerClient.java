package com.taikang.dic.ltci.system.serverClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.api.model.OrganizationDTO;
import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
/**
 * 机构微服务调用工具
 *
 * @author itw_muwg
 */
@FeignClient(name = "${feign.system}", url = "${feign.system.url}")
public interface OrganizationServerClient {

  /**
   * 按条件查询机构部门信息
   *
   * @param organization 条件
   * @param page 第几页
   * @param pageSize 每页条数
   * @param systemCode 本系统的服务名称
   * @return
   */
  @RequestMapping(method = RequestMethod.POST, value = "/api/v1/organization/list")
  PageResultDTO listOrganization(
      @RequestBody OrganizationDTO organization,
      @RequestParam(value = "page") int page,
      @RequestParam(value = "pageSize") int pageSize,
      @RequestParam(value = "systemCode") String systemCode);

  /**
   * 根据组织名称精确查询
   *
   * @param name 机构名称
   * @return
   */
  @RequestMapping(value = "/api/v1/organization/getByName", method = RequestMethod.GET)
  ResultDTO getByName(
      @RequestParam("name") String name, @RequestParam(value = "systemCode") String systemCode);

  /**
   * 根据组织编码精确查询
   *
   * @param code 机构编码
   * @return
   */
  @RequestMapping(value = "/api/v1/organization/getByCode", method = RequestMethod.GET)
  ResultDTO getByCode(
      @RequestParam("code") String code, @RequestParam(value = "systemCode") String systemCode);
  /**
   * 根据组织ID精确查询
   *
   * @param id 机构ID
   * @return
   */
  @RequestMapping(value = "/api/v1/organization/{id}", method = RequestMethod.GET)
  ResultDTO selectById(
      @PathVariable("id") String id, @RequestParam(value = "systemCode") String systemCode);
  /**
   * 根据ID删除组织
   *
   * @param id
   * @param operatedBy
   * @return
   */
  @RequestMapping(value = "/api/v1/organization/{id}", method = RequestMethod.DELETE)
  ResultDTO deleteById(
      @PathVariable("id") String id, @RequestParam("operatedBy") String operatedBy);
  /**
   * 更新组织信息
   *
   * @param organization
   */
  @RequestMapping(value = "/api/v1/organization/{id}", method = RequestMethod.PUT)
  public ResultDTO updateOrganization(
      @PathVariable("id") String id, @RequestBody OrganizationDTO organization);

  /**
   * 新增组织信息
   *
   * @param organization
   */
  @RequestMapping(value = "/api/v1/organization", method = RequestMethod.POST)
  public ResultDTO addOrganization(@RequestBody OrganizationDTO organization);
}
