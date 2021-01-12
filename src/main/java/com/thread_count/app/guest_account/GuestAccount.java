package com.thread_count.app.guest_account;

import com.thread_count.app.product.Product;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "GUEST_ACCOUNT")
public class GuestAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "GUEST_ID")
    private int Id;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "MIDDLE_NAME")
    private String middleName;
    @Column(name = "LAST_NAME")
    private String lastName;
//    @Column(name = "ORDER")
//    private Order[] orders;
//    @Column(name = "CARTS")
//    private Cart[] cars;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //    public Order[] getOrders() {
//        return orders;
//    }
//
//    public void setOrders(Order[] orders) {
//        this.orders = orders;
//    }
//
//    public Cart[] getCars() {
//        return cars;
//    }
//
//    public void setCars(Cart[] cars) {
//        this.cars = cars;
//    }

    @Override
    public String toString() {
        return "GuestAccount{" +
                "Id=" + Id +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
