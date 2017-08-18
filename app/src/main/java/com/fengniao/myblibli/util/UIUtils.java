package com.fengniao.myblibli.util;


import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import static com.fengniao.myblibli.app.BilibiliApp.getAppContext;

public class UIUtils {

    public static void showToast(String msg) {
        Toast.makeText(getAppContext(), msg, Toast.LENGTH_SHORT).show();
    }


    //获取状态栏高度
    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    //沉浸式状态栏
    public static void translucentBar(Activity activity, int statusColor) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT &&
                Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            WindowManager.LayoutParams localLayoutParams = activity.getWindow().getAttributes();
            //设置状态栏透明，activity全屏显示
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().getDecorView().setSystemUiVisibility(
                    // SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN:Activity全屏显示，但状态栏不会被隐藏覆盖，状态栏依然可见，Activity顶端布局部分会被状态遮住。
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                            // SYSTEM_UI_FLAG_LAYOUT_STABLE:防止系统栏隐藏时内容区域大小发生变化
                            View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            activity.getWindow().setStatusBarColor(statusColor);

        }
    }

    //设置虚拟按键透明
    public static void translucentNavigation(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT &&
                Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            WindowManager.LayoutParams localLayoutParams = activity.getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION | localLayoutParams.flags);
        }
    }


}
