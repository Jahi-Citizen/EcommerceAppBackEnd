package com.revature.Ecommerce.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.Ecommerce.Model.Cart;
import com.revature.Ecommerce.Model.Product;
import com.revature.Ecommerce.Model.User;
import com.revature.Ecommerce.Repository.CartRepository;

@Service
public class CartService {

    //Dependency Injection/ IOC 
    @Autowired
    CartRepository cartRepo; 

    //Method to create a create a new cart attached to the current/given user 
    @Transactional
    public String createCart(User user) 
    {
    Cart cart = new Cart();

    cart.setUser(user);

    cartRepo.save(cart);

    return "New cart created";
    }


    //TODO: Add error/exception handling 
    @Transactional
    public String addToCart(Long cartID, Long productId)
    {
        Cart cart = cartRepo.findById(cartID).orElse(null);
        if (cart == null) {
            return "Error: Cart not found";
        }
        List<Long> productIds = cart.getProductIds();
        productIds.add(productId);
        cart.setProductIds(productIds);
        cartRepo.save(cart);
        return "Success! Product added to cart";
    }
    
}


    //TODO: Method to remove products from a cart 


    //TODO: Method to delete a cart

    

