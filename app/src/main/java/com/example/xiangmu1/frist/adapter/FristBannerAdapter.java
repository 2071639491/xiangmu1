package com.example.xiangmu1.frist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.xiangmu1.R;
import com.example.xiangmu1.frist.bean.FristBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class FristBannerAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private ArrayList<FristBean.DataBean.BannerBean> mBanner;
    private LinearLayoutHelper linearLayoutHelper;

    public FristBannerAdapter(Context context, ArrayList<FristBean.DataBean.BannerBean> mBanner, LinearLayoutHelper linearLayoutHelper) {
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
        View inflate = LayoutInflater.from(context).inflate(R.layout.frist_banner, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1= (ViewHolder) holder;
        holder1.banner.setImages(mBanner).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                FristBean.DataBean.BannerBean pp= (FristBean.DataBean.BannerBean) path;
                Glide.with(context).load(pp.getImage_url()).into(imageView);
            }
        }).start();
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        private final Banner banner;

        public ViewHolder(View inflate) {
            super(inflate);
            banner = inflate.findViewById(R.id.banner);
        }
    }
}
