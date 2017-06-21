package com.taikang.dic.ltci.settlement.serverClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.taikang.dic.ltci.portal.api.model.MonSetPerDTO;
import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;

@FeignClient(name = "${feign.settlement}", url = "${feign.settlement.url}")
public interface MonSetPerServerClient {

  /**
   * 按条件分页查询个人月结算信息
   *
   * @param name 姓名
   * @param idCard 身份证号码
   * @param startDate 费用开始日期
   * @param endDate 费用终止日期
   * @param orgId 机构编号
   * @param unrFee 不合理费用
   * @param page 当前页
   * @param pageSize 每页显示件数
   * @return 个人月结算信息列表
   */
  @RequestMapping(method = RequestMethod.POST, value = "/api/v1/monSetPer/list")
  PageResultDTO listMonSetPer(
      @RequestParam(value = "name") String name,
      @RequestParam(value = "idCard") String idCard,
      @RequestParam(value = "startDate") String startDate,
      @RequestParam(value = "endDate") String endDate,
      @RequestParam(value = "orgCode") String orgCode,
      @RequestParam(value = "unrFee") Double unrFee,
      @RequestParam(value = "page") int page,
      @RequestParam(value = "pageSize") int pageSize,
      @RequestParam(value = "operateOrgCode") String operateOrgCode,
      @RequestParam(value = "systemCode") String systemCode);

  /**
   * 不合理费用录入
   *
   * @param id 主键
   * @param unrFee 不合理费用
   * @param systemCode
   * @return
   */
  @RequestMapping(method = RequestMethod.PUT, value = "/api/v1/monSetPer")
  ResultDTO enterUnrFee(
      @RequestBody MonSetPerDTO monSetPerDto,
      @RequestParam(value = "systemCode") String systemCode);
}
