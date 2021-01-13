package com.thread_count.app.register.seller;

import javax.persistence.*;

@Entity
@Table(name = "SELLER_REGISTRATION")
public class SellerRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SELLER_REGISTRATION_ID")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
