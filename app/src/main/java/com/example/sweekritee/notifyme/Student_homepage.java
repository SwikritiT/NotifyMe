package com.example.sweekritee.notifyme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class Student_homepage extends AppCompatActivity {
    Toolbar toolbar_std;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_homepage);
        toolbar_std=(Toolbar) findViewById(R.id.toolbar_ad);
        setSupportActionBar(toolbar_std);
        getSupportActionBar().setIcon(getDrawable(R.drawable.menu_ad));
    }
}
