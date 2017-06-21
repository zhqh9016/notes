package com.taikang.dic.ltci.portal.common.log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.taikang.dic.ltci.portal.api.model.RoleDTO;
import com.taikang.dic.ltci.portal.api.model.UserDTO;
import com.taikang.dic.ltci.portal.common.enumeration.RolesEnum;
import com.taikang.dic.ltci.portal.common.util.UserUtils;

public class ThreadLocalUtil {

  private ThreadLocalUtil() {
    super();
  }

  public static final ThreadLocal<LogBO> threadLocal = new ThreadLocal<>();

  public static String getTimestamp() {
    SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd HH:mm:ss SSS");
    return fmt.format(new Date());
  }

  public static String getBusinessSerialid() {
    return UUID.randomUUID().toString().replace("-", "");
  }

  public static String getOperatedOrg() {
    UserDTO currentUser = UserUtils.getCurrentUser();
    String operatedOrg = null;
    if (currentUser == null) {
      operatedOrg = "";
    } else {
      if (currentUser.getDepartment() != null) {
        operatedOrg = currentUser.getDepartment().getCode();
      } else {
        operatedOrg = "";
      }
      List<RoleDTO> roles = currentUser.getRole();
      if (!roles.isEmpty()) {
        for (RoleDTO role : roles) {
          if (RolesEnum.City_Admin.getValue().equals(role.getRoleCode())) { //代表是市级角色
            operatedOrg = "";
          }
        }
      }
    }
    return operatedOrg;
  }
}
