package com.meng.demo.mvp.presenter;

import android.content.Context;

import com.meng.demo.mvp.IView.IBaseView;

import java.lang.ref.WeakReference;

public class BasePresentImp<V extends IBaseView> implements IBasePresenter<V> {
    private WeakReference<V> weakReference;
    private WeakReference<Context> contextWeakReference;

    public BasePresentImp(V v,Context context) {
        weakReference=new WeakReference<>(v);
        contextWeakReference=new WeakReference<>(context);
    }

    @Override
    public void detachView() {
        if(isAttachView()){
            weakReference.clear();
        }

    }

    @Override
    public boolean isAttachView() {
        return weakReference!=null && weakReference.get()!=null;
    }

    public V getV(){
        return weakReference.get();
    }

    public Context getContext(){
        return contextWeakReference.get();
    }
}
