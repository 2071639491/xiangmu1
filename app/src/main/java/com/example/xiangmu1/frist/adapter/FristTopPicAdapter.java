package com.example.xiangmu1.frist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.xiangmu1.R;
import com.example.xiangmu1.frist.bean.FristBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class FristTopPicAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private ArrayList<FristBean.DataBean.TopicListBean> mBanner;
    private LinearLayoutHelper linearLayoutHelper;

    public FristTopPicAdapter(Context context, ArrayList<FristBean.DataBean.TopicListBean> mBanner, LinearLayoutHelper linearLayoutHelper) {
        this.context = context;
        this.mBanner = mBanner;
        this.linearLayoutHelper = linearLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.toppic_item, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1= (ViewHolder) holder;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        holder1.rlv.setLayoutManager(linearLayoutManager);
        FristTopPicZeroAdapter fristTopPicZeroAdapter = new FristTopPicZeroAdapter(context, mBanner);
        holder1.rlv.setAdapter(fristTopPicZeroAdapter);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        private final RecyclerView rlv;

        public ViewHolder(View inflate) {
            super(inflate);
            rlv = inflate.findViewById(R.id.pictop_rlv);
        }
    }
}
