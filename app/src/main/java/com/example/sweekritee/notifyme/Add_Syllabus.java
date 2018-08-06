package com.example.sweekritee.notifyme;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Add_Syllabus extends AppCompatActivity {
    private FloatingActionButton goback;
    private Button upload_syllabus,choose_syllabus;
    private EditText syllabusname;
    private ImageView syllabusView;
    private final int IMG_REQUEST=1;
    private String encoded_string;
    private Bitmap bitmap;
    private String reg_url = "http://192.168.1.12/notifyme/addsyllabus.php";

    private Uri file_uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_syllabus);
        upload_syllabus=(Button) findViewById(R.id.upload_syllabus);
        choose_syllabus=(Button) findViewById(R.id.choose_syllabus);
        syllabusname=(EditText) findViewById(R.id.syllabus_name);
        syllabusView=(ImageView) findViewById(R.id.syllabus_view);

        goback= (FloatingActionButton) findViewById(R.id.FAB_addsyllabus);
        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Add_Syllabus.this,Admin_Homepage.class);
                startActivity(intent);
            }
        });
        choose_syllabus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImage();

            }
        });
        upload_syllabus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadImage();

            }
        });
    }
    private void selectImage(){
        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,IMG_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==IMG_REQUEST && resultCode==RESULT_OK && data!=null){
            file_uri=data.getData();
            try {
                bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),file_uri);
                syllabusView.setImageBitmap(bitmap);
                syllabusView.setVisibility(View.VISIBLE);
                syllabusname.setVisibility(View.VISIBLE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void uploadImage(){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, reg_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            String success = jsonObject.getString("flag");
                            if (success.equals("1")) {
                                Toast.makeText(Add_Syllabus.this, "Added successfully", Toast.LENGTH_SHORT).show();
                                syllabusView.setImageResource(0);
                                syllabusView.setVisibility(View.GONE);
                                syllabusname.setText("");
                                syllabusname.setVisibility(View.GONE);

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(Add_Syllabus.this, "Failed"+e.toString(), Toast.LENGTH_SHORT).show();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Add_Syllabus.this, "Failed"+error.toString(), Toast.LENGTH_SHORT).show();

            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> map = new HashMap<>();
                map.put("encoded_string",imageToString(bitmap));
                map.put("syllabus_name",syllabusname.getText().toString().trim());


                return map;
            }
        };
        MySingleton.getInstance(Add_Syllabus.this).addToRequestQueue(stringRequest);
    }



    private String imageToString(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream= new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        byte[] imgBytes = byteArrayOutputStream.toByteArray();
        encoded_string = Base64.encodeToString(imgBytes, Base64.DEFAULT);
        return  encoded_string;

    }

}
