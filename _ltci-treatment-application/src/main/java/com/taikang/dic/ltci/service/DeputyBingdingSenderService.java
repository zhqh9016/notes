package com.taikang.dic.ltci.service;

public interface DeputyBingdingSenderService {
  void send(String context);

  void sendDeputyBingdingState(
      String serialNumber,
      String deputyName,
      String deputyIdCard,
      String idCard,
      String securityNumber,
      String checkState,
      String checkReason,
      String insuredPersonName);
}
