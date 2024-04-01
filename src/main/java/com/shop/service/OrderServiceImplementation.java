package com.shop.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.shop.exception.CouponException;
import com.shop.exception.OrderException;
import com.shop.exception.ProductException;
import com.shop.exception.UserException;
import com.shop.modal.Coupon;
import com.shop.modal.Orders;
import com.shop.modal.Product;
import com.shop.modal.User;
import com.shop.repository.OrderRepository;
import com.shop.repository.ProductRepository;
import com.shop.repository.UserRepository;
import com.shop.reqres.AllOrdersResponse;
import com.shop.reqres.OrderIdResponse;
import com.shop.reqres.OrderResponse;
import com.shop.reqres.PaymentResponse;

@Service
public class OrderServiceImplementation implements OrderService {
	
	UserService userService;
	
	UserRepository userRepository;
	
	CouponService couponService;
	
	ProductService productService;
	
	ProductRepository productRepository;
	
	OrderRepository orderRepository;
	
	public OrderServiceImplementation(UserService userService, UserRepository userRepository, CouponService couponService, ProductService productService, ProductRepository productRepository, OrderRepository orderRepository) {
		this.userService = userService;
		this.couponService = couponService;
		this.productService = productService;
		this.orderRepository = orderRepository;
		this.productRepository = productRepository;
		this.userRepository = userRepository;
	}
	
	
	@Override
	public OrderResponse makeOrder(Integer userId, Integer quantity, String coupon_name) throws OrderException, UserException, CouponException, ProductException {
		
		OrderResponse res = new OrderResponse();
		
		Optional<User> user = userRepository.findById(userId);
		
		if(user.isEmpty()) {
			throw new UserException("This user does not exist");
		}
		
		Optional<Product> prod = productRepository.findById(52);
		
		if(prod.isEmpty()) {
			throw new ProductException("Product with this product id does not exist");
		}
		
		if(quantity > prod.get().getAvailable() || quantity < 0) {
			throw new ProductException("Invalid quantity or item is not available in this much quantity");
		}
		
		Coupon coup = couponService.findCouponByName(coupon_name);
		
		if(coup == null) {
			throw new CouponException("Invalid Coupon");
		}
		
		Orders ord = createOrder(52, userId, quantity, coupon_name);
		
		res.setUserId(userId);
		res.setOrderId(ord.getId());
		res.setQuantity(quantity);
		
		Product pr = prod.get();
		pr.setAvailable(pr.getAvailable() - quantity);
		pr.setOrdered(pr.getOrdered() + quantity);
		productRepository.save(pr);
		
		res.setCoupon_name(coupon_name);
		Integer amount = quantity * prod.get().getPrice() - ((coup.getDiscount()*(prod.get().getPrice()*quantity))/100);
		res.setAmount(amount);
		
		ord.setAmount(amount);
		
		return res;
	}
	
	@Override
	public Orders createOrder(Integer productId, Integer userId, Integer quantity, String coupon_name) throws OrderException, UserException, CouponException {
		
		Orders ord = new Orders();
		
		ord.setStatus("successful");
		ord.setDate(LocalDateTime.now());
		ord.setOrderedBy(userId);
		ord.setQuantity(quantity);
		ord.setCouponName(coupon_name);
		ord.setProductId(productId);
		
		return orderRepository.save(ord);
	}

	@Override
	public PaymentResponse makePayment(Integer userId, Integer orderId, Integer amount) throws UserException, OrderException {
		
		Optional<User> user = userRepository.findById(userId);
		
		if(user.isEmpty()) {
			throw new UserException("This user does not exist");
		}
		
		Optional<Orders> ord = orderRepository.findById(orderId);
		
		if(ord.isEmpty()) {
			throw new OrderException("Order with this id does not exist");
		}
		
		Random random = new Random();
		int index = random.nextInt(6);
		
		PaymentResponse res;
		
		switch (index) {
        case 0:
            res = new PaymentResponse(userId, orderId, "tran010100001", "successful", "Payment successfull");
            break;
        case 1:
        	res = new PaymentResponse(userId, orderId, "tran010100002", "failed", "Payment Failed as amount is invalid");
            break;
        case 2:
        	res = new PaymentResponse(userId, orderId, "tran010100003", "failed", "Payment Failed from bank");
            break;
        case 3:
        	res = new PaymentResponse(userId, orderId, "tran010100004", "failed", "Payment Failed due to invalid order id");
            break;
        case 4:
        	res = new PaymentResponse(userId, orderId, "tran010100005", "failed", "No response from payment server");
            break;
        case 5:
        	res = new PaymentResponse(userId, orderId, "tran010100006", "failed", "Order is already paid for");
            break;
        default:
            return null;
		}
		
		return res;		
	}
	
	@Override
	public List<AllOrdersResponse> findAllOrdersByUserId(Integer userId) throws UserException {
		
		Optional<User> user = userRepository.findById(userId);
		
		if(user.isEmpty()) {
			throw new UserException("This user does not exist");
		}
		
		List<Orders> ords = orderRepository.findByOrderedBy(userId);
		
		List<AllOrdersResponse> responses = new ArrayList<>();
		
		for(Orders ord: ords) {
			AllOrdersResponse res = new AllOrdersResponse();
			res.setOrderId(ord.getId());
			res.setAmount(ord.getAmount());
			res.setDate(ord.getDate());
			res.setCoupon_name(ord.getCouponName());
			
			responses.add(res);
		}
		
		return responses;
	}

	@Override
	public OrderIdResponse findOrderByOrderId(Integer userId, Integer orderId) throws UserException, OrderException {
		
		Optional<User> user = userRepository.findById(userId);
		
		if(user.isEmpty()) {
			throw new UserException("This user does not exist");
		}
		
		Optional<Orders> ord = orderRepository.findById(orderId);
		
		if(ord.isEmpty()) {
			throw new OrderException("Order with this orderId does not exist");
		}
		
		if(!ord.get().getOrderedBy().equals(userId)) {
			throw new OrderException("This user does not have order with this id");
		}
		
		OrderIdResponse res = new OrderIdResponse();
		
		res.setOrderId(orderId);
		res.setAmount(ord.get().getAmount());
		res.setDate(LocalDateTime.now());
		res.setCoupon_name(ord.get().getCouponName());
		res.setTransaction_id(ord.get().getTransaction_id());
		res.setStatus(ord.get().getStatus());
		
		return res;
	}	

}
