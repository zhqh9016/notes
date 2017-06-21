package com.taikang.dic.ltci.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.taikang.dic.ltci.api.model.PageResultDTO;
import com.taikang.dic.ltci.api.model.PersonalNurseDetailDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.util.DateFormatUtil;
import com.taikang.dic.ltci.model.NurseDetailDO;
import com.taikang.dic.ltci.service.INurseDetailService;

/**
 * 个人费用护理明细Controller
 *
 * @author itw_liuzy 2017-04-13
 */
@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class PersonalNurseDetailController {
  private Logger logger = LoggerFactory.getLogger(PersonalNurseDetailController.class);

  @Autowired INurseDetailService nurseDetailService;

  /**
   * 按条件分页查询个人费用护理明细列表
   *
   * @param personalNurseDetailDTO 查询条件
   * @param page 当前页码
   * @param pageSize 每页显示件数
   * @return 个人费用护理明细信息列表
   */
  @RequestMapping(path = "/personal/nurse/detail/list", method = RequestMethod.POST)
  @ResponseBody
  public PageResultDTO listPersonNurseDetail(
      @RequestParam String orgCode,
      @RequestParam String inRecorduuid,
      @RequestParam String beCarePersonCard,
      @RequestParam String feeBeginDate,
      @RequestParam String feeEndDate,
      @RequestParam(value = "page", defaultValue = "1") int page,
      @RequestParam(value = "pageSize", defaultValue = "100") int pageSize) {
    logger.debug(
        "_listPersonNurseDetail___orgCode="
            + orgCode
            + "___page="
            + beCarePersonCard
            + "___beCarePersonCard="
            + feeBeginDate
            + "___feeDate="
            + page
            + "___pageSize="
            + pageSize);
    Map<String, Object> model =
        nurseDetailService.listPersonNurseDetail(
            orgCode, inRecorduuid, beCarePersonCard, feeBeginDate, feeEndDate, page, pageSize);
    PageResultDTO pageRet = new PageResultDTO();
    pageRet.setPage(page);
    pageRet.setPageSize(pageSize);
    pageRet.setTotalDataNum(Integer.parseInt(model.get("totalDataNum").toString()));
    pageRet.setTotalPageNum(Integer.parseInt(model.get("totalPageNum").toString()));
    @SuppressWarnings("unchecked")
    List<NurseDetailDO> personalNurseDetailDoList =
        (List<NurseDetailDO>) model.get("nurseDetailDoList");

    List<PersonalNurseDetailDTO> personalNurseDetailDTOList = new ArrayList<>();
    for (NurseDetailDO personalNurseDetail : personalNurseDetailDoList) {
      PersonalNurseDetailDTO personalNurseDetailRet = new PersonalNurseDetailDTO();
      BeanUtils.copyProperties(personalNurseDetail, personalNurseDetailRet);
      if (personalNurseDetail.getFeeDate() != null) {
        personalNurseDetailRet.setFeeDate(
            DateFormatUtil.dateToStr(
                personalNurseDetail.getFeeDate(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD));
      }
      personalNurseDetailDTOList.add(personalNurseDetailRet);
    }
    // 个人费用护理明细列表
    pageRet.setDatas(personalNurseDetailDTOList);
    pageRet.setStatus(200);
    pageRet.setMessage("查询个人费用护理明细信息成功");
    return pageRet;
  }

  /**
   * 1、默认查询前一天（对应字段：费用日期）且待上传(IsSynForSocial待上传到第三方社保)的明细（也可以指定某一天待上传的明细） 2、逐条上传到第三方（社保）
   * 3、根据逐条返回的结果更新明细数据状态 4、容错处理机制：如果有一条明细失败出现三次，这记录失败日志；本次；待人工进行处理；
   *
   * <p>5、调用个人日结算接口，参数个人标识、费用日期，都非必传 6、调用数据同步到专业服务系统
   *
   * @param feiDate 费用日期
   * @param sysnStatus 同步状态 只能是0,3
   */
  @RequestMapping(path = "/personal/nurse/detail/thirdparty", method = RequestMethod.GET)
  @ResponseBody
  public ResultDTO uploadDetailToThirdParty(String feiDate, Integer sysnStatus, String orgCode) {
    nurseDetailService.uploadDetailToThirdParty(feiDate, sysnStatus, orgCode);
    return new ResultDTO().status(200);
  }

  /**
   * 1、默认查询前一天（对应字段：费用日期）且待上传的明细（也可以指定某一天待上传的明细） 2、打包一并上传到专业服务系统MQ
   *
   * @param feiDate 费用日期
   * @param sysnStatus 同步状态 只能是0,3
   */
  @RequestMapping(path = "/personal/nurse/detail/org", method = RequestMethod.GET)
  @ResponseBody
  public ResultDTO uploadDetailToOrg(String feiDate, Integer sysnStatus, String orgCode) {
    nurseDetailService.uploadDetailToOrg(feiDate, sysnStatus, orgCode);
    return new ResultDTO().status(200);
  }
}
