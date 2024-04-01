package com.shop.service;

import java.util.List;

import com.shop.exception.ProductException;
import com.shop.modal.Product;
import com.shop.reqres.CreateProductRequest;

public interface ProductService {
	
	public Product createProduct(CreateProductRequest req) throws ProductException;
	
	public List<Product> getAllProducts() throws ProductException;
	
//	public Product getProductById(Integer productId) throws ProductException;
}
