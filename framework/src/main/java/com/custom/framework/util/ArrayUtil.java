package com.custom.framework.util;

import org.apache.commons.lang3.ArrayUtils;

/**
 * 数组工具类
 * @author liuyi
 * @date 2018/10/27
 */
public class ArrayUtil {
    /**
     * 判断数组是否非空
     * @param array
     * @return
     */
    public static boolean isNotEmpty(Object[] array) {
        return !ArrayUtils.isEmpty(array);
    }

    /**
     * 判断数组是否为空
     * @param array
     * @return
     */
    public static boolean isEmpty(Object[] array) {
        return ArrayUtil.isEmpty(array);
    }
}
