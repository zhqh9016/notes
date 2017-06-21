package com.taikang.dic.ltci.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.taikang.dic.ltci.api.model.PageResultDTO;
import com.taikang.dic.ltci.common.util.DateFormatUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class MonSetOrgServiceTest {

  @Autowired private IOrgSettlementService orgSettlementService;

  @Test
  public void fun1() {
    //    Date firstDay = DateFormatUtil.getMonthFirstDay("2017-02-12 12:12:12");
    //    Date lastDay = DateFormatUtil.getMonthLastDay("2017-03-12");
    //    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //    System.out.println(format.format(firstDay));
    //    System.out.println(format.format(lastDay));
  }

  @Test
  public void fun2() {
    //    List<Integer> checkFlags = new ArrayList<>();
    //    checkFlags.add(1);
    //    PageResultDTO listMonSetOrg =
    //        orgSettlementService.listMonSetOrg("", "", checkFlags, "", "", 1, 10);
    //    System.out.println(listMonSetOrg);
  }
}
