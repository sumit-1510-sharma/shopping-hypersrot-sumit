package com.shop.service;

import java.util.List;

import com.shop.exception.CouponException;
import com.shop.modal.Coupon;
import com.shop.reqres.CreateCouponRequest;

public interface CouponService {

	public Coupon createCoupon(CreateCouponRequest req) throws CouponException;
	
	public List<Coupon> findAllCoupons() throws CouponException;
	
	public Coupon findCouponByName(String coupon_name) throws CouponException;

}
