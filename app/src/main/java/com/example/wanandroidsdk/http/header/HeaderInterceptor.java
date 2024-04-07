package com.example.wanandroidsdk.http.header;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author: njb
 * @date: 2021/2/22 10:41
 * @desc:请求头部
 */
public class HeaderInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder requestBuilder = request.newBuilder();
            requestBuilder.cacheControl(new CacheControl.Builder().noCache().build())
                    .header("Content-Type", "application/json; charset=UTF-8")
                    .header("Charset", "UTF-8")
                    .header("Connection", "Keep-Alive")
                    .addHeader("Cache-Control", "public, max-age=0")
                    .header("Accept", "application/json");
                   // .header("token","testtest");

        return chain.proceed(requestBuilder.build());
    }

}
