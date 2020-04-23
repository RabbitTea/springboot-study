package com.sandra.staffmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 */
@Controller
public class IndexController {

    /**
     * {}表示一个数组，用户请求其中的URL都会访问到这个方法;
     * 该方法内容与自定义的MyMvcConfig类中实现的添加视图控制方法的内容一致（MyMvcConfig类就是把原来在web.xml配置的内容代码化）；
     * 所以这里注释掉，使用springboot推荐的方法；
     * @return
     */
    //@RequestMapping({"/", "/index.html"})
    //public String index() {
    //    return "index";
    //}

    /**
     * 这里Controller进行首页的视图控制可以完全由MyMvcConfig类中的addViewControllers方法来实现
     */
}
