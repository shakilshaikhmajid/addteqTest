package com.addteq.restdemo.component;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.stereotype.Component;

@Component
public class MyDBConnection {
	private String url;
	private String username;
	private String password;
	private String driver;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public MyDBConnection(String driver,String url, String username, String password) {
		super();
		this.url = url;
		this.username = username;
		this.password = password;
		this.driver = driver;
	}
	public MyDBConnection() {
		super();
	}
	public Connection getConnection() throws Exception
	{
			Class.forName(driver);
			Connection cn=DriverManager.getConnection(url,username,password);
			return cn;
	}
	
}
