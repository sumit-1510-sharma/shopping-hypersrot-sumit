package com.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shop.exception.ProductException;
import com.shop.modal.Product;
import com.shop.repository.ProductRepository;
import com.shop.reqres.CreateProductRequest;

@Service
public class ProductServiceImplementation implements ProductService {

	private ProductRepository productRepository;
	
	public ProductServiceImplementation(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	

	@Override
	public Product createProduct(CreateProductRequest req) throws ProductException {
		
		Product prod = new Product();
		
		prod.setProduct_name(req.getProduct_name());
		prod.setPrice(req.getPrice());
		prod.setAvailable(req.getAvailable());
		prod.setOrdered(0);
		
		return productRepository.save(prod);
	}
	
	@Override
	public List<Product> getAllProducts() throws ProductException {
		
		List<Product> prods = productRepository.findAll();
		
		return prods;
	}

//	@Override
//	public Product getProductById(Integer productId) throws ProductException {
//		
//		@SuppressWarnings("deprecation")
//		Product prod = productRepository.getById(productId);
//		
//		return prod;
//	}

}
