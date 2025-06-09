package com.example.EventsApp.repository;

import com.example.EventsApp.model.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventRepository extends CrudRepository<Event,Long> {
    @Query("SELECT e FROM Event e WHERE e.id = :id")
    Optional<Event> findEventById(@Param("id") Long id);

}


