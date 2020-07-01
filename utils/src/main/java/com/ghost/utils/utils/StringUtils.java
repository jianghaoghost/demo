package com.ghost.utils.utils;

import java.util.Collection;

/**
 * @author ghost
 */
public class StringUtils {

    /**
     * 用于判断 null(单个参数)
     *
     * @param string 字符串
     * @return true(null) or false("")
     */
    public static boolean isNull(String string) {
        if (null == string) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * 用于判断 ""(单个参数)
     *
     * @param string 字符串
     * @return true(" ") or false(null)
     */
    public static boolean isEmpty(String string) {
        if (null != string && string.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 用于判断 ""，或null(单个参数)
     *
     * @param string "",null
     * @return true(" " ， null)
     */
    public static boolean isNullOrEmpty(String string) {
        if (null == string) {
            return true;
        } else if (null != string && string.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 参数列表是否都为null(或"")
     *
     * @param strings 参数列表
     * @return true都为null(或 " "), false(任意一个不为null ( 或 " "))
     */
    public static boolean allIsNullOrEmpty(String... strings) {
        if (null == strings || strings.length == 0) {
            return true;
        }
        for (String s : strings) {
            if (isNullOrEmpty(s)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }


    public static boolean notNull(String string) {
        if (null != string) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean notEmpty(String string) {
        if (null != string && string.length() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean arrayNotNull(String... strings) {
        if (null == strings || strings.length == 0) {
            return false;
        }
        for (String s : strings) {
            if (isNull(s)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEmpty(Object obj) {
        return null == obj || (obj instanceof String && "".equals(obj)) || (obj instanceof Collection && ((Collection) obj).size() == 0);
    }

    public static boolean existEmpty(Object... objects) {
        if (objects == null || objects.length == 0) {
            return true;
        }
        for (Object object : objects) {
            if (isEmpty(object)) {
                return true;
            }
        }
        return false;
    }

    public static boolean notEmpty(String... strings) {
        if (null == strings || strings.length == 0) {
            return false;
        }
        for (String s : strings) {
            if (s == null || s.length() == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断字符串是否是纯数字字符串
     *
     * @param str 字符串
     * @return boolean true是，false不是
     */
    public static boolean isPureNumbersStr(String str) {
        return str.matches("[0-9]+");
    }
}
