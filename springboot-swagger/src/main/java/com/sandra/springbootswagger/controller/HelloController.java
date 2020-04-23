package com.sandra.springbootswagger.controller;

import com.sandra.springbootswagger.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class HelloController {

    @GetMapping(value = "/hello")
    public String hello() {
        return "hello";
    }

    // 只要我们的接口返回值中存在实体类，就会被swagger扫描
    @PostMapping("/user")
    public User user() {
        return new User();
    }

    @ApiOperation("Hello控制类")  //接口方法注释
    @GetMapping(value = "/hello2")
    public String hello(@ApiParam("用户名") String username) {
        return "hello" + username;
    }

}
