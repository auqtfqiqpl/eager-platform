package com.jx.agile.code.config;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;

import lombok.Data;

/**
 * @Auther: auqtfqiqpl
 * @Date: 2021/03/05/12:01
 * @Description:
 */
@Data
public abstract class CodeInjectionConfig{

    private CodeConfigBuilder config;
    private Map<String, Object> map;
    private List<FileOutConfig> fileOutConfigList;
    private CodeIFileCreate fileCreate;

    public abstract void initMap();

    public Map<String, Object> prepareObjectMap(Map<String, Object> objectMap) {
        return objectMap;
    }

    public CodeInjectionConfig() {
    }

    public CodeConfigBuilder getConfig() {
        return this.config;
    }

    public Map<String, Object> getMap() {
        return this.map;
    }

    public List<FileOutConfig> getFileOutConfigList() {
        return this.fileOutConfigList;
    }

    public CodeIFileCreate getFileCreate() {
        return this.fileCreate;
    }

    public CodeInjectionConfig setConfig(final CodeConfigBuilder config) {
        this.config = config;
        return this;
    }

    public CodeInjectionConfig setMap(final Map<String, Object> map) {
        this.map = map;
        return this;
    }

    public CodeInjectionConfig setFileOutConfigList(final List<FileOutConfig> fileOutConfigList) {
        this.fileOutConfigList = fileOutConfigList;
        return this;
    }

    public CodeInjectionConfig setFileCreate(final CodeIFileCreate fileCreate) {
        this.fileCreate = fileCreate;
        return this;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof CodeInjectionConfig)) {
            return false;
        } else {
            CodeInjectionConfig other = (CodeInjectionConfig)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label59: {
                    Object this$config = this.getConfig();
                    Object other$config = other.getConfig();
                    if (this$config == null) {
                        if (other$config == null) {
                            break label59;
                        }
                    } else if (this$config.equals(other$config)) {
                        break label59;
                    }

                    return false;
                }

                Object this$map = this.getMap();
                Object other$map = other.getMap();
                if (this$map == null) {
                    if (other$map != null) {
                        return false;
                    }
                } else if (!this$map.equals(other$map)) {
                    return false;
                }

                Object this$fileOutConfigList = this.getFileOutConfigList();
                Object other$fileOutConfigList = other.getFileOutConfigList();
                if (this$fileOutConfigList == null) {
                    if (other$fileOutConfigList != null) {
                        return false;
                    }
                } else if (!this$fileOutConfigList.equals(other$fileOutConfigList)) {
                    return false;
                }

                Object this$fileCreate = this.getFileCreate();
                Object other$fileCreate = other.getFileCreate();
                if (this$fileCreate == null) {
                    if (other$fileCreate != null) {
                        return false;
                    }
                } else if (!this$fileCreate.equals(other$fileCreate)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof InjectionConfig;
    }

    public int hashCode() {
        int PRIME = 1;
        int result = 1;
        Object $config = this.getConfig();
        result = result * 59 + ($config == null ? 43 : $config.hashCode());
        Object $map = this.getMap();
        result = result * 59 + ($map == null ? 43 : $map.hashCode());
        Object $fileOutConfigList = this.getFileOutConfigList();
        result = result * 59 + ($fileOutConfigList == null ? 43 : $fileOutConfigList.hashCode());
        Object $fileCreate = this.getFileCreate();
        result = result * 59 + ($fileCreate == null ? 43 : $fileCreate.hashCode());
        return result;
    }

    public String toString() {
        return "CodeInjectionConfig(config=" + this.getConfig() + ", map=" + this.getMap() + ", fileOutConfigList=" + this.getFileOutConfigList() + ", fileCreate=" + this.getFileCreate() + ")";
    }
}
