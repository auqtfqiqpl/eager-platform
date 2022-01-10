package com.jx.agile.code.config;

import com.baomidou.mybatisplus.generator.config.PackageConfig;

import lombok.Data;

/**
 * @Auther: auqtfqiqpl
 * @Date: 2021/03/04/10:41
 * @Description:
 */
@Data
public class CodePackageConfig  extends PackageConfig {

    private String constant = "constant";

    private String queryParam = "queryParam";

    private String optParam = "optParam";

    private String queryWapper = "queryWapper";


    private String updateWapper = "updateWapper";
}
