package com.taikang.dic.ltci.system.serverClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.taikang.dic.ltci.portal.api.model.UserPushDTO;
import com.taikang.dic.ltci.portal.api.model.UserPushResultDTO;

@FeignClient(name = "${feign.user.push}", url = "${feign.user.push.url}")
public interface UserPushServerClient {

  @RequestMapping(
    method = RequestMethod.POST,
    value = "/lcrm/v1/user/register",
    consumes = "application/json"
  )
  UserPushResultDTO pushUser(@RequestBody UserPushDTO userPushDto);
}
