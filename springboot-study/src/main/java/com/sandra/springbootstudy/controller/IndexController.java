package com.sandra.springbootstudy.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 在templates目录下的所有页面，只能通过controller来跳转
 */
@Controller
public class IndexController {

    @RequestMapping("/test")
    public String index(Model model) {

        model.addAttribute("msg", "<h1>hello, springboot!</h1>");

        model.addAttribute("users", Arrays.asList("sandra", "yy"));

        return "test";
    }
}
