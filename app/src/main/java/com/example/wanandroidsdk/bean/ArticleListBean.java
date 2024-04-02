package com.example.wanandroidsdk.bean;

import java.util.List;

/**
 * @author: njb
 * @date: 2024/3/30 11:23
 * @desc:
 */
public class ArticleListBean {
    public List<EasyDataBean> datas;

    public List<EasyDataBean> getDatas() {
        return datas;
    }

    public void setDatas(List<EasyDataBean> datas) {
        this.datas = datas;
    }

    @Override
    public String toString() {
        return "ArticleListBean{" +
                "datas=" + datas +
                '}';
    }
}
