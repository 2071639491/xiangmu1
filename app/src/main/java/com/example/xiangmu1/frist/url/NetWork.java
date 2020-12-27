package com.example.xiangmu1.frist.url;

public interface NetWork {
    <T> void get(String url, HttpCallBack<T> callBack);
}

