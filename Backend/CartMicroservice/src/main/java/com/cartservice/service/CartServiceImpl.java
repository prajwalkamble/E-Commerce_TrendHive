package com.cartservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cartservice.dto.CartItemsVO;
import com.cartservice.dto.CartRequest;
import com.cartservice.dto.CartVO;
import com.cartservice.entity.CartEntity;
import com.cartservice.entity.CartItemsEntity;
import com.cartservice.exception.CartExceptionCustom;
import com.cartservice.repository.CartItemsRepository;
import com.cartservice.repository.CartRepository;

@Service
public class CartServiceImpl implements CartServiceInterface {
	
	@Autowired
	private CartRepository cartRepository;
	
	private static final Logger Log = LoggerFactory.getLogger(CartServiceImpl.class);

	@Override
	public CartVO saveCart(CartRequest cartRequest) {
		Log.info("Creating new cart for user: {}", cartRequest.getCartId());
		CartEntity cart = convertToCartEntity(cartRequest);
		CartEntity savedCart = cartRepository.save(cart);
		return convertToCartVO(savedCart);
	}

	@Override
	public CartVO updateCart(Long cartId, CartRequest cartRequest)  throws CartExceptionCustom {
		Log.info("Updating cart with ID: {}", cartId);
    CartEntity existingCart = null;
		try {
			existingCart = cartRepository.findById(cartId)
			        .orElseThrow(() -> new CartExceptionCustom("Cart not found with ID: " + cartId));
		} catch (CartExceptionCustom e) {
			e.printStackTrace();
		}
    
    existingCart.setTotalQuantity(cartRequest.getTotalQuantity());
    existingCart.setTotalPrice(cartRequest.getTotalPrice());
    existingCart.setStatus(cartRequest.getStatus());

    CartEntity updatedCart = cartRepository.save(existingCart);
    return convertToCartVO(updatedCart);
	}

	@Override
	public CartVO getCartById(Long cartId)  throws CartExceptionCustom {
		Log.info("Fetching cart with ID: {}", cartId);
    CartEntity cart = null;
		try {
			cart = cartRepository.findById(cartId)
			        .orElseThrow(() -> new CartExceptionCustom("Cart not found with ID: " + cartId));
		} catch (CartExceptionCustom e) {
			e.printStackTrace();
		}
    return convertToCartVO(cart);
	}

	@SuppressWarnings("null")
	@Override
	public List<CartItemsVO> getAllItemsByCartItemId(Long CartItemId) throws CartExceptionCustom {
		Log.info("Fetching cart items for CartItemId: {}", CartItemId);

		CartItemsRepository cartItemsRepository = null;
		
    if (CartItemId == null || CartItemId <= 0) {
        throw new CartExceptionCustom("CartItemId cannot be null or negative");
    }

    List<CartItemsEntity> cartItemsEntities = cartItemsRepository.findAllByCartItemId(CartItemId);
    if (cartItemsEntities == null || cartItemsEntities.isEmpty()) {
        throw new CartExceptionCustom("No items found for CartItemId: " + CartItemId);
    }

    return cartItemsEntities.stream().map(cartItemEntity -> {
        CartItemsVO cartItemsVO = new CartItemsVO();
        cartItemsVO.setCartItemId(cartItemEntity.getCartItemId());
        cartItemsVO.setQuantity(cartItemEntity.getQuantity());
        cartItemsVO.setCartItemPrice(cartItemEntity.getCartItemPrice());
        return cartItemsVO;
    }).collect(Collectors.toList());
	}

	@Override
	public void deleteCart(Long cartId)  throws CartExceptionCustom {
		Log.info("Deleting cart with ID: {}", cartId);
    if (!cartRepository.existsById(cartId)) {
        throw new CartExceptionCustom("Cart not found with ID: " + cartId);
    }
    cartRepository.deleteById(cartId);
    Log.info("Cart with ID {} deleted successfully", cartId);
	}
	
	// Helper method to map Cart Request to Cart Entity
	private CartEntity convertToCartEntity(CartRequest cartRequest) {
		CartEntity cart = new CartEntity();
    cart.setTotalQuantity(cartRequest.getTotalQuantity());
    cart.setTotalPrice(cartRequest.getTotalPrice());
    cart.setStatus(cartRequest.getStatus());
		return cart;
	}
	
	// Helper method to map Cart Entity to CartVO
	private CartVO convertToCartVO(CartEntity cartEntity) {
		CartVO cartVO = new CartVO();
		cartVO.setCartId(cartEntity.getCartId());
    cartVO.setTotalQuantity(cartEntity.getTotalQuantity());
    cartVO.setTotalPrice(cartEntity.getTotalPrice());
    cartVO.setStatus(cartEntity.getStatus());
    cartVO.setCreatedDate(cartEntity.getCreatedDate());
    cartVO.setUpdatedDate(cartEntity.getUpdatedDate());
    return cartVO;
	}
}
