package com.example.EventsApp.service;

import com.example.EventsApp.model.Customer;
import com.example.EventsApp.model.Event;
import com.example.EventsApp.model.Staff;
import com.example.EventsApp.repository.CustomerRepository;
import com.example.EventsApp.repository.EventRepository;
import com.example.EventsApp.repository.StaffRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

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
    public Event editEvent(Event event){
        Event newEvent = new Event();
        newEvent.setId(event.getId());
        newEvent.setName(event.getName());
        newEvent.setTime(event.getTime());
        newEvent.setDescription(event.getDescription());
        newEvent.setLocation(event.getLocation());
        newEvent.setStaff(event.getStaff());
        return eventRepository.save(newEvent);
    }

    @Override
    public boolean removeEvent(Event event){
        if(eventRepository.existsById(event.getId())){
            eventRepository.delete(event);
            return true;
        }
        return false;
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


}
