package com.example.sweekritee.notifyme;

/**
 * Created by SWEEKRITEE on 8/7/2018.
 */

public class StudentModel {

    private String name,description,type,location,date;


    public StudentModel(String name,String description,String type,String date,String location){

        this.name=name;
        this.description=description;
        this.type=type;
        this.location=location;
        this.date=date;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
