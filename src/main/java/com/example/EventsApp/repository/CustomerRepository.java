package com.example.EventsApp.repository;

import com.example.EventsApp.model.Customer;
import com.example.EventsApp.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long> {
    Optional<Customer> findByUsername(String username);
}
