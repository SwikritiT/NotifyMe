package com.example.sweekritee.notifyme;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by SWEEKRITEE on 7/14/2018.
 */

public class ViewEvent extends Fragment {
//    private ListView listView;
//    private ArrayAdapter<String> adapter;
//    private InputStream inputStream;
//    String line=null;
//    String result=null;
//    String[] data;
//    private String reg_url = "http://192.168.1.12/notifyme/notificationListview.php";
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view= inflater.inflate(R.layout.viewevent,container,false);
//        listView= (ListView) view.findViewById(R.id.eventlist);
//        return view;
//    }
//    private void getData() {
//        try {
//            URL url=new URL(reg_url);
//            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
//            httpURLConnection.setRequestMethod("GET");
//            inputStream=new BufferedInputStream(httpURLConnection.getInputStream());
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//            StringBuilder stringBuilder= new StringBuilder();
//            while((line=bufferedReader.readLine())!=null){
//                stringBuilder.append(line+"\n");
//
//            }
//            inputStream.close();
//            result=stringBuilder.toString();
//
//
//
//
//        }
//       catch (Exception e){
//           e.printStackTrace();
//
//       }
//        try {
//            JSONArray jsonArray=new JSONArray(result);
//            JSONObject jsonObject=null;
//            data= new String[jsonArray.length()];
//            for (int i=0;i<jsonArray.length();i++){
//                jsonObject=jsonArray.getJSONObject(i);
//                data[i]=jsonObject.getString("name");
//
//            }
//        }
//        catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
    }

