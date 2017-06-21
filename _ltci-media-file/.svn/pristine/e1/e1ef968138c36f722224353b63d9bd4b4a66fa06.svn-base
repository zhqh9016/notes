package com.taikang.dic.ltci.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taikang.dic.ltci.common.enumeration.FileTypeEnum;
import com.taikang.dic.ltci.common.enumeration.IsOriginalEnum;
import com.taikang.dic.ltci.common.exception.NotFoundByIdException;
import com.taikang.dic.ltci.common.exception.ParametersIsNullException;
import com.taikang.dic.ltci.common.exception.ThrowsException;
import com.taikang.dic.ltci.common.util.Encodes;
import com.taikang.dic.ltci.model.AttachmentAudioDO;
import com.taikang.dic.ltci.model.AttachmentDO;
import com.taikang.dic.ltci.model.AttachmentPictureDOWithBLOBs;
import com.taikang.dic.ltci.model.AttachmentVideoDO;
import com.taikang.dic.ltci.service.AttachmentAudioService;
import com.taikang.dic.ltci.service.AttachmentPictureService;
import com.taikang.dic.ltci.service.AttachmentService;
import com.taikang.dic.ltci.service.AttachmentVideoService;

@Service
public class AttachmentServiceImpl implements AttachmentService {

  @Autowired private AttachmentAudioService attachmentAudioService;
  @Autowired private AttachmentPictureService attachmentPictureService;
  @Autowired private AttachmentVideoService attachmentVideoService;

  @Override
  public String insert(AttachmentDO attachmentDO) {
    String strResult;
    if (FileTypeEnum.PICTURE.getValue().equals(attachmentDO.getFileType())) {
      strResult = attachmentPictureService.insert(attachmentDO);
    } else if (FileTypeEnum.AUDIO.getValue().equals(attachmentDO.getFileType())) {
      strResult = attachmentAudioService.insert(attachmentDO);
    } else if (FileTypeEnum.VIDEO.getValue().equals(attachmentDO.getFileType())) {
      strResult = attachmentVideoService.insert(attachmentDO);
    } else {
      throw new ParametersIsNullException("没有与fileType：" + attachmentDO.getFileType() + "对应的附件类型！");
    }
    return strResult;
  }

  @Override
  public int delete(String id, String fileType) {
    int iResult;
    if (FileTypeEnum.PICTURE.getValue().equals(fileType)) {
      iResult = attachmentPictureService.delete(id);
    } else if (FileTypeEnum.VIDEO.getValue().equals(fileType)) {
      iResult = attachmentVideoService.delete(id);
    } else if (FileTypeEnum.AUDIO.getValue().equals(fileType)) {
      iResult = attachmentAudioService.delete(id);
    } else {
      throw new ParametersIsNullException("没有与fileType：" + fileType + "对应的附件类型！");
    }
    if (iResult < 1) {
      throw new ThrowsException("根据id" + id + " 删除附件失败，该附件已不存在！");
    }
    return iResult;
  }

  @Override
  public AttachmentDO selectByID(String id, String fileType) {
    AttachmentDO attachmentDO;
    if (FileTypeEnum.PICTURE.getValue().equals(fileType)) {
      AttachmentPictureDOWithBLOBs attachmentPictureDO =
          attachmentPictureService.selectByPrimaryKey(id);
      attachmentDO = convert2DO(attachmentPictureDO, id);
      attachmentDO.setFileType(fileType);
    } else if (FileTypeEnum.VIDEO.getValue().equals(fileType)) {
      AttachmentVideoDO attachmentVideoDO = attachmentVideoService.selectByPrimaryKey(id);
      attachmentDO = convert2DO(attachmentVideoDO, id);
      attachmentDO.setFileType(fileType);
    } else if (FileTypeEnum.AUDIO.getValue().equals(fileType)) {
      AttachmentAudioDO attachmentAudioDO = attachmentAudioService.selectByPrimaryKey(id);
      attachmentDO = convert2DO(attachmentAudioDO, id);
      attachmentDO.setFileType(fileType);
    } else {
      throw new ParametersIsNullException("没有与fileType：" + fileType + "对应的附件类型！");
    }
    return attachmentDO;
  }

