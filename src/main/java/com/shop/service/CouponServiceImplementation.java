package com.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shop.exception.CouponException;
import com.shop.modal.Coupon;
import com.shop.repository.CouponRepository;
import com.shop.reqres.CreateCouponRequest;

@Service
public class CouponServiceImplementation implements CouponService {
	
	private CouponRepository couponRepository;

	public CouponServiceImplementation(CouponRepository couponRepository) {
		this.couponRepository = couponRepository;
	}
	
	
	@Override
	public Coupon createCoupon(CreateCouponRequest req) throws CouponException {
		
		Coupon coup = new Coupon();
		
		coup.setCouponName(req.getCoupon_name());
		coup.setDiscount(req.getDiscount());
		
		return couponRepository.save(coup);
	}
	
	@Override
	public List<Coupon> findAllCoupons() throws CouponException {
		
		List<Coupon> coups = couponRepository.findAll();
		
		return coups;
	}
	

	@Override
	public Coupon findCouponByName(String coupon_name) throws CouponException {
		
		Coupon coup = couponRepository.findByCouponName(coupon_name);
		
		return coup;
	}


}
