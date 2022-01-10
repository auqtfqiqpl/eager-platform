package com.jx.agile.code.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.generator.config.DataSourceConfig;

/**
 * @Auther: auqtfqiqpl
 * @Date: 2021/03/03/15:04
 * @Description:
 */
@Configuration
public class PlusDataSourceConfig {


    @Autowired
    private DataSourceProperties  dataSourceProperties;

    @Bean
    public DataSourceConfig dataSourceConfig(){
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl(dataSourceProperties.getUrl());
        dataSourceConfig.setDriverName(dataSourceProperties.getDriverClassName());
        dataSourceConfig.setUsername(dataSourceProperties.getUserName());
        dataSourceConfig.setPassword(dataSourceProperties.getPassword());
        return dataSourceConfig;
    }
}
