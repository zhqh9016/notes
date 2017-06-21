package com.taikang.dic.ltci.portal.common.log.interceptor;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.taikang.dic.ltci.portal.common.log.LogConstant;
/**
 * 监听spring是否启动，启动后将获取当前登录用户的标志 置为 true
 *
 * @author itw_muwg
 */
@Component
public class CurrentUserListener implements ApplicationListener<ContextRefreshedEvent> {

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    if (!LogConstant.LOG.getCurrentUserFlag()) LogConstant.LOG.setCurrentUserFlag(true);
    ;
  }
}
