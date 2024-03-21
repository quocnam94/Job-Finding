package com.luv2code.springsecurity.demo.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springsecurity.demo.entity.CV;

@Repository
public class FileDAO {
	@Autowired
    private SessionFactory sessionFactory;

    public void save(CV CV) {
        sessionFactory.getCurrentSession().save(CV);
    }

    public CV get(int id) {
        return sessionFactory.getCurrentSession().get(CV.class, id);
    }

    public List<CV> list() {
        return sessionFactory.getCurrentSession().createQuery("from CV").list();
    }
    
    public CV findByUserId(int userId) {
        return sessionFactory.getCurrentSession().createQuery("from FileModel where userId = :userId", CV.class)
                .setParameter("userId", userId)
                .uniqueResult();
    }

}
