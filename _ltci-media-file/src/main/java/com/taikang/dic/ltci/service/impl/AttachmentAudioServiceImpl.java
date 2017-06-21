package com.taikang.dic.ltci.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taikang.dic.ltci.common.exception.ThrowsException;
import com.taikang.dic.ltci.common.util.Encodes;
import com.taikang.dic.ltci.dao.AttachmentAudioDAO;
import com.taikang.dic.ltci.dao.IGenericDAO;
import com.taikang.dic.ltci.model.AttachmentAudioDO;
import com.taikang.dic.ltci.model.AttachmentDO;
import com.taikang.dic.ltci.service.AbstractGenericService;
import com.taikang.dic.ltci.service.AttachmentAudioService;

@Service
public class AttachmentAudioServiceImpl extends AbstractGenericService<AttachmentAudioDO, String>
    implements AttachmentAudioService {

  @Autowired private AttachmentAudioDAO attachmentAudioDAO;

  @Override
  public IGenericDAO<AttachmentAudioDO, String> getDao() {
    return attachmentAudioDAO;
  }

  @Override
  public int delete(String id) {
    return attachmentAudioDAO.deleteByPrimaryKey(id);
  }

  @Override
  public String insert(AttachmentDO attachmentDO) {
    AttachmentAudioDO audioDO = new AttachmentAudioDO();
    audioDO.setFileName(attachmentDO.getFileName());
    audioDO.setSuffix(attachmentDO.getSuffix());
    audioDO.setContent(Encodes.decodeBase64(attachmentDO.getContent()));

    double size = (float) audioDO.getContent().length / 1024;
    BigDecimal bigDecimal = BigDecimal.valueOf(size);
    audioDO.setFileSize(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP));
    logger.info(
        "媒体文件微服务："
            + audioDO.getFileName()
            + " 的Size:"
            + audioDO.getContent().length
            + ",文件大小为"
            + audioDO.getFileSize().doubleValue()
            + "KB");

    audioDO.setFileSize(BigDecimal.valueOf(size));
    audioDO.setId(UUID.randomUUID().toString().replaceAll("-", ""));
    audioDO.setCreatedTime(new Date());
    int result = attachmentAudioDAO.insert(audioDO);
    if (result > 0) {
      return audioDO.getId();
    } else {
      throw new ThrowsException("保存附件后台出错，保存数量为0！");
    }
  }
}
