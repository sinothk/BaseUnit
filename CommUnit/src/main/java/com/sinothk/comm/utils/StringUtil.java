package com.sinothk.comm.utils;

import android.text.TextUtils;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * Created by 梁玉涛 on 2017/11/22/022.
 * 描述：
 */

public class StringUtil {

    // ===================返回===================

    /**
     * String为null或""时，返回""
     *
     * @param value
     * @return
     */
    public static String getNotNullValue(String value) {
        if (TextUtils.isEmpty(value) || value.trim().length() == 0
                || "null".equals(value.trim()) || "Null".equals(value.trim())
                || "NULL".equals(value.trim()) || "None".equals(value.trim())) {
            value = "";
        }
        return value;
    }

    /**
     * 返回永不为null的字符串数值,为空返回指定默认值
     *
     * @param value        字符串数值
     * @param defaultValue 为空时，返回默认值
     * @return
     */
    public static String getNotNullValue(String value, String defaultValue) {
        if (TextUtils.isEmpty(value) || value.trim().length() == 0
                || "null".equals(value.trim()) || "Null".equals(value.trim())
                || "NULL".equals(value.trim()) || "None".equals(value.trim())) {
            value = defaultValue;
        }
        return value;
    }
    // ===================判空===================

    /**
     * 判断给定字符串是否空白串。 空白串是指由空格、制表符、回车符、换行符组成的字符串 若输入字符串为null或空字符串，返回true
     *
     * @param value
     * @return boolean
     */
    public static boolean isEmpty(String value) {
        return value == null || "".equals(value) || value.trim().length() == 0 || value.trim().equals("null")
                || value.trim().equals("NULL") || value.trim().equals("Null");
    }

    public static boolean isNotEmpty(String value) {
        return !isEmpty(value);
    }

    // ====================其他===================

    /**
     * Return 2 空格.
     *
     * @return
     */
    public static String getTwoSpaces() {
        return "\u3000\u3000";
    }


    /**
     * 长度是否在a到b之间
     *
     * @param value
     * @param a
     * @param b
     * @return
     */
    public static boolean isBetweenAtoB(String value, int a, int b) {
        if (isEmpty(value)) {
            return false;
        }

        if (value.length() >= a && value.length() <= b) {
            return true;
        }

        return false;
    }

    /**
     * 获得星号代替的字符串。星号个数根据长度替换
     *
     * @param paramString
     * @return
     */
    public static String getStarString(String paramString) {
        try {
            if (paramString == null || paramString.equals("")) {
                return "";
            }

            int i = paramString.length();
            if (i <= 6) {
                return paramString;
            }

            if ((i <= 15) && (i > 6)) {
                String str5 = paramString.substring(0, 3);
                String str6 = paramString.substring(6);
                return str5 + "***" + str6;
            }

            if ((i <= 18) && (i > 15)) {
                String str1 = paramString.substring(0, 8);
                String str2 = paramString.substring(12);
                return str1 + "****" + str2;
            }

            if (i > 18) {
                String str3 = paramString.substring(0, 10);
                String str4 = paramString.substring(14);
                return str3 + "****" + str4;
            }
        } catch (Exception e) {
        }

        return "";
    }

    public static boolean isOnlyNUmber(String str) {
        try {
            return str.matches("^[0-9]*$");
        } catch (Exception e) {
            return false;
        }
    }

    public static final int EMAIL = 0;

    public static String getStarStringByType(String paramString, int type) {
        if (isEmpty(paramString)) {
            return "";
        }

        String endStr = "";

        if (EMAIL == type) {
            if (!paramString.contains("@")) {
                return paramString;
            }

            endStr = paramString.substring(paramString.indexOf("@"), paramString.length());
            paramString = paramString.substring(0, paramString.indexOf("@"));
        }

        try {

            String res = "";

            int i = paramString.length();
            if (i <= 6) {
                res = paramString;
            } else if ((i <= 15) && (i > 6)) {
                String str5 = paramString.substring(0, 3);
                String str6 = paramString.substring(6);
                res = str5 + "***" + str6;
            } else if ((i <= 18) && (i > 15)) {
                String str1 = paramString.substring(0, 8);
                String str2 = paramString.substring(12);
                res = str1 + "****" + str2;
            } else if (i > 18) {
                String str3 = paramString.substring(0, 10);
                String str4 = paramString.substring(14);
                res = str3 + "****" + str4;
            }

            if (EMAIL == type) {
                res = res + endStr;
            }

            return res;

        } catch (Exception e) {
        }

        return "";
    }

    /**
     * 根据flag拆分String，转为 ArrayList
     *
     * @param head
     * @param str
     * @param flag
     * @return
     */
    public static ArrayList<String> getArrayListByFlag(String head, String str, String flag) {
        ArrayList<String> list = new ArrayList<>();
        if (isEmpty(str)) {
            return list;
        }

        String[] s = str.split(flag);
        for (int i = 0; i < s.length; i++) {
            list.add(head + s[i]);
        }
        return list;
    }

    /**
     * 判断是否为一个合法的url地址
     *
     * @param str
     * @return
     */
    public static boolean isUrl(String str) {
        if (str == null || str.trim().length() == 0)
            return false;
        return URL.matcher(str).matches();
    }

    /**
     * 判断是不是一个合法的电子邮件地址
     *
     * @param email
     * @return
     */
    public static boolean isEmail(String email) {
        if (email == null || email.trim().length() == 0)
            return false;
        return emailer.matcher(email).matches();
    }

