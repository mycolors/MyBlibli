package com.fengniao.myblibli.module.common;

import android.os.Bundle;

import com.fengniao.myblibli.R;
import com.fengniao.myblibli.base.BaseActivity;

/**
 * 启动页
 */
public class SplashActivity extends BaseActivity implements SplashContract.View {

    private SplashContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new SplashPresenter(this);
        mPresenter.setUpSplash();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }


    @Override
    public void setPresenter(SplashContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showLoginPage() {
        jumpToActivity(LoginActivity.class);
        finish();
    }

    @Override
    public void showMainPage() {
        jumpToActivity(MainActivity.class);
        finish();
    }
}
