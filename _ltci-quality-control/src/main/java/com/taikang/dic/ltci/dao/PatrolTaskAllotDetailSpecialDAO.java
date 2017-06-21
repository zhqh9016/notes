package com.taikang.dic.ltci.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.taikang.dic.ltci.model.PatrolTaskAllotDetailSpecialDO;
import com.taikang.dic.ltci.model.PatrolTaskSpecialDO;

import feign.Param;

@Mapper
public interface PatrolTaskAllotDetailSpecialDAO {
  PatrolTaskAllotDetailSpecialDO selectPatrolTaskByPatrolTaskId(
      @Param("patrolTaskId") String patrolTaskId);
}
