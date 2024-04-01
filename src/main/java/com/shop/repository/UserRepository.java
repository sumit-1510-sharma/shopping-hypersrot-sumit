package com.shop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.modal.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findById(Integer userId);
}