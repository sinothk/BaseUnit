package com.sinothk.comm.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CommMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gotoScreenMatchDemoActivity(View view) {
        startActivity(new Intent(this, ScreenMatchDemoActivity.class));
    }

    public void gotoUtilsDemoActivity(View view) {
        startActivity(new Intent(this, UtilsDemoActivity.class));
    }

}
