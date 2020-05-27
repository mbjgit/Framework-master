package com.meng.demo.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.meng.demo.R;


import com.meng.demo.databinding.ActivityMvvcBinding;
import com.meng.demo.mvvm.adapter.MVVCAdapter;
import com.meng.demo.mvvm.handler.UserHandler;
import com.meng.demo.mvvm.model.UserInfo2;

import java.util.ArrayList;
import java.util.List;

public class MVVMActivity extends AppCompatActivity {

    private ActivityMvvcBinding dataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding= DataBindingUtil.setContentView(this,R.layout.activity_mvvc);
        UserHandler userHandler=new UserHandler();
        //数据绑定
        dataBinding.setUserInfo(userHandler.getUserInfo());
        //事件绑定
        dataBinding.setUserInfoHandler(userHandler);
        dataBinding.setLifecycleOwner(this);
        dataBinding.recyclerView.setLayoutManager(new LinearLayoutManager(
                this,LinearLayoutManager.VERTICAL,false));
        dataBinding.recyclerView.setAdapter(new MVVCAdapter(getTestUserInfo2List(),this));
    }

    public List<UserInfo2> getTestUserInfo2List(){
        List<UserInfo2> userInfo2List=new ArrayList<>();
        for(int i=0;i<20;i++){
            UserInfo2 userInfo2=new UserInfo2();
            userInfo2.firstName.set("Micheal ".concat(String.valueOf(i)));
            userInfo2.lastName.set("Jack ".concat(String.valueOf(i)));
            userInfo2.age.set(i);
            userInfo2List.add(userInfo2);
        }
        return userInfo2List;
    }
}
