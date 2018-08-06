package com.example.sweekritee.notifyme;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
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

import static android.R.attr.name;

public class SignUpStd extends AppCompatActivity {

    private EditText uname,pass;
    private Button signup;
    String reg_url = "http://192.168.1.12/notifyme/signup.php";
    String name, pword ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signupstd);
        //progressBar = new ProgressBar(this);
        uname = (EditText) findViewById(R.id.username_std);
        pass = (EditText) findViewById(R.id.pass_std);
        signup = (Button) findViewById(R.id.signup_std);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = uname.getText().toString().trim();

                pword = pass.getText().toString().trim();
                if (name.equals("") || pword.equals("")) {
                    Toast.makeText(SignUpStd.this, "Fill up th field properly", Toast.LENGTH_SHORT).show();

                }
                else {

                    // If EditText is not empty and CheckEditText = True then this block will execute.

                    UserRegisterFunction(name, pword);


                }

            }

        });
    }
    public void UserRegisterFunction(final String name,  final String pword){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, reg_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject= new JSONObject(response);
                            String success =jsonObject.getString("flag");
//                            JSONObject myObj=new JSONObject(success);
                            if (success.equals("1")){
                                Toast.makeText(SignUpStd.this, "Registration successful", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(SignUpStd.this,Student_homepage.class);
                                startActivity(intent);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(SignUpStd.this,"Register failed"+e.toString(),Toast.LENGTH_SHORT).show();
                        }


                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(SignUpStd.this,"Register Failed"+error.toString(),Toast.LENGTH_SHORT).show();

                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
                params.put("username",name);
                params.put("password",pword);

                return params;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }
}





