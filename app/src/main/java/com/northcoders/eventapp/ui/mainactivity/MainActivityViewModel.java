package com.northcoders.eventapp.ui.mainactivity;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.northcoders.eventapp.model.Event;
import com.northcoders.eventapp.model.EventRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    EventRepository eventRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.eventRepository = new EventRepository(application);
    }

    public MutableLiveData<List<Event>> getMutableLiveData(){
        return eventRepository.getMutableLiveData();
    }
}
