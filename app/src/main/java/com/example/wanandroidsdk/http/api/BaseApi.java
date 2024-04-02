package com.example.wanandroidsdk.http.api;

import android.util.Log;

import com.example.wanandroidsdk.app.WanApp;
import com.example.wanandroidsdk.http.header.HeaderInterceptor;
import com.example.wanandroidsdk.utils.LogUtils;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @auth: njb
 * @date: 2024/3/31 23:44
 * @desc: 描述
 */
public class BaseApi {
    public static final int DEFAULT_TIMEOUT = 20000;//10秒

    protected static OkHttpClient.Builder getHttpClient(final String tagName) {
        OkHttpClient.Builder httpClientBuilder;

        //设置缓存路径，系统默认缓存路径，并且限制缓存大小500m
        httpClientBuilder = new OkHttpClient.Builder();
        try {
            httpClientBuilder.addNetworkInterceptor(new HeaderInterceptor());
            httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS);
            httpClientBuilder.writeTimeout(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS);
            httpClientBuilder.readTimeout(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS);
            httpClientBuilder.retryOnConnectionFailure(true);

            //根据当前调试状态，是否显示请求日志
      /*      HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String message) {
                    LogUtils.e(tagName + "", message);
                }
            });
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClientBuilder.addInterceptor(interceptor);*/
            httpClientBuilder.addInterceptor(new CustomLoggingInterceptor());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return httpClientBuilder;
    }


    static class CustomLoggingInterceptor implements Interceptor {

        private String TAG = BaseApi.class.getSimpleName();

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            long startTime = System.currentTimeMillis();
            Response response = chain.proceed(chain.request());

            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            okhttp3.MediaType mediaType = response.body().contentType();
            String content = response.body().string();
            LogUtils.e(TAG, "----------Request Start----------------");
            LogUtils.e(TAG, "| " + request.toString() + request.headers().toString());
            LogUtils.e(TAG, "| Response:" + content);
            LogUtils.e(TAG, "----------Request End:" + duration + "毫秒----------");
            return response.newBuilder()
                    .body(ResponseBody.create(mediaType, content))
                    .build();
        }
    }
}
