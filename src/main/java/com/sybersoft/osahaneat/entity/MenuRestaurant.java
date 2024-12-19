package com.sybersoft.osahaneat.entity;

import com.sybersoft.osahaneat.entity.keys.KeyMenuRestaurant;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "MenuRestaurant")
public class MenuRestaurant {
    @EmbeddedId
     private KeyMenuRestaurant keys;

    @ManyToOne
    @JoinColumn(name = "cate_id",insertable = false,updatable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "res_id",insertable = false,updatable = false)
    private Restaurant restaurant;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    public KeyMenuRestaurant getKeys() {
        return keys;
    }

    public void setKeys(KeyMenuRestaurant keys) {
        this.keys = keys;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
    // Getters and Setters
}
