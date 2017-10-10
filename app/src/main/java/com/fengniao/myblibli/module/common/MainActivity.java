package com.fengniao.myblibli.module.common;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatDelegate;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.fengniao.myblibli.R;
import com.fengniao.myblibli.base.BaseActivity;
import com.fengniao.myblibli.bean.DayNight;
import com.fengniao.myblibli.module.home.HomeTabFragment;
import com.fengniao.myblibli.util.DayNightHelper;
import com.fengniao.myblibli.util.UIUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.container)
    FrameLayout container;
    @BindView(R.id.text_night_mode)
    TextView textNightMode;

    private DayNightHelper mDayNightHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDayNightHelper = new DayNightHelper(this);
        initView();
    }

    public void initView() {
        HomeTabFragment fragment = (HomeTabFragment) getSupportFragmentManager().findFragmentByTag("home");
        if (fragment == null)
            fragment = HomeTabFragment.newInstance();
        if (fragment.isAdded()) {
            getSupportFragmentManager().beginTransaction().show(fragment).commit();
        } else {
            getSupportFragmentManager().beginTransaction().add(R.id.container, fragment, "home").show(fragment).commit();
        }
        if (mDayNightHelper.isNight()) {
            textNightMode.setText("夜间");
        } else {
            textNightMode.setText("白天");
        }
    }

    @OnClick(R.id.text_night_mode)
    public void onViewClicked() {
        if (mDayNightHelper.isNight()) {
            UIUtils.showToast("白天模式");
            mDayNightHelper.setMode(DayNight.DAY);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        } else {
            UIUtils.showToast("夜间模式");
            mDayNightHelper.setMode(DayNight.NIGHT);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        recreate();
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
