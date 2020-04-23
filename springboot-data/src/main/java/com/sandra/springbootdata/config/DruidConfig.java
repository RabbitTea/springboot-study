package com.sandra.springbootdata.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 */
@Configuration
public class DruidConfig {

    /**
     * 绑定yml文件中的属性配置；
     * 由Spring接管；
     * @return
     */
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    /**
     * 后台监控： 相当于 web.xml
     * 因为springboot 内置了servlet容器，所以没有web.xml，替代方法：ServletRegistrationBean
     *
     * 注册servlet
     *
     * http://localhost:8080/druid
     * 默认会跳到login.html
     *
     * 输入这里配置的用户名和密码，可登录druid监控后台
     */
    @Bean
    public ServletRegistrationBean statViewServlet() {

        ServletRegistrationBean<StatViewServlet> srb = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

        // druid监控后台登录的账号密码配置

        HashMap<String, String> initParameters = new HashMap<>();
        // 增加配置：登录的key是固定的
        initParameters.put("loginUsername", "admin");
        initParameters.put("loginPassword", "123456");

        // 访问权限：value为空表示所有人均可访问；localhost表示仅本机可访问；
        initParameters.put("allow","");

        // 禁止访问 initParameters.put("sandra", "192.168.11.123");  key为用户名，value为IP地址


        // 设置初始化参数
        srb.setInitParameters(initParameters);

        return srb;
    }


    /**
     * filter
     */
    @Bean
    public FilterRegistrationBean webStatFilter() {

        FilterRegistrationBean bean = new FilterRegistrationBean();

        bean.setFilter(new WebStatFilter());

        // 可过滤的请求
        Map<String, String> initParameters = new HashMap<>();

        // 这些value不进行统计
        initParameters.put("exclusions", ".js,*.css,/druid/*");

        bean.setInitParameters(initParameters);

        return bean;
    }
}
