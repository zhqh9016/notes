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

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.api.model.AgencyDTO;
import com.taikang.dic.ltci.api.model.AgencyHistoryDTO;
import com.taikang.dic.ltci.common.enumeration.AgencyStateEnum;
import com.taikang.dic.ltci.common.util.DateFormatUtil;
import com.taikang.dic.ltci.model.BaseModel;

/**
 * 申诉复议测试类
 *
 * @author itw_muwg
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class AgencyInterfaceServiceTest {

  private static final Logger logger = LoggerFactory.getLogger(AgencyInterfaceServiceTest.class);

  @Autowired IAgencyInterfaceService agencyInterfaceService;

  @Autowired private AmqpTemplate rabbitTemplate;

  //    @Test
  public void putAgencyInfo() throws IOException {

    JSONObject root = new JSONObject();
    root.put("businessSerialid", BaseModel.getUUID());
    root.put("systemCode", "LCPM");
    root.put("moduleCode", "ltci-agency-person");
    root.put("nodeIP", "10.136.24.11");
    root.put("timestamp", System.currentTimeMillis());
    root.put("messageCode", "LTC_APL_ORG_001");

    JSONObject data = new JSONObject();
    data.put("actionType", "1"); //"操作类型（1:新增、2:变更；变更时只传有变化的项目值)",
    data.put("orgCode", BaseModel.getUUID()); //"机构编号（专业服务系统内部编号)",
    data.put("uniqueNumber", ""); //监管唯一认证ID，由经办生成，新增时为空,变更时必传
    data.put("orgName", "测试附件护理机构6"); //机构名称
    data.put("provinceCode", "143000"); //"所在省份编码"
    data.put("cityCode", "143020"); //"所在城市编码"
    data.put("areaCode", "143021"); //"所在区县编码
    data.put("agencyAddressDetail", "荆门市，丈八北路22号"); //"机构详细地址",
    data.put("orgLevel", "1"); //机构类别（单选）(1、一级及以上医疗机构;2、养老、护理机构;3、社区卫生服务中心;4、乡镇卫生院;99、其他)"
    data.put("orgServiceType", "2"); //"定点服务机构类型(多选)(1、居家护理;2、养老机构护理;3、医院护理)",
    data.put("orgType", "00"); //"机构类型(00、护理;10、评估)"
    data.put("orgServiceContact", "赵云"); //长期护理服务业务负责人
    data.put("orgContactPhone", "13888888888"); //长期护理服务业务负责人
    data.put("orgContactEmail", "zhaoy@163.com"); //"长期护理联系人邮箱",
    data.put("practiceLicense", "9999999999"); //"执业许可证号"
    data.put(
        "ownershipForm", "1"); //"所有制形式（1、国有企业;2、中外合资企业;3、外商独资企业;4、合伙企业;5、有限责任公司;6、有限股份公司;7、个人企业）",
    data.put("legalRepresentative", "刘备"); //"法人代表"
    data.put("legalPhone", "13777777777"); //"法人电话"
    data.put("legalIdCard", "623111198811042879"); //"法人身份证号"
    data.put("constructionArea", 3000.88); //长护区建筑面积
    data.put("orgBedNum", 200); //床位数
    data.put("advancedDoctorNum", 25); //高级执业医师数
    data.put("intermediateDoctorNum", 35); //中级执业医师数
    data.put("primaryDoctorNum", 45); //初级执业医师数
    data.put("advancedNurseNum", 45); //高级执业护士数
    data.put("intermediateNurseNum", 55); //中级执业护士数
    data.put("primaryNurseNum", 65); //初级执业护士数
    data.put("advancedCarerNum", 20); //高级执业护理员数
    data.put("intermediateCarerNum", 30); //中级执业护理员数
    data.put("primaryCarerNum", 40); //初级执业护理员数
    data.put("advancedMiscNum", 50); //高级其他人员数
    data.put("intermediateMiscNum", 60); //中级其他人员数
    data.put("primaryMiscNum", 70); //初级其他人员数
    data.put("operator", "马超"); //申请人
    data.put("operatingTime", "2017-05-19 14:00:59"); //申请日期

    //    //附件
    String file = "C:/Users/Public/Pictures/Sample Pictures/5785bcf8N0537ce9e.jpg";
    String file2 = "C:/Users/Public/Pictures/Sample Pictures/e13d8ab43198.jpg";
    String file3 = "C:/Users/Public/Pictures/Sample Pictures/579abff5Ne4ae877b.jpg";
    String file4 = "C:/Users/Public/Pictures/Sample Pictures/5763c34aN445acd80.jpg";
    String file5 = "C:/Users/Public/Pictures/Sample Pictures/5785bd09Nccc13612.jpg";
    String file6 = "C:/Users/Public/Pictures/Sample Pictures/5785bd03Nc380fa4a.jpg";
    FileInputStream fileInputStream = new FileInputStream(file);
    FileInputStream fileInputStream2 = new FileInputStream(file2);
    FileInputStream fileInputStream3 = new FileInputStream(file3);
    FileInputStream fileInputStream4 = new FileInputStream(file4);
    FileInputStream fileInputStream5 = new FileInputStream(file5);
    FileInputStream fileInputStream6 = new FileInputStream(file6);

    byte[] temp = new byte[10485760];
    int read = fileInputStream.read(temp);
    byte[] copyOf = Arrays.copyOf(temp, read);
    JSONArray accessory = new JSONArray();
    JSONObject details_first = new JSONObject();
    details_first.put(
        "accessory_type", "1"); //"附件类型（1:执业许可证、2法人身份证、3:单位职工花名册、4:房屋产权证书或租赁合同、5:社保缴费证明、6:其他材料）",
    details_first.put("accessory_info", copyOf); //附件内容byte类型
    details_first.put("file_name", "执业证书"); //附件名称
    details_first.put("file_type", "jpg"); //文件类型（存文件后缀，如jpg/png）
    accessory.add(details_first);

    int read2 = fileInputStream2.read(temp);
    byte[] copyOf2 = Arrays.copyOf(temp, read2);
    JSONObject details_second = new JSONObject();
    details_second.put("accessory_type", "2");
    details_second.put("accessory_info", copyOf2);
    details_second.put("file_name", "法人身份证");
    details_second.put("file_type", "jpg");
    accessory.add(details_second);

    int read3 = fileInputStream3.read(temp);
    byte[] copyOf3 = Arrays.copyOf(temp, read3);
    JSONObject details_3 = new JSONObject();
    details_3.put("accessory_type", "3");
    details_3.put("accessory_info", copyOf3);
    details_3.put("file_name", "职工花名册");
    details_3.put("file_type", "jpg");
    accessory.add(details_3);

    int read4 = fileInputStream4.read(temp);
    byte[] copyOf4 = Arrays.copyOf(temp, read4);
    JSONObject details_4 = new JSONObject();
    details_4.put("accessory_type", "4");
    details_4.put("accessory_info", copyOf4);
    details_4.put("file_name", "租赁合同");
    details_4.put("file_type", "jpg");
    accessory.add(details_4);

    int read5 = fileInputStream5.read(temp);
    byte[] copyOf5 = Arrays.copyOf(temp, read5);
    JSONObject details_5 = new JSONObject();
    details_5.put("accessory_type", "5");
    details_5.put("accessory_info", copyOf5);
    details_5.put("file_name", "社保缴费证明");
    details_5.put("file_type", "jpg");
    accessory.add(details_5);

    int read6 = fileInputStream6.read(temp);
    byte[] copyOf6 = Arrays.copyOf(temp, read6);
    JSONObject details_6 = new JSONObject();
    details_6.put("accessory_type", "6");
    details_6.put("accessory_info", copyOf6);
    details_6.put("file_name", "其它材料");
    details_6.put("file_type", "jpg");
    accessory.add(details_6);

    data.put("accessory", accessory);

    root.put("data", data);
    String message = root.toJSONString();
    //    rabbitTemplate.convertAndSend("x.orgApply", "jingmen", message.getBytes());
    agencyInterfaceService.getorgApplication(message.getBytes());
    fileInputStream.close();
    fileInputStream2.close();
    fileInputStream3.close();
    fileInputStream4.close();
    fileInputStream5.close();
    fileInputStream6.close();
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

  //  @Test
  public void sendOrgAcceptResult() {
    AgencyHistoryDTO agency = new AgencyHistoryDTO();
    agency.setAgencyState(AgencyStateEnum.STATE_NO_ACCEPT.getValue());
    agency.setOrgCode(BaseModel.getUUID());
    agency.setOperatedTime(DateFormatUtil.dateToTimeStr(new Date()));
    agency.setCause("资料不全！");
    agencyInterfaceService.sendOrgAcceptResult(agency);
  }

  //  @Test
  public void sendOrgApproveResult() {
    AgencyDTO agency = new AgencyDTO();
    agency.setAgencyState(AgencyStateEnum.STATE_AUDIT.getValue());
    agency.setOrgCode(BaseModel.getUUID());
    agency.setAgencyCode(BaseModel.getUUID());
    agency.setOperatedTime(DateFormatUtil.dateToTimeStr(new Date()));
    //	  agency.setRejectionReason("资料不全！");
    agency.setSecretKey("mysecret");
    agency.setKeyBeginDate("2017-05-10 00:00:01");
    agency.setKeyEndDate("2018-05-10 23:59:59");
    agencyInterfaceService.sendOrgApproveResult(agency);
  }
  //  @Test
  public void sendOrgChangeResult() {
    AgencyDTO agency = new AgencyDTO();
    agency.setAgencyState(AgencyStateEnum.STATE_NO_AUDIT.getValue());
    agency.setOrgCode(BaseModel.getUUID());
    agency.setAgencyCode(BaseModel.getUUID());
    agency.setOperatedTime(DateFormatUtil.dateToTimeStr(new Date()));
    agency.setRejectionReason("资料不全！");
    agencyInterfaceService.sendOrgChangeResult(agency);
  }

  @Test
  public void test() {}
}
