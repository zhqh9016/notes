package com.taikang.dic.ltci.service;

import java.util.Date;
import java.util.List;

import com.taikang.dic.ltci.api.model.DictionaryDTO;
import com.taikang.dic.ltci.api.model.PageResultDTO;
import com.taikang.dic.ltci.model.DictionaryDO;

public interface DiseaseService {

  PageResultDTO getDisease(String name, int page, int pageSize);
}
