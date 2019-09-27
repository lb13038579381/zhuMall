package com.zhumall.manage.provider;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(basePackages = "com.zhumall.manage.provider.dao")
public class manageProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(manageProviderApplication.class,args);
    }
}
