package com.example.xiangmu1.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.xiangmu1.R;
import com.example.xiangmu1.frist.adapter.FristBannerAdapter;
import com.example.xiangmu1.frist.adapter.FristChanAdapter;
import com.example.xiangmu1.frist.bean.FristBean;
import com.example.xiangmu1.frist.controct.FristControct;
import com.example.xiangmu1.frist.presenter.FristPresenter;

import java.util.ArrayList;

import retrofit2.Retrofit;


public class FristFragment extends Fragment implements FristControct.getBannerView {

    private View inflate;
    private LinearLayout fristll;
    private RecyclerView frist_rlv;
    private ArrayList<FristBean.DataBean.BannerBean> bannerBeans;
    private FristBannerAdapter fristBannerAdapter;
    private ArrayList<FristBean.DataBean.ChannelBean> channelBeans;
    private FristChanAdapter fristChanAdapter;
    private DelegateAdapter adapter;
    private LinearLayoutHelper linearLayoutHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_frist, container, false);
        initView();
        initData();
        return inflate;
    }

    private void initView() {
        fristll = inflate.findViewById(R.id.frist_ll);
        frist_rlv = inflate.findViewById(R.id.frist_rlv);

        VirtualLayoutManager layoutManager = new VirtualLayoutManager(getActivity());
        // 创建VirtualLayoutManager对象
        // 同时内部会创建一个LayoutHelperFinder对象，用来后续的LayoutHelper查找

        frist_rlv.setLayoutManager(layoutManager);
        // 将VirtualLayoutManager绑定到recyclerView

        // 设置组件复用回收池
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        frist_rlv.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 10);

        //bannner
        initBanner();
        //chan
        initChan();
        //brand
//        initBrand();


        adapter = new DelegateAdapter(layoutManager);
        adapter.addAdapter(fristBannerAdapter);
        adapter.addAdapter(fristChanAdapter);

        frist_rlv.setAdapter(adapter);

    }

    private void initBrand() {
        /**
         设置Grid布局
         */
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(3);
        // 在构造函数设置每行的网格个数

        // 公共属性
        gridLayoutHelper.setItemCount(6);// 设置布局里Item个数
        gridLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        gridLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        gridLayoutHelper.setBgColor(Color.GRAY);// 设置背景颜色
        gridLayoutHelper.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的比

        // gridLayoutHelper特有属性（下面会详细说明）
        gridLayoutHelper.setWeights(new float[]{50,50});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper.setVGap(20);// 控制子元素之间的垂直间距
        gridLayoutHelper.setHGap(20);// 控制子元素之间的水平间距
        gridLayoutHelper.setAutoExpand(false);//是否自动填充空白区域
        gridLayoutHelper.setSpanCount(2);// 设置每行多少个网格
    }

    private void initChan() {
        /**
         * chan
         设置栏格布局
         */
        ColumnLayoutHelper columnLayoutHelper = new ColumnLayoutHelper();
        // 创建对象

        // 公共属性
        columnLayoutHelper.setItemCount(5);// 设置布局里Item个数
        columnLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        columnLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
//        columnLayoutHelper.setBgColor(Color.GRAY);// 设置背景颜色
//        columnLayoutHelper.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的比

        // columnLayoutHelper特有属性
        columnLayoutHelper.setWeights(new float[]{20, 20, 20,20,20});// 设置该行每个Item占该行总宽度的比例
        // 同上面Weigths属性讲解
        channelBeans = new ArrayList<>();
        fristChanAdapter = new FristChanAdapter(getActivity(), channelBeans, columnLayoutHelper);
    }

    private void initBanner() {
        //bannner
        linearLayoutHelper = new LinearLayoutHelper();
        // 所有布局的公共属性（属性会在下面详细说明）

        linearLayoutHelper.setItemCount(1);// 设置布局里Item个数
        linearLayoutHelper.setPadding(10,10,10,10);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
//        linearLayoutHelper.setMargin(10,10,10,10);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
//        linearLayoutHelper.setBgColor(Color.GRAY);// 设置背景颜色
        linearLayoutHelper.setAspectRatio(2);// 设置设置布局内每行布局的宽与高的比

        // linearLayoutHelper特有属性
//        linearLayoutHelper.setDividerHeight(1); // 设置每行Item的距离

        bannerBeans = new ArrayList<>();
        fristBannerAdapter = new FristBannerAdapter(getActivity(), bannerBeans, linearLayoutHelper);
    }


    private void initData() {
        FristPresenter fristPresenter = new FristPresenter(this);
        fristPresenter.getBanner();
    }

    @Override
    public void onNext(FristBean fristBean) {
        Log.e("tag",fristBean.toString());

        bannerBeans.addAll(fristBean.getData().getBanner());
        fristBannerAdapter.notifyDataSetChanged();

        channelBeans.addAll(fristBean.getData().getChannel());
        fristChanAdapter.notifyDataSetChanged();

        adapter.notifyDataSetChanged();

    }

    @Override
    public void onFail(String err) {
        Log.e("tag",err);
    }
}