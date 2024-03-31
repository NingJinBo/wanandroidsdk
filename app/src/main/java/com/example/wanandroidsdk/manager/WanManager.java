package com.example.wanandroidsdk.manager;

import android.app.Application;
import android.content.Context;

/**
 * @auth: njb
 * @date: 2024/3/31 16:59
 * @desc: 描述
 */
public class WanManager {
    private static Context mContent;

    public static void init(Application application) {
        mContent = application.getApplicationContext();
    }
}
