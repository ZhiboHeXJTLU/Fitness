package com.example.demo.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String sex;
    private String honour;
    private int experience;
    private LocalDateTime entryTime;
    private int starRating; // New field for star rating

    public Trainer(String name, String sex, String honour, String experience, LocalDateTime entryTime) {
        // Default constructor
    }

    public Trainer(String name, String sex, String honour, int experience, LocalDateTime entryTime, int starRating) {
        this.name = name;
        this.sex = sex;
        this.honour = honour;
        this.experience = experience;
        this.entryTime = entryTime;
        this.starRating = starRating; // Initialize star rating
    }

    // Getters and setters...
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHonour() {
        return honour;
    }

    public void setHonour(String honour) {
        this.honour = honour;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public int getStarRating() {
        return starRating;
    }

    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }
}
