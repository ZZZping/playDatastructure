package com.ddb.model;

public class Order {

	private String order;
	private String ordered;
	
	
	public Order()
	{
		order = null;
		ordered = null;
		
	}
	
	public void setOrder(String order)
	{
		this.order = order;
	}
	public String getOrder()
	{
		return this.order;
		
	}
	public void setOrdered(String ordered)
	{
		this.ordered = ordered;
	}
	public String getOrdered()
	{
		return this.ordered;
	}
}
