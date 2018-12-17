package com.example.mahdi.unitenniangrocery;

/**
 * Created by mahdi on 9/6/2016.
 */
public class Record {

    private int id;
    private String name;
    private String phone_no;
    private String address;


    public Record () {
    }

    public Record(int id, String name, String phone_no, String address){

        this.id = id;
        this.name = name;
        this.phone_no = phone_no;
        this.address = address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName (String name){
        this.name = name;
    }

    public void setPhone_no (String phone_no){
        this.phone_no = phone_no;
    }

    public void setAddress (String address){
        this.address = address;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getPhone_no(){
        return phone_no;
    }

    public String getAddress(){
        return address;
    }
}
