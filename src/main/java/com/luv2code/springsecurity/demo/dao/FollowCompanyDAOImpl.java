package com.luv2code.springsecurity.demo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springsecurity.demo.entity.FollowCompany;

@Repository
public class FollowCompanyDAOImpl implements FollowCompanyDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void saveFollowCompany(FollowCompany followCompany) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(followCompany);
	}

	@Override
	public boolean isFollowCompany(int companyId, int userId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<FollowCompany> theQuery = currentSession.createQuery("from FollowCompany where company.id =:companyId "
				+ "and users.id=:userId", FollowCompany.class);
		theQuery.setParameter("companyId", companyId);
		theQuery.setParameter("userId", userId);
		FollowCompany theFollowCompany = theQuery.uniqueResult();
		if (theFollowCompany == null) {
            return false;
        }
		return true;
	}

	@Override
	public void unFollowCompany(FollowCompany followCompany) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<FollowCompany> theQuery = currentSession.createNativeQuery("DELETE FROM follow_company WHERE company_id = :companyId AND user_id = :userId", FollowCompany.class);
	    theQuery.setParameter("companyId", followCompany.getCompany().getId());
	    theQuery.setParameter("userId", followCompany.getUsers().getId());
	    theQuery.executeUpdate();
	}

}
