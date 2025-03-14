package com.example.adventurexp.model;

import jakarta.persistence.*;

@Entity
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = true)
    private int age_Requirement;
    @Column(nullable = true)
    private int height_Requirement;
    @Column(nullable = true)
    private String equipment;
    @Column(nullable = false)
    private int hourly_price;

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

    public int getAge_Requirement() {
        return age_Requirement;
    }

    public void setAge_Requirement(int age_Requirement) {
        this.age_Requirement = age_Requirement;
    }

    public int getHeight_Requirement() {
        return height_Requirement;
    }

    public void setHeight_Requirement(int height_Requirement) {
        this.height_Requirement = height_Requirement;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public int getHourly_price() {
        return hourly_price;
    }

    public void setHourly_price(int hourly_price) {
        this.hourly_price = hourly_price;
    }
}
