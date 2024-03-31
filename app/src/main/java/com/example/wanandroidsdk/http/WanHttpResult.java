package com.example.wanandroidsdk.http;

/**
 * @author: njb
 * @date: 2024/3/30 17:32
 * @desc:
 */
public class WanHttpResult<T> {
    /**
     * 记录请求回来的状态描述
     */
    private String errorMsg;
    /**
     * 记录请求回来的错误状态描述
     */
    private String code = "";
    /**
     * 记录请求回来的错误状态描述
     */
    private Integer errorCode = 0;
    /**
     * 记录返回的数据
     */
    private T data;

    /**
     * 业务是否成功
     */
    public boolean isBizSucceed(boolean defaultValue) {
        return null == errorCode ? defaultValue : errorCode == 0;
    }

    public void setMessage(String message) {
        this.errorMsg = message;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
