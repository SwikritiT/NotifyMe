package com.example.sweekritee.notifyme;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SWEEKRITEE on 8/7/2018.
 */

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    List<StudentModel> studentModelList=new ArrayList<>();
    private Context context;
    @Override
    public StudentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.custom_listview,parent,false);



        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StudentAdapter.ViewHolder holder, int position) {
            holder.name.setText(studentModelList.get(position).getName());
            holder.date.setText(studentModelList.get(position).getDate());
            holder.desc.setText(studentModelList.get(position).getDescription());
            holder.type.setText(studentModelList.get(position).getType());
            holder.location.setText(studentModelList.get(position).getLocation());
    }

    @Override
    public int getItemCount() {
        return studentModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name,type,location,date,desc;
        public ViewHolder(View itemView) {
            super(itemView);
            name= (TextView) itemView.findViewById(R.id.name);
            type=(TextView)  itemView.findViewById(R.id.type);
            location=(TextView)  itemView.findViewById(R.id.location);
            date=(TextView)  itemView.findViewById(R.id.date);
            desc=(TextView)  itemView.findViewById(R.id.desc);

        }
    }
    public StudentAdapter(List<StudentModel> studentModelList,Context context){
        this.studentModelList=studentModelList;
        this.context=context;
    }
}
