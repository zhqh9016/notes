package com.taikang.dic.ltci.treatment.application.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.common.util.UserUtils;
import com.taikang.dic.ltci.treatment.application.service.TodoListService;

/** @author itw_xuyao 对代办业务表进行操作 */
@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class TodoListController {
  private static final Logger logger = LoggerFactory.getLogger(TodoListController.class);

  @Autowired private TodoListService todoListServiceImpl;

  /**
   * 显示代办列表
   *
   * @return
   */
  @RequestMapping(path = "/todoList", method = RequestMethod.GET)
  @ResponseBody
  public ResultDTO listTodo() {
    logger.info("====进入listTodo方法开始========");

    return todoListServiceImpl.listTodo();
  }
}
