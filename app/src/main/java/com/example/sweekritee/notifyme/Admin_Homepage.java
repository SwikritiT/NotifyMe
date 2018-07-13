package com.example.sweekritee.notifyme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Admin_Homepage extends AppCompatActivity {
    Toolbar toolbar1;
    Button addevent, addroutine, addsyllabus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_homepage);
        toolbar1=(Toolbar) findViewById(R.id.toolbar_ad);
        setSupportActionBar(toolbar1);
        //getSupportActionBar().setIcon(getDrawable(R.drawable.menu_ad));
       // toolbar1.setTitle("NotifyMe");
        addevent=(Button) findViewById(R.id.addevent_btn);
        addroutine=(Button) findViewById(R.id.addroutine_btn);
        addsyllabus=(Button) findViewById(R.id.addsyllabus_btn);
        addevent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(Admin_Homepage.this,Add_Event.class);
                startActivity(intent1);


            }
        });
        addroutine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(Admin_Homepage.this,Add_Routine.class);
                startActivity(intent2);


            }
        });
        addsyllabus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent(Admin_Homepage.this,Add_Syllabus.class);
                startActivity(intent3);


            }
        });

}
}
