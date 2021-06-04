package com.example.serice.a;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author GUOCHEN
 * @Classname AserviceAplication
 * @Description TODO
 * @Date 2021/4/19 23:26
 * @Created by guochen
 */
@EnableFeignClients(basePackages = "com.example.serice.a.fegin")
@EnableDiscoveryClient
@SpringBootApplication
@RefreshScope
@Slf4j
public class AserviceAplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(AserviceAplication.class, args);
        String userName = applicationContext.getEnvironment().getProperty("user.name");
        String userAge = applicationContext.getEnvironment().getProperty("user.age");
        System.err.println("user name :"+userName+"; age: "+userAge);
        System.err.println("以上不为null 表示从nacos 中读到配置了");
        log.info("user name:{}   ->userAge:{}",userName,userAge);
        log.info("以上不为null 表示从nacos 中读到配置了");
    }

}
