package com.taikang.dic.ltci.service;

import java.util.List;

import com.taikang.dic.ltci.api.model.ApplicationLogDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.api.model.TreatmentApplicationDTO;
import com.taikang.dic.ltci.model.TreatmentApplicationDO;

public interface MobileTreatmentApplicationService {

  List<TreatmentApplicationDO> mobileTreatmentApplicationList(
      String insuredPersonName,
      String idCard,
      String securityNumber,
      String disease,
      String operatedTime,
      int page,
      int pageSize,
      String applicationStatus);

  int countTreatmentApplicationList(
      String insuredPersonName,
      String idCard,
      String securityNumber,
      String disease,
      String operatedTime,
      String applicationStatus);

  TreatmentApplicationDO getTreatmentApplication(String applicationCode);

  int treatmentApplicationUpdate(ApplicationLogDTO logDto);

  ResultDTO createMobileTreatmentApplication(TreatmentApplicationDO treatmentApplicationDO);

  void createTreatmentApplication(TreatmentApplicationDTO dto);

  ResultDTO batchTreatmentApplicationCase(String applicationSpecialDO);

  int treatmentApplicationCase(ApplicationLogDTO logDto);
}
