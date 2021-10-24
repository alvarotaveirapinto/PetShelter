package com.example.backend_shelter.service;

import com.example.backend_shelter.repositories.FeedRepository;
import org.springframework.stereotype.Service;

@Service
public class FeedService {

        FeedRepository feedRepository;
        //@Autowired
        public FeedService(FeedRepository feedRepository) {
                this.feedRepository = feedRepository;}
}
