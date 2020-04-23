package com.sandra.springboottask.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class AsyncService {

    /**
     * 告诉spring这是一个异步的方法；且需要在main方法开启异步功能;
     *
     * 后台等待三秒钟，但是前台秒刷新；这就是异步任务
     */
    @Async
    public void hello() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("数据正在处理....");
    }
}
