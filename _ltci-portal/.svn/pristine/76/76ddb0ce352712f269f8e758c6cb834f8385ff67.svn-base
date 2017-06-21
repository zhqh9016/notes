package com.taikang.dic.ltci.treatment.application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.treatment.application.serverClient.TodoListServerClient;
import com.taikang.dic.ltci.treatment.application.service.TodoListService;

@Service
public class TodoListServiceImpl implements TodoListService {
  @Autowired private TodoListServerClient todoListServerClient;

  @Value(value = "${spring.application.name}")
  private String systemCode;

  public ResultDTO listTodo() {
    return todoListServerClient.listTodo(systemCode);
  };
}
