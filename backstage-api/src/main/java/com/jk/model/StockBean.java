package com.jk.model;

import java.io.Serializable;

public class StockBean implements Serializable {
    private static final long serialVersionUID = 4678155856134456677L;
    private Integer stockId;
    private Integer stockNumber;

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public Integer getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(Integer stockNumber) {
        this.stockNumber = stockNumber;
    }
}
