package com.addteq.restdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.addteq.restdemo.ReadUsersFromFile;
import com.addteq.restdemo.modal.UserNameRepositoryImpl;
import com.addteq.restdemo.modal.UserNames;

@RestController
public class MyController {

	@RequestMapping("test")
	public String test()
	{
		return("My Test OK");
	}
	
	public List<UserNames> getUsersFromFileMethod()
	{
		
		List<UserNames> allusers;
		ReadUsersFromFile readUsersFromFile=new ReadUsersFromFile();
		readUsersFromFile.setFileName("resources/usernames.txt");
		
		allusers=readUsersFromFile.getAllUsers();
		return allusers;
	}
	@GetMapping(value= "getusersfromfile")
	public List<UserNames> getusersfromfile()
	{
		
		List<UserNames> allusers=getUsersFromFileMethod();
		return allusers;
	}
	
	@GetMapping(value= "getUserNamesFromDB")
	public List<UserNames> getUserNamesFromDB()
	{
		System.out.println("Inside get from db");
		UserNameRepositoryImpl userrepo=new UserNameRepositoryImpl();
		List<UserNames> allusers=userrepo.getUserNamesFromDB();
		return allusers;
	}
	@GetMapping(value= "searchUserNamesFromDB/{name}")
	public List<UserNames> serahcUserNamesFromDB(@PathVariable("name")String name)
	{
		System.out.println("path valriable username="+name);
		UserNameRepositoryImpl userrepo=new UserNameRepositoryImpl();
		List<UserNames> allusers=userrepo.searchUserNamesFromDB(name);
		return allusers;
	}
	
	@GetMapping(value= "getusersfromfile/save")
	public String saveUsersToDB()
	{
		String msg;
		List<UserNames> allusers=getUsersFromFileMethod();
		UserNameRepositoryImpl userrepo=new UserNameRepositoryImpl();
		msg=userrepo.saveAllUsersInDB(allusers);
		return msg;
	}
	
}
