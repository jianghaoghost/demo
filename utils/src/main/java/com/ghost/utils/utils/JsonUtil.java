package com.ghost.utils.utils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

/**
 * @author ghost
 * @description 字符串的工具类
 */
public final class JsonUtil {

    private static ObjectMapper mapper = new ObjectMapper();

    public static ObjectMapper getInstance() {
        if (mapper != null) {
            return mapper;
        } else {
            return new ObjectMapper();
        }
    }

    /**
     * bean转换为Json字符串
     *
     * @param obj obj
     * @return json字符串
     */
    public static String bean2Json(Object obj) {
        ObjectMapper objectMapper = JsonUtil.getInstance();
        objectMapper.setSerializationInclusion(Include.NON_NULL);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Json字符串转换为实体类bean
     *
     * @param jsonStr  字符串
     * @param objClass 实体类
     * @return 类对象
     */
    public static <T> T json2Bean(String jsonStr, Class<T> objClass) {
        ObjectMapper mapper = JsonUtil.getInstance();
        try {
            return mapper.readValue(jsonStr, objClass);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将json数据转换成pojo对象list
     * <p>Title: jsonToList</p>
     * <p>Description: </p>
     *
     * @param jsonData json数据
     * @param beanType bean类型
     * @return 对象集合
     */
    public static <T> List<T> jsonToList(String jsonData, Class<T> beanType) {
        JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, beanType);
        try {
            return mapper.readValue(jsonData, javaType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 初始化Json字符串
     *
     * @param jsonStr 字符串
     * @return 初始化后的Json字符串
     */
    public static JsonNode initJson(String jsonStr) {
        try {
            ObjectMapper mapper = JsonUtil.getInstance();
            return mapper.readTree(jsonStr);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}
