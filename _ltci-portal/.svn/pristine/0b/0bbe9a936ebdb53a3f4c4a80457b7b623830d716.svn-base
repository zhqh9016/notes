package com.taikang.dic.ltci.portal.common.shiro;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.portal.api.model.RRoleResDTO;
import com.taikang.dic.ltci.portal.api.model.ResDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.system.service.ResService;

/**
 * 当资源和角色关联关系发生变化时触发重新从数据库中获 取资源和角色的映射关系,加载到shiro权限配置中
 *
 * @author itw_muwg
 */
@Component
public class ReloadAuthorizationInfoSevice {
  private Logger logger = LoggerFactory.getLogger(ReloadAuthorizationInfoSevice.class);
  @Autowired private ShiroFilterFactoryBean shiroFilterFactoryBean;

  @Autowired private ResService resService;

  @Value("${shiro.custom.enabled:true}")
  private boolean shiroEnabled;

  public void reloadInfo() {

    AbstractShiroFilter shiroFilter = null;
    try {
      //获取过滤管理器
      shiroFilter = (AbstractShiroFilter) shiroFilterFactoryBean.getObject();
      PathMatchingFilterChainResolver filterChainResolver =
          (PathMatchingFilterChainResolver) shiroFilter.getFilterChainResolver();
      DefaultFilterChainManager manager =
          (DefaultFilterChainManager) filterChainResolver.getFilterChainManager();
      //清空初始权限数据
      manager.getFilterChains().clear();
      shiroFilterFactoryBean.getFilterChainDefinitionMap().clear();
      //重新构建权限
      shiroFilterFactoryBean.setFilterChainDefinitionMap(getFilterMap());
      Map<String, String> chain = shiroFilterFactoryBean.getFilterChainDefinitionMap();
      for (Map.Entry<String, String> entry : chain.entrySet()) {
        manager.createChain(entry.getKey(), entry.getValue().trim().replace(" ", ""));
      }
    } catch (Exception e) {
      logger.error("reload Authorization error !", e);
    }
  }

  private Map<String, String> getFilterMap() {
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
    if (shiroEnabled) {
      //====从数据库中加载所有菜单和角色信息
      ResultDTO allResAndRoles = resService.getAllResAndRoles();
      @SuppressWarnings("unchecked")
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
    return filterChainDefinitionMap;
  }
}
