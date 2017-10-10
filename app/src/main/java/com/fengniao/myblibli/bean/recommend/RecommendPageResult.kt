package com.fengniao.myblibli.bean.recommend


data class RecommendPageResult(var code: Int, var result: List<RecommendPageData>) {

    data class RecommendPageData(var type: String?, var head: Head?, var body: List<Body>?)
    data class Head(var param: String?, var goto: String?, var style: String?, var title: String?)
    data class Body(var title: String?, var style: String?, var cover: String?,
                    var param: String?, var goto: String?, var width: Int?,
                    var height: Int?, var up_face: String?, var up: String?,
                    var online: Int?, var area: String?, var area_id: Int?)

}