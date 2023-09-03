package com.app.service;

import java.util.List;

import com.app.request.ReviewRequest;
import com.app.response.ReviewDisplayDTO;
import com.app.exception.ProductException;
import com.app.modal.Review;
import com.app.modal.User;

public interface ReviewService {

	public Review createReview(ReviewRequest req,User user) throws ProductException;
	
	public List<ReviewDisplayDTO> getAllReview(Long productId);
	
	
}
