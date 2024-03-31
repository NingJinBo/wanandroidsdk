package com.example.wanandroidsdk.http;


import com.example.wanandroidsdk.bean.ArticleListBean;
import com.example.wanandroidsdk.bean.EasyDataBean;
import com.example.wanandroidsdk.http.api.EasyApi;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author: njb
 * @date: 2024/3/30 17:55
 * @desc: 网络请求工具类
 */
public class WanHttpUtil {

    public static void getBanner(final WanHttpCallBack callBack) {
        (EasyApi.getDefault().banner()).enqueue(new Callback<WanHttpResult<List<EasyDataBean>>>() {
            @Override
            public void onResponse(@NotNull Call<WanHttpResult<List<EasyDataBean>>> call, @NotNull Response<WanHttpResult<List<EasyDataBean>>> response) {
                WanHttpResult<List<EasyDataBean>> result = response.body();
                if (result != null && result.isBizSucceed(true) && result.getData() != null) {
                    callBack.onResponse(result.getData());
                }
            }

            @Override
            public void onFailure(@NotNull Call<WanHttpResult<List<EasyDataBean>>> call, @NotNull Throwable t) {
                callBack.onFailure(t.getMessage());
            }
        });
    }

    public static void getArticle(int page, final WanHttpCallBack callBack) {
        EasyApi.getDefault().articleList(page).enqueue(new Callback<WanHttpResult<ArticleListBean>>() {
            @Override
            public void onResponse(@NotNull Call<WanHttpResult<ArticleListBean>> call, Response<WanHttpResult<ArticleListBean>> response) {
                WanHttpResult<ArticleListBean> result = response.body();
                if (result != null && result.isBizSucceed(true)) {
                    try {
                        callBack.onResponse(result.getData().datas);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<WanHttpResult<ArticleListBean>> call, Throwable t) {
                callBack.onFailure(t.getMessage());
            }
        });
    }

    public static void getHotKey(final WanHttpCallBack callBack){
        EasyApi.getDefault().getHotKey().enqueue(new Callback<WanHttpResult<List<EasyDataBean>>>() {
            @Override
            public void onResponse(@NotNull Call<WanHttpResult<List<EasyDataBean>>> call, @NotNull Response<WanHttpResult<List<EasyDataBean>>> response) {
                WanHttpResult<List<EasyDataBean>> result  =response.body();
                if (result != null && result.isBizSucceed(true) && result.getData() != null) {
                    callBack.onResponse(result.getData());
                }
            }

            @Override
            public void onFailure(@NotNull Call<WanHttpResult<List<EasyDataBean>>> call, @NotNull Throwable t) {
                callBack.onFailure(t.getMessage());
            }
        });
    }

    public static void getKnwLedge(final WanHttpCallBack callBack){
        EasyApi.getDefault().getKnowLedge().enqueue(new Callback<WanHttpResult<List<EasyDataBean>>>() {
            @Override
            public void onResponse(@NotNull Call<WanHttpResult<List<EasyDataBean>>> call, @NotNull Response<WanHttpResult<List<EasyDataBean>>> response) {
                WanHttpResult<List<EasyDataBean>> result  = response.body();
                if (result != null && result.isBizSucceed(true) && result.getData() != null) {
                    callBack.onResponse(result.getData());
                }
            }

            @Override
            public void onFailure(@NotNull Call<WanHttpResult<List<EasyDataBean>>> call, @NotNull Throwable t) {
                       callBack.onFailure(t.getMessage());
            }
        });
    }
}
