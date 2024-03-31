package com.example.wanandroidsdk.utils;

import android.util.Log;

/**
 * @auth: njb
 * @date: 2024/3/31 23:44
 * @desc: 描述
 */
public class LogUtils {
    private static boolean showLog = true;

    public static void i(String tag, String msg) {
        if (showLog)
            Log.i(tag, msg);
    }

    public static void d(String tag, String msg) {
        if (showLog)
            Log.d(tag, msg);
    }

    public static void w(String tag, String msg) {
        if (showLog)
            Log.w(tag, msg);
    }

    public static void e(String tag, String msg) {
        if (showLog)
            Log.e(tag, msg);
    }
}
