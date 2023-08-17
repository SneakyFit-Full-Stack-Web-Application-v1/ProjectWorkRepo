package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.AddressDao;
import com.app.dao.UserProfileDao;
import com.app.pojo.*;
@Service
@Transactional
public class UserProfileServiceImpl {
	@Autowired
	private UserProfileDao userDao;
	@Autowired
	private AddressDao addrDao;
	
	public void addUser(ProfileDetail user) {
		userDao.save(user);
	}
	public List<ProfileDetail> getAllUser(){
		return userDao.findAll();
	}
	
	public String addAddress(Address addr,Long id ) {
		System.out.println("in add addrss dao");
//		userDao.findById(id).get().setAddress(addr);
		addrDao.save(addr);
		
		return "saved successful";
	}
}
