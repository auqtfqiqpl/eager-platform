package com.jx.agile.code.genarator;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.toolkit.PackageHelper;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.FileType;
import com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine;
import com.jx.agile.code.config.CodeConfigBuilder;
import com.jx.agile.code.config.CodeInjectionConfig;

/**
 * @Auther: auqtfqiqpl
 * @Date: 2021/03/05/14:01
 * @Description:
 */
public abstract class CodeAbstractTemplateEngine {

    protected static final Logger logger = LoggerFactory.getLogger(AbstractTemplateEngine.class);
    private CodeConfigBuilder configBuilder;

    public CodeAbstractTemplateEngine() {
    }

    public CodeAbstractTemplateEngine init(CodeConfigBuilder configBuilder) {
        this.configBuilder = configBuilder;
        return this;
    }

    public CodeAbstractTemplateEngine batchOutput() {
        try {
            List<TableInfo> tableInfoList = this.getCodeConfigBuilder().getTableInfoList();
            Iterator var2 = tableInfoList.iterator();

            while(var2.hasNext()) {
                TableInfo tableInfo = (TableInfo)var2.next();
                Map<String, Object> objectMap = this.getObjectMap(tableInfo);
                Map<String, String> pathInfo = this.getCodeConfigBuilder().getPathInfo();
                TemplateConfig template = this.getCodeConfigBuilder().getTemplate();
                CodeInjectionConfig injectionConfig = this.getCodeConfigBuilder().getInjectionConfig();
                if (null != injectionConfig) {
                    injectionConfig.initMap();
                    objectMap.put("cfg", injectionConfig.getMap());
                    List<FileOutConfig> focList = injectionConfig.getFileOutConfigList();
                    if (CollectionUtils.isNotEmpty(focList)) {
                        Iterator var9 = focList.iterator();

                        while(var9.hasNext()) {
                            FileOutConfig foc = (FileOutConfig)var9.next();
                            if (this.isCreate(FileType.OTHER, foc.outputFile(tableInfo))) {
                                this.writer(objectMap, foc.getTemplatePath(), foc.outputFile(tableInfo));
                            }
                        }
                    }
                }

                String entityName = tableInfo.getEntityName();
                String controllerFile;
                if (null != entityName && null != pathInfo.get("entity_path")) {
                    controllerFile = String.format((String)pathInfo.get("entity_path") + File.separator + "%s" + this.suffixJavaOrKt(), entityName);
                    if (this.isCreate(FileType.ENTITY, controllerFile)) {
                        this.writer(objectMap, this.templateFilePath(template.getEntity(this.getCodeConfigBuilder().getGlobalConfig().isKotlin())), controllerFile);
                    }
                }

                if (null != tableInfo.getMapperName() && null != pathInfo.get("mapper_path")) {
                    controllerFile = String.format((String)pathInfo.get("mapper_path") + File.separator + tableInfo.getMapperName() + this.suffixJavaOrKt(), entityName);
                    if (this.isCreate(FileType.MAPPER, controllerFile)) {
                        this.writer(objectMap, this.templateFilePath(template.getMapper()), controllerFile);
                    }
                }

                if (null != tableInfo.getXmlName() && null != pathInfo.get("xml_path")) {
                    controllerFile = String.format((String)pathInfo.get("xml_path") + File.separator + tableInfo.getXmlName() + ".xml", entityName);
                    if (this.isCreate(FileType.XML, controllerFile)) {
                        this.writer(objectMap, this.templateFilePath(template.getXml()), controllerFile);
                    }
                }

                if (null != tableInfo.getServiceName() && null != pathInfo.get("service_path")) {
                    controllerFile = String.format((String)pathInfo.get("service_path") + File.separator + tableInfo.getServiceName() + this.suffixJavaOrKt(), entityName);
                    if (this.isCreate(FileType.SERVICE, controllerFile)) {
                        this.writer(objectMap, this.templateFilePath(template.getService()), controllerFile);
                    }
                }

                if (null != tableInfo.getServiceImplName() && null != pathInfo.get("service_impl_path")) {
                    controllerFile = String.format((String)pathInfo.get("service_impl_path") + File.separator + tableInfo.getServiceImplName() + this.suffixJavaOrKt(), entityName);
                    if (this.isCreate(FileType.SERVICE_IMPL, controllerFile)) {
                        this.writer(objectMap, this.templateFilePath(template.getServiceImpl()), controllerFile);
                    }
                }

                if (null != tableInfo.getControllerName() && null != pathInfo.get("controller_path")) {
                    controllerFile = String.format((String)pathInfo.get("controller_path") + File.separator + tableInfo.getControllerName() + this.suffixJavaOrKt(), entityName);
                    if (this.isCreate(FileType.CONTROLLER, controllerFile)) {
                        this.writer(objectMap, this.templateFilePath(template.getController()), controllerFile);
                    }
                }
            }
        } catch (Exception var11) {
            logger.error("无法创建文件，请检查配置信息！", var11);
        }

        return this;
    }

    public abstract void writer(Map<String, Object> objectMap, String templatePath, String outputFile) throws Exception;

    public CodeAbstractTemplateEngine mkdirs() {
        this.getCodeConfigBuilder().getPathInfo().forEach((key, value) -> {
            File dir = new File(value);
            if (!dir.exists()) {
                boolean result = dir.mkdirs();
                if (result) {
                    logger.debug("创建目录： [" + value + "]");
                }
            }

        });
        return this;
    }

