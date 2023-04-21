package com.revature.Ecommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.Ecommerce.Model.Product;
import com.revature.Ecommerce.Service.CartService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Adding products to a cart")
public class AddToCart {

    //Dependency injection-Service level 
    @Autowired
    CartService cartServ; 

    @PostMapping("/carts/{cartID}/products/{productId}")
    public ResponseEntity<String> addToCart(@PathVariable Long cartID, @PathVariable Long productId) {
        String message = cartServ.addToCart(cartID, productId);
        return ResponseEntity.ok(message);
    }
    
}
