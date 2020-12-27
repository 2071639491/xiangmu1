package com.example.xiangmu1.frist.presenter;

import com.example.xiangmu1.fragments.FristFragment;
import com.example.xiangmu1.frist.bean.FristBean;
import com.example.xiangmu1.frist.controct.FristControct;
import com.example.xiangmu1.frist.model.FristModel;
import com.example.xiangmu1.frist.url.HttpCallBack;
import com.example.xiangmu1.frist.url.UrlUtil;

public class FristPresenter implements FristControct.getBannerPresenter {
    private final FristModel fristModel;
    private FristFragment homeFragment;


    public FristPresenter(FristFragment homeFragment) {
        this.homeFragment = homeFragment;
        fristModel = new FristModel();
    }


    @Override
    public void getBanner() {
        fristModel.getBannerModel(UrlUtil.BANNER, new HttpCallBack<FristBean>() {
            @Override
            public void OnNext(FristBean fristBean) {
                homeFragment.onNext(fristBean);
            }

            @Override
            public void OnFail(String err) {
                homeFragment.onFail(err);
            }
        });
    }
}
