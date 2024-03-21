package com.luv2code.springsecurity.demo.dao;

import org.springframework.stereotype.Repository;

import com.luv2code.springsecurity.demo.entity.FollowCompany;

@Repository
public interface FollowCompanyDAO {
	
	public void saveFollowCompany(FollowCompany followCompany);

	public boolean isFollowCompany(int companyId, int userId);

	public void unFollowCompany(FollowCompany followCompany);

}
