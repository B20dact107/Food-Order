package com.sybersoft.osahaneat.entity;


import com.sybersoft.osahaneat.entity.keys.KeyOrderItem;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "OrderItem")

public class OrderItem {
    @EmbeddedId
    private KeyOrderItem keyOrderItem;

    @ManyToOne
    @JoinColumn(name = "order_id",insertable = false,updatable = false)
    private Orders order;


    @ManyToOne
    @JoinColumn(name = "food_id",insertable = false,updatable = false)
    private Food food;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    // Getters and Setters

    public KeyOrderItem getKeyOrderItem() {
        return keyOrderItem;
    }

    public void setKeyOrderItem(KeyOrderItem keyOrderItem) {
        this.keyOrderItem = keyOrderItem;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
}
