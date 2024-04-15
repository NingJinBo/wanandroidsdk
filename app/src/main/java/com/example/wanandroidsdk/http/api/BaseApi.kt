package com.example.wanandroidsdk.http.api

import com.example.wanandroidsdk.http.header.HeaderInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody
import java.io.IOException
import java.util.concurrent.TimeUnit
import com.blankj.utilcode.util.LogUtils

/**
 * @auth: njb
 * @date: 2024/4/14 15:32
 * @desc: 描述
 */
open class BaseApi {
    companion object {
        const val DEFAULT_TIMEOUT = 20000
        fun getHttpClient(tagName: String?): OkHttpClient.Builder {
            //设置缓存路径，系统默认缓存路径，并且限制缓存大小500m
            val httpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
            try {
                httpClientBuilder.addNetworkInterceptor(HeaderInterceptor())
                httpClientBuilder.connectTimeout(
                    DEFAULT_TIMEOUT.toLong(),
                    TimeUnit.MILLISECONDS
                )
                httpClientBuilder.writeTimeout(
                    DEFAULT_TIMEOUT.toLong(),
                    TimeUnit.MILLISECONDS
                )
                httpClientBuilder.readTimeout(
                    DEFAULT_TIMEOUT.toLong(),
                    TimeUnit.MILLISECONDS
                )
                httpClientBuilder.retryOnConnectionFailure(true)
                httpClientBuilder.addInterceptor(CustomLoggingInterceptor())
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return httpClientBuilder
        }
    }


    internal class CustomLoggingInterceptor : Interceptor {
        private val TAG = "okhttp"

        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            val request: Request = chain.request()
            val startTime = System.currentTimeMillis()
            val response: Response = chain.proceed(chain.request())
            val endTime = System.currentTimeMillis()
            val duration = endTime - startTime
            assert(response.body != null)
            val mediaType = response.body!!.contentType()
            val content = response.body!!.string()
            LogUtils.e(TAG, "----------Request Start----------------")
            LogUtils.e(TAG, "| " + request + request.headers)
            LogUtils.e(TAG, "| Response:$content")
            LogUtils.e(TAG, "----------Request End:" + duration + "毫秒----------")
            return response.newBuilder()
                .body(ResponseBody.create(mediaType, content))
                .build()
        }
    }

}