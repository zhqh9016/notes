package com.taikang.dic.ltci.evaluate.nursing.service;

import com.taikang.dic.ltci.portal.api.model.CheckInDTO;
import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;

public interface CheckInService {
  ResultDTO checkInProtocolExit(CheckInDTO checkInDTO);

  PageResultDTO getCheckIn(
      String beCarePersonName,
      String beCarePersonCard,
      String orgName,
      String operatedTime,
      String inHospState,
      int page,
      int pageSize);
}
