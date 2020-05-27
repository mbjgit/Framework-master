package com.meng.demo.mvp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.meng.demo.R;
import com.meng.demo.mvp.model.MVPUserInfo;
import com.meng.demo.mvvm.adapter.MVVCAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MVPAdapter extends RecyclerView.Adapter<MVPAdapter.MVPHolder> {
    private List<MVPUserInfo> mvpUserInfoList=new ArrayList<>();
    private Context context;
    private MVVCAdapter.OnItemClickListener mOnItemClickListener;


    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(MVVCAdapter.OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public MVPAdapter(List<MVPUserInfo> mvpUserInfoList, Context context) {
        this.mvpUserInfoList = mvpUserInfoList;
        this.context = context;
    }


    @NonNull
    @Override
    public MVPHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.item_mvp_layout,parent,false);
        return new MVPHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MVPHolder holder, int position) {
        final MVPUserInfo mvpUserInfo=mvpUserInfoList.get(position);
        holder.firstNameTv.setText(mvpUserInfo.getFirstName());
        holder.lastNameTv.setText(mvpUserInfo.getLastName());
        holder.ageTv.setText("age:".concat(String.valueOf(mvpUserInfo.getAge())));
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,mvpUserInfo.toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mvpUserInfoList.size();
    }


    static class  MVPHolder extends RecyclerView.ViewHolder{
        TextView firstNameTv;
        TextView lastNameTv;
        TextView ageTv;
        LinearLayout linearLayout;
        public MVPHolder(@NonNull View itemView) {
            super(itemView);
            linearLayout=itemView.findViewById(R.id.item_layout);
            firstNameTv=itemView.findViewById(R.id.first_name_tv);
            lastNameTv=itemView.findViewById(R.id.last_name_tv);
            ageTv=itemView.findViewById(R.id.age_tv);
        }
    }
}
