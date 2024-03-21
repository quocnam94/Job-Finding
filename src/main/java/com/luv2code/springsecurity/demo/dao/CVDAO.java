package com.luv2code.springsecurity.demo.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface CVDAO {
	
	public String getNameCVByUserId(int userId);

	public boolean isExistCV(int userId);
}
