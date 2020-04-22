package com.ddb.steiner;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ddb.model.User;
import com.ddb.model.Order;
import com.ddb.model.Service;
import com.ddb.model.Serviceuser;

public class BuildTree {
	
	public ArrayList<User> authorList;
	public ArrayList<Service> paperList;
	public ArrayList<Order> citeList;
	public ArrayList<Serviceuser> paperauthorList;
	Connection con;
	connection cn;
	ResultSet rt;
	String sql ;

	public BuildTree(String ur,String pw)
	{
		authorList = new ArrayList<User>();
		paperList = new ArrayList<Service>();
		citeList = new ArrayList<Order>();
		paperauthorList = new ArrayList<Serviceuser>();
		cn = new connection();
		con = cn.getConnection(ur,pw);
		sql = null;
		setQuote();
	}
	
	public void setQuote()
	{
		rt = null;
		sql = "SET sql_mode='ANSI_QUOTES';";
		if(con!=null)
			cn.getResultSet(sql);
		else
			return ;
	}
	
  
	public ArrayList<User> getAuthorList()
    {
    	rt = null;
    	sql = "select * from author;";
 
    	if(con==null)
    		return null;
    	try{
    	rt = cn.getResultSet(sql);
    	while (rt.next()) {
    		
    		User ar = new User();
    		
    		ar.setUid(rt.getString("aid"));
    		ar.setName(rt.getString("name"));
    		authorList.add(ar);
    	}
    	}catch(Exception e){
    		System.out.println(e);
    	}
    	
    	return authorList;
    }
    
	public ArrayList<Service> getPaperList() throws SQLException
    {
    	rt = null;
    	sql = "select * from paper;";
    	if(con==null)
    		return null;
    	rt = cn.getResultSet(sql);
    	while (rt.next()) {
    		
    		Service pr = new Service();
    		pr.setSid(rt.getString("pid"));
    		pr.setSname(rt.getString("title"));
    		paperList.add(pr);
    		
//    		System.out.println(rt.getString("pid") + ":"
//    				+ rt.getString("title"));
    	}
    	
    	return paperList;
    }
	
	public ArrayList<Serviceuser> getPaperAuthorList() throws SQLException
    {
    	rt = null;
    	sql = "select * from \"paper-author\"";
    	if(con==null)
    		return null;
    	rt = cn.getResultSet(sql);
    	while (rt.next()) {
    		
    		Serviceuser pa = new Serviceuser();
    		pa.setUid(rt.getString("aid"));
    		pa.setSid(rt.getString("pid"));
    		paperauthorList.add(pa);
    		
//    		System.out.println(rt.getString("pid") + ":"
//    				+ rt.getString("aid"));
    	}
    
    	return paperauthorList;
    }
	
	public ArrayList<Order> getCiteList() throws SQLException
    {
    	rt = null;
    	sql = "select * from citation;";
    	if(con==null)
    		return null;
    	rt = cn.getResultSet(sql);
    	while (rt.next()) {
    		
    		Order ce = new Order();
    		ce.setOrder(rt.getString("cite"));
    		ce.setOrdered(rt.getString("cited"));
    		citeList.add(ce);
    		
//    		System.out.println(rt.getString("cite") + ":"
//    				+ rt.getString("cited"));
    	}
    	
    	return citeList;
    }
    
}
