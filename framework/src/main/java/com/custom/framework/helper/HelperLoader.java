package com.custom.framework.helper;

import com.custom.framework.annotation.Controller;
import com.custom.framework.proxy.AopHelper;
import com.custom.framework.util.ClassUtil;

/**
 *
 * @author liuyi
 * @date 2018/10/28
 */
public final class HelperLoader {

    public static void init() {
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                AopHelper.class,
                IocHelper.class,
                Controller.class,
        };
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName(),true);
        }
    }
}
