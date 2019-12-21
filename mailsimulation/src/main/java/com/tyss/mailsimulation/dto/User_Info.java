package com.tyss.mailsimulation.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user_info")
public class User_Info {
	@Id
	@Column
	@GeneratedValue
	private int uid;
	@Column
	private String userName;
	@Column(unique = true)
	private String email;
	@Column
	private String password;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Mail_Info> mailInfos;
	
	public List<Mail_Info> getMailInfos() {
		return mailInfos;
	}
	public void setMailInfos(List<Mail_Info> mailInfos) {
		this.mailInfos = mailInfos;
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
