package com.tianhaolin.hystrix.activity.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 处理注册、登录、相关活动
 */
@RestController
public class LoginActivityController {
    @PostMapping("/firstLoginActivity")
    public String firstLoginActivity(@RequestBody Long id){
        System.out.println("LoginActivityController 为首次登录(注册)用户发放优惠券成功"+id);
        return "success";
    }

}
