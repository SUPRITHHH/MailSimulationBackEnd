package com.tyss.mail.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user_info")
public class User_Info {

	@Column
	@Id
	@GeneratedValue
	private int uid;
	@Column(unique = true)
	private String email;
	@Column
	private String userName;
	@Column
	private String password;
	
	public List<Mail_Info> getMails() {
		return mails;
	}
	public void setMails(List<Mail_Info> mails) {
		this.mails = mails;
	}
	@OneToMany(cascade = CascadeType.ALL)
	private List<Mail_Info> mails;
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
