package com.sybersoft.osahaneat.entity.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;
@Embeddable
public class KeyMenuRestaurant implements Serializable {
    @Column(name = "cate_id")
    private int cateId;
    @Column(name = "res_id")
    private int resId;

    public KeyMenuRestaurant() {
    }

    public KeyMenuRestaurant(int cateId, int resId) {
        this.cateId = cateId;
        this.resId = resId;
    }

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyMenuRestaurant that = (KeyMenuRestaurant) o;
        return cateId == that.cateId && resId == that.resId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cateId, resId);
    }
}
