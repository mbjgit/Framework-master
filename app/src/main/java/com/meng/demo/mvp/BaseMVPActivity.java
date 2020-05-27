package com.meng.demo.mvp;

import android.os.Bundle;

import com.meng.demo.mvp.IView.IBaseView;
import com.meng.demo.mvp.presenter.BasePresentImp;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseMVPActivity<P extends BasePresentImp<IBaseView>>
        extends AppCompatActivity {
    private P basePresent;
    public abstract P initBasePresent();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        basePresent=initBasePresent();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        basePresent.detachView();
    }
}
