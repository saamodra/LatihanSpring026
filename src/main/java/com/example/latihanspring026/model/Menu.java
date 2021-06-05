package com.example.latihanspring026.model;

public class Menu {
    private int idMenu;
    private String menuName;
    private String menuCategory;
    private String menuDetail;
    private int harga;
    private int statusBasi;

    public Menu() {
    }

    public Menu(int idMenu, String menuName, String menuCategory, String menuDetail, int harga, int statusBasi) {
        this.idMenu = idMenu;
        this.menuName = menuName;
        this.menuCategory = menuCategory;
        this.menuDetail = menuDetail;
        this.harga = harga;
        this.statusBasi = statusBasi;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuCategory() {
        return menuCategory;
    }

    public void setMenuCategory(String menuCategory) {
        this.menuCategory = menuCategory;
    }

    public String getMenuDetail() {
        return menuDetail;
    }

    public void setMenuDetail(String menuDetail) {
        this.menuDetail = menuDetail;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getStatusBasi() {
        return statusBasi;
    }

    public void setStatusBasi(int statusBasi) {
        this.statusBasi = statusBasi;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "idMenu=" + idMenu +
                ", menuName='" + menuName + '\'' +
                ", menuCategory='" + menuCategory + '\'' +
                ", menuDetail='" + menuDetail + '\'' +
                ", harga=" + harga +
                ", statusBasi=" + statusBasi +
                '}';
    }
}
