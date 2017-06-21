package com.taikang.dic.ltci.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.taikang.dic.ltci.model.EvaluateTaskDO;
import com.taikang.dic.ltci.model.ExpertEvaluateDO;
import com.taikang.dic.ltci.model.ExpertEvaluateDOExample;
import com.taikang.dic.ltci.model.ExpertEvaluateSpecialDO;

@Mapper
public interface ExpertEvaluateSpecialDAO {

  List<ExpertEvaluateSpecialDO> getExpertEvaluate(Map<String, Object> map);

  Integer countExpertEvaluateList(Map<String, Object> map);

  Map<String, Object> getExpertEvaluateScan(String expertEvaluateCode);

  EvaluateTaskDO getEvaluateTask(String expertEvaluateCode);
}
