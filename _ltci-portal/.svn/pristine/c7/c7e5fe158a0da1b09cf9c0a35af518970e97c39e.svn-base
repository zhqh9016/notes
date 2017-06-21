package com.taikang.dic.ltci.settlement.serverClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.taikang.dic.ltci.portal.api.model.PageResultDTO;

@FeignClient(name = "${feign.settlement}", url = "${feign.settlement.url}")
public interface PersonalNurseDetailServerClient {

  /**
   * 按条件分页查询个人费用护理明细列表
   *
   * @param personalNurseDetailDTO 查询条件
   * @param page 当前页码
   * @param pageSize 每页显示件数
   * @return 个人费用护理明细信息列表
   */
  @RequestMapping(method = RequestMethod.POST, value = "/api/v1/personal/nurse/detail/list")
  PageResultDTO listPersonNurseDetail(
      @RequestParam(value = "orgCode") String orgCode,
      @RequestParam(value = "inRecorduuid") String inRecorduuid,
      @RequestParam(value = "beCarePersonCard") String beCarePersonCard,
      @RequestParam(value = "feeBeginDate") String feeBeginDate,
      @RequestParam(value = "feeEndDate") String feeEndDate,
      @RequestParam(value = "page") int page,
      @RequestParam(value = "pageSize") int pageSize);
}
