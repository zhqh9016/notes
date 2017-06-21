package com.taikang.dic.ltci.service;

import java.util.List;

import com.taikang.dic.ltci.common.Result;
import com.taikang.dic.ltci.model.TodoListDO;

public interface TodoListService extends GenericService<TodoListDO, String> {

  List<TodoListDO> findAll();

  Result createTodoList(TodoListDO todoListDO);

  Result deleteTodoList(TodoListDO todoListDO);

  Result getTodoListByBusinessType(String businessType, String createdOrg);
}
