package com.taikang.dic.ltci.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.taikang.dic.ltci.api.model.ResultDTO;

/**
 * 公共服务接口服务接口
 *
 * @author huodd
 * @date 创建时间：2017年6月20日
 */
public interface CommonService {

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
      String interfaceName);
}
