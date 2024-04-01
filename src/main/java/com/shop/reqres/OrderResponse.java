package com.shop.reqres;


// we get the response in this class format when we create any order.
public class OrderResponse {

	private Integer orderId;
	
	private Integer userId;
	
	private Integer quantity;
	
	private Integer amount;
	
	private String coupon_name;
	
	
	public OrderResponse() {
		// TODO Auto-generated constructor stub
	}


	public OrderResponse(Integer orderId, Integer userId, Integer quantity, Integer amount, String coupon_name) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.quantity = quantity;
		this.amount = amount;
		this.coupon_name = coupon_name;
	}


	public Integer getOrderId() {
		return orderId;
	}


	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public Integer getAmount() {
		return amount;
	}


	public void setAmount(Integer amount) {
		this.amount = amount;
	}


	public String getCoupon_name() {
		return coupon_name;
	}


	public void setCoupon_name(String coupon_name) {
		this.coupon_name = coupon_name;
	}


	@Override
	public String toString() {
		return "OrderResponse [orderId=" + orderId + ", userId=" + userId + ", quantity=" + quantity + ", amount="
				+ amount + ", coupon_name=" + coupon_name + "]";
	}
	
}
