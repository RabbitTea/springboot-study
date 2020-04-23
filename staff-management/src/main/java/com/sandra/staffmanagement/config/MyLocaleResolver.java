package com.sandra.staffmanagement.config;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

/**
 * 自定义自己的国际化解析器
 */
public class MyLocaleResolver implements LocaleResolver {

    /**
     * 解析请求
     * 仿照源码的样式写；
     *
     * @param request
     * @return
     */
    @Override
    public Locale resolveLocale(HttpServletRequest request) {

        // 获取请求中的语言参数
        String language = request.getParameter("l");

        Locale locale = Locale.getDefault();

        // 如果请求的链接携带了国际化的参数
        if (!StringUtils.isEmpty(language)) {
            // zh_CN
            String[] split = language.split("_");
            // 国家，地区
           locale = new Locale(split[0], split[1]);

        }

        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
