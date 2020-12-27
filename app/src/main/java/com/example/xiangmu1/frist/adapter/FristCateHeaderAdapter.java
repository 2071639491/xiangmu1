package com.example.xiangmu1.frist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.xiangmu1.R;
import com.example.xiangmu1.frist.bean.FristBean;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class FristCateHeaderAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private String listBeans;
    private LinearLayoutHelper linearLayoutHelper;


    public FristCateHeaderAdapter(Context context, String listBeans, LinearLayoutHelper linearLayoutHelper) {
        this.context = context;
        this.listBeans = listBeans;
        this.linearLayoutHelper = linearLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.cateheader_item, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        holder1.tv.setText(listBeans);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv;

        public ViewHolder(View inflate) {
            super(inflate);
            tv = inflate.findViewById(R.id.cate_tv);
        }
    }
}
