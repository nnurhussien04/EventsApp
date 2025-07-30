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
        return eventRepository.save(event); //Adds the event in the repository
    }


    @Override
    public Event editEvent(Event event,Long id) { //Edits the event and adds it to the repository
        Optional<Event> optionalEvent = eventRepository.findById(id); //Searches for the event model from the repo by using its ID
        if (optionalEvent.isPresent()) { //Conditional check it to see if the event exists
            Event existingEvent = optionalEvent.get(); //Retrieves the existing event from the repository
            existingEvent.setName(event.getName()); // Adds the changes to the new event
            existingEvent.setTime(event.getTime());
            existingEvent.setDate(event.getDate());
            existingEvent.setDescription(event.getDescription());
            existingEvent.setLocation(event.getLocation());
            existingEvent.setStaff(event.getStaff());
            return eventRepository.save(existingEvent); //Updates the event fields with the new values
        } else {
            throw new RuntimeException("Event not found with id: " + id); //An error is thrown if it doesn't exist
        }
    }


    @Override
    public void removeEvent(Long id){ //Removes the event from the repository
        if(eventRepository.existsById(id)){ //Checks if the events exists in the repository
            Event event = eventRepository.findById(id).get(); //Retrieves the event with the given ID
            for (Customer customer : event.getAttendees()) { //Goes through every customer that signed up for the event
                customer.getEvents().remove(event); //They remove the event from the list before its deleted
                customerRepository.save(customer); //Save the changes to the repository
            }
            eventRepository.delete(event); //Deleting an event from repository
        }
        return;
    }

    @Override
    public ArrayList<Event> displayEvent(){ //Shows the event listed in the database
        ArrayList<Event> events = new ArrayList<>(); //Created an array to show the all the events
        eventRepository.findAll().forEach(x -> events.add(x)); //Retrieves all events from the repository and adds them to the array
        return events; //Displays all the events
    }

    @Override
    public Customer addCustomer(Customer customer){ //Register the customer to the repository
        customer.setPassword(passwordEncoder.encode(customer.getPassword())); //Encodes the password to make application more secure
        return customerRepository.save(customer); //Adds the customer to the repository
    }

    @Override
    public Staff addStaff(Staff staff){ //Registers the staff to the repository
        staff.setPassword(passwordEncoder.encode(staff.getPassword())); //Encodes the password to make application more secure
        return staffRepository.save(staff); //Adds the staff to the repository
    }

    @Override
    public String checkCustomerLogin(Login login) { //Validates customer username and password
        if(customerRepository.findByUsername(login.getUsername()).isPresent()) { //Checks if the customer exists by trying to find username
            var customer = customerRepository.findByUsername(login.getUsername()).get(); //Retrieves the customer from the repository
            if(passwordEncoder.matches(login.getPassword(),customer.getPassword())) //Checks if the user password matches with the one in the repository by encoding them both and seeing if the code matches
                return "Login Successful";
        }
        return "Login Failed";
    }

    @Override
    public String checkStaffLogin(Login login) { //Validates staff username and password
        if(staffRepository.findByUsername(login.getUsername()).isPresent()) { //Checks if the staff exists by trying to find username
            var staff = staffRepository.findByUsername(login.getUsername()).get(); //Retrieves the staff from the repository
            if(passwordEncoder.matches(login.getPassword(),staff.getPassword())) //Checks if the staff password matches with the one in the repository by encoding and seeing if the code matches
                return "Login Successful";
        }
        return "Login Failed";
    }

    @Override
    public Staff staffDetails(Login login) {
        return staffRepository.findByUsername(login.getUsername()).get(); //Retrieves staff from the repository (throws if not found)
    }

    @Override
    public Customer customerDetails(Login login){
        return customerRepository.findByUsername(login.getUsername()).get(); //Retrieves customer from the repository (throws if not found)
    }



    @Override
    @Transactional
    public Customer registerCustomerToEvent(Long customerId, Long eventId) { //Adds the event to the customer's registered events
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found")); //Try to find the customer (if its exists) by its id, if it doesn't find it - it throws an exception

        Event event = eventRepository.findEventById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found")); //Try to find the event (if its exists) by its id, if it doesn't find it - it throws an exception

        Hibernate.initialize(customer.getEvents()); // Forces Hibernate to initialize the (potentially lazy-loaded) events from the database, using the existing session and the customer entity
        customer.getEvents().add(event); //register the event to the customer events set
        customerRepository.save(customer); //Adds the changes to the repository
        //customerRepository.save(customer);
        return customer; // or updatedEvents
    }







}
