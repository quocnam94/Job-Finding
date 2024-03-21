package com.luv2code.springsecurity.demo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springsecurity.demo.entity.Users;

@Repository
@Transactional
public class HibernateUserRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public HibernateUserRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveUser(Users user) {
        getSession().save(user);
    }

    public Users findByUsername(String username) {
        return getSession()
                .createQuery("FROM Users u WHERE u.userName = :username", Users.class)
                .setParameter("username", username)
                .uniqueResult();
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
