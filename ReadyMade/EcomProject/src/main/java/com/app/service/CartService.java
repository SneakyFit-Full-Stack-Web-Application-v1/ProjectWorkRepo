package com.app.service;

import com.app.request.AddItemRequest;
import com.app.exception.*;

import com.app.modal.*;


public interface CartService {
	
	public Cart createCart(User user);
	
	public String addCartItem(Long userId,AddItemRequest req) throws ProductException;
	
	public Cart findUserCart(Long userId);

}
