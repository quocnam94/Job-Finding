package com.luv2code.springsecurity.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springsecurity.demo.entity.Users;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
		
	@Override
	public void saveUser(Users theUser) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theUser);
	}

	@Override
	public Users findByUserName(String userName) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Users> theQuery = currentSession.createQuery("from User where userName=:uName", Users.class);
		theQuery.setParameter("uName", userName);
		Users theUser = null;
		try {
			theUser = theQuery.getSingleResult();
		} catch (Exception e) {
			theUser = null;
		}
		return theUser;
	}

	@Override
	public Users getUser(int userId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Users theUser = currentSession.get(Users.class, userId);
		return theUser;
	}

	@Override
	public int getUserIdByEmail(String userName) {
		Session currentSession = sessionFactory.getCurrentSession();
	    Query<Users> query = currentSession.createQuery("from Users where userName = :userName", Users.class);
	    query.setParameter("userName", userName);
	    List<Users> userList = query.list();
	    if (!userList.isEmpty()) {
	        Users user = userList.get(0);
	        return user.getId();
	    } else {
	        return -1;
	    }
	}

	@Override
	public int getTotalUser() {
		Session currentSession = sessionFactory.getCurrentSession();
	    Query<Long> theQuery = currentSession.createQuery("select count(*) from Users where role = 'USER,USER'", Long.class);
	    Long result = theQuery.uniqueResult();
	    return result != null ? result.intValue() : 0;
	}

	@Override
	public List<Users> getUsers(List<Integer> theUserIds) {
		Session currentSession = sessionFactory.getCurrentSession();
	    Query<Users> theQuery = currentSession.createQuery("FROM Users WHERE id IN :theUserIds", Users.class);
		theQuery.setParameter("theUserIds", theUserIds);
		List<Users> theUsers = theQuery.getResultList();
		return theUsers;
	}

}
