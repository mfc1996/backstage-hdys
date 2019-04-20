package com.jk.model;

import java.io.Serializable;

public class ProBean implements Serializable {

    private static final long serialVersionUID = -527932410834395732L;

      private Integer    productId;
      private  String productName;
    private   Double   productPrice;
    private  Integer      productDiscountId;
    private  Integer      productCollectionId;
    private  Integer       typeId;
    private  String       typeName;
    private   String     productColor;
    private   Integer      productStockId;
    private    String       productSize;
    private     String     productDeliveryTime;
    private    Integer       productCommentId;
    private    Integer       productTransactionId;
    private     Integer     paymentId;
    private     Integer    productState;
    private      String    addressId;
    private    Integer     proDealCount;
    private    Integer      stockNumber;
    private     String        productImg;
    private    String    shuName;

    public String getShuName() {
        return shuName;
    }

    public void setShuName(String shuName) {
        this.shuName = shuName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public Integer getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(Integer stockNumber) {
        this.stockNumber = stockNumber;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductDiscountId() {
        return productDiscountId;
    }

    public void setProductDiscountId(Integer productDiscountId) {
        this.productDiscountId = productDiscountId;
    }

    public Integer getProductCollectionId() {
        return productCollectionId;
    }

    public void setProductCollectionId(Integer productCollectionId) {
        this.productCollectionId = productCollectionId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public Integer getProductStockId() {
        return productStockId;
    }

    public void setProductStockId(Integer productStockId) {
        this.productStockId = productStockId;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public String getProductDeliveryTime() {
        return productDeliveryTime;
    }

    public void setProductDeliveryTime(String productDeliveryTime) {
        this.productDeliveryTime = productDeliveryTime;
    }

    public Integer getProductCommentId() {
        return productCommentId;
    }

    public void setProductCommentId(Integer productCommentId) {
        this.productCommentId = productCommentId;
    }

    public Integer getProductTransactionId() {
        return productTransactionId;
    }

    public void setProductTransactionId(Integer productTransactionId) {
        this.productTransactionId = productTransactionId;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Integer getProductState() {
        return productState;
    }

    public void setProductState(Integer productState) {
        this.productState = productState;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public Integer getProDealCount() {
        return proDealCount;
    }

    public void setProDealCount(Integer proDealCount) {
        this.proDealCount = proDealCount;
    }
}