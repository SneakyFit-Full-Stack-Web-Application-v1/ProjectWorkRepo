package com.app.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.app.custom_exceptions.ProductException;
import com.app.pojo.Product;
import com.app.request.CreateProductRequest;
import com.app.request.DisplayProductInfo;
import com.app.request.UpdateProductRequest;

public interface ProductService {
	
	// only for admin
		public Product createProduct(CreateProductRequest req) throws ProductException;
		
		public String deleteProduct(Long productId) throws ProductException;
		
		public String updateProduct(Long productId,CreateProductRequest product)throws ProductException;
		
		public List<DisplayProductInfo> getAllProducts();
		
		
		// for user and admin both
//		public Product findProductById(Long id) throws ProductException;
//		
//		public List<Product> findProductByCategory(String category);
//		
//		public List<Product> searchProduct(String query);
//		
////		public List<Product> getAllProduct(List<String>colors,List<String>sizes,int minPrice, int maxPrice,int minDiscount, String category, String sort,int pageNumber, int pageSize);
//		public Page<Product> getAllProduct(String category, List<String>colors, List<String> sizes, Integer minPrice, Integer maxPrice, Integer minDiscount,String sort, String stock, Integer pageNumber, Integer pageSize);

}
