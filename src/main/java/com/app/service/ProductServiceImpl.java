package com.app.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ProductException;
import com.app.dao.CategoryDao;
import com.app.dao.ProductDao;
import com.app.pojo.Category;
import com.app.pojo.Product;
import com.app.pojo.Size;
import com.app.request.CreateProductRequest;
import com.app.request.DisplayProductInfo;
import com.app.request.UpdateProductRequest;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Autowired
	private CategoryDao categoryDao;

	@Override
	public Product createProduct(CreateProductRequest req) throws ProductException {
		Category topLevel = categoryDao.findByName(req.getTopLevelCategory());

		if (topLevel == null) {
			Category topLevelCategory = new Category();
			topLevelCategory.setName(req.getTopLevelCategory());
			topLevelCategory.setLevel(1);

			topLevel = categoryDao.save(topLevelCategory);
		}

		Category secondLevel = categoryDao.findByNameAndParant(req.getSecondLevelCategory(), topLevel.getName());

		if (secondLevel == null) {
			Category secondLevelCategory = new Category();
			secondLevelCategory.setName(req.getSecondLevelCategory());
			secondLevelCategory.setParentCategory(topLevel);
			secondLevelCategory.setLevel(2);

			secondLevel = categoryDao.save(secondLevelCategory);
		}

		Category thirdLevel = categoryDao.findByNameAndParant(req.getThirdLevelCategory(), secondLevel.getName());

		if (thirdLevel == null) {
			Category thirdLevelCategory = new Category();
			thirdLevelCategory.setName(req.getThirdLevelCategory());
			thirdLevelCategory.setParentCategory(secondLevel);
			thirdLevelCategory.setLevel(3);

			thirdLevel = categoryDao.save(thirdLevelCategory);
		}

		Product product = new Product();
		product.setTitle(req.getTitle());
		product.setColor(req.getColor());
		product.setDescription(req.getDescription());
		product.setDiscountedPrice(req.getDiscountedPrice());
		product.setDiscountPercent(req.getDiscountPercent());
		product.setImageUrl(req.getImageUrl());
		product.setBrand(req.getBrand());
		product.setPrice(req.getPrice());
		product.setSizes(req.getSize());
		product.setQuantity(req.getQuantity());
		product.setCategory(thirdLevel);
		product.setCreatedAt(LocalDate.now());

		Product savedProduct = productDao.save(product);

		return savedProduct;
	}

	@Override
	public String deleteProduct(Long productId) throws ProductException {
		Product product = productDao.findById(productId).get();
		product.getSizes().clear();
		product.getRatings().forEach(rating -> product.removeRatings(rating));
		product.getReviews().forEach(review -> product.removeReview(review));
		productDao.delete(product);

		return "Product deleted successfully";
	}

	@Override
	public String updateProduct(Long productId, CreateProductRequest req) throws ProductException {
		// Product p1=new Product();
		Product product = productDao.findById(productId).get();
		// System.out.println(product);

//	    	product.setTitle(req.getTitle());
//	    	product.setDescription(req.getDescription());
//	    	product.setPrice(req.getPrice());
//	    	product.setDiscountedPrice(req.getDiscountedPrice());
//	    	product.setDiscountPercent(req.getDiscountPercent());
//	    	product.setQuantity(req.getQuantity());
//	    	product.setSizes(req.getSizes());

		Category topLevel = categoryDao.findByName(req.getTopLevelCategory());

		if (topLevel == null) {
			Category topLevelCategory = new Category();
			topLevelCategory.setName(req.getTopLevelCategory());
			topLevelCategory.setLevel(1);

			topLevel = categoryDao.save(topLevelCategory);
		}

		Category secondLevel = categoryDao.findByNameAndParant(req.getSecondLevelCategory(), topLevel.getName());

		if (secondLevel == null) {
			Category secondLevelCategory = new Category();
			secondLevelCategory.setName(req.getSecondLevelCategory());
			secondLevelCategory.setParentCategory(topLevel);
			secondLevelCategory.setLevel(2);

			secondLevel = categoryDao.save(secondLevelCategory);
		}

		Category thirdLevel = categoryDao.findByNameAndParant(req.getThirdLevelCategory(), secondLevel.getName());

		if (thirdLevel == null) {
			Category thirdLevelCategory = new Category();
			thirdLevelCategory.setName(req.getThirdLevelCategory());
			thirdLevelCategory.setParentCategory(secondLevel);
			thirdLevelCategory.setLevel(3);

			thirdLevel = categoryDao.save(thirdLevelCategory);
		}

		// Product product=new Product();
		product.setTitle(req.getTitle());
		product.setColor(req.getColor());
		product.setDescription(req.getDescription());
		product.setDiscountedPrice(req.getDiscountedPrice());
		product.setDiscountPercent(req.getDiscountPercent());
		product.setImageUrl(req.getImageUrl());
		product.setBrand(req.getBrand());
		product.setPrice(req.getPrice());
		product.setSizes(req.getSize());
		product.setQuantity(req.getQuantity());
		product.setCategory(thirdLevel);
		product.setCreatedAt(LocalDate.now());

		productDao.save(product);

		return "SuccessFull Update";
	}

	@Override
	public List<DisplayProductInfo> getAllProducts() {

		List<DisplayProductInfo> products = new ArrayList<DisplayProductInfo>();

		List<Product> total = productDao.findAll();

		for (int i = 0; i < total.size(); i++) {
			DisplayProductInfo prod = new DisplayProductInfo();

			// System.out.println(total.size());
			System.out.println(total.get(i).getTitle());
			prod.setTitle(total.get(i).getTitle());
			prod.setDescription(total.get(i).getDescription());
			prod.setImageUrl(total.get(i).getImageUrl());
			prod.setBrand(total.get(i).getBrand());
			prod.setColor(total.get(i).getColor());
			prod.setPrice(total.get(i).getPrice());
			prod.setQuantity(total.get(i).getQuantity());
			products.add(prod);
		}

		return products;
	}

}
