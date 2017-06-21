package com.taikang.dic.ltci.service.impl;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.common.JsonUtils;
import com.taikang.dic.ltci.common.Result;
import com.taikang.dic.ltci.common.enumeration.IsValidEnum;
import com.taikang.dic.ltci.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.common.log.ThreadLocalUtil;
import com.taikang.dic.ltci.dao.IGenericDAO;
import com.taikang.dic.ltci.dao.TodoListDAO;
import com.taikang.dic.ltci.model.TodoListDO;
import com.taikang.dic.ltci.model.TodoListDOExample;
import com.taikang.dic.ltci.model.TodoListDOExample.Criteria;
import com.taikang.dic.ltci.service.AbstractGenericService;
import com.taikang.dic.ltci.service.TodoListService;

/** @author itw_xuyao 对代办任务表进行操作 */
@Service
public class TodoListServiceImpl extends AbstractGenericService<TodoListDO, String>
    implements TodoListService {
  private static final Logger logger = LoggerFactory.getLogger(TodoListServiceImpl.class);

  @Autowired private TodoListDAO todoListDAO;

  /**
   * 显示待办提醒
   *
   * @return
   */
  public List<TodoListDO> findAll() {
    logger.debug("=======进入TodoListService findAll方法开始============");
    // 从session中获取用户id作为接收角色进行条件查询
    //String userId = "1";
    String createdOrg = ThreadLocalUtil.threadLocal.get().getOperatedOrg();
    TodoListDOExample doExample = new TodoListDOExample();
    Criteria criteria = doExample.createCriteria();
    criteria.andIsValidEqualTo(IsValidEnum.NO_DELETE.getValue());
    if (!StringUtils.isEmpty(createdOrg)) {
      criteria.andCreatedOrgEqualTo(createdOrg);
    }
    doExample.setOrderByClause(" created_time desc ");

    //criteria.andReceiveCharactarEqualTo(userId);
    List<TodoListDO> todoListDOList = todoListDAO.selectByExample(doExample);
    logger.info("======todoListDOList【" + todoListDOList.size() + "】======");
    return todoListDOList;
  }

  /**
   * 新增待办提醒接口
   *
   * @param TodoListDto
   * @return
   */
  public Result createTodoList(TodoListDO todoListDO) {
    logger.debug("===进入TodoListService createTodoList方法开始===");
    logger.debug("===传入todoListDO【" + JsonUtils.makeJsonForObject(todoListDO) + "】===");

    //主键id
    todoListDO.setTodoListid(UUID.randomUUID().toString().replaceAll("-", ""));
    //待办任务表编号暂时写死
    todoListDO.setTodoListCode(UUID.randomUUID().toString().replaceAll("-", ""));
    todoListDO.setCreateTime(new Date());
    todoListDO.setIsValid(IsValidEnum.NO_DELETE.getValue());
    //    String url = todoListDO.getIp() + todoListDO.getPort() + todoListDO.getUri();
    //    todoListDO.setUrl(url);
    //创建人如何存入 移动端调用时是有创建人的  如果经办系统内自己调用该如何存入

    logger.debug(
        "======将要存入的todoListDO【" + JsonUtils.makeJsonForObject(todoListDO) + "】===============");

    int i = todoListDAO.insert(todoListDO);
    Result result = new Result();
    if (i > 0) {
      result.setStatus(StatusCodeEnum.CREATED.getValue());
      result.setDatas(todoListDO);
      result.setMessage("生成代办任务成功");
    } else {
      result.setStatus(StatusCodeEnum.INTERNAL_SERVER_ERROR.getValue());
      result.setDatas(todoListDO);
      result.setMessage("生成代办任务失败");
    }

    logger.debug("===resultDTO【" + result.toString() + "】===");
    logger.debug("===进入TodoListService createTodoList方法结束===");
    return result;
  }

  /**
   * 删除待办提醒接口
   *
   * @param TodoListDto
   * @return
   */
  @Transactional
  public Result deleteTodoList(TodoListDO todoListDO) {
    logger.debug("===进入TodoListService deleteTodoList方法开始===");
    logger.debug("===传入todoListDO【" + JsonUtils.makeJsonForObject(todoListDO) + "】===");

    Result result = new Result();

    TodoListDOExample doExample = new TodoListDOExample();
    Criteria criteria = doExample.createCriteria();
    criteria.andBusinessCodeEqualTo(todoListDO.getBusinessCode());
    criteria.andBusinessTypeEqualTo(todoListDO.getBusinessType());
    if (!StringUtils.isEmpty(todoListDO.getCreatedOrg())) {
      criteria.andCreatedOrgEqualTo(todoListDO.getCreatedOrg());
    }

    TodoListDO newTodoListDO = new TodoListDO();
    newTodoListDO.setIsValid(IsValidEnum.ALREADY_DELETE.getValue());
    int i = todoListDAO.updateByExampleSelective(newTodoListDO, doExample);
    if (i > 0) {
      result.setStatus(StatusCodeEnum.OK.getValue());
      todoListDO.setIsValid(IsValidEnum.ALREADY_DELETE.getValue());
      result.setDatas(todoListDO);
      result.setMessage("删除成功");
    } else {
      //      result.setStatus(StatusCodeEnum.INTERNAL_SERVER_ERROR.getValue());
      //      result.setDatas(todoListDO);
      //      result.setMessage("删除失败");
      throw new RuntimeException("删除代办信息失败");
    }
    logger.debug("===resultDTO【" + result.toString() + "】===");
    logger.debug("===进入TodoListService deleteTodoList方法结束===");
    return result;
  }

  @Override
  public Result getTodoListByBusinessType(String businessType, String createdOrg) {
    TodoListDOExample doExampleToDo = new TodoListDOExample();
    com.taikang.dic.ltci.model.TodoListDOExample.Criteria createCriteria =
        doExampleToDo.createCriteria();
    createCriteria.andBusinessTypeEqualTo(businessType);
    if (!StringUtils.isEmpty(createdOrg)) {
      createCriteria.andCreatedByEqualTo(createdOrg);
    }
    createCriteria.andIsValidEqualTo(IsValidEnum.NO_DELETE.getValue());
    List<TodoListDO> todoListDOs = todoListDAO.selectByExample(doExampleToDo);
    logger.debug("=======todoListDOs【" + JSONObject.toJSONString(todoListDOs) + "】===========");

    Result result = new Result();
    result.setStatus(StatusCodeEnum.OK.getValue());
    result.setDatas(todoListDOs);
    result.setMessage("查询成功");

    return result;
  }

  /**
   * @param inputDate
   * @return
   */
  public OffsetDateTime date2OffsetDateTime(Date inputDate) {
    Instant instant = inputDate.toInstant();
    OffsetDateTime dateTime = instant.atZone(ZoneId.systemDefault()).toOffsetDateTime();
    return dateTime;
  }

  @Override
  public IGenericDAO<TodoListDO, String> getDao() {
    return todoListDAO;
  }
}
