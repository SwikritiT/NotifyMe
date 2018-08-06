package com.example.sweekritee.notifyme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

import static com.example.sweekritee.notifyme.R.id.username_login;


public class Login extends AppCompatActivity {
    Button loginbtn;
    String a;
    TextView textView1, textView2;
    EditText user, pass;
    String reg_url = "http://192.168.1.12/notifyme/login.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        loginbtn = (Button) findViewById(R.id.login);
        user = (EditText) findViewById(username_login);
        pass = (EditText) findViewById(R.id.password_login);


        textView1 = (TextView) findViewById(R.id.extratext);
        textView2=(TextView) findViewById(R.id.register);
        final int f = Integer.parseInt(getIntent().getExtras().getString("extratext"));
        //final int flag2 = Integer.parseInt(getIntent().getExtras().getString("extratext2"));
        if(f == 1)
            textView1.setText(R.string.fadmin);
        else if(f == 0 )
        {
        textView1.setText(R.string.fstudents);
        textView2.setText(R.string.noAccount);
        }

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String username = user.getText().toString();
                String password = pass.getText().toString();

                if (username.equals("") || password.equals("")) {
                    Toast.makeText(getBaseContext(), "Fill up all the field properly", Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                {
                    UserLoginFunction(username, password,f);



                }






            }
        });

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Intent intent= new Intent(Login.this,SignUpStd.class);
                startActivity(intent);
            }

        });


    }
    public void UserLoginFunction(final String username,  final String password, final int f){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, reg_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject= new JSONObject(response);
                            String success =jsonObject.getString("flag");
//                            JSONObject myObj=new JSONObject(success);
                            if (success.equals("1")){
                                if (f == 0) {
                                    Log.d("test",">>>>1"+textView1.getText());
                                    Toast.makeText(Login.this,"Login Successful",Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(Login.this, Student_homepage.class);
                                    startActivity(intent);
                                }
                                else if (f == 1){
                                    Log.d("test",">>>>2"+textView1.getText());
                                    Toast.makeText(Login.this,"Login Successful",Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(Login.this, Admin_Homepage.class);
                                    startActivity(intent);
                                }

                            }
                            else
                            {
                                Toast.makeText(Login.this,"Enter correct username or password",Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(Login.this,"Login failed"+e.toString(),Toast.LENGTH_SHORT).show();
                        }


                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Login.this,"Login Failed"+error.toString(),Toast.LENGTH_SHORT).show();

                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
                params.put("username",username);
                params.put("password",password);

                return params;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }
}













