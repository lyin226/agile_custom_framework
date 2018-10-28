package com.custom.framework.util;

import java.util.ResourceBundle;

/**
 * 属性工具类
 * @author liuyi
 * @date 2018/10/14
 */
public class PropsUtil {

    /**
     * 根据属性文件获取资源
     * @param name
     * @return
     */
    public static ResourceBundle getResource(String name) {
        ResourceBundle resource = ResourceBundle.getBundle(name);
        return resource;
    }

    /**
     * 根据key获取value
     * @param resourceBundle
     * @param key
     * @return
     */
    public static String getString(ResourceBundle resourceBundle, String key) {
        return resourceBundle.getString(key);
    }

}
