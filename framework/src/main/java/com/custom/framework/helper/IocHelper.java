package com.custom.framework.helper;


import com.custom.framework.annotation.Inject;
import com.custom.framework.util.ArrayUtil;
import com.custom.framework.util.CollectionUtil;
import com.custom.framework.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 依赖注入助手类
 * @author liuyi
 * @date 2018/10/27
 */
public class IocHelper {

    static {
        //获取所有的Bean类与Bean实例之间的映射关系（简称BeanMap）
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        if (CollectionUtil.isNotEmpty(beanMap)) {
            //遍历BeanMap
            for (Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()) {
                //从BeanMap中获取Bean类与Bean实例
                Class<?> beanClass = beanEntry.getKey();
                Object beanInstance = beanEntry.getValue();
                //获取Bean类定义的所有成员变量(简称Bean Field)
                Field[] beanFields = beanClass.getDeclaredFields();
                if (ArrayUtil.isNotEmpty(beanFields)) {
                    //遍历Bean Field
                    for (Field beanField : beanFields) {
                        //判断当前Bean Field 是否带有Inject注解
                        if (beanField.isAnnotationPresent(Inject.class)) {
                            //在Bean Map中获取Bean Field对应的实例
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if (beanFieldInstance != null) {
                                //通过反射初始化 BeanField的值
                                ReflectionUtil.setField(beanInstance, beanField, beanFieldInstance);
                            }
                        }
                    }
                }
            }
        }
    }
}
