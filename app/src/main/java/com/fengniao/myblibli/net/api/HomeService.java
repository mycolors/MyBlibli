package com.fengniao.myblibli.net.api;


import io.reactivex.Observable;
import retrofit2.http.GET;

public interface HomeService {

    /**
     * 首页推荐数据
     */
    @GET("x/show/old?platform=android&device=&build=412001")
    Observable<String> getRecommendInfo();

    /**
     * 首页推荐banner
     */
    @GET("x/banner?plat=4&build=411007&channel=bilih5")
    Observable<String> getRecommendBannerInfo();




}
