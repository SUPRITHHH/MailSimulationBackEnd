package com.tyss.assessment3.dto;




import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="User_info")
public class UserInformation {

	@Id
	@Column
	@GeneratedValue
	private int uid;
	
	@Column
	private String userName;
	
	@Column(unique=true)
	private String email;
	
	@Column
	private String password;
	
	@Column
	private String confirmPassword;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<MailIformation> mailInfos;
	
	
	public List<MailIformation> getMailInfos() {
		return mailInfos;
	}

	public void setMailInfos(List<MailIformation> mailInfos) {
		this.mailInfos = mailInfos;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
