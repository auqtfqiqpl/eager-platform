package com.jx.agile.code.genarator;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.jx.agile.code.config.CodeConfigBuilder;
import com.jx.agile.code.config.CodeInjectionConfig;
import com.jx.agile.code.config.CodePackageConfig;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Auther: auqtfqiqpl
 * @Date: 2021/03/05/11:32
 * @Description:
 */
@Slf4j
@Data
public class CodeAutoGenerator{

    private static final Logger logger = LoggerFactory.getLogger(AutoGenerator.class);
    protected CodeConfigBuilder config;
    protected CodeInjectionConfig injectionConfig;
    private DataSourceConfig dataSource;
    private StrategyConfig strategy;
    private CodePackageConfig packageInfo;
    private TemplateConfig template;
    private GlobalConfig globalConfig;
    private CodeAbstractTemplateEngine templateEngine;

    public void execute() {
        logger.debug("==========================准备生成文件...==========================");
        if (null == this.config) {
            this.config = new CodeConfigBuilder(this.packageInfo, this.dataSource, this.strategy, this.template, this.globalConfig);
            if (null != this.injectionConfig) {
                this.injectionConfig.setConfig(this.config);
            }
        }

        if (null == this.templateEngine) {
            this.templateEngine = new CodeVelocityTemplateEngine();
        }

        this.templateEngine.init(this.pretreatmentConfigBuilder(this.config)).mkdirs().batchOutput().open();
        logger.debug("==========================文件生成完成！！！==========================");
    }

    protected List<TableInfo> getAllTableInfoList(CodeConfigBuilder config) {
        return config.getTableInfoList();
    }

    protected CodeConfigBuilder pretreatmentConfigBuilder(CodeConfigBuilder config) {
        if (null != this.injectionConfig) {
            this.injectionConfig.initMap();
            config.setInjectionConfig(this.injectionConfig);
        }

        List<TableInfo> tableList = this.getAllTableInfoList(config);
        Iterator var3 = tableList.iterator();

        while(var3.hasNext()) {
            TableInfo tableInfo = (TableInfo)var3.next();
            if (config.getGlobalConfig().isActiveRecord()) {
                tableInfo.setImportPackages(Model.class.getCanonicalName());
            }

            if (tableInfo.isConvert()) {
                tableInfo.setImportPackages(TableName.class.getCanonicalName());
            }

            if (config.getStrategyConfig().getLogicDeleteFieldName() != null && tableInfo.isLogicDelete(config.getStrategyConfig().getLogicDeleteFieldName())) {
                tableInfo.setImportPackages(TableLogic.class.getCanonicalName());
            }

            if (StringUtils.isNotEmpty(config.getStrategyConfig().getVersionFieldName())) {
                tableInfo.setImportPackages(Version.class.getCanonicalName());
            }

            boolean importSerializable = true;
            if (StringUtils.isNotEmpty(config.getSuperEntityClass())) {
                tableInfo.setImportPackages(config.getSuperEntityClass());
                importSerializable = false;
            }

            if (config.getGlobalConfig().isActiveRecord()) {
                importSerializable = true;
            }

            if (importSerializable) {
                tableInfo.setImportPackages(Serializable.class.getCanonicalName());
            }

            if (config.getStrategyConfig().isEntityBooleanColumnRemoveIsPrefix()) {
                tableInfo.getFields().stream().filter((field) -> {
                    return "boolean".equalsIgnoreCase(field.getPropertyType());
                }).filter((field) -> {
                    return field.getPropertyName().startsWith("is");
                }).forEach((field) -> {
                    field.setConvert(true);
                    field.setPropertyName(StringUtils.removePrefixAfterPrefixToLower(field.getPropertyName(), 2));
                });
            }
        }

        return config.setTableInfoList(tableList);
    }

    public CodeInjectionConfig getCfg() {
        return this.injectionConfig;
    }

    public CodeAutoGenerator setCfg(CodeInjectionConfig injectionConfig) {
        this.injectionConfig = injectionConfig;
        return this;
    }

    public CodeAutoGenerator() {
    }

    public CodeConfigBuilder getConfig() {
        return this.config;
    }

    public DataSourceConfig getDataSource() {
        return this.dataSource;
    }

    public StrategyConfig getStrategy() {
        return this.strategy;
    }

    public PackageConfig getPackageInfo() {
        return this.packageInfo;
    }

    public TemplateConfig getTemplate() {
        return this.template;
    }

    public GlobalConfig getGlobalConfig() {
        return this.globalConfig;
    }

    public CodeAbstractTemplateEngine getTemplateEngine() {
        return this.templateEngine;
    }

    public CodeAutoGenerator setConfig(final CodeConfigBuilder config) {
        this.config = config;
        return this;
    }

    public CodeAutoGenerator setDataSource(final DataSourceConfig dataSource) {
        this.dataSource = dataSource;
        return this;
    }

