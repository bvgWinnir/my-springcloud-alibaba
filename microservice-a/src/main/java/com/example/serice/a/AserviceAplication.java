package com.example.serice.a;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Classname AserviceAplication
 * @Description TODO
 * @Date 2021/4/19 23:26
 * @Created by guochen
 */

@EnableDiscoveryClient
@SpringBootApplication
public class AserviceAplication {

    public static void main(String[] args) {
        SpringApplication.run(AserviceAplication.class, args);
    }

}