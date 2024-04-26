package com.example.wanandroidsdk.http.api

import com.example.wanandroidsdk.constant.Constants
import com.example.wanandroidsdk.http.header.WanHeaderInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit
import com.blankj.utilcode.util.LogUtils

object WanApi  {
    const val DEFAULT_TIMEOUT = 20000

    private val wanApi by lazy {
        //获取请求客户端
        val okHttpClient: OkHttpClient.Builder = getHttpClient(WanApi::class.java.getSimpleName())

        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient.build())
            .build()
        retrofit.create(ApiService::class.java)
    }

    fun getHttp():ApiService{
        return wanApi
    }

    fun getHttpClient(tagName: String?): OkHttpClient.Builder {
        //设置缓存路径，系统默认缓存路径，并且限制缓存大小500m
        val httpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
        try {
            httpClientBuilder.addNetworkInterceptor(WanHeaderInterceptor())
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