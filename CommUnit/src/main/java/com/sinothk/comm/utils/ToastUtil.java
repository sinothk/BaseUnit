package com.sinothk.comm.utils;

import android.widget.Toast;

/**
 * Company SINOTHK Created by 梁玉涛 on 2015/9/22.
 */
public class ToastUtil extends OUtil {

    /**
     * Toast 短时间显示,传文字
     *
     * @param txt
     */
    public static void show(String txt) {
        if (isDisable() || StringUtil.isEmpty(txt)) return;

        Toast.makeText(mContext, txt, Toast.LENGTH_SHORT).show();
    }

    /**
     * Toast 短时间显示,传文字Id
     *
     * @param id
     */
    public static void show(int id) {
        if (isDisable()) return;

        if (id > 0) {
            Toast.makeText(mContext, mContext.getResources().getString(id), Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Toast 长时间显示,传文字
     *
     * @param txt
     */
    public static void showLong(String txt) {
        if (isDisable() || StringUtil.isEmpty(txt)) return;

        Toast.makeText(mContext, txt, Toast.LENGTH_LONG).show();
    }

    /**
     * Toast 长时间显示,传文字Id
     *
     * @param id
     */
    public static void showLong(int id) {
        if (isDisable()) return;

        if (id > 0) {
            Toast.makeText(mContext, mContext.getResources().getString(id), Toast.LENGTH_LONG).show();
        }
    }
}
