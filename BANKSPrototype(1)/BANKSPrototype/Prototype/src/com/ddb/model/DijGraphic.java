package com.ddb.model;

import java.util.HashMap;

public class DijGraphic {
	private String name;
//	private String minNode;
//	private int minLen;
	private HashMap<String ,Node> allNode;
	
	public DijGraphic(){
		name = null;
//		minNode = null;
//		minLen = 0;
		allNode = new HashMap<String, Node>();
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public HashMap<String, Node> getAllNode(){
		return this.allNode;
	}
	public String getName(){
		return this.name;
	}
//	public void setMinNode(String node){
//		this.minNode = node;
//	}
//	public void setMinLen(int len){
//		this.minLen = len;
//	}

//	public String getMinNode(){
//		return this.minNode;
//	}
//	public int getMinLen(){
//		return this.minLen;
//	}
}
