package com.luv2code.springsecurity.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.luv2code.springsecurity.demo.entity.Users;

@Repository
public interface UserDAO {
	
	public void saveUser(Users theUser);

	public Users findByUserName(String userName);

	public Users getUser(int userId);

	public int getUserIdByEmail(String email);

	public int getTotalUser();

	public List<Users> getUsers(List<Integer> theUserIds);

}
