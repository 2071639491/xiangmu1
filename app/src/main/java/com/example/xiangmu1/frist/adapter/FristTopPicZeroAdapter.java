package com.example.xiangmu1.frist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.xiangmu1.R;
import com.example.xiangmu1.frist.bean.FristBean;

import java.util.ArrayList;

public class FristTopPicZeroAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<FristBean.DataBean.TopicListBean> list;

    public FristTopPicZeroAdapter(Context context, ArrayList<FristBean.DataBean.TopicListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.toppiczero_item, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        holder1.tv1.setText(list.get(position).getTitle());
        holder1.tv2.setText(list.get(position).getSubtitle());
        Glide.with(context).load(list.get(position).getScene_pic_url()).into(holder1.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView img;
        private final TextView tv1;
        private final TextView tv2;

        public ViewHolder(View inflate) {
            super(inflate);
            img = inflate.findViewById(R.id.toppic_img);
            tv1 = inflate.findViewById(R.id.toppic_tv1);
            tv2 = inflate.findViewById(R.id.toppic_tv2);
        }
    }
}
