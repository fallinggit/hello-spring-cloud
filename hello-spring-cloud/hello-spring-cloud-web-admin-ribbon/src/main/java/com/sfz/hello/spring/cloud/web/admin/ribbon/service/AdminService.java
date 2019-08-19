package com.sfz.hello.spring.cloud.web.admin.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AdminService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String sayHi(String message){
        return restTemplate.getForObject("http://HELLO-SPRING-CLOUD-SERVICE-ADMIN/hi?message=" + message, String.class);
    }

    public String hiError(String message){
        return String.format("hi your me ssage is %s but request error ",message);
    }
}
