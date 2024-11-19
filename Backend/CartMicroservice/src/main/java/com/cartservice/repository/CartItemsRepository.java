package com.cartservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cartservice.entity.CartItemsEntity;

@Repository
public interface CartItemsRepository extends JpaRepository<CartItemsEntity, Long> {

	// Secure query to find a specific product in cart by cartId and productId
	@Query("SELECT ci FROM CartItemsEntity ci WHERE ci.cartId = :cartId AND ci.productId = :productId")
  CartItemsEntity findCartItemByCartIdAndProductId(Long cartId, Long productId);
	
	List<CartItemsEntity> findAllByCartItemId(Long cartItemId);
}
