package com.custom.framework.aspect;

import com.custom.framework.proxy.AspectProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * @author liuyi
 * @date 2019/2/17
 */
public class ControllerAspect extends AspectProxy {

    private static final Logger logger = LoggerFactory.getLogger(ControllerAspect.class);

    private long begin;

    @Override
    public void before(Class<?> cls, Method method, Object[] params) throws Throwable {
        logger.debug("---------- begin ----------");
        logger.debug(String.format("class: %s", cls.getName()));
        logger.debug(String.format("method: %s", method.getName()));
        begin = System.currentTimeMillis();
    }

    @Override
    public void after(Class<?> cls, Method method, Object[] params) throws Throwable {
        logger.debug(String.format("time: %dms", System.currentTimeMillis() - begin));
        logger.debug("---------- end ----------");
    }
}
