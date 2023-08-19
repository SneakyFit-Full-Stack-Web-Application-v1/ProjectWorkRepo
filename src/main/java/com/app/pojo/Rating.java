package com.app.pojo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ratings")
public class Rating extends BaseEntity {
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="profile_id")
	private ProfileDetail profileDetail;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="product_id")
	private Product product;
	
	private Double ratings;
	
	private LocalDate createdAt;

	public ProfileDetail getProfileDetail() {
		return profileDetail;
	}

	public void setProfileDetail(ProfileDetail profileDetail) {
		this.profileDetail = profileDetail;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Double getRatings() {
		return ratings;
	}

	public void setRatings(Double ratings) {
		this.ratings = ratings;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Rating [profileDetail=" + profileDetail + ", product=" + product + ", ratings=" + ratings
				+ ", createdAt=" + createdAt + "]";
	}
	
	
	
}
