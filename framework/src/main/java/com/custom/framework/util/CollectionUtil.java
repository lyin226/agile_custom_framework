package com.custom.framework.util;

import java.util.Map;
/**
 * @author liuyi
 * @date 2018/10/27
 */
public class CollectionUtil {

    public static boolean isNotEmpty(Map<Class<?>, Object> map) {
        if (map == null || map.size() == 0) {
            return false;
        }
        return true;
    }
}
