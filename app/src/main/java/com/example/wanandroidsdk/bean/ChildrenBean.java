package com.example.wanandroidsdk.bean;

import java.util.List;

/**
 * @author: njb
 * @date: 2024/3/30 14:59
 * @desc:
 */
public class ChildrenBean {
    private int courseId= 0;
    private int id= 0;
    private String name;
    private int order= 0;
    private int parentChapterId= 0;
    private int visible= 0;
    private List<String> children;
    private Boolean isSelect= false;

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

    public List<String> getChildren() {
        return children;
    }

    public void setChildren(List<String> children) {
        this.children = children;
    }

    public Boolean getSelect() {
        return isSelect;
    }

    public void setSelect(Boolean select) {
        isSelect = select;
    }

    @Override
    public String toString() {
        return "ChildrenBean{" +
                "courseId=" + courseId +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", order=" + order +
                ", parentChapterId=" + parentChapterId +
                ", visible=" + visible +
                ", children=" + children +
                ", isSelect=" + isSelect +
                '}';
    }
}
