package com.ridegroup.yop.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

public abstract class JsonUtil {

    public static <T> T parseObject(String json, Class<T> clazz) {
        return JSON.parseObject(json, clazz);
    }

    public static <T> T parseObject(String json, TypeReference<T> type) {
        return JSON.parseObject(json, type);
    }

    public static String toJSONString(Object object) {
        return JSON.toJSONString(object);
    }
}
