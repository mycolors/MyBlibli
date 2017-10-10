package com.fengniao.myblibli.net.api.home

import com.fengniao.myblibli.bean.recommend.RecommendBannerData
import com.fengniao.myblibli.bean.recommend.RecommendPageResult
import com.fengniao.myblibli.net.HttpResult
import io.reactivex.Observable
import retrofit2.http.GET

//推荐页API
interface RecommendService {

    //获取推荐页面数据
    @GET("x/show/old?platform=android&device=&build=412001")
    fun getRecommendData(): Observable<RecommendPageResult>

    //获取推荐banner数据
    @GET("x/banner?plat=4&build=411007&channel=bilih5")
    fun getRecommendBannerData(): Observable<HttpResult<List<RecommendBannerData>>>


}