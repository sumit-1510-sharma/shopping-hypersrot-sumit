package com.shop.reqres;

import java.time.LocalDateTime;


//we get the response in this class format when we try to find a particular order made by a particular User.
public class OrderIdResponse {

	private Integer orderId;
	
	private Integer amount;
	
	private LocalDateTime date;
	
	private String coupon_name;
	
	private String transaction_id;
	
	private String status;
	
	private String description;
	
	
	public OrderIdResponse() {
		// TODO Auto-generated constructor stub
	}

	public OrderIdResponse(Integer orderId, Integer amount, LocalDateTime date, String coupon_name,
			String transaction_id, String status, String description) {
		super();
		this.orderId = orderId;
		this.amount = amount;
		this.date = date;
		this.coupon_name = coupon_name;
		this.transaction_id = transaction_id;
		this.status = status;
		this.description = description;
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

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "OrderIdResponse [orderId=" + orderId + ", amount=" + amount + ", date=" + date + ", coupon_name="
				+ coupon_name + ", transaction_id=" + transaction_id + ", status=" + status + ", description="
				+ description + "]";
	}

}
