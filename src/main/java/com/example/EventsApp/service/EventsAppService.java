package com.example.EventsApp.service;

import com.example.EventsApp.model.Customer;
import com.example.EventsApp.model.Staff;
import com.example.EventsApp.repository.CustomerRepository;
import com.example.EventsApp.repository.StaffRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EventsAppService implements UserDetailsService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private StaffRepository staffRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Customer> customer = customerRepository.findByUsername(username);
        Optional<Staff> staff = staffRepository.findByUsername(username);
        if(customer.isPresent()){
            var userObj = customer.get();
            return User.builder()
                    .username(userObj.getUsername())
                    .password(userObj.getPassword())
                    .build();
        }
        else if(staff.isPresent()){
            var userObj = staff.get();
            return User.builder()
                    .username(userObj.getUsername())
                    .password(userObj.getPassword())
                    .build();
        }
        else{
            throw new UsernameNotFoundException(username);
        }
    }
}
