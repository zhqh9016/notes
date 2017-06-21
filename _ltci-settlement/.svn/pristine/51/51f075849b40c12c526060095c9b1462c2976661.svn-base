package com.taikang.dic.ltci.service;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.common.ws.InsuredInfo;
import com.taikang.dic.ltci.common.ws.TreatmentState;
import com.taikang.dic.ltci.configration.WSConfig;
import com.taikang.dic.ltci.model.NurseDetailDO;
import com.taikang.dic.ltci.model.ServiceItemDO;

/**
 * 护理项目服务测试类
 *
 * @author liyh01 E-mail:
 * @version 创建时间：2017年4月13日 下午4:57:47
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class WSConfigTest {

  private static final Logger logger = LoggerFactory.getLogger(WSConfigTest.class);

  @Autowired WSConfig config;
  @Autowired WSService wsService;

  /** 护理费用明细与日结算结果查询 */
  //  @Test
  public void getNurseFeeDetailAndCalaResult() {

    //        LongtermCareService longtermCaseService = config.longtermCaseService();
    //        //logger.debug("_____________longtermCaseService=" + longtermCaseService);
    //        NurseAmount ddo = new NurseAmount();
    //        ddo.setInRecorduuid("uuid");
    //        ddo.setProjectType("1");
    //        ddo.setChargeType("1");
    //        ddo.setCareOrgServiceCode("010101");
    //        ddo.setMedicareCode("1111");
    //        ddo.setCareOrgServiceName("测试处方号");
    //        ddo.setPrice("1.00");
    //        ddo.setCount("1");
    //        ddo.setNurseName("张三");
    //        ddo.setOperator("李四");
    //        ddo.setBuildingNo("1楼");
    //        ddo.setRoomNo("001号");
    //        ddo.setIsRelativeCare("");
    //        ddo.setNurseTime(String.valueOf(new Date().getTime()));
    //        ddo.setDiseaseArea("1");
    //        ddo.setBedNum("1");
    //        ddo.setRxDate(String.valueOf(new Date().getTime()));
    //        ddo.setRxNum("1234323");
    //        ddo.setSendTimestamp(String.valueOf(new Date().getTime()));
    //
    //        NurseAmountDetail detail1 = longtermCaseService.getNurseAmountDetail(ddo);
    //        logger.debug( "__________getNurseAmountDetail="+JSONObject.toJSONString(detail1));

    NurseDetailDO detail = new NurseDetailDO();
    detail.setInRecorduuid("111231231");
    detail.setProjectType("1");
    detail.setChargeType("1");
    detail.setCareOrgServiceCode("12312");
    ;
    detail.setCareOrgServiceName("test");
    detail.setMedicareCode("12322");
    detail.setPrice(new BigDecimal(1));
    detail.setCount(1.00);
    detail.setNurseName("护理");
    detail.setOperatedBy("操作");
    detail.setBuildingNo("213");
    detail.setRoomNo("123");
    detail.setIsRelativeCare(1);
    detail.setNurseTime(new Date());
    detail.setDiseaseArea("2122");
    detail.setBedNum("22");
    detail.setCreatedTime(new Date());
    detail.setTradeNum("123324324");
    NurseDetailDO tdo = wsService.getNurseFeeDetailAndCalaResult(detail);
    logger.debug("__________getNurseFeeDetailAndCalaResult=" + JSONObject.toJSONString(tdo));
  }

  /** 参保人信息查询 */
  @Test
  public void selectInsuredInfo() {
    //    	  InsuredInfo ret = wsService.selectInsuredInfo("13040619881019275X", "霍丁丁");
    //    	  logger.debug("__________selectInsuredInfo="+ JSONObject.toJSONString(ret));
  }

  /** * 长护待遇状态查询 */
  @Test
  public void selectApplicationStatus() {
    //    	  TreatmentState ret = wsService.selectApplicationStatus("13040619881019275X", "霍丁丁");
    //    	  logger.debug( "__________selectApplicationStatus="+JSONObject.toJSONString(ret));
  }

  /** 服务项目推送接口 */
  @Test
  public void pushServiceProject() {
    ServiceItemDO serviceItemDo = new ServiceItemDO();
    serviceItemDo.setId("1");
    // 服务项目编码
    serviceItemDo.setServiceCode("SI001");
    // 服务项目类型
    serviceItemDo.setServiceType(101);
    // 服务项目名称
    serviceItemDo.setServiceName("排泄护理");
    // 费用类别
    serviceItemDo.setChargeType("11");
    // 收费项目等级
    serviceItemDo.setChargeLevel("1");
    // 服务频次
    serviceItemDo.setFrequency("1-4次/日");
    // 服务项目持续时间
    serviceItemDo.setTaskTime("15-30分钟");
    // 服务项目内涵
    serviceItemDo.setDescription("根据护理对象病情和自理能力，选择轮椅、助行器、拐杖等不同的移动工具，协助老人如厕。");
    // 生效开始时间
    serviceItemDo.setStartTime(new Date());
    // 生效结束时间
    serviceItemDo.setEndTime(new Date());
    // 单价
    serviceItemDo.setPrice(new BigDecimal(20.0));
    // 最高限价
    serviceItemDo.setLimitPrice(new BigDecimal(30.0));
    // 统筹区
    serviceItemDo.setSiArea("北京市");
    // 经办人
    serviceItemDo.setOperatedBy("泰康");
    // 经办日期
    serviceItemDo.setOperatedTime(new Date());
    // 是否删除
    serviceItemDo.setIsValid(1);
    //    	 wsService.pushServiceProject(serviceItemDo);
  }
}
