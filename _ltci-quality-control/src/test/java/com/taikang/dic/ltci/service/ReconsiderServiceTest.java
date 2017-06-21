package com.taikang.dic.ltci.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.common.enumeration.ModuleCodeEnum;
import com.taikang.dic.ltci.common.util.DateFormat;
import com.taikang.dic.ltci.common.util.DateFormatUtil;
import com.taikang.dic.ltci.common.util.IPUtil;
import com.taikang.dic.ltci.model.BaseModel;
import com.taikang.dic.ltci.mqmodel.AppealReconsiderModel;
import com.taikang.dic.ltci.mqmodel.MqBaseModel;
import com.taikang.dic.ltci.mqmodel.ReplyReconsiderModel;

/**
 * 申诉复议测试类
 *
 * @author itw_muwg
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ReconsiderServiceTest {

  private static final Logger logger = LoggerFactory.getLogger(ReconsiderServiceTest.class);

  @Autowired IReconsiderService reconsiderService;

  @Autowired private AmqpTemplate rabbitTemplate;

  //    @Test
  public void putReconsiderInfo() throws IOException {

    JSONObject root = new JSONObject();
    root.put("businessSerialid", BaseModel.getUUID());
    root.put("systemCode", "LCPM");
    root.put("moduleCode", "ltci-quality-control");
    root.put("nodeIP", "10.130.202.62");
    root.put("timestamp", System.currentTimeMillis());
    root.put("messageCode", "LTC_HQA_PAT_002");

    JSONObject data = new JSONObject();
    data.put(AppealReconsiderModel.SER_NUM, BaseModel.getUUID());
    data.put(AppealReconsiderModel.PATROL_TASK_ID, "dda16db7f44ba60528e3826be4");
    data.put(AppealReconsiderModel.RECON_APPLICANT, "zhangqh");
    data.put(AppealReconsiderModel.RECON_APPLICANT_PHONE, "15219574082");
    data.put(AppealReconsiderModel.RECON_DATE, "2017-05-02 11:11:11");
    data.put(AppealReconsiderModel.RECON_CONTENT, "这个结果不公平，巡查员太武断了2222！");
    //    //附件
    String file = "D:/Lighthouse.jpg";
    String file2 = "D:/Lighthouse.jpg";
    FileInputStream fileInputStream = new FileInputStream(file);
    FileInputStream fileInputStream2 = new FileInputStream(file2);

    byte[] temp = new byte[10485760];
    int read = fileInputStream.read(temp);
    byte[] copyOf = Arrays.copyOf(temp, read);
    JSONArray additions = new JSONArray();
    JSONObject details_first = new JSONObject();
    details_first.put(AppealReconsiderModel.ADDITION_TYPE, "mp4");
    details_first.put(AppealReconsiderModel.ADDITION_INFO, copyOf);
    details_first.put(AppealReconsiderModel.ADDITION_INFO_ID, BaseModel.getUUID());
    additions.add(details_first);
    int read2 = fileInputStream2.read(temp);
    byte[] copyOf2 = Arrays.copyOf(temp, read2);
    JSONObject details_second = new JSONObject();
    details_second.put(AppealReconsiderModel.ADDITION_TYPE, "mp4");
    details_second.put(AppealReconsiderModel.ADDITION_INFO, copyOf2);
    details_second.put(AppealReconsiderModel.ADDITION_INFO_ID, BaseModel.getUUID());
    additions.add(details_second);

    data.put(AppealReconsiderModel.ADDITIONS, additions);
    root.put("data", data);
    String message = root.toJSONString();
    rabbitTemplate.convertAndSend("x.appealReconsider", "jingmen", message.getBytes());
    fileInputStream.close();
    fileInputStream2.close();
    //            reconsiderService.getReconsiderReceive(message.getBytes());
  }

  //  @Test
  public void recevive() {
    String body = null;
    while (true) {
      Message message = rabbitTemplate.receive("q.test-3");
      if (message != null) {
        byte[] bytes = message.getBody();
        try {
          body = new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
          logger.error("解析数据异常", e);
        }
        System.out.println(body);
      }
    }
  }

  @Test
  public void test3() {}

  //    @Test
  public void sendResult() {

    //转换成接口参数
    ReplyReconsiderModel model = new ReplyReconsiderModel();
    model.setSerialNumber(BaseModel.getUUID());
    model.setPatrolTaskId(BaseModel.getUUID());
    model.setFeedbackDate(DateFormatUtil.dateToTimeStr(new Date()));
    model.setFeedbackContent("联调测试6");
    model.setContactPhone("13223451111");
    model.setContact("zhangsan");
    //构建公共mq接口规范
    MqBaseModel mqBaseModel = new MqBaseModel();
    mqBaseModel.setBusinessSerialid(BaseModel.getUUID());
    mqBaseModel.setTimestamp(DateFormat.getLocalDateTime());
    try {
      mqBaseModel.setNodeIP(IPUtil.getLocalIp());
    } catch (Exception e) {
      logger.error("获取本地IP失败：" + e);
    }
    mqBaseModel.setSystemCode("LCPM");
    mqBaseModel.setModuleCode(ModuleCodeEnum.SEND_APPEAL_RESULT.getValue());
    mqBaseModel.setMessageCode("LTC_HQA_PAT_003");
    mqBaseModel.setData(model);
    String jsonString = JSONObject.toJSONString(mqBaseModel);
    //发送至mq routingKey 是 “jingmen”,不是queryName
    logger.info(jsonString);
    rabbitTemplate.convertAndSend("x.appealResult", "jingmen", jsonString);
  }

  //  @Test
  @Transactional
  public void test2() {
    String message =
        "{'businessSerialid':'66b527101dc844a8b9bad5a962cdefb8','moduleCode':'ltci-quality-control','data':{'reconsiderationDate':'2017-05-02 11:11:11','serialNumber':'ed9fee105fee49b8ac53f27348f788a5','reconsiderationApplicantPhone':'15219574082','patrolTaskId':'dedc0ec8f38a4e99bd5582e158e8e852','additions':[{'additionalInfoType':1,'additionalInfo':'5oiR5piv5Luj6KGo5Zu+54mH','additionalInfoID':'07f3a15268eb4e428e16759abb054975'},{'additionalInfoType':2,'additionalInfo':'5oiR5piv5Luj6KGo6KeG6aKR','additionalInfoID':'7239509269704c7ea8481c4c8bf8d2e7'}],'reconsiderationApplicant':'zhangqh','reconsiderationContent':'这个结果不公平，巡查员太武断了！'},'systemCode':'LCPM','nodeIP':'10.130.202.62','messageCode':'LTC_HQA_PAT_002','timestamp':1493890122267}";
    reconsiderService.parseMessage(message);
  }
}
