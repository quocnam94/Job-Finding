package com.luv2code.springsecurity.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springsecurity.demo.dao.FollowCompanyDAO;
import com.luv2code.springsecurity.demo.entity.FollowCompany;

@Service
public class FollowCompanyServiceImpl implements FollowCompanyService {
	
	@Autowired
	FollowCompanyDAO followCompanyDAO;

	@Override
	@Transactional
	public void saveFollowCompany(FollowCompany followCompany) {
		followCompanyDAO.saveFollowCompany(followCompany);
	}

	@Override
	@Transactional
	public boolean isFollowCompany(int companyId, int userId) {
		return followCompanyDAO.isFollowCompany(companyId, userId);
	}

	@Override
	@Transactional
	public void unFollowCompany(FollowCompany followCompany) {
		followCompanyDAO.unFollowCompany(followCompany);
	}

}
