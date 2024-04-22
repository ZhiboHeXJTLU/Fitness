package com.example.demo.controller;


import com.example.demo.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@Controller
public class add_trainerController {

    private final com.example.demo.service.TrainerService TrainerService;

    @Autowired
    public add_trainerController(TrainerService TrainerService) {
        this.TrainerService = TrainerService;
    }


    @GetMapping("/add_trainer") // 处理根路径
    public String showAddTrainerPage() {
        return "add_trainer";// 返回前端文件的路径
    }

    @PostMapping("/add_trainer")
    public ResponseEntity<String> addTrainer(@RequestBody TrainerRequest request) {
        try {
            // Extract information from the request
            String name = request.getName();
            String sex = request.getSex();
            String honour = request.getHonour();
            String experience = request.getExperience();
            String entryTime = request.getEntryTime();

            // Call the service to add the trainer
            TrainerService.addTrainer(name, sex, honour, experience, LocalDateTime.parse(entryTime));

            // Return success response
            return ResponseEntity.ok("Trainer added successfully");
        } catch (Exception e) {
            // Return error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to add trainer: " + e.getMessage());
        }
    }

    // Define a class to represent the request body
    private static class TrainerRequest {
        private String name;
        private String sex;
        private String honour;
        private String experience;
        private String entryTime;

        // Getters and setters
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

        public String getExperience() {
            return experience;
        }

        public void setExperience(String experience) {
            this.experience = experience;
        }

        public String getEntryTime() {
            return entryTime;
        }

        public void setEntryTime(String entryTime) {
            this.entryTime = entryTime;
        }
    }
}