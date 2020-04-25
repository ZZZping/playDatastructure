package com.ddb.steiner;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ddb.model.User;
import com.ddb.model.sequence;
import com.ddb.model.Service;
import com.ddb.model.Serviceuser;

public class BuildTree {

    public ArrayList<User> userList;
    public ArrayList<Service> serviceList;
    public ArrayList<sequence> sequenceList;
    public ArrayList<Serviceuser> serviceuserList;
    Connection con;
    connection cn;
    ResultSet rt;
    String sql ;

    public BuildTree(String ur,String pw) {
        userList = new ArrayList<User>();
        serviceList = new ArrayList<Service>();
        sequenceList = new ArrayList<sequence>();
        serviceuserList = new ArrayList<Serviceuser>();
        cn = new connection();
        con = cn.getConnection(ur,pw);
        sql = null;
        setQuote();
    }

    public void setQuote() {
        rt = null;
        sql = "SET sql_mode='ANSI_QUOTES';";
        if(con!=null)
            cn.getResultSet(sql);
        else
            return ;
    }


    public ArrayList<User> getUserList() {
        rt = null;
        sql = "select * from user;";

        if(con==null)
            return null;
        try{
            rt = cn.getResultSet(sql);
            while (rt.next()) {

                User ar = new User();

                ar.setUid(rt.getString("uid"));
                ar.setName(rt.getString("name"));
                userList.add(ar);
            }
        }catch(Exception e){
            System.out.println(e);
        }

        return userList;
    }

    public ArrayList<Service> getServiceList() throws SQLException {
        rt = null;
        sql = "select * from service;";
        if(con==null)
            return null;
        rt = cn.getResultSet(sql);
        while (rt.next()) {

            Service pr = new Service();
            pr.setSid(rt.getString("sid"));
            pr.setSname(rt.getString("sname"));
            serviceList.add(pr);

        }

        return serviceList;
    }

    public ArrayList<Serviceuser> getServiceUserlist() throws SQLException {
        rt = null;
        sql = "select * from \"service-user\"";
        if(con==null)
            return null;
        rt = cn.getResultSet(sql);
        while (rt.next()) {

            Serviceuser pa = new Serviceuser();
            pa.setUid(rt.getString("sid"));
            pa.setSid(rt.getString("uid"));
            serviceuserList.add(pa);

        }

        return serviceuserList;
    }

    public ArrayList<sequence> getSequenceList() throws SQLException {
        rt = null;
        sql = "select * from sequence;";
        if(con==null)
            return null;
        rt = cn.getResultSet(sql);
        while (rt.next()) {

            sequence ce = new sequence();
            ce.setSequence(rt.getString("sequence"));
            ce.setSequenced(rt.getString("sequenced"));
            sequenceList.add(ce);

        }

        return sequenceList;
    }

}

