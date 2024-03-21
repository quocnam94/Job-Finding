package com.luv2code.springsecurity.demo.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.luv2code.springsecurity.demo.entity.Recruitment;
import org.springframework.data.domain.Page;


@Repository
public class RecruitmentDAOImpl implements RecruitmentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveJob(Recruitment theRecruitment) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theRecruitment);
	}

	@Override
	public List<Recruitment> getRecruitments(int userId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Recruitment> theQuery = currentSession.createQuery("from Recruitment where user_id =:userId",
				Recruitment.class);
		theQuery.setParameter("userId", userId);
		List<Recruitment> recruitments = theQuery.getResultList();
		return recruitments;
	}

	@Override
	public Recruitment getRecruitment(int userId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Recruitment theRecruitment = currentSession.get(Recruitment.class, userId);
		return theRecruitment;
	}

	@Override
	public Recruitment getRecruitmentByRecruitmentId(int recruitmentId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Recruitment theRecruitment = currentSession.get(Recruitment.class, recruitmentId);
		return theRecruitment;
	}

	@Override
	public void deleteJob(int recruitmentId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Recruitment> theQuery = currentSession
				.createNativeQuery("delete from Recruitment where id=:recruitmentId", Recruitment.class);
		theQuery.setParameter("recruitmentId", recruitmentId);
		theQuery.executeUpdate();
	}

	@Override
	public int getTotalRecruitment() {
		Session currentSession = sessionFactory.getCurrentSession();
		Long count = (Long) currentSession.createQuery("SELECT COUNT(*) FROM Recruitment").getSingleResult();
		return count.intValue();
	}

	@Override
	public List<Recruitment> search(String theSearch) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Recruitment> theQuery = null;
		if (theSearch != null && theSearch.trim().length() > 0) {
			theQuery = currentSession.createQuery("from Recruitment where lower(title) like :theSearch or lower(address) like :theSearch",
					Recruitment.class);
			theQuery.setParameter("theSearch", "%" + theSearch.toLowerCase() + "%");
		} else {
			theQuery = currentSession.createQuery("from Recruitment", Recruitment.class);
		}
		List<Recruitment> theRecruitments = theQuery.getResultList();
		return theRecruitments;
	}

	@Override
	public List<Map<String, Object>> topCategory() {
	    Session currentSession = sessionFactory.getCurrentSession();
	    String queryString = "SELECT r.jobCategory, COUNT(r.jobCategory) FROM Recruitment r GROUP BY r.jobCategory ORDER BY COUNT(r.jobCategory) DESC";
	    Query<Object[]> theQuery = currentSession.createQuery(queryString, Object[].class);
	    theQuery.setMaxResults(4);
	    List<Object[]> resultList = theQuery.getResultList();
	    List<Map<String, Object>> jobCategoryCounts = new ArrayList<>();
	    for (Object[] result : resultList) {
	        String jobCategory = (String) result[0];
	        Long count = (Long) result[1];
	        Map<String, Object> entry = new HashMap<>();
	        entry.put("jobCategory", jobCategory);
	        entry.put("count", count);
	        jobCategoryCounts.add(entry);
	    }
	    return jobCategoryCounts;
	}

	@Override
	public List<Recruitment> topJob() {
		Session currentSession = sessionFactory.getCurrentSession();
		String queryString = "from Recruitment ORDER BY salary DESC, quantity DESC";
		Query<Recruitment> theQuery = currentSession.createQuery(queryString, Recruitment.class);
	    theQuery.setMaxResults(3);
		List<Recruitment> theRecruitments = theQuery.getResultList();
		return theRecruitments;
	}

	@Override
	public List<Integer> getRecruitmentIds(int userId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Recruitment> theQuery = currentSession.createQuery("from Recruitment where user_id =:userId",
				Recruitment.class);
		theQuery.setParameter("userId", userId);
		List<Recruitment> recruitments = theQuery.getResultList();
		List<Integer> recruitmentIds = new ArrayList<>();
	    for (Recruitment recruitment : recruitments) {
	        recruitmentIds.add(recruitment.getId());
	    }
	    return recruitmentIds;
	}

	@Override
	public List<Recruitment> getRecruitmentsByIds(List<Integer> theRecruitmentIds) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Recruitment> theQuery = currentSession.createQuery("from Recruitment where id in:theRecruitmentIds", Recruitment.class);
		theQuery.setParameter("theRecruitmentIds", theRecruitmentIds);
		List<Recruitment> result = theQuery.getResultList();
		return result;
	}
	
	@Override
	public List<Recruitment> getRecruitmentsByCompanyId(int companyId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Recruitment> theQuery = currentSession.createQuery("from Recruitment where idCompany =:companyId", Recruitment.class);
		theQuery.setParameter("companyId", companyId);
		List<Recruitment> result = theQuery.getResultList();
		return result;
	}
	
	@Override
	public List<Recruitment> getRecruitmentsFollowed(int userId) {
	    Session currentSession = sessionFactory.getCurrentSession();
	    Query<Recruitment> theQuery = currentSession.createQuery("select r from Recruitment r join FollowJob f on r.id = f.recruitment.id "
	    		+ "where f.users.id = :userId", Recruitment.class);
	    theQuery.setParameter("userId", userId);
	    List<Recruitment> result = theQuery.getResultList();
	    return result;
	}
	
	@Override
	public List<Recruitment> getRecruitmentsApplied(int userId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Recruitment> theQuery = currentSession.createQuery("select r from Recruitment r join ApplyJob a on r.id = a.recruitment.id where a.users.id =:userId", Recruitment.class);
		theQuery.setParameter("userId", userId);
		List<Recruitment> result = theQuery.getResultList();
		return result;
	}

	@Override
	public Page<Recruitment> getRecruitments(int userId, int page, int size) {
		Session currentSession = sessionFactory.getCurrentSession();
	    Query<Long> countQuery = currentSession.createQuery("select count(*) from Recruitment where user_id =:userId", Long.class);
	    countQuery.setParameter("userId", userId);
	    long total = (Long) countQuery.uniqueResult();
	    Query<Recruitment> query = currentSession.createQuery("from Recruitment where user_id =:userId", Recruitment.class);
	    query.setParameter("userId", userId);
	    query.setFirstResult((page - 1) * size);
	    query.setMaxResults(size);
	    List<Recruitment> recruitments = query.getResultList();
	    return new PageImpl<>(recruitments, PageRequest.of(page - 1, size), total);
	}

}
