package com.example.sweekritee.notifyme;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by SWEEKRITEE on 8/9/2018.
 */

public class Adapter_syllabus extends RecyclerView.Adapter <Adapter_syllabus.ViewHolder> {
    List<SyllabusItem> syllabusItems;
    private Activity context;

    public Adapter_syllabus(List<SyllabusItem> syllabusItems, Activity contextt) {
        this.syllabusItems = syllabusItems;
        this.context = contextt;
    }

    @Override
    public Adapter_syllabus.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.syllabus_item,parent,false);
        return new Adapter_syllabus.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(Adapter_syllabus.ViewHolder holder, int position) {
        SyllabusItem syllabusItem= syllabusItems.get(position);
        holder.name.setText(syllabusItem.getName());
        //ImageView imgage_path=(ImageView) itemView.findViewById(R.id.rout_image);
        Picasso.with(context).load(syllabusItem.getImage()).into(holder.imageView);

    }


    @Override
    public int getItemCount() {
        return syllabusItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            name=(TextView) itemView.findViewById(R.id.subject_name);
            imageView=(ImageView) itemView.findViewById(R.id.syllab_image);
        }
    }
}
