package com.sybersoft.osahaneat.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "Promo")
public class Promo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "res_id")
    private Restaurant restaurant;

    @Column(name = "percent")
    private int percent;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    // Getters and Setters
}
