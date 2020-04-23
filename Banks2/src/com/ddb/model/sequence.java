package com.ddb.model;

public class sequence {

    //ord±í
    private String sequence;
    private String sequenced;


    public sequence()
    {
        sequence = null;
        sequenced = null;

    }

    public void setSequence(String sequence)
    {
        this.sequence = sequence;
    }
    public String getSequence()
    {
        return this.sequence;

    }
    public void setSequenced(String sequenced)
    {
        this.sequenced = sequenced;
    }
    public String getSequenced()
    {
        return this.sequenced;
    }
}