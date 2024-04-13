package com.example.wanandroidsdk.utils

import android.util.Log

/**
 * @auth: njb
 * @date: 2024/4/13 23:43
 * @desc: 描述
 */
class LogUtils {
    private val showLog = true

    fun i(tag: String?, msg: String?) {
        if (showLog) Log.i(tag, msg!!)
    }

    fun d(tag: String?, msg: String?) {
        if (showLog) Log.d(tag, msg!!)
    }

    fun w(tag: String?, msg: String?) {
        if (showLog) Log.w(tag, msg!!)
    }

    fun e(tag: String?, msg: String?) {
        if (showLog) Log.e(tag, msg!!)
    }
}