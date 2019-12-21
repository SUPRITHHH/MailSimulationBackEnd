package com.tyss.assessment3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.assessment3.dto.Response;
import com.tyss.assessment3.dto.UserInformation;
import com.tyss.assessment3.service.EmailService;


@RestController
@RequestMapping("email")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmailController {

	@Autowired
	private EmailService service;
	
	@PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response login(@RequestBody UserInformation bean) {

	    Response response = new Response();
		try {
		UserInformation bean1 = service.login(bean.getEmail(),bean.getPassword());
		String user = bean1.getEmail();
		String password = bean.getPassword();
		if (bean1 != null && bean1.getPassword().equals(bean.getPassword())) {
			response.setStatusCode(201);;
			response.setMessage("login successfull");
			response.setDescription("login successfull");
			response.setUsers(user);
			response.setPassword(password);
			
		} }catch(Exception e) {
			e.printStackTrace();
			response.setStatusCode(401);
			response.setMessage("UserId and Password doesnot match");
			response.setDescription("Invalid credentials");
			return response;
		}

		return response;
	}
	
	@PostMapping(path = "/changepassword", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response changePassword(@RequestBody UserInformation bean) {

	    Response response = new Response();
		try {
		boolean bean1 = service.changePassword(bean.getUid(),bean.getPassword());
		int user = bean.getUid();
		String password = bean.getPassword();
		if (bean1) {
			response.setStatusCode(201);;
			response.setMessage("Password Changed successfull");
			response.setDescription("Password Changed successfull");
			response.setUser1(user);;
			response.setPassword(password);
		} }catch(Exception e) {
			e.printStackTrace();
			response.setStatusCode(401);
			response.setMessage("Password doesnot Changed");
			response.setDescription("Password doesnot Changed");
			return response;
		}

		return response;
	}
	
	@PostMapping(path = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response allocateAsset(@RequestBody UserInformation bean) {

		Response response = new Response();
		int count = service.register( bean);
		if (count==-1) {
			response.setStatusCode(201);
			response.setMessage("sucess");
			response.setDescription("Data added to the database");
			response.setUser(bean);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription(" failed to add data to the database");
		}

		return response;
	}
	
	
	
}
