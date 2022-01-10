package com.jx.agile.code.genarator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.jx.agile.code.config.CodeInjectionConfig;
import com.jx.agile.code.config.CodePackageConfig;
import com.jx.agile.core.utils.ResultUtils;
import com.jx.agile.core.utils.StringUtils;
import com.jx.agile.core.web.Result;

/**
 * https://gitee.com/baomidou/mybatis-plus-samples
 * mybatis-plus使用事例
 */
@RestController
public class CodeGeneratorController {

    @Autowired
    private DataSourceConfig dataSourceConfig;

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    @GetMapping("/autoCode")
    public Result autoCode(String author,String packages,String module,String fun,String tableName,String prefix,String projectPath) {
        boolean checkParams = StringUtils.isBlank(author)
                || StringUtils.isBlank(module)
                || StringUtils.isBlank(tableName)
                || StringUtils.isBlank(prefix)
                || StringUtils.isBlank(fun)
                || StringUtils.isBlank(packages);
        if(checkParams){
            return ResultUtils.fail("缺少参数").addBizInfo("author=XXX&module=user&tableName=t_user&prefix=t_");
        }
        // 代码生成器
        CodeAutoGenerator mpg = new CodeAutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        if(StringUtils.isBlank(projectPath)){
            projectPath = System.getProperty("user.dir")+"/cloud-platform-"+module+"/cloud-platform-"+module;
        }
        String finalProjectPath = projectPath;

      //  gc.setOutputDir(finalProjectPath+"/cloud-platform-"+module + "/src/main/java");
        gc.setAuthor(author);
        gc.setOpen(false);
        gc.setBaseResultMap(true);
        gc.setEnableCache(true);
        gc.setBaseColumnList(true);
//
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        mpg.setDataSource(dataSourceConfig);

        // 包配置
        CodePackageConfig pc = new CodePackageConfig();
        pc.setModuleName(module);
        pc.setParent(packages);
        pc.setController("controller."+fun);
        pc.setEntity("client."+fun+".model.entity");
        pc.setService("client."+fun+".api");
        pc.setConstant("client."+fun+".constant");
        pc.setQueryParam("client."+fun+".params");
        pc.setOptParam("client."+fun+".params");

//       // pc.setService("query");
        pc.setServiceImpl("service."+fun+".impl");
        pc.setQueryWapper("service."+fun+".wrapper");
        pc.setUpdateWapper("service."+fun+".wrapper");

        pc.setMapper("mysql.mapper");

        mpg.setPackageInfo(pc);


        // 自定义配置
        CodeInjectionConfig cfg = new CodeInjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return finalProjectPath + "-dao/src/main/resources/mysql/mapper"
                        + "/"+fun+"/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        // dao
        focList.add(new FileOutConfig("/templates/mapper.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return finalProjectPath + "-dao/src/main/java/com/jx/agile/" +pc.getModuleName()+ "/mysql/mapper"
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_JAVA;
            }
        });

        //controller
        focList.add(new FileOutConfig("/templates/controller.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return finalProjectPath + "-controller/src/main/java/com/jx/agile/" +pc.getModuleName()+ "/controller/"+fun
                        + "/" + tableInfo.getEntityName() + "Controller" + StringPool.DOT_JAVA;
            }
        });

        //client
        focList.add(new FileOutConfig("/templates/service.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return finalProjectPath + "-client/src/main/java/com/jx/agile/" +pc.getModuleName()+ "/client/"+fun+"/api/"
                        + "/I" + tableInfo.getEntityName() + "Service" + StringPool.DOT_JAVA;
            }
        });

        //entity
        focList.add(new FileOutConfig("/templates/entity.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return finalProjectPath + "-client/src/main/java/com/jx/agile/" +pc.getModuleName()+ "/client/"+fun+"/model/entity"
                        + "/" + tableInfo.getEntityName()  + StringPool.DOT_JAVA;
            }
        });

        //constant
        focList.add(new FileOutConfig("/templates/constant.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return finalProjectPath + "-client/src/main/java/com/jx/agile/" +pc.getModuleName()+ "/client/"+fun+"/constant/"
                        + "/" + tableInfo.getEntityName() + "Constant" + StringPool.DOT_JAVA;
            }
        });

        //optParam
        focList.add(new FileOutConfig("/templates/optParam.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return finalProjectPath + "-client/src/main/java/com/jx/agile/" +pc.getModuleName()+ "/client/"+fun+"/params/"
                        + "/" + tableInfo.getEntityName() + "OptParam" + StringPool.DOT_JAVA;
            }
        });

        //queryParam
        focList.add(new FileOutConfig("/templates/queryParam.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return finalProjectPath + "-client/src/main/java/com/jx/agile/" +pc.getModuleName()+ "/client/"+fun+"/params/"
                        + "/" + tableInfo.getEntityName() + "QueryParam" + StringPool.DOT_JAVA;
            }
        });

        //service
        focList.add(new FileOutConfig("/templates/serviceImpl.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return finalProjectPath + "-service/src/main/java/com/jx/agile/" +pc.getModuleName()+ "/service/"+fun+"/impl"
                        + "/" + tableInfo.getEntityName() + "ServiceImpl" + StringPool.DOT_JAVA;
            }
        });

        //query
        focList.add(new FileOutConfig("/templates/queryWapper.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return finalProjectPath + "-service/src/main/java/com/jx/agile/" +pc.getModuleName()+ "/service/"+fun+"/wrapper"
                        + "/" + tableInfo.getEntityName() + "QueryWrapper" + StringPool.DOT_JAVA;
            }
        });


        //update
        focList.add(new FileOutConfig("/templates/updateWapper.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return finalProjectPath + "-service/src/main/java/com/jx/agile/" +pc.getModuleName()+ "/service/"+fun+"/wrapper"
                        + "/" + tableInfo.getEntityName() + "UpdateWrapper" + StringPool.DOT_JAVA;
            }
        });


        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        //templateConfig.setXml("templates/mapper.xml");
        //templateConfig.setService("/template/query.java");
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);

        strategy.setEntityLombokModel(true);

        strategy.setRestControllerStyle(true);
        // 公共父类
        //strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
        // 写于父类中的公共字段

        strategy.setInclude(tableName);
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setEntityTableFieldAnnotationEnable(true);
        strategy.setTablePrefix(prefix);

        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new CodeFreemarkerTemplateEngine());
        mpg.execute();
        return ResultUtils.success();
    }
}
