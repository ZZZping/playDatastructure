	package com.ddb.model;

	public class User {
		private String uid;
		private String name;
		
		public User()
		{
			uid = null;
			name = null;
		}
		
		public void setUid(String uid)
		{
			this.uid = uid;
		}
		
		public String getUid()
		{
			return this.uid;
		}
		
		public void setName(String name)
		{
			this.name = name;
		}
		
		public String getName()
		{
			return this.name;
		}
	}

