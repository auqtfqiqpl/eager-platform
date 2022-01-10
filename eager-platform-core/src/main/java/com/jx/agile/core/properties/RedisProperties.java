package com.jx.agile.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * @Auther: auqtfqiqpl
 * @Date: 2021/03/03/16:27
 * @Description:
 */
@Data
@Component
@ConfigurationProperties(prefix = "spring.redis")
public class RedisProperties {

    private String host;
    private int port;
    private int timeout;
    private String password;
}
