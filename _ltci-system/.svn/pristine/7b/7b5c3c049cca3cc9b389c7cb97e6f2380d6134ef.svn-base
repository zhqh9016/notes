package com.taikang.dic.ltci.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.taikang.dic.ltci.api.model.OrganizationDTO;
import com.taikang.dic.ltci.api.model.PageResultDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.api.model.UserDTO;
import com.taikang.dic.ltci.common.util.DateFormatUtil;
import com.taikang.dic.ltci.model.UserDO;
import com.taikang.dic.ltci.service.IOrganizationService;
import com.taikang.dic.ltci.service.IUserService;
import com.taikang.dic.ltci.service.ServiceException;

/**
 * 用户信息UserController
 *
 * @author itw_liyh01 2017-03-29
 */
@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class UserController {

  private static final Logger logger = LoggerFactory.getLogger(UserController.class);

  @Autowired private IUserService userService;

  @Autowired private IOrganizationService organizationService;

  /**
   * 按条件分页查询用户列表
   *
   * @param userDto 查询条件
   * @param page 当前页码
   * @param pageSize 每页显示件数
   * @return 用户信息列表
   */
  @SuppressWarnings("unchecked")
  @RequestMapping(path = "/users/list", method = RequestMethod.POST)
  @ResponseBody
  public PageResultDTO listUser(UserDTO userDto, String roleCode, int page, int pageSize) {
    logger.debug("_listUser___userDto=" + userDto + "___page=" + page + "___pageSize=" + pageSize);
    UserDO userDo = new UserDO();
    BeanUtils.copyProperties(userDto, userDo);
    Map<String, Object> model = userService.listUser(userDo, roleCode, page, pageSize);

    PageResultDTO pageRet = new PageResultDTO();
    pageRet.setPage(page);
    pageRet.setPageSize(pageSize);
    pageRet.setTotalDataNum(Integer.parseInt(model.get("totalDataNum").toString()));
    pageRet.setTotalPageNum(Integer.parseInt(model.get("totalPageNum").toString()));
    List<UserDO> userDoList = (List<UserDO>) model.get("userDoList");

    List<UserDTO> userDtoList = new ArrayList<>();
    for (UserDO user : userDoList) {
      UserDTO userRet = new UserDTO();
      BeanUtils.copyProperties(user, userRet);
      if (!StringUtils.isEmpty(user.getDepartmentid())) {
        OrganizationDTO department =
            (OrganizationDTO) organizationService.selectById(user.getDepartmentid()).getDatas();
        userRet.setDepartment(department);
      }
      if (user.getCreateTime() != null) {
        userRet.setCreateTime(
            DateFormatUtil.dateToStr(
                user.getCreateTime(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD_HH_MM_SS));
      }
      if (user.getOperatedTime() != null) {
        userRet.setOperatedTime(
            DateFormatUtil.dateToStr(
                user.getOperatedTime(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD_HH_MM_SS));
      }
      userDtoList.add(userRet);
    }
    pageRet.setStatus(200);
    // 用户列表
    pageRet.setDatas(userDtoList);
    return pageRet;
  }

  /**
   * 新增用户
   *
   * @param userDto 新增用户信息
   */
  @RequestMapping(path = "/users", method = RequestMethod.POST)
  @ResponseBody
  public ResultDTO createUser(@RequestBody UserDTO userDto) {
    logger.debug("_createUser___userDto=" + userDto);
    ResultDTO resultDto = new ResultDTO();
    try {
      UserDO userDo = new UserDO();
      BeanUtils.copyProperties(userDto, userDo);
      userService.createUser(userDo);
      resultDto.setStatus(200);
      resultDto.setMessage("新增用户成功");
    } catch (ServiceException e) {
      resultDto.setStatus(e.getErrorCode());
      resultDto.setMessage(e.getMessage());
      logger.error("_createUser_", e);
      return resultDto;
    }
    return resultDto;
  }

  /**
   * 根据用户名精确查询
   *
   * @param userName 用户名
   * @return 用户列表
   */
  @RequestMapping(path = "/users/{userName}", method = RequestMethod.GET)
  @ResponseBody
  public ResultDTO listUser(@PathVariable String userName) {
    logger.debug("_listUser___userName=" + userName);
    ResultDTO resultDto = new ResultDTO();
    List<UserDO> userList = userService.listUser(userName);
    List<UserDTO> userDtoList = new ArrayList<>();
    for (UserDO user : userList) {
      UserDTO userRet = new UserDTO();
      BeanUtils.copyProperties(user, userRet);
      if (user.getCreateTime() != null) {
        userRet.setCreateTime(
            DateFormatUtil.dateToStr(
                user.getCreateTime(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD_HH_MM_SS));
      }
      if (user.getOperatedTime() != null) {
        userRet.setOperatedTime(
            DateFormatUtil.dateToStr(
                user.getOperatedTime(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD_HH_MM_SS));
      }
      userDtoList.add(userRet);
    }
    resultDto.setStatus(200);
    resultDto.setDatas(userDtoList);
    return resultDto;
  }

  /**
   * 删除用户-微服务 1.提供用户删除微服务 2.提供用户角色关联删除微服务
   *
   * @param id 用户编号
   */
  @RequestMapping(path = "/users/{id}", method = RequestMethod.DELETE)
  @ResponseBody
  public ResultDTO deleteUser(@PathVariable String id, @RequestBody UserDTO userDto) {
    logger.debug("_deleteUser___id=" + id + "__userDto" + userDto);
    ResultDTO resultDto = new ResultDTO();
    try {
      UserDO userDo = new UserDO();
      BeanUtils.copyProperties(userDto, userDo);
      userService.deleteUser(id, userDo);
      resultDto.setMessage("删除用户成功");
      resultDto.setStatus(200);
    } catch (ServiceException e) {
      resultDto.setStatus(e.getErrorCode());
      resultDto.setMessage(e.getMessage());
      logger.error("deleteUser", e);
      return resultDto;
    }
    return resultDto;
  }

  /**
   * 根据ID查询用户信息
   *
   * @param id 用户编号
   * @return 用户信息
   */
  @RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
  @ResponseBody
  public ResultDTO getUser(@PathVariable String id) {
    logger.debug("_getUser___id=" + id);
    UserDO userDo = userService.getUser(id);
    ResultDTO resultDto = new ResultDTO();
    UserDTO userDto = new UserDTO();
    BeanUtils.copyProperties(userDo, userDto);
    if (!StringUtils.isEmpty(userDo.getDepartmentid())) {
      OrganizationDTO department =
          (OrganizationDTO) organizationService.selectById(userDo.getDepartmentid()).getDatas();
      userDto.setDepartment(department);
    }
    resultDto.setStatus(200);
    resultDto.setDatas(userDto);
    return resultDto;
  }

  /**
   * 修改用户信息
   *
   * @param userDto 用户修改信息
   * @return
   */
  @RequestMapping(path = "/users", method = RequestMethod.PUT)
  @ResponseBody
  public ResultDTO updateUser(@RequestBody UserDTO userDto) {
    logger.debug("_updateUser___userDto=" + userDto);
    ResultDTO resultDto = new ResultDTO();
    try {
      UserDO userDo = new UserDO();
      BeanUtils.copyProperties(userDto, userDo);
      userService.updateUser(userDo);
      resultDto.setStatus(200);
      resultDto.setMessage("修改用户成功");
    } catch (ServiceException e) {
      resultDto.setStatus(e.getErrorCode());
      resultDto.setMessage(e.getMessage());
      logger.error("_updateUser_", e);
      return resultDto;
    }
    return resultDto;
  }

  /**
   * 获取稽核人员列表
   *
   * @return
   */
  @RequestMapping(path = "/users/auditor", method = RequestMethod.GET)
  @ResponseBody
  public ResultDTO getAuditor() {
    ResultDTO resultDto = new ResultDTO();
    List<UserDTO> userDtoList = new ArrayList<>();
    List<UserDO> userDoList = userService.getAuditor();
    for (UserDO user : userDoList) {
      UserDTO userRet = new UserDTO();
      BeanUtils.copyProperties(user, userRet);
      userDtoList.add(userRet);
    }
    resultDto.setStatus(200);
    resultDto.setDatas(userDtoList);
    return resultDto;
  }
}
