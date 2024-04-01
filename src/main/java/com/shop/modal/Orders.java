package com.shop.modal;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

@Entity
public class Orders {                                 // I named this class as "Orders" and not "Order"
													  // because Order is already a keyword in SQL and JPA 
													  // was causing error due to this.
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private Integer productId;

	private String transaction_id;
	
	private LocalDateTime date;
	
	private Integer quantity;
	
	private Integer amount;
	
	private String couponName;
	
	private String status;
	
	private String description;
	
	@Column(name="ordered_by")               // this field is necessary, so that we can search the 
	private Integer orderedBy;				 // orders made by a particular user only

	
	
	
	public Orders() {
		// TODO Auto-generated constructor stub
	}

	@PrePersist
    public void generateTransactionId() {
        if (this.transaction_id == null) {
            // Generate a unique transaction_id (e.g., using UUID)
            this.transaction_id = UUID.randomUUID().toString();
        }
    }

	public Orders(Integer id, Integer productId, String transaction_id, LocalDateTime date, Integer quantity,
			Integer amount, String couponName, String status, String description, Integer orderedBy) {
		super();
		this.id = id;
		this.productId = productId;
		this.transaction_id = transaction_id;
		this.date = date;
		this.quantity = quantity;
		this.amount = amount;
		this.couponName = couponName;
		this.status = status;
		this.description = description;
		this.orderedBy = orderedBy;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
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

	public String getCouponName() {
		return couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
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

	public Integer getOrderedBy() {
		return orderedBy;
	}

	public void setOrderedBy(Integer orderedBy) {
		this.orderedBy = orderedBy;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", productId=" + productId + ", transaction_id=" + transaction_id + ", date=" + date
				+ ", quantity=" + quantity + ", amount=" + amount + ", couponName=" + couponName + ", status=" + status
				+ ", description=" + description + ", orderedBy=" + orderedBy + "]";
	}

}
