package com.example.xiangmu1.frist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
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

public class FristHotGoodAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private ArrayList<FristBean.DataBean.HotGoodsListBean> list;
    private LinearLayoutHelper linearLayoutHelper;

    public FristHotGoodAdapter(Context context, ArrayList<FristBean.DataBean.HotGoodsListBean> list, LinearLayoutHelper linearLayoutHelper) {
        this.context = context;
        this.list = list;
        this.linearLayoutHelper = linearLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return new SingleLayoutHelper();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.hotgood_item, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1= (ViewHolder) holder;
        holder1.tv1.setText(list.get(position).getName());
        holder1.tv2.setText(list.get(position).getGoods_brief());
        holder1.tv3.setText(list.get(position).getRetail_price()+"");
        Glide.with(context).load(list.get(position).getList_pic_url()).into(holder1.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder {


        private final ImageView img;
        private final TextView tv1;
        private final TextView tv2;
        private final TextView tv3;

        public ViewHolder(View inflate) {
            super(inflate);
            img = inflate.findViewById(R.id.hotgood_img);
            tv1 = inflate.findViewById(R.id.hotgood_tv1);
            tv2 = inflate.findViewById(R.id.hotgood_tv2);
            tv3 = inflate.findViewById(R.id.hotgood_tv3);
        }
    }
}
