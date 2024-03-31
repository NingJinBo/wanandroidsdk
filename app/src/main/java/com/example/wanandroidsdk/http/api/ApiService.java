package com.example.wanandroidsdk.http.api;


import com.example.wanandroidsdk.bean.ArticleListBean;
import com.example.wanandroidsdk.bean.EasyDataBean;
import com.example.wanandroidsdk.constant.Constants;
import com.example.wanandroidsdk.http.WanHttpResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author: njb
 * @date: 2024/3/30 18:04
 * @desc:
 */
public interface ApiService {
    /**
     * 获取首页banner
     */
    @GET(Constants.BANNER_LIST)
    Call<WanHttpResult<List<EasyDataBean>>> banner();

    /**
     * 获取文章列表
     * @param page
     * @return
     */
    @GET(Constants.ARTICLE_LIST)
    Call<WanHttpResult<ArticleListBean>> articleList(@Path("page") int page);

    /**
     *获取搜索热词
     *
     */
    @GET(Constants.HOT_KEY)
    Call<WanHttpResult<List<EasyDataBean>>> getHotKey();

    /**
     * 获取知识
     * @return
     */
    @GET(Constants.TREE)
    Call<WanHttpResult<List<EasyDataBean>>> getKnowLedge();
}
