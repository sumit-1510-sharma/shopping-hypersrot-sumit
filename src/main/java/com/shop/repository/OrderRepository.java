package com.shop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.modal.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer> {
	
	Optional<Orders> findById(Integer orderId);

	List<Orders> findByOrderedBy(Integer userId);
}
