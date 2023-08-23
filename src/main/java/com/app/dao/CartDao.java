package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojo.Cart;

public interface CartDao extends JpaRepository<Cart, Long> {

}
