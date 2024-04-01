package com.shop.reqres;

public class CreateProductRequest {

	private String product_name;
	
	private Integer price;
	
	private Integer available;
	
	public CreateProductRequest() {
		// TODO Auto-generated constructor stub
	}

	public CreateProductRequest(String product_name, Integer price, Integer available) {
		super();
		this.product_name = product_name;
		this.price = price;
		this.available = available;
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

	public Integer getAvailable() {
		return available;
	}

	public void setAvailable(Integer available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "CreateProductRequest [product_name=" + product_name + ", price=" + price + ", available=" + available
				+ "]";
	}
	
	
}
