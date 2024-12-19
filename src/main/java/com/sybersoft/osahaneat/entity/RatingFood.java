package com.sybersoft.osahaneat.entity;

import jakarta.persistence.*;

@Entity(name = "RatingFood")
public class RatingFood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    @Column(name = "content", columnDefinition = "NVARCHAR(MAX)")
    private String content;

    // Getters and Setters
}
