package com.taikang.dic.ltci.serverClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.taikang.dic.ltci.api.model.ResultDTO;

/**
 * 调用专业服务机构查询接口
 *
 * @author itw_liuxy
 * @description
 * @createTime 2017年4月14日 下午2:27:59
 */
@FeignClient(name = "${feign.agency.person.client}", url = "${feign.agency.person.url}")
public interface OrganizationServerClient {

  @RequestMapping(value = "/api/v1/bes/jborganizations", method = RequestMethod.GET)
  public ResultDTO getEvaluateDepartments(
      @RequestParam(value = "areaNum") String areaNum,
      @RequestParam(value = "organizationType") String organizationType);
}
