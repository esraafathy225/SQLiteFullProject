package com.example.win7sp1.sqlitefullproject;

/**
 * Created by WIN7SP1 on 01/09/2018.
 */

public class Contact {
    private String mname;
    private String mphone;
    private  int mid;

    public Contact(String name,String phone){
        mname=name;
        mphone=phone;

    }
    public Contact(int id,String name,String phone){
        mname=name;
        mphone=phone;
        mid=id;

    }

    public String getName(){
        return mname;
    }
    public String getPhone(){
        return mphone;
    }


    public int getId() {
        return mid;
    }
}

