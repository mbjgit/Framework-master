package com.meng.demo.mvp.presenter;

import android.content.Context;

import com.meng.demo.mvp.IView.IBaseView;

public interface IBasePresenter<V extends IBaseView>{
    void detachView();
    boolean isAttachView();
}
