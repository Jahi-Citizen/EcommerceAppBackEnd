package com.revature.Ecommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.Ecommerce.Model.Product;
import com.revature.Ecommerce.Service.AddProductService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Add products to the database(Security & Validation pending)")
public class AddProducts {

    @Autowired
    AddProductService addProductServ; 

    //Method to add products to the database 
    @PostMapping("/addProduct")
    public ResponseEntity<String> addProduct(@RequestBody Product product)
    {
        String response = addProductServ.addProduct(product);
        HttpStatus status = HttpStatus.OK;

        if (response.startsWith("Validation"))
        {
            status = HttpStatus.BAD_REQUEST;
        }
        else if (response.startsWith("Internal"))
        {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return ResponseEntity.status(status).body(response);

    }
    
}
