package com.example.adventurexp.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "Activity_id_fk", nullable = false)
    private Activity activity;

    @ManyToOne
    @JoinColumn(name = "Customer_id_fk", nullable = false)
    private Customer customer;

    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    private LocalTime time;
    @Column(nullable = false)
    private LocalTime duration;
    @Column(nullable = false)
    private int participants;
    @Column(nullable = false)
    private int sweet_Grams;
    @Column(nullable = false)
    private int tshirts;
    @Column(nullable = false)
    private int sodas;
    private float totalPrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Customer getCustomer() {
            return customer;
    }

    public void setCustomer(Customer customer) {
            this.customer = customer;
    }
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    public int getParticipants() {
        return participants;
    }

    public void setParticipants(int participants) {
        this.participants = participants;
    }

    public int getSweet_Grams() {
        return sweet_Grams;
    }

    public void setSweet_Grams(int sweet_Grams) {
        this.sweet_Grams = sweet_Grams;
    }

    public int getTshirts() {
        return tshirts;
    }

    public void setTshirts(int tshirts) {
        this.tshirts = tshirts;
    }

    public int getSodas() {
        return sodas;
    }

    public void setSodas(int sodas) {
        this.sodas = sodas;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
}
