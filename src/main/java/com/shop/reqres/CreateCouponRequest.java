package com.shop.reqres;

public class CreateCouponRequest {

	private String coupon_name;
	
	private Integer discount;
	
	public CreateCouponRequest() {
		// TODO Auto-generated constructor stub
	}

	public CreateCouponRequest(String coupon_name, Integer discount) {
		super();
		this.coupon_name = coupon_name;
		this.discount = discount;
	}

	public String getCoupon_name() {
		return coupon_name;
	}

	public void setCoupon_name(String coupon_name) {
		this.coupon_name = coupon_name;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "CreateCouponRequest [coupon_name=" + coupon_name + ", discount=" + discount + "]";
	}
	
	
}
