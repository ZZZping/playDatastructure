package com.model;

public class isSorted {
    less less = new less();
    public static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length; i ++) {
            if (com.model.less.less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }
}
