package com.sandra.springbootstudy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * springboot中的热部署，就是在pom.xml引入devtools依赖；
 */
@RestController   //或者这里用@Controller，在方法上加@ResponseBody
@RequestMapping("/hello")
public class HelloController {

    /**
     * 接口：http://localhost:8080/hello
     * 启动Springboot后，可以直接输入上面的地址访问；
     * @return
     */
    @RequestMapping("/h1")
    public String hello() {

        //调用业务，接收前端参数

        return "hello, world!";
    }
}
