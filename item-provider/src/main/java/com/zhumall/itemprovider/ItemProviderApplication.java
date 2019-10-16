package com.zhumall.itemprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

//@EnableEurekaClient
@SpringBootApplication
@ComponentScan(basePackages = {"com.zhumall.manage.provider","com.zhumall.itemprovider","com.zhumall.commonutils"})
//@EnableDiscoveryClient
//@MapperScan(basePackages = "com.zhumall.itemprovider.dao")
public class ItemProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItemProviderApplication.class, args);
    }

}
