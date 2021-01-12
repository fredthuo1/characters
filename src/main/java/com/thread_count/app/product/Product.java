package com.thread_count.app.product;

//import com.thread_count.app.order.Order;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thread_count.app.cart.Cart;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;

@Entity
@Table( name = "PRODUCT" )
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCT_ID")
    private int id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "SIZE")
    private String size;
    @Column(name = "COLOR")
    private String color;
    @Column(name = "MATERIAL")
    private String material;
    @Column(name = "IMAGES")
    private ArrayList<byte[]> images;
    @Column(name = "ORIGINAL_PRICE")
    private BigDecimal originalPrice;
    @Column(name = "DISCOUNT_PRICE")
    private BigDecimal discountPrice;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CART_ID")
    private Cart cart;

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public ArrayList<byte[]> getImages() {
        return images;
    }

    public void setImages(ArrayList<byte[]> images) {
        this.images = images;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    //    public Order getOrder() {
//        return order;
//    }
//
//    public void setOrder(Order order) {
//        this.order = order;
//    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", material='" + material + '\'' +
                ", images=" + images +
                ", originalPrice=" + originalPrice +
                ", discountPrice=" + discountPrice +
//                ", order=" + order +
                '}';
    }
}
