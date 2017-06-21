package com.taikang.dic.ltci.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taikang.dic.ltci.common.exception.ThrowsException;
import com.taikang.dic.ltci.common.util.Encodes;
import com.taikang.dic.ltci.dao.AttachmentVideoDAO;
import com.taikang.dic.ltci.dao.IGenericDAO;
import com.taikang.dic.ltci.model.AttachmentDO;
import com.taikang.dic.ltci.model.AttachmentVideoDO;
import com.taikang.dic.ltci.service.AbstractGenericService;
import com.taikang.dic.ltci.service.AttachmentVideoService;

@Service
public class AttachmentVideoServiceImpl extends AbstractGenericService<AttachmentVideoDO, String>
    implements AttachmentVideoService {

  private static final Logger logger = LoggerFactory.getLogger(AttachmentVideoServiceImpl.class);

  @Autowired private AttachmentVideoDAO attachmentVideoDAO;

  @Override
  public IGenericDAO<AttachmentVideoDO, String> getDao() {
    return attachmentVideoDAO;
  }

  @Override
  public int delete(String id) {
    return attachmentVideoDAO.deleteByPrimaryKey(id);
  }

  @Override
  public String insert(AttachmentDO attachmentDO) {
    AttachmentVideoDO videoDO = new AttachmentVideoDO();
    videoDO.setFileName(attachmentDO.getFileName());
    videoDO.setSuffix(attachmentDO.getSuffix());
    videoDO.setContent(Encodes.decodeBase64(attachmentDO.getContent()));

    double size = (float) videoDO.getContent().length / 1024;
    BigDecimal bigDecimal = BigDecimal.valueOf(size);
    videoDO.setFileSize(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP));
    logger.info(
        "媒体文件微服务："
            + videoDO.getFileName()
            + " 的Size:"
            + videoDO.getContent().length
            + ",文件大小为"
            + videoDO.getFileSize().doubleValue()
            + "KB");
    videoDO.setId(UUID.randomUUID().toString().replaceAll("-", ""));
    videoDO.setCreatedTime(new Date());
    int result = attachmentVideoDAO.insert(videoDO);
    if (result > 0) {
      return videoDO.getId();
    } else {
      throw new ThrowsException("保存附件后台出错，保存数量为0！");
    }
  }
}
