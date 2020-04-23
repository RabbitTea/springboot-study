package com.sandra.springbootstudy.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 全面扩展SpringMVC;
 * 比如原来要实现自定义的拦截器，需要创建一个类实现拦截器的接口，现在只需要自定义这样的配置类，重写其中对应的方法即可。
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    //ViewResolver 实现了视图解析器的类，就可以称为视图解析器

    /**
     * 自定义拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

    }

    /**
     * 让自定义的视图解析器被Springboot接管装配
     * @return
     */
    @Bean
    public  ViewResolver myViewResolver(){
        return new MyViewResolver();
    }

    /**
     * 自定义一个视图解析器
     */
    public static class MyViewResolver implements ViewResolver {
        @Override
        public View resolveViewName(String viewName, Locale locale) throws Exception {
            return null;
        }
    }

    /**
     * 自定义视图跳转
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/sandra").setViewName("test");
    }
}
