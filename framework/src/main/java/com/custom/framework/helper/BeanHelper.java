package com.custom.framework.helper;

import com.custom.framework.util.ReflectionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Bean助手类
 * @author liuyi
 * @date 2018/10/25
 */
public final class BeanHelper {

    /**
     * 定义Bean映射（用于存放Bean类与Bean实例的映射关系）
     */
    private static final Map<Class<?>, Object> BEAN_MAP = new HashMap<Class<?>, Object>();

    static {
        Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
        for (Class<?> beanClass : beanClassSet) {
            Object obj = ReflectionUtil.newInstance(beanClass);
            BEAN_MAP.put(beanClass, obj);
        }
    }

    /**
     * 获取Bean映射
     * @return
     */
    public static Map<Class<?>, Object> getBeanMap() {
        return BEAN_MAP;
    }

    /**
     * 获取Bean实例
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> cls) {
        if (!BEAN_MAP.containsKey(cls)) {
            throw new RuntimeException("can not get bean by class: " + cls);
        }
        return (T)BEAN_MAP.get(cls);
    }

    /**
     * 设置Bean 实例
     * @param cls
     * @param obj
     */
    public static void setBeanMap(Class<?> cls, Object obj) {
        BEAN_MAP.put(cls, obj);
    }

}
