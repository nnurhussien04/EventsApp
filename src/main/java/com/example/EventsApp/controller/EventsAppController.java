package com.example.EventsApp.controller;

import com.example.EventsApp.dto.CustomerEventRequest;
import com.example.EventsApp.model.Event;
import com.example.EventsApp.service.EventsAppService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EventsAppController {
    @Autowired
    EventsAppService eventsAppService;

    @Operation(
            summary = "Create a new event",
            description = "Allows the user to create a new event by providing name, description, date, and location."
    )
    @PostMapping("/Event")
    public ResponseEntity<?> addEvent(@RequestBody Event event){
        return new ResponseEntity<>(eventsAppService.addEvent(event),HttpStatus.CREATED);
    }

    @Operation(
            summary = "Edit a event",
            description = "Allows the user to edit event by identifying its ID"
    )
    @PutMapping("/Event/{id}")
    public ResponseEntity<?> editEvent(@RequestBody Event event,@PathVariable Long id){
        return new ResponseEntity<>(eventsAppService.editEvent(event,id),HttpStatus.OK);
    }

    @Operation(
            summary = "Delete an event",
            description = "Allows the user to delete event by identifying its ID"
    )
    @DeleteMapping("/Event/{id}")
    public void deleteEvent(@PathVariable Long id){
        eventsAppService.removeEvent(id);
    }

    @Operation(
            summary = "View event",
            description = "Allows the user to view all events in the database"
    )
    @GetMapping("/Event")
    public ResponseEntity<?> listEvent(){
        return new ResponseEntity<>(eventsAppService.displayEvent(),HttpStatus.OK);
    }

    @Operation(
            summary = "Sign up for an event",
            description = "Allows the customer to sign up to an event using both the customer and event's ID"
    )
    @PostMapping("/SignToEvent/{customerId}/{eventId}")
    public ResponseEntity<?> customerEventRegistration(@PathVariable Long customerId, @PathVariable Long eventId) {
        return new ResponseEntity<>(eventsAppService.registerCustomerToEvent(customerId, eventId), HttpStatus.OK);
    }






}
