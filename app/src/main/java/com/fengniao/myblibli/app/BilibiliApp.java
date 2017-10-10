package com.fengniao.myblibli.app;

import android.app.Application;
import android.content.Context;


public class BilibiliApp extends Application {
    public static Context APPCONTEXT;

    @Override
    public void onCreate() {
        super.onCreate();
        APPCONTEXT = getApplicationContext();
//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
    }

    public static Context getAppContext() {
        return APPCONTEXT;
    }

}
