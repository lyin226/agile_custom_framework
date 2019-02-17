package com.custom.framework.proxy;

/**
 * @author liuyi
 * @date 2019/2/16
 */
public interface Proxy {

    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
