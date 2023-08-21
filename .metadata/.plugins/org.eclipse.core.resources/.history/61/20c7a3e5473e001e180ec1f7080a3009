package com.app.pojo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


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


}
