package com.shop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.modal.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	Optional<Product> findById(Integer product_id);
}
