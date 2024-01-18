package com.unibuc.javaproject.repository;

import com.unibuc.javaproject.model.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public interface VenueRepository extends JpaRepository<Venue, Long> {

    @Query("from Venue where capacity >= :capacity")
    List<Venue> findVenuesWithCapacity(Integer capacity);
}
