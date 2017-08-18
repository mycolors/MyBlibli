package com.fengniao.myblibli.net.retrofit;


import com.fengniao.myblibli.net.HttpResult;
import com.fengniao.myblibli.util.UIUtils;

import java.net.SocketException;
import java.util.concurrent.TimeoutException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class BaseRequestObserver<T> implements Observer<HttpResult<T>> {
    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(HttpResult<T> value) {
        if (value.isSuccess()) {
            T t = value.getData();
            onHandleSuccess(t);
        } else {
            onHandleError(value.getMsg());
        }

    }


    @Override
    public void onError(Throwable e) {
        if (e instanceof SocketException) {
            onHandleError("网络异常");
        } else if (e instanceof TimeoutException) {
            onHandleError("请求超时");
        } else {
            onHandleError("请求失败");
        }
    }

    @Override
    public void onComplete() {

    }

    protected abstract void onHandleSuccess(T t);

    protected void onHandleError(String msg) {
        UIUtils.showToast(msg);
    }


}
