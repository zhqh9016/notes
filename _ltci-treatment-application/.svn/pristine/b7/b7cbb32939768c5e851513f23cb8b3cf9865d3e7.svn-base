package com.taikang.dic.ltci.serverClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.api.model.TodoListDTO;

/** @author itw_xuyao */
@FeignClient(name = "${feign.system}", url = "${feign.system.url}")
public interface TodoListServerClient {

  @RequestMapping(method = RequestMethod.POST, value = "/api/v1/todoList")
  public ResultDTO createTodoList(@RequestBody TodoListDTO todoListDTO);

  @RequestMapping(method = RequestMethod.POST, value = "/api/v1/todoListByTitle")
  public ResultDTO deleteTodoList(@RequestBody TodoListDTO todoListDTO);
}
