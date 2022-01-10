package com.jx.agile.basic.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import io.github.yedaxia.apidocs.Docs;
import io.github.yedaxia.apidocs.DocsConfig;

/**
 * @Auther: auqtfqiqpl
 * @Date: 2021/02/24/18:31
 * @Description:
 */
@EnableEurekaClient
@ComponentScan(value = "com.jx.agile.**")
@MapperScan(value = "com.jx.agile.*.mysql.mapper.**")
@EnableAspectJAutoProxy
@SpringBootApplication
public class BasicWebApplication {

    public static void main(String[] args) {
        DocsConfig config = new DocsConfig();
        config.setProjectPath("D:\\jxh\\code\\self"); // root project path
        config.setProjectName("ProjectName"); // project name
        config.setApiVersion("V1.0");       // api version
        config.setDocsPath("D:\\jxh\\code\\self\\doc"); // api docs target path
        config.setAutoGenerate(Boolean.TRUE);  // auto generate
        Docs.buildHtmlDocs(config); // execute to generate
        SpringApplication.run(BasicWebApplication.class);
    }
}
