package com.luv2code.springsecurity.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.luv2code.springsecurity.demo.entity.Users;

@Service
public interface UserService {
	
	public void saveUser (Users theUser);
	
	public Users getUser(int userId);
	
	public int getUserIdByEmail(String email);
	
	public int getTotalUser();
	
	public List<Users> getUsers(List<Integer> theUserIds);

}
