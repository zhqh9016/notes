package com.taikang.dic.ltci.quality.control.serviceClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.taikang.dic.ltci.quality.control.professionModel.PageResultPF;

@FeignClient(
  name = "${feign.quality.control.profession.client}",
  url = "${feign.quality.control.profession.url}"
)
public interface PatrolTaskOfProfessionClient {

  @RequestMapping(method = RequestMethod.GET, value = "/ltcs/evaluate/evaluateagencytasks")
  PageResultPF getEvaluatePatrolTaskList(
      @RequestParam(value = "isCritical") String isCritical,
      @RequestParam(value = "beginTime") String beginTime,
      @RequestParam(value = "endTime") String endTime,
      @RequestParam(value = "provinceCode") String provinceCode,
      @RequestParam(value = "cityCode") String cityCode,
      @RequestParam(value = "areaCode") String areaCode,
      @RequestParam(value = "orgCode") String orgCode,
      @RequestParam(value = "number") int page,
      @RequestParam(value = "size") int pageSize);
  /**
   * 获取专业平台的护理任务列表
   *
   * @param serviceType 服务类型（页面选择）: 非全日居家护理、全日居家护理、机构护理、医疗护理
   * @param serviceItems 服务目录项（页面录入的）
   * @param isKinshipCare 是否特权通过
   * @param isPrivilege 是否亲属照护
   * @param beginTime
   * @param endTime
   * @param provinceCode
   * @param cityCode
   * @param areaCode
   * @param orgCode
   * @param page
   * @param pageSize
   * @return
   */
  @RequestMapping(method = RequestMethod.GET, value = "ltcs/nurse/nurseagencttask")
  PageResultPF getNursingPatrolTaskList(
      @RequestParam(value = "serviceType") String serviceType,
      @RequestParam(value = "serviceItems") String serviceItems,
      @RequestParam(value = "isKinshipCare") String isKinshipCare,
      @RequestParam(value = "isPrivilege") String isPrivilege,
      @RequestParam(value = "beginTime") String beginTime,
      @RequestParam(value = "endTime") String endTime,
      @RequestParam(value = "provinceCode") String provinceCode,
      @RequestParam(value = "cityCode") String cityCode,
      @RequestParam(value = "areaCode") String areaCode,
      @RequestParam(value = "orgCode") String orgCode,
      @RequestParam(value = "number") int page,
      @RequestParam(value = "size") int pageSize);
}
