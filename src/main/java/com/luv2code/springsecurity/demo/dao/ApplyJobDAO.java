package com.luv2code.springsecurity.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.luv2code.springsecurity.demo.entity.ApplyJob;

@Repository
public interface ApplyJobDAO {
	
	public void saveApplyJob(ApplyJob theApplyJob);

	public List<Integer> getUserIds(List<Integer> theRecruitmentIds);

	public List<Integer> getTheRecruitmentIdsInApplyJob(List<Integer> theUserIds);

	public List<ApplyJob> getApplyJobsByRecruitmentId(List<Integer> theRecruitmentIds);

	public List<ApplyJob> getApplyJob(int recruitmentId);

	public boolean isApplyJob(int recruitmentId, int userId);

}
