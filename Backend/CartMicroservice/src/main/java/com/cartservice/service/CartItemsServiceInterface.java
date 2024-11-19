package com.cartservice.service;

import java.util.List;

import com.cartservice.dto.CartItemsRequest;
import com.cartservice.dto.CartItemsVO;
import com.cartservice.exception.CartItemsExceptionCustom;

public interface CartItemsServiceInterface {

	CartItemsVO saveCartItem(CartItemsRequest cartItemsRequest) throws CartItemsExceptionCustom;

  CartItemsVO updateCartItem(Long cartItemId, CartItemsRequest cartItemsRequest) throws CartItemsExceptionCustom;

  CartItemsVO getCartItemById(Long cartItemId) throws CartItemsExceptionCustom;

  List<CartItemsVO> getCartItemsByCartId(Long cartId) throws CartItemsExceptionCustom;

  void deleteCartItem(Long cartItemId) throws CartItemsExceptionCustom;
}
