package com.sandra.springbootshiro.config;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

/**
 */
public class ShiroConfig {

    /**
     *  ShiroFilterFactoryBean
      */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {

        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();

        // 设置安全管理器
        factoryBean.setSecurityManager(securityManager);


        /**
         * 登录拦截
         *
         *  添加shiro的内置过滤器
         *
         *  anon：无需认证就可以访问
         *  authc：必须认证了才能访问
         *  user：必须拥有 记住我 功能才能用
         *  perms：拥有对某个资源的权限才能访问
         *  role：拥有某个角色权限才能访问
         */
        Map<String, String> filterMap = new LinkedHashMap<>();

        filterMap.put("/user/add", "authc");
        filterMap.put("/user/update", "authc");

        // 授权
        filterMap.put("/user/add", "perms[user:add]");

        factoryBean.setFilterChainDefinitionMap(filterMap);

        // 设置登录的请求
        factoryBean.setLoginUrl("/toLogin");

        // 未授权页面
        factoryBean.setUnauthorizedUrl("/noauth");


        return factoryBean;
    }



    /**
     * DefaultWebSecurityManager
     */
    @Bean(name="securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm realm) {

        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 关联realm，通过spring管理；通过@Qualifier注解中的方法名（或@Bean中的name属性）指定需要spring注入的具体的bean
        securityManager.setRealm(realm);
        return securityManager;
    }

    /**
     * 创建realm对象，需要自定义类
     */
    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }

    /**
     * 整合shiroDialect：用来整合shiro thymeleaf
     */
    @Bean
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }
}
