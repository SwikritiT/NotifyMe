package com.example.sweekritee.notifyme;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class firstPage extends AppCompatActivity {
    private static final int SPLASH_TIME_OUT=3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstpage);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent= new Intent(firstPage.this,AdmORstd.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}
