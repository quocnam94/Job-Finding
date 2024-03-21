package com.luv2code.springsecurity.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springsecurity.demo.entity.ApplyJob;

@Repository
public class ApplyJobDAOImpl implements ApplyJobDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveApplyJob(ApplyJob theApplyJob) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theApplyJob);
	}

	@Override
	public List<Integer> getUserIds(List<Integer> theRecruitmentIds) {
	    Session currentSession = sessionFactory.getCurrentSession();
	    Query<Integer> theQuery = currentSession.createQuery(
	            "SELECT users.id FROM ApplyJob WHERE recruitment.id IN :recruitmentIds", Integer.class
	        );
	        theQuery.setParameterList("recruitmentIds", theRecruitmentIds);
	        List<Integer> userIdList = theQuery.getResultList();
	        return userIdList;
	}

	@Override
	public List<Integer> getTheRecruitmentIdsInApplyJob(List<Integer> theUserIds) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Integer> theQuery = currentSession.createQuery("select recruitment.id from ApplyJob where users.id in:theUserIds", Integer.class);
		theQuery.setParameter("theUserIds", theUserIds);
		List<Integer> result = theQuery.getResultList();
		return result;
	}

	@Override
	public List<ApplyJob> getApplyJobsByRecruitmentId(List<Integer> theRecruitmentIds) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<ApplyJob> theQuery = currentSession.createQuery("from ApplyJob where recruitment.id in:theRecruitmentIds", ApplyJob.class);
		theQuery.setParameter("theRecruitmentIds", theRecruitmentIds);
		List<ApplyJob> result = theQuery.getResultList();
		return result;
	}

	@Override
	public List<ApplyJob> getApplyJob(int recruitmentId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<ApplyJob> theQuery = currentSession.createQuery("from ApplyJob where recruitment.id =:recruitmentId", ApplyJob.class);
		theQuery.setParameter("recruitmentId", recruitmentId);
		List<ApplyJob> result = theQuery.getResultList();
		return result;
	}

	@Override
	public boolean isApplyJob(int recruitment, int userId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<ApplyJob> theQuery = currentSession.createQuery("from ApplyJob where recruitment.id =:recruitment and users.id=:userId", ApplyJob.class);
		theQuery.setParameter("recruitment", recruitment);
		theQuery.setParameter("userId", userId);
		ApplyJob theApplyJob = theQuery.uniqueResult();
		if (theApplyJob == null) {
            return false;
        }
		return true;
	}

}
