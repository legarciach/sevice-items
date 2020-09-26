package com.springboot.app.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@RibbonClient(name = "service-productos")
public class ServiceItemsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceItemsApplication.class, args);
    }

}
