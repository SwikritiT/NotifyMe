package com.example.sweekritee.notifyme;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class Student_homepage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar_std;
    private DrawerLayout drawerLayoutstd;
    private ActionBarDrawerToggle stdToggle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_homepage);
        toolbar_std=(Toolbar) findViewById(R.id.toolbar_ad);
        NavigationView navigationView_std=( NavigationView) findViewById(R.id.nav_std);
        navigationView_std.setNavigationItemSelectedListener(Student_homepage.this);
        setSupportActionBar(toolbar_std);
        //getSupportActionBar().setIcon(getDrawable(R.drawable.menu_ad));
        drawerLayoutstd=(DrawerLayout) findViewById(R.id.drawerlayout_std);
        stdToggle=new ActionBarDrawerToggle(Student_homepage.this,drawerLayoutstd,toolbar_std,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayoutstd.addDrawerListener(stdToggle);
        stdToggle.syncState();

        if(savedInstanceState==null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_std, new ViewEvent()).commit();
            navigationView_std.setCheckedItem(R.id.viewevents);
        }




    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.viewevents:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_std , new ViewEvent()).commit();
                break;

            case R.id.viewroutine:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_std , new ViewRoutine()).commit();
                break;
            case R.id.viewsyllabus:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_std , new ViewSyllabus()).commit();
                break;

            case R.id.aboutus:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_std , new Aboutus()).commit();
                break;


        }
        drawerLayoutstd.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayoutstd.isDrawerOpen(GravityCompat.START)){
            drawerLayoutstd.closeDrawer(GravityCompat.START);

        }
        else{
        super.onBackPressed();}
    }


}
