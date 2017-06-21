package com.taikang.dic.ltci.common.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.api.model.AttachmentDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.enumeration.FileTypeEnum;
import com.taikang.dic.ltci.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.common.exception.ThrowsException;
import com.taikang.dic.ltci.serverClient.AttachmentServiceClient;

@Component
public class MediaFileUtils {

  @Autowired private AttachmentServiceClient attachmentServiceClient;

  private Logger logger = LoggerFactory.getLogger(MediaFileUtils.class);

  @Value("${systemCharset}")
  private String systemCharset;

  /**
   * 根据数据库存储的id,id格式串，获取mongodb中的文件流，再配对对应组合放到集合中，将集合转成json串返回前端
   *
   * @param scanIdStr id,id格式字符串
   * @return
   */
  public String scanIdStrToJsonStr(String scanIdStr) {
    List<Map<String, byte[]>> list = new ArrayList<>();
    if (null != scanIdStr && !"".equals(scanIdStr)) {
      String[] scanIdArray = scanIdStr.split(",");
      for (String str : scanIdArray) {
        if (!"".equals(str)) {
          try {
            String content = getContent(str);
            Map<String, byte[]> map = new HashMap<>();
            if (StringUtils.isNotBlank(content)) {
              map.put(str, content.getBytes(systemCharset));
            } else {
              map.put(str, null);
            }
            list.add(map);
          } catch (Exception e) {
            logger.error("将mognodb中的id获取对应二级制，组合返回配对失败：" + e);
          }
        }
      }
    }
    return JSON.toJSONString(list);
  }

  /**
   * 根据数据库存储的id,id格式串，获取mongodb中的文件流，再配对对应组合放到集合中，将集合转成json串返回前端
   *
   * @param scanIdStr id,id格式字符串
   * @return
   */
  public String scanIdStrToMapStr(String scanIdStr) {
    logger.info("scanIdStrToMapStr-Start:" + DateFormatUtil.dateToTimeStr(new Date()));
    Map<String, String> map = new LinkedHashMap<>();
    if (null != scanIdStr && !"".equals(scanIdStr)) {
      String[] scanIdArray = scanIdStr.split(",");
      for (String str : scanIdArray) {
        logger.info(str + ":" + DateFormatUtil.dateToTimeStr(new Date()));
        if (!"".equals(str)) {
          map.put(str, getContent(str));
        }
      }
    }
    logger.info("scanIdStrToMapStr-End:" + DateFormatUtil.dateToTimeStr(new Date()));
    return JSON.toJSONString(map);
  }

  public String getContent(String str) {
    logger.info("getContent-Start:" + DateFormatUtil.dateToTimeStr(new Date()));
    ResultDTO resultDTO =
        attachmentServiceClient.getAttachmentByID(str, FileTypeEnum.PICTURE.getValue());
    if (resultDTO == null || !StatusCodeEnum.OK.getValue().equals(resultDTO.getStatus())) {
      throw new ThrowsException(
          "根据id:" + str + " 和fileType:" + FileTypeEnum.PICTURE.getValue() + " 查询媒体文件微服务出错！");
    }
    AttachmentDTO dto =
        JSONObject.parseObject(JSONObject.toJSONString(resultDTO.getDatas()), AttachmentDTO.class);
    logger.info("getContent-End:" + DateFormatUtil.dateToTimeStr(new Date()));
    return dto.getContent();
  }
}