  @Override
  public AttachmentDO selectByID(String id, String fileType, String isOriginal) {
    AttachmentDO attachmentDO;
    if (FileTypeEnum.PICTURE.getValue().equals(fileType)) {
      AttachmentPictureDOWithBLOBs attachmentPictureDO =
          attachmentPictureService.selectByPrimaryKey(id);
      //如果是缩略图
      if (IsOriginalEnum.THUMBNAIL_PICTURE.getValue().equals(isOriginal)) {
        attachmentDO = convert2DO(attachmentPictureDO, id);
      } else {
        //如果是原图
        attachmentDO = getOriginalPicture(id);
      }
      attachmentDO.setFileType(fileType);
    } else if (FileTypeEnum.VIDEO.getValue().equals(fileType)) {
      AttachmentVideoDO attachmentVideoDO = attachmentVideoService.selectByPrimaryKey(id);
      attachmentDO = convert2DO(attachmentVideoDO, id);
      attachmentDO.setFileType(fileType);
    } else if (FileTypeEnum.AUDIO.getValue().equals(fileType)) {
      AttachmentAudioDO attachmentAudioDO = attachmentAudioService.selectByPrimaryKey(id);
      attachmentDO = convert2DO(attachmentAudioDO, id);
      attachmentDO.setFileType(fileType);
    } else {
      throw new ParametersIsNullException("没有与fileType：" + fileType + "对应的附件类型！");
    }
    return attachmentDO;
  }

  /**
   * 查询图片原图
   *
   * @param id
   * @return
   */
  @Override
  public AttachmentDO getOriginalPicture(String id) {
    AttachmentPictureDOWithBLOBs attachmentPictureDO =
        attachmentPictureService.selectByPrimaryKey(id);

    AttachmentDO attachmentDO = new AttachmentDO();
    if (attachmentPictureDO == null) {
      throw new NotFoundByIdException("数据库中没有与id为：" + id + " 对应的附件");
    }
    attachmentDO.setFileName(attachmentPictureDO.getFileName());
    attachmentDO.setSuffix(attachmentPictureDO.getSuffix());

    attachmentDO.setContent(Encodes.encodeBase64(attachmentPictureDO.getContent()));

    return attachmentDO;
  }

  private AttachmentDO convert2DO(AttachmentPictureDOWithBLOBs attachmentPictureDO, String id) {
    AttachmentDO attachmentDO = new AttachmentDO();
    if (attachmentPictureDO == null) {
      throw new NotFoundByIdException("数据库中没有与id为：" + id + " 对应的附件");
    }
    attachmentDO.setFileName(attachmentPictureDO.getFileName());
    attachmentDO.setSuffix(attachmentPictureDO.getSuffix());
    if (attachmentPictureDO.getThubmContent() != null) {
      attachmentDO.setContent(Encodes.encodeBase64(attachmentPictureDO.getThubmContent()));
    } else if (attachmentPictureDO.getContent() != null) {
      attachmentDO.setContent(Encodes.encodeBase64(attachmentPictureDO.getContent()));
    }
    return attachmentDO;
  }

  private AttachmentDO convert2DO(AttachmentVideoDO attachmentVideoDO, String id) {
    AttachmentDO attachmentDO = new AttachmentDO();
    if (attachmentVideoDO == null) {
      throw new NotFoundByIdException("数据库中没有与id为：" + id + " 对应的附件");
    }
    attachmentDO.setFileName(attachmentVideoDO.getFileName());
    attachmentDO.setSuffix(attachmentVideoDO.getSuffix());
    if (attachmentVideoDO.getContent() != null) {
      attachmentDO.setContent(Encodes.encodeBase64(attachmentVideoDO.getContent()));
    }
    return attachmentDO;
  }

  private AttachmentDO convert2DO(AttachmentAudioDO attachmentAudioDO, String id) {
    AttachmentDO attachmentDO = new AttachmentDO();
    if (attachmentAudioDO == null) {
      throw new NotFoundByIdException("数据库中没有与id为：" + id + " 对应的附件");
    }
    attachmentDO.setFileName(attachmentAudioDO.getFileName());
    attachmentDO.setSuffix(attachmentAudioDO.getSuffix());
    if (attachmentAudioDO.getContent() != null) {
      attachmentDO.setContent(Encodes.encodeBase64(attachmentAudioDO.getContent()));
    }
    return attachmentDO;
  }
}
