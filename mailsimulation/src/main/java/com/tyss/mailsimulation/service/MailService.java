package com.tyss.mailsimulation.service;

import java.util.List;

import com.tyss.mailsimulation.dto.Mail_Info;
import com.tyss.mailsimulation.dto.User_Info;

public interface MailService {
	public List<Mail_Info> inbox(User_Info userInfo);
	public List<Mail_Info> sentItems(User_Info userInfo);
	public boolean composeMail(User_Info userInfo);

}
