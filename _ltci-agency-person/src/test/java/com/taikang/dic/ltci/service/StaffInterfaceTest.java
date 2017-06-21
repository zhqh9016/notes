package com.taikang.dic.ltci.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.common.enumeration.ActionTypeEnum;
import com.taikang.dic.ltci.common.enumeration.AgencyStateEnum;
import com.taikang.dic.ltci.model.BaseModel;
import com.taikang.dic.ltci.model.StaffFieldConstant;
import com.taikang.dic.ltci.model.StaffHistoryDO;

/**
 * 人员相关接口测试类
 *
 * @author itw_zhangqh
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class StaffInterfaceTest {

  @Autowired private RabbitTemplate rabbitTemplate;

  @Autowired private IStaffInterfaceService staffInterfaceService;

  /**
   * 模拟专业系统发送人员申请消息
   *
   * @throws IOException
   */
  //  @Test
  public void sendStaffAddRequst() throws IOException {

    JSONObject root = new JSONObject();
    root.put("businessSerialid", BaseModel.getUUID());
    root.put("systemCode", "LCPM");
    root.put("moduleCode", "ltci-agency-person");
    root.put("nodeIP", "10.130.202.62");
    root.put("timestamp", System.currentTimeMillis());
    root.put("messageCode", "LTC_APL_EMP_001");

    JSONObject data = new JSONObject();
    data.put(StaffFieldConstant.ACTIONTYPE, ActionTypeEnum.CREATE.getValue());
    data.put(StaffFieldConstant.EMPCODE, "002");
    //	    data.put(StaffFieldConstant.UNIQUENUMBER,"");
    data.put(StaffFieldConstant.EMPNAME, "lily");
    data.put(StaffFieldConstant.ORGCODE, "798456");
    data.put(StaffFieldConstant.CARDTYPE, "1");
    data.put(StaffFieldConstant.CARDNUMBER, "846583459384777");
    data.put(StaffFieldConstant.GENDER, "1");
    data.put(StaffFieldConstant.HIGHESTEDUCATION, "大学");
    data.put(StaffFieldConstant.ACQUIREDDEGREE, "学士");
    data.put(StaffFieldConstant.CERTIFICATEDATE, "2012-07-01 00:00:00");
    data.put(StaffFieldConstant.JOBSCOPE, "1");
    //    data.put(StaffFieldConstant.PRACTICECERTIFICATENUMBER, "34134");
    //    data.put(StaffFieldConstant.PRACTICELEVEL, "1");
    //    data.put(StaffFieldConstant.PRACTICECERTIFICATEDATE, "2012-07-02 00:00:00");
    //    data.put(StaffFieldConstant.QUALIFICATIONCERTIFICATENUMBER, "4535");
    //    data.put(StaffFieldConstant.QUALIFICATIONLEVEL, "1");
    //    data.put(StaffFieldConstant.QUALIFICATIONCERTIFICATEDATE, "2012-07-03 00:00:00");
    data.put(StaffFieldConstant.COMMENT, "qwer");
    data.put(StaffFieldConstant.OPERATOR, "zhqh");
    data.put(StaffFieldConstant.OPERATINGTIME, "2015-08-01 09:00:00");

    JSONArray credentials = new JSONArray();

    //身份证附件
    String file = "D:/Koala.jpg";
    String file2 = "D:/Lighthouse.jpg";
    String file3 = "D:/Chrysanthemum.jpg";
    FileInputStream fileInputStream = new FileInputStream(file);
    FileInputStream fileInputStream2 = new FileInputStream(file2);
    FileInputStream fileInputStream3 = new FileInputStream(file3);

    JSONObject credential1 = new JSONObject();
    credential1.put(StaffFieldConstant.CREDENTIAL_TYPE, "809");
    credential1.put(StaffFieldConstant.CREDENTIAL_NAME, "身份证");

    byte[] temp = new byte[1048576];

    int read = fileInputStream.read(temp);
    byte[] copyOf = Arrays.copyOf(temp, read);
    JSONArray credential1_files = new JSONArray();
    JSONObject details_first = new JSONObject();
    details_first.put(StaffFieldConstant.FILE_TYPE, "jpg");
    details_first.put(StaffFieldConstant.FILE_NAME, "Koala");
    details_first.put(StaffFieldConstant.ACCESSORY_INFO, copyOf);

    credential1_files.add(details_first);

    int read2 = fileInputStream2.read(temp);
    byte[] copyOf2 = Arrays.copyOf(temp, read2);
    JSONObject details_second = new JSONObject();
    details_second.put(StaffFieldConstant.FILE_TYPE, "jpg");
    details_second.put(StaffFieldConstant.FILE_NAME, "Lighthouse");
    details_second.put(StaffFieldConstant.ACCESSORY_INFO, copyOf2);
    credential1_files.add(details_second);

    credential1.put(StaffFieldConstant.FILE, credential1_files);
    credentials.add(credential1);

    //教师资格证
    JSONObject credential2 = new JSONObject();
    credential2.put(StaffFieldConstant.CREDENTIAL_TYPE, "801");
    credential2.put(StaffFieldConstant.CREDENTIAL_NAME, "护士资格证");
    credential2.put(StaffFieldConstant.CREDENTIAL_CODE, "HSZGZ_001");
    credential2.put(StaffFieldConstant.CREDENTIAL_DATE, new Date());
    credential2.put(StaffFieldConstant.CREDENTIAL_LEVEL, "1");

    int read3 = fileInputStream3.read(temp);
    byte[] copyOf3 = Arrays.copyOf(temp, read3);
    JSONArray credential2_files = new JSONArray();
    JSONObject details2_first = new JSONObject();
    details2_first.put(StaffFieldConstant.FILE_TYPE, "jpg");
    details2_first.put(StaffFieldConstant.FILE_NAME, "Chrysanthemum");
    details2_first.put(StaffFieldConstant.ACCESSORY_INFO, copyOf3);
    credential2_files.add(details2_first);
    credential2.put(StaffFieldConstant.FILE, credential2_files);
    credentials.add(credential2);

    //
    data.put(StaffFieldConstant.CREDENTIALS, credentials);
    root.put("data", data);
    String message = root.toJSONString();
    fileInputStream.close();
    fileInputStream2.close();
    fileInputStream3.close();
    rabbitTemplate.convertAndSend("x.personApply", "jingmen", message.getBytes());
    //	    reconsiderService.getReconsiderReceive(message.getBytes());

  }

  public void fun1() {
    JSONObject data = new JSONObject();
    data.put(StaffFieldConstant.ACTIONTYPE, ActionTypeEnum.CREATE.getValue());
    data.put(StaffFieldConstant.EMPCODE, "001");
    //	    data.put(StaffFieldConstant.UNIQUENUMBER,"");
    data.put(StaffFieldConstant.EMPNAME, "lily");
    data.put(StaffFieldConstant.ORGCODE, "798456");
    data.put(StaffFieldConstant.CARDTYPE, "1");
    data.put(StaffFieldConstant.CARDNUMBER, "846583459384589");
    data.put(StaffFieldConstant.GENDER, "1");
    data.put(StaffFieldConstant.HIGHESTEDUCATION, "大学");
    data.put(StaffFieldConstant.ACQUIREDDEGREE, "学士");
    data.put(StaffFieldConstant.CERTIFICATEDATE, "2012-07-01 00:00:00");
    data.put(StaffFieldConstant.JOBSCOPE, "1");
    data.put(StaffFieldConstant.PRACTICECERTIFICATENUMBER, "34134");
    data.put(StaffFieldConstant.PRACTICELEVEL, "1");
    data.put(StaffFieldConstant.PRACTICECERTIFICATEDATE, "2012-07-02 00:00:00");
    data.put(StaffFieldConstant.QUALIFICATIONCERTIFICATENUMBER, "4535");
    data.put(StaffFieldConstant.QUALIFICATIONLEVEL, "1");
    data.put(StaffFieldConstant.QUALIFICATIONCERTIFICATEDATE, "2012-07-03 00:00:00");
    data.put(StaffFieldConstant.COMMENT, "");
    data.put(StaffFieldConstant.OPERATOR, "");
    data.put(StaffFieldConstant.OPERATINGTIME, "2015-08-01 09:00:00");
  }

  /**
   * 模拟专业系统发起人员变更请求
   *
   * @throws IOException
   */
  //  @Test
  public void sendStaffUpdaeRequst() throws IOException {
    JSONObject root = new JSONObject();
    root.put("businessSerialid", BaseModel.getUUID());
    root.put("systemCode", "LCPM");
    root.put("moduleCode", "ltci-agency-person");
    root.put("nodeIP", "10.130.202.62");
    root.put("timestamp", System.currentTimeMillis());
    root.put("messageCode", "LTC_APL_EMP_001");

    JSONObject data = new JSONObject();
    data.put(StaffFieldConstant.ACTIONTYPE, ActionTypeEnum.UPDATE.getValue());
    data.put(StaffFieldConstant.EMPCODE, "001");
    //	    data.put(StaffFieldConstant.UNIQUENUMBER,"");
    data.put(StaffFieldConstant.EMPNAME, "lily000");
    data.put(StaffFieldConstant.ORGCODE, "798456");
    data.put(StaffFieldConstant.CARDTYPE, "1");
    data.put(StaffFieldConstant.CARDNUMBER, "846583459384589");
    data.put(StaffFieldConstant.GENDER, "1");
    data.put(StaffFieldConstant.HIGHESTEDUCATION, "大学");
    data.put(StaffFieldConstant.ACQUIREDDEGREE, "学士");
    data.put(StaffFieldConstant.CERTIFICATEDATE, "2012-07-01 00:00:00");
    data.put(StaffFieldConstant.JOBSCOPE, "1");
    data.put(StaffFieldConstant.PRACTICECERTIFICATENUMBER, "34134");
    data.put(StaffFieldConstant.PRACTICELEVEL, "1");
    data.put(StaffFieldConstant.PRACTICECERTIFICATEDATE, "2012-07-02 00:00:00");
    data.put(StaffFieldConstant.QUALIFICATIONCERTIFICATENUMBER, "4535");
    data.put(StaffFieldConstant.QUALIFICATIONLEVEL, "1");
    data.put(StaffFieldConstant.QUALIFICATIONCERTIFICATEDATE, "2012-07-03 00:00:00");
    data.put(StaffFieldConstant.COMMENT, "qwer");
    data.put(StaffFieldConstant.OPERATOR, "zhqh");
    data.put(StaffFieldConstant.OPERATINGTIME, "2015-08-01 09:00:00");

    root.put("data", data);
    String message = root.toJSONString();
    rabbitTemplate.convertAndSend("x.personApply", "jingmen", message.getBytes());
    //	    reconsiderService.getReconsiderReceive(message.getBytes());
  }

  /** 模拟专业系统发起人员注销请求 */
  //	@Test
  public void sendStaffDeleteRequest() {}

  /** 模拟专业系统人员申请受理结果告知接收 */
  //	@Test
  public void receiveStaffAcceptResult() {}

  /** 模拟专业系统人员审核结果告知接收 */
  //	@Test
  public void receiveStaffApproveRequest() {}

  /** 模拟专业系统人员变更结果告知接收 */
  //	@Test
  public void receiveStaffChangeResult() {}

  /** 人员申请受理告知发送 */
  @Test
  public void sendStaffAcceptResult() {

    StaffHistoryDO staffHistory = new StaffHistoryDO();
    staffHistory.setEmpCode("6aecdb9789cb4bf08bde3ac8fbaed468");
    staffHistory.setStaffName("qwerwe");
    staffHistory.setStaffGender(1);
    staffHistory.setCredentialType(1);
    staffHistory.setCredentialNumber("11111111");
    staffHistory.setOperatedTime(new Date());
    staffHistory.setAuditState(AgencyStateEnum.STATE_ACCEPT.getValue());
    //		staffHistory.setAuditState(AgencyStateEnum.STATE_NO_ACCEPT.getValue());
    //		staffHistory.setCause("人员不够,暂时不受理");
    staffInterfaceService.sendAcceptResult(staffHistory);
  }

  /** 人员审核结果告知发送 */
  //	@Test
  public void sendStaffApproveRequest() {
    StaffHistoryDO staffHistory = new StaffHistoryDO();
    staffHistory.setEmpCode("0002");
    staffHistory.setStaffName("qwerwe");
    staffHistory.setStaffGender(1);
    staffHistory.setCredentialType(1);
    staffHistory.setCredentialNumber("11111111");
    staffHistory.setOperatedTime(new Date());
    staffHistory.setAuditState(AgencyStateEnum.STATE_AUDIT.getValue());
    staffHistory.setStaffCode("487162374"); //经办端人员编号
    //		staffHistory.setAuditState(AgencyStateEnum.STATE_NO_AUDIT.getValue());
    //		staffHistory.setCause("人已经够多了,不需要了");
    staffInterfaceService.sendApproveResult(staffHistory);
  }

  /** 人员变更结果告知发送 */
  //	@Test
  public void sendStaffChangeResult() {
    StaffHistoryDO staffHistory = new StaffHistoryDO();
    staffHistory.setEmpCode("0002");
    staffHistory.setOperatedTime(new Date());
    staffHistory.setAuditState(AgencyStateEnum.STATE_AUDIT.getValue());
    //		staffHistory.setAuditState(AgencyStateEnum.STATE_NO_AUDIT.getValue());
    //		staffHistory.setCause("不允许修改,审核不通过");
    staffInterfaceService.sendChangeApproveResult(staffHistory);
  }

  @Test
  public void fun() {}
}
