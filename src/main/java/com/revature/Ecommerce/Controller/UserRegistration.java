package com.revature.Ecommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.Ecommerce.Model.User;
import com.revature.Ecommerce.Service.CartService;
import com.revature.Ecommerce.Service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@Tag(name = "Registration")
public class UserRegistration {

    @Autowired
    private UserService userServ;
    
    @Autowired
    private CartService cartServ; 

    @PostMapping("/register")
    @Operation(summary = "Registers a user", description = "This endpoint is used to register a new user.")
    public ResponseEntity<String> registerUser(@RequestBody User user)
    {
        String response = userServ.saveUser(user);
        HttpStatus status = HttpStatus.OK;

        if (response.startsWith("Email address")) {
            status = HttpStatus.CONFLICT;
        } else if (response.startsWith("Error")) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }


        // cartServ.createCart(user); TODO: Add cart init for portfolio purposes 
        return ResponseEntity.status(status).body(response);
    }
    
}
