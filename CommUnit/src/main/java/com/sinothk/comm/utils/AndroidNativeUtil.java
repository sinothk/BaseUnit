package com.sinothk.comm.utils;


import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

/**
 * <pre>
 *  创建:  LiangYT 2018/6/20/020 on 16:00
 *  项目: gxqptAndroid
 *  描述:
 *  更新:
 * <pre>
 */
public class AndroidNativeUtil extends com.sinothk.comm.utils.AppUtil {

//    /**
//     * 打开其他App
//     *
//     * @param mContext
//     * @param packName
//     * @param targetActivity
//     * @param bundle
//     */
//    public static String startOtherApp(Context mContext, String packName, String targetActivity, Bundle bundle) {
//
//        try {
//            //第一种方式
////            ComponentName cn = new ComponentName(packName, targetActivity);
////            intent.setComponent(cn);
//            //第二种方式
//            Intent intent = new Intent();
//            intent.setClassName(packName, targetActivity);
//            if (bundle != null) {
//                intent.putExtras(bundle);
//            }
//            mContext.startActivity(intent);
//            return "";
//        } catch (Exception e) {
//            // 可以在这里提示用户没有安装应用或找不到指定Activity，或者是做其他的操作
//            Toast.makeText(mContext, "没有安装：" + packName, Toast.LENGTH_SHORT).show();
//            return "没有安装";
//        }
//    }

    /**
     * 打开其他App
     *
     * @param mContext
     * @param packName
     */
    public static String startOtherApp(Context mContext, String packName, Bundle bundle) {
        PackageManager packageManager = mContext.getPackageManager();

        PackageInfo packageInfo;
        try {
            packageInfo = packageManager.getPackageInfo(packName, 0);
            if (packageInfo != null) {
                Intent intent = packageManager.getLaunchIntentForPackage(packName);
                if (bundle != null) {
                    assert intent != null;
                    intent.putExtras(bundle);
                }
                mContext.startActivity(intent);
                return "";
            } else {
                return "没有安装";
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "没有安装";
        }
    }

    public static void downLoadByBrowser(Context mContext, String url) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        // 走自己的服务器
        intent.setData(Uri.parse(url));
        mContext.startActivity(intent);
    }
}
