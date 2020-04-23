package com.sandra.springboottask.controller;

import com.sandra.springboottask.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class AsyncController {

    @Autowired
    AsyncService asyncService;

    @RequestMapping("/hello")
    public String hello() {
        // 停三秒（网站显示转圈）
        asyncService.hello();
        return "OK";
    }
}
