package com.example.wanandroidsdk.bean

import java.io.Serializable

/**
 * @auth: njb
 * @date: 2024/4/13 23:06
 * @desc: 描述
 */
data class WanKnowDataBean(
    var courseId: Int = 0,
    var id: Int = 0,
    var name: String,
    var order: Int = 0,
    var parentChapterId: Int = 0,
    var visible: Int = 0,
    var children: List<WanChildrenBean>,
    var isSelect: Boolean = false
):Serializable
