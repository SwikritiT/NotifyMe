package com.example.sweekritee.notifyme;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

import static com.example.sweekritee.notifyme.APICreator.BASE_URL;

/**
 * Created by SWEEKRITEE on 7/14/2018.
 */

public class ViewSyllabus extends AppCompatActivity {
    private FloatingActionButton goback;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<SyllabusItem> syllabusItems;
    private static String url=BASE_URL+"getsyllabus.php";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewsyllabus);
        syllabusItems= new ArrayList<>();
        goback= (FloatingActionButton) findViewById(R.id.FAB_viewsyllabus);
        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ViewSyllabus.this,Student_homepage.class);
                startActivity(intent);
            }
        });
        loadSyllabus();


    }
    private  void loadSyllabus()
    {
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("loading data");
        progressDialog.show();
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("response",response);
                progressDialog.dismiss();

                try {
                    int i=0;
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray jsonArray=jsonObject.getJSONArray("response_list");

                    while(i<jsonArray.length())
                    {

                        JSONObject object=jsonArray.getJSONObject(i);
                        String name=object.getString("subjectname");
                        String image_path=object.getString("syllabuspath");

                        SyllabusItem item=new SyllabusItem(name,image_path);
                        syllabusItems.add(item);

                        i++;
                    }

                    recyclerView =(RecyclerView) findViewById(R.id.syllabus_recycler);
                    recyclerView.setLayoutManager(new LinearLayoutManager(ViewSyllabus.this));
                    recyclerView.setHasFixedSize(true);

                    adapter= new Adapter_syllabus(syllabusItems,ViewSyllabus.this);
                    recyclerView.setAdapter(adapter);

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
