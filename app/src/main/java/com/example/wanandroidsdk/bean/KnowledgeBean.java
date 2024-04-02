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

        public int getCourseId() {
            return courseId;
        }

        public void setCourseId(int courseId) {
            this.courseId = courseId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public int getParentChapterId() {
            return parentChapterId;
        }

        public void setParentChapterId(int parentChapterId) {
            this.parentChapterId = parentChapterId;
        }

        public int getVisible() {
            return visible;
        }

        public void setVisible(int visible) {
            this.visible = visible;
        }

        public List<ChildrenBean> getChildren() {
            return children;
        }

        public void setChildren(List<ChildrenBean> children) {
            this.children = children;
        }

        public Boolean getSelect() {
            return isSelect;
        }

        public void setSelect(Boolean select) {
            isSelect = select;
        }
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "KnowledgeBean{" +
                "data=" + data +
                '}';
    }
}
