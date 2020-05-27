package com.meng.demo.mvp.module;

import android.content.Context;

import com.meng.demo.mvp.IView.IMVPView;
import com.meng.demo.mvp.adapter.MVPAdapter;
import com.meng.demo.mvp.model.MVPUserInfo;
import com.meng.demo.mvp.presenter.IMVPPresenter;
import com.meng.demo.mvp.presenter.MVPPresenterImp;
import com.meng.demo.mvvm.model.UserInfo2;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

@Module
public class MVPDagger2Module {
    private IMVPView v;
    private Context context;

    public MVPDagger2Module(IMVPView v, Context context) {
        this.v = v;
        this.context = context;
    }

    @Provides
    IMVPPresenter providerPresenter() {
        return new MVPPresenterImp(v,context);
    }

    private List<MVPUserInfo> getTestUserInfo2List(){
        List<MVPUserInfo> mvpUserInfoList=new ArrayList<>();
        for(int i=0;i<20;i++){
            MVPUserInfo mvpUserInfo=new MVPUserInfo("Micheal ".concat(String.valueOf(i)),
                    "Jack ".concat(String.valueOf(i)),i);
            mvpUserInfoList.add(mvpUserInfo);
        }
        return mvpUserInfoList;
    }

    @Provides
    MVPAdapter providerMVPAdapter(){
        return new MVPAdapter(getTestUserInfo2List(),context);
    }

}
