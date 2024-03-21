package com.luv2code.springsecurity.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springsecurity.demo.dao.FollowJobDAO;
import com.luv2code.springsecurity.demo.entity.FollowJob;

@Service
public class FollowJobServiceImpl implements FollowJobService {
	
	@Autowired
	FollowJobDAO followJobDAO;

	@Override
	@Transactional
	public void saveFollowJob(FollowJob followJob) {
		followJobDAO.saveFollowJob(followJob);
	}

	@Override
	@Transactional
	public boolean isFollowJob(int recruitmentId, int userId) {
		return followJobDAO.isFollowJob(recruitmentId, userId);
	}

	@Override
	@Transactional
	public void unFollowJob(FollowJob followJob) {
		followJobDAO.unFollowJob(followJob);
	}

	@Override
	@Transactional
	public List<FollowJob> getFollowJob(int userId) {
		return followJobDAO.getFollowJob(userId);
	}

}
