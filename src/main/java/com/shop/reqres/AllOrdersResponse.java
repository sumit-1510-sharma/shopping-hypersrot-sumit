package com.shop.reqres;

import java.time.LocalDateTime;


// we get the response in this class format when we try to find all the orders made by a particular User.
public class AllOrdersResponse {

	private Integer orderId;
	
	private Integer amount;
	
	private LocalDateTime date;
	
	private String coupon_name;
	
	
	public AllOrdersResponse() {
		// TODO Auto-generated constructor stub
	}


	public AllOrdersResponse(Integer orderId, Integer amount, LocalDateTime date, String coupon_name) {
		super();
		this.orderId = orderId;
		this.amount = amount;
		this.date = date;
		this.coupon_name = coupon_name;
	}


	public Integer getOrderId() {
		return orderId;
	}


	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}


	public Integer getAmount() {
		return amount;
	}


	public void setAmount(Integer amount) {
		this.amount = amount;
	}


	public LocalDateTime getDate() {
		return date;
	}


	public void setDate(LocalDateTime date) {
		this.date = date;
	}


	public String getCoupon_name() {
		return coupon_name;
	}


	public void setCoupon_name(String coupon_name) {
		this.coupon_name = coupon_name;
	}


	@Override
	public String toString() {
		return "AllOrdersResponse [orderId=" + orderId + ", amount=" + amount + ", date=" + date + ", coupon_name="
				+ coupon_name + "]";
	}

}
