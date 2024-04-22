package com.example.demo.dto;

public class TrainerRequest {
    private String name;
    private String sex;
    private String honour;
    private String experience;
    private String entryTime;

    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSex() { return sex; }
    public void setSex(String sex) { this.sex = sex; }
    public String getHonour() { return honour; }
    public void setHonour(String honour) { this.honour = honour; }
    public String getExperience() { return experience; }
    public void setExperience(String experience) { this.experience = experience; }
    public String getEntryTime() { return entryTime; }
    public void setEntryTime(String entryTime) { this.entryTime = entryTime; }
}
