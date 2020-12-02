package com.zzzping.SymbleTable;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Main {

    public static void main(String[] args) {
        ST<String, Integer> stringIntegerST;
        stringIntegerST = new ST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i ++) {
            String key = StdIn.readString();
            stringIntegerST.put(key, i);
        }

        for (String s : stringIntegerST) {
            StdOut.print(s + " " + stringIntegerST.get(s));
        }
    }
}
