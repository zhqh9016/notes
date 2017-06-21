package com.taikang.dic.ltci.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.service.TodoListService;

/**
 * 发送评估任务时定时产生提醒信息
 *
 * @author itw_liuxy
 * @description
 * @createTime 2017年4月13日 下午5:43:12
 */
//@RestController
//@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
@Component
public class TodoListController {

  @Autowired private TodoListService todoListService;

  private static final Logger logger = LoggerFactory.getLogger(TodoListController.class);

  //  /**
  //   * 新增待办提醒接口
  //   *
  //   * @param TodoListDto
  //   * @return
  //   */
  //  @RequestMapping(path = "/todoListTiming", method = RequestMethod.GET)
  //  public RestResponseDTO createTodoListTiming() {
  //    ResultDTO dto = todoListService.createTodoListTiming();
  //    RestResponseDTO responseDTO = new RestResponseDTO();
  //    responseDTO.setData(dto);
  //    return responseDTO;
  //  }

  @Scheduled(cron = "${todoListTiming}")
  public void createTodoListTiming() {
    ResultDTO dto = todoListService.createTodoListTiming();
    logger.info("定时任务返回信息：" + dto);
  }
}
