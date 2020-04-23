package com.sandra.staffmanagement.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 */
@Controller
public class LoginController {

    /**
     * 登录用户
     * @param username
     * @param password
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/user/login")
    //@ResponseBody
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
                        Model model, HttpSession session) {

        // 具体的业务
        if (!StringUtils.isEmpty(username) && "123456".equals(password)){

            session.setAttribute("loginUser", username);

            // dashboard
            return "redirect:/main.html";
        } else {
            // 告诉用户登录失败
            model.addAttribute("msg", "用户名或密码错误");
            return "index";
        }
    }

    /**
     * 注销用户
     * @param session
     * @return
     */
    @RequestMapping("/user/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/index.html";
    }
}
