package com.example.backend_shelter.service;

import com.example.backend_shelter.repositories.FoodRepository;
import org.springframework.stereotype.Service;

@Service
public class FoodService {
    FoodRepository foodRepository;
    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }
}
