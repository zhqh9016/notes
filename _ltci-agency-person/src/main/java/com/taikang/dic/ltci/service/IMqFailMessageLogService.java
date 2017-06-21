package com.taikang.dic.ltci.service;

import com.taikang.dic.ltci.model.MqFailMessageLogDO;

public interface IMqFailMessageLogService {

  void saveOrUpdateFailLog(MqFailMessageLogDO failMessageLog);
}
