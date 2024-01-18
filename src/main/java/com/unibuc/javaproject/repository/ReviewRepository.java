package com.unibuc.javaproject.repository;

import com.unibuc.javaproject.model.Event;
import com.unibuc.javaproject.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query(nativeQuery = true,
            value = "select avg(re.rating) from reviews re where event_id = :id")
    Optional<Double> getAverageRatingOfEvent(Long id);

}
