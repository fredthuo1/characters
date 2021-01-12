package com.thread_count.app.cart;

import com.thread_count.app.product.Product;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "CARTS")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CART_ID")
    private int id;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private Set<Product> products;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "NUMBER_OF_PRODUCTS")
    private int numberOfProducts;
    @Column(name = "ORIGINAL_PRICE")
    private BigDecimal totalOriginalPrice;
    @Column(name = "SHIPPING_PRICE")
    private BigDecimal totalShippingCost;
    @Column(name = "TRANSACTION_FEE")
    private BigDecimal transactionCost;
    @Column(name = "TOTAL_AMOUNT")
    private BigDecimal totalAmount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNumberOfProducts() {
        return numberOfProducts;
    }

    public void setNumberOfProducts(int numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }

    public BigDecimal getTotalOriginalPrice() {
        return totalOriginalPrice;
    }

    public void setTotalOriginalPrice(BigDecimal totalOriginalPrice) {
        this.totalOriginalPrice = totalOriginalPrice;
    }

    public BigDecimal getTotalShippingPrice() {
        return totalShippingCost;
    }

    public void setTotalShippingPrice(BigDecimal totalShippingPrice) {
        this.totalShippingCost = totalShippingCost;
    }

    public BigDecimal getTransactionCost() {
        return transactionCost;
    }

    public void setTransactionCost(BigDecimal transactionPrice) {
        this.transactionCost = transactionCost;
    }

    public BigDecimal getTotalCost() {
        return totalAmount;
    }

    public void setTotalCost (BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", products=" + products +
                ", status='" + status + '\'' +
                ", numberOfProducts=" + numberOfProducts +
                ", totalOriginalPrice=" + totalOriginalPrice +
                ", totalShippingPrice=" + totalShippingCost +
                ", transactionPrice=" + transactionCost +
                ", totalFee=" + totalAmount +
                '}';
    }
}
