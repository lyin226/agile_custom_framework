package com.custom.framework.proxy;

import com.custom.framework.annotation.Aspect;
import com.custom.framework.helper.BeanHelper;
import com.custom.framework.helper.ClassHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 初始化 AOP 框架
 *
 * @author huangyong
 * @since 1.0
 */
public class AopHelper {
    private static final Logger logger = LoggerFactory.getLogger(AopHelper.class);

    static {
        try {
            // 创建 Proxy Map（用于 存放代理类 与 目标类列表 的映射关系）
            Map<Class<?>, Set<Class<?>>> proxyMap = createProxyMap();
            // 创建 Target Map（用于 存放目标类 与 代理类列表 的映射关系）
            Map<Class<?>, List<Proxy>> targetMap = createTargetMap(proxyMap);
            // 遍历 Target Map
            for (Map.Entry<Class<?>, List<Proxy>> targetEntry : targetMap.entrySet()) {
                // 分别获取 map 中的 key 与 value
                Class<?> targetClass = targetEntry.getKey();
                List<Proxy> proxyList = targetEntry.getValue();
                // 创建代理实例
                Object proxyInstance = ProxyManager.createProxy(targetClass, proxyList);
                // 用代理实例覆盖目标实例，并放入 Bean 容器中
                BeanHelper.setBeanMap(targetClass, proxyInstance);
            }
        } catch (Exception e) {
            logger.error("aop failure",e);
        }
    }

    private static Map<Class<?>, Set<Class<?>>> createProxyMap() throws Exception {
        Map<Class<?>, Set<Class<?>>> proxyMap = new HashMap<>();
        Set<Class<?>> proxyClassSet = ClassHelper.getClassSetBySuper(AspectProxy.class);
        for(Class<?> proxyClass : proxyClassSet) {
            if (proxyClass.isAnnotationPresent(Aspect.class)) {
                Aspect aspect = proxyClass.getAnnotation(Aspect.class);
                Set<Class<?>> targetClassSet = createTargetClassSet(aspect);
                proxyMap.put(proxyClass, targetClassSet);
            }
        }
        return proxyMap;
    }


    private static Set<Class<?>> createTargetClassSet(Aspect aspect) throws Exception {
        Set<Class<?>> targetClassSet = new HashSet<>();
        Class<? extends Annotation> annotation = aspect.value();
        if (annotation != null && !annotation.equals(Aspect.class)) {
            targetClassSet.addAll(ClassHelper.getClassSetByAnnotation(annotation));
        }
        return targetClassSet;
    }

    private static Map<Class<?>, List<Proxy>> createTargetMap(Map<Class<?>, Set<Class<?>>> proxyMap) throws Exception {
        Map<Class<?>, List<Proxy>> targetMap = new HashMap<Class<?>, List<Proxy>>();
        // 遍历 Proxy Map
        for (Map.Entry<Class<?>, Set<Class<?>>> proxyEntry : proxyMap.entrySet()) {
            // 分别获取 map 中的 key 与 value
            Class<?> proxyClass = proxyEntry.getKey();
            Set<Class<?>> targetClassSet = proxyEntry.getValue();
            // 遍历目标类列表
            for (Class<?> targetClass : targetClassSet) {
                // 创建代理类（切面类）实例
                Proxy baseAspect = (Proxy) proxyClass.newInstance();
                // 初始化 Target Map
                if (targetMap.containsKey(targetClass)) {
                    targetMap.get(targetClass).add(baseAspect);
                } else {
                    List<Proxy> baseAspectList = new ArrayList<Proxy>();
                    baseAspectList.add(baseAspect);
                    targetMap.put(targetClass, baseAspectList);
                }
            }
        }
        return targetMap;
    }
}
