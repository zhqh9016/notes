package com.taikang.dic.ltci.portal;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.treatment.application.model.SocialSecurity;

/**
 * 测试fastjson的使用
 *
 * @author itw_zhangqh
 */
public class FastJsonTest {

  /*
   * fastjson
   */
  @Test
  public void fun1() {

    SocialSecurity obj = new SocialSecurity();
    obj.setAge("12");
    obj.setIdCard("7384336");

    //由对象转成json串
    String jsonString = JSONObject.toJSONString(obj);
    System.out.println(jsonString);

    //由json串转成对象
    SocialSecurity parseObject = JSONObject.parseObject(jsonString, SocialSecurity.class);
    System.out.println(parseObject);
  }
}
