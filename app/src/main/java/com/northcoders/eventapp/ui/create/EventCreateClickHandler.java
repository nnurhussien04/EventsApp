package com.northcoders.eventapp.ui.create;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.northcoders.eventapp.model.Event;
import com.northcoders.eventapp.model.Staff;
import com.northcoders.eventapp.ui.homepage.HomepageActivity;
import com.northcoders.eventapp.ui.mainactivity.MainActivityViewModel;

public class EventCreateClickHandler {
    MainActivityViewModel viewModel;
    Context context;
    Event event;

    public EventCreateClickHandler(MainActivityViewModel viewModel, Context context, Event event) {
        this.viewModel = viewModel;
        this.context = context;
        this.event = event;
    }

    public static <T> void observeOnce(LiveData<T> liveData, LifecycleOwner owner, Observer<T> observer) {
        liveData.observe(owner, new Observer<T>() {
            @Override
            public void onChanged(T t) {
                liveData.removeObserver(this);
                observer.onChanged(t);
            }
        });
    }


    public void createEvent(View view){
        if(event.getName() == null || event.getDate() == null || event.getDescription() == null || event.getLocation() == null || event.getTime() == null){
            Toast.makeText(context,"Form Incomplete, Try Again", Toast.LENGTH_SHORT);
            return;
        }

        observeOnce(viewModel.getStaffData(), (LifecycleOwner)  context, staff -> {
            if (staff != null) {
                event.setStaff(staff);
                viewModel.getCreateEvent(event);
                Intent intent = new Intent(context, HomepageActivity.class);
                context.startActivity(intent);
            } else {
                Toast.makeText(context,"Staff Null",Toast.LENGTH_SHORT).show();
            }
        });

    }


}
