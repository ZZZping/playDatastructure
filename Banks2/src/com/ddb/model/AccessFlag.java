package com.ddb.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class AccessFlag {

    private HashMap<String,Integer> flag ;

    public AccessFlag(){
        flag = new HashMap<String,Integer>();
    }

    public HashMap<String,Integer> getFlag(){
        return this.flag;
    }

    public int getSum(){
        int sum = 0;
        Collection<Integer> values = flag.values();
        for(Iterator<Integer> iterator=values.iterator(); iterator.hasNext();){
            Integer it = iterator.next();
            sum = sum + it.intValue();
        }
        return sum;
    }
}
