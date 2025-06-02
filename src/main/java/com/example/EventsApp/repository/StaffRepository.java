package com.example.EventsApp.repository;

import com.example.EventsApp.model.Customer;
import com.example.EventsApp.model.Staff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StaffRepository extends CrudRepository<Staff,Long> {
    Optional<Staff> findByUsername(String username);
    Optional<Staff> findByUsernameAndPassword(String username, String password);


}
