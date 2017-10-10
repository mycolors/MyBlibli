package com.fengniao.myblibli.net;


import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.fengniao.myblibli.app.BilibiliApp;
import com.fengniao.myblibli.net.api.HomeService;
import com.fengniao.myblibli.net.api.LiveService;
import com.fengniao.myblibli.net.api.home.DramaService;
import com.fengniao.myblibli.net.api.home.RecommendService;
import com.fengniao.myblibli.util.NetworkUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpClient {

    private OkHttpClient mOkHttpClient;

    private static HttpClient INSTANCE;

    private String token;

    private HttpClient() {
        initOkHttpClient();
    }

    public static HttpClient getInstance() {
        if (INSTANCE == null) {
            synchronized (HttpClient.class) {
                if (INSTANCE == null) {
                    INSTANCE = new HttpClient();
                }
            }
        }
        return INSTANCE;
    }


    public HomeService getHomeApi() {
        return createApi(HomeService.class, ApiConstants.LIVE_BASE_URL);
    }


    public LiveService getLiveApi() {
        return createApi(LiveService.class, ApiConstants.LIVE_BASE_URL);
    }


    public RecommendService getRecommendService() {
        return createApi(RecommendService.class, ApiConstants.APP_BASE_URL);
    }

    public DramaService getDramaService() {
        return createApi(DramaService.class, ApiConstants.BANGUMI_BASE_URL);
    }


    private <T> T createApi(Class<T> tClass, String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(tClass);
    }


    /**
     * 初始化OKHttpClient,设置缓存,设置超时时间,设置打印日志,设置UA拦截器
     */
    private void initOkHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        if (mOkHttpClient == null) {
            //设置Http缓存
            Cache cache = new Cache(new File(BilibiliApp.getAppContext().getCacheDir(), "HttpCache"), 1024 * 1024 * 10);
            mOkHttpClient = new OkHttpClient.Builder()
                    .cache(cache)
                    .addInterceptor(interceptor)
                    .addNetworkInterceptor(new CacheInterceptor())
                    .addNetworkInterceptor(new StethoInterceptor())
                    .retryOnConnectionFailure(true)
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(20, TimeUnit.SECONDS)
                    .readTimeout(20, TimeUnit.SECONDS)
//                    .addInterceptor(new UserAgentInterceptor())
                    .build();
        }
    }


    /**
     * 添加UA拦截器，B站请求API需要加上UA才能正常使用
     */
    private static class UserAgentInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request originalRequest = chain.request();
            Request requestWithUserAgent = originalRequest.newBuilder()
                    .removeHeader("User-Agent")
                    .addHeader("User-Agent", ApiConstants.COMMON_UA_STR)
                    .build();
            return chain.proceed(requestWithUserAgent);
        }
    }


    /**
     * 为okhttp添加缓存，这里是考虑到服务器不支持缓存时，从而让okhttp支持缓存
     */
    private class CacheInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            // 有网络时 设置缓存超时时间1个小时
            int maxAge = 60 * 60;
            // 无网络时，设置超时为1天
            int maxStale = 60 * 60 * 24;
            Request request = chain.request();
            if (NetworkUtils.isNetworkAvailable(BilibiliApp.getAppContext())) {
                //有网络时只从网络获取
                request = request.newBuilder().cacheControl(CacheControl.FORCE_NETWORK).build();
            } else {
                //无网络时只从缓存中读取
                request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
            }
            Response response = chain.proceed(request);
            if (NetworkUtils.isNetworkAvailable(BilibiliApp.getAppContext())) {
                response = response.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, max-age=" + maxAge)
                        .build();
            } else {
                response = response.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .build();
            }
            return response;
        }
    }


}

