package com.example.adventurexp.model;

import jakarta.persistence.*;

@Entity
public class SalesItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private int price;

}
