package com.example.sweekritee.notifyme;

import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Admin_Homepage extends AppCompatActivity {
    Toolbar toolbar1;
    Button addevent, addroutine, addsyllabus;
    private DrawerLayout drawerLayoutadm;
    private ActionBarDrawerToggle admToggle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_homepage);
        toolbar1=(Toolbar) findViewById(R.id.toolbar_ad);
        setSupportActionBar(toolbar1);
        drawerLayoutadm=(DrawerLayout) findViewById(R.id.drawerlayout_ad);
        admToggle=new ActionBarDrawerToggle(Admin_Homepage.this,drawerLayoutadm,toolbar1,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayoutadm.addDrawerListener(admToggle);
        admToggle.syncState();
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
    @Override
    public void onBackPressed() {
        if(drawerLayoutadm.isDrawerOpen(GravityCompat.START)){
            drawerLayoutadm.closeDrawer(GravityCompat.START);

        }
        else{
            super.onBackPressed();}
    }
    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (admToggle.onOptionsItemSelected(item)) {
            return true;

        }
        return super.onOptionsItemSelected(item);

    }*/
}
