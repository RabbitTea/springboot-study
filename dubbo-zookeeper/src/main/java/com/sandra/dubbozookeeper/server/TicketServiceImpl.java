package com.sandra.dubbozookeeper.server;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 *
 */
@Service  // 这里使用dubbo提供的注解，使其可以被扫描到，在项目启动时就自动注册到注册中心
@Component  // 使用了dubbo后尽量不要使用service注解，因为dubbo也有同名注解
public class TicketServiceImpl implements TicketService {

    @Override
    public String getTicket() {
        return "Hello，Sandra";
    }
}
