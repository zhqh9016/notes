package com.taikang.dic.ltci.portal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.taikang.dic.ltci.portal.api.model.ResultDTO;

@RestController
@RequestMapping("/api/v1")
public class MqFailMessageRetryController {

  @RequestMapping(value = "/retry", method = RequestMethod.POST)
  public ResultDTO mqFailMessageRetry(String url, String message) {
    MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
    List<String> list = new ArrayList<>();
    list.add(message);
    map.put("message", list);
    ResultDTO dto = new RestTemplate().postForObject(url, map, ResultDTO.class);
    return dto;
  }
}
