package com.revature.Ecommerce.Model;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;
    
    @Column(name = "payment_info")
    private String paymentInfo;
    
    @Column(name = "shipping_address")
    private String shippingAddress;
    
    //Constructors, getters, and setters
    
    public Order() {
        super();
    }

    public Order(User user, Cart cart, String paymentInfo, String shippingAddress) {
        super();
        this.user = user;
        this.cart = cart;
        this.paymentInfo = paymentInfo;
        this.shippingAddress = shippingAddress;
    }
    
    //Getters and Setters
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(String paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}