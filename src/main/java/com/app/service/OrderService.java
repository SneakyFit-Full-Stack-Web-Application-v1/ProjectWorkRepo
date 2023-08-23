package com.app.service;

import java.util.List;

import com.app.custom_exceptions.OrderException;
import com.app.pojo.Address;
import com.app.pojo.Order;
import com.app.pojo.ProfileDetail;

public interface OrderService {

	public Order createOrder(ProfileDetail profileDetail, Address shippingAdress);

	public Order findOrderById(Long orderId) throws OrderException;

	public List<Order> usersOrderHistory(Long userId);

	public Order placedOrder(Long orderId) throws OrderException;

	public Order confirmedOrder(Long orderId) throws OrderException;

	public Order shippedOrder(Long orderId) throws OrderException;

	public Order deliveredOrder(Long orderId) throws OrderException;

	public Order cancledOrder(Long orderId) throws OrderException;

	public List<Order> getAllOrders();

	public void deleteOrder(Long orderId) throws OrderException;

}
