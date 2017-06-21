package com.taikang.dic.ltci.portal.configuration;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.filter.DelegatingFilterProxy;

import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.portal.api.model.RRoleResDTO;
import com.taikang.dic.ltci.portal.api.model.ResDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.common.shiro.CustomAnyRoleAuthorizationFilter;
import com.taikang.dic.ltci.portal.common.shiro.CustomCredentialsMatcher;
import com.taikang.dic.ltci.portal.common.shiro.CustomUserFilter;
import com.taikang.dic.ltci.portal.common.shiro.CustomFormAuthenticationFilter;
import com.taikang.dic.ltci.portal.common.shiro.SystemAuthorizingRealm;
import com.taikang.dic.ltci.portal.common.shiro.TKLogoutFilter;
import com.taikang.dic.ltci.system.service.ResService;

@Configuration
public class ShiroConfiguration {

  @Value("${spring.redis.host:localhost}")
  private String redisHost;

  @Value("${spring.redis.port:6379}")
  private int redisPort;

  @Value("${shiro.custom.enabled:true}")
  private boolean shiroEnabled;

  @Value("${shiro.custom.redisSession.enabled:false}")
  private boolean redisSessionEnabled;

  @Value("${server.session.timeout: ${server.session-timeout: 1800}}")
  private int sessionTimeout;

  @Autowired private ResService resService;

  /**
   * FilterRegistrationBean
   *
   * @return
   */
  @Bean
  public FilterRegistrationBean filterRegistrationBean() {
    FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
    filterRegistration.setFilter(new DelegatingFilterProxy("shiroFilter"));
    filterRegistration.setEnabled(true);
    filterRegistration.addUrlPatterns("/*");
    filterRegistration.setDispatcherTypes(DispatcherType.REQUEST);
    return filterRegistration;
  }

  @Bean(name = "systemAuthorizingRealm")
  public SystemAuthorizingRealm realm() {
    final SystemAuthorizingRealm realm = new SystemAuthorizingRealm();
    //设置自定义matcher
    realm.setCredentialsMatcher(new CustomCredentialsMatcher());
    return realm;
  }

  @Bean
  public CustomFormAuthenticationFilter filter() {
    final CustomFormAuthenticationFilter filter = new CustomFormAuthenticationFilter();
    return filter;
  }

  //shiro对redis的依赖
  /**
   * shiro redis manager
   *
   * @return
   */
  @Bean
  @ConditionalOnProperty(havingValue = "true", name = "shiro.custom.redisSession.enabled")
  public RedisManager redisManager() {
    final RedisManager redisManager = new RedisManager();
    //redis地址需要在配置文件中配置,具体怎么引入redis需要修改
    redisManager.setHost(redisHost);
    redisManager.setPort(redisPort);
    redisManager.setExpire(sessionTimeout); //缓存过期时间
    return redisManager;
  }
  /**
   * cacheManger 由redis实现
   *
   * @return
   */
  @Bean
  @ConditionalOnProperty(havingValue = "true", name = "shiro.custom.redisSession.enabled")
  public RedisCacheManager cacheManager() {
    final RedisCacheManager redisCacheManager = new RedisCacheManager();
    redisCacheManager.setRedisManager(redisManager());
    return redisCacheManager;
  }

  /**
   * 实现session持久化到redis
   *
   * @return
   */
  @Bean
  @ConditionalOnProperty(havingValue = "true", name = "shiro.custom.redisSession.enabled")
  public RedisSessionDAO redisSessionDAO() {
    final RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
    redisSessionDAO.setRedisManager(redisManager());
    return redisSessionDAO;
  }
  /**
   * sessionManger 由redis实现
   *
   * @return
   */
  @Bean
  public DefaultWebSessionManager sessionManager() {
    final DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
    if (redisSessionEnabled) {
      sessionManager.setSessionDAO(redisSessionDAO());
    }
    sessionManager.setGlobalSessionTimeout(sessionTimeout * 1000);
    return sessionManager;
  }

  @Bean(name = "securityManager")
  public DefaultWebSecurityManager securityManager() {
    final DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
    //注册自定义Realm
    securityManager.setRealm(realm());

    //根据标记决定是否使用redisSession
    if (redisSessionEnabled) {
      securityManager.setCacheManager(cacheManager());
    }
    securityManager.setSessionManager(sessionManager());
    return securityManager;
  }

