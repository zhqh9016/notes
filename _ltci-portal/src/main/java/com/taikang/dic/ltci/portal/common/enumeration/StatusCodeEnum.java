package com.taikang.dic.ltci.portal.common.enumeration;

/**
 * 状态码枚举类
 *
 * @author itw_liuxy
 * @description
 * @createTime 2017年4月6日 上午10:41:44
 */
public enum StatusCodeEnum {
  OK(200, "服务器成功返回用户请求数据"),
  CREATED(201, "[POST/PUT]:服务器成功返回用户请求数据"),
  NO_CONTENT(204, "[DELETE]:删除数据成功，但没有数据返回，浏览器不用刷新，不用向导新页面"),
  UNAUTHORIZED(401, "授权失败,用户没有权限访问该资源"),
  NOT_FOUND(404, "[*]：发出的请求针对的是不存在的资源，服务器没有进行操作"),
  UNAUTHENTICATED(403, "未认证的请求,需要先登录"),
  NOT_ACCEPTABLE(406, "[GET]：请求的格式不可得或请求参数为空"),
  INTERNAL_SERVER_ERROR(500, "[*]：服务器发生错误，用户将无法判断发出的请求是否成功");

  private Integer value;

  private String desc;

  private StatusCodeEnum(Integer value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  public Integer getValue() {
    return value;
  }

  public String getDesc() {
    return desc;
  }
}
