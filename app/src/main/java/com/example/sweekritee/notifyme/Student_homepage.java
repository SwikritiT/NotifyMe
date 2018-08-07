package com.example.sweekritee.notifyme;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Student_homepage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar_std;
    private DrawerLayout drawerLayoutstd;
    private List<StudentModel> studentModelList;
    private ActionBarDrawerToggle stdToggle;
    private FragmentTransaction fragmentTransaction;
    private NavigationView navigationView_std;
    private static String url="http://192.168.137.1/notifyme/notificationListview.php";
    RecyclerView recyclerView;

    StudentAdapter studentAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_homepage);
        toolbar_std=(Toolbar) findViewById(R.id.toolbar_ad);
        navigationView_std=( NavigationView) findViewById(R.id.nav_std);
        navigationView_std.setNavigationItemSelectedListener(Student_homepage.this);

        recyclerView= (RecyclerView) findViewById(R.id.eventlist);
        setSupportActionBar(toolbar_std);
        //getSupportActionBar().setIcon(getDrawable(R.drawable.menu_ad));
        drawerLayoutstd=(DrawerLayout) findViewById(R.id.drawerlayout_std);
        stdToggle=new ActionBarDrawerToggle(Student_homepage.this,drawerLayoutstd,toolbar_std,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayoutstd.addDrawerListener(stdToggle);
        stdToggle.syncState();
//        fragmentTransaction=getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.add(R.id.fragment_container_std, new ViewEvent());
//        fragmentTransaction.commit();
        studentModelList=new ArrayList<>();

        studentAdapter=new StudentAdapter(studentModelList,getApplicationContext());
        loadData();


        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(studentAdapter);


       /* if(savedInstanceState==null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_std, new ViewEvent()).commit();
            navigationView_std.setCheckedItem(R.id.viewevents);
        }*/




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

    public void loadData(){

        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("response",response.toString());

                try {
                    int i=0;
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray jsonArray=jsonObject.getJSONArray("response_list");

                    while(i<jsonArray.length()){

                        JSONObject jsonObject1=jsonArray.getJSONObject(i);
                        String name=jsonObject1.getString("name");
                        String desc=jsonObject1.getString("description");
                        String type=jsonObject1.getString("type");
                        String location=jsonObject1.getString("location");
                        String date=jsonObject1.getString("date");

                        StudentModel studentModel=new StudentModel(name,desc,type,date,location);
                        studentModelList.add(studentModel);


                        i++;
                    }
                    //studentAdapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
    }

}
