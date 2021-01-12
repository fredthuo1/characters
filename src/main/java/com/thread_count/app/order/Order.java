package com.thread_count.app.order;

import com.thread_count.app.guest_account.GuestAccount;
import com.thread_count.app.person.Person;
import com.thread_count.app.product.Product;

import javax.persistence.*;
import java.util.Set;

//import javax.persistence.*;
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//
@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @Column(name = "ORDERS_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ACCOUNT_ORDERS", joinColumns = {
            @JoinColumn(referencedColumnName = "ORDERS_ID")
    }, inverseJoinColumns = {@JoinColumn(referencedColumnName = "GUEST_ID")})
    private Set<GuestAccount> guestAccounts;
////    //@ManyToOne
////    //private Person person;
////    //@OneToOne
////    //private Business business;
////    private BigDecimal originalPrice;
////    private BigDecimal totalShippingPrice;
////    private BigDecimal totalTax;
////    private BigDecimal fees;
////    private BigDecimal finalPrice;
//////    private Address shippingAddress;
//////    private Address billingAddress;
////
//
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<GuestAccount> getGuestAccounts() {
        return guestAccounts;
    }

    public void setGuestAccounts(Set<GuestAccount> guestAccounts) {
        this.guestAccounts = guestAccounts;
    }
}
