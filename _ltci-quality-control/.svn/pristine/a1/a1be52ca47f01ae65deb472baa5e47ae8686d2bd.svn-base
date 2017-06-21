package com.taikang.dic.ltci.service;

import com.taikang.dic.ltci.api.model.ReconsiderDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.model.ReconsiderDO;

public interface IReconsiderService extends GenericService<ReconsiderDO, String> {

  public ResultDTO listReconsidersByPatrolTaskId(String patrolTaskId);

  public ResultDTO saveReconsider(ReconsiderDTO reconsider);

  public void getReconsiderReceive(byte[] bytes);

  public void parseMessage(String message);
}
