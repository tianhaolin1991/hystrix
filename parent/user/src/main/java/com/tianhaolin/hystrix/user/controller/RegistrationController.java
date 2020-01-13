package com.tianhaolin.hystrix.user.controller;

import com.tianhaolin.hystrix.user.entity.User;
import com.tianhaolin.hystrix.user.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private ActivityService activityService;

    @PostMapping("/userRegistration")
    public String userRegistration(@RequestBody User user){
        System.out.println("用户注册成功:" + user.getName());
        return activityService.firstLogin(user.getId());
    }

}
