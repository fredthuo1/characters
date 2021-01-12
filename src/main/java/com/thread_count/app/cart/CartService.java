package com.thread_count.app.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    final private CartRepo cartRepo;

    public CartService(CartRepo cartRepo) {
        this.cartRepo = cartRepo;
    }

    // Get All Carts
    public List<Cart> cartList() {
        if (cartRepo.findAll().size() > 0) {
            return cartRepo.findAll();
        } else {
            return new ArrayList<Cart>();
        }
    }

    // Save An Account
    public Cart addCart(Cart cart) {
        return cartRepo.save(cart);
    }

    // Get Cart By Id
    public Cart getCart(int id) {
        Optional<Cart> cartOption = cartRepo.findById(id);
        if (cartOption.isPresent()) {
            Cart cart = cartOption.get();
            return cart;
        } else {
            return null;
        }
    }

    // Delete Cart
    public void deleteCart(int id) {
        Optional<Cart> optionalCart = cartRepo.findById(id);
        if (optionalCart.isPresent()) {
            cartRepo.delete(optionalCart.get());
        }
    }

    // Edit Cart
    public Cart editCart(Cart cart) {
        Optional<Cart> optionalCart = cartRepo.findById(cart.getId());
        if (optionalCart.isPresent()) {
            Cart tempCart = optionalCart.get();
            tempCart.setId(cart.getId());
            tempCart.setEmail(cart.getEmail());
            tempCart.setPhoneNumber(cart.getPhoneNumber());
            tempCart.setProducts(cart.getProducts());
            tempCart.setStatus(cart.getStatus());
            tempCart.setNumberOfProducts(cart.getNumberOfProducts());
            tempCart.setTotalOriginalPrice(cart.getTotalOriginalPrice());
            tempCart.setTotalShippingPrice(cart.getTotalShippingPrice());
            tempCart.setTransactionCost(cart.getTransactionCost());
            tempCart.setTotalCost(cart.getTotalCost());
            tempCart = cartRepo.save(tempCart);
            return tempCart;
        } else {
            cart = cartRepo.save(cart);
            return cart;
        }
    }
}
