package com.taikang.dic.ltci.system.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.api.model.UserDTO;
import com.taikang.dic.ltci.portal.api.model.UserPushDTO;
import com.taikang.dic.ltci.portal.api.model.UserPushResultDTO;
import com.taikang.dic.ltci.portal.common.enumeration.IsAuthorityEnum;
import com.taikang.dic.ltci.portal.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.portal.common.enumeration.ThirdInterfaceLogEnum;
import com.taikang.dic.ltci.portal.common.exception.TKCheckedException;
import com.taikang.dic.ltci.portal.common.util.UserUtils;
import com.taikang.dic.ltci.portal.model.ThirdInterfaceLogDO;
import com.taikang.dic.ltci.portal.service.impl.ScheduleServiceImpl;
import com.taikang.dic.ltci.system.common.ConstantUtil;
import com.taikang.dic.ltci.system.common.enumeration.PushUserActionTypeEnum;
import com.taikang.dic.ltci.system.common.enumeration.PushUserStateCodeEnum;
import com.taikang.dic.ltci.system.serverClient.UserPushServerClient;
import com.taikang.dic.ltci.system.serverClient.UserServerClient;
import com.taikang.dic.ltci.system.service.UserService;
import com.taikang.dic.ltci.treatment.application.common.NotFoundByIdException;

@Service
public class UserServiceImpl implements UserService {

  private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

  @Autowired private UserServerClient userServerClient;

  @Autowired private UserPushServerClient userPushServerClient;

  @Value(value = "${spring.application.name}")
  private String systemCode;

  @Value(value = "${user.push.cityId}")
  private String cityId;

  @Autowired private ScheduleServiceImpl scheduleExecuteServiceImpl;

  /** 按条件分页查询用户列表 */
  @Override
  public PageResultDTO listUser(UserDTO userDto, String roleCode, int page, int pageSize) {
    return userServerClient.listUser(
        userDto.getUserName(), userDto.getDepartmentid(), roleCode, page, pageSize, systemCode);
  }

  /** 新增用户 */
  @Override
  public ResultDTO createUser(UserDTO userDto) {
    ResultDTO result = new ResultDTO();
    try {
      // 用户名输入验证
      if (StringUtils.isEmpty(userDto.getUserName())) {
        result.setStatus(500);
        result.setMessage("请输入用户名");
        return result;
      }
      // 真实姓名输入验证
      if (StringUtils.isEmpty(userDto.getTrueName())) {
        result.setStatus(500);
        result.setMessage("请输入真实姓名");
        return result;
      }
      // 部门输入验证
      if (StringUtils.isEmpty(userDto.getDepartmentid())) {
        result.setStatus(500);
        result.setMessage("请选择部门");
        return result;
      }
      // 手机号输入验证
      if (StringUtils.isEmpty(userDto.getMobile())) {
        result.setStatus(500);
        result.setMessage("请输入手机号");
        return result;
      }
      // 生成密码
      userDto.setPassword(UserUtils.entryptPassword(ConstantUtil.USER_DEFAULT));
      // 获取当前登录用户信息
      UserDTO userInfo = UserUtils.getCurrentUser();
      logger.debug("_current_userInfo=" + userInfo);
      if (userInfo != null) {
        // 创建人
        userDto.setCreatedBy(userInfo.getTrueName());
        // 创建机构
        if (userDto.getDepartment() != null) {
          userDto.setCreatedOrg(userInfo.getDepartment().getCode());
        }
      }
      result = userServerClient.createUser(userDto, systemCode);
      if (StatusCodeEnum.OK.getValue().equals(result.getStatus())
          && userDto.getIsAuthority().equals(IsAuthorityEnum.YES.getValue())) {
        // 向大数据推送用户信息(新增)
        UserPushDTO userPushDto = new UserPushDTO();
        userPushDto.setUsername(userDto.getUserName());
        userPushDto.setPwd(userDto.getPassword());
        userPushDto.setCityid(cityId);
        userPushDto.setType(PushUserActionTypeEnum.CREATE.getValue());
        UserPushResultDTO pushUserResultDto = userPushServerClient.pushUser(userPushDto);
        logger.debug("_pushUser=" + pushUserResultDto);
        thirdInterfaceLog(userPushDto, pushUserResultDto);
      }
    } catch (TKCheckedException e) {
      logger.error("_current_userInfo", e);
      throw new NotFoundByIdException(e.getMessage());
    }
    return result;
  }

