package com.ddb.model;

public class Serviceuser {

    private String sid;
    private String uid;

    public Serviceuser(){

        sid = null;
        uid = null;

    }

    public void setSid(String sid){
        this.sid = sid;
    }

    public String getSid(){
        return this.sid;

    }

    public void setUid(String uid){
        this.uid = uid;
    }

    public String getUid(){
        return this.uid;
    }
}
