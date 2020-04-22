package com.ddb.model;

public class Node {

	private String nodename;
	private int dist ;
	private String next ;
	private String belong ;
	private String pre ;
	
	public Node(){
		dist = 0;
		next = null;
		belong = null;
		pre = null ;
	}
	
	public void setBelong(String belong){
		this.belong = belong ;
	}
	
	public void setPre(String pre){
		this.pre = pre;
	}
	
	public String getPre(){
		return this.pre;
	}
	public String getBelong(){
		return this.belong ;
	}
	public Node(String name,int dist){
		this.nodename = name;
		this.dist = dist;
	}
	
	public void setNext(String next){
		this.next = next;
	}
	
	public String getNext(){
		return this.next;
	}
	
	public void setDist(int dist){
		this.dist = dist;
	}
	
	public void setNodename(String name){
		this.nodename = name;
	}
	
	public String getNodename(){
		return this.nodename;
	}
	
	public int getDist(){
		return this.dist;
	}
}
