package com.mtit.microservices.orderservice.orderserviceimplement.model;

import javax.persistence.*;

@Entity
@Table(name="order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="order_name")
    private String orderName;

    @Column(name="order_type")
    private String orderType;

    @Column(name="order_details")
    private String orderDetails;

    @Column(name="order_date")
    private String orderDate;


    public Order() {
        super();
    }

    public Order(long id, String orderName, String orderType, String orderDetails, String orderDate) {
        super();
        this.id = id;
        this.orderName = orderName;
        this.orderType = orderType;
        this.orderDetails = orderDetails;
        this.orderDate = orderDate;
    }

    public long getid() {
        return id;
    }

    public void setid(long id) {
        this.id = id;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}
