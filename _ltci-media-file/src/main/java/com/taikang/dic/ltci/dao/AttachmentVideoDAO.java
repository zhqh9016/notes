package com.taikang.dic.ltci.dao;

import com.taikang.dic.ltci.model.AttachmentVideoDO;
import com.taikang.dic.ltci.model.AttachmentVideoDOExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AttachmentVideoDAO extends IGenericDAO<AttachmentVideoDO, String> {
  int countByExample(AttachmentVideoDOExample example);

  int deleteByExample(AttachmentVideoDOExample example);

  int deleteByPrimaryKey(String id);

  int insert(AttachmentVideoDO record);

  int insertSelective(AttachmentVideoDO record);

  List<AttachmentVideoDO> selectByExampleWithBLOBs(AttachmentVideoDOExample example);

  List<AttachmentVideoDO> selectByExample(AttachmentVideoDOExample example);

  AttachmentVideoDO selectByPrimaryKey(String id);

  int updateByExampleSelective(
      @Param("record") AttachmentVideoDO record,
      @Param("example") AttachmentVideoDOExample example);

  int updateByExampleWithBLOBs(
      @Param("record") AttachmentVideoDO record,
      @Param("example") AttachmentVideoDOExample example);

  int updateByExample(
      @Param("record") AttachmentVideoDO record,
      @Param("example") AttachmentVideoDOExample example);

  int updateByPrimaryKeySelective(AttachmentVideoDO record);

  int updateByPrimaryKeyWithBLOBs(AttachmentVideoDO record);

  int updateByPrimaryKey(AttachmentVideoDO record);
}
