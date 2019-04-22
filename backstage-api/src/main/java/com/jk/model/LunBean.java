package com.jk.model;

import java.io.Serializable;

public class LunBean implements Serializable {
    private static final long serialVersionUID = -3648375520617758598L;
    private Integer id;
    private String lunImg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLunImg() {
        return lunImg;
    }

    public void setLunImg(String lunImg) {
        this.lunImg = lunImg;
    }
}
