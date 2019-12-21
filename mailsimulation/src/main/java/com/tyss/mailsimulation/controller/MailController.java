package com.tyss.mailsimulation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.mailsimulation.dto.MailResponse;
import com.tyss.mailsimulation.dto.Mail_Info;
import com.tyss.mailsimulation.dto.User_Info;
import com.tyss.mailsimulation.service.MailService;


@RestController
public class MailController {
	@Autowired
	private MailService service;
	
	@PostMapping(path = "/inbox",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public MailResponse inbox(@RequestBody User_Info userInfo) {
		MailResponse response = new MailResponse();
		List<Mail_Info> mailInfos = service.inbox(userInfo);
		if(!mailInfos.isEmpty()) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("ur inbox is here");
			response.setMailInfos(mailInfos);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("no mails present in inbox");
		}
		return response;
	}
	
	@PostMapping(path = "/sentitems",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public MailResponse sentItems(@RequestBody User_Info userInfo) {
		MailResponse response = new MailResponse();
		List<Mail_Info> mailInfos = service.sentItems(userInfo);
		if(!mailInfos.isEmpty()) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Yours Sent items are here");
			response.setMailInfos(mailInfos);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("no mails present in SentBox");
		}
		return response;
	}
	
	@PostMapping(path = "/composemail",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public MailResponse composeMail(@RequestBody User_Info userInfo) {
		MailResponse response = new MailResponse();
		if(service.composeMail(userInfo)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("message sent");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("message not sent");
		}
		return response;
	}


}