  @SuppressWarnings("unchecked")
  @Bean(name = "shiroFilter")
  public ShiroFilterFactoryBean shiroFilter() {
    ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
    factoryBean.setSecurityManager(securityManager());
    factoryBean.setLoginUrl("/api/v1/login");
    //设置自定义filter
    Map<String, Filter> filters = new HashMap<String, Filter>();
    //注册自定义登录过滤器
    filters.put("authc", filter());
    //注册自定义退出过滤器
    filters.put("logout", new TKLogoutFilter());
    //注册自定义授权过滤器
    filters.put("anyRoles", new CustomAnyRoleAuthorizationFilter());
    //注册自定义用户登录状态检查过滤器
    filters.put("user", new CustomUserFilter());
    factoryBean.setFilters(filters);

    //将角色权限信息初始化到shiro中
    Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();

    filterChainDefinitionMap.put("/", "anon");

    filterChainDefinitionMap.put("/webjars/**", "anon");
    filterChainDefinitionMap.put("/swagger/**", "anon");

    filterChainDefinitionMap.put("/**/*.ico", "anon");
    filterChainDefinitionMap.put("/**/*.png", "anon");
    filterChainDefinitionMap.put("/**/*.html", "anon");
    filterChainDefinitionMap.put("/**/*.js", "anon");
    filterChainDefinitionMap.put("/**/*.css", "anon");
    filterChainDefinitionMap.put("/**/*.yml", "anon");
    filterChainDefinitionMap.put("/api/v1/logout", "logout");

    //判断是否开启shiro认证,如果开启,则从数据库加载资源角色映射关系,并设置默认认证策略为需要登录,
    //如果不开启shiro认证,那么放行所有请求
    if (shiroEnabled) {

      //====从数据库中加载所有菜单和角色信息
      ResultDTO allResAndRoles = resService.getAllResAndRoles();
      List<Map<String, Object>> datas = (List<Map<String, Object>>) allResAndRoles.getDatas();
      if (datas != null) {
        for (Map<String, Object> source : datas) {
          //将map转换成DTO
          String jsonString = JSONObject.toJSONString(source);
          ResDTO parseObject = JSONObject.parseObject(jsonString, ResDTO.class);

          //遍历角色信息,拼接成行如roles[role1,role2]的形式
          if (parseObject != null
              && StringUtils.isNotBlank(parseObject.getUrl())
              && parseObject.getRoleRess().size() > 0) {
            List<RRoleResDTO> roleRess = parseObject.getRoleRess();
            String strTemp = filterChainDefinitionMap.get(parseObject.getUrl());
            if (!StringUtils.isBlank(strTemp)) {
              String replace = strTemp.replace("]", ",");
              StringBuffer rolePattern = new StringBuffer(replace);
              for (RRoleResDTO rRoleResDTO : roleRess) {
                rolePattern.append(rRoleResDTO.getRoleId());
                rolePattern.append(",");
              }
              int lastIndexOf = rolePattern.lastIndexOf(",");
              if (lastIndexOf > 0) {
                String temp = rolePattern.substring(0, lastIndexOf);
                rolePattern = new StringBuffer(temp);
                rolePattern.append("]");
                //将资源和角色对应关系放入临时map中
                filterChainDefinitionMap.put(parseObject.getUrl(), rolePattern.toString());
              }
            } else {
              StringBuffer rolePattern = new StringBuffer("anyRoles[");
              for (RRoleResDTO rRoleResDTO : roleRess) {
                rolePattern.append(rRoleResDTO.getRoleId());
                rolePattern.append(",");
              }
              int lastIndexOf = rolePattern.lastIndexOf(",");
              if (lastIndexOf > 0) {
                String temp = rolePattern.substring(0, lastIndexOf);
                rolePattern = new StringBuffer(temp);
                rolePattern.append("]");
                //将资源和角色对应关系放入临时map中
                filterChainDefinitionMap.put(parseObject.getUrl(), rolePattern.toString());
              }
            }
          }
        }
      }
      filterChainDefinitionMap.put("/**", "user");
    } else {
      filterChainDefinitionMap.put("/**", "anon");
    }
    factoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
    return factoryBean;
  }

  @Bean
  @DependsOn("lifecycleBeanPostProcessor")
  public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
    DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator =
        new DefaultAdvisorAutoProxyCreator();
    defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
    return defaultAdvisorAutoProxyCreator;
  }

  @Bean
  public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
    AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor =
        new AuthorizationAttributeSourceAdvisor();
    authorizationAttributeSourceAdvisor.setSecurityManager(securityManager());
    return authorizationAttributeSourceAdvisor;
  }
}
