package com.example.xiangmu1.frist.controct;

import com.example.xiangmu1.frist.bean.FristBean;
import com.example.xiangmu1.frist.url.HttpCallBack;

public class FristControct {
    public interface getBannerView{
        void onNext(FristBean fristBean);
        void onFail(String err);
    }

    public interface getBannerPresenter{
        void getBanner();
    }

    public interface getBannerModel{
        <T> void getBannerModel(String url, HttpCallBack<T> callBack);
    }
}
