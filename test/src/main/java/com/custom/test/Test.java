package com.custom.test;


import java.util.ResourceBundle;

/**
 * @author liuyi
 * @date 2018/10/14
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(getString("framework", "framework.jdbc.asset_path"));
    }
    public static ResourceBundle getResource(String name) {
        ResourceBundle resource = ResourceBundle.getBundle(name);
        return resource;
    }
    public static String getString(String name, String key) {
        return getResource(name).getString(key);
    }
}
