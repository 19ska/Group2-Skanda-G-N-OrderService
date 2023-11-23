package com.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

	List<Cart> findByUserId(Long userId);
    // Add custom queries if needed
	
}
