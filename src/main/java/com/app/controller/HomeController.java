package com.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.response.ApiResponse;

@RestController
public class HomeController {
	
	@GetMapping("/")
	public ResponseEntity<ApiResponse> homeController()
	{
		ApiResponse response=new ApiResponse("WELCOME TO SNEAKYFIT", true);
		return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
	}
	
	


}
