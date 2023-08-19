package com.app.pojo;

import java.time.LocalDate;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Review extends BaseEntity {
	
	private String review;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "profile_id")
	private ProfileDetail profileDetail;
	
	private LocalDate createdAt;

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ProfileDetail getProfileDetail() {
		return profileDetail;
	}

	public void setProfileDetail(ProfileDetail profileDetail) {
		this.profileDetail = profileDetail;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}
	
	
	

}
