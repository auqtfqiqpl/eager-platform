package com.jx.agile.code.config;

import java.io.File;

import com.baomidou.mybatisplus.extension.toolkit.PackageHelper;
import com.baomidou.mybatisplus.generator.config.rules.FileType;

/**
 * @Auther: auqtfqiqpl
 * @Date: 2021/03/05/14:10
 * @Description:
 */
public interface CodeIFileCreate {

    boolean isCreate(CodeConfigBuilder configBuilder, FileType fileType, String filePath);

    default void checkDir(String filePath) {
        File file = new File(filePath);
        boolean exist = file.exists();
        if (!exist) {
            PackageHelper.mkDir(file.getParentFile());
        }

    }
}
