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
import java.util.Set;

public interface EventsAppService{
        Event addEvent(Event event);

        Event editEvent(Event event,Long id);

        void removeEvent(Long id);

        ArrayList<Event> displayEvent();

        Customer addCustomer(Customer customer);

        Staff addStaff(Staff staff);

        String checkCustomerLogin(Login login);

        String checkStaffLogin(Login login);

        Staff staffDetails(Login login);

        Customer customerDetails(Login login);

        Customer registerCustomerToEvent(Long customerId, Long eventId);
}
