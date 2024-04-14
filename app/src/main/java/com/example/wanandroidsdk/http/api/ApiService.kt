package com.example.wanandroidsdk.http.api

import com.example.wanandroidsdk.bean.WanArticleListBean
import com.example.wanandroidsdk.bean.WanDataBean
import com.example.wanandroidsdk.http.WanHttpResult
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET(Constants.BANNER_LIST)
    suspend fun getBanner():  WanHttpResult<List<WanDataBean>>

    @GET(Constants.ARTICLE_LIST)
    suspend fun articleList(@Path("page") page:Int): WanHttpResult<WanArticleListBean>

    @GET(Constants.HOT_KEY)
    suspend fun hotKeyList(): WanHttpResult<List<WanDataBean>>
    
    @GET(Constants.TREE)
    suspend fun knowList(): WanHttpResult<List<WanDataBean>>
}