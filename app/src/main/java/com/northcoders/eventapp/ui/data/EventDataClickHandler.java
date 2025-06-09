package com.northcoders.eventapp.ui.data;

import android.content.Context;
import android.content.Intent;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;

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

    public void AddToCalendar(View view){
        Intent intent = new Intent(Intent.ACTION_EDIT);
        intent.setType("vnd.android.cursor.item/event");

        intent.putExtra(CalendarContract.Events.TITLE,event.getName());
        intent.putExtra(CalendarContract.Events.DESCRIPTION,event.getDescription());
        intent.putExtra(CalendarContract.Events.EVENT_LOCATION,event.getLocation());
        intent.setPackage("com.google.android.calendar");
        context.startActivity(intent);
    }

    public void SignUpToEvent(View view){
        viewModel.getCustomerData().observe((LifecycleOwner) context, customer -> {
            if(customer!=null){
                Log.d("CustomerData", "checkRole: " + customer.getId());
                viewModel.getCustomerSignUpEvent(customer.getId(), event.getId());
            }else{
                return;
            }
        });
    }

}
