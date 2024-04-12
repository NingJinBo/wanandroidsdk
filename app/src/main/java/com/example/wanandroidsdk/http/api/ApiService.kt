package com.example.wanandroidsdk.http.api

import com.example.wanandroidsdk.bean.ArticleListBean
import com.example.wanandroidsdk.bean.EasyDataBean
import com.example.wanandroidsdk.constant.Constants
import com.example.wanandroidsdk.http.WanHttpResult
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET(Constants.BANNER_LIST)
    suspend fun getBanner():  WanHttpResult<List<EasyDataBean>>

    @GET(Constants.ARTICLE_LIST)
    suspend fun articleList(@Path("page") page:Int): WanHttpResult<ArticleListBean>

    @GET(Constants.HOT_KEY)
    suspend fun hotKeyList(): WanHttpResult<List<EasyDataBean>>
    
    @GET(Constants.TREE)
    suspend fun knowList(): WanHttpResult<List<EasyDataBean>>
}