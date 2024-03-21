package com.luv2code.springsecurity.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.luv2code.springsecurity.demo.dao.CVDAO;


@Service
public class CVServiceImpl implements CVService {

	@Autowired
	private CVDAO CVDAO;
	
	@Override
	@Transactional
	public String getNameCVByUserId(int userId) {
		return CVDAO.getNameCVByUserId(userId);
	}

	@Override
	@Transactional
	public boolean isExistCV(int userId) {
		return CVDAO.isExistCV(userId);
	}

}
