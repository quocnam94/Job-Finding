package com.luv2code.springsecurity.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.luv2code.springsecurity.demo.entity.ApplyJob;

@Service
public interface ApplyJobService {
	
	public void saveApplyJob(ApplyJob theApplyJob);

	public List<Integer> getUserIds(List<Integer> theRecruitmentIds);

	public List<Integer> getTheRecruitmentIdsInApplyJob(List<Integer> theUserIds);

	public List<ApplyJob> getApplyJobsByRecruitmentId(List<Integer> theRecruitmentIds);

	public List<ApplyJob> getApplyJob(int recruitmentId);

	public boolean isApplyJob(int recruitmentId, int userId);

}
