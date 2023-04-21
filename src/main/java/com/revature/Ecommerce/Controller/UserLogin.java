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


import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Login")
public class UserLogin {

    //Dependency injection/ IOC 
    @Autowired
    UserService userServ;

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user)
    {
        String response = userServ.loginUser(user);
        HttpStatus status = HttpStatus.OK;

        if (response.startsWith("User"))
        {
            status = HttpStatus.BAD_REQUEST;
        }
        else if (response.startsWith("Incorrect"))
        {
            status = HttpStatus.BAD_REQUEST;
        }
        else if (response.startsWith("Error"))
        {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }


        return ResponseEntity.status(status).body(response);
    }
    
}
