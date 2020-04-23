package com.ddb.model;

public class NodePosition {

    private String left ;
    private String right;
    private int x ;
    private int y ;

    public NodePosition(){
        left = null;
        right= null;
        x = 0 ;
        y = 0 ;
    }
    public void setLeft(String left){
        this.left = left ;
    }
    public String getLeft(){
        return this.left;
    }
    public void setRight(String right){
        this.right = right;
    }
    public String getRight(){
        return this.right;
    }
    public void setX(int x){
        this.x = x ;
    }
    public int getX(){
        return this.x ;
    }
    public void setY(int y){
        this.y = y ;
    }
    public int getY(){
        return this.y ;
    }
}
