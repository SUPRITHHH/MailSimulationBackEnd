package com.tyss.assessment3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.assessment3.dao.EmailDAO;
import com.tyss.assessment3.dto.UserInformation;



@Service
public class EmailServiceImpl implements  EmailService {

	
	@Autowired
	private EmailDAO dao;

	@Override
	public UserInformation login(String email, String password) {
		return dao.login(email, password);
	}

	@Override
	public int register(UserInformation bean) {
		return dao.register(bean);
	}

	@Override
	public boolean changePassword(int  uid,String password) {
		return dao.changePassword(uid, password);
	}
	

	
	
}
