package com.example.xiangmu1.apiservice;

import com.example.xiangmu1.frist.bean.FristBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface apiservice {
    String banner="https://cdwan.cn/";
    @GET("api/index")
    Observable<FristBean> getBanner();
}
