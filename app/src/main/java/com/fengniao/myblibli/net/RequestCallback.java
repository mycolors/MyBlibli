package com.fengniao.myblibli.net;


public interface RequestCallback<T> {


    void onRequestSuccess(T t);

    void onRequestError(Exception e, String msg);
}
