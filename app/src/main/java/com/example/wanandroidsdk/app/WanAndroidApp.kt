package com.example.wanandroidsdk.app

import android.app.Application

/**
 * @auth: njb
 * @date: 2024/4/14 12:58
 * @desc: 描述
 */
class WanAndroidApp : Application() {

    override fun onCreate() {
        super.onCreate()
    }

    companion object{
       val instance by lazy (LazyThreadSafetyMode.SYNCHRONIZED){
           WanAndroidApp()
       }
    }
}