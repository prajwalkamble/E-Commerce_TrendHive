package com.cartservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cartservice.dto.CartItemsRequest;
import com.cartservice.dto.CartItemsVO;
import com.cartservice.exception.CartItemsExceptionCustom;
import com.cartservice.service.CartItemsServiceInterface;

@RestController
@RequestMapping("/api/v1/cart")
public class CartMSController {

	private static final Logger Log = LoggerFactory.getLogger(CartMSController.class);
	
	@Autowired
	private CartItemsServiceInterface cartService;
	
	public CartMSController(CartItemsServiceInterface cartService) {
    this.cartService = cartService;
	}
	
	@PostMapping
	@Validated
  public ResponseEntity<CartItemsVO> saveCartItem(@RequestBody CartItemsRequest cartItemsRequest) {
      try {
          CartItemsVO cartItemsVO = cartService.saveCartItem(cartItemsRequest);
          return new ResponseEntity<>(cartItemsVO, HttpStatus.CREATED);
      } catch (CartItemsExceptionCustom e) {
          return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
      }
  }

  @PutMapping("/{cartItemId}")
  @Validated
  public ResponseEntity<CartItemsVO> updateCartItem(@PathVariable Long cartItemId, 
                                                    @RequestBody CartItemsRequest cartItemsRequest) {
      try {
          CartItemsVO updatedCartItem = cartService.updateCartItem(cartItemId, cartItemsRequest);
          return new ResponseEntity<>(updatedCartItem, HttpStatus.OK);
      } catch (CartItemsExceptionCustom e) {
          return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
      }
  }

  @GetMapping("/{cartItemId}")
  public ResponseEntity<CartItemsVO> getCartItemById(@PathVariable Long cartItemId) {
      try {
          CartItemsVO cartItemsVO = cartService.getCartItemById(cartItemId);
          return new ResponseEntity<>(cartItemsVO, HttpStatus.OK);
      } catch (CartItemsExceptionCustom e) {
          return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
      }
  }

  @GetMapping("/cart/{cartId}")
  public ResponseEntity<List<CartItemsVO>> getCartItemsByCartId(@PathVariable Long cartId) {
      try {
          List<CartItemsVO> cartItems = cartService.getCartItemsByCartId(cartId);
          return new ResponseEntity<>(cartItems, HttpStatus.OK);
      } catch (CartItemsExceptionCustom e) {
          return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
      }
  }

  @DeleteMapping("/{cartItemId}")
  public ResponseEntity<String> deleteCartItem(@PathVariable Long cartItemId) {
      try {
          cartService.deleteCartItem(cartItemId);
          return new ResponseEntity<>("Cart item deleted successfully", HttpStatus.NO_CONTENT);
      } catch (CartItemsExceptionCustom e) {
          return new ResponseEntity<>("Cart item not found", HttpStatus.NOT_FOUND);
      }
  }
}
