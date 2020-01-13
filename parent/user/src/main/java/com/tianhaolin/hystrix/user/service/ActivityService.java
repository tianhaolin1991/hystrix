package com.tianhaolin.hystrix.user.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ActivityService {

    @Autowired
    private RestTemplate restTemplate;


    public String firstLogin(Long id) {
        return restTemplate.postForObject("http://activity/firstLoginActivity",id,String.class);
    }

}
