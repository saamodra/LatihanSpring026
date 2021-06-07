package com.example.latihanspring026.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Orders {
    private int idOrder;
    private String namaCustomer;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderDate;

    private int orderCount;
    private double orderBill;
    private double orderDelivery;
    private double orderTotal;

    public Orders() {
    }

    public Orders(int idOrder, String namaCustomer, Date orderDate, int orderCount, double orderBill, double orderDelivery, double orderTotal) {
        this.idOrder = idOrder;
        this.namaCustomer = namaCustomer;
        this.orderDate = orderDate;
        this.orderCount = orderCount;
        this.orderBill = orderBill;
        this.orderDelivery = orderDelivery;
        this.orderTotal = orderTotal;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public String getNamaCustomer() {
        return namaCustomer;
    }

    public void setNamaCustomer(String namaCustomer) {
        this.namaCustomer = namaCustomer;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    public double getOrderBill() {
        return orderBill;
    }

    public void setOrderBill(double orderBill) {
        this.orderBill = orderBill;
    }

    public double getOrderDelivery() {
        return orderDelivery;
    }

    public void setOrderDelivery(double orderDelivery) {
        this.orderDelivery = orderDelivery;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "idOrder=" + idOrder +
                ", namaCustomer='" + namaCustomer + '\'' +
                ", orderDate=" + orderDate +
                ", orderCount=" + orderCount +
                ", orderBill=" + orderBill +
                ", orderDelivery=" + orderDelivery +
                ", orderTotal=" + orderTotal +
                '}';
    }
}
