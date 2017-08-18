package com.fengniao.myblibli.net.api;


import com.fengniao.myblibli.bean.live.LiveData;
import com.fengniao.myblibli.net.HttpResult;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface LiveService {

    /**
     * 获取首页直播列表
     */
    @GET("AppNewIndex/common?_device=android&platform=android&scale=xxhdpi")
    Observable<HttpResult<LiveData>> getHomeLiveList();

}
