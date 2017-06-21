package com.taikang.dic.ltci.dao;

import com.taikang.dic.ltci.model.AttachmentPictureDO;
import com.taikang.dic.ltci.model.AttachmentPictureDOExample;
import com.taikang.dic.ltci.model.AttachmentPictureDOWithBLOBs;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AttachmentPictureDAO extends IGenericDAO<AttachmentPictureDOWithBLOBs, String> {
  int countByExample(AttachmentPictureDOExample example);

  int deleteByExample(AttachmentPictureDOExample example);

  int deleteByPrimaryKey(String id);

  int insert(AttachmentPictureDOWithBLOBs record);

  int insertSelective(AttachmentPictureDOWithBLOBs record);

  List<AttachmentPictureDOWithBLOBs> selectByExampleWithBLOBs(AttachmentPictureDOExample example);

  List<AttachmentPictureDO> selectByExample(AttachmentPictureDOExample example);

  AttachmentPictureDOWithBLOBs selectByPrimaryKey(String id);

  int updateByExampleSelective(
      @Param("record") AttachmentPictureDOWithBLOBs record,
      @Param("example") AttachmentPictureDOExample example);

  int updateByExampleWithBLOBs(
      @Param("record") AttachmentPictureDOWithBLOBs record,
      @Param("example") AttachmentPictureDOExample example);

  int updateByExample(
      @Param("record") AttachmentPictureDO record,
      @Param("example") AttachmentPictureDOExample example);

  int updateByPrimaryKeySelective(AttachmentPictureDOWithBLOBs record);

  int updateByPrimaryKeyWithBLOBs(AttachmentPictureDOWithBLOBs record);

  int updateByPrimaryKey(AttachmentPictureDO record);
}
