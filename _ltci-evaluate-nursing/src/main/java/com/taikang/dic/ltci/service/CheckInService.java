package com.taikang.dic.ltci.service;

import com.taikang.dic.ltci.api.model.CheckInDTO;
import com.taikang.dic.ltci.api.model.PageResultDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.ws.ErrorReason;
import com.taikang.dic.ltci.model.CheckInDO;

public interface CheckInService extends GenericService<CheckInDO, String> {
  PageResultDTO getCheckIn(
      String beCarePersonName,
      String beCarePersonCard,
      String orgName,
      String operatedTime,
      String inHospState,
      int page,
      int pageSize);

  int updateCheckInByCheckInCode(
      String exitFrom,
      String exitReason,
      String exitReasonDetial,
      String inHospState,
      String realOutDate,
      String checkInCode,
      String operatedBy);

  ResultDTO getInHospState(String idCard, String insuredPersonName);

  ResultDTO getCheckInHospState(String idCard, String insuredPersonName);

  ErrorReason registNurseInfo(String jsonString);

  ErrorReason getNurseOutInfo(String jsonString);

  CheckInDTO getCheckInHospStateByInRecordUuid(String inRecordUuid);
}
