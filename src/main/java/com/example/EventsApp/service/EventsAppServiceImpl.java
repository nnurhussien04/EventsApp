package com.example.EventsApp.service;

import com.example.EventsApp.model.Customer;
import com.example.EventsApp.model.Event;
import com.example.EventsApp.model.Login;
import com.example.EventsApp.model.Staff;
import com.example.EventsApp.repository.CustomerRepository;
import com.example.EventsApp.repository.EventRepository;
import com.example.EventsApp.repository.StaffRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class EventsAppServiceImpl implements EventsAppService{
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Event addEvent(Event event){
        return eventRepository.save(event);
    }


    @Override
    public Event editEvent(Event event,Long id) {
        Optional<Event> optionalEvent = eventRepository.findById(id);
        if (optionalEvent.isPresent()) {
            Event existingEvent = optionalEvent.get();
            existingEvent.setName(event.getName());
            existingEvent.setTime(event.getTime());
            existingEvent.setDate(event.getDate());
            existingEvent.setDescription(event.getDescription());
            existingEvent.setLocation(event.getLocation());
            existingEvent.setStaff(event.getStaff());
            return eventRepository.save(existingEvent);
        } else {
            throw new RuntimeException("Event not found with id: " + id);
        }
    }


    @Override
    public void removeEvent(Long id){
        if(eventRepository.existsById(id)){
            Event event = eventRepository.findById(id).get();
            for (Customer customer : event.getAttendees()) {
                customer.getEvents().remove(event);
                customerRepository.save(customer);
            }
            eventRepository.delete(event);
        }
        return;
    }

    @Override
    public ArrayList<Event> displayEvent(){
        ArrayList<Event> events = new ArrayList<>();
        eventRepository.findAll().forEach(x -> events.add(x));
        return events;
    }

    @Override
    public Customer addCustomer(Customer customer){
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        return customerRepository.save(customer);
    }

    @Override
    public Staff addStaff(Staff staff){
        staff.setPassword(passwordEncoder.encode(staff.getPassword()));
        return staffRepository.save(staff);
    }

    @Override
    public String checkCustomerLogin(Login login) {
        if(customerRepository.findByUsername(login.getUsername()).isPresent()) {
            var customer = customerRepository.findByUsername(login.getUsername()).get();
            if(passwordEncoder.matches(login.getPassword(),customer.getPassword()))
                return "Login Successful";
        }
        return "Login Failed";
    }

    @Override
    public String checkStaffLogin(Login login) {
        if(staffRepository.findByUsername(login.getUsername()).isPresent()) {
            var staff = staffRepository.findByUsername(login.getUsername()).get();
            if(passwordEncoder.matches(login.getPassword(),staff.getPassword()))
                return "Login Successful";
        }
        return "Login Failed";
    }

    @Override
    public Staff staffDetails(Login login) {
        return staffRepository.findByUsername(login.getUsername()).get();
    }

    @Override
    public Customer customerDetails(Login login){return customerRepository.findByUsername(login.getUsername()).get();}



    @Override
    @Transactional
    public Customer registerCustomerToEvent(Long customerId, Long eventId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Event event = eventRepository.findEventById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        Hibernate.initialize(customer.getEvents());

        // Copy and update the set to avoid modifying PersistentSet directly
        customer.getEvents().add(event);
        customerRepository.save(customer);
        //customerRepository.save(customer);
        return customer; // or updatedEvents
    }







}
