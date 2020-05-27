package com.meng.demo.mvp;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.meng.demo.R;
import com.meng.demo.mvp.IView.IBaseView;
import com.meng.demo.mvp.IView.IMVPView;
import com.meng.demo.mvp.presenter.IMVPPresenter;
import com.meng.demo.mvp.presenter.MVPPresenterImp;

public class MVPActivity extends BaseMVPActivity implements IMVPView {
    private IMVPPresenter imvpPresenter;

    @Override
    public IMVPPresenter initBasePresent() {
        imvpPresenter = new MVPPresenterImp(this,this);
        return imvpPresenter;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imvpPresenter.showMVP();
            }
        });
    }

    @Override
    public void onToastView() {
        Toast.makeText(MVPActivity.this,"C",Toast.LENGTH_SHORT).show();
    }
}
