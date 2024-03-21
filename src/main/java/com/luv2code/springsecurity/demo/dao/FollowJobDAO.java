package com.luv2code.springsecurity.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.luv2code.springsecurity.demo.entity.FollowJob;

@Repository
public interface FollowJobDAO {
	
	public void saveFollowJob(FollowJob followJob);

	public boolean isFollowJob(int recruitmentId, int userId);

	public void unFollowJob(FollowJob followJob);

	public List<FollowJob> getFollowJob(int userId);

}
