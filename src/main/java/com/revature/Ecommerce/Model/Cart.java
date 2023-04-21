package com.revature.Ecommerce.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "carts")
@Getter 
@Setter 
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long cartID; 

   @NonNull
   private String cartName; 

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "userID")
   private User user;

   @ElementCollection
    private List<Long> productIds = new ArrayList<>();

    @OneToMany(mappedBy = "cart")
    private List<Order> orders;

    
}
