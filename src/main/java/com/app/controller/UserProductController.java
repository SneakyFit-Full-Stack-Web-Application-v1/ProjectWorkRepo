package com.app.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojo.Product;
import com.app.request.DisplayProductInfo;
import com.app.service.ProductServiceImpl;

@RestController
@RequestMapping("/api")
public class UserProductController {

	
	@Autowired
	private ProductServiceImpl productService;
	
	
	@GetMapping("/products")
	public List<DisplayProductInfo> getAllProducts()
	{
		return productService.getAllProducts();
	}
}
