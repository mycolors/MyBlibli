package com.fengniao.myblibli.net.api.home

import com.fengniao.myblibli.bean.drama.DramaPageData
import com.fengniao.myblibli.bean.drama.DramaPageResult
import com.fengniao.myblibli.bean.drama.RecommendDramaData
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * 番剧API
 */
interface DramaService {

    /**
     * 番剧页面数据
     */
    @GET("api/app_index_page_v4?build=3940&device=phone&mobi_app=iphone&platform=ios")
    fun getDramaData(): Observable<DramaPageResult<DramaPageData>>

    /**
     * 推荐番剧
     */
    @GET("api/bangumi_recommend?access_key=f5bd4e793b82fba5aaf5b91fb549910a&actionKey=appkey&appkey=27eb53fc9058f8c3&build=3470&cursor=0&device=phone&mobi_app=iphone&pagesize=10&platform=ios&sign=56329a5709c401d4d7c0237f64f7943f&ts=1469613558")
    fun getRecommendDrama(): Observable<DramaPageResult<List<RecommendDramaData>>>


}