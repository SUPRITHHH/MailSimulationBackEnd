package com.tyss.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.mail.dao.MailSimulationDAO;

@Service
public class MailSimulationServiceImpl implements MailSimulationService{

	@Autowired
	private MailSimulationDAO dao;
	
	@Override
	public boolean deleteMail(int mid) {
		return dao.deleteMail(mid);
	}

}
