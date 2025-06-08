package com.northcoders.eventapp.ui.data;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.northcoders.eventapp.model.Event;
import com.northcoders.eventapp.ui.homepage.HomepageActivity;
import com.northcoders.eventapp.ui.mainactivity.MainActivity;
import com.northcoders.eventapp.ui.mainactivity.MainActivityViewModel;

public class EventDataClickHandler {
    private Event event;
    private MainActivityViewModel viewModel;
    private long id;
    private Context context;

    public EventDataClickHandler(Event event,MainActivityViewModel viewModel,Context context) {
        this.event = event;
        this.viewModel = viewModel;
        this.context = context;
    }

    public void EditButton(View view){
        if(event.getName() == null || event.getDate() == null || event.getDescription() == null || event.getLocation() == null || event.getTime() == null){
            Toast.makeText(context,"Form Incomplete, Try Again", Toast.LENGTH_SHORT);
            return;
        }
        id = event.getId();
        Event newEvent = new Event();
        newEvent.setId(id);
        newEvent.setName(event.getName());
        newEvent.setDate(event.getDate());
        newEvent.setTime(event.getTime());
        newEvent.setDescription(event.getDescription());
        newEvent.setLocation(event.getLocation());
        newEvent.setStaff(event.getStaff());
        viewModel.getUpdateEvent(newEvent,id);
        Intent intent = new Intent(context, HomepageActivity.class);
        context.startActivity(intent);
    }

    public void DeleteButton(View view){
        viewModel.getDeleteEvent(event);
        Intent intent = new Intent(context, HomepageActivity.class);
        context.startActivity(intent);
    }

}
