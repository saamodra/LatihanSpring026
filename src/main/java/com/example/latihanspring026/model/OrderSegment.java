package com.example.latihanspring026.model;


public class OrderSegment {
    private int idOrderSegment;
    private int idOrder;
    private int idMenu;
    private int osCount;
    private double osPrice;
    private String osDetail;
    private Orders order;
    private Menu menu;

    public OrderSegment() {
    }

    public OrderSegment(int idOrderSegment, int idOrder, int idMenu, int osCount, double osPrice, String osDetail) {
        this.idOrderSegment = idOrderSegment;
        this.idOrder = idOrder;
        this.idMenu = idMenu;
        this.osCount = osCount;
        this.osPrice = osPrice;
        this.osDetail = osDetail;
    }

    public int getIdOrderSegment() {
        return idOrderSegment;
    }

    public void setIdOrderSegment(int idOrderSegment) {
        this.idOrderSegment = idOrderSegment;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public int getOsCount() {
        return osCount;
    }

    public void setOsCount(int osCount) {
        this.osCount = osCount;
    }

    public double getOsPrice() {
        return osPrice;
    }

    public void setOsPrice(double osPrice) {
        this.osPrice = osPrice;
    }

    public String getOsDetail() {
        return osDetail;
    }

    public void setOsDetail(String osDetail) {
        this.osDetail = osDetail;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "OrderSegment{" +
                "idOrderSegment=" + idOrderSegment +
                ", idOrder=" + idOrder +
                ", idMenu=" + idMenu +
                ", osCount=" + osCount +
                ", osPrice=" + osPrice +
                ", osDetail='" + osDetail + '\'' +
                '}';
    }
}
