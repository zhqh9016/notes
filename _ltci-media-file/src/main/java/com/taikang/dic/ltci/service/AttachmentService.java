package com.taikang.dic.ltci.service;

import com.taikang.dic.ltci.model.AttachmentDO;

public interface AttachmentService {

  String insert(AttachmentDO attachmentDO);

  int delete(String id, String fileType);

  AttachmentDO selectByID(String id, String fileType);

  AttachmentDO selectByID(String id, String fileType, String isOriginal);

  AttachmentDO getOriginalPicture(String id);
}
