package com.daily.menu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daily.menu.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> { 
	
}
