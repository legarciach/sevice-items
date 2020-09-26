package com.springboot.app.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ServiceItemsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceItemsApplication.class, args);
    }

}
