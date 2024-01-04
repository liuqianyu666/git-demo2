package com.tjetc.util;

import cn.hutool.core.util.ObjectUtil;

public class ValidationUtil{

    /**
     * 验证空
     */
    public static void isNull(Object obj, String entity, String parameter , Object value){
        if(ObjectUtil.isNull(obj)){
            String msg = entity + " 不存在: "+ parameter +" is "+ value;
            throw new RuntimeException(msg);
        }
    }
}
