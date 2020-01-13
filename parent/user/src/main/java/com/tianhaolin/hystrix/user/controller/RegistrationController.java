package com.tianhaolin.hystrix.user.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.tianhaolin.hystrix.user.entity.User;
import com.tianhaolin.hystrix.user.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class RegistrationController {

    @Autowired
    private ActivityService activityService;

    @PostMapping("/userRegistration")
    @HystrixCommand(
            fallbackMethod = "firstLoginFallBack",
            commandProperties = {
                    //HystrixCommandProperties中提供了相关配置
                    @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="2000")//设定超时时间
            }
    )
    public String userRegistration(@RequestBody User user) throws InterruptedException {
        System.out.println("用户注册成功:" + user.getName());
        Thread.sleep(new Random().nextInt(4000));
        return activityService.firstLogin(user.getId());
    }

    public String firstLoginFallBack(@RequestBody User user){
        return "fallback";
    }

}
