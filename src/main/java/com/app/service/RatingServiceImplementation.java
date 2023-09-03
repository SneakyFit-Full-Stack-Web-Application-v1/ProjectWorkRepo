package com.app.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.app.exception.ProductException;
import com.app.modal.Product;
import com.app.modal.Rating;
import com.app.modal.User;
import com.app.repository.RatingRepository;
import com.app.request.RatingRequest;
import com.app.response.RatingDisplayDTO;

@Service
@Transactional
public class RatingServiceImplementation implements RatingServices{
	
	private RatingRepository ratingRepository;
	private ProductService productService;
	
	public RatingServiceImplementation(RatingRepository ratingRepository,ProductService productService) {
		this.ratingRepository=ratingRepository;
		this.productService=productService;
	}

	@Override
	public Rating createRating(RatingRequest req,User user) throws ProductException {
		
		Product product=productService.findProductByIdMan(req.getProductId());
		
		Rating rating=new Rating();
		rating.setProduct(product);
		rating.setUser(user);
		rating.setRating(req.getRating());
		rating.setCreatedAt(LocalDateTime.now());
		
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getProductsRating(Long productId) {
		// TODO Auto-generated method stub
		return ratingRepository.getAllProductsRating(productId);
	}

	@Override
	public RatingDisplayDTO getOverallRatingOfProduct(Long productId) {
		// TODO Auto-generated method stub
		
		List<Rating> list= ratingRepository.getAllProductsRating(productId);
		double x=0;
		int count=0;
		for(Rating each:list)
		{
			x=x+each.getRating();
			count++;
		}
		double avgRating=x/count;
		RatingDisplayDTO pass=new RatingDisplayDTO();
		pass.setRatings(avgRating);
		return pass;
	}
	
	
	
	

}
