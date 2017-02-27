package com.didispace.web;

import com.didispace.service.ComputeClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    ComputeClient computeClient;
    
    @HystrixCommand(fallbackMethod = "addServiceFallback")//加一个断路由，如果程序出错不会一直阻塞，调用一个出错时候的机制放啊
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add() {
        return computeClient.add(10, 20);
    }
    
    public Integer addServiceFallback() {
        return 102;
    }

}