package com.example.wanandroidsdk

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.wanandroidsdk.http.api.EasyApi
import com.example.wanandroidsdk.http.api.WanApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
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
                val result = WanApi.getApi().getBanner()
                if(result.data != null){
                    Log.d(TAG,"===数据请求成功===${result.data}")
                }
            }
        }
    }

    fun getHotKey(view: View) {
        view.setOnClickListener {
            MainScope().launch(Dispatchers.Main) {
                val hotList = EasyApi.getDefault().hotKeyList()
                if(hotList.data != null){
                    Log.d(TAG,"===搜索热词列表获取成功===${hotList.data}")
                }
            }
        }
    }

    fun getKnow(view: View) {
        view.setOnClickListener {
            MainScope().launch(Dispatchers.Main) {
                val knowList = EasyApi.getDefault().knowList()
                if(knowList.data != null){
                    Log.d(TAG,"===知识列表获取成功===${knowList.data}")
                }
            }
        }
    }

    fun getArticleList(view: View) {
        view.setOnClickListener {
            MainScope().launch {
                val artists = EasyApi.getDefault().articleList(1)
                if(artists.data != null){
                    Log.d(TAG,"===文章列表获取成功===${artists.data}")
                }
            }
        }
    }
}