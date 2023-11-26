package com.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.demo.dto.CartDTO;
import com.demo.services.CartService;
import com.demo.exceptions.*;

import java.util.List;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }
    
    @ExceptionHandler(CartNotFoundException.class)
    public ResponseEntity<String> handleCartNotFoundException(CartNotFoundException e) {
        return ResponseEntity.status(404).body("Cart not found: " + e.getMessage());
    }

    @PostMapping("/{userId}")
    public ResponseEntity<CartDTO> createCart(@PathVariable Long userId, @RequestBody CartDTO cartDTO) {
        return cartService.createCart(userId, cartDTO);
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<CartDTO> getCartById(@PathVariable Long cartId) {
        return cartService.getCartById(cartId);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CartDTO>> getCartsByUserId(@PathVariable Long userId) {
        return cartService.getCartsByUserId(userId);
    }

    @GetMapping
    public ResponseEntity<List<CartDTO>> getAllCarts() {
        return cartService.getAllCarts();
    }

    @PutMapping("/{cartId}")
    public ResponseEntity<Void> updateCart(@PathVariable Long cartId, @RequestBody CartDTO cartDTO) {
        return cartService.updateCart(cartId, cartDTO);
    }

    @DeleteMapping("/{cartId}")
    public ResponseEntity<Void> deleteCart(@PathVariable Long cartId) {
        return cartService.deleteCart(cartId);
    }
}
