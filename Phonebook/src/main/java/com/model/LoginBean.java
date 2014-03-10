package com.model;


public class LoginBean {
	
	private int id;
    private String name;
    private String password;
      
    public LoginBean() {
	}
	public String getName() {
		return name;
	}
	public void setName(final String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(final String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
