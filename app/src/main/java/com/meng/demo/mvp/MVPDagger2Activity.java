package com.meng.demo.mvp;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import com.meng.demo.R;
import com.meng.demo.mvp.IView.IBaseView;
import com.meng.demo.mvp.IView.IMVPView;
import com.meng.demo.mvp.adapter.MVPAdapter;
import com.meng.demo.mvp.component.DaggerMVPDagger2Component;
import com.meng.demo.mvp.module.MVPDagger2Module;
import com.meng.demo.mvp.presenter.IMVPPresenter;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class MVPDagger2Activity extends AppCompatActivity implements IMVPView {
    @Inject
    IMVPPresenter imvpPresenter;
    @Inject
    MVPAdapter mvpAdapter;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp_dagger2);
        DaggerMVPDagger2Component.builder().
                mVPDagger2Module(new MVPDagger2Module(this,this)).
                build().
                inject(this);
        findViewById(R.id.text_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imvpPresenter.showMVP();
            }
        });
        recyclerView=findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(
                this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(mvpAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        imvpPresenter.detachView();
    }

    @Override
    public void onToastView() {
        Toast.makeText(MVPDagger2Activity.this,"Hello Dagger2",Toast.LENGTH_SHORT).show();
    }
}
