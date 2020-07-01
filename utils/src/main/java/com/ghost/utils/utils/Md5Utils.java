package com.ghost.utils.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密
 *
 * @author ghost
 * @date 2018/8/2
 */
public final class Md5Utils {

    /**
     * MD5加密
     *
     * @param str 字符串
     * @return 加密密文
     */
    public static String getMD5(String str) {
        String result = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            // 这句是关键
            md5.update(str.getBytes(StandardCharsets.UTF_8));
            byte[] bytes = md5.digest();
            int i;
            StringBuilder buf = new StringBuilder();
            for (int offset = 0; offset < bytes.length; offset++) {
                i = bytes[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString().toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

}
