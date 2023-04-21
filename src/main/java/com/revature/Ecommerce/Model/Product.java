package com.revature.Ecommerce.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "products")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productID;

    @NonNull
    @Column(unique = false)
    @Size(min = 1, max = 255)
    private String productName; 
    private String productDescription;

    //this tag ensures that we won't have negative values 
    @Min(0)
    private int productPrice;
    
    @Min(0)
    private int productQuantity;

    @Size(max = 50 )
    private String productCategory; 

    @Size(max = 50)
    private String productBrand; 

    private String productImageURL;

    //Default constructor to ensure that products are properly init 
    public Product()
    {
        this.productName = "default name";
        this.productDescription= "default description";
        this.productBrand = "default brand";
        this.productCategory = "default category";
        this.productImageURL = "https://via.placeholder.com/150x150?text=Shopping+Bag";
        this.productPrice = 10;
        this.productQuantity = 200;
    }
    
}
