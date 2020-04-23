package com.sandra.dubbozookeeper.client;

import com.sandra.dubbozookeeper.server.TicketService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * 应该客户端和服务端创建两个模块会比较好模拟；就是两个jar包
 */
@Service // 放到spring容器中
public interface UserService {

    // 调用不同服务器上的server服务
    // 去注册中心拿到服务
    //@Reference //引用 法1.引入pom坐标； 法2.可以定义路径相同的接口名
    //TicketService ticketService;

    //public void buyTicket() {
    //    String ticket = ticketService.getTicket();
    //    System.out.println("在注册中心拿到=>"+ticket);
    //}
}
