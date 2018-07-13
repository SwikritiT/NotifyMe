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

import static com.example.sweekritee.notifyme.R.id.username_login;


public class Login extends AppCompatActivity {
    Button loginbtn;
    String a;
    TextView textView1;
    EditText user, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        loginbtn = (Button) findViewById(R.id.login);
        user = (EditText) findViewById(username_login);
        pass = (EditText) findViewById(R.id.password_login);


        textView1 = (TextView) findViewById(R.id.extratext);
        final int flag = Integer.parseInt(getIntent().getExtras().getString("extratext"));
        if(flag == 1)
            textView1.setText("For Admin");
        else if(flag == 0)
        textView1.setText("For Students");

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String username = user.getText().toString();
                String password = pass.getText().toString();
                if (username.length() >5 || password.length() > 5) {
                    if (flag == 0) {
                        Log.d("test",">>>>1"+textView1.getText());
                        Intent intent = new Intent(Login.this, Student_homepage.class);
                        startActivity(intent);
                    }
                    else if (flag == 1){
                        Log.d("test",">>>>2"+textView1.getText());
                        Intent intent = new Intent(Login.this, Admin_Homepage.class);
                        startActivity(intent);
                    }


                }
                else if (username.equals("") || password.equals("")) {
                    Toast.makeText(getBaseContext(), "Fill up all the field properly", Toast.LENGTH_SHORT).show();
                }




            }
        });

    }

        }



