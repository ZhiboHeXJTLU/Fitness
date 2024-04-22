
package com.example.demo.controller;

import com.example.demo.entity.Trainer;
import com.example.demo.service.TrainerService;
import com.example.demo.dto.TrainerRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/trainers")
public class TrainerController {
    @Autowired
    private TrainerService trainerService;

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
            trainerService.addTrainer(name, sex, honour, experience, LocalDateTime.parse(entryTime));

            // Return success response
            return ResponseEntity.ok("Trainer added successfully");
        } catch (Exception e) {
            // Return error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to add trainer: " + e.getMessage());
        }
    }

    @PostMapping("/{id}/calculate-rating")
    public ResponseEntity<?> calculateStarRating(@PathVariable Long id) {
        Trainer trainer = trainerService.findTrainerById(id);
        if (trainer != null) {
            trainerService.calculateStarRating(trainer);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public List<Trainer> getAllTrainers() {
        return trainerService.getAllTrainers();
    }
}
