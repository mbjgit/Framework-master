package com.meng.demo.mvp.presenter;

import android.content.Context;

import com.meng.demo.mvp.IView.IBaseView;

public abstract class IMVPPresenter extends BasePresentImp {

    public IMVPPresenter(IBaseView iBaseView, Context context) {
        super(iBaseView, context);
    }

    public abstract void showMVP();
}
