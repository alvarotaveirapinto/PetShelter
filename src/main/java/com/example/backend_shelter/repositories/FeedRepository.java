package com.example.backend_shelter.repositories;

import com.example.backend_shelter.models.Feed;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedRepository extends CrudRepository<Feed, Long> {
}
