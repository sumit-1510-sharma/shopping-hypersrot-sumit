package com.shop.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String product_name;
	
	private Integer price;
	
	private Integer ordered;                            // this value changes if we order some
	                                                    // quantity of the product
	
	private Integer available;
	
	
	
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(Integer id, String product_name, Integer price, Integer ordered, Integer available) {
		super();
		this.id = id;
		this.product_name = product_name;
		this.price = price;
		this.ordered = ordered;
		this.available = available;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getOrdered() {
		return ordered;
	}

	public void setOrdered(Integer ordered) {
		this.ordered = ordered;
	}

	public Integer getAvailable() {
		return available;
	}

	public void setAvailable(Integer available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", product_name=" + product_name + ", price=" + price + ", ordered=" + ordered
				+ ", available=" + available + "]";
	}
	
	
	
}
