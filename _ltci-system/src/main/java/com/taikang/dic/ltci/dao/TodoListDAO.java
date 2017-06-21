package com.taikang.dic.ltci.dao;

import com.taikang.dic.ltci.model.TodoListDO;
import com.taikang.dic.ltci.model.TodoListDOExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TodoListDAO extends IGenericDAO<TodoListDO, String> {
  int countByExample(TodoListDOExample example);

  int deleteByExample(TodoListDOExample example);

  int deleteByPrimaryKey(String todoListid);

  int insert(TodoListDO record);

  int insertSelective(TodoListDO record);

  List<TodoListDO> selectByExample(TodoListDOExample example);

  TodoListDO selectByPrimaryKey(String todoListid);

  int updateByExampleSelective(
      @Param("record") TodoListDO record, @Param("example") TodoListDOExample example);

  int updateByExample(
      @Param("record") TodoListDO record, @Param("example") TodoListDOExample example);

  int updateByPrimaryKeySelective(TodoListDO record);

  int updateByPrimaryKey(TodoListDO record);
}
