package com.fengniao.myblibli.module.common;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class SplashPresenter implements SplashContract.Presenter {

    private SplashContract.View mSplashView;

    public SplashPresenter(SplashContract.View splashView) {
        this.mSplashView = splashView;
        mSplashView.setPresenter(this);
    }

    @Override
    public void start() {
        setUpSplash();
    }

    @Override
    public void setUpSplash() {
        Observable.timer(2000, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> finishTask());
    }

    @Override
    public void finishTask() {
        mSplashView.showMainPage();
    }
}
