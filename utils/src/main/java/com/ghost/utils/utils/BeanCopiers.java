package com.ghost.utils.utils;


import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.cglib.core.Converter;

/**
 * @author yh
 * @version 2019/8/30 下午 04:37
 */
public class BeanCopiers {

    /**
     * 属性拷贝
     *
     * @param source 源对象
     * @param target 目标
     */
    public static void copy(Object source, Object target) {
        BeanCopier copier = BeanCopier.create(source.getClass(), target.getClass(), false);
        copier.copy(source, target, null);
    }

    /**
     * 属性拷贝（不包括空值和null）
     *
     * @param source 源对象
     * @param target 目标
     */
    public static void copyNoEmpty(Object source, Object target) {
        BeanCopier copier = BeanCopier.create(source.getClass(), target.getClass(), true);
        copier.copy(source, target, converter(target));
    }

    /**
     * 条件转换
     *
     * @param target 目标
     * @return 转化结果
     */
    private static Converter converter(Object target) {
        return (Object val, Class tar, Object context) -> {
            boolean empty = null == val || (val instanceof String && ((String) val).length() == 0);
            if (empty) {
                char[] chars = context.toString().toCharArray();
                char[] newChars = new char[chars.length - 3];
                System.arraycopy(chars, 3, newChars, 0, chars.length - 3);
                newChars[0] = Character.toLowerCase(newChars[0]);
                String property = String.valueOf(newChars);
                val = BeanMap.create(target).get(property);
            }
            return val;
        };
    }

}
