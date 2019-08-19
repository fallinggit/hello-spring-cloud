package com.sfz.hello.spring.cloud.web.admin.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@EnableHystrixDashboard //熔断器仪表盘 监视熔断器
public class WebAdminFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebAdminFeignApplication.class,args);
    }
}
