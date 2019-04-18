package com.jk.model;

import java.io.Serializable;

public class StockProBean implements Serializable {
    private static final long serialVersionUID = -5723108818174495797L;
    private Integer id;
    private Integer stockId;
    private Integer productId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
