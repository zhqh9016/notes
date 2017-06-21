package com.taikang.dic.ltci.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.util.DateFormatUtil;
import com.taikang.dic.ltci.common.util.IPUtil;
import com.taikang.dic.ltci.dao.RClientorgSiAreaDAO;
import com.taikang.dic.ltci.dao.WhiteListDAO;
import com.taikang.dic.ltci.model.RClientorgSiAreaDOExample;
import com.taikang.dic.ltci.model.WhiteListDOExample;
import com.taikang.dic.ltci.service.CommonService;

/**
 * 公共服务接口服务接口
 *
 * @author huodd
 * @date 创建时间：2017年6月20日
 */
@Service
public class CommonServiceImpl implements CommonService {
  private static final Logger logger = LoggerFactory.getLogger(CommonServiceImpl.class);

  @Autowired private WhiteListDAO whiteListDAO;

  @Autowired private RClientorgSiAreaDAO rClientorgSiAreaDAO;

  @Value("${ltci.interface.request.times}")
  private Long times; //次数

  /**
   * 1、接口白名单校验 2、参数有效性校验 3、接口当天调用次数校验
   *
   * @param clientCode
   * @param siArea
   * @param agencyCode
   * @param request
   * @param interfaceName
   * @return
   */
  public ResultDTO checkInterfaceIsValid(
      String clientCode,
      String siArea,
      String agencyCode,
      HttpServletRequest request,
      String interfaceName) {
    ResultDTO dto = new ResultDTO();
    dto.setStatus(500);
    String ip = IPUtil.getRemoteHost(request);
    logger.debug("____checkInterfaceIsValid_ip=" + ip);
    if (StringUtils.isEmpty(ip)) {
      dto.setMessage("请求端ip获取失败");
      return dto;
    } else {
      if (!ipIsValid(ip)) {
        dto.setMessage("您没有权限调用本接口");
        return dto;
      }
    }
    if (StringUtils.isEmpty(clientCode)) {
      dto.setMessage("clientCode不能为空");
      return dto;
    }
    if (StringUtils.isEmpty(siArea)) {
      dto.setMessage("siArea不能为空");
      return dto;
    } else {
      if (!siAreaIsValid(clientCode, siArea)) {
        dto.setMessage("您没有查询本统筹区数据的权限");
        return dto;
      }
    }
    //校验接口调用次数，按天算：一天不能超过配置的数量
    if (isOverstepResTimes(request, interfaceName)) {
      dto.setMessage("今日接口调用已超过上限次数" + times);
      return dto;
    }
    return null;
  }
  /**
   * 校验接口调用次数
   *
   * @param interfaceName
   * @return
   */
  private boolean isOverstepResTimes(HttpServletRequest request, String interfaceName) {
    ServletContext application = request.getServletContext();
    Object obj = application.getAttribute(interfaceName);
    logger.debug(
        "____isOverstepResTimes_="
            + interfaceName
            + "_application.getAttribute(interfaceName)="
            + obj);
    if (obj == null) {
      Map<String, Long> map = new HashMap<String, Long>();
      map.put("addTime", new Date().getTime());
      map.put("times", 1L);
      application.setAttribute(interfaceName, map);
    } else {
      @SuppressWarnings("unchecked")
      Map<String, Long> map = (HashMap<String, Long>) obj;
      Long addTime = map.get("addTime");
      //校验时间,有效期当天
      String strA = DateFormatUtil.dateToStr(new Date(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD);
      String strB =
          DateFormatUtil.dateToStr(new Date(addTime), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD);
      Date dateA = DateFormatUtil.strToDate(strA, DateFormatUtil.DATE_FORMAT_YYYY_MM_DD);
      Date dateB = DateFormatUtil.strToDate(strB, DateFormatUtil.DATE_FORMAT_YYYY_MM_DD);
      Calendar c = Calendar.getInstance();
      c.setTime(dateB);
      c.add(Calendar.DAY_OF_YEAR, 1);
      dateB = c.getTime();
      if (dateB.equals(dateA) || dateB.before(dateA)) { //如果存的时间超过一天（自然天），则重新赋值
        map.put("addTime", new Date().getTime());
        map.put("times", 1L);
      } else {
        //校验请求次数
        Long ltimes = map.get("times");
        if (times <= ltimes) {
          return true;
        }
        map.put("times", ltimes + 1);
      }
      application.setAttribute(interfaceName, map);
    }
    return false;
  }
  //	public static void main(String[] sdf){
  //		String strA = "2017-06-20";
  //		String strB = "2017-06-21";
  //		Date dateA = DateFormatUtil.strToDate(strA, DateFormatUtil.DATE_FORMAT_YYYY_MM_DD);
  //		Date dateB = DateFormatUtil.strToDate(strB, DateFormatUtil.DATE_FORMAT_YYYY_MM_DD);
  //		Calendar c =Calendar.getInstance();
  //		c.setTime(dateB);
  //		c.add(Calendar.DAY_OF_YEAR,1);
  //		dateB=c.getTime();
  //		System.out.println(dateB.equals(dateA) || dateB.before(dateA));
  //	}
  /**
   * 统筹区是否有权限
   *
   * @param siArea
   * @return
   */
  private boolean siAreaIsValid(String clientCode, String siAreas) {
    String[] arr = siAreas.split(",");
    List<String> list = new ArrayList<String>();
    for (String str : arr) {
      list.add(str);
    }
    RClientorgSiAreaDOExample example = new RClientorgSiAreaDOExample();
    example
        .createCriteria()
        .andIsValidEqualTo(1)
        .andClientCodeEqualTo(clientCode)
        .andSiAreaIn(list);
    return rClientorgSiAreaDAO.selectByExample(example).size() >= 1;
  }
  /**
   * 根据ip获取有效的白名单列表
   *
   * @param ip
   * @return
   */
  private boolean ipIsValid(String ip) {
    WhiteListDOExample example = new WhiteListDOExample();
    example.createCriteria().andIsValidEqualTo(1).andIpAddrEqualTo(ip);
    return whiteListDAO.selectByExample(example).size() >= 1;
  }
}
