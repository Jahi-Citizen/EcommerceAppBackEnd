package com.revature.Ecommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.Ecommerce.Model.Order;
import com.revature.Ecommerce.Service.OrderService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Submit an order of products within a given cart")
public class SubmitOrder {

    @Autowired
    OrderService orderServ; 

    @PostMapping("/submit")
    public ResponseEntity<String> submitOrder(@RequestBody Order order) {
        try {
            orderServ.submitOrder(order);
            return ResponseEntity.ok("Order submitted successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
}
