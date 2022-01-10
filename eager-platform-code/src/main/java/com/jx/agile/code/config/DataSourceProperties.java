package com.jx.agile.code.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * @Auther: auqtfqiqpl
 * @Date: 2021/03/03/15:41
 * @Description:
 */
@Data
@Component
@ConfigurationProperties(prefix = "spring.datasource")
public class DataSourceProperties {

    private String url;

    private String driverClassName;

    private String userName;


    private String password;
}
