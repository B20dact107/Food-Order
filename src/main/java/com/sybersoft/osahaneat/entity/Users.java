package com.sybersoft.osahaneat.entity;

import com.sybersoft.osahaneat.entity.Roles;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;


@Entity(name = "Users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Roles role;
    @OneToMany(mappedBy = "user")
    private Set<RatingFood> ratingFoods;

    @OneToMany(mappedBy = "user")
    private Set<RatingRestaurant> ratingRestaurants;

    @OneToMany(mappedBy = "user")
    private Set<Orders> orders;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public Set<RatingFood> getRatingFoods() {
        return ratingFoods;
    }

    public void setRatingFoods(Set<RatingFood> ratingFoods) {
        this.ratingFoods = ratingFoods;
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

    // Getters and Setters

}
