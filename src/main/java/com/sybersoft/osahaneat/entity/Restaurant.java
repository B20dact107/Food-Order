package com.sybersoft.osahaneat.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity(name = "Restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "subtitle")
    private String subtitle;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @Column(name = "is_freeship")
    private boolean isFreeship;

    @Column(name = "address")
    private String address;

    @Column(name = "open_date")
    private LocalDateTime openDate;
    @OneToMany(mappedBy = "restaurant")
    private Set<RatingRestaurant> ratingRestaurants;

    @OneToMany(mappedBy = "restaurant")
    private Set<Orders> orders;

    @OneToMany(mappedBy = "restaurant")
    private Set<Promo> promos;

    @OneToMany(mappedBy = "restaurant",fetch = FetchType.EAGER)
    private Set<MenuRestaurant> menuRestaurants;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isFreeship() {
        return isFreeship;
    }

    public void setFreeship(boolean freeship) {
        isFreeship = freeship;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getOpenDate() {
        return openDate;
    }

    public void setOpenDate(LocalDateTime openDate) {
        this.openDate = openDate;
    }

    public Set<RatingRestaurant> getRatingRestaurants() {
        return ratingRestaurants;
    }

    public void setRatingRestaurants(Set<RatingRestaurant> ratingRestaurants) {
        this.ratingRestaurants = ratingRestaurants;
    }

    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }

    public Set<Promo> getPromos() {
        return promos;
    }

    public void setPromos(Set<Promo> promos) {
        this.promos = promos;
    }

    public Set<MenuRestaurant> getMenuRestaurants() {
        return menuRestaurants;
    }

    public void setMenuRestaurants(Set<MenuRestaurant> menuRestaurants) {
        this.menuRestaurants = menuRestaurants;
    }
}

