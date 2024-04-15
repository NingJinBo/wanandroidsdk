package com.example.wanandroidsdk

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.blankj.utilcode.util.LogUtils
import com.example.wanandroidsdk.app.WanAndroidApp
import com.example.wanandroidsdk.http.api.WanApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val TAG = "okhttp"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun getData(view: View) {
        view.setOnClickListener {
            MainScope().launch(Dispatchers.Main) {
                val result = WanApi.getHttp().getBanner()
                if(result.data != null){
                    LogUtils.d(TAG,"===数据请求成功===${result.data}")
                }
            }
        }
    }

    fun getHotKey(view: View) {
        view.setOnClickListener {
            MainScope().launch(Dispatchers.Main) {
                val hotList = WanApi.getHttp().hotKeyList()
                if(hotList.data != null){
                    LogUtils.d(TAG,"===搜索热词列表获取成功===${hotList.data}")
                }
            }
        }
    }

    fun getKnow(view: View) {
        view.setOnClickListener {
            MainScope().launch(Dispatchers.Main) {
                val knowList = WanApi.getHttp().knowList()
                if(knowList.data != null){
                    LogUtils.d(TAG,"===知识列表获取成功===${knowList.data}")
                }
            }
        }
    }

    fun getArticleList(view: View) {
        view.setOnClickListener {
            MainScope().launch {
                val artists = WanApi.getHttp().articleList(1)
                if(artists.data != null){
                    LogUtils.d(TAG,"===文章列表获取成功===${artists.data}")
                }
            }
        }
    }
}