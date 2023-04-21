package com.revature.Ecommerce.Service;

import java.util.Objects;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.Ecommerce.Model.Product;
import com.revature.Ecommerce.Repository.ProductRepository;

@Service
public class AddProductService {

    //Dependency injection / IOC 
    @Autowired
    ProductRepository productRepo; 

    //Method to create add a new product to the catalog (Should only be accessible by mods or admins )
    //But that validation can be implemented later if deemed neccessary 
    public String addProduct(Product product)
    {
        try 
        {
            //Create product using default constructor 
             Product newProduct = new Product();
            
            //Set the fields of the newProduct using values from the product object 
            if (product.getProductName() != null && !product.getProductName().isEmpty()) 
            {
                newProduct.setProductName(product.getProductName());
            }
            if (product.getProductDescription() != null && !product.getProductDescription().isEmpty()) 
            {
                newProduct.setProductDescription(product.getProductDescription());
            }
            if (!Objects.equals(product.getProductPrice(), null)) 
            {
                newProduct.setProductPrice(product.getProductPrice());
            }
            if (!Objects.equals(product.getProductQuantity(), null)) 
            {
                 newProduct.setProductQuantity(product.getProductQuantity());
            }
            if (product.getProductCategory() != null && !product.getProductCategory().isEmpty()) 
            {
                 newProduct.setProductCategory(product.getProductCategory());
            }
            if (product.getProductBrand() != null && !product.getProductBrand().isEmpty()) 
            {
                newProduct.setProductBrand(product.getProductBrand());
            }
            if (product.getProductImageURL() != null && !product.getProductImageURL().isEmpty()) 
            {
                 newProduct.setProductImageURL(product.getProductImageURL());
            }
           
                   productRepo.save(newProduct);
                   return "Success! Product has been added to the catalog";
        }catch (ConstraintViolationException e)
        {
            System.err.println("Validation error: " + e.getMessage());
            return "Validation error: " + e.getMessage();
        }catch (Exception e)
        {
            return "Internal Server Error, Please contact customer support with this message:" + e.getMessage(); 
        }
        
    }
    
}
