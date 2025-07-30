package com.example.EventsApp.controller;

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
    ) //This is for documentation purposes, allows us to document the endpoints and give a description
    @PostMapping("/Event") //Maps HTTP POST requests to /Event
    public ResponseEntity<?> addEvent(@RequestBody Event event){
        return new ResponseEntity<>(eventsAppService.addEvent(event),HttpStatus.CREATED); // Calls addEvent service method and returns the created event with HTTP 201 Created status
    }

    @Operation(
            summary = "Edit a event",
            description = "Allows the user to edit event by identifying its ID"
    )
    @PutMapping("/Event/{id}") //Maps HTTP PUT requests to /Event/{id}
    public ResponseEntity<?> editEvent(@RequestBody Event event,@PathVariable Long id){
        return new ResponseEntity<>(eventsAppService.editEvent(event,id),HttpStatus.OK); //Calls editEvent service method and returns the edited Event with HTTP 200 OK status
    }

    @Operation(
            summary = "Delete an event",
            description = "Allows the user to delete event by identifying its ID"
    )
    @DeleteMapping("/Event/{id}") //Maps HTTP DELETE requests to /Event/{id}
    public void deleteEvent(@PathVariable Long id){
        eventsAppService.removeEvent(id); //Just deletes the event and should return a HTTP 200 OK code
    }

    @Operation(
            summary = "View event",
            description = "Allows the user to view all events in the database"
    )
    @GetMapping("/Event") //Maps HTTP GET requests to /Event
    public ResponseEntity<?> listEvent(){
        return new ResponseEntity<>(eventsAppService.displayEvent(),HttpStatus.OK); //Calls the displayEvent service method and displays the events with HTTP 200 OK status
    }

    @Operation(
            summary = "Sign up for an event",
            description = "Allows the customer to sign up to an event using both the customer and event's ID"
    )
    @PostMapping("/SignToEvent/{customerId}/{eventId}") //Maps HTTP POST requests to //SignToEvent/{customerId}/{eventId}
    public ResponseEntity<?> customerEventRegistration(@PathVariable Long customerId, @PathVariable Long eventId) {
        return new ResponseEntity<>(eventsAppService.registerCustomerToEvent(customerId, eventId), HttpStatus.OK); //Calls the registerCustomerToEvent method and display the events with HTTP 200 OK status
    }







}
