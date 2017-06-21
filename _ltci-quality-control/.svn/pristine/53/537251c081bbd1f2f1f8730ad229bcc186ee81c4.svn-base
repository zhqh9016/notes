package com.taikang.dic.ltci.service;

import com.taikang.dic.ltci.model.ExecuteResultDO;

public interface ITaskResultService extends GenericService<ExecuteResultDO, String> {

  /**
   * step 1: 获取AMQ中的费用明细信息 step 2: 解析AMQ中的费用信息 ①
   * 将头部信息存储在消息日志表中，如果在处理过程中出现错误，或者总的消息条数和消息头中的消息总数不符，需要记录 错误日志，并将完整的消息以json形式记录 ② 将消息实体存储费用明细表
   */
  public void receiveMessage(byte[] bytes);
}
