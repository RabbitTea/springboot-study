package com.sandra.staffmanagement.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 登录验证拦截器
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {

        // 登录成功后，保存用户的session
        Object loginUser = request.getSession().getAttribute("loginUser");

        // 没有登录
        if (loginUser == null){
            request.setAttribute("msg", "没有权限，请先登录");
            request.getRequestDispatcher("/index.html").forward(request, response);
            return false;
        } else {
            return true;
        }
    }
}
