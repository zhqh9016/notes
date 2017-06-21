package com.taikang.dic.ltci.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taikang.dic.ltci.common.exception.ThrowsException;
import com.taikang.dic.ltci.common.util.Encodes;
import com.taikang.dic.ltci.dao.AttachmentPictureDAO;
import com.taikang.dic.ltci.dao.IGenericDAO;
import com.taikang.dic.ltci.model.AttachmentDO;
import com.taikang.dic.ltci.model.AttachmentPictureDOWithBLOBs;
import com.taikang.dic.ltci.service.AbstractGenericService;
import com.taikang.dic.ltci.service.AttachmentPictureService;

import net.coobird.thumbnailator.Thumbnails;

@Service
public class AttachmentPictureServiceImpl
    extends AbstractGenericService<AttachmentPictureDOWithBLOBs, String>
    implements AttachmentPictureService {

  @Autowired private AttachmentPictureDAO attachmentPictureDAO;

  @Override
  public IGenericDAO<AttachmentPictureDOWithBLOBs, String> getDao() {
    return attachmentPictureDAO;
  }

  @Override
  public int delete(String id) {
    return attachmentPictureDAO.deleteByPrimaryKey(id);
  }

  @Override
  public String insert(AttachmentDO attachmentDO) {
    AttachmentPictureDOWithBLOBs pictureDO = new AttachmentPictureDOWithBLOBs();
    pictureDO.setFileName(attachmentDO.getFileName());
    pictureDO.setSuffix(attachmentDO.getSuffix());
    byte[] bytes = Encodes.decodeBase64(attachmentDO.getContent());
    pictureDO.setContent(bytes);

    double size = (float) pictureDO.getContent().length / 1024;
    BigDecimal bigDecimal = BigDecimal.valueOf(size);
    pictureDO.setFileSize(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP));
    logger.info(
        "媒体文件微服务："
            + pictureDO.getFileName()
            + " 的Size:"
            + pictureDO.getContent().length
            + ",文件大小为"
            + pictureDO.getFileSize().doubleValue()
            + "KB");

    //生成缩略图
    byte[] t_bytes = fileByteArr(bytes);
    pictureDO.setThubmContent(t_bytes);

    pictureDO.setFileSize(BigDecimal.valueOf(size));
    pictureDO.setId(UUID.randomUUID().toString().replaceAll("-", ""));
    pictureDO.setCreatedTime(new Date());
    int result = attachmentPictureDAO.insert(pictureDO);
    if (result > 0) {
      return pictureDO.getId();
    } else {
      throw new ThrowsException("保存附件后台出错，保存数量为0！");
    }
  }
  /**
   * 生成图片缩略图
   *
   * @param bytes
   * @return
   */
  private byte[] fileByteArr(byte[] bytes) {
    byte[] t_bytes = null;
    try {
      InputStream is = new ByteArrayInputStream(bytes);
      ByteArrayOutputStream os = new ByteArrayOutputStream();
      Thumbnails.of(is).size(400, 500).toOutputStream(os); //指定尺寸压缩
      //			Thumbnails.of(is).scale(0.2f).toOutputStream(os);//指定比例压缩
      t_bytes = os.toByteArray();
      os.close();
    } catch (Exception e) {
      logger.error("____生成缩略图失败，返回null", e);
      e.printStackTrace();
    }
    return t_bytes;
  }
}
