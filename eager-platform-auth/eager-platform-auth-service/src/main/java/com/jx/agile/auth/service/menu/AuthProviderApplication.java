package com.jx.agile.auth.service.menu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Auther: auqtfqiqpl
 * @Date: 2021/02/24/18:31
 * @Description:
 */
@EnableEurekaClient
@ComponentScan(value = "com.jx.agile.**")
@MapperScan(value="com.jx.agile.*.dao")
@EnableAspectJAutoProxy
@SpringBootApplication
public class AuthProviderApplication {

    public static void main(String[] args) {

        SpringApplication.run(AuthProviderApplication.class);
    }
}
