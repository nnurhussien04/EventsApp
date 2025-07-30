package com.example.EventsApp.repository;

import com.example.EventsApp.model.Customer;
import com.example.EventsApp.model.Event;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long> {
    Optional<Customer> findByUsername(String username); //Returns an Optional of the customer matching the username, if found

}
