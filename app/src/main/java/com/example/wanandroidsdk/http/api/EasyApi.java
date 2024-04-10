package com.example.wanandroidsdk.http.api;

import com.example.wanandroidsdk.constant.Constants;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * @auth: njb
 * @date: 2024/3/31 13:45
 * @desc: 描述
 */
public class EasyApi extends BaseApi{
    private static ApiService SERVICE;

    public static ApiService getDefault() {
        if (SERVICE == null) {
            //获取请求客户端
            OkHttpClient.Builder httpClientBuilder = getHttpClient(EasyApi.class.getSimpleName());
            SERVICE = new Retrofit.Builder()
                    .client(httpClientBuilder.build())
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(Constants.EasyPlayHostDefault)
                    .build().create(ApiService.class);
        }
        return SERVICE;
    }
}
