package com.shabsudemy.viewpagerrecyclerviewpoc.models;

import java.util.List;

public class DataModel {
    static String currency;
    String productId;
    String productName;
    String productCategory;
    double sellingPrice;
    double actualMRP;
    boolean saleFlag;
    List<String> productImage;

    public DataModel() {
    }

    public DataModel(String productId, String productName, String productCategory, double sellingPrice, double actualMRP, boolean saleFlag, List<String> productImage) {
        this.productId = productId;
        this.productName = productName;
        this.productCategory = productCategory;
        this.sellingPrice = sellingPrice;
        this.actualMRP = actualMRP;
        this.saleFlag = saleFlag;
        this.productImage = productImage;
    }

    public List<String> getProductImage() {
        return productImage;
    }

    public void setProductImage(List<String> productImage) {
        this.productImage = productImage;
    }

    public static String getCurrency() {
        return currency;
    }

    public static void setCurrency(String currency) {
        DataModel.currency = currency;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public double getActualMRP() {
        return actualMRP;
    }

    public void setActualMRP(double actualMRP) {
        this.actualMRP = actualMRP;
    }

    public boolean isSaleFlag() {
        return saleFlag;
    }

    public void setSaleFlag(boolean saleFlag) {
        this.saleFlag = saleFlag;
    }

    @Override
    public String toString() {
        return "DataModel{" + "productId='" + productId + '\'' + ", productName='" + productName + '\'' + ", productCategory='" + productCategory + '\'' + ", sellingPrice=" + sellingPrice + ", actualMRP=" + actualMRP + ", saleFlag=" + saleFlag + ", productImage=" + productImage + '}';
    }
}
