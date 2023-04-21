package com.revature.Ecommerce.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.Ecommerce.Model.Order;
import com.revature.Ecommerce.Repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepo;

   //Method to submit an order 
    public String submitOrder(Order order) 
    {

    if (order.getUser() == null || order.getCart() == null || order.getPaymentInfo() == null || order.getShippingAddress() == null) 
    {
        return "Error: Order information incomplete";
    }
    
    try 
    {
        orderRepo.save(order);
        return "Success! Order received";
    } catch (Exception e) 
    {
        return "Error: Failed to save order";
    }
}


    
    
}
