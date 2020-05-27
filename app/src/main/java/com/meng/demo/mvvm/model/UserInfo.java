package com.meng.demo.mvvm.model;

import androidx.databinding.ObservableField;

public class UserInfo {
    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableField<String> password = new ObservableField<>();

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name.get() + '\'' +
                ", password='" + password.get() + '\'' +
                '}';
    }
}
