package com.example.wanandroidsdk.http;


import com.example.wanandroidsdk.bean.WanDataBean;

import java.util.List;

/**
 * @auth: njb
 * @date: 2024/3/31 1:10
 * @desc: 请求回调
 */
public interface WanHttpCallBack {
    Boolean onResponse(List<WanDataBean> result);

    Boolean onFailure(String message);
}
