package com.example.sweekritee.notifyme;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Add_Syllabus extends AppCompatActivity {
    private FloatingActionButton goback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_syllabus);
        goback= (FloatingActionButton) findViewById(R.id.FAB_addsyllabus);
        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Add_Syllabus.this,Admin_Homepage.class);
                startActivity(intent);
            }
        });
    }
}
