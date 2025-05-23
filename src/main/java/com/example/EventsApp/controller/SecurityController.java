package com.example.EventsApp.controller;

import com.example.EventsApp.model.Customer;
import com.example.EventsApp.model.Staff;
import com.example.EventsApp.repository.CustomerRepository;
import com.example.EventsApp.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String home(){
        return "Hello home";
    }

    @PostMapping("/UserSignup")
    public Customer CustomerSignUp(@RequestBody Customer customer){
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        return customerRepository.save(customer);
    }

    @PostMapping("/StaffSignup")
    public Staff StaffSignUp(@RequestBody Staff staff){
        staff.setPassword(passwordEncoder.encode(staff.getPassword()));
        return staffRepository.save(staff);
    }


}
