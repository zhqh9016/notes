package com.taikang.dic.ltci.quality.control.service.impl;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.portal.api.model.AttachmentDTO;
import com.taikang.dic.ltci.portal.api.model.ExecuteResultDTO;
import com.taikang.dic.ltci.portal.api.model.RExecuteFileDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.api.model.UserDTO;
import com.taikang.dic.ltci.portal.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.portal.common.util.Encodes;
import com.taikang.dic.ltci.portal.common.util.FileTypeDecideUtil;
import com.taikang.dic.ltci.portal.common.util.UserUtils;
import com.taikang.dic.ltci.portal.serverClient.AttachmentServiceClient;
import com.taikang.dic.ltci.quality.control.service.PatrolTaskExecuteService;
import com.taikang.dic.ltci.quality.control.serviceClient.PatrolTaskExecuteServiceClient;
import com.taikang.dic.ltci.treatment.application.common.ThrowsException;

@Service
public class PatrolTaskExecuteServiceImpl implements PatrolTaskExecuteService {

  private static final Logger logger = LoggerFactory.getLogger(PatrolTaskExecuteServiceImpl.class);

  @Value(value = "${spring.application.name}")
  private String systemCode;

  @Value(value = "${systemCharset}")
  private String systemCharset;

  @Autowired private PatrolTaskExecuteServiceClient taskExecuteClient;

  @Autowired private AttachmentServiceClient attachmentServiceClient;

  @Override
  public ResultDTO uploadPatrolTaskExecute(MultipartFile file) {
    ResultDTO resultDTO = null;
    try {
      String fileName = file.getOriginalFilename();
      logger.debug("上传附件文件名为：" + fileName);
      if (file.isEmpty()) {
        throw new ThrowsException("上传失败：附件信息不能为空！");
      }
      long size = file.getSize();
      if (size > 1024 * 1024 * 4) {
        throw new ThrowsException("上传失败：附件大小不能超过4MB！");
      }
      logger.info("文件：" + fileName + " 的Size：" + size);
      String suffix = fileName.substring(fileName.lastIndexOf('.') + 1);
      String fileType = FileTypeDecideUtil.getFileType(suffix);
      if (StringUtils.isEmpty(fileType)) {
        throw new ThrowsException("上传失败：暂不支持上传" + suffix + "类型的附件！");
      }

      //将File文件转换为Base64字符串
      byte[] byteFile = file.getBytes();
      String base64 = Encodes.encodeBase64(byteFile);
      AttachmentDTO dto = new AttachmentDTO();
      dto.setContent(base64);
      dto.setFileType(fileType);
      dto.setFileName(fileName);
      dto.setSuffix(suffix);

      resultDTO = attachmentServiceClient.addAttachment(dto);
      if (resultDTO == null || !resultDTO.getStatus().equals(StatusCodeEnum.CREATED.getValue())) {
        throw new ThrowsException("调用媒体文件微服务端保存文件失败！");
      }
    } catch (IOException e) {
      logger.error("错误信息： " + e);
      throw new ThrowsException("上传失败：文件转换为Bytes失败！");
    }
    return resultDTO;
  }

  @Override
  public ResultDTO deleteExecuteFile(String fileId, String suffix) {
    String fileType = FileTypeDecideUtil.getFileType(suffix);
    return attachmentServiceClient.deleteAttachment(fileId, fileType);
  }

  @Override
  public ResultDTO createPatrolTaskExecute(ExecuteResultDTO executeResultDto) {
    UserDTO userInfo = UserUtils.getCurrentUser();
    if (userInfo != null) {
      executeResultDto.setCreatedBy(userInfo.getTrueName());
      executeResultDto.setCreatedOrg(userInfo.getDepartment().getCode());
      executeResultDto.setOperatedBy(userInfo.getTrueName());
      executeResultDto.setOperatedOrg(userInfo.getDepartment().getCode());
    }
    ResultDTO taskResult =
        taskExecuteClient.getPatrolTaskResultByTaskId(
            executeResultDto.getPatrolTaskId(), systemCode);
    if (!StatusCodeEnum.OK.getValue().equals(taskResult.getStatus())) {
      for (RExecuteFileDTO fileDto : executeResultDto.getExecuteFile()) {
        attachmentServiceClient.deleteAttachment(
            fileDto.getFileId(), FileTypeDecideUtil.getFileType(fileDto.getFileType()));
      }
      return taskResult;
    }
    return taskExecuteClient.createPatrolTaskExecute(executeResultDto, systemCode);
  }

