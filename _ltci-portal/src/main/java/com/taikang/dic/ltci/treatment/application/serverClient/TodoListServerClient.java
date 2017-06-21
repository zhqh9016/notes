package com.taikang.dic.ltci.treatment.application.serverClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.api.model.TodoListDTO;

/** @author itw_xuyao */
@FeignClient(name = "${feign.system}", url = "${feign.system.url}")
public interface TodoListServerClient {
  @RequestMapping(method = RequestMethod.GET, value = "/api/v1/todoList")
  public ResultDTO listTodo(@RequestParam(value = "systemCode") String systemCode);

  @RequestMapping(method = RequestMethod.POST, value = "/api/v1/todoList")
  public ResultDTO createTodoList(
      @RequestBody TodoListDTO todoListDTO, @RequestParam(value = "systemCode") String systemCode);
}
