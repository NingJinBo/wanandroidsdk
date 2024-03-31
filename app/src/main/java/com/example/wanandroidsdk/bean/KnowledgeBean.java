package com.example.wanandroidsdk.bean;

import java.util.List;

/**
 * @author: njb
 * @date: 2024/3/30 14:56
 * @desc:
 */
public class KnowledgeBean {
    public List<DataBean> data;

    public static class DataBean {
        private int courseId = 0;
        private int id = 0;
        private String name;
        private int order = 0;
        private int parentChapterId = 0;
        private int visible = 0;
        private List<ChildrenBean> children;
        private Boolean isSelect = false;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }
}
