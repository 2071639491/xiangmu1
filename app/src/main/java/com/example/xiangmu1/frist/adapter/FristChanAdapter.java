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
import com.bumptech.glide.Glide;
import com.example.xiangmu1.R;
import com.example.xiangmu1.frist.bean.FristBean;

import java.util.ArrayList;

public class FristChanAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private ArrayList<FristBean.DataBean.ChannelBean> list;
    private ColumnLayoutHelper columnLayoutHelper;

    public FristChanAdapter(Context context, ArrayList<FristBean.DataBean.ChannelBean> list, ColumnLayoutHelper columnLayoutHelper) {
        this.context = context;
        this.list = list;
        this.columnLayoutHelper = columnLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return columnLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.chan_item, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1= (ViewHolder) holder;
        holder1.tv.setText(list.get(position).getName());
        Glide.with(context).load(list.get(position).getIcon_url()).into(holder1.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView img;
        private final TextView tv;

        public ViewHolder(View inflate) {
            super(inflate);
            img = inflate.findViewById(R.id.chan_item_img);
            tv = inflate.findViewById(R.id.chan_item_tv);
        }
    }
}
