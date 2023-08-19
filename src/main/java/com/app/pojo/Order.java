package com.app.pojo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
	
	@Column(name="order_id")
    private String orderId;
  
    @ManyToOne
    @JoinColumn(name = "profile_id")
    private ProfileDetail profileDetail;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems = new ArrayList<>();

    private LocalDate orderDate;

	private LocalDate deliveryDate;

    @OneToOne
    private Address shippingAddress;

    @Embedded
    private PaymentDetails paymentDetails=new PaymentDetails();

    private double totalPrice;
    
    private Integer totalDiscountedPrice;
    
    private Integer discounte;

    private OrderStatus orderStatus;
    
    private int totalItem;
    
    private LocalDate createdAt;
    
    public String getOrderId() {
    	return orderId;
    }
    public void setOrderId(String orderId) {
    	this.orderId = orderId;
    }
    public ProfileDetail getProfileDetail() {
    	return profileDetail;
    }
    public void setProfileDetail(ProfileDetail profileDetail) {
    	this.profileDetail = profileDetail;
    }
    public List<OrderItem> getOrderItems() {
    	return orderItems;
    }
    public void setOrderItems(List<OrderItem> orderItems) {
    	this.orderItems = orderItems;
    }
    public LocalDate getOrderDate() {
    	return orderDate;
    }
    public void setOrderDate(LocalDate orderDate) {
    	this.orderDate = orderDate;
    }
    public LocalDate getDeliveryDate() {
    	return deliveryDate;
    }
    public void setDeliveryDate(LocalDate deliveryDate) {
    	this.deliveryDate = deliveryDate;
    }
    public Address getShippingAddress() {
    	return shippingAddress;
    }
    public void setShippingAddress(Address shippingAddress) {
    	this.shippingAddress = shippingAddress;
    }
    public PaymentDetails getPaymentDetails() {
    	return paymentDetails;
    }
    public void setPaymentDetails(PaymentDetails paymentDetails) {
    	this.paymentDetails = paymentDetails;
    }
    public double getTotalPrice() {
    	return totalPrice;
    }
    public void setTotalPrice(double totalPrice) {
    	this.totalPrice = totalPrice;
    }
    public Integer getTotalDiscountedPrice() {
    	return totalDiscountedPrice;
    }
    public void setTotalDiscountedPrice(Integer totalDiscountedPrice) {
    	this.totalDiscountedPrice = totalDiscountedPrice;
    }
    public Integer getDiscounte() {
    	return discounte;
    }
    public void setDiscounte(Integer discounte) {
    	this.discounte = discounte;
    }
    public OrderStatus getOrderStatus() {
    	return orderStatus;
    }
    public void setOrderStatus(OrderStatus orderStatus) {
    	this.orderStatus = orderStatus;
    }
    public int getTotalItem() {
    	return totalItem;
    }
    public void setTotalItem(int totalItem) {
    	this.totalItem = totalItem;
    }
    public LocalDate getCreatedAt() {
    	return createdAt;
    }
    public void setCreatedAt(LocalDate createdAt) {
    	this.createdAt = createdAt;
    }
    public void addOrderItem(OrderItem orderItem)
    {
    	orderItems.add(orderItem);
    	orderItem.setOrder(this);
    }
    public void removeOrderItem(OrderItem orderItem)
    {
    	orderItems.remove(totalItem);
    	orderItem.setOrder(null);
    }


}
