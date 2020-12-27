package com.example.xiangmu1.frist.url;

public interface HttpCallBack<T> {
    void OnNext(T t);
    void OnFail(String err);
}

