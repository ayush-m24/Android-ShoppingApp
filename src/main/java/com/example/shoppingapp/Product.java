package com.example.shoppingapp;


public class Product {

    private String productName;
    private int productQuantity;
    private int productPrice;
    private int productImagecode;

    public Product(String productName, int productQuantity, int productPrice, int productImagecode) {
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
        this.productImagecode = productImagecode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductImagecode() {
        return productImagecode;
    }

    public void setProductImagecode(int productImagecode) {
        this.productImagecode = productImagecode;
    }
}
