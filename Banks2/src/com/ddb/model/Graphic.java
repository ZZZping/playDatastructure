package com.ddb.model;

import java.util.ArrayList;

public class Graphic {
    private String name;

    ArrayList<Node> adj ;

    public Graphic(){
        this.name = null;
        this.adj = new ArrayList<Node>();
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAdj(ArrayList<Node> al){
        this.adj = al;
    }

    public String getName(){
        return this.name;
    }

    public ArrayList<Node> getAdj(){
        return this.adj;
    }

}