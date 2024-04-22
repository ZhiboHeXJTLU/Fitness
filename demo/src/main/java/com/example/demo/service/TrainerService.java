
package com.example.demo.service;

import com.example.demo.entity.Trainer;
import com.example.demo.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TrainerService {
    private final TrainerRepository trainerRepository;

    @Autowired
    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public void addTrainer(String name, String sex, String honour, String experience, LocalDateTime entryTime) {
        // Create a new trainer object
        Trainer newTrainer = new Trainer(name, sex, honour, experience, entryTime);

        // Save the trainer using the repository
        trainerRepository.save(newTrainer);

    }

    // 根据ID查找教练
    public Trainer findTrainerById(Long id) {
        return trainerRepository.findById(id).orElse(null);
    }

    // 计算教练星级
    public void calculateStarRating(Trainer trainer) {
        int experience = trainer.getExperience(); // Assume experience is retrieved correctly
        int starRating = 3; // Default star rating

        if (experience >= 5) {
            starRating = 5;
        } else if (experience >= 3) {
            starRating = 4;
        }

        trainer.setStarRating(starRating);
        trainerRepository.save(trainer); // Save the trainer with the new star rating
    }

    // 获取所有教练
    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }
}
