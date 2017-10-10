package com.fengniao.myblibli.util;


import android.content.Context;
import android.content.SharedPreferences;

import com.fengniao.myblibli.bean.DayNight;

//切换白天夜晚模式的辅助类
public class DayNightHelper {

    private static final String SPF_NAME = "DayOrNight";

    private static final String MODE = "day_night_mode";

    private SharedPreferences mSharedPreferences;

    public DayNightHelper(Context context) {
        mSharedPreferences = context.getApplicationContext()
                .getSharedPreferences(SPF_NAME, Context.MODE_PRIVATE);
    }


    public boolean setMode(DayNight mode) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(MODE, mode.getName());
        return editor.commit();
    }


    public boolean isNight() {
        String mode = mSharedPreferences.getString(MODE, DayNight.NIGHT.getName());
        return DayNight.NIGHT.getName().equals(mode);
    }


    public boolean isDay() {
        String mode = mSharedPreferences.getString(MODE, DayNight.DAY.getName());
        return DayNight.DAY.getName().equals(mode);
    }

}
