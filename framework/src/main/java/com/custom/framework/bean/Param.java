package com.custom.framework.bean;

import com.custom.framework.util.CastUtil;

import java.util.Map;

/**
 * 请求参数对象
 * @author liuyi
 * @date 2018/10/28
 */
public class Param {

    private Map<String, Object> paramMap;

    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    /**
     * 根据参数名获取 long 型参数值
     * @param name
     * @return
     */
    public long getLong(String name) {
        return CastUtil.castLong(paramMap.get(name));
    }

    /**
     * 获取所有字段信息
     * @return
     */
    public Map<String, Object> getMap() {
        return paramMap;
    }
}
