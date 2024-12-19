package com.sybersoft.osahaneat.entity.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class KeyOrderItem implements Serializable {
    @Column(name = "order_id")
    private int order;
    @Column(name = "food_id")
    private int food;

    public KeyOrderItem() {
    }

    public KeyOrderItem(int order, int food) {
        this.order = order;
        this.food = food;
    }
}