package com.thread_count.app.customer_account;

import com.thread_count.app.order.Order;
import com.thread_count.app.person.Person;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CUSTOMER_ACCOUNT")
public class CustomerAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CUSTOMER_ID")
    private int id;
    @OneToOne
    @JoinColumn(name = "CUSTOMER_ACCOUNT_ID")
    private Person person;
//    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
//    private Set<Order> orderSet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
