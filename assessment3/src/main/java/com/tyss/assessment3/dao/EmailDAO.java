package com.tyss.assessment3.dao;

import com.tyss.assessment3.dto.UserInformation;


public interface EmailDAO {

	public UserInformation login(String email ,String password);
	public int register(UserInformation bean);
	public boolean changePassword(int  uid,String password);
	
}
