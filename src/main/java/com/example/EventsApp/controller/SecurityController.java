package com.example.EventsApp.controller;

import com.example.EventsApp.dto.CustomerEventRequest;
import com.example.EventsApp.model.Customer;
import com.example.EventsApp.model.Login;
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

    @PostMapping("/CustomerLogin")
    public String customerLogin(@RequestBody Login login){
        return eventsAppService.checkCustomerLogin(login);
    }

    @PostMapping("/StaffLogin")
    public String staffLogin(@RequestBody Login login){
        return eventsAppService.checkStaffLogin(login);
    }

    @PostMapping("/StaffDetails")
    public Staff retrieveStaffDetails(@RequestBody Login login){
        return eventsAppService.staffDetails(login);
    }

    @PostMapping("/CustomerDetails")
    public Customer retrieveCustomerDetails(@RequestBody Login login){
        return eventsAppService.customerDetails(login);
    }






}
