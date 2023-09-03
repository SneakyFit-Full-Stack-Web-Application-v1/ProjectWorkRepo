package com.app.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.app.repository.ProductRepository;
import com.app.repository.ReviewRepository;
import com.app.request.ReviewRequest;
import com.app.response.ReviewDisplayDTO;
import com.app.exception.ProductException;
import com.app.modal.Product;
import com.app.modal.Review;
import com.app.modal.User;

@Service
@Transactional
public class ReviewServiceImplementation implements ReviewService {
	
	private ReviewRepository reviewRepository;
	private ProductService productService;
	private ProductRepository productRepository;
	
	public ReviewServiceImplementation(ReviewRepository reviewRepository,ProductService productService,ProductRepository productRepository) {
		this.reviewRepository=reviewRepository;
		this.productService=productService;
		this.productRepository=productRepository;
	}

	@Override
	public Review createReview(ReviewRequest req,User user) throws ProductException {
		// TODO Auto-generated method stub
		Product product=productService.findProductByIdMan(req.getProductId());
		Review review=new Review();
		review.setUser(user);
		review.setProduct(product);
		review.setReview(req.getReview());
		review.setCreatedAt(LocalDateTime.now());
		
//		product.getReviews().add(review);
		productRepository.save(product);
		return reviewRepository.save(review);
	}

	@Override
	public List<ReviewDisplayDTO> getAllReview(Long productId) {
		
		List<Review> review= reviewRepository.getAllProductsReview(productId);
		
		List<ReviewDisplayDTO> list=new ArrayList<ReviewDisplayDTO>();
		
		for(Review r:review)
		{
			ReviewDisplayDTO disp=new ReviewDisplayDTO();
			disp.setId(r.getProduct().getId());
			disp.setReview(r.getReview());
			list.add(disp);
		}
		
		
		return list;
	}

}
