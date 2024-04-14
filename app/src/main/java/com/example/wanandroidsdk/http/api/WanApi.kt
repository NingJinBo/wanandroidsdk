package com.example.wanandroidsdk.http.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object WanApi  {

    private val wanApi by lazy {
        //获取请求客户端
        val okHttpClient: OkHttpClient.Builder = BaseApi.getHttpClient(
            WanApi::class.java.getSimpleName()
        )
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
}