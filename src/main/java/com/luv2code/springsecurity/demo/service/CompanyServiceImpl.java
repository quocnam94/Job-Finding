package com.luv2code.springsecurity.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springsecurity.demo.dao.CompanyDAO;
import com.luv2code.springsecurity.demo.entity.Company;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyDAO companyDAO;

	@Override
	@Transactional
	public Company getCompany(int userId) {
		return companyDAO.getCompany(userId);
	}

	@Override
	@Transactional
	public void saveCompany(Company theCompany) {
		companyDAO.saveCompany(theCompany);
	}

	@Override
	@Transactional
	public String getNameCompanyByUserId(int userId) {
		return companyDAO.getNameCompanyByUserId(userId);
	}

	@Override
	@Transactional
	public int getTotalCompany() {
		return companyDAO.getTotalCompany();
	}

	@Override
	@Transactional
	public List<Company> search(String theSearch) {
		return companyDAO.search(theSearch);
	}

	@Override
	@Transactional
	public List<Map<String, Object>> topCompany() {
		return companyDAO.topCompany();
	}

	@Override
	@Transactional
	public Company getCompanyByCompanyId(int companyId) {
		return companyDAO.getCompanyByCompanyId(companyId);
	}

	@Override
	@Transactional
	public int getIdCompanyByUserId(int userId) {
		return companyDAO.getIdCompanyByUserId(userId);
	}

	@Override
	@Transactional
	public List<Company> getCompanyFollowed(int userId) {
		return companyDAO.getCompanyFollowed(userId);
	}

}
