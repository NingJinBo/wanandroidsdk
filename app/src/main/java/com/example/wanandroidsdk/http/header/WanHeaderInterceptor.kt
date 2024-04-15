package com.example.wanandroidsdk.http.header

import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/**
 * @auth: njb
 * @date: 2024/4/15 9:28
 * @desc: 描述
 */
class WanHeaderInterceptor :Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val request:Request = chain.request()
        val requestBuilder: Request.Builder = request.newBuilder()
        requestBuilder.cacheControl(CacheControl.Builder().noCache().build())
            .header("Content-Type", "application/json; charset=UTF-8")
            .header("Charset", "UTF-8")
            .header("Connection", "Keep-Alive")
            .addHeader("Cache-Control", "public, max-age=0")
            .header("Accept", "application/json")
        return chain.proceed(requestBuilder.build())
    }
}