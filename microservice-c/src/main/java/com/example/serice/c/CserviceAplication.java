package com.example.serice.c;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Classname CserviceAplication
 * @Description TODO
 * @Date 2021/4/19 23:30
 * @Created by guochen
 */
@EnableDiscoveryClient
@SpringBootApplication
public class CserviceAplication {

    public static void main(String[] args) {
        SpringApplication.run(CserviceAplication.class, args);
    }

}