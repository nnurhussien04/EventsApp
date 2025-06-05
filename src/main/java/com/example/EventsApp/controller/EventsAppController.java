package com.example.EventsApp.controller;

import com.example.EventsApp.dto.CustomerEventRequest;
import com.example.EventsApp.model.Event;
import com.example.EventsApp.service.EventsAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EventsAppController {
    @Autowired
    EventsAppService eventsAppService;

    @PostMapping("/Event")
    public ResponseEntity<?> addEvent(@RequestBody Event event){
        return new ResponseEntity<>(eventsAppService.addEvent(event),HttpStatus.CREATED);
    }

    @PutMapping("/Event")
    public ResponseEntity<?> editEvent(@RequestBody Event event){
        return new ResponseEntity<>(eventsAppService.editEvent(event),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/Event")
    public ResponseEntity<?> deleteEvent(@RequestBody Event event){
        return new ResponseEntity<>(eventsAppService.removeEvent(event),HttpStatus.OK);
    }

    @GetMapping("/Event")
    public ResponseEntity<?> listEvent(){
        return new ResponseEntity<>(eventsAppService.displayEvent(),HttpStatus.OK);
    }

    @PostMapping("/SignToEvent")
    public ResponseEntity<?> customerEventRegistration(@RequestBody CustomerEventRequest customerEventRequest){
        return new ResponseEntity<>(eventsAppService.registerCustomerToEvent(customerEventRequest.getCustomerId(), customerEventRequest.getEventId()),HttpStatus.OK);
    }





}
