package com.taikang.dic.ltci.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.taikang.dic.ltci.dao.AgencyStaffUnionSpecDAO;
import com.taikang.dic.ltci.model.StaffHistoryDO;
import com.taikang.dic.ltci.model.StaffHistoryUnionExample;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class SpecTest {
  @Autowired AgencyStaffUnionSpecDAO agencyStaffUnionSpecDAO;

  @Test
  public void test1() {
    StaffHistoryUnionExample map = new StaffHistoryUnionExample();
    map.setActionType("01");
    map.setBeginNum(0);
    map.setEndNum(10);
    List<String> list = new ArrayList<String>();
    list.add("1");
    list.add("3");
    map.setAuditState(list);
    //    map.setAgencyName("张三");
    //    map.setStaffName("123");
    //    List<String> list = new ArrayList<String>();
    //    list.add("1");
    //    map.setAgencyLevel(list.toArray());
    //    map.setIsAgencyLevel(true);
    //    map.setIsBetweenOne(true);
    //    map.setBeginTime(new Date());
    //    int i = agencyStaffUnionSpecDAO.countByExample(map);
    //    System.out.println(i);
    List<StaffHistoryDO> list1 = agencyStaffUnionSpecDAO.selectByExample(map);
    System.out.println(list1);
  }
}
