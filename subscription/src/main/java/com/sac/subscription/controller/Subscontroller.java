package com.sac.subscription.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sac.subscription.service.Subsservice;
import com.sac.subsscription.entity.TransactionRequest;
import com.sac.subsscription.entity.Userprofile;

@RestController()
@CrossOrigin()
public class Subscontroller {

	@Autowired
	Subsservice service;

	@PostMapping("/adduser")
	public String addUserProfile(@RequestBody Userprofile usr) throws ClassNotFoundException, SQLException {
		String result = service.addUserProfile(usr);
		return result;

	}

	@GetMapping("/showusers")
	public List<Userprofile> showUsers() throws ClassNotFoundException, SQLException {
		List<Userprofile> result = service.showUsers();
		return result;

	}

	@PostMapping("/subscription")
	public String enrollMember(@RequestBody TransactionRequest request) {

		String memberStatus = service.enrollMember(request);

		return memberStatus;
	}

}
