package com.luv2code.springsecurity.demo.dao;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springsecurity.demo.entity.CV;

@Repository
public class CVDAOImpl implements CVDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public String getNameCVByUserId(int userId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<String> theQuery = currentSession.createQuery("select fileName from CV where userId=:userId", String.class);
		theQuery.setParameter("userId", userId);
		String nameCV = null;
		try {
			nameCV = theQuery.getSingleResult();
		} catch (NoResultException e) {
			nameCV = null;
		}
		return nameCV;
	}

	@Override
	public boolean isExistCV(int userId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<CV> theQuery = currentSession.createQuery("from CV where userId=:userId" , CV.class);
		theQuery.setParameter("userId", userId);
		CV theCv = theQuery.uniqueResult();
		if (theCv == null) {
            return false;
        }
		return true;
	}

}
