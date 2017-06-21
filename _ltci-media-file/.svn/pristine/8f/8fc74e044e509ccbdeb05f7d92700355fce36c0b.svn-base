package com.taikang.dic.ltci.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.taikang.dic.ltci.model.AttachmentAudioDO;
import com.taikang.dic.ltci.model.AttachmentAudioDOExample;

@Mapper
public interface AttachmentAudioDAO extends IGenericDAO<AttachmentAudioDO, String> {
  int countByExample(AttachmentAudioDOExample example);

  int deleteByExample(AttachmentAudioDOExample example);

  int deleteByPrimaryKey(String id);

  int insert(AttachmentAudioDO record);

  int insertSelective(AttachmentAudioDO record);

  List<AttachmentAudioDO> selectByExampleWithBLOBs(AttachmentAudioDOExample example);

  List<AttachmentAudioDO> selectByExample(AttachmentAudioDOExample example);

  AttachmentAudioDO selectByPrimaryKey(String id);

  int updateByExampleSelective(
      @Param("record") AttachmentAudioDO record,
      @Param("example") AttachmentAudioDOExample example);

  int updateByExampleWithBLOBs(
      @Param("record") AttachmentAudioDO record,
      @Param("example") AttachmentAudioDOExample example);

  int updateByExample(
      @Param("record") AttachmentAudioDO record,
      @Param("example") AttachmentAudioDOExample example);

  int updateByPrimaryKeySelective(AttachmentAudioDO record);

  int updateByPrimaryKeyWithBLOBs(AttachmentAudioDO record);

  int updateByPrimaryKey(AttachmentAudioDO record);
}
