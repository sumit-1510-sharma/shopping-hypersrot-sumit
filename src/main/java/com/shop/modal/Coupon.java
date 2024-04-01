package com.shop.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Coupon {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "coupon_name")
	private String couponName;
	
	private Integer discount;
	
	
	
	public Coupon() {
		// TODO Auto-generated constructor stub
	}

	public Coupon(Integer id, String couponName, Integer discount) {
		super();
		this.id = id;
		this.couponName = couponName;
		this.discount = discount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCouponName() {
		return couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "Coupon [id=" + id + ", couponName=" + couponName + ", discount=" + discount + "]";
	}
	
	

}
