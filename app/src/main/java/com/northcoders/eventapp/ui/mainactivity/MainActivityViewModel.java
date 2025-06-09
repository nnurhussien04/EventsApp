package com.northcoders.eventapp.ui.mainactivity;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.northcoders.eventapp.model.Customer;
import com.northcoders.eventapp.model.Event;
import com.northcoders.eventapp.model.EventRepository;
import com.northcoders.eventapp.model.Login;
import com.northcoders.eventapp.model.Staff;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    EventRepository eventRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.eventRepository = EventRepository.getInstance(application);
    }

    public MutableLiveData<List<Event>> getMutableLiveData(){
        return eventRepository.getMutableLiveData();
    }

    public MutableLiveData<String> getLoginData(Login login){
        return eventRepository.getLoginData(login);
    }

    public MutableLiveData<Customer> getCustomerSignup(Customer customer){
        return eventRepository.CustomerSignUp(customer);
    }

    public MutableLiveData<Event> getCreateEvent(Event event){
        return eventRepository.CreateEvent(event);
    }
    public MutableLiveData<Staff> getStaffData(){
        return eventRepository.staffRetrieval();
    }

    public MutableLiveData<Customer> getCustomerData(){
        return eventRepository.customerRetrieval();
    }

    public void getUpdateEvent(Event event,Long id){
        eventRepository.editEvent(event,id);
    }

    public void getDeleteEvent(Event event){
        eventRepository.deleteEvent(event.getId());
    }

    public MutableLiveData<Customer> getCustomerSignUpEvent(Long customerID,Long eventID){
        return eventRepository.customerSignUpEvent(customerID, eventID);
    }
}
