package com.unibuc.javaproject.repository;

import com.unibuc.javaproject.model.Event;
import com.unibuc.javaproject.model.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findAllByTitle(String title);

    List<Event> findAllByOrganizer_Id(Long Id);
}
