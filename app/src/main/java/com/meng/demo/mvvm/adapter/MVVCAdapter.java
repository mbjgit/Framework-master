package com.meng.demo.mvvm.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.meng.demo.R;
import com.meng.demo.databinding.ItemMvvcLayoutBinding;
import com.meng.demo.mvvm.model.UserInfo2;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class MVVCAdapter extends RecyclerView.Adapter<MVVCAdapter.MVVCHolder> {
    private List<UserInfo2> userInfo2List=new ArrayList<>();
    private Context context;
    private OnItemClickListener mOnItemClickListener;


    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public MVVCAdapter(List<UserInfo2> userInfo2List, Context context) {
        this.userInfo2List = userInfo2List;
        this.context = context;
    }

    @NonNull
    @Override
    public MVVCHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMvvcLayoutBinding itemMvvcLayoutBinding= DataBindingUtil.inflate(
                LayoutInflater.from(context), R.layout.item_mvvc_layout,parent,false);
        return  new MVVCHolder(itemMvvcLayoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MVVCHolder holder,final int position) {
        final ItemMvvcLayoutBinding itemMvvcLayoutBinding=holder.getItemMvvcLayoutBinding();
        itemMvvcLayoutBinding.setUser2(userInfo2List.get(position));
        itemMvvcLayoutBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return userInfo2List.size();
    }


    static class  MVVCHolder extends RecyclerView.ViewHolder{
        private ItemMvvcLayoutBinding itemMvvcLayoutBinding;
        public MVVCHolder(ItemMvvcLayoutBinding itemMvvcLayoutBinding) {
            super(itemMvvcLayoutBinding.getRoot());
            this.itemMvvcLayoutBinding = itemMvvcLayoutBinding;
        }

        public ItemMvvcLayoutBinding getItemMvvcLayoutBinding() {
            return itemMvvcLayoutBinding;
        }

    }
}
