package com.app.request;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.app.pojo.Size;

public class UpdateProductRequest {

	private String title;

    private String description;

    private double price;

    private double discountedPrice;
   
    private double discountPercent;

    private int quantity;
    
    private String color;
    
    private String imageUrl;
    
    private String brand;
    
    private Set<Size> sizes=new HashSet<Size>();

	public Set<Size> getSizes() {
		return sizes;
	}

	public void setSizes(Set<Size> sizes) {
		this.sizes = sizes;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(double discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	public double getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(double discountPercent) {
		this.discountPercent = discountPercent;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
