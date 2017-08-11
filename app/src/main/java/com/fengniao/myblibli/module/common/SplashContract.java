package com.fengniao.myblibli.module.common;


import com.fengniao.myblibli.base.BasePresenter;
import com.fengniao.myblibli.base.BaseView;

public interface SplashContract {

    interface Presenter extends BasePresenter {

        void setUpSplash();

        void finishTask();

    }

    interface View extends BaseView<Presenter> {

        void showLoginPage();

        void showMainPage();

    }

}
