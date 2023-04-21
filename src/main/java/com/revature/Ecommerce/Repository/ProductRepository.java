package com.revature.Ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.Ecommerce.Model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
