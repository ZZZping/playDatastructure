package com.ddb.model;

public class Service {
	private String sid;
	private String sname;
	
	public Service()
	{
		sid = null;
		sname = null;
	}
	
	public void setSid(String sid)
	{
		this.sid = sid;
	}
	public String getSid()
	{
		return this.sid;
	}
	public void setSname(String sname)
	{
		this.sname = sname;
	}
	public String getSname()
	{
		return this.sname;
	}
	
}
