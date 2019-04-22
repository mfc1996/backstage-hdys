package com.jk.model;

import java.util.Date;

public class OrderBean  {
    private String id;
    private long orderId;
    private String orderName;
    private String orderImg;
    private Integer orderStatus;
    private Date orderTime;//订单生成时间
    private Double orderPrice;
    private Date updateTime;//订单修改时间

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderImg() {
        return orderImg;
    }

    public void setOrderImg(String orderImg) {
        this.orderImg = orderImg;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "OrderBean{" +
                "id='" + id + '\'' +
                ", orderId=" + orderId +
                ", orderName='" + orderName + '\'' +
                ", orderImg='" + orderImg + '\'' +
                ", orderStatus=" + orderStatus +
                ", orderTime=" + orderTime +
                ", orderPrice=" + orderPrice +
                ", updateTime=" + updateTime +
                '}';
    }
}
