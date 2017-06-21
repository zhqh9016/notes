package com.taikang.dic.ltci.settlement.serverClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.taikang.dic.ltci.portal.api.model.OrgSettlementDTO;
import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
/**
 * 机构微服务调用工具
 *
 * @author itw_muwg
 */
@FeignClient(name = "${feign.settlement}", url = "${feign.settlement.url}")
public interface OrgSettlementServerClient {
  /** 统计机构月结信息 */
  @RequestMapping(method = RequestMethod.POST, value = "/api/v1/orgSettlement/countData")
  public PageResultDTO countOrgData(
      @RequestBody OrgSettlementDTO orgSettlementDTO,
      @RequestParam("page") Integer page,
      @RequestParam("pageSize") Integer pageSize);
  /** 保存审核通过的机构月结信息 */
  @RequestMapping(method = RequestMethod.POST, value = "/api/v1/orgSettlement/save")
  public ResultDTO saveOrgData(@RequestBody OrgSettlementDTO orgSettlementDTO);

  /**
   * 机构月结表查询 包括费用复核查询,费用支付查询
   *
   * @return
   */
  @RequestMapping(value = "/api/v1//orgSets/list", method = RequestMethod.POST)
  public PageResultDTO listMonSetOrgForCheckReview(
      @RequestParam("orgName") String orgName,
      @RequestParam("orgCode") String orgCode,
      @RequestParam("auditState") String auditState,
      @RequestParam("startDate") String startDate,
      @RequestParam("endDate") String endDate,
      @RequestParam("page") Integer page,
      @RequestParam("pageSize") Integer pageSize);
  /**
   * 根据ID查询机构月结信息
   *
   * @param id
   * @return
   */
  @RequestMapping(value = "/api/v1/orgSettlement/{id}", method = RequestMethod.GET)
  public ResultDTO selectById(@PathVariable("id") String id);
  /**
   * 更新机构月结审核状态信息
   *
   * @param orgSet
   * @return
   */
  @RequestMapping(value = "/api/v1/orgSettlement/auditState", method = RequestMethod.PUT)
  public ResultDTO updateAuditState(@RequestBody OrgSettlementDTO orgSet);
  /**
   * 机构月结费用结算操作
   *
   * @param orgSet
   * @return
   */
  @RequestMapping(value = "/api/v1/orgSettlement/settle", method = RequestMethod.PUT)
  public ResultDTO settleForOrg(@RequestBody OrgSettlementDTO orgSet);
}
