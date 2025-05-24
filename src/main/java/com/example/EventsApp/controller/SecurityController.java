package com.example.EventsApp.controller;

import com.example.EventsApp.model.Customer;
import com.example.EventsApp.model.Staff;
import com.example.EventsApp.service.EventsAppService;
import com.example.EventsApp.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @Autowired
    private SecurityService securityService;

    @Autowired
    private EventsAppService eventsAppService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String home(){
        return "Hello home";
    }

    @PostMapping("/CustomerSignup")
    public Customer CustomerSignUp(@RequestBody Customer customer){
        return eventsAppService.addCustomer(customer);
    }

    @PostMapping("/StaffSignup")
    public Staff StaffSignUp(@RequestBody Staff staff){
        return eventsAppService.addStaff(staff);
    }


}
