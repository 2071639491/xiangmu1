package com.example.xiangmu1.frist.model;

import com.example.xiangmu1.frist.controct.FristControct;
import com.example.xiangmu1.frist.url.HttpCallBack;
import com.example.xiangmu1.frist.url.RetrotUtil;

public class FristModel implements FristControct.getBannerModel {
    @Override
    public <T> void getBannerModel(String url, HttpCallBack<T> callBack) {
        RetrotUtil.getInstance().get(url,callBack);
    }
}
