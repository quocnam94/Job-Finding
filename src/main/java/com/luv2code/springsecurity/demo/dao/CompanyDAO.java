package com.luv2code.springsecurity.demo.dao;

import java.util.List;
import java.util.Map;

import com.luv2code.springsecurity.demo.entity.Company;

public interface CompanyDAO {

	public Company getCompany(int userId);

	public void saveCompany(Company theCompany);

	public String getNameCompanyByUserId(int userId);

	public int getTotalCompany();

	public List<Company> search(String theSearch);

	public List<Map<String, Object>> topCompany();

	public Company getCompanyByCompanyId(int companyId);

	public int getIdCompanyByUserId(int userId);

	public List<Company> getCompanyFollowed(int userId);

}
