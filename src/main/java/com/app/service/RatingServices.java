package com.app.service;

import java.util.List;

import com.app.exception.ProductException;
import com.app.modal.Rating;
import com.app.modal.User;
import com.app.request.RatingRequest;
import com.app.response.RatingDisplayDTO;

public interface RatingServices {
	
	public Rating createRating(RatingRequest req,User user) throws ProductException;
	
	public List<Rating> getProductsRating(Long productId);
	
	public RatingDisplayDTO getOverallRatingOfProduct(Long productId);

}
