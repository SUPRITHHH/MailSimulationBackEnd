package com.tyss.mailsimulation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.mailsimulation.dao.MailSimulationDAO;
import com.tyss.mailsimulation.dto.Mail_Info;
import com.tyss.mailsimulation.dto.User_Info;

@Service
public class MailServiceImpl implements MailService {
	@Autowired
	private MailSimulationDAO dao;

	@Override
	public List<Mail_Info> inbox(User_Info userInfo) {
		return dao.inbox(userInfo);
	}

	@Override
	public List<Mail_Info> sentItems(User_Info userInfo) {
		return dao.sentItems(userInfo);
	}

	@Override
	public boolean composeMail(User_Info userInfo) {
		return dao.composeMail(userInfo);
	}

}
