package com.example.serice.b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Classname BserviceAplication
 * @Description TODO
 * @Date 2021/4/19 23:29
 * @Created by guochen
 */

@EnableDiscoveryClient
@SpringBootApplication
public class BserviceAplication {

    public static void main(String[] args) {
        SpringApplication.run(BserviceAplication.class, args);
    }

}
