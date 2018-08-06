package com.example.sweekritee.notifyme;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class NavigationBarAdmin extends AppCompatActivity {
    private DrawerLayout drawerLayoutadm;
    private ActionBarDrawerToggle admToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigationbaradmin);
        drawerLayoutadm=(DrawerLayout) findViewById(R.id.drawerlayout_ad);
        admToggle=new ActionBarDrawerToggle(NavigationBarAdmin.this,drawerLayoutadm,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayoutadm.addDrawerListener(admToggle);
        admToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (admToggle.onOptionsItemSelected(item)) {
            return true;

        }
        return super.onOptionsItemSelected(item);

    }
}