    public CodeAutoGenerator setStrategy(final StrategyConfig strategy) {
        this.strategy = strategy;
        return this;
    }

    public CodeAutoGenerator setPackageInfo(final CodePackageConfig packageInfo) {
        this.packageInfo = packageInfo;
        return this;
    }

    public CodeAutoGenerator setTemplate(final TemplateConfig template) {
        this.template = template;
        return this;
    }

    public CodeAutoGenerator setGlobalConfig(final GlobalConfig globalConfig) {
        this.globalConfig = globalConfig;
        return this;
    }

    public CodeAutoGenerator setTemplateEngine(final CodeAbstractTemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
        return this;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof AutoGenerator)) {
            return false;
        } else {
            CodeAutoGenerator other = (CodeAutoGenerator)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label107: {
                    Object this$config = this.getConfig();
                    Object other$config = other.getConfig();
                    if (this$config == null) {
                        if (other$config == null) {
                            break label107;
                        }
                    } else if (this$config.equals(other$config)) {
                        break label107;
                    }

                    return false;
                }

                Object this$injectionConfig = this.injectionConfig;
                Object other$injectionConfig = other.injectionConfig;
                if (this$injectionConfig == null) {
                    if (other$injectionConfig != null) {
                        return false;
                    }
                } else if (!this$injectionConfig.equals(other$injectionConfig)) {
                    return false;
                }

                Object this$dataSource = this.getDataSource();
                Object other$dataSource = other.getDataSource();
                if (this$dataSource == null) {
                    if (other$dataSource != null) {
                        return false;
                    }
                } else if (!this$dataSource.equals(other$dataSource)) {
                    return false;
                }

                label86: {
                    Object this$strategy = this.getStrategy();
                    Object other$strategy = other.getStrategy();
                    if (this$strategy == null) {
                        if (other$strategy == null) {
                            break label86;
                        }
                    } else if (this$strategy.equals(other$strategy)) {
                        break label86;
                    }

                    return false;
                }

                label79: {
                    Object this$packageInfo = this.getPackageInfo();
                    Object other$packageInfo = other.getPackageInfo();
                    if (this$packageInfo == null) {
                        if (other$packageInfo == null) {
                            break label79;
                        }
                    } else if (this$packageInfo.equals(other$packageInfo)) {
                        break label79;
                    }

                    return false;
                }

                label72: {
                    Object this$template = this.getTemplate();
                    Object other$template = other.getTemplate();
                    if (this$template == null) {
                        if (other$template == null) {
                            break label72;
                        }
                    } else if (this$template.equals(other$template)) {
                        break label72;
                    }

                    return false;
                }

                Object this$globalConfig = this.getGlobalConfig();
                Object other$globalConfig = other.getGlobalConfig();
                if (this$globalConfig == null) {
                    if (other$globalConfig != null) {
                        return false;
                    }
                } else if (!this$globalConfig.equals(other$globalConfig)) {
                    return false;
                }

                Object this$templateEngine = this.getTemplateEngine();
                Object other$templateEngine = other.getTemplateEngine();
                if (this$templateEngine == null) {
                    if (other$templateEngine != null) {
                        return false;
                    }
                } else if (!this$templateEngine.equals(other$templateEngine)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof AutoGenerator;
    }

    public int hashCode() {
        int PRIME = 1;
        int result = 1;
        Object $config = this.getConfig();
        result = result * 59 + ($config == null ? 43 : $config.hashCode());
        Object $injectionConfig = this.injectionConfig;
        result = result * 59 + ($injectionConfig == null ? 43 : $injectionConfig.hashCode());
        Object $dataSource = this.getDataSource();
        result = result * 59 + ($dataSource == null ? 43 : $dataSource.hashCode());
        Object $strategy = this.getStrategy();
        result = result * 59 + ($strategy == null ? 43 : $strategy.hashCode());
        Object $packageInfo = this.getPackageInfo();
        result = result * 59 + ($packageInfo == null ? 43 : $packageInfo.hashCode());
        Object $template = this.getTemplate();
        result = result * 59 + ($template == null ? 43 : $template.hashCode());
        Object $globalConfig = this.getGlobalConfig();
        result = result * 59 + ($globalConfig == null ? 43 : $globalConfig.hashCode());
        Object $templateEngine = this.getTemplateEngine();
        result = result * 59 + ($templateEngine == null ? 43 : $templateEngine.hashCode());
        return result;
    }

    public String toString() {
        return "AutoGenerator(config=" + this.getConfig() + ", injectionConfig=" + this.injectionConfig + ", dataSource=" + this.getDataSource() + ", strategy=" + this.getStrategy() + ", packageInfo=" + this.getPackageInfo() + ", template=" + this.getTemplate() + ", globalConfig=" + this.getGlobalConfig() + ", templateEngine=" + this.getTemplateEngine() + ")";
    }
}
