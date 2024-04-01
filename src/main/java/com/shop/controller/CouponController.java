package com.shop.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shop.exception.CouponException;
import com.shop.modal.Coupon;
import com.shop.reqres.CreateCouponRequest;
import com.shop.service.CouponService;

@RestController
public class CouponController {
	
	private CouponService couponService;

	public CouponController(CouponService couponService) {            //Constructor Injection because it is faster
		this.couponService = couponService;
	}
	
	
	
	
	@PostMapping("/coupon/create")
	public ResponseEntity<Coupon> createCouponHandler(@RequestBody CreateCouponRequest req) throws CouponException {
		
		Coupon coupon = couponService.createCoupon(req);
		
		return new ResponseEntity<Coupon>(coupon,HttpStatus.ACCEPTED);
	}

	@GetMapping("/fetchCoupons")
	public ResponseEntity<List<Coupon>> getAllCouponsHandler() throws CouponException {
		
		List<Coupon> coupons = couponService.findAllCoupons();
		
		return new ResponseEntity<List<Coupon>>(coupons,HttpStatus.ACCEPTED);
	}
}
