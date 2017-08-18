package com.fengniao.myblibli.app;

import android.app.Application;
import android.content.Context;


public class BilibiliApp extends Application {
    public static Context APPCONTEXT;

    @Override
    public void onCreate() {
        super.onCreate();
        APPCONTEXT = getApplicationContext();
    }

    public static Context getAppContext() {
        return APPCONTEXT;
    }

}
