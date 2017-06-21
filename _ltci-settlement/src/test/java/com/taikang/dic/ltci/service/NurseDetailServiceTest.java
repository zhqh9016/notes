package com.taikang.dic.ltci.service;

import java.security.SecureRandom;
import java.math.BigDecimal;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.common.ConstantUtil;
import com.taikang.dic.ltci.common.util.DateFormatUtil;
import com.taikang.dic.ltci.common.util.UUIDUtil;
import com.taikang.dic.ltci.dao.CustomNurseDetailDAO;
import com.taikang.dic.ltci.model.NurseDetailDO;

/**
 * 护理详细服务测试类
 *
 * @author longfei04 E-mail:
 * @version 创建时间：2017年4月13日 下午2:57:47
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class NurseDetailServiceTest {

  private static final Logger logger = LoggerFactory.getLogger(NurseDetailServiceTest.class);

  @Autowired INurseDetailService nurseDetailService;

  @Autowired CustomNurseDetailDAO customNurseDetailDAO;

  /*@Test
  public void takeNurseDetail(){
  	nurseDetailService.receiveMessage();
  }*/

  @Test
  public void putNurseDetail() throws UnsupportedEncodingException {

    JSONObject root = new JSONObject();
    root.put(ConstantUtil.BUSINESS_SERIALID, "e3f34c872d514159b0caa601eb2bd89f");
    root.put(ConstantUtil.SYS_CODE, "LTCS");
    root.put(ConstantUtil.MODULE_CODE, "");
    root.put(ConstantUtil.NODE_IP, "10.130.202.62");
    root.put(ConstantUtil.TIMESTAMP, System.currentTimeMillis());
    root.put(ConstantUtil.MESSAGE_CODE, "");

    JSONObject data = new JSONObject();
    data.put(ConstantUtil.ORG_CODE, "JG100000002");
    data.put(ConstantUtil.ORG_NAME, "泰康人寿保险");
    data.put(ConstantUtil.SEND_TIME, System.currentTimeMillis());
    data.put(ConstantUtil.DETAIL_COUNT, "1");

    JSONArray nersingDetails = new JSONArray();
    JSONObject details_one = new JSONObject();
    details_one.put(ConstantUtil.RECORD_UUID, "f6d8251e8c3548a8a8dd4c6b581f22cb");
    details_one.put(ConstantUtil.SOC_SEC_NUM, "护理对象身份证号码");
    details_one.put(ConstantUtil.BE_CARE_PERSON_NAME, "护理对象姓名");
    details_one.put(ConstantUtil.BE_CARE_PERSON_CARD, "身份证号码");
    details_one.put(ConstantUtil.BUILDING_NO, "楼号");
    details_one.put(ConstantUtil.ROOM_NO, "房间号");
    details_one.put(ConstantUtil.DISEASE_AREA, "病区");
    details_one.put(ConstantUtil.BED_NUM, "床位号");
    details_one.put(ConstantUtil.BE_CARE_PERSON_NAME, "护理对象姓名");
    details_one.put(ConstantUtil.PROJECT_TYPE, "1"); //1药品 2诊疗项目 3服务设施 4 护理项目
    details_one.put(ConstantUtil.CHARGE_TYPE, ""); //费用类别:由社保提供字典值
    /*details_one.put(ConstantUtil.MEDICAL_TYPE, "医疗类别 31 全日居家护理 32 非全日居家护理 33 养老机构护理");*/
    details_one.put(ConstantUtil.MEDICAL_TYPE, "31");
    details_one.put(ConstantUtil.IS_RELATIVE_CARE, 0);
    details_one.put(ConstantUtil.TRADE_NUM, UUIDUtil.getUUID());
    details_one.put(ConstantUtil.MEDICARE_CODE, ""); //医保服务项目编码
    details_one.put(ConstantUtil.MEDICARE_NAME, ""); //医保服务项目名称
    details_one.put(ConstantUtil.CARE_ORG_SERVICE_CODE, "'"); //护理机构服务项目编码
    details_one.put(ConstantUtil.CARE_ORG_SERVICE_NAME, ""); //护理机构服务项目名称
    details_one.put(ConstantUtil.FEE_DATE, "2017-04-18 16:43:27");
    details_one.put(ConstantUtil.PRICE, 7.25);
    details_one.put(ConstantUtil.COUNT, 2.01);
    details_one.put(ConstantUtil.AMOUNT, 14.5);
    details_one.put(ConstantUtil.MAN_HOUR, "7");
    details_one.put(ConstantUtil.NURSE_CODE, "护理人员编码");
    details_one.put(ConstantUtil.NURSE_NAME, "护理人员名称");
    details_one.put(ConstantUtil.NURSE_TIME, "2017-04-18");
    details_one.put(ConstantUtil.CHARGE_PERSON_CODE, "上帐人编码");
    details_one.put(ConstantUtil.CHARGE_PERSON_NAME, "上帐人名称");
    details_one.put(ConstantUtil.CHARGE_DEPT_CODE, "上帐科室编码");

    nersingDetails.add(details_one);
    data.put(ConstantUtil.NURSING_DETAILS, nersingDetails);
    root.put(ConstantUtil.DATA, data);
    String message = root.toJSONString();
    // nurseDetailService.receiveMessage(message.getBytes("utf-8"));
    // nurseDetailService.receiveMessage(message.getBytes("utf-8"));
    //    nurseDetailService.putNurseDetailMessage(message);
    // nurseDetailService.receiveMessage(message.getBytes("utf-8"));
  }

  @Test
  public void countDaySetPer() throws ParseException {
    //    for (int n = 2011; n < 2017; n++) {
    //
    //      //    	  int[] year = {2011,2012,2013};
    //      //    	  int[] mouth = {1,2,3,4,5,6,7,8,9,10,11,12};
    //      for (int j = 1; j < 13; j++) {
    //        nurseDetailService.countDaySetPer(
    //            null, DateFormatUtil.strToDate(n + "-" + j + "-04", "yyyy-MM-dd"), "ac111");
    //      }
    //    }
  }

  /** 费用明细构建测试数据 */
  //  @Test
  public void uploadDetailToThirdParty() {
    //    String feiDate = "2017-01-02";
    //    int sysnStatus = 0;
    //    String orgCode = "123123";
    //    nurseDetailService.uploadDetailToThirdParty(feiDate, sysnStatus, orgCode);
  }

  @Test
  public void sdf() {
    //    String feiDate = "2017-01-02";
    //    int sysnStatus = 0;
    //    String orgCode = "123123";
    //    nurseDetailService.uploadDetailToOrg(feiDate, sysnStatus, orgCode);
  }

  @Test
  public void createNurseDetail() {
    //
    //    SecureRandom random = new SecureRandom();
    //    for (int n = 2011; n < 2017; n++) {
    //
    //      //    	  int[] year = {2011,2012,2013};
    //      //    	  int[] mouth = {1,2,3,4,5,6,7,8,9,10,11,12};
    //      for (int j = 1; j < 13; j++) {
    //
    //        for (int i = 1; i < 5; i++) {
    //          NurseDetailDO nurseDetail = new NurseDetailDO();
    //          nurseDetail.setId(UUIDUtil.getUUID());
    //          nurseDetail.setTradeNum(UUIDUtil.getUUID());
    //
    //          //人的信息
    //          //          		  nurseDetail.setInRecorduuid("b842eba7b48441baa7dd28937a2ac8a4");
    //          //          		  nurseDetail.setBeCarePersonCard("123456");
    //          //          		  nurseDetail.setSocSecNum("123456");
    //          //          		  nurseDetail.setCardType(0);
    //          //          		  nurseDetail.setBeCarePersonName("kitty");
    //
    //          nurseDetail.setInRecorduuid("b842eba7b48441baa7dd28937a2ac800");
    //          nurseDetail.setBeCarePersonCard("371521199202167800");
    //          nurseDetail.setSocSecNum("371521199022167800");
    //          nurseDetail.setCardType(0);
    //          nurseDetail.setBeCarePersonName("lucy");
    //
    //          //机构信息
    //          nurseDetail.setOrgCode("ac000");
    //          nurseDetail.setOrgName("金门市人民医院");
    //
    //          int randomYear = random.nextInt(3);
    //          int randomMonth = random.nextInt(12);
    //
    //          //费用发生日期
    //          //          nurseDetail.setFeeDate(DateFormatUtil.strToDate(year[randomYear]+"-0"+mouth[randomMonth]+"-02 20:59:59"));
    //          //          nurseDetail.setNurseTime(DateFormatUtil.strToDate(year[randomYear]+"-0"+mouth[randomMonth]+"-02 20:59:59"));
    //          nurseDetail.setFeeDate(DateFormatUtil.strToDate(n + "-" + j + "-04 20:59:59"));
    //          nurseDetail.setNurseTime(DateFormatUtil.strToDate(n + "-" + j + "-04 20:59:59"));
    //          nurseDetail.setBuildingNo("b101");
    //          nurseDetail.setMedicalType("33");
    //          nurseDetail.setIsSynForSocial(1);
    //          nurseDetail.setIsSysForOrg(1);
    //          nurseDetail.setIsValid(1);
    //          nurseDetail.setChargeType("4");
    //          nurseDetail.setNurseCode("n001");
    //          nurseDetail.setNurseName("nurse001");
    //          int m = random.nextInt(3);
    //          switch (m) {
    //            case 0:
    //              //护理项目信息
    //              nurseDetail.setMedicareCode("fw000");
    //              nurseDetail.setMedicareName("洗漱");
    //              nurseDetail.setCareOrgServiceCode("careOrg000");
    //              nurseDetail.setCareOrgServiceName("洗漱");
    //              nurseDetail.setCount(2);
    //              nurseDetail.setPrice(BigDecimal.valueOf(500));
    //              nurseDetail.setAmount(BigDecimal.valueOf(1000));
    //              //费用信息
    //              nurseDetail.setNurseTotalAmount(BigDecimal.valueOf(1000));
    //              nurseDetail.setSiPay(BigDecimal.valueOf(700));
    //              nurseDetail.setPaySelf(BigDecimal.valueOf(300));
    //              break;
    //            case 1:
    //              nurseDetail.setMedicareCode("fw001");
    //              nurseDetail.setMedicareName("翻身");
    //              nurseDetail.setCareOrgServiceCode("careOrg001");
    //              nurseDetail.setCareOrgServiceName("翻身");
    //              nurseDetail.setCount(2);
    //              nurseDetail.setPrice(BigDecimal.valueOf(500));
    //              nurseDetail.setAmount(BigDecimal.valueOf(1000));
    //              //费用信息
    //              nurseDetail.setNurseTotalAmount(BigDecimal.valueOf(1000));
    //              nurseDetail.setSiPay(BigDecimal.valueOf(700));
    //              nurseDetail.setPaySelf(BigDecimal.valueOf(300));
    //              break;
    //            case 2:
    //              nurseDetail.setMedicareCode("fw002");
    //              nurseDetail.setMedicareName("洗头");
    //              nurseDetail.setCareOrgServiceCode("careOrg002");
    //              nurseDetail.setCareOrgServiceName("洗头");
    //              nurseDetail.setCount(2);
    //              nurseDetail.setPrice(BigDecimal.valueOf(500));
    //              nurseDetail.setAmount(BigDecimal.valueOf(1000));
    //              //费用信息
    //              nurseDetail.setNurseTotalAmount(BigDecimal.valueOf(1000));
    //              nurseDetail.setSiPay(BigDecimal.valueOf(700));
    //              nurseDetail.setPaySelf(BigDecimal.valueOf(300));
    //              break;
    //
    //            default:
    //              nurseDetail.setMedicareCode("fw003");
    //              nurseDetail.setMedicareName("喂药");
    //              nurseDetail.setCareOrgServiceCode("careOrg003");
    //              nurseDetail.setCareOrgServiceName("喂药");
    //              nurseDetail.setCount(2);
    //              nurseDetail.setPrice(BigDecimal.valueOf(500));
    //              nurseDetail.setAmount(BigDecimal.valueOf(1000));
    //              //费用信息
    //              nurseDetail.setNurseTotalAmount(BigDecimal.valueOf(1000));
    //              nurseDetail.setSiPay(BigDecimal.valueOf(700));
    //              nurseDetail.setPaySelf(BigDecimal.valueOf(300));
    //              break;
    //          }
    //          nurseDetailService.insertSelective(nurseDetail);
    //        }
    //      }
    //    }
  }
}
