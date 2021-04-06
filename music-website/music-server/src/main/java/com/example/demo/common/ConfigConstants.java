package com.example.demo.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName: ConfigConstants
 * @Author: 59644
 * @Description: 用于配置不同系统环境常量
 * @Date: 2019-11-4 13:36
 * @Version: 1.0
 */
@Component
public class ConfigConstants {

    /**
     * 文件磁盘图片映射URL
     */
    private static String mapperUrl;

    /**
     * 文件磁盘图片映射URL
     */
    private static String fileDir;

    /**
     * 文件磁盘图片映射URL
     */
    private static String filePath;


    public static String getMapperUrl() {
        return mapperUrl;
    }

    public static String getFileDir() {
        return fileDir;
    }
    @Value("${param.fileDir}")
    public void setFileDir(String fileDir) {
        ConfigConstants.fileDir = fileDir;
    }

    public static String getFilePath() {
        return filePath;
    }
    @Value("${param.filePath}")
    public void setFilePath(String filePath) {
        ConfigConstants.filePath = filePath;
    }

    @Value("${param.mapperUrl}")
    public void setMapperUrl(String mapperUrl) {
        ConfigConstants.mapperUrl = mapperUrl;
    }

}
