package com.sinothk.comm.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import static com.sinothk.comm.BuildConfig.DEBUG;

/**
 * Company SINOTHK Created by 梁玉涛 on 2015/9/22.
 */
public class ToastUtil {

    private static Context mContext;

    public static void init(Context context) {
        mContext = context;
    }

    /**
     * Toast 短时间显示,传文字
     *
     * @param txt
     */
    public static void show(String txt) {
        if (mContext == null || StringUtil.isEmpty(txt)) {
            if (DEBUG) {
                throw new NullPointerException("mContext == null或参数为null, 请在调用前初始化：init(context), 请在调用前初始化：init(context)");
            }
            return;
        }

        Toast.makeText(mContext, txt, Toast.LENGTH_SHORT).show();
    }

    /**
     * Toast 短时间显示,传文字Id
     *
     * @param id
     */
    public static void show(int id) {
        if (mContext == null || id == 0) {
            if (DEBUG) {
                throw new NullPointerException("mContext == null或参数为null, 请在调用前初始化：init(context)");
            }
            return;
        }

        Toast.makeText(mContext, mContext.getResources().getString(id), Toast.LENGTH_SHORT).show();
    }

    /**
     * Toast 长时间显示,传文字
     *
     * @param txt
     */
    public static void showLong(String txt) {
        if (mContext == null || StringUtil.isEmpty(txt)) {
            if (DEBUG) {
                throw new NullPointerException("mContext == null或参数为null, 请在调用前初始化：init(context)");
            }
            return;
        }

        Toast.makeText(mContext, txt, Toast.LENGTH_LONG).show();
    }

    /**
     * Toast 长时间显示,传文字Id
     *
     * @param id
     */
    public static void showLong(int id) {
        if (mContext == null || id == 0) {
            if (DEBUG) {
                throw new NullPointerException("mContext == null或参数为null, 请在调用前初始化：init(context)");
            }
            return;
        }

        Toast.makeText(mContext, mContext.getResources().getString(id), Toast.LENGTH_LONG).show();
    }
}
