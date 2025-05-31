package com.northcoders.eventapp.ui.mainactivity;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.northcoders.eventapp.R;
import com.northcoders.eventapp.databinding.EventItemBinding;
import com.northcoders.eventapp.databinding.EventPageBinding;
import com.northcoders.eventapp.model.Event;
import com.northcoders.eventapp.model.EventRepository;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Event> events;
    private EventAdapter eventAdapter;
    private MainActivityViewModel mainActivityViewModel;
    private EventPageBinding eventPageBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.event_page);
        EventRepository eventRepository = new EventRepository(this.getApplication());
        eventRepository.getMutableLiveData();
        eventPageBinding = DataBindingUtil.setContentView(this,R.layout.event_page);
        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        getAllEvents();
    }

    private void getAllEvents(){
        mainActivityViewModel.getMutableLiveData().observe(
                this, new Observer<List<Event>>() {
                    @Override
                    public void onChanged(List<Event> eventFromLiveData) {
                        Log.d("MainActivityEvent", "Events received: " + eventFromLiveData.size());
                        events = (ArrayList<Event>) eventFromLiveData;
                        displayInRecyclerView();
                    }
                }
        );
    }

    private void displayInRecyclerView(){
        recyclerView = eventPageBinding.recyclerView;
        eventAdapter = new EventAdapter(events,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(eventAdapter);
        recyclerView.setHasFixedSize(true);
        eventAdapter.notifyDataSetChanged();
    }


}