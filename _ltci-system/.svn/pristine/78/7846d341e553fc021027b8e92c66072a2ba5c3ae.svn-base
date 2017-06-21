package com.taikang.dic.ltci.controller;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.util.Digests;
import com.taikang.dic.ltci.common.util.Encodes;
import com.taikang.dic.ltci.common.util.MoveUserResultConstant;
import com.taikang.dic.ltci.model.OrganizationDO;
import com.taikang.dic.ltci.model.UserDO;
import com.taikang.dic.ltci.service.IOrganizationService;
import com.taikang.dic.ltci.service.IUserService;

/**
 * 移动端登录接口controller
 *
 * @author itw_zhangqh
 */
@RestController
@RequestMapping(path = "${restBasePath}", produces = "application/json;charset=utf-8")
public class MoveLoginController {

  public static final String HASH_ALGORITHM = "MD5";

  public static final int HASH_INTERATIONS = 1024;

  @Autowired private IUserService userService;
  @Autowired private IOrganizationService organizationService;

  private Logger logger = LoggerFactory.getLogger(MoveLoginController.class);

  @RequestMapping(value = "/move/user/token", method = RequestMethod.GET)
  public ResultDTO getToken(String username) {

    ResultDTO result = new ResultDTO();
    result.setStatus(200);
    result.setMessage("OK");
    logger.info("移动端请求获取用户盐值,用户名:" + username);
    List<UserDO> listUser = userService.listUser(username);
    Map<String, String> datas = new HashMap<>();
    if (!CollectionUtils.isEmpty(listUser)) {
      //获取用户
      UserDO userDO = listUser.get(0);
      //从用户密码中截取盐值,并进行hex解码
      String password = userDO.getPassword();
      byte[] salt = Encodes.decodeHex(password.substring(0, 16));
      //将盐值byte数组进行base64编码
      String encodeToString = Base64.getEncoder().encodeToString(salt);
      datas.put(MoveUserResultConstant.SALT, encodeToString);
      //设置用户是否存在的状态
      datas.put(MoveUserResultConstant.STATUS, MoveUserResultConstant.STATUS_Y);
      result.setDatas(datas);
      return result;
    }

    //如果用户不存在就设置用户不存在的标识
    datas.put(MoveUserResultConstant.STATUS, MoveUserResultConstant.STATUS_N);
    result.setDatas(datas);
    return result;
  }

  @RequestMapping(value = "/move/user/check", method = RequestMethod.GET)
  public ResultDTO checkUser(String username, String password) {

    //移动端传过来的是base64编码的加密信息,先进行解码
    byte[] hashPassword = Base64.getDecoder().decode(password);

    ResultDTO result = new ResultDTO();
    result.setStatus(200);
    result.setMessage("OK");

    logger.info("移动端请求校验登录/获取用户信息,用户名:" + username);

    List<UserDO> listUser = userService.listUser(username);
    Map<String, String> datas = new HashMap<>();
    if (!CollectionUtils.isEmpty(listUser)) {
      //获取用户
      UserDO userDO = listUser.get(0);
      String password2 = userDO.getPassword();

      boolean equals =
          password2.equals(password2.substring(0, 16) + Encodes.encodeHex(hashPassword));
      if (equals) {
        String departmentid = userDO.getDepartmentid();
        ResultDTO selectById = organizationService.selectById(departmentid);
        Object datas2 = selectById.getDatas();
        if (datas2 != null) {
          OrganizationDO organizationDO =
              JSONObject.parseObject(JSONObject.toJSONString(datas2), OrganizationDO.class);
          datas.put(MoveUserResultConstant.ORG_NAME, organizationDO.getName());
        }
        if (userDO.getSex() != null) {
          if (userDO.getSex() == 0) {
            datas.put(MoveUserResultConstant.SEX, "未知");
          }
          if (userDO.getSex() == 1) {
            datas.put(MoveUserResultConstant.SEX, "男");
          }
          if (userDO.getSex() == 2) {
            datas.put(MoveUserResultConstant.SEX, "女");
          }
          if (userDO.getSex() == 9) {
            datas.put(MoveUserResultConstant.SEX, "未知");
          }
        } else {
          datas.put(MoveUserResultConstant.SEX, "未知");
        }
        datas.put(MoveUserResultConstant.STATUS, MoveUserResultConstant.STATUS_Y);
        datas.put(MoveUserResultConstant.TELEPHONE, userDO.getTelephone());
        datas.put(MoveUserResultConstant.CALL, userDO.getMobile());
        datas.put(MoveUserResultConstant.EMAIL, userDO.getEmail());
        datas.put(MoveUserResultConstant.USERNAME, userDO.getUserName());
        datas.put(MoveUserResultConstant.TRUENAME, userDO.getTrueName());
        datas.put(MoveUserResultConstant.STAFF_CODE, userDO.getId());
        result.setDatas(datas);
      } else {
        datas.put(MoveUserResultConstant.STATUS, MoveUserResultConstant.STATUS_N);
        result.setDatas(datas);
      }
    }
    return result;
  }
}