  /** 根据用户名精确查询 */
  @Override
  public ResultDTO listUser(String userName) {
    logger.debug("_listUser_userName=" + userName);
    return userServerClient.listUser(userName, systemCode);
  }

  /** 修改用户信息 */
  @Override
  public ResultDTO updateUser(UserDTO userDto) {
    ResultDTO result = new ResultDTO();
    // 真实姓名输入验证
    if (StringUtils.isEmpty(userDto.getTrueName())) {
      result.setStatus(500);
      result.setMessage("请输入真实姓名");
      return result;
    }
    // 部门输入验证
    if (StringUtils.isEmpty(userDto.getDepartmentid())) {
      result.setStatus(500);
      result.setMessage("请选择部门");
      return result;
    }
    // 手机号输入验证
    if (StringUtils.isEmpty(userDto.getMobile())) {
      result.setStatus(500);
      result.setMessage("请输入手机号");
      return result;
    }
    // 获取当前登录用户信息
    UserDTO userInfo = UserUtils.getCurrentUser();
    if (userInfo != null) {
      // 经办人
      userDto.setOperatedBy(userInfo.getTrueName());
      // 经办机构
      if (userDto.getDepartment() != null) {
        userDto.setOperatedOrg(userInfo.getDepartment().getCode());
      }
    }
    return userServerClient.updateUser(userDto, systemCode);
  }

  /** 根据ID查询用户信息 */
  @Override
  public ResultDTO getUser(String id) {
    return userServerClient.getUser(id, systemCode);
  }

  /** 重置密码 */
  @Override
  public ResultDTO resetPassword(UserDTO userDto) {
    try {
      // 生成密码
      userDto.setPassword(UserUtils.entryptPassword(ConstantUtil.USER_DEFAULT));
      // 获取当前登录用户信息
      UserDTO userInfo = UserUtils.getCurrentUser();
      if (userInfo != null) {
        // 经办人
        userDto.setOperatedBy(userInfo.getTrueName());
        // 经办机构
        if (userDto.getDepartment() != null) {
          userDto.setOperatedOrg(userInfo.getDepartment().getCode());
        }
      }
    } catch (TKCheckedException e) {
      logger.error("_resetPassword", e);
      throw new NotFoundByIdException(e.getMessage());
    }
    return userServerClient.updateUser(userDto, systemCode);
  }

  /** 删除用户 */
  @Override
  public ResultDTO deleteUser(String id) {
    ResultDTO result = new ResultDTO();
    // 获取当前登录用户信息
    UserDTO userInfo = UserUtils.getCurrentUser();
    UserDTO userDto = new UserDTO();
    if (userInfo != null) {
      // 判断欲删除用户是否是当前登录用户
      if (id.equals(userInfo.getId())) {
        throw new NotFoundByIdException("当前登录用户不可删除！");
      }
      userDto.setOperatedBy(userInfo.getTrueName());
      if (userDto.getDepartment() != null) {
        userDto.setOperatedOrg(userInfo.getDepartment().getCode());
      }
      ResultDTO resultDto = userServerClient.getUser(id, systemCode);
      UserDTO userDelete =
          JSONObject.parseObject(JSONObject.toJSONString(resultDto.getDatas()), UserDTO.class);
      result = userServerClient.deleteUser(id, userDto, systemCode);
      if (StatusCodeEnum.OK.getValue().equals(result.getStatus())
          && userDelete.getIsAuthority().equals(IsAuthorityEnum.YES.getValue())) {
        // 向大数据推送用户信息(删除)
        UserPushDTO userPushDto = new UserPushDTO();
        userPushDto.setUsername(userDelete.getUserName());
        userPushDto.setPwd(userDelete.getPassword());
        userPushDto.setCityid(cityId);
        userPushDto.setType(PushUserActionTypeEnum.DELETE.getValue());
        UserPushResultDTO pushUserResultDto = userPushServerClient.pushUser(userPushDto);
        thirdInterfaceLog(userPushDto, pushUserResultDto);
      }
    }
    return result;
  }

