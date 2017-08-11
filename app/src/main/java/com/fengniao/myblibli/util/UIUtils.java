package com.fengniao.myblibli.util;


import android.widget.Toast;

import static com.fengniao.myblibli.app.BilibiliApp.getAppContext;

public class UIUtils {

    public static void showToast(String msg){
        Toast.makeText(getAppContext(),msg,Toast.LENGTH_SHORT).show();
    }


}
