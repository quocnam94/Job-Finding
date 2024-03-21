package com.luv2code.springsecurity.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springsecurity.demo.entity.FollowJob;

@Repository
public class FollowJobDAOImpl implements FollowJobDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void saveFollowJob(FollowJob followJob) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(followJob);
	}

	@Override
	public boolean isFollowJob(int recruitmentId, int userId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<FollowJob> theQuery = currentSession.createQuery("from FollowJob where recruitment.id =:recruitmentId "
				+ "and users.id=:userId", FollowJob.class);
		theQuery.setParameter("recruitmentId", recruitmentId);
		theQuery.setParameter("userId", userId);
		FollowJob theFollowJob = theQuery.uniqueResult();
		if (theFollowJob == null) {
            return false;
        }
		return true;
	}

	@Override
	public void unFollowJob(FollowJob followJob) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<FollowJob> theQuery = currentSession.createNativeQuery("DELETE FROM follow_job WHERE recruitment_id = :recruitmentId AND user_id = :userId", FollowJob.class);
	    theQuery.setParameter("recruitmentId", followJob.getRecruitment().getId());
	    theQuery.setParameter("userId", followJob.getUsers().getId());
	    theQuery.executeUpdate();
	}

	@Override
	public List<FollowJob> getFollowJob(int userId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<FollowJob> theQuery = currentSession.createQuery("from FollowJob where users.id=:userId", FollowJob.class);
		theQuery.setParameter("userId", userId);
		List<FollowJob> result = theQuery.getResultList();
		return result;
	}
	
}
