package com.cartservice.service;

import java.util.List;

import com.cartservice.dto.CartItemsVO;
import com.cartservice.dto.CartRequest;
import com.cartservice.dto.CartVO;
import com.cartservice.exception.CartExceptionCustom;

public interface CartServiceInterface {
	
	CartVO saveCart(CartRequest cartRequest) throws CartExceptionCustom;

  CartVO updateCart(Long cartId, CartRequest cartRequest) throws CartExceptionCustom;

  CartVO getCartById(Long cartId) throws CartExceptionCustom;

  List<CartItemsVO> getAllItemsByCartItemId(Long CartItemId) throws CartExceptionCustom;

  void deleteCart(Long cartId) throws CartExceptionCustom;
}
