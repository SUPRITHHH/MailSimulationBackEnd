package com.tyss.assessment3.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Mail_info")
public class MailIformation {

	@Id
	@Column
	@GeneratedValue
	private int mid;
	
	@Column
	private int from_id;
	
	@Column
	private int to_id;
	
	@Column
	private String suject;
	
	@Column
	private String message;
	
	@Column
	private String status;

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getSuject() {
		return suject;
	}

	public void setSuject(String suject) {
		this.suject = suject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
