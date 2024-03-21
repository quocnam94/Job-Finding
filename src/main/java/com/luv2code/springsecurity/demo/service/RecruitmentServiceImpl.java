package com.luv2code.springsecurity.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springsecurity.demo.dao.RecruitmentDAO;
import com.luv2code.springsecurity.demo.entity.Recruitment;
import org.springframework.data.domain.Page;

@Service
public class RecruitmentServiceImpl implements RecruitmentService {

	@Autowired
	private RecruitmentDAO recruitmentDAO;

	@Override
	@Transactional
	public void saveJob(Recruitment theRecruitment) {
		recruitmentDAO.saveJob(theRecruitment);
	}

	@Override
	@Transactional
	public List<Recruitment> getRecruitments(int userId) {
		return recruitmentDAO.getRecruitments(userId);
	}

	@Override
	@Transactional
	public Recruitment getRecruitment(int userId) {
		return recruitmentDAO.getRecruitment(userId);
	}

	@Override
	@Transactional
	public Recruitment getRecruitmentByRecruitmentId(int recruitmentId) {
		return recruitmentDAO.getRecruitmentByRecruitmentId(recruitmentId);
	}

	@Override
	@Transactional
	public void deleteJob(int recruitmentId) {
		recruitmentDAO.deleteJob(recruitmentId);
		
	}

	@Override
	@Transactional
	public int getTotalRecruitment() {
		return recruitmentDAO.getTotalRecruitment();
	}

	@Override
	@Transactional
	public List<Recruitment> search(String theSearch) {
		return recruitmentDAO.search(theSearch);
	}

	@Override
	@Transactional
	public List<Map<String, Object>> topCategory(){
		return recruitmentDAO.topCategory();
	}

	@Override
	@Transactional
	public List<Recruitment> topJob() {
		return recruitmentDAO.topJob();
	}

	@Override
	@Transactional
	public List<Integer> getRecruitmentIds(int userId) {
		return recruitmentDAO.getRecruitmentIds(userId);
	}

	@Override
	@Transactional
	public List<Recruitment> getRecruitmentsByIds(List<Integer> theRecruitmentIds) {
		return recruitmentDAO.getRecruitmentsByIds(theRecruitmentIds);
	}

	@Override
	@Transactional
	public List<Recruitment> getRecruitmentsByCompanyId(int companyId) {
		return recruitmentDAO.getRecruitmentsByCompanyId(companyId);
	}

	@Override
	@Transactional
	public List<Recruitment> getRecruitmentsFollowed(int userId) {
		return recruitmentDAO.getRecruitmentsFollowed(userId);
	}

	@Override
	@Transactional
	public Page<Recruitment> getRecruitments(int userId, int page, int i) {
		return recruitmentDAO.getRecruitments(userId, page,i);
	}

	@Override
	@Transactional
	public List<Recruitment> getRecruitmentsApplied(int userId) {
		return recruitmentDAO.getRecruitmentsApplied(userId);
	}

}
