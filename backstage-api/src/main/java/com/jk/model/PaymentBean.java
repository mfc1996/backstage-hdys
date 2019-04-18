package com.jk.model;

import java.io.Serializable;

public class PaymentBean implements Serializable {
    private static final long serialVersionUID = -2579105425791091368L;

    private Integer paymentId;
    private String  paymentName;
    private String paymentImg;

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    public String getPaymentImg() {
        return paymentImg;
    }

    public void setPaymentImg(String paymentImg) {
        this.paymentImg = paymentImg;
    }
}
