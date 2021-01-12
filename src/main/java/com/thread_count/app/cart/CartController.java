package com.thread_count.app.cart;

import com.thread_count.app.guest_account.GuestAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CartController {

    @Autowired
    final private CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @RequestMapping(value = "/getAllCarts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Cart> cartArrayList() {
        return (ArrayList<Cart>) cartService.cartList();
    }

    @RequestMapping(value = "addCart", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Cart> addCart(@RequestBody Cart cart) {
        cartService.addCart(cart);
        return new ResponseEntity<Cart>(cart, HttpStatus.CREATED);
    }

    // Delete
    @RequestMapping(value = "deleteCart", method = {RequestMethod.GET, RequestMethod.POST})
    public void deleteCart(@RequestParam int id) {
        cartService.deleteCart(id);
    }

    // Get Guest Account
    @RequestMapping( value = "/getCart", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cart> getCart(@RequestParam int id) {
        Cart cart = cartService.getCart(id);
        return new ResponseEntity<Cart>(cart, HttpStatus.OK);
    }

    // Edit Guest Account
    @RequestMapping( value = "/updateCart", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cart> editCart(@RequestBody Cart cart) {
        cartService.editCart(cart);
        return new ResponseEntity<Cart>(cart, HttpStatus.OK);
    }

}
