package com.meng.demo.mvvm.handler;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.meng.demo.mvvm.model.UserInfo;

public class UserHandler {
    private UserInfo userInfo;
    public UserHandler() {
        userInfo=new UserInfo();
        userInfo.name.set("Hello ");
        userInfo.password.set(" MVVM");
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void onClickLogin(View view, UserInfo userInfo){
        TextView view1 = (TextView) view;
        userInfo.name.set("Hello onClickLogin");
        Toast.makeText(view.getContext(),view1.getText().toString()+" "+userInfo.toString(),Toast.LENGTH_SHORT).show();
    }
}
