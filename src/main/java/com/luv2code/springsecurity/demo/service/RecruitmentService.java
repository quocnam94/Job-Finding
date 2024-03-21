package com.luv2code.springsecurity.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;

import com.luv2code.springsecurity.demo.entity.Recruitment;

@Service
public interface RecruitmentService {
		
	public void saveJob (Recruitment theRecruitment);

	public List<Recruitment> getRecruitments(int userId);

	public Recruitment getRecruitment(int userId);

	public Recruitment getRecruitmentByRecruitmentId(int recruitmentId);

	public void deleteJob(int recruitmentId);

	public int getTotalRecruitment();

	public List<Recruitment> search(String theSearch);

	public List<Map<String, Object>> topCategory();

	public List<Recruitment> topJob();

	public List<Integer> getRecruitmentIds(int userId);

	public List<Recruitment> getRecruitmentsByIds(List<Integer> theRecruitmentIds);

	public List<Recruitment> getRecruitmentsByCompanyId(int companyId);

	public List<Recruitment> getRecruitmentsFollowed(int userId);

	public Page<Recruitment> getRecruitments(int userId, int page, int i);

	public List<Recruitment> getRecruitmentsApplied(int userId);

}
