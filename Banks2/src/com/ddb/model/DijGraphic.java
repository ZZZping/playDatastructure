package com.ddb.model;

import java.util.HashMap;

public class DijGraphic {
    private String name;
    private HashMap<String ,Node> allNode;

    public DijGraphic(){
        name = null;
        allNode = new HashMap<String, Node>();
    }

    public void setName(String name){
        this.name = name;
    }

    public HashMap<String, Node> getAllNode(){
        return this.allNode;
    }
    public String getName(){
        return this.name;
    }
}

