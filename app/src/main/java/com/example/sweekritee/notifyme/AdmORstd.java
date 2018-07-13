package com.example.sweekritee.notifyme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdmORstd extends AppCompatActivity {
     private Button adminbtn,studentbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admorstd);
        adminbtn=(Button) findViewById(R.id.adminbtn);
        studentbtn=(Button) findViewById(R.id.studentbtn);
        adminbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginAd();
            }
        });
        studentbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginStd();
            }
        });


    }
    public void openLoginAd(){
        Intent intent1=new Intent(this,Login.class);
        intent1.putExtra("extratext","1");

        startActivity(intent1);

    }

    public void openLoginStd(){
        Intent intent2=new Intent(this,Login.class);
        intent2.putExtra("extratext","0");

        startActivity(intent2);

    }
}
