package com.shop.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shop.exception.ProductException;
import com.shop.modal.Product;
import com.shop.reqres.CreateProductRequest;
import com.shop.service.ProductService;

@RestController
public class ProductController {
	
	private ProductService productService;
	
	public ProductController(ProductService productService) {               //Constructor Injection because it is faster
		this.productService = productService;
	}
	
	
	@PostMapping("/product/create")
	public ResponseEntity<Product> createProductHandler(@RequestBody CreateProductRequest req) throws ProductException {
		
		Product prod = productService.createProduct(req);
		
		return new ResponseEntity<Product>(prod,HttpStatus.ACCEPTED);
		
	}
		
	@GetMapping("/inventory")
	public ResponseEntity<List<Product>> getAllProductsHandler() throws ProductException {
		
		List<Product> products = productService.getAllProducts();
		
		return new ResponseEntity<List<Product>>(products,HttpStatus.ACCEPTED);
	}

}
