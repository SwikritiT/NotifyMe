package com.example.sweekritee.notifyme;

import static com.example.sweekritee.notifyme.APICreator.BASE_URL;

/**
 * Created by SWEEKRITEE on 8/9/2018.
 */

public class SyllabusItem {
    private String name,image_path;


    public SyllabusItem(String name,String image_path){

        this.name=name;
        this.image_path=image_path;

    }


    public String getName() {
        return name;
    }

    public String getImage() {
        return BASE_URL+image_path;

    }
}
