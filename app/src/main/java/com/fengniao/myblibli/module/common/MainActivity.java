package com.fengniao.myblibli.module.common;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.fengniao.myblibli.R;
import com.fengniao.myblibli.base.BaseActivity;
import com.fengniao.myblibli.module.home.HomeTabFragment;
import com.fengniao.myblibli.util.UIUtils;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.container)
    FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);

            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {

                //将侧边栏顶部延伸至status bar

                drawerLayout.setFitsSystemWindows(true);

                //将主页面顶部延伸至status bar;虽默认为false,但经测试,DrawerLayout需显示设置

                drawerLayout.setClipToPadding(false);
            }
        }
        initView();
    }

    public void initView() {
        HomeTabFragment fragment = HomeTabFragment.newInstance();
        getSupportFragmentManager().beginTransaction().add(R.id.container, fragment).show(fragment).commit();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }


    long lastTime;

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - lastTime > 2000) {
            UIUtils.showToast("再按一次退出");
            lastTime = System.currentTimeMillis();
            return;
        }
        super.onBackPressed();

    }
}
