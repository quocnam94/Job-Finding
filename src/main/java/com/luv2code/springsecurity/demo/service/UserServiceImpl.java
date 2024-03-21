package com.luv2code.springsecurity.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springsecurity.demo.dao.UserDAO;
import com.luv2code.springsecurity.demo.entity.Users;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
		
	@Override
	@Transactional
	public void saveUser(Users theUser) {
		userDAO.saveUser(theUser);
	}

	@Override
	@Transactional
	public Users getUser(int userId) {
		return userDAO.getUser(userId);	}

	@Override
	@Transactional
	public int getUserIdByEmail(String email) {
		return userDAO.getUserIdByEmail(email);
	}

	@Override
	@Transactional
	public int getTotalUser() {
		return userDAO.getTotalUser();
	}

	@Override
	@Transactional
	public List<Users> getUsers(List<Integer> theUserIds) {
		return userDAO.getUsers(theUserIds);
	}

}
