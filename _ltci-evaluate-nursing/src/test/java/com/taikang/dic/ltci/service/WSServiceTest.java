package com.taikang.dic.ltci.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.common.ws.ChanghuCard;
import com.taikang.dic.ltci.common.ws.ErrorReason;
import com.taikang.dic.ltci.common.ws.NurseInInfo;
import com.taikang.dic.ltci.common.ws.NurseOutInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class WSServiceTest {

  private static final Logger logger = LoggerFactory.getLogger(WSServiceTest.class);

  @Autowired WSService wsService;

  @Test
  public void registNurseInfo() {
    //	  NurseInInfo registRequest = new NurseInInfo();
    //      registRequest.setBedNum("123");
    //      registRequest.setDepartment("123");
    //      registRequest.setDiseaseCode("123");
    //      registRequest.setDiseaseName("123");
    //      registRequest.setInRecorduuid("123");
    //      registRequest.setMedicalRecord("123");
    //      registRequest.setMedicalType("123");
    //      registRequest.setOperator("123");
    //      registRequest.setRealInDate("123");
    //
    //      ChanghuCard changhuCard = new ChanghuCard();
    //      changhuCard.setPSAMCardNum("123");
    //      changhuCard.setSCardNo("123");
    //      changhuCard.setSCardType("123");
    //      changhuCard.setSIDNo("123");
    //      changhuCard.setSName("123");
    //
    //      wsService.registNurseInfo(registRequest, changhuCard);
    //
    //	ErrorReason errorReason = wsService.registNurseInfo(registRequest, changhuCard);
    //	logger.debug("registNurseInfo=" + JSONObject.toJSONString(errorReason));
  }
  //
  //    @Test
  //    public void getNurseOutInfo(){
  //    	NurseOutInfo nurseOutInfo = new NurseOutInfo();
  //        nurseOutInfo.setBedNum("123");
  //
  //        nurseOutInfo.setCareType("0");
  //        nurseOutInfo.setDepartment("123");
  //        nurseOutInfo.setInRecorduuid("123");
  //        nurseOutInfo.setOperator("123");
  //        nurseOutInfo.setOutReason("123");
  //        nurseOutInfo.setRealOutDate("123");
  //        nurseOutInfo.setRxInfo("123");
  //
  //	ErrorReason errorReason = wsService.getNurseOutInfo(nurseOutInfo );
  //  	  logger.debug("getNurseOutInfo=" + JSONObject.toJSONString(errorReason));
  //    }

}
