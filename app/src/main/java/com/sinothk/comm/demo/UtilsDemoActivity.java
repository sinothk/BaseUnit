package com.sinothk.comm.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sinothk.comm.utils.DateUtil;
import com.sinothk.comm.utils.ToastUtil;

import java.util.Date;

public class UtilsDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utils_demo);

        ToastUtil.init(this);

        int age = DateUtil.getAge(DateUtil.getDateByDateStr("1988-12-18", "yyyy-MM-dd"));

        ToastUtil.show("age = " + age);
    }
}
