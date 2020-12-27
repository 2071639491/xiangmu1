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
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.xiangmu1.R;
import com.example.xiangmu1.frist.bean.FristBean;

import java.util.ArrayList;

public class FristBrandCkAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private ArrayList<FristBean.DataBean.BrandListBean> list;
    private GridLayoutHelper gridLayoutHelper;

    public FristBrandCkAdapter(Context context, ArrayList<FristBean.DataBean.BrandListBean> list, GridLayoutHelper gridLayoutHelper) {
        this.context = context;
        this.list = list;
        this.gridLayoutHelper = gridLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.brandck_item, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1= (ViewHolder) holder;
        holder1.tv.setText(list.get(position).getName());
        holder1.tv1.setText(list.get(position).getFloor_price()+"");
        Glide.with(context).load(list.get(position).getNew_pic_url()).into(holder1.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView img;
        private final TextView tv;
        private final TextView tv1;

        public ViewHolder(View inflate) {
            super(inflate);
            img = inflate.findViewById(R.id.brandck_img);
            tv = inflate.findViewById(R.id.brank_tv1);
            tv1 = inflate.findViewById(R.id.brank_tv2);
        }
    }
}
