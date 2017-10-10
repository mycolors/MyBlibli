package com.fengniao.myblibli.net.api;


import com.fengniao.myblibli.bean.live.CommonLiveData;
import com.fengniao.myblibli.bean.live.RecommendLiveData;
import com.fengniao.myblibli.net.HttpResult;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface LiveService {

    /**
     * 获取首页直播列表
     */
    @GET("AppNewIndex/common?_device=android&platform=android&scale=xxhdpi")
    Observable<HttpResult<CommonLiveData>> getCommonLiveList();

    @GET("AppNewIndex/recommend?_device=android&_hwid=IkF1TCkaeUsvTXtKNko2ADQNbAlsXQ&appkey=1d8b6e7d45233436&build=512000&mobi_app=android&platform=android&scale=xxhdpi&src=html5_seo&trace_id=20170824175300007&ts=1503568387&version=5.12.0.512000&sign=622524ced64239aa17587bf4c4f69888")
    Observable<HttpResult<RecommendLiveData>> getRecommendLiveList();


}
