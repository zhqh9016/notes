package com.taikang.dic.ltci.treatment.application.serverClient;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.lang.reflect.InvocationTargetException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.portal.api.model.InsuredPersonDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.common.util.DateFormatUtil;
import com.taikang.dic.ltci.treatment.application.serverClient.InsuredPersonServerClient;

/**
 * @author itw_liuxy
 * @description
 * @createTime 2017年3月31日 上午9:12:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class InsuredPersonServerClientIT {

  private static final Logger logger = LoggerFactory.getLogger(InsuredPersonServerClientIT.class);

  @Autowired private InsuredPersonServerClient insuredPersonServerClient;

  @Test
  @Rollback
  public void testCreateInsuredPerson() {
    //    logger.info("==========testCreateInsuredPerson开始==============");
    //    InsuredPersonDTO personDTO = new InsuredPersonDTO();
    //    personDTO.setInsuredPersonName("李四");
    //    personDTO.setInsuredPersonGender("1");
    //    personDTO.setAddress("北京昌平区史各庄");
    //    personDTO.setAreaCode("123");
    //    personDTO.setBirthday(DateFormatUtil.DateToStr(new Date(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD));
    //    personDTO.setCityCode("123");
    //    personDTO.setEducationid("123");
    //    personDTO.setEmail("123@hotmail.com");
    //    personDTO.setIdCard("371425199108032579");
    //    personDTO.setMarried("1");
    //    personDTO.setNation("123");
    //    personDTO.setOccupationid("123");
    //    personDTO.setOrgName("泰康人寿");
    //    personDTO.setPersonnelIdentityName("公务员");
    //    personDTO.setPersonnelIdentityCode("123");
    //    personDTO.setPoliticsid("123");
    //    personDTO.setProvinceCode("123");
    //    personDTO.setSecurityNumber("3714251991");
    //    personDTO.setSecurityPersonalNumber("123");
    //    personDTO.setMobile("13260199197");
    //
    //    ResultDTO resultDTO = insuredPersonServerClient.createInsuredPerson(personDTO);
    //    logger.info("==========新增返回resultDTO:" + resultDTO.toString() + "==============");
    //
    //    resultDTO =
    //        insuredPersonServerClient.getInsuredPerson(
    //            personDTO.getIdCard(), personDTO.getInsuredPersonName());
    //    logger.info("==========查询返回resultDTO:" + resultDTO.toString() + "==============");
    //    logger.info("==========testCreateInsuredPerson结束==============");
  }

  //  @Test
  //  @Rollback
  //  public void testUpdateInsuredPerson() {
  //        logger.info("==========testUpdateInsuredPerson开始==============");
  //        InsuredPersonDTO personDTO = new InsuredPersonDTO();
  //        personDTO.setInsuredPersonName("李四");
  //        personDTO.setInsuredPersonGender("1");
  //        personDTO.setAddress("北京昌平区史各庄");
  //        personDTO.setAreaCode("123");
  //        DateFormatUtil.DateToStr(new Date(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD)
  //        personDTO.setCityCode("123");
  //        personDTO.setEducationid("123");
  //        personDTO.setEmail("123@hotmail.com");
  //        personDTO.setIdCard("371425199108032579");
  //        personDTO.setMarried("1");
  //        personDTO.setNation("123");
  //        personDTO.setOccupationid("123");
  //        personDTO.setOrgName("泰康人寿");
  //        personDTO.setPersonnelIdentityName("公务员");
  //        personDTO.setPersonnelIdentityCode("123");
  //        personDTO.setPoliticsid("123");
  //        personDTO.setProvinceCode("123");
  //        personDTO.setSecurityNumber("3714251991");
  //        personDTO.setSecurityPersonalNumber("123");
  //        personDTO.setMobile("13260199197");
  //
  //        ResultDTO resultDTO = insuredPersonServerClient.createInsuredPerson(personDTO);
  //        Map<String, Object> map = JSONObject.parseObject(resultDTO.getDatas().toString());
  //        logger.info("==========新增返回map:" + map + "==============");
  //
  //        resultDTO =
  //            insuredPersonServerClient.getInsuredPerson(
  //                personDTO.getIdCard(), personDTO.getInsuredPersonName());
  //        logger.info("==========查询返回resultDTO:" + resultDTO.toString() + "==============");
  //
  //        personDTO = JSONObject.parseObject(resultDTO.getDatas().toString(), InsuredPersonDTO.class);
  //
  //        InsuredPersonDTO dto = new InsuredPersonDTO();
  //        dto.setInsuredPersonid(personDTO.getInsuredPersonid());
  //        dto.setInsuredPersonCode(personDTO.getInsuredPersonCode());
  //        dto.setAddress("中国 北京市 昌平区 史各庄村");
  //        resultDTO = insuredPersonServerClient.updateInsuredPerson(dto);
  //        logger.info("==========修改返回resultDTO:" + resultDTO.toString() + "==============");
  //        logger.info("==========testUpdateInsuredPerson结束==============");
  //  }
  //
  //  @Test
  //  @Rollback
  // public void testGetInsuredPerson() {
  //        logger.info("==========testGetInsuredPerson开始==============");
  //          InsuredPersonDTO personDTO = new InsuredPersonDTO();
  //          personDTO.setInsuredPersonName("李四");
  //          personDTO.setInsuredPersonGender("1");
  //          personDTO.setAddress("北京昌平区史各庄");
  //          personDTO.setAreaCode("123");
  //          personDTO.setBirthday(DateFormatUtil.DateToStr(new Date(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD));
  //        personDTO.setCityCode("123");
  //        personDTO.setEducationid("123");
  //        personDTO.setEmail("123@hotmail.com");
  //        personDTO.setIdCard("371425199108032579");
  //        personDTO.setMarried("1");
  //        personDTO.setNation("123");
  //        personDTO.setOccupationid("123");
  //        personDTO.setOrgName("泰康人寿");
  //        personDTO.setPersonnelIdentityName("公务员");
  //        personDTO.setPersonnelIdentityCode("123");
  //        personDTO.setPoliticsid("123");
  //        personDTO.setProvinceCode("123");
  //        personDTO.setSecurityNumber("3714251991");
  //        personDTO.setSecurityPersonalNumber("123");
  //        personDTO.setMobile("13260199197");
  //
  //        ResultDTO resultDTO = insuredPersonServerClient.createInsuredPerson(personDTO);
  //
  //        logger.info("==========新增返回resultDTO:" + resultDTO.toString() + "==============");
  //
  //        String idCard = personDTO.getIdCard();
  //        String insuredPersonName = personDTO.getInsuredPersonName();
  //
  //        resultDTO = insuredPersonServerClient.getInsuredPerson(idCard, insuredPersonName);
  //        logger.info("==========查询返回resultDTO:" + resultDTO.toString() + "==============");
  //        logger.info("==========testGetInsuredPerson结束==============");
  // }

}
