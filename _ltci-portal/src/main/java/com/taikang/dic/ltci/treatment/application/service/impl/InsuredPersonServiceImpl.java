package com.taikang.dic.ltci.treatment.application.service.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taikang.dic.ltci.portal.api.model.RestResponseDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.api.model.UserDTO;
import com.taikang.dic.ltci.portal.common.restRequestResponse.RestResponseFormat;
import com.taikang.dic.ltci.portal.common.util.UserUtils;
import com.taikang.dic.ltci.treatment.application.common.ParametersIsNullException;
import com.taikang.dic.ltci.treatment.application.serverClient.InsuredPersonServerClient;
import com.taikang.dic.ltci.treatment.application.service.InsuredPersonService;

/**
 * @author itw_liuxy
 * @description
 * @createTime 2017年3月31日 下午3:31:10
 */
@Service
public class InsuredPersonServiceImpl implements InsuredPersonService {

  private static final Logger logger = LoggerFactory.getLogger(InsuredPersonServiceImpl.class);

  @Autowired private InsuredPersonServerClient insuredPersonServerClient;

  @Value(value = "${spring.application.name}")
  private String systemCode;

  /**
   * 查询参保人信息 1.查询社保局中的参保人信息 2.查询微服务中的参保人信息 3.将社保局中的信息保存到DTO中
   *
   * @param idCard
   * @param insuredPersonName
   * @return
   */
  public ResultDTO getInsuredPerson(String idCard, String insuredPersonName) {
    //首先调用社保局的接口，查询参保人的具体信息，接口未定义？？？
    if (StringUtils.isBlank(idCard) || StringUtils.isBlank(insuredPersonName)) {
      throw new ParametersIsNullException("请求参数不能为空！");
    }
    UserDTO userDTO = UserUtils.getCurrentUser();
    String uniqueNumber = "jingmen";
    String operator = "jingban";

    if (userDTO != null) {
      operator = userDTO.getUserName();
      if (userDTO.getDepartment() != null) {
        uniqueNumber = userDTO.getDepartment().getCode().substring(6);
      }
    }
    RestResponseDTO restResponseDTO =
        insuredPersonServerClient.getInsuredPerson(
            idCard, insuredPersonName, uniqueNumber, operator, systemCode);
    return RestResponseFormat.restResponseDTO2ResultDTO(restResponseDTO);
  }

  public ResultDTO getInsuredPersonDetail(
      String insuredPersonCode, String idCard, String securityNum) {
    RestResponseDTO restResponseDTO =
        insuredPersonServerClient.getInsuredPersonDetail(insuredPersonCode, idCard, securityNum);
    return RestResponseFormat.restResponseDTO2ResultDTO(restResponseDTO);
  }

  @Override
  public void getInsuredPersonExcel(HttpServletRequest request, HttpServletResponse response) {
    HSSFWorkbook wb = new HSSFWorkbook();
    HSSFSheet sheet = wb.createSheet("insuredPerson");
    HSSFRow row = sheet.createRow(0);
    row.createCell(0).setCellValue("姓名");
    row.createCell(1).setCellValue("性别");
    row.createCell(2).setCellValue("民族(例:汉族)");
    row.createCell(3).setCellValue("身份证号码");
    row.createCell(4).setCellValue("社保卡号");
    row.createCell(5).setCellValue("个人编码");
    row.createCell(6).setCellValue("护理对象所属统筹区");
    row.createCell(7).setCellValue("医疗人员类别");
    row.createCell(8).setCellValue("医疗人员类别");
    row.createCell(9).setCellValue("户口性质");
    row.createCell(10).setCellValue("个人身份");

    String excelName = "insuredPerson";
    try {
      ByteArrayOutputStream os = new ByteArrayOutputStream();
      wb.write(os);
      byte[] content = os.toByteArray();
      InputStream is = new ByteArrayInputStream(content);
      response.setContentType("application/zip; charset=utf-8");
      response.reset();
      response.addHeader(
          "Content-Disposition",
          "attachment;filename=\"" + new String((excelName + ".xls").getBytes(), "utf-8") + "\"");
      ServletOutputStream out = response.getOutputStream();
      exportExcel(is, out);
      is.close();
      out.close();
      logger.info("===service层：getInsuredPersonExcel方法结束========");
    } catch (Exception e) {
      logger.debug("下载参保人模板失败", e);
      throw new ParametersIsNullException("下载参保人模板失败");
    }
  }

  private void exportExcel(InputStream is, ServletOutputStream out) throws Exception {
    BufferedInputStream bis = null;
    BufferedOutputStream bos = null;
    bis = new BufferedInputStream(is);
    bos = new BufferedOutputStream(out);
    byte[] buff = new byte[1024];
    int bytesRead;
    while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
      bos.write(buff, 0, bytesRead);
    }

    if (bis != null) {
      bis.close();
    }
    if (bos != null) {
      bos.close();
    }
  };
}
