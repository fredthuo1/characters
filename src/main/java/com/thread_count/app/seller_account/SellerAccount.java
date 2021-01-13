package com.thread_count.app.seller_account;

import javax.persistence.*;

@Entity
@Table(name = "SELLER_ACCOUNT")
public class SellerAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SELLER_ID")
    private int id;
}
