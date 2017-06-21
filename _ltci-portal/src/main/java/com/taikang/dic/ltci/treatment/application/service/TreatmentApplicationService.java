package com.taikang.dic.ltci.treatment.application.service;

import org.springframework.web.multipart.MultipartFile;

import com.taikang.dic.ltci.portal.api.model.ApplicationLogDTO;
import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.api.model.TreatmentApplicationDTO;

public interface TreatmentApplicationService {

  ResultDTO caseTreatmentApplicationStauts(ApplicationLogDTO logDto);

  ResultDTO getTreatmentApplicationInfo(String applicationCode);

  ResultDTO createTreatmentApplication(TreatmentApplicationDTO dto);

  ResultDTO uploadTreatmentApplicationAttachement(MultipartFile file);

  ResultDTO uploadTreatmentApplicationAttachement(String base64);

  ResultDTO deleteTreatmentApplicationAttachement(String attachmentid);

  PageResultDTO mobileTreatmentApplicationList(
      String insuredPersonName,
      String idCard,
      String securityNumber,
      String disease,
      String operatedTime,
      int page,
      int pageSize,
      String applicationStatus);

  ResultDTO batchTreatmentApplicationCase(String applicationSpecialDO);
}
