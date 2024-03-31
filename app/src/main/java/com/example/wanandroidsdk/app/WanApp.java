package com.example.wanandroidsdk.app;

import android.app.Application;

/**
 * @auth: njb
 * @date: 2024/3/31 1:12
 * @desc: 描述
 */
public class WanApp extends Application {
    private static Application mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static Application getInstance() {
        return  mInstance;
    }
}
