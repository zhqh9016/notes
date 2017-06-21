/** */
package com.taikang.dic.ltci.portal.common.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * 自定义认证匹配器.
 *
 * <p>CustomCredentialsMatcher负责对比SystemAuthorizingRealm从数据库中获取的用户信息
 * 和CustomFormAuthenticationFilter从表单获取到的用户信息是否一致.
 *
 * @author itw_zhangqh
 */
public class CustomCredentialsMatcher extends SimpleCredentialsMatcher {

  @Override
  public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {

    UsernamePasswordToken token = (UsernamePasswordToken) authcToken;

    HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
    matcher.setHashAlgorithmName("MD5");
    matcher.setHashIterations(1024);
    return matcher.doCredentialsMatch(token, info);
  }
}
