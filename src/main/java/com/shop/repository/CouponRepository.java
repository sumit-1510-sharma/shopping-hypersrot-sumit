package com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.modal.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {

	Coupon findByCouponName(String couponName);
}
