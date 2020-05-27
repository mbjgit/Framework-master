package com.meng.demo.mvp.component;

import com.meng.demo.mvp.MVPActivity;
import com.meng.demo.mvp.MVPDagger2Activity;
import com.meng.demo.mvp.module.MVPDagger2Module;

import dagger.Component;

@Component(modules = {MVPDagger2Module.class})
public interface MVPDagger2Component {
    void inject(MVPDagger2Activity mvpDagger2Activity);
}
