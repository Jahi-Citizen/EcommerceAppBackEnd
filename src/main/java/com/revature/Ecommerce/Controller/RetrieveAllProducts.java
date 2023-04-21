package com.revature.Ecommerce.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.Ecommerce.Model.Product;
import com.revature.Ecommerce.Service.ProductService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Product Catalog")
public class RetrieveAllProducts {

    //Dependency injection / IOC principle 
    @Autowired
    ProductService productServ; 

    @GetMapping("/productCatalog")
    public ResponseEntity<List<Product>> findAllProducts()
    {
        List<Product> products = productServ.getAllProducts();
        return ResponseEntity.ok(products);
    } 
    
}
