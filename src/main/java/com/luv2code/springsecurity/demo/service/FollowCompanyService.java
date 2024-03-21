package com.luv2code.springsecurity.demo.service;

import org.springframework.stereotype.Service;

import com.luv2code.springsecurity.demo.entity.FollowCompany;

@Service
public interface FollowCompanyService {
	
	public void saveFollowCompany(FollowCompany followCompany) ;

	public boolean isFollowCompany(int companyId, int userId);

	public void unFollowCompany(FollowCompany followCompany);
}
