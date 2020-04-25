package com.ddb.steiner;

import java.util.ArrayList;
import java.util.HashMap;

import com.ddb.model.DijGraphic;
import com.ddb.model.Node;

public class FindBase {

    //关键词keyword
    ArrayList<Node> kw ;
    DijGraphic dij;
    HashMap<String,DijGraphic> dinfo ;

    public FindBase(){
        this.kw = new ArrayList<Node>();
        this.dij = null;
        this.dinfo = null;
    }

    public void add(Node nd){
        kw.add(nd);
    }
    public void setDij(DijGraphic dij){
        this.dij = dij;
    }

    public void setDinfo(HashMap<String,DijGraphic> dinfo){
        this.dinfo = dinfo;
    }

    public void sort(){

        Node n = kw.get(0);


        int Nodedist = -1;
        Node next = null ;

        int i = 0;

        if( n.getNext() == null){  //如果最小节点的下一个节点为null，直接删掉该节点 返回
            kw.remove(0);
            return ;
        }else{
            String belong = n.getBelong();
            String nextNode = n.getNext();
            Nodedist = dinfo.get(belong).getAllNode().get(nextNode).getDist();
            next = dinfo.get(belong).getAllNode().get(nextNode);
        }

        if(kw.size() == 1) {
            kw.remove(0);
            kw.add(next);
            return ;
        }

        for(i = 1 ;i < kw.size() ; i++){
            Node ce = kw.get(i);
            if( Nodedist > dinfo.get(ce.getBelong()).getAllNode().get(ce.getNodename()).getDist()){
                continue ;
            }else{
                break;
            }
        }
        Node temp = next;      //交换位置
        kw.set(0, kw.get(i-1));
        kw.set(i-1, temp);
    }

    public Node getMin(){

        Node rt = null;

        if(kw.size() == 0){
            rt = null;
            return rt ;
        }else{
            rt = kw.get(0);
        }

        sort();

        return rt ;
    }



}