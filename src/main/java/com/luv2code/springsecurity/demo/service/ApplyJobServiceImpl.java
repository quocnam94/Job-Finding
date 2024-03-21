package com.luv2code.springsecurity.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springsecurity.demo.dao.ApplyJobDAO;
import com.luv2code.springsecurity.demo.entity.ApplyJob;

@Service
public class ApplyJobServiceImpl implements ApplyJobService {
	
	@Autowired
	private ApplyJobDAO applyJobDAO;

	@Override
	@Transactional
	public void saveApplyJob(ApplyJob theApplyJob) {
		applyJobDAO.saveApplyJob(theApplyJob);
	}

	@Override
	@Transactional
	public List<Integer> getUserIds(List<Integer> theRecruitmentIds) {
		return applyJobDAO.getUserIds(theRecruitmentIds);
	}

	@Override
	@Transactional
	public List<Integer> getTheRecruitmentIdsInApplyJob(List<Integer> theUserIds) {
		return applyJobDAO.getTheRecruitmentIdsInApplyJob(theUserIds);
	}

	@Override
	@Transactional
	public List<ApplyJob> getApplyJobsByRecruitmentId(List<Integer> theRecruitmentIds) {
		return applyJobDAO.getApplyJobsByRecruitmentId(theRecruitmentIds);
	}

	@Override
	@Transactional
	public List<ApplyJob> getApplyJob(int recruitmentId) {
		return applyJobDAO.getApplyJob(recruitmentId);
	}

	@Override
	@Transactional
	public boolean isApplyJob(int recruitmentId, int userId) {
		return applyJobDAO.isApplyJob(recruitmentId, userId);
	}

}
