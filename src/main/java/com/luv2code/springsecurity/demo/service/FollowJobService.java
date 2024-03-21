package com.luv2code.springsecurity.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.luv2code.springsecurity.demo.entity.FollowJob;

@Service
public interface FollowJobService {
	
	public void saveFollowJob(FollowJob followJob) ;

	public boolean isFollowJob(int recruitmentId, int userId);

	public void unFollowJob(FollowJob followJob);

	public List<FollowJob> getFollowJob(int userId);
}
