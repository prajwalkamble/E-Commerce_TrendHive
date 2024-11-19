package com.cartservice.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cartservice.dto.CartItemsRequest;
import com.cartservice.dto.CartItemsVO;
import com.cartservice.entity.CartEntity;
import com.cartservice.entity.CartItemsEntity;
import com.cartservice.exception.CartItemsExceptionCustom;
import com.cartservice.repository.CartItemsRepository;
import com.cartservice.repository.CartRepository;
import com.productservice.dto.ProductVO;
import com.productservice.entity.ProductEntity;
import com.productservice.repository.ProductRepository;

@Service
public class CartItemsServiceImpl implements CartItemsServiceInterface {
	
	@Autowired
	private CartItemsRepository cartItemsRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	private static final Logger Log = LoggerFactory.getLogger(CartItemsServiceImpl.class);

	@Override
	public CartItemsVO saveCartItem(CartItemsRequest cartItemsRequest) throws CartItemsExceptionCustom {
		Log.info("Saving cart item for Cart ID: {}", cartItemsRequest.getCartId());
    
    // Validate associated Cart
    Optional<CartEntity> cart = cartRepository.findById(cartItemsRequest.getCartId());
    if (!cart.isPresent()) {
        Log.error("Cart with ID {} not found.", cartItemsRequest.getCartId());
        throw new CartItemsExceptionCustom("Cart with ID " + cartItemsRequest.getCartId() + " not found.");
    }

    // Validate associated Product
    Optional<ProductEntity> product = productRepository.findById(cartItemsRequest.getProductId());
    if (!product.isPresent()) {
        Log.error("Product with ID {} not found.", cartItemsRequest.getProductId());
        throw new CartItemsExceptionCustom("Product with ID " + cartItemsRequest.getProductId() + " not found.");
    }

    // Create new CartItemsEntity
    CartItemsEntity cartItem = new CartItemsEntity();
    cartItem.setCart(cart.get());
    cartItem.setUserId(cartItemsRequest.getUserId());
    cartItem.setProduct(product.get());
    cartItem.setQuantity(cartItemsRequest.getQuantity());
    cartItem.setCartItemPrice(cartItemsRequest.getCartItemPrice());

    CartItemsEntity savedCartItem = cartItemsRepository.save(cartItem);

    return mapToVO(savedCartItem);
	}

	@Override
	public CartItemsVO updateCartItem(Long cartItemId, CartItemsRequest cartItemsRequest) throws CartItemsExceptionCustom {
		 Log.info("Updating cart item with ID: {}", cartItemId);

     Optional<CartItemsEntity> cartItemOpt = cartItemsRepository.findById(cartItemId);
     if (!cartItemOpt.isPresent()) {
         Log.error("Cart item with ID {} not found.", cartItemId);
         throw new CartItemsExceptionCustom("Cart item with ID " + cartItemId + " not found.");
     }

     CartItemsEntity cartItem = cartItemOpt.get();
     cartItem.setQuantity(cartItemsRequest.getQuantity());
     cartItem.setCartItemPrice(cartItemsRequest.getCartItemPrice());

     CartItemsEntity updatedCartItem = cartItemsRepository.save(cartItem);

     return mapToVO(updatedCartItem);
	}

	@Override
	public CartItemsVO getCartItemById(Long cartItemId) throws CartItemsExceptionCustom {
		Log.info("Fetching cart item with ID: {}", cartItemId);

    Optional<CartItemsEntity> cartItemOpt = cartItemsRepository.findById(cartItemId);
    if (!cartItemOpt.isPresent()) {
        Log.error("Cart item with ID {} not found.", cartItemId);
        throw new CartItemsExceptionCustom("Cart item with ID " + cartItemId + " not found.");
    }

    return mapToVO(cartItemOpt.get());
	}

	@Override
	public List<CartItemsVO> getCartItemsByCartId(Long cartId) throws CartItemsExceptionCustom {
		Log.info("Fetching all cart items for Cart ID: {}", cartId);

    List<CartItemsEntity> cartItems = cartItemsRepository.findAll()
        .stream()
        .filter(item -> item.getCart().getCartId().equals(cartId))
        .collect(Collectors.toList());

    return cartItems.stream()
        .map(this::mapToVO)
        .collect(Collectors.toList());
	}

	@Override
	public void deleteCartItem(Long cartItemId) throws CartItemsExceptionCustom {
		Log.info("Deleting cart item with ID: {}", cartItemId);

    if (!cartItemsRepository.existsById(cartItemId)) {
        Log.error("Cart item with ID {} not found.", cartItemId);
        throw new CartItemsExceptionCustom("Cart item with ID " + cartItemId + " not found.");
    }

    cartItemsRepository.deleteById(cartItemId);
	}
	
	 CartItemsVO mapToVO(CartItemsEntity cartItem) {
     CartItemsVO cartItemsVO = new CartItemsVO();
     cartItemsVO.setCartItemId(cartItem.getCartItemId());
     cartItemsVO.setCartId(cartItem.getCart().getCartId());
     cartItemsVO.setUserId(cartItem.getUserId());
     cartItemsVO.setQuantity(cartItem.getQuantity());
     cartItemsVO.setCartItemPrice(cartItem.getCartItemPrice());

     // Mapping product details if present
     if (cartItem.getProduct() != null) {
         ProductEntity product = cartItem.getProduct();
         cartItemsVO.setProduct(new ProductVO(
             product.getProductId(),
             product.getProductName(),
             product.getProductPrice(),
             product.getProductCategory()
         ));
     }

     return cartItemsVO;
	 }
}
