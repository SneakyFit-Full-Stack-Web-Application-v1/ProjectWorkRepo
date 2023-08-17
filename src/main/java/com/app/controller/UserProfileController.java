package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojo.Address;
import com.app.pojo.ProfileDetail;
import com.app.service.UserProfileServiceImpl;

@RestController

public class UserProfileController {

	@Autowired
	private UserProfileServiceImpl usr;

	
	@PostMapping("/add")
	
	
	public void addUser(@RequestBody ProfileDetail user) {
		System.out.println("in User add controller");
		usr.addUser(user);
	}
	@GetMapping("/get")
	public List<ProfileDetail> getAllUser() {
		System.out.println("in get method controller");
		return usr.getAllUser();
	}
	@PostMapping("/address/{id}")
	public String addAddress(@RequestBody Address adr, @PathVariable Long id) {
		System.out.println("in add address controller");
		System.out.println(adr.getCity());
		return usr.addAddress(adr,id);
	}
}
