package com.example.EventsApp.service;

import com.example.EventsApp.model.Customer;
import com.example.EventsApp.model.Event;
import com.example.EventsApp.model.Login;
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
        newEvent.setDate(event.getDate());
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


}
