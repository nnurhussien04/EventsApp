package com.example.EventsApp.controller;

import com.example.EventsApp.dto.CustomerEventRequest;
import com.example.EventsApp.model.Customer;
import com.example.EventsApp.model.Login;
import com.example.EventsApp.model.Staff;
import com.example.EventsApp.service.EventsAppService;
import com.example.EventsApp.service.SecurityService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(
            summary = "Test",
            description = "Used to see if the API works"
    )
    @GetMapping("/")
    public String home(){
        return "Hello home";
    }

    @Operation(
            summary = "Sign up as a customer",
            description = "Allows the user to sign up as a customer in the application"
    )
    @PostMapping("/CustomerSignup")
    public Customer CustomerSignUp(@RequestBody Customer customer){
        return eventsAppService.addCustomer(customer);
    }

    @Operation(
            summary = "Sign up as staff",
            description = "Allows the user to sign up as a staff in the application"
    )
    @PostMapping("/StaffSignup")
    public Staff StaffSignUp(@RequestBody Staff staff){
        return eventsAppService.addStaff(staff);
    }

    @Operation(
            summary = "Sign in as customer",
            description = "Allows the user to login as a customer in the application"
    )
    @PostMapping("/CustomerLogin")
    public String customerLogin(@RequestBody Login login){
        return eventsAppService.checkCustomerLogin(login);
    }

    @Operation(
            summary = "Sign in as staff",
            description = "Allows the user to login as a staff in the application"
    )
    @PostMapping("/StaffLogin")
    public String staffLogin(@RequestBody Login login){
        return eventsAppService.checkStaffLogin(login);
    }

    @Operation(
            summary = "Retrieve staff details",
            description = "Allows the user to retrieve staff details such as name, email address, birth date etc.."
    )
    @PostMapping("/StaffDetails")
    public Staff retrieveStaffDetails(@RequestBody Login login){
        return eventsAppService.staffDetails(login);
    }

    @Operation(
            summary = "Retrieve customer details",
            description = "Allows the user to retrieve customer details such as name, email address, birth date etc.."
    )
    @PostMapping("/CustomerDetails")
    public Customer retrieveCustomerDetails(@RequestBody Login login){
        return eventsAppService.customerDetails(login);
    }






}
