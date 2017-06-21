package com.taikang.dic.ltci.service;

import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.model.StaffHistoryDO;

public interface IStaffInterfaceService {

  void receiveStaff(byte[] bytes);

  void sendAcceptResult(StaffHistoryDO staffHistory);

  void sendApproveResult(StaffHistoryDO staffHistory);

  void sendChangeApproveResult(StaffHistoryDO staffHistory);

  void saveStaffHistory4Add(
      String businessSerialid, StaffHistoryDO staffHistory, String message, JSONObject data);

  void saveStaffHistory4Update(
      String businessSerialid, StaffHistoryDO staffHistory, String message, JSONObject data);

  void saveStaffHistory4Delete(
      String businessSerialid, StaffHistoryDO staffHistory, String message);

  void parseMessage(String message);
}
