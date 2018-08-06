package com.example.sweekritee.notifyme;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Add_Event extends AppCompatActivity {
    private FloatingActionButton goback;
    private Button add_event;
    private EditText name, desc, type, location, date;
    String reg_url = "http://192.168.1.12/notifyme/addevent.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_event);
        goback = (FloatingActionButton) findViewById(R.id.FAB_addevents);
        name = (EditText) findViewById(R.id.eventname);
        desc = (EditText) findViewById(R.id.eventdesc);
        type = (EditText) findViewById(R.id.eventtype);
        location = (EditText) findViewById(R.id.eventlocation);
        date = (EditText) findViewById(R.id.eventdate);
        add_event = (Button) findViewById(R.id.eventdescadd_btn);
        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Add_Event.this, Admin_Homepage.class);
                startActivity(intent);
            }
        });
        add_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String event_name = name.getText().toString();
                String event_desc = desc.getText().toString();
                String event_type = type.getText().toString();
                String event_location = location.getText().toString();
                String event_date = date.getText().toString();
                AddEventFunction(event_name, event_desc, event_type, event_location, event_date);
            }
        });


    }

    public void AddEventFunction(final String event_name, final String event_desc,
                                 final String event_type, final String event_location, final String event_date) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, reg_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("flag");
//                            JSONObject myObj=new JSONObject(success);
                            if (success.equals("1")) {
                                Toast.makeText(Add_Event.this, " successfully added", Toast.LENGTH_SHORT).show();
                                //Intent intent = new Intent(Add_Event.this,Student_homepage.class);
                                // startActivity(intent);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(Add_Event.this, "failure in adding" + e.toString(), Toast.LENGTH_SHORT).show();
                        }


                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Add_Event.this, "failure in adding" + error.toString(), Toast.LENGTH_SHORT).show();

                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("name", event_name);
                params.put("type", event_type);
                params.put("description", event_desc);
                params.put("location", event_location);
                params.put("date", event_date);

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
}
