package com.luv2code.springsecurity.demo.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springsecurity.demo.entity.Company;

@Repository
public class CompanyDAOImpl implements CompanyDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Company getCompany(int userId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Company> theQuery = currentSession.createQuery("from Company c where c.userId=:userId", Company.class);
	    theQuery.setParameter("userId", userId);
	    List<Company> results = theQuery.getResultList();
	    Company theCompany = null;
	    if (!results.isEmpty()) {
	        theCompany = results.get(0);
	    }
	    else {
			theCompany = null;
		}
	    return theCompany;
	}

	@Override
	public void saveCompany(Company theCompany) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theCompany);
	}

	@Override
	public String getNameCompanyByUserId(int userId) {
	    Session currentSession = sessionFactory.getCurrentSession();
	    Query<String> theQuery = currentSession.createQuery("select c.nameCompany from Company c where c.userId=:userId", String.class);
	    theQuery.setParameter("userId", userId);
	    String theNameCompany = null;
	    try {
	        theNameCompany = theQuery.getSingleResult();
	    } catch (NoResultException e) {
	        theNameCompany = null;
	    }
	    return theNameCompany;
	}

	@Override
	public int getTotalCompany() {
		Session currentSession = sessionFactory.getCurrentSession();
		Long  count = (Long ) currentSession.createQuery("SELECT COUNT(DISTINCT userId) FROM Company").getSingleResult();
        return count.intValue(); 
	}

	@Override
	public List<Company> search(String theSearch) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Company> theQuery = null;
		if (theSearch != null && theSearch.trim().length() > 0) {
			theQuery=currentSession.createQuery("from Company where lower(nameCompany) like:theSearch",Company.class);
			theQuery.setParameter("theSearch", "%" + theSearch.toLowerCase() + "%");
		}
		else {
			theQuery = currentSession.createQuery("from Company", Company.class);
		}
		List<Company> theCompanies = theQuery.getResultList();
		return theCompanies;

	}

	@Override
	public List<Map<String, Object>> topCompany() {
	    Session currentSession = sessionFactory.getCurrentSession();
	    String queryString = "SELECT c.id, c.nameCompany, COUNT(r.userId) FROM Company c " +
	                        "LEFT JOIN Recruitment r ON c.userId = r.userId " +
	                        "GROUP BY c.id, c.nameCompany " +
	                        "ORDER BY COUNT(r.userId) DESC";
	    Query<Object[]> theQuery = currentSession.createQuery(queryString, Object[].class);
	    theQuery.setMaxResults(3);
	    List<Object[]> resultList = theQuery.getResultList();
	    List<Map<String, Object>> companyDataList = new ArrayList<>();
	    for (Object[] result : resultList) {
	        int id = (int) result[0];
	        String nameCompany = (String) result[1];
	        Long count = (Long) result[2];
	        Map<String, Object> entry = new HashMap<>();
	        entry.put("id", id);
	        entry.put("nameCompany", nameCompany);
	        entry.put("count", count);
	        companyDataList.add(entry);
	    }
	    return companyDataList;
	}

	@Override
	public Company getCompanyByCompanyId(int companyId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Company> theQuery = currentSession.createQuery("from Company c where c.id=:companyId", Company.class);
	    theQuery.setParameter("companyId", companyId);
	    List<Company> results = theQuery.getResultList();
	    Company theCompany = null;
	    if (!results.isEmpty()) {
	        theCompany = results.get(0);
	    }
	    else {
			theCompany = null;
		}
	    return theCompany;
	}

	@Override
	public int getIdCompanyByUserId(int userId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Company> theQuery = currentSession.createQuery("from Company c where c.userId=:userId", Company.class);
	    theQuery.setParameter("userId", userId);
	    List<Company> results = theQuery.getResultList();
	    int companyId  = 0;
	    if (!results.isEmpty()) {
	    	companyId  = results.get(0).getId();
	    }
	    return companyId;
	}

	@Override
	public List<Company> getCompanyFollowed(int userId) {
		Session currentSession = sessionFactory.getCurrentSession();
	    Query<Company> theQuery = currentSession.createQuery("select c from Company c join FollowCompany f on c.id = f.company.id "
	    		+ "where f.users.id = :userId", Company.class);
	    theQuery.setParameter("userId", userId);
	    List<Company> result = theQuery.getResultList();
	    return result;
	}

}
