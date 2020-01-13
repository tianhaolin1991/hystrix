package com.tianhaolin.hystrix.user.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ActivityService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(
            fallbackMethod = "firstLoginFallBack",
            commandProperties = {
                    //HystrixCommandProperties中提供了相关配置
                    @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="2000")//设定超时时间
            }
    )
    public String firstLogin(Long id) {
        return restTemplate.postForObject("http://activity/firstLoginActivity",id,String.class);
    }

    public String firstLoginFallBack(Long id){
        return "fallback";
    }
}
