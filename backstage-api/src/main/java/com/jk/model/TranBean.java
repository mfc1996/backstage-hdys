package com.jk.model;

import java.io.Serializable;

public class TranBean implements Serializable {
    private static final long serialVersionUID = -8880908566977915630L;
    private Integer transactionId;
    private Integer transactionState;


    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getTransactionState() {
        return transactionState;
    }

    public void setTransactionState(Integer transactionState) {
        this.transactionState = transactionState;
    }
}
