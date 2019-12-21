package com.tyss.assessment3.service;

import com.tyss.assessment3.dto.UserInformation;

public interface EmailService {

	public UserInformation login(String email ,String password);
	public int register(UserInformation bean);
	public boolean changePassword(int  uid,String password);
}
