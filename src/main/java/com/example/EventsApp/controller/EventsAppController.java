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

    @PutMapping("/Event/{id}")
    public ResponseEntity<?> editEvent(@RequestBody Event event,@PathVariable Long id){
        return new ResponseEntity<>(eventsAppService.editEvent(event,id),HttpStatus.OK);
    }

    @DeleteMapping("/Event/{id}")
    public void deleteEvent(@PathVariable Long id){
        eventsAppService.removeEvent(id);
    }

    @GetMapping("/Event")
    public ResponseEntity<?> listEvent(){
        return new ResponseEntity<>(eventsAppService.displayEvent(),HttpStatus.OK);
    }

    @PostMapping("/SignToEvent/{customerId}/{eventId}")
    public ResponseEntity<?> customerEventRegistration(@PathVariable Long customerId, @PathVariable Long eventId) {
        return new ResponseEntity<>(eventsAppService.registerCustomerToEvent(customerId, eventId), HttpStatus.OK);
    }






}
