package com.taikang.dic.ltci.service;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.taikang.dic.ltci.api.model.OrgSettlementDTO;
import com.taikang.dic.ltci.api.model.PageResultDTO;
import com.taikang.dic.ltci.common.util.DateFormatUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class OrgSettlementTest {
  @Autowired IOrgSettlementService settlementService;

  //  @Test
  public void test1() {
    OrgSettlementDTO dto = new OrgSettlementDTO();
    dto.setFeeStarttime("2017-04-01");
    dto.setFeeEndtime("2017-04-30");
    //    dto.setOrgName("北京");
    PageResultDTO countOrgData = settlementService.countOrgData(dto, 1, 10);
    System.out.println(countOrgData.getDatas());
  }

  @Test
  public void test() {}

  public static void main(String[] args) {
    String dateToStr = DateFormatUtil.dateToStr(new Date(), "yyyyMMdd HH:mm:ss SSS");
    Date strToDate = DateFormatUtil.strToDate(dateToStr, "yyyyMMdd HH:mm:ss SSS");
    System.out.println(dateToStr);
    System.out.println(strToDate);
  }
}
