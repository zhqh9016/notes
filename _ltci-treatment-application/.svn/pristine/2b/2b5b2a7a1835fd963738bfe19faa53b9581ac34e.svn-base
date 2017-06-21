package com.taikang.dic.ltci.service;

import java.net.SocketException;
import java.net.UnknownHostException;

import com.taikang.dic.ltci.api.model.PageResultDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.Result;
import com.taikang.dic.ltci.model.DeputyBindingDO;
import com.taikang.dic.ltci.model.DeputyBindingSpecialDO;

public interface DeputyBindingService extends GenericService<DeputyBindingDO, String> {

  PageResultDTO queryDeputyBinding(
      String insuredPersonName,
      String idCard,
      String securityNumber,
      String deputyName,
      String deputyIdCard,
      String checkState,
      int page,
      int pageSize);

  Result getDeputyBindingStatus(DeputyBindingSpecialDO deputyBindingSpecialDO);

  void createDeputyBinding(byte[] message) throws UnknownHostException, SocketException;

  DeputyBindingSpecialDO getDeputyBindingDO(String deputyBindingid);

  Result updateDeputyBindingDO(DeputyBindingDO deputyBindingDO);

  ResultDTO getDeputyBindingListQuery(String deputyIdCard);

  ResultDTO insertMqMessageLog(String message);
}
