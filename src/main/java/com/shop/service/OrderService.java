package com.shop.service;

import java.util.List;

import com.shop.exception.CouponException;
import com.shop.exception.OrderException;
import com.shop.exception.ProductException;
import com.shop.exception.UserException;
import com.shop.modal.Orders;
import com.shop.reqres.AllOrdersResponse;
import com.shop.reqres.OrderIdResponse;
import com.shop.reqres.OrderResponse;
import com.shop.reqres.PaymentResponse;

public interface OrderService {
	
	public OrderResponse makeOrder(Integer userId, Integer quantity, String coupon_name) throws CouponException, UserException, OrderException, ProductException;
	
	public Orders createOrder(Integer productId, Integer userId, Integer quantity, String coupon_name) throws CouponException, OrderException, UserException;

	public List<AllOrdersResponse> findAllOrdersByUserId(Integer userId) throws UserException;
	
	public OrderIdResponse findOrderByOrderId(Integer userId, Integer orderId) throws UserException, OrderException;
	
	public PaymentResponse makePayment(Integer userId, Integer orderId, Integer amount) throws UserException, OrderException;
}
