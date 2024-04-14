package com.example.wanandroidsdk.http

import com.example.wanandroidsdk.bean.WanDataBean

/**
 * @auth: njb
 * @date: 2024/4/14 12:46
 * @desc: 描述
 */
interface WanHttpCallBack {
    fun onResponse(result: List<WanDataBean>): Boolean

    fun onFailure(message: String?): Boolean
}