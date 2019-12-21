package com.tyss.mailsimulation.dto;

import java.util.List;

public class MailResponse {
	private int statusCode;
	private String description;
	private String message;
	List<Mail_Info> mailInfos;
	
	public List<Mail_Info> getMailInfos() {
		return mailInfos;
	}
	public void setMailInfos(List<Mail_Info> mailInfos) {
		this.mailInfos = mailInfos;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
