package com.shop.reqres;


//we get the response in this class format when we create Payment
public class PaymentResponse {
	
	private Integer userId;
	
	private Integer orderId;
	
	private String transactionId;
	
	private String status;
	
	private String description;
	
	
	
	public PaymentResponse() {
		// TODO Auto-generated constructor stub
	}

	public PaymentResponse(Integer userId, Integer orderId, String transactionId, String status, String description) {
		super();
		this.userId = userId;
		this.orderId = orderId;
		this.transactionId = transactionId;
		this.status = status;
		this.description = description;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
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
		return "PaymentResponse [userId=" + userId + ", orderId=" + orderId + ", transactionId=" + transactionId
				+ ", status=" + status + ", description=" + description + "]";
	}
	
}
