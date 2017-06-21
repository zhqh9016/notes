package com.taikang.dic.ltci.quality.control.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.taikang.dic.ltci.portal.api.model.ExecuteResultDTO;
import com.taikang.dic.ltci.portal.api.model.RExecuteFileDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;

public interface PatrolTaskExecuteService {

  ResultDTO uploadPatrolTaskExecute(MultipartFile file);

  ResultDTO deleteExecuteFile(String fileId, String suffix);

  ResultDTO createPatrolTaskExecute(ExecuteResultDTO executeResultDto);

  ResultDTO getPatrolTaskExecuteFile(String patrolTaskId);

  void getMongoDBMessage(
      RExecuteFileDTO executeFileDto, HttpServletRequest request, HttpServletResponse response);
}