    public void open() {
        String outDir = this.getCodeConfigBuilder().getGlobalConfig().getOutputDir();
        if (this.getCodeConfigBuilder().getGlobalConfig().isOpen() && StringUtils.isNotEmpty(outDir)) {
            try {
                String osName = System.getProperty("os.name");
                if (osName != null) {
                    if (osName.contains("Mac")) {
                        Runtime.getRuntime().exec("open " + outDir);
                    } else if (osName.contains("Windows")) {
                        Runtime.getRuntime().exec("cmd /c start " + outDir);
                    } else {
                        logger.debug("文件输出目录:" + outDir);
                    }
                }
            } catch (IOException var3) {
                var3.printStackTrace();
            }
        }

    }

    public Map<String, Object> getObjectMap(TableInfo tableInfo) {
        Map<String, Object> objectMap = new HashMap(30);
        CodeConfigBuilder config = this.getCodeConfigBuilder();
        if (config.getStrategyConfig().isControllerMappingHyphenStyle()) {
            objectMap.put("controllerMappingHyphenStyle", config.getStrategyConfig().isControllerMappingHyphenStyle());
            objectMap.put("controllerMappingHyphen", StringUtils.camelToHyphen(tableInfo.getEntityPath()));
        }

        objectMap.put("restControllerStyle", config.getStrategyConfig().isRestControllerStyle());
        objectMap.put("config", config);
        objectMap.put("package", config.getPackageInfo());
        GlobalConfig globalConfig = config.getGlobalConfig();
        objectMap.put("author", globalConfig.getAuthor());
        objectMap.put("idType", globalConfig.getIdType() == null ? null : globalConfig.getIdType().toString());
        objectMap.put("logicDeleteFieldName", config.getStrategyConfig().getLogicDeleteFieldName());
        objectMap.put("versionFieldName", config.getStrategyConfig().getVersionFieldName());
        objectMap.put("activeRecord", globalConfig.isActiveRecord());
        objectMap.put("kotlin", globalConfig.isKotlin());
        objectMap.put("swagger2", globalConfig.isSwagger2());
        objectMap.put("date", (new SimpleDateFormat("yyyy-MM-dd")).format(new Date()));
        objectMap.put("table", tableInfo);
        objectMap.put("enableCache", globalConfig.isEnableCache());
        objectMap.put("baseResultMap", globalConfig.isBaseResultMap());
        objectMap.put("baseColumnList", globalConfig.isBaseColumnList());
        objectMap.put("entity", tableInfo.getEntityName());
        objectMap.put("entitySerialVersionUID", config.getStrategyConfig().isEntitySerialVersionUID());
        objectMap.put("entityColumnConstant", config.getStrategyConfig().isEntityColumnConstant());
        objectMap.put("entityBuilderModel", config.getStrategyConfig().isEntityBuilderModel());
        objectMap.put("entityLombokModel", config.getStrategyConfig().isEntityLombokModel());
        objectMap.put("entityBooleanColumnRemoveIsPrefix", config.getStrategyConfig().isEntityBooleanColumnRemoveIsPrefix());
        objectMap.put("superEntityClass", this.getSuperClassName(config.getSuperEntityClass()));
        objectMap.put("superMapperClassPackage", config.getSuperMapperClass());
        objectMap.put("superMapperClass", this.getSuperClassName(config.getSuperMapperClass()));
        objectMap.put("superServiceClassPackage", config.getSuperServiceClass());
        objectMap.put("superServiceClass", this.getSuperClassName(config.getSuperServiceClass()));
        objectMap.put("superServiceImplClassPackage", config.getSuperServiceImplClass());
        objectMap.put("superServiceImplClass", this.getSuperClassName(config.getSuperServiceImplClass()));
        objectMap.put("superControllerClassPackage", config.getSuperControllerClass());
        objectMap.put("superControllerClass", this.getSuperClassName(config.getSuperControllerClass()));
        return config.getInjectionConfig().prepareObjectMap(objectMap);
    }

    private String getSuperClassName(String classPath) {
        return StringUtils.isEmpty(classPath) ? null : classPath.substring(classPath.lastIndexOf(".") + 1);
    }

    public abstract String templateFilePath(String filePath);

    protected boolean isCreate(FileType fileType, String filePath) {
        CodeConfigBuilder cb = this.getCodeConfigBuilder();
        CodeInjectionConfig ic = cb.getInjectionConfig();
        if (null != ic && null != ic.getFileCreate()) {
            return ic.getFileCreate().isCreate(cb, fileType, filePath);
        } else {
            File file = new File(filePath);
            boolean exist = file.exists();
            if (!exist) {
                PackageHelper.mkDir(file.getParentFile());
            }

            return !exist || this.getCodeConfigBuilder().getGlobalConfig().isFileOverride();
        }
    }

    protected String suffixJavaOrKt() {
        return this.getCodeConfigBuilder().getGlobalConfig().isKotlin() ? ".kt" : ".java";
    }

    public CodeConfigBuilder getCodeConfigBuilder() {
        return this.configBuilder;
    }

    public CodeAbstractTemplateEngine setCodeConfigBuilder(CodeConfigBuilder configBuilder) {
        this.configBuilder = configBuilder;
        return this;
    }
}
