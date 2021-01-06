package com.thread_count.app.guest_account;

import com.thread_count.app.product.Product;

import javax.persistence.*;

@Entity
@Table(name = "GUEST_ACCOUNT")
public class Guest_Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "GUEST_ID")
    private int Id;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
}