    /**
     * 判断一个url是否为图片url
     *
     * @param url
     * @return
     */
    public static boolean isImgUrl(String url) {
        if (url == null || url.trim().length() == 0)
            return false;
        return IMG_URL.matcher(url).matches();
    }

    private final static Pattern emailer = Pattern
            .compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
    private final static Pattern IMG_URL = Pattern
            .compile(".*?(gif|jpeg|png|jpg|bmp)");
    private final static Pattern URL = Pattern
            .compile("^(https|http)://.*?$(net|com|.com.cn|org|me|)");

    /**
     * String转对象
     *
     * @param ret
     * @return
     */
    public static Object string2Obj(String ret) {
        Object obj = null;
        if (ret != null) {
            byte[] buffer = Base64.decode(ret.getBytes(), Base64.DEFAULT);
            ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
            try {
                ObjectInputStream ois = new ObjectInputStream(bais);
                obj = ois.readObject();
                ois.close();
            } catch (StreamCorruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    bais.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return obj;
    }

    /**
     * 对象转String
     *
     * @param obj
     * @return
     */
    public static String obj2String(Object obj) {
        String strRet = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            strRet = new String(Base64.encode(baos.toByteArray(),
                    Base64.DEFAULT));
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return strRet;
    }

    /**
     * 首字母大写
     *
     * @param s 待转字符串
     * @return 首字母大写字符串
     */
    public static String upperFirstLetter(String s) {
        if (isEmpty(s) || !Character.isLowerCase(s.charAt(0))) {
            return s;
        }
        return String.valueOf((char) (s.charAt(0) - 32)) + s.substring(1);
    }

    /**
     * 首字母小写
     *
     * @param s 待转字符串
     * @return 首字母小写字符串
     */
    public static String lowerFirstLetter(String s) {
        if (isEmpty(s) || !Character.isUpperCase(s.charAt(0))) {
            return s;
        }
        return String.valueOf((char) (s.charAt(0) + 32)) + s.substring(1);
    }

    /**
     * 反转字符串
     *
     * @param s 待反转字符串
     * @return 反转字符串
     */
    public static String reverse(String s) {

        if (isEmpty(s)) {
            return s;
        }

        int len = s.length();
        if (len <= 1) return s;
        int mid = len >> 1;
        char[] chars = s.toCharArray();
        char c;
        for (int i = 0; i < mid; ++i) {
            c = chars[i];
            chars[i] = chars[len - i - 1];
            chars[len - i - 1] = c;
        }
        return new String(chars);
    }

    /**
     * 转化为半角字符
     *
     * @param s 待转字符串
     * @return 半角字符串
     */
    public static String toDBC(String s) {
        if (isEmpty(s)) {
            return s;
        }
        char[] chars = s.toCharArray();
        for (int i = 0, len = chars.length; i < len; i++) {
            if (chars[i] == 12288) {
                chars[i] = ' ';
            } else if (65281 <= chars[i] && chars[i] <= 65374) {
                chars[i] = (char) (chars[i] - 65248);
            } else {
                chars[i] = chars[i];
            }
        }
        return new String(chars);
    }

    /**
     * 转化为全角字符
     *
     * @param s 待转字符串
     * @return 全角字符串
     */
    public static String toSBC(String s) {
        if (isEmpty(s)) {
            return s;
        }
        char[] chars = s.toCharArray();
        for (int i = 0, len = chars.length; i < len; i++) {
            if (chars[i] == ' ') {
                chars[i] = (char) 12288;
            } else if (33 <= chars[i] && chars[i] <= 126) {
                chars[i] = (char) (chars[i] + 65248);
            } else {
                chars[i] = chars[i];
            }
        }
        return new String(chars);
    }

    /**
     * 计算参数中含有多少个特定字符
     *
     * @param string
     * @param ch
     * @return
     */
    public static int getCharNum(String string, String ch) {
        int pos = -2;
        int n = 0;

        while (pos != -1) {
            if (pos == -2) {
                pos = -1;
            }
            pos = string.indexOf(ch, pos + 1);
            if (pos != -1) {
                n++;
            }
        }
        return n;
    }

    /**
     * 获得格式为：####.00的数字123456.00
     *
     * @param money
     * @return
     */
    public static String getMenyTypeXXXX00(float money) {
        DecimalFormat df1 = new DecimalFormat("####.00");
        String m = df1.format(money);

        return m.replace(".", "");
    }

    /**
     * 获得格式为：####00的数字12345600
     *
     * @param money
     * @return
     */
    public static String getMenyTypeXXXX_DOT_00(float money) {
        DecimalFormat df1 = new DecimalFormat("####.00");
        return df1.format(money);
    }

    /**
     * 获得星号代替的字符串。形如：12345 =>getStarString("12345", 1, 3)=> 1***5。星数和字符串个数相同情况
     *
     * @param str
     * @param start
     * @param end
     * @return
     */
    public static String getStarString(String str, int start, int end) {
        try {
            String startStr = str.substring(0, start);
            String endStr = str.substring(end, str.length());

            String starStr = "";
            for (int i = start; i < end; i++) {
                starStr = starStr + "*";
            }

            return startStr + starStr + endStr;
        } catch (Exception e) {
            return str;
        }
    }

    public static boolean isSpace(String filePath) {
        return filePath == null || filePath.trim().length() == 0;
    }
}
