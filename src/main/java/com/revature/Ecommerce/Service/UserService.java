package com.revature.Ecommerce.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


import com.revature.Ecommerce.Model.User;
import com.revature.Ecommerce.Repository.UserRepository;



@Service
public class UserService {

    //Dependency injection/IOC 
    @Autowired
    private UserRepository userRepo; 
    
    //Method to allow basic registration 
    public String saveUser(User user)
    {
        try 
        {
            if(userRepo.findByEmail(user.getEmail()) != null || userRepo.findByUsername(user.getUsername()) != null)
            {   
                return "Email address or username already exists!";

            }else 
            {  
                userRepo.save(user);
                return "Success! User saved";

            }
        } catch(DataIntegrityViolationException e)
        {
            return "Error saving user: " + e.getMessage();
        }
    }

    //Basic login functionality..checks for valid username and a password matching said username 
    public String loginUser(User user)
    {
        try 
        {
            User retrievedUser = userRepo.findByUsername(user.getUsername());
            if (retrievedUser == null)
            {
                return "User does not exist!";
            }
            if (!retrievedUser.getPassword().equals(user.getPassword()))
            {
                return "Incorrect password!";
            }
            return "Login successful!";
        }catch (Exception e)
            {
                return "Error: " + e.getMessage();
            }
    }

    //TODO: Add password reset

    //TODO: Add username reset

    //TODO: Add email confirmation 
    }

