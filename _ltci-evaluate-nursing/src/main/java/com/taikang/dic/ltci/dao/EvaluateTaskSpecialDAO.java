package com.taikang.dic.ltci.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.taikang.dic.ltci.model.EvaluateTaskDeliveryDO;
import com.taikang.dic.ltci.model.EvaluateTaskSpecialDO;

/**
 * 评估任务扩展查询
 *
 * @author itw_xuxf
 * @version 2017年4月13日下午2:58:46
 */
@Mapper
public interface EvaluateTaskSpecialDAO {
  //分页查询评估任务列表
  List<EvaluateTaskSpecialDO> queryEvaluateTaskList(Map<String, Object> map);

  Integer countEvaluateTaskDOList(Map<String, Object> map);

  //根据评估任务code获取详情
  EvaluateTaskSpecialDO getEvaluateTaskSpecialDOByCode(
      @Param("evaluateTaskCode") String evaluateTaskCode);

  List<String> checkEvaluateTaskUrgent(Map<String, Object> map);

  List<EvaluateTaskDeliveryDO> getExpertTaskList(Map<String, Object> mapForSelect);

  Integer countExpertTaskList(Map<String, Object> map);

  int batchUpdateEvaluateTaskStatusByEvaluateTaskCodes(Map<String, Object> map);

  EvaluateTaskDeliveryDO getEvaluateTaskSpecialStateByCode(
      @Param("evaluateTaskCode") String evaluateTaskCode);

  EvaluateTaskDeliveryDO getInsPersonByIdCard(@Param("idCard") String idCard);

  List<EvaluateTaskDeliveryDO> getEvaluateTaskByIdCard(@Param("idCard") String idCard);

  List<EvaluateTaskSpecialDO> getToDoListEvaluateTaskList(Map<String, Object> map);

  String getTaskStateByIdCardOrEvaluateTaskCode(
      @Param("idCard") String idCard, @Param("evaluateTaskCode") String evaluateTaskCode);
}
