package com.northcoders.eventapp.ui.create;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;

import com.northcoders.eventapp.R;
import com.northcoders.eventapp.databinding.ActivityEventCreateBinding;
import com.northcoders.eventapp.model.Event;
import com.northcoders.eventapp.ui.mainactivity.MainActivityViewModel;

public class EventCreateActivity extends AppCompatActivity implements LifecycleOwner {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_event_create);
        Event event = new Event();
        MainActivityViewModel viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        EventCreateClickHandler clickHandler = new EventCreateClickHandler(viewModel,this,event);
        ActivityEventCreateBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_event_create);
        binding.setClickHandler(clickHandler);
        binding.setEvent(event);
    }
}