  /** 用户修改登录密码 */
  @Override
  public ResultDTO amendPassword(String oldPassword, String newPassword) {
    UserDTO userDto = new UserDTO();
    ResultDTO result = new ResultDTO();
    try {
      // 获取当前登录用户信息
      UserDTO userInfo = UserUtils.getCurrentUser();
      // 校验原密码是否正确
      if (UserUtils.validatePassword(oldPassword, userInfo.getPassword())) {
        userDto.setId(userInfo.getId());
        // 生成密码
        userDto.setPassword(UserUtils.entryptPassword(newPassword));
      } else {
        throw new NotFoundByIdException("原密码输入错误！");
      }
      result = userServerClient.updateUser(userDto, systemCode);
      if (StatusCodeEnum.OK.getValue().equals(result.getStatus())
          && userInfo.getIsAuthority().equals(IsAuthorityEnum.YES.getValue())) {
        ResultDTO resultDto = userServerClient.getUser(userInfo.getId(), systemCode);
        UserDTO user =
            JSONObject.parseObject(JSONObject.toJSONString(resultDto.getDatas()), UserDTO.class);
        // 向大数据推送用户信息(修改)
        UserPushDTO userPushDto = new UserPushDTO();
        userPushDto.setUsername(user.getUserName());
        userPushDto.setPwd(user.getPassword());
        userPushDto.setCityid(cityId);
        userPushDto.setType(PushUserActionTypeEnum.UPDATE.getValue());
        UserPushResultDTO pushUserResultDto = userPushServerClient.pushUser(userPushDto);
        thirdInterfaceLog(userPushDto, pushUserResultDto);
      }
    } catch (TKCheckedException e) {
      logger.error("_amendPassword", e);
      throw new NotFoundByIdException(e.getMessage());
    }
    return result;
  }

  /** 获取稽核人员列表 */
  @Override
  public ResultDTO getAuditor() {
    return userServerClient.getAuditor(systemCode);
  }

  private void thirdInterfaceLog(UserPushDTO userPushDto, UserPushResultDTO pushUserResultDto) {
    ////////////////////////////////////////////////////////////
    long begin = System.currentTimeMillis();
    ThirdInterfaceLogDO log = new ThirdInterfaceLogDO();
    log.setType(ThirdInterfaceLogEnum.TYPE_PUSH_USER.getValue());
    log.setBusiType(ThirdInterfaceLogEnum.BUSI_PUSH_USER.getValue());
    ////////////////////////////////////////////////////////////////////////
    try {
      log.setBusiDataId(userPushDto.getUsername());
      log.setSendContent(JSONObject.toJSONString(userPushDto));
      log.setSendTime(new Date());

      log.setReveiceContent(JSONObject.toJSONString(pushUserResultDto));
      log.setReveiceTime(new Date());
      if (PushUserStateCodeEnum.SUCCESS.getValue().equals(pushUserResultDto.getCode())) {
        log.setIsSendSuccess(1);
      } else {
        log.setIsSendSuccess(0);
        log.setFailMessage(pushUserResultDto.getMsg());
      }
    } catch (Exception e) {
      log.setIsSendSuccess(0);
      log.setFailMessage(e.getMessage());
      logger.error("ltci-portal pushUser 推送用户失败：" + e);
    } finally {
      scheduleExecuteServiceImpl.insertInterfaceLog(log);
      logger.debug(
          "_____evaluateTaskServerClient >>>>>> expertTaskAdd__耗时S:"
              + ((System.currentTimeMillis()) - begin) / 1000);
    }
  }
}
