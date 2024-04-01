package com.shop.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shop.exception.CouponException;
import com.shop.exception.OrderException;
import com.shop.exception.ProductException;
import com.shop.exception.UserException;
import com.shop.reqres.AllOrdersResponse;
import com.shop.reqres.OrderIdResponse;
import com.shop.reqres.OrderResponse;
import com.shop.reqres.PaymentResponse;
import com.shop.service.OrderService;

@RestController
public class OrderController {
	
	private OrderService orderService;
	
	public OrderController(OrderService orderService) {            //Constructor Injection because it is faster
		this.orderService = orderService;
	}
	
	
	@PostMapping("/{userId}/order")
	public ResponseEntity<OrderResponse> makeOrderHandler(@PathVariable(name="userId") Integer userIdParameter, @RequestParam("qty") Integer quantity, @RequestParam(value="coupon") String coupon_name) throws OrderException, CouponException, UserException, ProductException {
		
		OrderResponse res = orderService.makeOrder(userIdParameter, quantity, coupon_name);
		
		return new ResponseEntity<OrderResponse>(res,HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/{userId}/{orderId}/pay")
	public ResponseEntity<PaymentResponse> makePaymentHandler(@PathVariable(name="userId") Integer userIdParameter, @PathVariable(name="orderId") Integer orderIdParameter, @RequestParam(value="amount") Integer amountParameter) throws UserException, OrderException {
		
		PaymentResponse res = orderService.makePayment(userIdParameter, orderIdParameter, amountParameter);
		
		return new ResponseEntity<PaymentResponse>(res,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{userId}/orders")
	public ResponseEntity<List<AllOrdersResponse>> getAllOrdersByUserIdHandler(@PathVariable(name="userId") Integer userIdParameter) throws UserException {
		
		List<AllOrdersResponse> orders = orderService.findAllOrdersByUserId(userIdParameter);
		
		return new ResponseEntity<List<AllOrdersResponse>>(orders,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{userId}/orders/{orderId}")	
	public ResponseEntity<OrderIdResponse> getOrderByOrderIdHandler(@PathVariable(name="userId") Integer userIdParameter, @PathVariable(name="orderId") Integer orderIdParameter) throws UserException, OrderException {
		
		OrderIdResponse ord = orderService.findOrderByOrderId(userIdParameter, orderIdParameter);
		
		return new ResponseEntity<OrderIdResponse>(ord,HttpStatus.ACCEPTED);
	}	
	
}
