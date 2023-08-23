package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojo.Product;
import com.app.request.CreateProductRequest;
import com.app.request.DisplayProductInfo;
import com.app.request.UpdateProductRequest;
import com.app.service.ProductServiceImpl;

@RestController
@RequestMapping("/api/admin/products")
public class AdminProductController {
	
	@Autowired
	private ProductServiceImpl productService;
	
	@GetMapping("/")
	public List<DisplayProductInfo> getAllProducts()
	{
		return productService.getAllProducts();
	}
	
	@PostMapping("/")
	public Product createProductHandler(@RequestBody CreateProductRequest newProduct)
	{
		return productService.createProduct(newProduct);
	}
	
	@DeleteMapping("/delete/{productId}")
	public String deleteProductHandler(@PathVariable Long productId)
	{
		return productService.deleteProduct(productId);
	}
	
	@PutMapping("/update/{productId}")
	public String updateProductHandler(@PathVariable Long productId,@RequestBody CreateProductRequest requestedProduct)
	{
		return productService.updateProduct(productId, requestedProduct);
	}

}
