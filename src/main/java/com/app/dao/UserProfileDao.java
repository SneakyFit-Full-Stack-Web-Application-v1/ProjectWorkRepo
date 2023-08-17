package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojo.ProfileDetail;

public interface UserProfileDao extends JpaRepository<ProfileDetail , Long> {
	

}
