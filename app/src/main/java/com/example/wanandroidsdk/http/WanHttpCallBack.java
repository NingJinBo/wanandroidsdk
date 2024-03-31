package com.example.wanandroidsdk.http;

import com.example.wanandroidsdk.bean.EasyDataBean;

import java.util.List;

/**
 * @auth: njb
 * @date: 2024/3/31 1:10
 * @desc: 描述
 */
public interface WanHttpCallBack {
    Boolean onResponse(List<EasyDataBean> result);

    Boolean onFailure(String message);
}
