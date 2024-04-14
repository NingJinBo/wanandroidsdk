package com.example.wanandroidsdk.http

/**
 * @author: njb
 * @date: 2024/3/30 17:32
 * @desc:
 */
class WanHttpResult<T> {
    /**
     * 记录请求回来的状态描述
     */
    var errorMsg: String? = null

    /**
     * 记录请求回来的错误状态描述
     */
    var code = ""

    /**
     * 记录请求回来的错误状态描述
     */
    var errorCode: Int? = 0

    /**
     * 记录返回的数据
     */
    var data: T? = null
        private set

    /**
     * 业务是否成功
     */
    fun isBizSucceed(defaultValue: Boolean): Boolean {
        return if (null == errorCode) defaultValue else errorCode == 0
    }

    fun setMessage(message: String?) {
        errorMsg = message
    }

    fun setData(data: T) {
        this.data = data
    }
}