  @Override
  public ResultDTO getPatrolTaskExecuteFile(String patrolTaskId) {
    return taskExecuteClient.getPatrolTaskExecuteFile(patrolTaskId, systemCode);
  }

  @Override
  public void getMongoDBMessage(
      RExecuteFileDTO executeFileDto, HttpServletRequest request, HttpServletResponse response) {
    String fileType = FileTypeDecideUtil.getFileType(executeFileDto.getFileType());
    ResultDTO resultDTO =
        attachmentServiceClient.getAttachmentByID(executeFileDto.getFileId(), fileType);
    if (resultDTO == null || !StatusCodeEnum.OK.getValue().equals(resultDTO.getStatus())) {
      throw new ThrowsException(
          "根据id:" + executeFileDto.getFileId() + " 和fileType:" + fileType + " 查询媒体文件微服务出错！");
    }
    String fileName = executeFileDto.getFileName();
    try {
      AttachmentDTO dto =
          JSONObject.parseObject(
              JSONObject.toJSONString(resultDTO.getDatas()), AttachmentDTO.class);
      videoDownload(request, response, Encodes.decodeBase64(dto.getContent()), fileName);
    } catch (IOException e) {
      logger.error("错误信息： " + e);
    }
  }

  private void videoDownload(
      HttpServletRequest request, HttpServletResponse response, byte[] data, String diskfilename)
      throws IOException {
    // 取头参数
    String range = request.getHeader("range");
    String browser = request.getHeader("User-Agent");
    if (browser.indexOf("Firefox") != -1) {
      // 火狐浏览器
      response.setContentType("video/ogg");
      response.setContentLength(data.length);
      response.setHeader(
          "Content-Disposition",
          "attachment; filename=\"" + URLEncoder.encode(diskfilename, "utf-8") + "\"");
      response.setHeader("Content-Range", range + Integer.valueOf(data.length - 1));
      response.setHeader("Accept-Ranges", "bytes");
      response.setHeader("Etag", "W/\"9767057-1323779115364\"");
      byte[] content = new byte[1024];
      BufferedInputStream is = new BufferedInputStream(new ByteArrayInputStream(data));
      OutputStream os = response.getOutputStream();
      while (is.read(content) != -1) {
        os.write(content);
      }
      is.close();
      os.close();
    } else if (browser.indexOf("MSIE") != -1) {
      // IE9以上浏览器
      response.setContentType("video/mpeg");
      // response.setContentType("application/octet-stream");
      response.setHeader(
          "Content-Disposition",
          "attachment; filename=\"" + URLEncoder.encode(diskfilename, "utf-8") + "\"");
      response.setContentLength(data.length);
      response.setHeader("Content-Range", range + Integer.valueOf(data.length - 1));
      response.setHeader("Accept-Ranges", "text/x-dvi");
      response.setHeader("Etag", "W/\"9767057-1323779115364\"");
      byte[] content = new byte[1024];
      BufferedInputStream is = new BufferedInputStream(new ByteArrayInputStream(data));
      OutputStream os = response.getOutputStream();
      while (is.read(content) != -1) {
        os.write(content);
      }
      is.close();
      os.close();
    } else if (browser.indexOf("Chrome") != -1) {
      // 谷歌浏览器
      response.setContentType("video/mp4");
      // response.setContentType("application/octet-stream");
      response.setHeader(
          "Content-Disposition",
          "attachment; filename=\"" + URLEncoder.encode(diskfilename, "utf-8") + "\"");
      System.out.println("data.length " + data.length);
      response.setContentLength(data.length);
      response.setHeader("Content-Range", range + Integer.valueOf(data.length - 1));
      response.setHeader("Accept-Ranges", "bytes");
      response.setHeader("Etag", "W/\"9767057-1323779115364\"");
      byte[] content = new byte[1024];
      BufferedInputStream is = new BufferedInputStream(new ByteArrayInputStream(data));
      OutputStream os = response.getOutputStream();
      while (is.read(content) != -1) {
        os.write(content);
      }
      is.close();
      os.close();
    } else if (browser.indexOf("CoreMedia") != -1) {
      // 其他浏览器
      response.setContentType("video/mpeg");
      response.setHeader(
          "Content-Disposition",
          "attachment; filename=\"" + URLEncoder.encode(diskfilename, "utf-8") + "\"");
      byte[] content = new byte[1024];
      BufferedInputStream is = new BufferedInputStream(new ByteArrayInputStream(data));
      OutputStream os = response.getOutputStream();
      while (is.read(content) != -1) {
        os.write(content);
      }
      is.close();
      os.close();
    }
  }
}
