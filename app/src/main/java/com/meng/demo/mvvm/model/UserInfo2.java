package com.meng.demo.mvvm.model;

import android.view.View;
import android.widget.Toast;

import androidx.databinding.ObservableField;

public class UserInfo2 {
    public final ObservableField<String> firstName = new ObservableField<>();
    public final ObservableField<String> lastName = new ObservableField<>();
    public final ObservableField<Integer> age = new ObservableField<>();

    public void onChange(View view){
        Toast.makeText(view.getContext(), toString(),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public String toString() {
        return "UserInfo2{" +
                "firstName=" + firstName.get() +
                ", lastName=" + lastName.get() +
                ", age=" + age.get() +
                '}';
    }
}
