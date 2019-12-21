package com.tyss.mail.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.mail.dto.MailResponse;
import com.tyss.mail.service.MailSimulationService;

@RestController
public class MailController {

	@Autowired
	private MailSimulationService service;

	@DeleteMapping(path="/delete/{mid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public MailResponse deleteEmployee(@PathVariable("mid") int mid) {
		MailResponse response = new MailResponse();
		if(service.deleteMail(mid)) {
			response.setStatusCode(201);              
			response.setMessage("success");
			response.setDescription("Data deleted form DB");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Data not deleted from DB");
		}
		return response;
	}
}
