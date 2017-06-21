package com.taikang.dic.ltci.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.taikang.dic.ltci.api.model.RestResponseDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.api.model.TodoListDTO;
import com.taikang.dic.ltci.common.Result;
import com.taikang.dic.ltci.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.common.ParametersIsNullException;
import com.taikang.dic.ltci.common.util.DateFormatUtil;
import com.taikang.dic.ltci.model.TodoListDO;
import com.taikang.dic.ltci.service.TodoListService;

/** @author itw_xuyao 对代办业务表进行操作 */
@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class TodoListController {
  private static final Logger logger = LoggerFactory.getLogger(TodoListController.class);

  @Autowired private TodoListService todoListService;

  /**
   * 显示代办列表
   *
   * @return
   */
  @RequestMapping(path = "/todoList", method = RequestMethod.GET)
  @ResponseBody
  public ResultDTO listTodo() {
    List<TodoListDO> todoListDOList = todoListService.findAll();
    List<TodoListDTO> todoListDTOList = new ArrayList<TodoListDTO>();
    for (TodoListDO todoListDO : todoListDOList) {
      TodoListDTO todoListDTO = new TodoListDTO();
      BeanUtils.copyProperties(todoListDO, todoListDTO);
      //todoListDTO.setCreatedTime(DateFormat.date2OffsetDateTime(todoListDO.getCreatedTime()));
      todoListDTO.setCreatedTime(
          DateFormatUtil.dateToStr(
              todoListDO.getCreateTime(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD_HH_MM_SS));
      todoListDTOList.add(todoListDTO);
    }

    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setStatus(StatusCodeEnum.OK.getValue());
    resultDTO.setDatas(todoListDTOList);
    resultDTO.setMessage("查询成功");
    logger.debug("===listTodo方法返回resultDTO【" + resultDTO.toString() + "】===========");
    return resultDTO;
  }

  /**
   * 新增待办提醒接口
   *
   * @param TodoListDto
   * @return
   */
  @RequestMapping(path = "/todoList", method = RequestMethod.POST)
  @ResponseBody
  public ResultDTO createTodoList(@RequestBody TodoListDTO todoListDTO) {
    logger.info("====进入createTodoList方法开始========");
    logger.debug("======todoListDTO【" + todoListDTO.toString() + "】========");
    if (StringUtils.isEmpty(todoListDTO.getTitle())
        || StringUtils.isEmpty(todoListDTO.getBusinessType())
        || StringUtils.isEmpty(todoListDTO.getType())
        || StringUtils.isEmpty(todoListDTO.getCreatedOrg())) {
      throw new ParametersIsNullException("插入代办任务传入参数有空值，请确认");
    } else {
      TodoListDO todoListDO = new TodoListDO();
      BeanUtils.copyProperties(todoListDTO, todoListDO);
      Result result = todoListService.createTodoList(todoListDO);
      ResultDTO resultDTO = new ResultDTO();
      BeanUtils.copyProperties(result, resultDTO);

      return resultDTO;
    }
  }

  /**
   * 删除待办提醒接口
   *
   * @param TodoListDTO
   * @return
   */
  @RequestMapping(path = "/todoListByTitle", method = RequestMethod.POST)
  @ResponseBody
  public ResultDTO deleteTodoList(@RequestBody TodoListDTO todoListDTO) {
    logger.info("====进入deleteTodoList方法开始========");
    logger.debug("===deleteTodoList传入todoListDTO【" + todoListDTO.toString() + "】========");
    if (StringUtils.isEmpty(todoListDTO.getBusinessCode())
        || StringUtils.isEmpty(todoListDTO.getBusinessType())) {
      throw new ParametersIsNullException("删除代办任务传入参数有空值，请确认");
    } else {
      TodoListDO todoListDO = new TodoListDO();
      BeanUtils.copyProperties(todoListDTO, todoListDO);
      Result result = todoListService.deleteTodoList(todoListDO);
      ResultDTO resultDTO = new ResultDTO();
      BeanUtils.copyProperties(result, resultDTO);

      return resultDTO;
    }
  }

  /**
   * 代办提醒判重接口
   *
   * @param TodoListDTO
   * @return
   */
  @RequestMapping(path = "/todoListByBusinessType", method = RequestMethod.POST)
  @ResponseBody
  public ResultDTO getTodoListByBusinessType(String businessType, String createdOrg) {
    logger.info("====进入getTodoListByBusinessType方法开始========");
    logger.debug("===getTodoListByBusinessType传入businessType【" + businessType + "】========");
    logger.debug("===getTodoListByBusinessType传入createdOrg【" + createdOrg + "】========");
    Result result = todoListService.getTodoListByBusinessType(businessType, createdOrg);
    ResultDTO resultDTO = new ResultDTO();
    BeanUtils.copyProperties(result, resultDTO);

    return resultDTO;
  }
}
