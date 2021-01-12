//package com.thread_count.app.order;
//
//import com.thread_count.app.person.Person;
//import com.thread_count.app.product.Product;
//
//import javax.persistence.*;
//import java.math.BigDecimal;
//import java.util.Set;
//
//@Entity
//@Table(name = "ORDER")
//public class Order {
//    @Id
//    @Column(name = "ORDER_ID")
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private int id;
//   // @OneToMany(cascade = CascadeType.ALL)
//    //@JoinTable(name = "PRODUCT_ID", joinColumns = {@JoinColumn(name = "ORDER_ID", referencedColumnName = "ID")})
//    //private Set<Product> products;
//    //@ManyToOne
//    //private Person person;
//    //@OneToOne
//    //private Business business;
//    private BigDecimal originalPrice;
//    private BigDecimal totalShippingPrice;
//    private BigDecimal totalTax;
//    private BigDecimal fees;
//    private BigDecimal finalPrice;
////    private Address shippingAddress;
////    private Address billingAddress;
//
//}
