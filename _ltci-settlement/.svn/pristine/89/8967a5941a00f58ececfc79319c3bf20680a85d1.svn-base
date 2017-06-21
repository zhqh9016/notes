package com.taikang.dic.ltci.dao;

import com.taikang.dic.ltci.model.OrgSettlementDO;
import com.taikang.dic.ltci.model.OrgSettlementDOExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrgSettlementDAO extends IGenericDAO<OrgSettlementDO, String> {
  int countByExample(OrgSettlementDOExample example);

  int deleteByExample(OrgSettlementDOExample example);

  int deleteByPrimaryKey(String id);

  int insert(OrgSettlementDO record);

  int insertSelective(OrgSettlementDO record);

  List<OrgSettlementDO> selectByExample(OrgSettlementDOExample example);

  OrgSettlementDO selectByPrimaryKey(String id);

  int updateByExampleSelective(
      @Param("record") OrgSettlementDO record, @Param("example") OrgSettlementDOExample example);

  int updateByExample(
      @Param("record") OrgSettlementDO record, @Param("example") OrgSettlementDOExample example);

  int updateByPrimaryKeySelective(OrgSettlementDO record);

  int updateByPrimaryKey(OrgSettlementDO record);
}
