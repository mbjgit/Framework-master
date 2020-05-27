package com.meng.demo.mvp.presenter;

import android.content.Context;

import com.meng.demo.mvp.IView.IBaseView;
import com.meng.demo.mvp.IView.IMVPView;

public class MVPPresenterImp extends IMVPPresenter{

    public MVPPresenterImp(IBaseView iBaseView, Context context) {
        super(iBaseView, context);
    }

    @Override
    public void showMVP() {
        getV().onToastView();
    }

    @Override
    public IMVPView getV() {
        return (IMVPView) super.getV();
    }
}
