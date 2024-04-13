package com.example.wanandroidsdk.bean

/**
 * @auth: njb
 * @date: 2024/4/13 23:07
 * @desc: 描述
 */
data class WanChildrenBean(
    var courseId : Int = 0,
    var id :Int =0,
    var name :String = "",
    var order:Int = 0,
    var parentChapterId :Int = 0,
    var visible:Int = 0,
    var children:List<String>,
    var isSelect:Boolean = false
)
