package com.custom.framework.helper;

import com.custom.framework.constants.Constants;
import com.custom.framework.util.PropsUtil;

import java.util.ResourceBundle;

/**
 * 属性文件助手类
 * @author liuyi
 * @date 2018/10/14
 */
public final class ConfigHelper {

    private static final ResourceBundle resource = PropsUtil.getResource(Constants.CONFIG_FILE);

    /**
     * 获取JDBC驱动
     * @return
     */
    public static String getJdbcDriver() {
        return PropsUtil.getString(resource, Constants.JDBC_DRIVER);
    }

    /**
     * 获取JDBC URL
     * @return
     */
    public static String getJdbcUrl() {
        return PropsUtil.getString(resource, Constants.JDBC_URL);
    }

    /**
     * 获取JDBC 用户名
     * @return
     */
    public static String getJdbcUsername() {
        return PropsUtil.getString(resource, Constants.JDBC_USERNAME);
    }

    /**
     * 获取JDBC 密码
     * @return
     */
    public static String getJdbcPassword() {
        return PropsUtil.getString(resource, Constants.JDBC_PASSWORD);
    }

    /**
     * 获取应用基础包名
     * @return
     */
    public static String getAppBasePackage() {
        return PropsUtil.getString(resource, Constants.FRAMEWORK_JDBC_APP_BASE_PACKAGE);
    }

    /**
     * 获取应用JSP路径
     * @return
     */
    public static String getAppJspPath() {
        return PropsUtil.getString(resource, Constants.FRAMEWORK_JDBC_JSP_PATH);
    }

    /**
     * 获取应用静态资源文件路径
     * @return
     */
    public static String getAppAssetPath() {
        return PropsUtil.getString(resource, Constants.FRAMEWORK_JDBC_ASSET_PATH);
    }

}
