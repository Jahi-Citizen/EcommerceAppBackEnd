package com.revature.Ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.Ecommerce.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    User findByUsernameAndPassword(String username, String password);
    User findByEmail(String email);
    User findByUsername(String username);
}
