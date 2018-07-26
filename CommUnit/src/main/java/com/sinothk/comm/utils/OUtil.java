package com.sinothk.comm.utils;

import android.content.Context;
import android.util.Log;

/**
 * <pre>
 *     更新  ：
 *     作者  : 梁玉涛
 *     主页  : https://github.com/sinothk
 *     日期  : 2018/1/18
 *     功能  :功能类注册类
 * </pre>
 */
public class OUtil {

    protected static Context mContext;

    public static void init(Context context) {
        mContext = context;
    }

    protected static boolean isDisable() {
        if (mContext == null) {
            Log.e("OUtil", "-----------------------------------------------------------------");
            Log.e("OUtil", "使用*Util工具类前，请先在Application中调用OUtil.init(Context mContext)");
            Log.e("OUtil", "-----------------------------------------------------------------");
            return true;
        } else {
            return false;
        }
    }
}
