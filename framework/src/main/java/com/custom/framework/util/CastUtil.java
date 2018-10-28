package com.custom.framework.util;

import org.apache.commons.lang3.StringUtils;

/**
 * 数据转型工具类
 * @author liuyi
 * @date 2018/10/28
 */
public class CastUtil {


    /**
     * 转为long类型
     * @param obj
     * @return
     */
    public static long castLong(Object obj){
        return CastUtil.castLong(obj,0);
    }

    /**
     * 转为long
     * @param obj
     * @param defaultValue
     * @return
     */
    public static long castLong(Object obj,long defaultValue){
        long value = defaultValue;
        if (obj!=null){
            String strValue = castString(obj);
            if (StringUtils.isNotEmpty(strValue)){
                try{
                    value = Long.parseLong(strValue);
                }catch (NumberFormatException e){
                    value = defaultValue;
                }
            }
        }
        return value;
    }

    /**
     * 转为String
     * @param obj
     * @return
     */
    public static String castString(Object obj){
        return CastUtil.castString(obj,"");
    }

    /**
     * 转为String
     * @param obj
     * @param defaultValue
     * @return
     */
    public static String castString(Object obj,String defaultValue){
        return obj!=null?String.valueOf(obj):defaultValue;
    }


}
