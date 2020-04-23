package com.sandra.staffmanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 原来Spring或web的控制都在Java类中完成；
 *
 * JavaConfig
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    /**
     * 自定义视图控制
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        // 页面url映射
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");

    }

    /**
     * 注册自定义的国际化组件
     * @return
     */
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }

    /**
     * 自定义拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LoginHandlerInterceptor())
            .addPathPatterns("/**")
            .excludePathPatterns("/index.html", "/" , "/user/login", "/css/*", "/js/**", "/img/**");
    }
}
