package com.taikang.dic.ltci.service;

import com.taikang.dic.ltci.model.AttachmentDO;
import com.taikang.dic.ltci.model.AttachmentPictureDOWithBLOBs;

public interface AttachmentPictureService
    extends GenericService<AttachmentPictureDOWithBLOBs, String> {

  int delete(String id);

  String insert(AttachmentDO attachmentDO);
}
