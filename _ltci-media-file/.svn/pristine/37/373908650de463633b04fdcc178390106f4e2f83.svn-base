package com.taikang.dic.ltci.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.taikang.dic.ltci.api.model.AttachmentDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.model.AttachmentDO;
import com.taikang.dic.ltci.service.AttachmentService;

@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class AttachmentController {

  @Autowired private AttachmentService attachmentService;

  private static final Logger logger = LoggerFactory.getLogger(AttachmentController.class);

  @RequestMapping(value = "/attachment", method = RequestMethod.POST)
  public ResultDTO addAttachment(@RequestBody AttachmentDTO dto) {
    logger.info(
        "开始----根据fileName:"
            + dto.getFileName()
            + "，fileType："
            + dto.getFileType()
            + "和suffix:"
            + dto.getSuffix()
            + "新增附件信息...");

    ResultDTO resultDTO = new ResultDTO();
    AttachmentDO attachmentDO = new AttachmentDO();
    BeanUtils.copyProperties(dto, attachmentDO);
    String id = attachmentService.insert(attachmentDO);
    Map<String, String> map = new HashMap<>();
    map.put("attachmentid", id);
    resultDTO.setStatus(StatusCodeEnum.CREATED.getValue());
    resultDTO.setDatas(map);
    resultDTO.setMessage("附件保存成功！");

    logger.info(
        "结束----根据fileName:"
            + dto.getFileName()
            + "，fileType："
            + dto.getFileType()
            + "和suffix:"
            + dto.getSuffix()
            + "新增附件信息...");

    return resultDTO;
  }

  @RequestMapping(value = "/attachment/{id}/{fileType}", method = RequestMethod.DELETE)
  public ResultDTO deleteAttachment(@PathVariable String id, @PathVariable String fileType) {

    logger.info("开始----根据id:" + id + "和fileType：" + fileType + "删除附件信息...");

    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setStatus(StatusCodeEnum.CREATED.getValue());
    resultDTO.setDatas(attachmentService.delete(id, fileType));
    resultDTO.setMessage("附件删除成功！");

    logger.info("结束----根据id:" + id + "和fileType：" + fileType + "删除附件信息...");

    return resultDTO;
  }

  @RequestMapping(value = "/attachment/{id}/{fileType}", method = RequestMethod.GET)
  public ResultDTO getAttachmentByID(@PathVariable String id, @PathVariable String fileType) {
    logger.info("开始----根据id:" + id + "和fileType：" + fileType + "查询附件信息...");

    AttachmentDO attachmentDO = attachmentService.selectByID(id, fileType);
    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setStatus(StatusCodeEnum.OK.getValue());
    resultDTO.setDatas(attachmentDO);
    resultDTO.setMessage("附件查询成功！");

    logger.info("结束----根据id:" + id + "和fileType：" + fileType + "查询附件信息...");
    return resultDTO;
  }

  @RequestMapping(value = "/attachment/{id}/{fileType}/{isOriginal}", method = RequestMethod.GET)
  public ResultDTO getAttachmentByID(
      @PathVariable String id, @PathVariable String fileType, @PathVariable String isOriginal) {
    logger.info(
        "开始----根据id:" + id + "，fileType：" + fileType + "和isOriginal：" + isOriginal + "查询附件信息...");

    AttachmentDO attachmentDO = attachmentService.selectByID(id, fileType, isOriginal);
    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setStatus(StatusCodeEnum.OK.getValue());
    resultDTO.setDatas(attachmentDO);
    resultDTO.setMessage("附件查询成功！");

    logger.info(
        "结束----根据id:" + id + "，fileType：" + fileType + "和isOriginal：" + isOriginal + "查询附件信息...");
    return resultDTO;
  }

  /**
   * 查询图片附件的原图信息
   *
   * @param id
   * @return
   */
  @RequestMapping(value = "/attachment/originalPicture/{id}", method = RequestMethod.GET)
  public ResultDTO getOriginalPicture(@PathVariable String id) {
    logger.info("开始----根据id:" + id + "查询图片原图信息...");
    AttachmentDO attachmentDO = attachmentService.getOriginalPicture(id);
    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setStatus(StatusCodeEnum.OK.getValue());
    resultDTO.setDatas(attachmentDO);
    resultDTO.setMessage("附件查询成功！");
    logger.info("结束----根据id:" + id + "查询图片原图信息...");
    return resultDTO;
  }
}
