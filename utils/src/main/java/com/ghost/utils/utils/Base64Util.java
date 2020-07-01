package com.ghost.utils.utils;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;

/**
 * @author: ghost
 * @date: 2019/9/17 10:29
 * @version: 1.0
 * @description:
 */
public class Base64Util {
    private static final Logger logger = LoggerFactory.getLogger(Base64Util.class);

    private static final String UTF_8 = "UTF-8";

    /**
     * 对给定的字符串进行base64加密操作
     *
     * @param inputData 字符串
     * @return 加密后的字符串
     */
    public static String encodeData(String inputData) {
        try {
            if (null == inputData) {
                return null;
            }
            return new String(Base64.encodeBase64(inputData.getBytes(UTF_8)), UTF_8).replaceAll("=", "");
        } catch (UnsupportedEncodingException e) {
            logger.error(inputData, e);
        }
        return null;
    }

    /**
     * 对给定的字符串进行base64解码操作
     *
     * @param inputData 字符串
     * @return 解密后的字符串
     */
    public static String decodeData(String inputData) {
        try {
            if (null == inputData) {
                return null;
            }
            return new String(Base64.decodeBase64(inputData.getBytes(UTF_8)), UTF_8);
        } catch (UnsupportedEncodingException e) {
            logger.error(inputData, e);
        }
        return null;
    }



}
