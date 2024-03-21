package com.luv2code.springsecurity.demo.service;

import org.springframework.stereotype.Service;

@Service
public interface CVService {
	
	public String getNameCVByUserId(int userId);
	
	public boolean isExistCV(int userId);
}
