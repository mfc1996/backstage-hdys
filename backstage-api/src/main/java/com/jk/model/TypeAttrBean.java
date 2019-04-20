package com.jk.model;

import java.io.Serializable;

public class TypeAttrBean implements Serializable {
    private static final long serialVersionUID = 7135859269937000194L;
    private Integer typeAttributeId;
    private Integer typeId;
    private Integer attributeId;

    public Integer getTypeAttributeId() {
        return typeAttributeId;
    }

    public void setTypeAttributeId(Integer typeAttributeId) {
        this.typeAttributeId = typeAttributeId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Integer attributeId) {
        this.attributeId = attributeId;
    }
}
