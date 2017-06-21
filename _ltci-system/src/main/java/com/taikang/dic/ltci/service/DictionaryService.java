package com.taikang.dic.ltci.service;

import java.util.Date;
import java.util.List;

import com.taikang.dic.ltci.api.model.DictionaryDTO;
import com.taikang.dic.ltci.api.model.PageResultDTO;
import com.taikang.dic.ltci.model.DictionaryDO;

public interface DictionaryService {

  PageResultDTO getDictionary(
      DictionaryDTO dictionaryDTO, int page, int pageSize, String queryFlag);

  void createDictionary(DictionaryDO dictionaryDO);

  void deleteDictionary(String id, String operatedBy);

  void updateDictionary(DictionaryDO dictionaryDO);

  void recoverDictionary(String id, String operatedBy);

  Date getMaxOperateTime();

  List<DictionaryDO> getDictionaryDOByCondition(String type, String value);
}
