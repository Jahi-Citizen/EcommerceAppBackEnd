package com.revature.Ecommerce.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.Ecommerce.Model.Product;
import com.revature.Ecommerce.Repository.ProductRepository;

@Service
public class ProductService {

    //Dependency Injection / IOC principle 
    @Autowired
    private ProductRepository productRepo; 

    //Simple method to retrieve a list of all products in the database for our product catalog page in React 
    public List<Product> getAllProducts() 
    {
        return productRepo.findAll();
    }

    //TODO: Add sorting/filtering methods 

    
}
