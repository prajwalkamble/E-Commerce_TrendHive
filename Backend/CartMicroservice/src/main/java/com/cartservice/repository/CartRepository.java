package com.cartservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cartservice.dto.CartVO;
import com.cartservice.entity.CartEntity;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Long> {

	// Search cart products/items by status, i.e., In Stock, Out of Stock
	CartEntity findByStatus(String status);
	
	List<CartVO> findByCartItemId(Long cartItemId);

}
